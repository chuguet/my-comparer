/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

/**
 * The Class MarketWillNotBeProcessedException.
 */
@SuppressWarnings("serial")
public class MarketWillNotBeProcessedException extends InterwettenCoreException {

	/**
	 * Instantiates a new market will not be processed exception.
	 */
	public MarketWillNotBeProcessedException() {
	}

	/**
	 * Instantiates a new market will not be processed exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public MarketWillNotBeProcessedException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new market will not be processed exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public MarketWillNotBeProcessedException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new market will not be processed exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public MarketWillNotBeProcessedException(Throwable pCause) {
		super(pCause);
	}

}
