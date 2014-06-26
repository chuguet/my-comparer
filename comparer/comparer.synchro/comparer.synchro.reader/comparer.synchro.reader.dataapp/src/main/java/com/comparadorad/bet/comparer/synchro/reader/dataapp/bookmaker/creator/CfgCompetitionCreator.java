/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord.CfgSynonymWordHistoricData;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgHistoricUser;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.CfgMasterId;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ISynonymsService;
import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerMasterWordsService;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.exception.CfgFromXmlCreatorException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;

/**
 * The Class CfgCompetitionCreator.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CfgCompetitionCreator extends AbstractCfgCreator<CfgCompetition, CfgCompetitionSynonyms> implements
		ICfgFromXmlCreator<XmlTournament, CfgCompetition, CfgCompetitionSynonyms> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CfgCompetitionCreator.class);

	/** The competition service. */
	@Inject
	private ICfgCompetitionService competitionService;

	/** The competition synonyms service. */
	@Inject
	private ICfgCompetitionSynonymsService competitionSynonymsService;

	/** The log event bookmaker service. */
	@Inject
	private ILogEventBookmakerMasterWordsService logEventBookmakerMasterWordsService;

	/**
	 * Creates the.
	 * 
	 * @param xmlTournament
	 *            the xml tournament
	 * @param dataBookmaker
	 *            the data bookmaker
	 * @param logEventBookmaker
	 *            the log event bookmaker
	 * @return the cfg creator data
	 * @throws CfgFromXmlCreatorException
	 *             the cfg from xml creator exception {@inheritDoc}
	 */
	public CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms> create(XmlTournament xmlTournament, CfgBookmaker dataBookmaker,
			LogEventBookmakerMasterWords logEventBookmaker) throws CfgFromXmlCreatorException {
		CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms> creatorData = new CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms>();

		creatorData.setLogEventBookmakerMasterWords(logEventBookmaker);
		if (xmlTournament.getXmlSport() == null || xmlTournament.getXmlSport().getCfgObjectId() == null) {
			LOG.error("La competicion no tiene un id de deporte correcto por lo que se marca como incorrecta");
			creatorData.setLogEventBookmakerMasterWords(logEventBookmaker);
			creatorData.getLogEventBookmakerMasterWords().setLogState(LogState.DATA_ERROR);
			logEventBookmakerMasterWordsService.save(creatorData.getLogEventBookmakerMasterWords());
			throw new CfgFromXmlCreatorException("The sport or the sport id is null");
		}

		CfgCompetitionSynonyms synonymsDb = getSynonyms(xmlTournament, dataBookmaker);
		if (synonymsDb != null) {
			LOG.debug("Hemos encontrado sinonimos con lo que solo damos de alta estos");
			creatorData.setSynonyms(synonymsDb);
			creatorData.setModelData(synonymsDb.getRelatedDocument());
			if (creatorData.getModelData().getRegion() == null) {
				CfgRegion region = new CfgRegion(new BigInteger("1"));
				region.setName("Otros");
				creatorData.getModelData().setRegion(region);
			}
			Object result = getCrudService().findOne(creatorData.getModelData().getObjectId());
			if (result != null) {
				creatorData.getModelData().getObjectState().setObjectState(ObjectStateEnum.NOT_MODIFIED);
			}

		} else {
			try {
				LOG.debug("No se ha encontrado ningun sinonimo con lo que damos de alta tanto el deporte como el sinonimo");
				CfgSport sport = new CfgSport();
				sport.setObjectId(xmlTournament.getXmlSport().getCfgObjectId());
				sport.setName(xmlTournament.getXmlSport().getName().trim());
				CfgCompetition competition = new CfgCompetition();
				if (xmlTournament.getRegion() != null && xmlTournament.getRegion().getCfgObjectId() != null) {
					LOG.debug(new StringBuffer().append("La competición tiene como región ").append(xmlTournament.getRegion().getName())
							.append(" por lo que se la asociamos a la nueva competicion").toString());
					competition.setRegion(new CfgRegion(xmlTournament.getRegion().getCfgObjectId()));
					competition.getRegion().setName(xmlTournament.getRegion().getName().trim());
				} else {
					LOG.debug("La competición no tiene region asociada por lo que la asociamos OTROS como region por defecto");
					competition.setRegion(new CfgRegion(new BigInteger("1")));
					competition.getRegion().setName("Otros");
				}
				setNewObjectId(competition);
				LOG.debug(new StringBuffer().append("Se da de alta una nueva competicion con nombre ")
						.append(xmlTournament.getName().trim()).append(" con un deporte asociado ")
						.append(xmlTournament.getXmlSport().getName().trim()).toString());
				competition.setName(xmlTournament.getName().trim());
				competition.setCfgName(xmlTournament.getName().trim());
				competition.setSport(sport);
				competition.setParticipantNames(xmlTournament.getParticipantNames());
				creatorData.setModelData(competition);

				CfgCompetitionSynonyms synonyms = new CfgCompetitionSynonyms();
				CfgSynonymWordHistoricData historicData = new CfgSynonymWordHistoricData();

				synonyms.setObjectId(getNewObjectDictionaryId(competition.getObjectId()));
				LOG.debug(new StringBuffer().append("Añadimos nuevo sinonimo para la competicion recien creada, con nombre ")
						.append(xmlTournament.getName().trim()).append(" y con estado ").append(CfgHistoricUser.NOT_VERIFIED.nameId())
						.toString());
				synonyms.addSynonimWord(xmlTournament.getName().trim(), dataBookmaker, CfgHistoricUser.NOT_VERIFIED.nameId(), historicData);
				synonyms.setRelatedDocument(competition);
				creatorData.setSynonyms(synonyms);
			} catch (Exception e) {
				LOG.warn(new StringBuffer().append("Se ha producido una excepción al crear la nueva competicion con un error de tipo ")
						.append(e.getLocalizedMessage()));
				throw new CfgFromXmlCreatorException("Error al generar una nueva competicion");
			}
		}
		return creatorData;

	}

	/**
	 * Gets the cfg master id.
	 * 
	 * @return the cfg master id {@inheritDoc}
	 */
	@Override
	protected CfgMasterId getCfgMasterId() {
		return CfgMasterId.COMPETITION;
	}

	/**
	 * Gets the crud service.
	 * 
	 * @return the crud service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgCompetition> getCrudService() {
		return competitionService;
	}

	/**
	 * Gets the synonyms crud service.
	 * 
	 * @return the synonyms crud service {@inheritDoc}
	 */
	@Override
	protected ISynonymsService<CfgCompetitionSynonyms> getSynonymsCrudService() {
		return competitionSynonymsService;
	}
}
