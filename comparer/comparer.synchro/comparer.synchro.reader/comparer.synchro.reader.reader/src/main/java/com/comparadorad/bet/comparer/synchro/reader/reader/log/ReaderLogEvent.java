/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.log;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerService;

/**
 * The Class SynchoErrerEvent.
 */
@Service
final class ReaderLogEvent implements IReaderLogEvent {

	/** The Constant READER_PROCESS. */
	private static final String READER_PROCESS = "READER_XML_PROCESS";
	//
	/** The log event service. */
	@Inject
	private ILogEventBookmakerService logEventService;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ReaderLogEvent.class);

	/**
	 * Instantiates a new syncho error event.
	 */
	private ReaderLogEvent() {
		super();
	}

	//
	// /**
	// * Error log.
	// *
	// * @param message
	// * the message {@inheritDoc}
	// */
	//
	// @Override
	// public void errorLog(String message) {
	// logEventService.error(READER_PROCESS, message, null);
	// consoleErrorLogMessage(message);
	// }
	//
	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param data
	 *            the data {@inheritDoc}
	 */

	@Override
	public void errorLog(String message, Object data, CfgBookmaker cfgBookmaker) {
		logEventService.error(READER_PROCESS, message, data, cfgBookmaker);
		consoleErrorLogMessage(message);
	}

	//
	// /**
	// * Error log.
	// *
	// * @param message
	// * the message
	// * @param data
	// * the data
	// * @param throwable
	// * the throwable {@inheritDoc}
	// */
	//
	// @Override
	// public void errorLog(String message, Object data, Throwable throwable) {
	// logEventService.error(READER_PROCESS, message, data);
	// consoleErrorLogMessage(message);
	// }
	//
	// /**
	// * Error log.
	// *
	// * @param title
	// * the title
	// * @param message
	// * the message {@inheritDoc}
	// */
	//
	// @Override
	// public void errorLog(String title, String message) {
	// logEventService.error(READER_PROCESS, title, message);
	// consoleErrorLogMessage(message);
	// }
	//
	// /**
	// * Error log.
	// *
	// * @param message
	// * the message
	// * @param throwable
	// * the throwable {@inheritDoc}
	// */
	//
	// @Override
	// public void errorLog(String message, Throwable throwable) {
	// logEventService.error(READER_PROCESS, message, null);
	// consoleErrorLogMessage(message);
	// }
	//
	/**
	 * Console error log message.
	 * 
	 * @param message
	 *            the message
	 */
	private void consoleErrorLogMessage(String message) {
		StringBuffer logMsg = new StringBuffer();
		logMsg.append("[").append(READER_PROCESS).append("]").append(message);
		LOG.error(logMsg.toString());
	}
}
