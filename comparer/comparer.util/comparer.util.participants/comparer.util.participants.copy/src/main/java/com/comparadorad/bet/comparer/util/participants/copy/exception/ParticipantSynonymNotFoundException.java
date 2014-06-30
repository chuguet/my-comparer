/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.exception;

/**
 * The Class ParticipantSynonymNotFoundException.
 */
@SuppressWarnings("serial")
public class ParticipantSynonymNotFoundException extends DataNotFoundException {

	/**
	 * Instantiates a new participant synonym not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ParticipantSynonymNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new participant synonym not found exception.
	 * 
	 * @param t
	 *            the t
	 */
	public ParticipantSynonymNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new participant synonym not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public ParticipantSynonymNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new participant synonym not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public ParticipantSynonymNotFoundException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Instantiates a new participant synonym not found exception.
	 * 
	 * @param e
	 *            the e
	 */
	public ParticipantSynonymNotFoundException(Exception e) {
		super(e);
	}

}
