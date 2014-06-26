/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class DateFormatException.
 */
@SuppressWarnings("serial")
public class DateFormatException extends RuntimeException {

	/**
	 * Instantiates a new convert exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public DateFormatException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new convert exception.
	 */
	public DateFormatException() {
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
	public DateFormatException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new convert exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public DateFormatException(Throwable pCause) {
		super(pCause);
	}

}