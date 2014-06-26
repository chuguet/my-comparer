/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception;

/**
 * The Class NoParameterException.
 */
@SuppressWarnings("serial")
public class NoParameterException extends UrlParameterException {
	


	/**
	 * Instantiates a new no parameter exception.
	 */
	public NoParameterException() {
		super();
	}


	/**
	 * Instantiates a new no parameter exception.
	 *
	 * @param exception the exception
	 */
	public NoParameterException(Exception exception) {
		super(exception);
	}



	/**
	 * Instantiates a new no parameter exception.
	 *
	 * @param message the message
	 */
	public NoParameterException(String message) {
		super(message);
	}


	/**
	 * Instantiates a new no parameter exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public NoParameterException(String message, Exception exception) {
		super(message, exception);
	}



	/**
	 * Instantiates a new no parameter exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public NoParameterException(String message, Throwable throwable) {
		super(message, throwable);
	}


	/**
	 * Instantiates a new no parameter exception.
	 *
	 * @param throwable the throwable
	 */
	public NoParameterException(Throwable throwable) {
		super(throwable);
	}



}
