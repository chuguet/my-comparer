/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class BetTypeException.
 */
public class BetTypeException extends ConvertException {

	/**
	 * Instantiates a new bet type exception.
	 */
	public BetTypeException() {
		super();
	}

	/**
	 * Instantiates a new bet type exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BetTypeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new bet type exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BetTypeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new bet type exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BetTypeException(Throwable pCause) {
		super(pCause);
	}

}
