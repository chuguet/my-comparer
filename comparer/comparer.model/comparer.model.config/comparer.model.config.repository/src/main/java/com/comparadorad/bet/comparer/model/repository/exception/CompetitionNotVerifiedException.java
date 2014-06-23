/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository.exception;

/**
 * The Class SportNotFoundException.
 */
@SuppressWarnings("serial")
public class CompetitionNotVerifiedException extends Exception {

	/**
	 * Instantiates a new sport not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public CompetitionNotVerifiedException(String message) {
		super(message);
	}

}
