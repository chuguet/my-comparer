/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception;

/**
 * The Class UrlParameterException.
 */
@SuppressWarnings("serial")
public class UrlParameterException extends Exception {
	

	/**
	 * Instantiates a new url parameter exception.
	 */
	public UrlParameterException() {
		super();
	}


	/**
	 * Instantiates a new url parameter exception.
	 *
	 * @param exception the exception
	 */
	public UrlParameterException(Exception exception) {
		super(exception);
	}


	/**
	 * Instantiates a new url parameter exception.
	 *
	 * @param message the message
	 */
	public UrlParameterException(String message) {
		super(message);
	}


	/**
	 * Instantiates a new url parameter exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public UrlParameterException(String message, Exception exception) {
		super(message, exception);
	}


	/**
	 * Instantiates a new url parameter exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public UrlParameterException(String message, Throwable throwable) {
		super(message, throwable);
	}


	/**
	 * Instantiates a new url parameter exception.
	 *
	 * @param throwable the throwable
	 */
	public UrlParameterException(Throwable throwable) {
		super(throwable);
	}


}
