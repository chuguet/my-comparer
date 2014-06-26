/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.longTerm;

import com.comparadorad.bet.comparer.model.config.bean.LongTerm;

/**
 * The Class AbstractLongTermResolver.
 */
public abstract class AbstractLongTermResolver implements ILongTermResolver {

	/**
	 * Resolve.
	 * 
	 * @param pLongTerm
	 *            the long term
	 * @return the long term {@inheritDoc}
	 */

	@Override
	public LongTerm resolveLongTerm(boolean pLongTerm) {
		LongTerm result;
		result = resolver(pLongTerm);
		return result;
	}

	/**
	 * Resolver.
	 * 
	 * @param pLongTerm
	 *            the long term
	 * @return the long term
	 */
	protected abstract LongTerm resolver(boolean pLongTerm);

}
