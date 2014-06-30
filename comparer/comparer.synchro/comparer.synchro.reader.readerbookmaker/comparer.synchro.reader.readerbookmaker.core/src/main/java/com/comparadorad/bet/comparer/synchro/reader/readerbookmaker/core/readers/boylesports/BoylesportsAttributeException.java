/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.boylesports;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class BoylesportsAttributeException.
 */
@SuppressWarnings("serial")
public class BoylesportsAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new boylesports attribute exception.
	 */
	public BoylesportsAttributeException() {
	}

	/**
	 * Instantiates a new boylesports attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BoylesportsAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new boylesports attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BoylesportsAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new boylesports attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BoylesportsAttributeException(Throwable pCause) {
		super(pCause);
	}

}
