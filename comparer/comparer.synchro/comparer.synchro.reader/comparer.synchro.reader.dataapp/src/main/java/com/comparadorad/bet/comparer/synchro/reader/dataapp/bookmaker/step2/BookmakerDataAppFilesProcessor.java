/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.service.ICfgMasterService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerMasterWordsService;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerService;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.CfgCompetitionCreator;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.CfgCreatorData;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.CfgParticipantCreator;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;

// TODO: Auto-generated Javadoc
/**
 * The Class BookmakerFilesProcessor.
 */
@Service
public final class BookmakerDataAppFilesProcessor extends AbstractBookmakerDataAppProcess implements
		ItemProcessor<CfgBookmaker, StepProcessData<CfgCreatorDataProcess>> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(BookmakerDataAppFilesProcessor.class);

	/** The competition creator. */
	@Inject
	private CfgCompetitionCreator competitionCreator;


	/** The team creator. */
	@Inject
	private CfgParticipantCreator participantCreator;

	/** The master service. */
	@Inject
	private ICfgMasterService masterService;

	/**
	 * Instantiates a new factory processor.
	 */
	private BookmakerDataAppFilesProcessor() {
		super();
	}

	/** The log event bookmaker service. */
	@Inject
	private ILogEventBookmakerMasterWordsService logEventBookmakerMasterWordService;

	/** The master list. */
	private List<CfgMaster> masterList;

	/**
	 * Process.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the object
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public StepProcessData<CfgCreatorDataProcess> process(CfgBookmaker bookmaker) throws Exception {

		if (LOG.isDebugEnabled()) {
			LOG.debug("Inicio generación de nombres");
			LOG.debug("Buscamos en la tabla de errores los elementos a dar de alta");
		}
		List<LogEventBookmakerMasterWords> logEventBookmakers = logEventBookmakerMasterWordService.customFindBySta(LogState.NEW);

		
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Recogemos los datos de configuración");
		}
		if (masterList == null) {
			masterList = (List<CfgMaster>) masterService.findAll();
			competitionCreator.setMasterList(masterList);
			participantCreator.setMasterList(masterList);
		}

		StepProcessData<CfgCreatorDataProcess> stepProcessData = new StepProcessData<CfgCreatorDataProcess>(bookmaker,
				new CfgCreatorDataProcess());
		for (LogEventBookmakerMasterWords logEventBookmaker : logEventBookmakers) {
			CfgCreatorData creatorData = null;

			AbstractXmlData data = logEventBookmaker.getData();
			CfgBookmaker dataBookmaker = logEventBookmaker.getBookmaker();
			if (data instanceof XmlTournament) {
				LOG.debug("El elemento " + data.getName() + " es una competicion");
				LOG.debug("Comprobamos si ha pasado el tiempo necesario para tratar la competicion");
				CfgMaster master = competitionCreator.getMaster();
				Date dateDB = new Date(logEventBookmaker.getErrorDate().getTime() + master.getTimeToProcess());
				Date now = new Date();

				if (dateDB.before(now)) {
					LOG.debug("Ha pasado el tiempo configurado procedemos a procesar la competicion");
					if (data.getName() != null && !data.getName().equals("")) {
						creatorData = competitionCreator.create((XmlTournament) data, dataBookmaker, logEventBookmaker);
						stepProcessData.getData().addCompetitionCreatorData(
								(CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms>) creatorData);
					}
				}
			} else if (data instanceof XmlMatchParticipant) {
				LOG.debug("El elemento " + data.getName() + " es un participante");
				
				LOG.debug("Comprueba si el participante ya habia sido dado de alta");
				Boolean participanteExistente = logEventBookmakerMasterWordService.checkParticipantExistence((XmlMatchParticipant)data);
				
				if (!participanteExistente)
				{
					if (data.getName() != null && !data.getName().equals("")) {
						creatorData = participantCreator.create((XmlMatchParticipant) data, dataBookmaker, logEventBookmaker);
						stepProcessData.getData().addMatchParticipantCreatorData(creatorData);
					}
				} else {
					LOG.warn("El participante ya se habia dado de alta por lo que no lo procesamos y lo eliminamos para no volver a tratarlo");
					logEventBookmakerMasterWordService.delete(logEventBookmaker);
				}
			}

			if (creatorData != null && !creatorData.getLogEventBookmakerMasterWords().getLogState().equals(LogState.DATA_ERROR)) {
				creatorData.setLogEventBookmakerMasterWords(logEventBookmaker);
			}
		}
		LOG.info(getStepMessageChain(bookmaker) + "PROCESSING: " + bookmaker.getName(Locale.ENGLISH));

		return stepProcessData;
	}
}
