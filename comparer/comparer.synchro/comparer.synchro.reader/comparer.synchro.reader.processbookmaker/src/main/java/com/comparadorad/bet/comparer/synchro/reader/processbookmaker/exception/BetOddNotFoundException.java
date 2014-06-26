/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class BetOddNotFoundException.
 */
public class BetOddNotFoundException extends ConvertException {

	/**
	 * Instantiates a new bet odd not found exception.
	 */
	public BetOddNotFoundException() {
		super();
	}

	/**
	 * Instantiates a new bet odd not found exception.
	 *
	 * @param pMessage the message
	 * @param pCause the cause
	 */
	public BetOddNotFoundException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new bet odd not found exception.
	 *
	 * @param pMessage the message
	 */
	public BetOddNotFoundException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new bet odd not found exception.
	 *
	 * @param pCause the cause
	 */
	public BetOddNotFoundException(Throwable pCause) {
		super(pCause);
	}
	

}
