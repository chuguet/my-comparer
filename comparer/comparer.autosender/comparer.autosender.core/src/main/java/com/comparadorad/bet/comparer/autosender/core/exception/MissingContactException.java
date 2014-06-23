/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.exception;

/**
 * The Class MissingContactException.
 */
@SuppressWarnings("serial")
public class MissingContactException extends ExternalAutoSenderException {

	/**
	 * Instantiates a new missing contact exception.
	 */
	public MissingContactException() {
		super();
	}

	/**
	 * Instantiates a new missing contact exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public MissingContactException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new missing contact exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 */
	public MissingContactException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new missing contact exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public MissingContactException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new missing contact exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param code
	 *            the code
	 */
	public MissingContactException(String arg0, Integer code) {
		super(arg0, code);
	}

}
