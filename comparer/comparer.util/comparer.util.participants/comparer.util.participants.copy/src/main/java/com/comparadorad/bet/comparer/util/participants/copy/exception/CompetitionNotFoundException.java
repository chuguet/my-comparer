/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.exception;

/**
 * The Class CompetitionNotFoundException.
 */
@SuppressWarnings("serial")
public class CompetitionNotFoundException extends DataNotFoundException {

	/**
	 * Instantiates a new competition not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public CompetitionNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new competition not found exception.
	 * 
	 * @param t
	 *            the t
	 */
	public CompetitionNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new competition not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public CompetitionNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new competition not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public CompetitionNotFoundException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Instantiates a new competition not found exception.
	 * 
	 * @param e
	 *            the e
	 */
	public CompetitionNotFoundException(Exception e) {
		super(e);
	}

}
