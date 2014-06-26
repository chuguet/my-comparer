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
public class XmlDataFileReaderException extends Exception {

	/**
	 * Instantiates a new xml data file reader exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public XmlDataFileReaderException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}
