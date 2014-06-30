/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.exception;

/**
 * The Class CacheException.
 */
public class AsynchronousCacheException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7518316811384140858L;

	/**
	 * Instantiates a new cache exception.
	 */
	public AsynchronousCacheException() {
		super();
	}

	/**
	 * Instantiates a new cache exception.
	 * 
	 * @param message
	 *            the message
	 */
	public AsynchronousCacheException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new cache exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public AsynchronousCacheException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new cache exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public AsynchronousCacheException(Throwable cause) {
		super(cause);
	}

}
