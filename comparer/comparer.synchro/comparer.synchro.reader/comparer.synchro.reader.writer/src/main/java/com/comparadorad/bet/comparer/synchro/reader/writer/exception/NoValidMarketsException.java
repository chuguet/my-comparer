/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.exception;

/**
 * The Class NoValidMarketsException.
 */
@SuppressWarnings("serial")
public class NoValidMarketsException extends SynchroMatchWriterServiceException {

	/**
	 * Instantiates a new no valid markets exception.
	 */
	public NoValidMarketsException() {
		super();
	}

	/**
	 * Instantiates a new no valid markets exception.
	 * 
	 * @param message
	 *            the message
	 */
	public NoValidMarketsException(String message) {
		super(message);
	}

}