/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;

/**
 * The Class AbstractBookmakerProcess.
 */
public abstract class AbstractBookmakerDataAppProcess extends
		AbstractBookmakerProcess {

	/** The Constant PROCESS_LOG_INIT_STRING. */
	private static final String PROCESS_LOG_INIT_STRING = "[READER_DATA_APP] ";

	/** {@inheritDoc} */
	@Override
	protected String getLogInitString() {
		return PROCESS_LOG_INIT_STRING;
	}
}
