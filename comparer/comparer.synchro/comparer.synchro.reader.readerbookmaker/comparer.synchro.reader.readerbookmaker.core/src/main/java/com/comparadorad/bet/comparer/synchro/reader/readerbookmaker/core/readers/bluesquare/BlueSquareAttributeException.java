/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bluesquare;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class BlueSquareAttributeException.
 */
public class BlueSquareAttributeException extends XmlReaderException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7164513199008586385L;

	/**
	 * Instantiates a new blue square attribute exception.
	 */
	public BlueSquareAttributeException() {
		super();
	}

	/**
	 * Instantiates a new blue square attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BlueSquareAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new blue square attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BlueSquareAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new blue square attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BlueSquareAttributeException(Throwable pCause) {
		super(pCause);
	}

}
