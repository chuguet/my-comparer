/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.exception;

/**
 * The Class ExternalAutoSenderException.
 */
@SuppressWarnings("serial")
public class ExternalAutoSenderException extends Exception {

	/** The code. */
	private Integer code;

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Instantiates a new external auto sender exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param code
	 *            the code
	 */
	public ExternalAutoSenderException(String arg0, Integer code) {
		super(arg0);
		this.code = code;
	}

	/**
	 * Instantiates a new external auto sender exception.
	 */
	public ExternalAutoSenderException() {
		super();
	}

	/**
	 * Instantiates a new external auto sender exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public ExternalAutoSenderException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new external auto sender exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 */
	public ExternalAutoSenderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new external auto sender exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public ExternalAutoSenderException(Throwable arg0) {
		super(arg0);
	}
}
