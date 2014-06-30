/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class TriobetAttributeException.
 */
@SuppressWarnings("serial")
public class TrioNordicbetAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new triobet attribute exception.
	 */
	public TrioNordicbetAttributeException() {
	}

	/**
	 * Instantiates a new triobet attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public TrioNordicbetAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new triobet attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public TrioNordicbetAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new triobet attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public TrioNordicbetAttributeException(Throwable pCause) {
		super(pCause);
	}

}
