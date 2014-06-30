/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.log.core;

import org.springframework.stereotype.Component;

/**
 * The Class ComparerWrapperLogImpl.
 */
@Component
class ComparerWrapperLogImpl extends AbstractComparerWrapperLog {

	/** {@inheritDoc} */
	@Override
	public void debug(Thread thread, String message) {
		message = getLogInfoParameters(thread, message);
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}

	}

	/** {@inheritDoc} */
	@Override
	public void info(Thread thread, String message) {
		message = getLogInfoParameters(thread, message);
		logger.info(message);
	}

	/** {@inheritDoc} */
	@Override
	public void warn(Thread thread, String message, Exception exception) {
		message = getLogInfoParameters(thread, message);
		logger.warn(message, exception);

	}

	/** {@inheritDoc} */
	@Override
	public void error(Thread thread, String message, Exception exception) {
		message = getLogInfoParameters(thread, message);
		logger.error(message, exception);

	}

	/** {@inheritDoc} */
	@Override
	public void fatal(Thread thread, String message, Exception exception) {
		message = getLogInfoParameters(thread, message);
		logger.fatal(message, exception);
	}

}
