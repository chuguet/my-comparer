/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

/**
 * The Class ExpektAttributeException.
 */
@SuppressWarnings("serial")
public class InterwettenAttributeException extends InterwettenCoreException {

	/**
	 * Instantiates a new interwetten attribute exception.
	 */
	public InterwettenAttributeException() {
	}

	/**
	 * Instantiates a new interwetten attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public InterwettenAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new interwetten attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public InterwettenAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new interwetten attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public InterwettenAttributeException(Throwable pCause) {
		super(pCause);
	}

}
