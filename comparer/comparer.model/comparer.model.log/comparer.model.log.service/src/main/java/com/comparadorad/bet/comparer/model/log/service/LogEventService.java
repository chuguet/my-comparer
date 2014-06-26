/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.log.repository.LogEventRepository;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogLevel;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;

/**
 * The Class CfgBetTypeService.
 */
@Service
class LogEventService extends AbstractGenericCrudService<LogEvent> implements
		ILogEventService {

	/** The sport repository. */
	@Inject
	private LogEventRepository repository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<LogEvent> getCrudRepository() {
		return repository;
	}

	/** {@inheritDoc} */
	@Override
	public void info(String pProcessId, String pMessage, Object pData, Date errorDate) {
		this.log(pProcessId, pMessage, pData, LogLevel.INFO, errorDate);
	}

	/** {@inheritDoc} */
	@Override
	public void error(String pProcessId, String pMessage, Object pData, Date errorDate) {
		this.log(pProcessId, pMessage, pData, LogLevel.ERROR, errorDate);
	}

	/** {@inheritDoc} */
	@Override
	public void warn(String pProcessId, String pMessage, Object pData, Date errorDate) {
		this.log(pProcessId, pMessage, pData, LogLevel.WARN, errorDate);
	}

	/** {@inheritDoc} */
	@Override
	public void log(String pProcessId, String pMessage, Object pData,
			final LogLevel pLogLevel, Date errorDate) {
		LogEvent logSynchroEvent = new LogEvent(pProcessId, pMessage, pData,
				pLogLevel, LogState.NEW, errorDate);
		try {
			this.repository.save(logSynchroEvent);
		} catch (Exception e) {
			logSynchroEvent.setData(null);
			this.repository.save(logSynchroEvent);
		}
	}

}
