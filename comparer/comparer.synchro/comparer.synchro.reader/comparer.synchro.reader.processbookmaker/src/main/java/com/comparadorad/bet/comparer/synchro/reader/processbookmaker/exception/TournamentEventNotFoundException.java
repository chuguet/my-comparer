/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception;

/**
 * The Class TournamentNotFoundException.
 */
@SuppressWarnings("serial")
public class TournamentEventNotFoundException extends NotFoundElementException {

	/**
	 * Instantiates a new tournament not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public TournamentEventNotFoundException(String message) {
		super(message);
	}

}
