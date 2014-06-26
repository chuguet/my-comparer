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
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleTeamException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.ParticipantInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.TeamNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.synonyms.ISynonymsComponent;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlMatchParticipantToRtParticipant.
 */
@Component
public class XmlMatchParticipantToRtParticipant extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlMatchParticipantToRtParticipant.class);

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
		RtParticipant result = new RtParticipant();
		XmlMatchParticipant xmlMatchParticipant;
		if (sourceObject instanceof XmlMatchParticipant) {
			xmlMatchParticipant = (XmlMatchParticipant) sourceObject;
			if (xmlMatchParticipant.getName() != null) {
				try {
					CfgParticipant participante = new CfgParticipant();
					participante = synonymsComponent
							.resolverParticipantes(xmlMatchParticipant);
					result.setCfgParticipant(participante);
					if (participante.getCoreActiveElement() != null
							&& !participante.getCoreActiveElement().isActive(
									new Date())) {
						throw new ParticipantInactiveException(
								new StringBuffer().append("El participante ")
										.append(participante.getName(null))
										.append(" esta desactivado.")
										.toString());
					}
				} catch (TeamNotFoundException e) {
					getSynchroErrorEvent().errorLog(e.getMessage(), e,
							xmlMatchParticipant, getCfgBookmaker());
					LOG.info("Comprobamos si habia ocurrido previamente el error");
					String message = "Not found the team: "
							+ xmlMatchParticipant.getName();
					if (!repository.existsPreviousError(message, state)) {
						LOG.info("No habia ocurrido el error previamente con lo que damos de alta el sport:"
								+ xmlMatchParticipant.getName());
						getSynchroErrorEvent().errorMasterWordsLog(
								e.getMessage(), e, xmlMatchParticipant,
								getCfgBookmaker());
					}

					throw new ConvertException(e);
				} catch (MultipleTeamException e) {
					getSynchroErrorEvent().errorLog(e.getMessage(), e,
							xmlMatchParticipant, getCfgBookmaker());
					throw new ConvertException(e);
				} catch (ParticipantInactiveException e) {
					getSynchroErrorEvent().errorLog(e.getMessage(), e,
							xmlMatchParticipant, getCfgBookmaker());
					throw new ConvertException(e);
				}
				result.setAwayParticipant(xmlMatchParticipant
						.isAwayParticipant());
				result.setHomeParticipant(xmlMatchParticipant
						.isHomeParticipant());
			}
		} else {
			LOG.error("No se podido asignar los valores del participante");
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
		return "xmlMatchParticipantToRtParticipant";
	}

}
