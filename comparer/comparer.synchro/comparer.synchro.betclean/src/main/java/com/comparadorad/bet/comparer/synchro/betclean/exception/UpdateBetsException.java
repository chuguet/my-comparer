/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.exception;

/**
 * The Class UpdateBetsException.
 */
public class UpdateBetsException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7312458312699593658L;

	/**
	 * Instantiates a new update bets exception.
	 */
	public UpdateBetsException() {
		super();
	}

	/**
	 * Instantiates a new update bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 */
	public UpdateBetsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new update bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public UpdateBetsException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new update bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public UpdateBetsException(Throwable arg0) {
		super(arg0);
	}
}
