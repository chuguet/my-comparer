/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.log;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerMasterWordsService;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerService;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;

/**
 * The Class SynchoErrerEvent.
 */
@Service
final class SynchroErrorEvent implements ISynchroErrorEvent {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SynchroErrorEvent.class);

	/** The Constant READER_PROCESS. */
	private static final String READER_PROCESS = "READER_PROCESS";

	/** The log xml event service. */
	@Inject
	private ILogEventBookmakerService logXmlEventService;
	
	/** The log xml event service. */
	@Inject
	private ILogEventBookmakerMasterWordsService logXmlEventServiceMasterWords;

	/**
	 * Instantiates a new syncho error event.
	 */
	private SynchroErrorEvent() {
		super();
	}

	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@Override
	public void errorLog(String message,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker) {
		logXmlEventService.error(READER_PROCESS, message, xmlData, bookmaker);
		LOG.error(message);
	}

	/**
	 * Error log.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@Override
	public void errorLog(String pMessage, Object pData, CfgBookmaker pBookmaker) {
		logXmlEventService.error(READER_PROCESS, pMessage, pData, pBookmaker);
		LOG.error(pMessage);
	}

	
	/**
	 * Error log.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pThrowable
	 *            the throwable
	 * @param pXmlData
	 *            the xml data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void errorLog(String pMessage, Throwable pThrowable,
			AbstractXmlData pXmlData, CfgBookmaker pBookmaker) {
		logXmlEventService
				.error(READER_PROCESS, pMessage, pXmlData, pBookmaker);
		LOG.error(pMessage, pThrowable);
	}
	
	/**
	 * Error log master words.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pThrowable
	 *            the throwable
	 * @param pXmlData
	 *            the xml data
	 * @param pBookmaker
	 *            the bookmaker {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void errorMasterWordsLog(String pMessage, Throwable pThrowable,
			AbstractXmlData pXmlData, CfgBookmaker pBookmaker) {
		logXmlEventServiceMasterWords
				.error(READER_PROCESS, pMessage, pXmlData, pBookmaker);
		//LOG.error(pMessage, pThrowable);
	}
	
}
