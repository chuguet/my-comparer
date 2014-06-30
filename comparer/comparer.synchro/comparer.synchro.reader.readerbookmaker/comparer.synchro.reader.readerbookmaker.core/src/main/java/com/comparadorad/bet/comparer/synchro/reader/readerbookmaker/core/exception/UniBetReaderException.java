/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception;

/**
 * The Class XmlReaderRuntimeException.
 */
@SuppressWarnings("serial")
public class UniBetReaderException extends RuntimeException {

	/**
	 * Instantiates a new xml reader runtime exception.
	 */
	public UniBetReaderException() {
		super();
	}

	/**
	 * Instantiates a new xml reader runtime exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public UniBetReaderException(String pMessage) {
		super(pMessage);

	}

	/**
	 * Instantiates a new xml reader runtime exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public UniBetReaderException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

	/**
	 * Instantiates a new xml reader runtime exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public UniBetReaderException(Throwable pCause) {
		super(pCause);

	}

}
