/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class NotFoundElementException.
 */
@SuppressWarnings("serial")
public class InactiveElementException extends Exception {

	/**
	 * Instantiates a new not found element exception.
	 */
	public InactiveElementException() {
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
	public InactiveElementException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

	/**
	 * Instantiates a new not found element exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public InactiveElementException(Throwable pCause) {
		super(pCause);

	}

	/**
	 * Instantiates a new not found element exception.
	 * 
	 * @param message
	 *            the message
	 */
	public InactiveElementException(String message) {
		super(message);
	}

}
