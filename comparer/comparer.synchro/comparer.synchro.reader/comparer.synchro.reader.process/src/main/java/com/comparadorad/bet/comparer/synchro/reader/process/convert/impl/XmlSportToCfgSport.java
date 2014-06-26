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
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleSportException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.SportInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.SportNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.synonyms.ISynonymsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlTournamentToCfgCompetition.
 */
@Component
public class XmlSportToCfgSport extends AbstractCustomConvertProcess implements
		CustomConvertProcess {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlSportToCfgSport.class);

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
		CfgSport result = null;
		if (sourceObject instanceof XmlSport) {
			XmlSport xmlSport = (XmlSport) sourceObject;
			try {
				if (xmlSport.getName() != null) {
					result = synonymsComponent.findByNameSport(xmlSport
							.getName());
					if (result != null) {
						xmlSport.setCfgObjectId(result.getObjectId());
						if (result.getCoreActiveElement() != null
								&& !result.getCoreActiveElement().isActive(
										new Date())) {
							throw new SportInactiveException(new StringBuffer()
									.append("El deporte ")
									.append(result.getName(null))
									.append(" esta desactivado.").toString());
						}
					}
				}
			} catch (SportNotFoundException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport,
						getCfgBookmaker());
				// Miramos a ver si el este mismo error ya estaba tratado si no
				// existe lo agregamos sino no hacemos nada
				LOG.info("Comprobamos si habia ocurrido previamente el error");
				String message = "Not found the sport: " + xmlSport.getName();
				if (!repository.existsPreviousError(message, state)) {
					LOG.info("No habia ocurrido el error previamente con lo que damos de alta el sport:"
							+ xmlSport.getName());
					getSynchroErrorEvent().errorMasterWordsLog(e.getMessage(),
							e, xmlSport, getCfgBookmaker());
				}
				throw new ConvertException(e);
			} catch (MultipleSportException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport,
						getCfgBookmaker());
				throw new ConvertException(e);
			} catch (SportInactiveException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlSport,
						getCfgBookmaker());
				throw new ConvertException(e);
			}
		} else {
			LOG.error("No se podido asignar los valores del deporte");
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
		return "xmlSportToCfgSport";
	}

}
