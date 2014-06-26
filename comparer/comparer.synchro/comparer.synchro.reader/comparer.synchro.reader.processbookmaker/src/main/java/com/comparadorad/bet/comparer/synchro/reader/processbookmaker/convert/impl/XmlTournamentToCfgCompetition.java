/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerMasterWordsRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.CompetitionInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleTournamentException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.TournamentNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.XmlTournamentNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.synonyms.ISynonymsComponent;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlTournamentToCfgCompetition.
 */
@Component
public class XmlTournamentToCfgCompetition extends AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The synonyms component. */
	@Inject
	private ISynonymsComponent synonymsComponent;

	/** The repository. */
	@Inject
	private LogEventBookmakerMasterWordsRepository repository;

	/** The state. */
	private static String[] state = { "NEW" };

	/**
	 * Convert.
	 * 
	 * @param targetObject
	 *            the target object
	 * @param sourceObject
	 *            the source object
	 * @param pArg2
	 *            the arg2
	 * @param pArg3
	 *            the arg3
	 * @return the object {@inheritDoc}
	 */
	@Override
	public Object convert(Object targetObject, Object sourceObject, Class<?> pArg2, Class<?> pArg3) {
		CfgCompetition result = null;
		if (sourceObject instanceof XmlTournament) {
			XmlTournament xmlTournament = (XmlTournament) sourceObject;
			try {
				if (xmlTournament.getName() != null && xmlTournament.getXmlSport().getCfgObjectId() != null) {
					LOG.debug(Thread.currentThread(), new StringBuffer().append("Inicio de la conversion de la competicion: ").append(xmlTournament.getName())
								.append(" con el deporte ").append(xmlTournament.getXmlSport().getName()).toString());
					result = synonymsComponent.findByCompetitionNameAndSport(xmlTournament.getName().trim(), xmlTournament.getXmlSport()
							.getCfgObjectId());
					if (result != null) {
						xmlTournament.setCfgObjectId(result.getObjectId());
						result.setCfgName(result.getName(null));
						if (result.getCoreActiveElement() != null && !result.getCoreActiveElement().isActive(new Date())) {
							throw new CompetitionInactiveException(new StringBuffer().append("La competicion ")
									.append(result.getName(null)).append(" esta desactivada.").toString());
						}
					}
				} else {
					LOG.debug(Thread.currentThread(), "No se podido asignar los valores de la competicion");
					throw new XmlTournamentNotFoundException("La competicion no tiene un nombre asociado");
				}
			} catch (TournamentNotFoundException e) {
				LOG_DATA_NO_PROCESSED.info("Competicion no encontrada: " + xmlTournament.getName());
				generateMasterWordError(xmlTournament, e);
				throw new ConvertException(e);
			} catch (MultipleTournamentException e) {
				LOG_DATA_NO_PROCESSED.info("Competicion duplicada en DB: " + xmlTournament.getName());
				LOG.error(Thread.currentThread(), "Multiple competicion encontrada en BD. Hay mas de una competicion con el nombre " + result.getName(null), e);
				throw new ConvertException(e);
			} catch (CompetitionInactiveException e) {
				LOG_DATA_NO_PROCESSED.info("Competicion inactiva en DB: " + xmlTournament.getName());
				LOG.warn(Thread.currentThread(), e.getMessage(), e);
				throw new ConvertException(e);
			} catch (CompetitionNotVerifiedException e) {
				LOG_DATA_NO_PROCESSED.info("Competicion no verificada en DB: " + xmlTournament.getName());
				LOG.error(Thread.currentThread(), e.getMessage(), e);
				throw new ConvertException(e);
			}
		} else {
			LOG.debug(Thread.currentThread(), "No se podido asignar los valores de la competicion");
			throw new XmlTournamentNotFoundException("No se ha encontrado la competicion dentro del XmlMatch");
		}
		return result;
	}

	/**
	 * Generate master word error.
	 * 
	 * @param xmlTournament
	 *            the xml tournament
	 * @param e
	 *            the e
	 */
	private void generateMasterWordError(XmlTournament xmlTournament, TournamentNotFoundException e) {
		LOG.debug(Thread.currentThread(), new StringBuffer().append("No se ha encontrado la competicion: ").append(xmlTournament.getName())
				.append(" para el deporte ").append(xmlTournament.getXmlSport().getName()).toString());
		// Miramos a ver si el este mismo error ya estaba tratado si no
		// existe lo agregamos sino no hacemos nada
		LOG.debug(Thread.currentThread(), "Comprobamos si habia ocurrido previamente el error");
		String message = new StringBuffer().append("Not found the competition: ").append(xmlTournament.getName().trim()).toString();
		LogEventBookmakerMasterWords eventDb = repository.existsPreviousCompetitionError(message, state);

		if (eventDb != null) {
			LOG.debug(Thread.currentThread(), "Ya existia la competicion en la tabla del generador, le añadimos los nuevos participantes");
			XmlTournament dbTournament = (XmlTournament) eventDb.getData();
			if (!dbTournament.getParticipantNames().equals(xmlTournament.getParticipantNames())) {
				for (String participant : xmlTournament.getParticipantNames()) {
					dbTournament.getParticipantNames().add(participant);
				}
				eventDb.setData(dbTournament);
				repository.updateEventCompetition(eventDb);
			}
		} else {
			LOG.debug(Thread.currentThread(), "No habia ocurrido el error previamente con lo que damos de alta la competicion:" + xmlTournament.getName());
			if (xmlTournament.getXmlSport() != null && xmlTournament.getXmlSport().getCfgObjectId() != null) {
				LOG.debug(Thread.currentThread(), new StringBuffer().append("Insertamos la competicion para que la procese el generador de nombres").toString());
				getSynchroErrorEvent().errorMasterWordsLog(e.getMessage(), e, xmlTournament, getCfgBookmaker(), new Date());
			} else {
				LOG.debug(Thread.currentThread(), "El partido no se ha podido insertar en la tabla del generador al no disponer de id de deporte necesario");
			}

		}

	}

	/**
	 * Gets the name.
	 * 
	 * @return the name {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "xmlTournamentToCfgCompetition";
	}

}
