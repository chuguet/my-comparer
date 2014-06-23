package com.comparadorad.bet.comparer.dbsynchro.usertask.exception;

@SuppressWarnings("serial")
public class InternalSystemException extends StateException {
	
	/**
	 * Instantiates a new client reader exception.
	 */
	public InternalSystemException() {
		super();
	}


	/**
	 * Instantiates a new client reader exception.
	 *
	 * @param arg0 the arg0
	 */
	public InternalSystemException(String arg0) {
		super(arg0);
	}


	/**
	 * Instantiates a new client reader exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public InternalSystemException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new client reader exception.
	 *
	 * @param arg0 the arg0
	 */
	public InternalSystemException(Throwable arg0) {
		super(arg0);
	}


}
