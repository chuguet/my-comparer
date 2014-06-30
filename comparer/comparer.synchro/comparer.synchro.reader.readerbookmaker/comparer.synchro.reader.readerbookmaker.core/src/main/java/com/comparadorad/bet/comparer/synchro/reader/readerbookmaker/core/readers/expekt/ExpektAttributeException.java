/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.expekt;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class ExpektAttributeException.
 */
@SuppressWarnings("serial")
public class ExpektAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new expekt attribute exception.
	 */
	public ExpektAttributeException() {
	}

	/**
	 * Instantiates a new expekt attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public ExpektAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new expekt attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public ExpektAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new expekt attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public ExpektAttributeException(Throwable pCause) {
		super(pCause);
	}

}
