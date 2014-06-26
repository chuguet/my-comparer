/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.exception;

/**
 * The Class SynchroMatchWriterServiceException.
 */
@SuppressWarnings("serial")
public class SynchroMatchWriterServiceException extends Exception {

	/**
	 * Instantiates a new synchro match writer service exception.
	 */
	public SynchroMatchWriterServiceException() {
		super();
	}

	/**
	 * Instantiates a new synchro match writer service exception.
	 * 
	 * @param message
	 *            the message
	 */
	public SynchroMatchWriterServiceException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new synchro match writer service exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public SynchroMatchWriterServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new synchro match writer service exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public SynchroMatchWriterServiceException(Throwable cause) {
		super(cause);
	}

}
