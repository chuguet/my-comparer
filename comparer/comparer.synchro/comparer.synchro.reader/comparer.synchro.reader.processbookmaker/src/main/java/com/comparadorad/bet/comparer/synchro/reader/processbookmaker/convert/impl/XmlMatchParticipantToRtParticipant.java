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
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleParticipantException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ParticipantInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ParticipantNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.synonyms.ISynonymsComponent;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlMatchParticipantToRtParticipant.
 */
@Component
public class XmlMatchParticipantToRtParticipant extends AbstractCustomConvertProcess implements CustomConvertProcess {

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
	private static String state[] = { "NEW" };

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
		RtParticipant result = new RtParticipant();
		XmlMatchParticipant xmlMatchParticipant;
		if (sourceObject instanceof XmlMatchParticipant) {
			xmlMatchParticipant = (XmlMatchParticipant) sourceObject;
			if (xmlMatchParticipant.getName() != null && !xmlMatchParticipant.getName().equals("")) {
				try {
					CfgParticipant participante = new CfgParticipant();
					participante = synonymsComponent.resolverParticipantes(xmlMatchParticipant);
					participante.setCfgName(participante.getName(null));
					result.setCfgParticipant(participante);
					if (participante.getCoreActiveElement() != null && !participante.getCoreActiveElement().isActive(new Date())) {
						throw new ParticipantInactiveException(new StringBuffer().append("El participante ")
								.append(participante.getName(null)).append(" esta desactivado.").toString());
					}
				} catch (ParticipantNotFoundException e) {
					LOG.info(Thread.currentThread(), "Comprobamos si habia ocurrido previamente el error");
					String message = "Not found the participant: " + xmlMatchParticipant.getName().trim();
					boolean existeParticipante = repository.existsPreviousParticipantError(message, state, xmlMatchParticipant
							.getXmlTournament().getCfgObjectId());
					LOG_DATA_NO_PROCESSED.info(message);
					if (!existeParticipante) {
						LOG.info(Thread.currentThread(), "No habia ocurrido el error previamente con lo que damos de alta el participante:"
								+ xmlMatchParticipant.getName());
						getSynchroErrorEvent().errorMasterWordsLog(e.getMessage(), e, xmlMatchParticipant, getCfgBookmaker(), new Date());
					}

					throw new ConvertException(e);
				} catch (MultipleParticipantException e) {
					getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlMatchParticipant, getCfgBookmaker(), new Date());
					LOG.error(Thread.currentThread(), "Error en la base de datos. Hay varios participantes con el mismo nombre", e);
					LOG_DATA_NO_PROCESSED.info("Error en BD. Hay varios participantes con el mismo nombre " + xmlMatchParticipant.getName().trim());
					throw new ConvertException(e);
				} catch (ParticipantInactiveException e) {
					getSynchroErrorEvent().errorLog(e.getMessage(), e, xmlMatchParticipant, getCfgBookmaker(), new Date());
					LOG.error(Thread.currentThread(), "El participante esta desactivado", e);
					LOG_DATA_NO_PROCESSED.info("El participante esta desactivado " + xmlMatchParticipant.getName());
					throw new ConvertException(e);
				}
				result.setAwayParticipant(xmlMatchParticipant.isAwayParticipant());
				result.setHomeParticipant(xmlMatchParticipant.isHomeParticipant());
			}
		} else {
			LOG.debug(Thread.currentThread(), "No se podido asignar los valores del participante");
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
