/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.exception;

/**
 * The Class SportNotFoundException.
 */
@SuppressWarnings("serial")
public class MultipleSportFoundException extends MultipleElementException {

	/**
	 * Instantiates a new sport not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public MultipleSportFoundException(String message) {
		super(message);
	}

}
