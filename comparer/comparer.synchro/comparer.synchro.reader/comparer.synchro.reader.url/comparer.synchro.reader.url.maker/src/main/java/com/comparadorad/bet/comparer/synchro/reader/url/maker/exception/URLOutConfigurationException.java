package com.comparadorad.bet.comparer.synchro.reader.url.maker.exception;

@SuppressWarnings("serial")
public class URLOutConfigurationException extends CoreUrlMakerException {

	/**
	 * Instantiates a new url core exception.
	 */
	public URLOutConfigurationException() {
		super();
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param exception
	 *            the exception
	 */
	public URLOutConfigurationException(Exception exception) {
		super(exception);
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param message
	 *            the message
	 */
	public URLOutConfigurationException(String message) {
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
	public URLOutConfigurationException(String message, Exception exception) {
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
	public URLOutConfigurationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Instantiates a new url core exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public URLOutConfigurationException(Throwable throwable) {
		super(throwable);
	}

}
