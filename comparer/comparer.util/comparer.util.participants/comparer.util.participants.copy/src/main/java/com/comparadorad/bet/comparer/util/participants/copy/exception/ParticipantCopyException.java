/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.exception;

/**
 * The Class ParticipantCopyException.
 */
@SuppressWarnings("serial")
public class ParticipantCopyException extends Exception {

	/**
	 * Instantiates a new participant copy exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ParticipantCopyException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new participant copy exception.
	 * 
	 * @param t
	 *            the t
	 */
	public ParticipantCopyException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new participant copy exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public ParticipantCopyException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new participant copy exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public ParticipantCopyException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Instantiates a new participant copy exception.
	 * 
	 * @param e
	 *            the e
	 */
	public ParticipantCopyException(Exception e) {
		super(e);
	}

}
