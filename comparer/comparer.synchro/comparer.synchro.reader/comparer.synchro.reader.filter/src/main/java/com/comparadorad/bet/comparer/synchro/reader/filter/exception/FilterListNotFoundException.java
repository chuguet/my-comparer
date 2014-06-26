package com.comparadorad.bet.comparer.synchro.reader.filter.exception;

@SuppressWarnings("serial")
public class FilterListNotFoundException extends FilterException {

	/**
	 * Instantiates a new filter exception.
	 */
	public FilterListNotFoundException() {
		super();
	}

	/**
	 * Instantiates a new filter exception.
	 * 
	 * @param message
	 *            the message
	 */
	public FilterListNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new filter exception.
	 * 
	 * @param e
	 *            the e
	 */
	public FilterListNotFoundException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new filter exception.
	 * 
	 * @param t
	 *            the t
	 */
	public FilterListNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new filter exception.
	 * 
	 * @param message
	 *            the message
	 * @param t
	 *            the t
	 */
	public FilterListNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	/**
	 * Instantiates a new filter exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public FilterListNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
