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
public class ParticipantInactiveException extends InactiveElementException {

	/**
	 * Instantiates a new sport not found exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ParticipantInactiveException(String message) {
		super(message);
	}

}
