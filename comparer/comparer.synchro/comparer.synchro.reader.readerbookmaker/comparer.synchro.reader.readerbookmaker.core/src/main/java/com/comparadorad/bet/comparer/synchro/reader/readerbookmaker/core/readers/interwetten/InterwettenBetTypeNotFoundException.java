/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

/**
 * The Class InterwettenBetTypeException.
 */
@SuppressWarnings("serial")
public class InterwettenBetTypeNotFoundException extends
		InterwettenCoreException {

	/**
	 * Instantiates a new interwetten bet type exception.
	 */
	public InterwettenBetTypeNotFoundException() {
	}

	/**
	 * Instantiates a new interwetten bet type exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public InterwettenBetTypeNotFoundException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new interwetten bet type exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public InterwettenBetTypeNotFoundException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new interwetten bet type exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public InterwettenBetTypeNotFoundException(Throwable pCause) {
		super(pCause);
	}

}
