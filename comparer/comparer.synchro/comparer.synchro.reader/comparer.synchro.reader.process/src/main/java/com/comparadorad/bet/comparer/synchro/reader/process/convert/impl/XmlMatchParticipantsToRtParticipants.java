/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
public class XmlMatchParticipantsToRtParticipants extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlMatchParticipantsToRtParticipants.class);

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
	 * @return the object
	 * @throws ConvertException
	 *             the convert exception {@inheritDoc}
	 */
	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) throws ConvertException {
		Set<RtParticipant> result = new HashSet<RtParticipant>();
		if (sourceObject instanceof Collection<?>) {
			Collection<?> list = (Collection<?>) sourceObject;
			XmlMatchParticipant xmlMatchParticipant;
			RtParticipant rtParticipant;
			for (Object object : list) {
				if (object instanceof XmlMatchParticipant) {
					xmlMatchParticipant = (XmlMatchParticipant) object;
					rtParticipant = new RtParticipant();
					if (xmlMatchParticipant.getName() != null) {
						try {
							CfgParticipant participante = new CfgParticipant();
							participante = synonymsComponent
									.resolverParticipantes(xmlMatchParticipant);
							rtParticipant.setCfgParticipant(participante);
							if (participante.getCoreActiveElement() != null
									&& !participante.getCoreActiveElement()
											.isActive(new Date())) {
								throw new ParticipantInactiveException(
										new StringBuffer()
												.append("El participante ")
												.append(participante
														.getName(null))
												.append(" esta desactivado.")
												.toString());
							}
						} catch (TeamNotFoundException e) {
							getSynchroErrorEvent().errorLog(e.getMessage(), e,
									xmlMatchParticipant, getCfgBookmaker());
							// Miramos a ver si el este mismo error ya estaba
							// tratado si no
							// existe lo agregamos sino no hacemos nada
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
							getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlMatchParticipant,
									getCfgBookmaker());
							throw new ConvertException(e);
						}
					}
					rtParticipant.setAwayParticipant(xmlMatchParticipant
							.isAwayParticipant());
					rtParticipant.setHomeParticipant(xmlMatchParticipant
							.isHomeParticipant());
					result.add(rtParticipant);
				} else {
					LOG.error("No se podido asignar los valores del participante");
				}
			}
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
		return "XmlMatchParticipantsToRtParticipants";
	}

}
