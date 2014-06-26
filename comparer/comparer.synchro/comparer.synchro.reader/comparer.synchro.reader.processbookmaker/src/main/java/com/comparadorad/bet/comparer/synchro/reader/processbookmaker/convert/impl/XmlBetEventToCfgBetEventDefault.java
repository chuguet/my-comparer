/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlBetEventToCfgBetEventDefault.
 */
@Component
public class XmlBetEventToCfgBetEventDefault implements IXmlBetEventToCfgBetEvent {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

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
	 * @param bookmaker
	 *            the bookmaker
	 * @param synchroErrorEvent
	 *            the synchro error event
	 * @param xmlToResolverData
	 *            the xml to resolver data
	 * @return the object {@inheritDoc}
	 */
	@Override
	public Object convert(Object targetObject, Object sourceObject, Class<?> pArg2, Class<?> pArg3, CfgBookmaker bookmaker,
			ISynchroErrorEvent synchroErrorEvent, XmlToRtResolverData xmlToResolverData) {
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		CfgBetTypeEvent result = new CfgBetTypeEvent();
		LOG.debug(Thread.currentThread(), "Convertimos el evento de apuesta");
		if (sourceObject instanceof XmlBetType) {
			XmlBetType xmlBetType = (XmlBetType) sourceObject;
			if (xmlBetType.getXmlBetEvent() != null && xmlBetType.getXmlBetEvent().getBetEvent() != null) {
				IBetEvent betEventName = xmlBetType.getXmlBetEvent().getBetEvent();
				String event = betEventName.getEvents()[0];
				if (event.equals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId())) {
					result.setNameId(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId());
					result.setObjectId(CfgBetTypeEventId.PARTIDO_COMPLETO.objectId());
				} else if (event.equals(CfgBetTypeEventId.PRIMERA_PARTE.nameId())) {
					result.setNameId(CfgBetTypeEventId.PRIMERA_PARTE.nameId());
					result.setObjectId(CfgBetTypeEventId.PRIMERA_PARTE.objectId());
				} else if (event.equals(CfgBetTypeEventId.QUINCE_MINUTOS.nameId())) {
					result.setNameId(CfgBetTypeEventId.QUINCE_MINUTOS.nameId());
					result.setObjectId(CfgBetTypeEventId.QUINCE_MINUTOS.objectId());
				} else if (event.equals(CfgBetTypeEventId.SEGUNDA_PARTE.nameId())) {
					result.setNameId(CfgBetTypeEventId.SEGUNDA_PARTE.nameId());
					result.setObjectId(CfgBetTypeEventId.SEGUNDA_PARTE.objectId());
				} else if (event.equals(CfgBetTypeEventId.SETENTA_MINUTOS.nameId())) {
					result.setNameId(CfgBetTypeEventId.SETENTA_MINUTOS.nameId());
					result.setObjectId(CfgBetTypeEventId.SETENTA_MINUTOS.objectId());
				} else if (event.equals(CfgBetTypeEventId.PRIMER_SET.nameId())) {
					result.setNameId(CfgBetTypeEventId.PRIMER_SET.nameId());
					result.setObjectId(CfgBetTypeEventId.PRIMER_SET.objectId());
				} else if (event.equals(CfgBetTypeEventId.TREINTA_MINUTOS.nameId())) {
					result.setNameId(CfgBetTypeEventId.TREINTA_MINUTOS.nameId());
					result.setObjectId(CfgBetTypeEventId.TREINTA_MINUTOS.objectId());
				} else if (event.equals(CfgBetTypeEventId.SEGUNDO_SET.nameId())) {
					result.setNameId(CfgBetTypeEventId.SEGUNDO_SET.nameId());
					result.setObjectId(CfgBetTypeEventId.SEGUNDO_SET.objectId());
				} else if (event.equals(CfgBetTypeEventId.TERCER_SET.nameId())) {
					result.setNameId(CfgBetTypeEventId.TERCER_SET.nameId());
					result.setObjectId(CfgBetTypeEventId.TERCER_SET.objectId());
				} else if (event.equals(CfgBetTypeEventId.CUARTO_SET.nameId())) {
					result.setNameId(CfgBetTypeEventId.CUARTO_SET.nameId());
					result.setObjectId(CfgBetTypeEventId.CUARTO_SET.objectId());
				} else if (event.equals(CfgBetTypeEventId.QUINTO_SET.nameId())) {
					result.setNameId(CfgBetTypeEventId.QUINTO_SET.nameId());
					result.setObjectId(CfgBetTypeEventId.QUINTO_SET.objectId());
				} else if (event.equals(CfgBetTypeEventId.PRIMER_CUARTO.nameId())) {
					result.setNameId(CfgBetTypeEventId.PRIMER_CUARTO.nameId());
					result.setObjectId(CfgBetTypeEventId.PRIMER_CUARTO.objectId());
				} else if (event.equals(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId())) {
					result.setNameId(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId());
					result.setObjectId(CfgBetTypeEventId.SEGUNDO_CUARTO.objectId());
				} else if (event.equals(CfgBetTypeEventId.TERCER_CUARTO.nameId())) {
					result.setNameId(CfgBetTypeEventId.TERCER_CUARTO.nameId());
					result.setObjectId(CfgBetTypeEventId.TERCER_CUARTO.objectId());
				} else if (event.equals(CfgBetTypeEventId.CUARTO_CUARTO.nameId())) {
					result.setNameId(CfgBetTypeEventId.CUARTO_CUARTO.nameId());
					result.setObjectId(CfgBetTypeEventId.CUARTO_CUARTO.objectId());
				} else if (event.equals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId())) {
					result.setNameId(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId());
					result.setObjectId(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId());
				} else if (event.equals(CfgBetTypeEventId.PRIMERA_ENTRADA.nameId())) {
					result.setNameId(CfgBetTypeEventId.PRIMERA_ENTRADA.nameId());
					result.setObjectId(CfgBetTypeEventId.PRIMERA_ENTRADA.objectId());
				} else if (event.equals(CfgBetTypeEventId.CINCO_PRIMERAS_ENTRADAS.nameId())) {
					result.setNameId(CfgBetTypeEventId.CINCO_PRIMERAS_ENTRADAS.nameId());
					result.setObjectId(CfgBetTypeEventId.CINCO_PRIMERAS_ENTRADAS.objectId());
				} else if (event.equals(CfgBetTypeEventId.TERCERA_PARTE.nameId())) {
					result.setNameId(CfgBetTypeEventId.TERCERA_PARTE.nameId());
					result.setObjectId(CfgBetTypeEventId.TERCERA_PARTE.objectId());
				} else {
					result.setNameId(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId());
					result.setObjectId(CfgBetTypeEventId.PARTIDO_COMPLETO.objectId());
				}
			} else {
				result.setNameId(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId());
				result.setObjectId(CfgBetTypeEventId.PARTIDO_COMPLETO.objectId());
			}

		}
		LOG.debug(Thread.currentThread(), new StringBuffer("El evento de apuesta obtenido es: ").append(result.getNameId()).toString());
		rtBetTypeEvent.setBetTypeEvent(result);
		return rtBetTypeEvent;
	}
}
