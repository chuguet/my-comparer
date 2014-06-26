/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.service;

import java.util.Date;

import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;

/**
 * The Interface ICfgBetTypeService.
 */
public interface ILogEventService extends IGenericCrudService<LogEvent> {
	/**
	 * Info.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 */
	void info(String pProcessId, String pMessage, Object pData, Date errorDate);

	/**
	 * Error.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 */
	void error(String pProcessId, String pMessage, Object pData, Date errorDate);

	/**
	 * Warn.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 */
	void warn(String pProcessId, String pMessage, Object pData, Date errorDate);

	/**
	 * Log.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 * @param pLogLevel
	 *            the log level
	 */
	void log(String pProcessId, String pMessage, Object pData,
			final LogLevel pLogLevel, Date errorDate);

}
