/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mock.exception;

/**
 * The Class MockException.
 */
@SuppressWarnings("serial")
public class MockException extends Exception {

	/**
	 * Instantiates a new mock exception.
	 * 
	 * @param message
	 *            the message
	 */
	public MockException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new mock exception.
	 * 
	 * @param e
	 *            the e
	 */
	public MockException(final Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new mock exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public MockException(final String message, final Exception e) {
		super(message, e);
	}

	/**
	 * Instantiates a new mock exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public MockException(final String message, final Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new mock exception.
	 * 
	 * @param t
	 *            the t
	 */
	public MockException(final Throwable t) {
		super(t);
	}

}
