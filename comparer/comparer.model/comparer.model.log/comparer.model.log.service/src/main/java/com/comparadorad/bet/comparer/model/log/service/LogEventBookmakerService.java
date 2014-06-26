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

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class LogXmlEventService.
 */
@Service
class LogEventBookmakerService extends
		AbstractGenericCrudService<LogEventBookmaker> implements
		ILogEventBookmakerService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(LogEventBookmakerService.class);
	/** The repository. */
	@Inject
	private LogEventBookmakerRepository repository;

	/** {@inheritDoc} */
	@Override
	public List<LogEventBookmaker> customFindByBookmakerAndSta(
			CfgBookmaker pBookmaker, LogState pLogState) {
		return repository.customFindByBookmakerAndState(pBookmaker, pLogState);
	}

	/**
	 * Error.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pXmlData
	 *            the xml data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@Override
	public void error(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData pXmlData,
			CfgBookmaker pBookmaker, Date errorDate) {
		this.log(pProcessId, pMessage, pXmlData, pBookmaker, LogLevel.ERROR, errorDate);

	}

	/**
	 * Error.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@Override
	public void error(String pProcessId, String pMessage, Object pData,
			CfgBookmaker pBookmaker, Date errorDate) {
		this.log(pProcessId, pMessage, pData, pBookmaker, LogLevel.INFO, errorDate);

	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<LogEventBookmaker> getCrudRepository() {
		return repository;
	}

	/**
	 * Info.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pXmlData
	 *            the xml data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@Override
	public void info(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData pXmlData,
			CfgBookmaker pBookmaker, Date errorDate) {
		this.log(pProcessId, pMessage, pXmlData, pBookmaker, LogLevel.INFO, errorDate);

	}

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
	 *            the log level {@inheritDoc}
	 */
	@Override
	public void log(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData pXmlData,
			CfgBookmaker pBookmaker, LogLevel pLogLevel, Date errorDate) {
		LogEventBookmaker logXmlEvent = new LogEventBookmaker(pProcessId,
				pMessage, pXmlData, pBookmaker, pLogLevel, LogState.NEW, errorDate);
		try {
			this.repository.save(logXmlEvent);
		} catch (Throwable e) {
			// Hay un error en la grabación, lo haremos en formato XSTREAM
			LOG.error("Ha habido un error en la grabación del objeto, lo grabaremos en formato XSTREAM");
			logXmlEvent.setData(XStreamUtil.createXStream().toXML(pXmlData));
			this.repository.save(logXmlEvent);
		}
	}

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
	 *            the log level {@inheritDoc}
	 */
	@Override
	public void log(String pProcessId, String pMessage, Object pXmlData,
			CfgBookmaker pBookmaker, LogLevel pLogLevel, Date errorDate) {
		LogEventBookmaker logXmlEvent = new LogEventBookmaker(pProcessId,
				pMessage, pXmlData, pBookmaker, pLogLevel, LogState.NEW, errorDate);
		try {
			this.repository.save(logXmlEvent);
		} catch (Throwable e) {
			// Hay un error en la grabación, lo haremos en formato XSTREAM
			LOG.error("Ha habido un error en la grabación del objeto, lo grabaremos en formato XSTREAM");
			logXmlEvent.setData(XStreamUtil.createXStream().toXML(pXmlData));
			this.repository.save(logXmlEvent);
		}
	}

	/**
	 * Warn.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pXmlData
	 *            the xml data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@Override
	public void warn(String pProcessId, String pMessage,
			@SuppressWarnings("rawtypes") AbstractXmlData pXmlData,
			CfgBookmaker pBookmaker, Date errorDate) {
		this.log(pProcessId, pMessage, pXmlData, pBookmaker, LogLevel.WARN, errorDate);

	}
}
