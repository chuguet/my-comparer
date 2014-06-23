/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.exception;

/**
 * The Class InvalidBeanException.
 */
@SuppressWarnings("serial")
public class InvalidBeanException extends GetResponseException{

	/**
	 * Instantiates a new invalid bean exception.
	 */
	public InvalidBeanException() {
		super();
	}

	/**
	 * Instantiates a new invalid bean exception.
	 *
	 * @param arg0 the arg0
	 */
	public InvalidBeanException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new invalid bean exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public InvalidBeanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new invalid bean exception.
	 *
	 * @param arg0 the arg0
	 */
	public InvalidBeanException(Throwable arg0) {
		super(arg0);
	}	

}
