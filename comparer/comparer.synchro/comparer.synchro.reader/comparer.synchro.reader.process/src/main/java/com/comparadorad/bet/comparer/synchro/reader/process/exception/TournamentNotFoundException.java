/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.exception;

/**
 * The Class TournamentNotFoundException.
 */
@SuppressWarnings("serial")
public class TournamentNotFoundException extends NotFoundElementException {

	/**
	 * Instantiates a new tournament not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public TournamentNotFoundException(String message) {
		super(message);
	}

}
