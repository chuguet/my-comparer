/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.exception;

/**
 * The Class CfgFromXmlCreatorException.
 */
@SuppressWarnings("serial")
public class CfgFromXmlCreatorException extends Exception {

	/**
	 * Instantiates a new cfg from xml creator exception.
	 */
	public CfgFromXmlCreatorException() {
		super();
	}

	/**
	 * Instantiates a new cfg from xml creator exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public CfgFromXmlCreatorException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new cfg from xml creator exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public CfgFromXmlCreatorException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new cfg from xml creator exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public CfgFromXmlCreatorException(Throwable pCause) {
		super(pCause);
	}

}
