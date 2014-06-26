/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.exception;

/**
 * The Class XmlDataFileReaderException.
 */
@SuppressWarnings("serial")
public class XmlNotFoundException extends Exception {

	/**
	 * Instantiates a new xml data file reader exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public XmlNotFoundException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}
