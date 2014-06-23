package com.comparadorad.bet.comparer.communication.email.exception;

public class EmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2432539672440223075L;

	/**
	 * Instantiates a new builds the email exception.
	 * 
	 * @param message
	 *            the message
	 */
	public EmailException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new builds the email exception.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 */
	public EmailException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Instantiates a new builds the email exception.
	 * 
	 * @param message
	 *            the message
	 * @param exception
	 *            the exception
	 */
	public EmailException(String message, Exception exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new builds the email exception.
	 * 
	 * @param exception
	 *            the exception
	 */
	public EmailException(Exception exception) {
		super(exception);
	}

}
