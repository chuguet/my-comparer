package com.comparadorad.bet.comparer.communication.email.exception;

public class ShippingEmailException extends EmailException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param message the message
	 */
	public ShippingEmailException( String message ){
		super(message);
	}
	
	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public ShippingEmailException(String message,Throwable throwable ){
		super(message,throwable);
	}
	
	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public ShippingEmailException(String message,Exception exception ){
		super(message,exception);
	}
	
	/**
	 * Instantiates a new builds the email exception.
	 *
	 * @param exception the exception
	 */
	public ShippingEmailException(Exception exception ){
		super(exception);
	}
	
	

}
