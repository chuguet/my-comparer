/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class InterwettenCoreException.
 */
@SuppressWarnings("serial")
public class InterwettenCoreException extends XmlReaderException {

	/**
	 * Instantiates a new interwetten core exception.
	 */
	public InterwettenCoreException() {
	}

	/**
	 * Instantiates a new interwetten core exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public InterwettenCoreException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new interwetten core exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public InterwettenCoreException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new interwetten core exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public InterwettenCoreException(Throwable pCause) {
		super(pCause);
	}

}
