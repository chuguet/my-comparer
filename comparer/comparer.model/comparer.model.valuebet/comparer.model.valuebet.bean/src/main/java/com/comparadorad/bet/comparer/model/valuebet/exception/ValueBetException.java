/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.exception;

/**
 * The Class ValueBetException.
 */
@SuppressWarnings("serial")
public class ValueBetException extends Exception {

	/**
	 * Instantiates a new value bet exception.
	 */
	public ValueBetException() {
	}

	/**
	 * Instantiates a new value bet exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public ValueBetException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new value bet exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public ValueBetException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new value bet exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public ValueBetException(Throwable pCause) {
		super(pCause);
	}

}
