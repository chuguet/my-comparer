/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.exception;

/**
 * The Class DateFormatException.
 */
@SuppressWarnings("serial")
public class DateFormatException extends RuntimeException {

	/**
	 * Instantiates a new date format exception.
	 */
	public DateFormatException() {
		super();
		
	}

	/**
	 * Instantiates a new date format exception.
	 *
	 * @param pArg0 the arg0
	 * @param pArg1 the arg1
	 */
	public DateFormatException(String pArg0, Throwable pArg1) {
		super(pArg0, pArg1);
		
	}

	/**
	 * Instantiates a new date format exception.
	 *
	 * @param pArg0 the arg0
	 */
	public DateFormatException(String pArg0) {
		super(pArg0);
		
	}

	/**
	 * Instantiates a new date format exception.
	 *
	 * @param pArg0 the arg0
	 */
	public DateFormatException(Throwable pArg0) {
		super(pArg0);
		
	}

}
