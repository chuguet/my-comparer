/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

/**
 * The Class MatchWillNotBeProcessedException.
 */
@SuppressWarnings("serial")
public class MatchWillNotBeProcessedException extends InterwettenCoreException {

	/**
	 * Instantiates a new match will not be processed exception.
	 */
	public MatchWillNotBeProcessedException() {
	}

	/**
	 * Instantiates a new match will not be processed exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public MatchWillNotBeProcessedException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new match will not be processed exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public MatchWillNotBeProcessedException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new match will not be processed exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public MatchWillNotBeProcessedException(Throwable pCause) {
		super(pCause);
	}

}
