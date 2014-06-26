/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log;

import java.util.Date;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;

/**
 * The Interface ISynchroErrorEvent.
 */
public interface ISynchroErrorEvent {

	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void errorLog(String message,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmake, Date errorDate);

	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void errorLog(String message, Throwable throwable,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker, Date errorDate);

	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 * @param xmlData
	 *            the xml data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void errorMasterWordsLog(String message, Throwable throwable,
			@SuppressWarnings("rawtypes") AbstractXmlData xmlData,
			CfgBookmaker bookmaker, Date errorDate);
	
//	/**
//	 * Error log.
//	 * 
//	 * @param message
//	 *            the message
//	 */
//	void errorLog(String message);
//
//	/**
//	 * Error log.
//	 * 
//	 * @param message
//	 *            the message
//	 * @param data
//	 *            the data
//	 */
//	void errorLog(String message, Object data);

	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param data
	 *            the data
	 * @param bookmaker
	 *            the bookmaker
	 */
	void errorLog(String message, Object data, CfgBookmaker bookmaker, Date errorDate);
//
//	/**
//	 * Error log.
//	 * 
//	 * @param message
//	 *            the message
//	 * @param data
//	 *            the data
//	 * @param throwable
//	 *            the throwable
//	 */
//	void errorLog(String message, Object data, Throwable throwable);
//
//	/**
//	 * Error log.
//	 * 
//	 * @param title
//	 *            the title
//	 * @param message
//	 *            the message
//	 */
//	void errorLog(String title, String message);
//
//	/**
//	 * Error log.
//	 * 
//	 * @param message
//	 *            the message
//	 * @param throwable
//	 *            the throwable
//	 */
//	void errorLog(String message, Throwable throwable);

}