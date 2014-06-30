/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.historic.exception;

/**
 * Clase encargada de encapsular los errores provocados por el historico de
 * apuesta segura.
 * 
 * The Class SecureBetHistoricException.
 */
public class SecureBetHistoricException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8164232118450497798L;

	/**
	 * Instantiates a new secure bet historic exception.
	 */
	public SecureBetHistoricException() {
		super();
	}

	/**
	 * Instantiates a new secure bet historic exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public SecureBetHistoricException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new secure bet historic exception.
	 * 
	 * @param message
	 *            the message
	 */
	public SecureBetHistoricException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new secure bet historic exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public SecureBetHistoricException(Throwable cause) {
		super(cause);
	}

}
