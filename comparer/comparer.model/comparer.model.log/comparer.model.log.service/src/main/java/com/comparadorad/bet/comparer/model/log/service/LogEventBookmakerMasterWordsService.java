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

import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerMasterWordsRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;

/**
 * The Class LogXmlEventService.
 */
@Service
class LogEventBookmakerMasterWordsService extends AbstractGenericCrudService<LogEventBookmakerMasterWords> implements
		ILogEventBookmakerMasterWordsService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LogEventBookmakerMasterWordsService.class);
	/** The repository. */
	@Inject
	private LogEventBookmakerMasterWordsRepository repository;

	/**
	 * Custom find by sta.
	 * 
	 * @param pLogState
	 *            the log state
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<LogEventBookmakerMasterWords> customFindBySta(LogState pLogState) {
		return repository.customFindByState(pLogState);
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
	 * @param errorDate
	 *            the error date
	 */
	@Override
	public void error(String pProcessId, String pMessage, @SuppressWarnings("rawtypes") AbstractXmlData pXmlData, CfgBookmaker pBookmaker,
			Date errorDate) {
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
	 * @param errorDate
	 *            the error date
	 */
	@Override
	public void error(String pProcessId, String pMessage, Object pData, CfgBookmaker pBookmaker, Date errorDate) {
		this.log(pProcessId, pMessage, pData, pBookmaker, LogLevel.INFO, errorDate);

	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<LogEventBookmakerMasterWords> getCrudRepository() {
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
	 * @param errorDate
	 *            the error date
	 */
	@Override
	public void info(String pProcessId, String pMessage, @SuppressWarnings("rawtypes") AbstractXmlData pXmlData, CfgBookmaker pBookmaker,
			Date errorDate) {
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
	 * @param errorDate
	 *            the error date
	 */
	@Override
	public void log(String pProcessId, String pMessage, @SuppressWarnings("rawtypes") AbstractXmlData pXmlData, CfgBookmaker pBookmaker,
			LogLevel pLogLevel, Date errorDate) {
		LogEventBookmakerMasterWords logXmlEvent = new LogEventBookmakerMasterWords(pProcessId, pMessage, pXmlData, pBookmaker, pLogLevel,
				LogState.NEW, errorDate);
		try {
			this.repository.save(logXmlEvent);
		} catch (Throwable e) {
			LOG.error("Ha habido un error en la grabación del objeto");
			LOG.error(e.getMessage());
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
	 * @param errorDate
	 *            the error date
	 */
	@Override
	public void log(String pProcessId, String pMessage, Object pXmlData, CfgBookmaker pBookmaker, LogLevel pLogLevel, Date errorDate) {
		LogEventBookmakerMasterWords logXmlEvent = new LogEventBookmakerMasterWords(pProcessId, pMessage, pXmlData, pBookmaker, pLogLevel,
				LogState.NEW, errorDate);
		try {
			this.repository.save(logXmlEvent);
		} catch (Throwable e) {
			LOG.error("Ha habido un error en la grabación del objeto");
			LOG.error(e.getMessage());
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
	 * @param errorDate
	 *            the error date
	 */
	@Override
	public void warn(String pProcessId, String pMessage, @SuppressWarnings("rawtypes") AbstractXmlData pXmlData, CfgBookmaker pBookmaker,
			Date errorDate) {
		this.log(pProcessId, pMessage, pXmlData, pBookmaker, LogLevel.WARN, errorDate);
	}

	/** {@inheritDoc} */
	@Override
	public Boolean checkParticipantExistence(XmlMatchParticipant participante) {
		Boolean existe = Boolean.FALSE;
		existe = repository.checkParticipantExistence(participante);
		return existe;
	}

	@Override
	public void deleteExistentSynonym(String message) {
		repository.deleteExistentSynonym(message);
		
	}
}
