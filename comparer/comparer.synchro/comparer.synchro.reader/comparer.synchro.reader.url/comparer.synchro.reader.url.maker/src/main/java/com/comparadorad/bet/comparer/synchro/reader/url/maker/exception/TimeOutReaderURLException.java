/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.exception;

import com.comparadorad.bet.comparer.synchro.reader.url.core.exception.UrlCoreException;

/**
 * The Class TimeOutReaderURLException.
 */
@SuppressWarnings("serial")
public class TimeOutReaderURLException extends UrlCoreException {

	/** The date differences. */
	private Long dateDifferences;

	/**
	 * Instantiates a new url core exception.
	 */
	public TimeOutReaderURLException() {
		super();
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param exception
	 *            the exception
	 */
	public TimeOutReaderURLException(Exception exception) {
		super(exception);
	}

	/**
	 * Instantiates a new time out reader url exception.
	 * 
	 * @param exception
	 *            the exception
	 * @param dateDifferences
	 *            the date differences
	 */
	public TimeOutReaderURLException(Exception exception, Long dateDifferences) {
		super(exception);
		this.dateDifferences = dateDifferences;
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param message
	 *            the message
	 */
	public TimeOutReaderURLException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param message
	 *            the message
	 * @param exception
	 *            the exception
	 */
	public TimeOutReaderURLException(String message, Exception exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 */
	public TimeOutReaderURLException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public TimeOutReaderURLException(String message, Long dateDifferences) {
		super(message);
		this.dateDifferences = dateDifferences;
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public TimeOutReaderURLException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Gets the date differences.
	 * 
	 * @return the date differences
	 */
	public Long getDateDifferences() {
		return dateDifferences;
	}

	/**
	 * Sets the date differences.
	 * 
	 * @param dateDifferences
	 *            the new date differences
	 */
	public void setDateDifferences(Long dateDifferences) {
		this.dateDifferences = dateDifferences;
	}

}
