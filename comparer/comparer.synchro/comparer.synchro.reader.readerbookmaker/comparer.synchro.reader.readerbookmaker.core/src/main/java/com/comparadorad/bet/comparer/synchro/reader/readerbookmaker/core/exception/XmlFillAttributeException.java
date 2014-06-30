/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception;

/**
 * The Class XmlFillAttributeException.
 */
@SuppressWarnings("serial")
public class XmlFillAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new xml fill attribute exception.
	 */
	public XmlFillAttributeException() {
		super();

	}

	/**
	 * Instantiates a new xml fill attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public XmlFillAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);

	}

	/**
	 * Instantiates a new xml fill attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public XmlFillAttributeException(String pMessage) {
		super(pMessage);

	}

	/**
	 * Instantiates a new xml fill attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public XmlFillAttributeException(Throwable pCause) {
		super(pCause);

	}

}
