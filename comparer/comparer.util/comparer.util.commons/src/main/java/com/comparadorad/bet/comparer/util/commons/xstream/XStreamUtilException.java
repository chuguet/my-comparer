/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.xstream;

/**
 * The Class XStreamUtilException.
 */
@SuppressWarnings("serial")
public class XStreamUtilException extends RuntimeException {

	/**
	 * Instantiates a new x stream util exception.
	 */
	public XStreamUtilException() {
		super();

	}

	/**
	 * Instantiates a new x stream util exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public XStreamUtilException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

	/**
	 * Instantiates a new x stream util exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public XStreamUtilException(String pMessage) {
		super(pMessage);

	}

	/**
	 * Instantiates a new x stream util exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public XStreamUtilException(Throwable pCause) {
		super(pCause);

	}

}
