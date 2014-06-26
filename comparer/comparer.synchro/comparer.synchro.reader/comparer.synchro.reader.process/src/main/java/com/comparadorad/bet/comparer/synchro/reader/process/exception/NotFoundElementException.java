/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.exception;

/**
 * The Class NotFoundElementException.
 */
@SuppressWarnings("serial")
public class NotFoundElementException extends Exception {

	/**
	 * Instantiates a new not found element exception.
	 */
	public NotFoundElementException() {
		super();

	}

	/**
	 * Instantiates a new not found element exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public NotFoundElementException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

	/**
	 * Instantiates a new not found element exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public NotFoundElementException(Throwable pCause) {
		super(pCause);

	}

	/**
	 * Instantiates a new not found element exception.
	 * 
	 * @param message
	 *            the message
	 */
	public NotFoundElementException(String message) {
		super(message);
	}

}
