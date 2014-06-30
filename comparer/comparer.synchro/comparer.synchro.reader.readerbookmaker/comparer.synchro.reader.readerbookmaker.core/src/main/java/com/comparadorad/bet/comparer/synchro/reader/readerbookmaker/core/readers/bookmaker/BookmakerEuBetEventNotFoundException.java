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
 * The Class BookmakerEuBetEventNotFoundException.
 */
@SuppressWarnings("serial")
class BookmakerEuBetEventNotFoundException extends XmlReaderException {

	/**
	 * Instantiates a new bookmaker eu bet event not found exception.
	 */
	public BookmakerEuBetEventNotFoundException() {
		super();
	}

	/**
	 * Instantiates a new bookmaker eu bet event not found exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public BookmakerEuBetEventNotFoundException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new bookmaker eu bet event not found exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public BookmakerEuBetEventNotFoundException(String pMessage,
			Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new bookmaker eu bet event not found exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public BookmakerEuBetEventNotFoundException(Throwable pCause) {
		super(pCause);
	}

}
