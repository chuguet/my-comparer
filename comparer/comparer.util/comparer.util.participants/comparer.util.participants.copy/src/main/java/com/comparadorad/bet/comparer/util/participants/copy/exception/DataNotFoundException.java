/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.exception;

/**
 * The Class DataNotFoundException.
 */
@SuppressWarnings("serial")
public class DataNotFoundException extends ParticipantCopyException {

	/**
	 * Instantiates a new data not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public DataNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new data not found exception.
	 * 
	 * @param t
	 *            the t
	 */
	public DataNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new data not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public DataNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new data not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public DataNotFoundException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Instantiates a new data not found exception.
	 * 
	 * @param e
	 *            the e
	 */
	public DataNotFoundException(Exception e) {
		super(e);
	}

}
