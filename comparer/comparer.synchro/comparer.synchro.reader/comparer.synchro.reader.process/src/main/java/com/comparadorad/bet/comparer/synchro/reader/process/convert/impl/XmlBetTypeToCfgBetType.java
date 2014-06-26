/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.process.convert.factory.IConvertFactory;

/**
 * The Class XmlBetTypeToCfgBetType.
 */
@Component
public class XmlBetTypeToCfgBetType extends AbstractCustomConvertProcess {

	@Inject
	private IConvertFactory factory;

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
		Object customConvertProcess = null;
		customConvertProcess = factory.getBetTypeInstance(getCfgBookmaker(),
				null);
		return ((IXmlBetTypeToCfgBetType) customConvertProcess).convert(
				targetObject, sourceObject, pArg2, pArg3, getCfgBookmaker(),
				getSynchroErrorEvent(), getXmlToRtResolverData());
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "xmlBetTypeToCfgBetType";
	}

}
