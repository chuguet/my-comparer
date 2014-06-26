/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class NotAllowedElementException.
 */
@SuppressWarnings("serial")
public class NotAllowedElementException extends Exception {

	/**
	 * Instantiates a new not allowed element exception.
	 */
	public NotAllowedElementException() {
		super();
	}

	/**
	 * Instantiates a new not allowed element exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 */
	public NotAllowedElementException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new not allowed element exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public NotAllowedElementException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new not allowed element exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public NotAllowedElementException(Throwable arg0) {
		super(arg0);
	}

}
