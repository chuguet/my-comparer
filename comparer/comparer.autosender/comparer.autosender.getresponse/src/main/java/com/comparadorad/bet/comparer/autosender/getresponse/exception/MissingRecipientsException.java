/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.exception;

/**
 * The Class MissingRecipientsException.
 */
@SuppressWarnings("serial")
public class MissingRecipientsException extends GetResponseException {
	
	/**
	 * Instantiates a new missing recipients exception.
	 */
	public MissingRecipientsException() {
		super();
	}


	/**
	 * Instantiates a new missing recipients exception.
	 *
	 * @param arg0 the arg0
	 */
	public MissingRecipientsException(String arg0) {
		super(arg0);
	}


	/**
	 * Instantiates a new missing recipients exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public MissingRecipientsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new missing recipients exception.
	 *
	 * @param arg0 the arg0
	 */
	public MissingRecipientsException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * Instantiates a new missing recipients exception.
	 *
	 * @param exception the exception
	 */
	public MissingRecipientsException(Exception exception){
		super(exception);
	}


}
