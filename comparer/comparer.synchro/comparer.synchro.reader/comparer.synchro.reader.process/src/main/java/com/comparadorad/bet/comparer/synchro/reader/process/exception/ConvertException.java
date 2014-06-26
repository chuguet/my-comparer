/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.exception;

/**
 * The Class ConvertException.
 */
@SuppressWarnings("serial")
public class ConvertException extends RuntimeException {

	/**
	 * Instantiates a new convert exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public ConvertException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new convert exception.
	 */
	public ConvertException() {
		super();
	}

	/**
	 * Instantiates a new convert exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public ConvertException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new convert exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public ConvertException(Throwable pCause) {
		super(pCause);
	}

}
