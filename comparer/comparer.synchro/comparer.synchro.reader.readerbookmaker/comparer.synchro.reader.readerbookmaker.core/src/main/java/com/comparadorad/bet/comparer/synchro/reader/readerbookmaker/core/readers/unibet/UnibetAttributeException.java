/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.unibet;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class UnibetAttributeException.
 */
@SuppressWarnings("serial")
public class UnibetAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new unibet attribute exception.
	 */
	public UnibetAttributeException() {
	}

	/**
	 * Instantiates a new unibet attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public UnibetAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new unibet attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public UnibetAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new unibet attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public UnibetAttributeException(Throwable pCause) {
		super(pCause);
	}

}
