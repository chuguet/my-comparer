/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.exception;

/**
 * The Class DbcoreRuntimeException.
 */
@SuppressWarnings("serial")
public class DbcoreRuntimeException extends RuntimeException {

	/**
	 * Instantiates a new dbcore runtime exception.
	 */
	public DbcoreRuntimeException() {
		super();
	}

	/**
	 * Instantiates a new dbcore runtime exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public DbcoreRuntimeException(String pMessage) {
		super(pMessage);

	}

	/**
	 * Instantiates a new dbcore runtime exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public DbcoreRuntimeException(Throwable pCause) {
		super(pCause);

	}

	/**
	 * Instantiates a new dbcore runtime exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public DbcoreRuntimeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

}
