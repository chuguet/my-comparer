/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.exception;

/**
 * The Class BuildEmailException.
 */
public class BuildEmailException extends EmailException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param message the message
	 */
	public BuildEmailException( String message ){
		super(message);
	}
	
	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public BuildEmailException(String message,Throwable throwable ){
		super(message,throwable);
	}	
	
	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public BuildEmailException(String message,Exception exception ){
		super(message,exception);
	}
	
	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param exception the exception
	 */
	public BuildEmailException(Exception exception ){
		super(exception);
	}	

}
