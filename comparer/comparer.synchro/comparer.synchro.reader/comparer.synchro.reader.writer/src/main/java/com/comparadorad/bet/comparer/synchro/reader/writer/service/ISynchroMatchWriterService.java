/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Interface ISynchroMatchWriterService.
 */
public interface ISynchroMatchWriterService {

	/**
	 * Write.
	 * 
	 * @param pMatch
	 *            the match
	 */
	public abstract void write(final RtMatch pMatch);

}