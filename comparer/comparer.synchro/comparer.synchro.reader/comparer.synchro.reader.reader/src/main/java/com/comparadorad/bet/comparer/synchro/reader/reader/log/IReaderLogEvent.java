/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.log;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Interface IReaderLogEvent.
 */
public interface IReaderLogEvent {

	// /**
	// * Error log.
	// *
	// * @param message
	// * the message {@inheritDoc}
	// */
	//
	// void errorLog(String message);
	//
	/**
	 * Error log.
	 * 
	 * @param message
	 *            the message
	 * @param data
	 *            the data {@inheritDoc}
	 */

	void errorLog(String message, Object data, CfgBookmaker bookmaker);
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
	// void errorLog(String message, Object data, Throwable throwable);
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
	// void errorLog(String title, String message);
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
	// void errorLog(String message, Throwable throwable);

}