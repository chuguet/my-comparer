/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.exception;

/**
 * The Class ElemementNotFoundException.
 */
public class ElemementNotFoundException extends AsynchronousCacheException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new elemement not found exception.
	 */
	public ElemementNotFoundException() {
		super();
	}

	/**
	 * Instantiates a new elemement not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ElemementNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new elemement not found exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ElemementNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new elemement not found exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ElemementNotFoundException(Throwable cause) {
		super(cause);
	}

}
