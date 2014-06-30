/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betgun;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class BetgunAttributeException.
 */
@SuppressWarnings("serial")
public class BetgunAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new betgun attribute exception.
	 */
	public BetgunAttributeException() {
		super();
	}

	/**
	 * Instantiates a new betgun attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BetgunAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new betgun attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BetgunAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new betgun attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BetgunAttributeException(Throwable pCause) {
		super(pCause);
	}

}
