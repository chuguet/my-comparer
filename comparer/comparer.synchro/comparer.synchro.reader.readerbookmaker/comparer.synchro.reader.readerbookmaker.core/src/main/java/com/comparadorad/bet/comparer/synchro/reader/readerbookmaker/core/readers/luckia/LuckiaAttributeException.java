/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.luckia;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class UnibetAttributeException.
 */
@SuppressWarnings("serial")
public class LuckiaAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new unibet attribute exception.
	 */
	public LuckiaAttributeException() {
	}

	/**
	 * Instantiates a new unibet attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public LuckiaAttributeException(String pMessage) {
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
	public LuckiaAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new unibet attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public LuckiaAttributeException(Throwable pCause) {
		super(pCause);
	}

}
