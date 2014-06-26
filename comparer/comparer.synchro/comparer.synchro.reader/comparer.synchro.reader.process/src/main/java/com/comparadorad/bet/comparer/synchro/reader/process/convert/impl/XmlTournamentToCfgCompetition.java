/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerMasterWordsRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.CompetitionInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleTournamentException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.TournamentNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.synonyms.ISynonymsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlTournamentToCfgCompetition.
 */
@Component
public class XmlTournamentToCfgCompetition extends AbstractCustomConvertProcess
		implements CustomConvertProcess {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlTournamentToCfgCompetition.class);

	/** The synonyms component. */
	@Inject
	private ISynonymsComponent synonymsComponent;

	/** The repository. */
	@Inject
	private LogEventBookmakerMasterWordsRepository repository;

	/** The state. */
	private static String state = "NEW";

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
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) {
		CfgCompetition result = null;
		CfgSport sport = null;
		if (sourceObject instanceof XmlTournament) {
			XmlTournament xmlTournament = (XmlTournament) sourceObject;
			try {
				if (xmlTournament.getName() != null) {
					result = synonymsComponent
							.findByNameCompetition(xmlTournament.getName());
					if (result != null) {
						xmlTournament.setCfgObjectId(result.getObjectId());
						result.setSport(sport);
						if (result.getCoreActiveElement() != null
								&& !result.getCoreActiveElement().isActive(
										new Date())) {
							throw new CompetitionInactiveException(
									new StringBuffer()
											.append("La competicion ")
											.append(result.getName(null))
											.append(" esta desactivada.")
											.toString());
						}
					}
				}
			} catch (TournamentNotFoundException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e,
						xmlTournament, getCfgBookmaker());
				// Miramos a ver si el este mismo error ya estaba tratado si no
				// existe lo agregamos sino no hacemos nada
				LOG.info("Comprobamos si habia ocurrido previamente el error");
				String message = "Not found the tournament: "
						+ xmlTournament.getName();
				if (!repository.existsPreviousError(message, state)) {
					LOG.info("No habia ocurrido el error previamente con lo que damos de alta el tournament:"
							+ xmlTournament.getName());
					getSynchroErrorEvent().errorMasterWordsLog(e.getMessage(),
							e, xmlTournament, getCfgBookmaker());
				}
				throw new ConvertException(e);
			} catch (MultipleTournamentException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e,
						xmlTournament, getCfgBookmaker());
				throw new ConvertException(e);
			} catch (CompetitionInactiveException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlTournament,
						getCfgBookmaker());
				throw new ConvertException(e);
			}
		} else {
			LOG.error("No se podido asignar los valores de la competicion");
		}
			
		return result;
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
