/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

/**
 * The Class InterwettenHandicapException.
 */
@SuppressWarnings("serial")
public class InterwettenHandicapException extends InterwettenCoreException {

	/**
	 * Instantiates a new interwetten handicap exception.
	 */
	public InterwettenHandicapException() {
	}

	/**
	 * Instantiates a new interwetten handicap exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public InterwettenHandicapException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new interwetten handicap exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public InterwettenHandicapException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new interwetten handicap exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public InterwettenHandicapException(Throwable pCause) {
		super(pCause);
	}

}
