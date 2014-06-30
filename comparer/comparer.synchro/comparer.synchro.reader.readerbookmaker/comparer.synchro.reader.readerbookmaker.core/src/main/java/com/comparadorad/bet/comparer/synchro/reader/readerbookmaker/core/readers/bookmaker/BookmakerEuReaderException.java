/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class BookmakerEuReaderException.
 */
@SuppressWarnings("serial")
public class BookmakerEuReaderException extends XmlReaderException {

	/**
	 * Instantiates a new bookmaker eu reader exception.
	 */
	public BookmakerEuReaderException() {
		super();
	}

	/**
	 * Instantiates a new bookmaker eu reader exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BookmakerEuReaderException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new bookmaker eu reader exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BookmakerEuReaderException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new bookmaker eu reader exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BookmakerEuReaderException(Throwable pCause) {
		super(pCause);
	}

}
