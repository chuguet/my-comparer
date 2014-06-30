/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class BetAtHomeAttributeException.
 */
@SuppressWarnings("serial")
public class BetAtHomeAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new bet at home attribute exception.
	 */
	public BetAtHomeAttributeException() {
		super();
	}

	/**
	 * Instantiates a new bet at home attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BetAtHomeAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new bet at home attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BetAtHomeAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new bet at home attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BetAtHomeAttributeException(Throwable pCause) {
		super(pCause);
	}

}
