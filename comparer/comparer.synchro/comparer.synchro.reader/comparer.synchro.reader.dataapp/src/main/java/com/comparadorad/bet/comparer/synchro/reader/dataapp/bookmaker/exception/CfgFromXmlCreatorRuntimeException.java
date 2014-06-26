/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.exception;

/**
 * The Class CfgFromXmlCreatorRuntimeException.
 */
@SuppressWarnings("serial")
public class CfgFromXmlCreatorRuntimeException extends RuntimeException {

	/**
	 * Instantiates a new cfg from xml creator exception.
	 */
	public CfgFromXmlCreatorRuntimeException() {
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
	public CfgFromXmlCreatorRuntimeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new cfg from xml creator exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public CfgFromXmlCreatorRuntimeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new cfg from xml creator exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public CfgFromXmlCreatorRuntimeException(Throwable pCause) {
		super(pCause);
	}

}
