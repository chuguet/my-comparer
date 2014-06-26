/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.repository.exception;

/**
 * The Class ObjectWithRecursiveDataException.
 */
@SuppressWarnings("serial")
public class ObjectWithRecursiveDataException extends RuntimeException {

	/**
	 * Instantiates a new object with recursive data exception.
	 */
	public ObjectWithRecursiveDataException() {
	}

	/**
	 * Instantiates a new object with recursive data exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public ObjectWithRecursiveDataException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new object with recursive data exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public ObjectWithRecursiveDataException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Instantiates a new object with recursive data exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public ObjectWithRecursiveDataException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}
