/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.logger.core;

import org.apache.log4j.Level;
import org.springframework.stereotype.Component;

/**
 * The Class ComparerWrapperLogImpl.
 */
@Component
class ComparerWrapperLogImpl extends AbstractComparerWrapperLog {

	/** {@inheritDoc} */
	@Override
	public void debug(Thread thread, String message) {
		if (logger.isDebugEnabled()) {
			message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.DEBUG);
			message = message.replaceAll("\\n", "");
			logger.debug(message);
		}

	}

	/** {@inheritDoc} */
	@Override
	public void info(Thread thread, String message) {
		if (logger.isInfoEnabled()) {
			message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.INFO);
			logger.info(message);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void warn(Thread thread, String message, Exception exception) {
		message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.WARN);
		logger.warn(message, exception);

	}

	/** {@inheritDoc} */
	@Override
	public void error(Thread thread, String message, Exception exception) {
		message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.ERROR);
		logger.error(new StringBuffer(message).append(exception), exception);

	}

	/** {@inheritDoc} */
	@Override
	public void fatal(Thread thread, String message, Exception exception) {
		message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.FATAL);
		logger.fatal(message, exception);
	}

	@Override
	public void warn(Thread thread, String message) {
		message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.WARN);
		logger.warn(message);
	}

	@Override
	public void error(Thread thread, String message) {
		message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.ERROR);
		logger.error(message);
	}

	@Override
	public void fatal(Thread thread, String message) {
		message = getLogInfoParameters(thread, message, System.currentTimeMillis(), Level.FATAL);
		logger.fatal(message);
	}

}
