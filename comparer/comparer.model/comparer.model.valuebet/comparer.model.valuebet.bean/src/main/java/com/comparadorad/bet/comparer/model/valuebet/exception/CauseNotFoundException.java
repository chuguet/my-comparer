/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.exception;

/**
 * The Class CauseNotFoundException.
 */
@SuppressWarnings("serial")
public class CauseNotFoundException extends ValueBetException {

	/**
	 * Instantiates a new cause not found exception.
	 */
	public CauseNotFoundException() {
	}

	/**
	 * Instantiates a new cause not found exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public CauseNotFoundException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new cause not found exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public CauseNotFoundException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new cause not found exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public CauseNotFoundException(Throwable pCause) {
		super(pCause);
	}

}
