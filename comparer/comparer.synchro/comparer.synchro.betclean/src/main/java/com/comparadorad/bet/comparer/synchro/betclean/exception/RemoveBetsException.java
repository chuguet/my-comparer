/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.exception;

/**
 * The Class RemoveBetsException.
 */
public class RemoveBetsException extends BetCleanException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1096861259466599728L;

	/**
	 * Instantiates a new removes the bets exception.
	 */
	public RemoveBetsException() {
		super();
	}

	/**
	 * Instantiates a new removes the bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 */
	public RemoveBetsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new removes the bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public RemoveBetsException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new removes the bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public RemoveBetsException(Throwable arg0) {
		super(arg0);
	}
}
