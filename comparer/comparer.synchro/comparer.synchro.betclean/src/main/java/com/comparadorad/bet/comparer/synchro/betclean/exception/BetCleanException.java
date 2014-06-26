package com.comparadorad.bet.comparer.synchro.betclean.exception;

public class BetCleanException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new removes the bets exception.
	 */
	public BetCleanException() {
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
	public BetCleanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new removes the bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public BetCleanException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new removes the bets exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public BetCleanException(Throwable arg0) {
		super(arg0);
	}

}
