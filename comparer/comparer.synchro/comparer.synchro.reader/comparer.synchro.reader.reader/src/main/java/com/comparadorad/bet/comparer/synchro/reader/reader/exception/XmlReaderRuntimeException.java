/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.exception;

/**
 * The Class XmlReaderRuntimeException.
 */
@SuppressWarnings("serial")
public class XmlReaderRuntimeException extends RuntimeException {

	/**
	 * Instantiates a new xml reader runtime exception.
	 */
	public XmlReaderRuntimeException() {
		super();
	}

	/**
	 * Instantiates a new xml reader runtime exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public XmlReaderRuntimeException(String pMessage) {
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
	public XmlReaderRuntimeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

	/**
	 * Instantiates a new xml reader runtime exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public XmlReaderRuntimeException(Throwable pCause) {
		super(pCause);

	}

}
