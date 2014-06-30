/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betclick;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class BetclickAttributeException.
 */
@SuppressWarnings("serial")
public class BetclickAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new betclick attribute exception.
	 */
	public BetclickAttributeException() {
		super();
	}

	/**
	 * Instantiates a new betclick attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BetclickAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new betclick attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BetclickAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new betclick attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BetclickAttributeException(Throwable pCause) {
		super(pCause);
	}

}
