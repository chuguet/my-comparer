package com.comparadorad.bet.comparer.dbsynchro.usertask.exception;

@SuppressWarnings("serial")
public class ExternalSystemException extends StateException {
	/**
	 * Instantiates a new client reader exception.
	 */
	public ExternalSystemException() {
		super();
	}


	/**
	 * Instantiates a new client reader exception.
	 *
	 * @param arg0 the arg0
	 */
	public ExternalSystemException(String arg0) {
		super(arg0);
	}


	/**
	 * Instantiates a new client reader exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public ExternalSystemException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new client reader exception.
	 *
	 * @param arg0 the arg0
	 */
	public ExternalSystemException(Throwable arg0) {
		super(arg0);
	}

}
