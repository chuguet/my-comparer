/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.exception;

/**
 * The Class ParticipantNotFoundException.
 */
@SuppressWarnings("serial")
public class ParticipantNotFoundException extends DataNotFoundException {

	/**
	 * Instantiates a new participant not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ParticipantNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new participant not found exception.
	 * 
	 * @param t
	 *            the t
	 */
	public ParticipantNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new participant not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public ParticipantNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new participant not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public ParticipantNotFoundException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Instantiates a new participant not found exception.
	 * 
	 * @param e
	 *            the e
	 */
	public ParticipantNotFoundException(Exception e) {
		super(e);
	}

}
