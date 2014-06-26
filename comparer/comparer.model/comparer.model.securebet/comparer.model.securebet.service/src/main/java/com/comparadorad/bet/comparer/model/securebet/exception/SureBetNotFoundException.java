/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.exception;


/**
 * The Class SureBetNotFoundException.
 */
@SuppressWarnings("serial")
public class SureBetNotFoundException extends Exception {
	

	
	/**
	 * Instantiates a new sure bet not found exception.
	 */
	public SureBetNotFoundException() {
		super();
	}


	
	/**
	 * Instantiates a new sure bet not found exception.
	 *
	 * @param exception the exception
	 */
	public SureBetNotFoundException(Exception exception) {
		super(exception);
	}


	
	/**
	 * Instantiates a new sure bet not found exception.
	 *
	 * @param message the message
	 */
	public SureBetNotFoundException(String message) {
		super(message);
	}


	
	/**
	 * Instantiates a new sure bet not found exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public SureBetNotFoundException(String message, Exception exception) {
		super(message, exception);
	}


	
	/**
	 * Instantiates a new sure bet not found exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public SureBetNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}


	
	/**
	 * Instantiates a new sure bet not found exception.
	 *
	 * @param throwable the throwable
	 */
	public SureBetNotFoundException(Throwable throwable) {
		super(throwable);
	}


}
