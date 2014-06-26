/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.exception;

/**
 * The Class TeamNotFoundException.
 */
@SuppressWarnings("serial")
public class TeamNotFoundException extends NotFoundElementException {

	/**
	 * Instantiates a new team not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public TeamNotFoundException(String message) {
		super(message);
	}

}
