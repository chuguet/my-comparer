/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.logger.readerdatanoprocessed;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * The Class logger.
 */
@Component
class LogReaderDataNoProcessedImpl implements LogReaderDataNoProcessed {

	/** The logger. */
	private Logger logger = Logger.getLogger("ReaderDataNoProcessed");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.logger.readerdatanoprocessed.
	 * LogReaderDataNoProcessed#info(java.lang.String)
	 */
	@Override
	public void info(String msg) {
		logger.info(msg);
	}

}
