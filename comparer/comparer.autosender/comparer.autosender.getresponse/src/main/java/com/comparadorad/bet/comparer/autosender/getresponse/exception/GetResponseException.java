/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.exception;

/**
 * The Class GetResponseException.
 */
@SuppressWarnings("serial")
public class GetResponseException extends Exception{
	

	/**
	 * Instantiates a new gets the response exception.
	 */
	public GetResponseException() {
		super();
	}

	/**
	 * Instantiates a new gets the response exception.
	 *
	 * @param arg0 the arg0
	 */
	public GetResponseException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new gets the response exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public GetResponseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new gets the response exception.
	 *
	 * @param arg0 the arg0
	 */
	public GetResponseException(Throwable arg0) {
		super(arg0);
	}


	
}
