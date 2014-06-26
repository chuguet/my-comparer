/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Interface IXmlBetEventToCfgBetEvent.
 */
public interface IXmlBetEventToCfgBetEvent {

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
	 * @return the object
	 */
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3, CfgBookmaker bookmaker,
			ISynchroErrorEvent synchroErrorEvent,
			XmlToRtResolverData xmlToResolverData);
}
