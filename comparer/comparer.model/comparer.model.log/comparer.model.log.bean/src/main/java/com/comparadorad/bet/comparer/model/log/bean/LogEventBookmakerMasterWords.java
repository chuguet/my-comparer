/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtilException;

/**
 * The Class LogXmlEvent.
 */
@SuppressWarnings("serial")
@Document
public class LogEventBookmakerMasterWords extends LogEvent {

	private static final Log LOG = LogFactory.getLog(LogEventBookmakerMasterWords.class);
	/** The bookmaker. */
	@DBRef
	@NotNull
	private CfgBookmaker bookmaker;

	/**
	 * Instantiates a new log xml event.
	 */
	public LogEventBookmakerMasterWords() {
		super();
	}

	/**
	 * Instantiates a new log event bookmaker Master Words.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 * @param pBookmaker
	 *            the bookmaker
	 * @param pLogLevel
	 *            the log level
	 * @param pLogState
	 *            the log state
	 */
	public LogEventBookmakerMasterWords(String pProcessId, String pMessage, Object pData,
			CfgBookmaker pBookmaker, LogLevel pLogLevel, LogState pLogState, Date errorDate) {
		super(pProcessId, pMessage, pData, pLogLevel, pLogState, errorDate);
		this.bookmaker = pBookmaker;
	}

	/**
	 * Gets the bookmaker.
	 * 
	 * @return the bookmaker
	 */
	public CfgBookmaker getBookmaker() {
		return bookmaker;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public AbstractXmlData getData() {
		if (super.getData() instanceof AbstractXmlData) {
			return (AbstractXmlData) super.getData();
		} else if (super.getData() instanceof String) {
			try {
				return (AbstractXmlData) XStreamUtil.fromXML((String) super
						.getData());
			} catch (XStreamUtilException e) {
				LOG.warn(e.getMessage(), e);
				return null;
			}
		}
		return null;
	}

	/**
	 * Sets the bookmaker.
	 * 
	 * @param pBookmaker
	 *            the new bookmaker
	 */
	public void setBookmaker(CfgBookmaker pBookmaker) {
		bookmaker = pBookmaker;
	}

	/**
	 * Sets the data.
	 * 
	 * @param pData
	 *            the new data
	 */
	public void setData(@SuppressWarnings("rawtypes") AbstractXmlData pData) {
		super.setData(pData);
	}

}
