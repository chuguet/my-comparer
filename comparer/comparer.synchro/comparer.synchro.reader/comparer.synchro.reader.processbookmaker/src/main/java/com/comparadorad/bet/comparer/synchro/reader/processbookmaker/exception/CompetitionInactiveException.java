/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class SportNotFoundException.
 */
@SuppressWarnings("serial")
public class CompetitionInactiveException extends InactiveElementException {

	/**
	 * Instantiates a new sport not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public CompetitionInactiveException(String message) {
		super(message);
	}

}
