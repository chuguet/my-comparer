/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.longTerm;

import com.comparadorad.bet.comparer.model.config.bean.LongTerm;

public interface ILongTermResolver {
	
	/**
	 * Resolve.
	 *
	 * @param longTerm the long term
	 * @return the long term
	 */
	public abstract LongTerm resolveLongTerm(boolean longTerm);

}
