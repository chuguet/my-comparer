/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

/**
 * The Class InterwettenBetTypeEventNotFoundException.
 */
@SuppressWarnings("serial")
class InterwettenBetTypeEventNotFoundException extends InterwettenCoreException {

	/**
	 * Instantiates a new interwetten bet type event not found exception.
	 */
	public InterwettenBetTypeEventNotFoundException() {
		this("pepito");
	}

	/**
	 * Instantiates a new interwetten bet type event not found exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public InterwettenBetTypeEventNotFoundException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new interwetten bet type event not found exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public InterwettenBetTypeEventNotFoundException(String pMessage,
			Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new interwetten bet type event not found exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public InterwettenBetTypeEventNotFoundException(Throwable pCause) {
		super(pCause);
	}

}
