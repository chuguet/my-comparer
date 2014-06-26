/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.service;

import java.util.Date;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;

/**
 * The Interface ILogXmlEventService.
 */
public interface ILogEventBookmakerService extends
		IGenericCrudService<LogEventBookmaker> {

	/**
	 * Custom find by bookmaker and sta.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @param pLogState
	 *            the log state
	 * @return the list
	 */
	List<LogEventBookmaker> customFindByBookmakerAndSta(CfgBookmaker bookmaker,
			LogState pLogState);

	/**
	 * Error.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void error(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker, Date errorDate);

	/**
	 * Error.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param data
	 *            the data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void error(String pProcessId, String pMessage, Object data,
			CfgBookmaker bookmaker, Date errorDate);

	/**
	 * Info.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void info(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker, Date errorDate);

	/**
	 * Log.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 * @param pLogLevel
	 *            the log level
	 */
	void log(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker, final LogLevel pLogLevel, Date errorDate);

	/**
	 * Log.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pXmlData
	 *            the xml data
	 * @param pBookmaker
	 *            the bookmaker
	 * @param pLogLevel
	 *            the log level
	 */
	void log(String pProcessId, String pMessage, Object pXmlData,
			CfgBookmaker pBookmaker, LogLevel pLogLevel, Date errorDate);

	/**
	 * Warn.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void warn(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker, Date errorDate);

}
