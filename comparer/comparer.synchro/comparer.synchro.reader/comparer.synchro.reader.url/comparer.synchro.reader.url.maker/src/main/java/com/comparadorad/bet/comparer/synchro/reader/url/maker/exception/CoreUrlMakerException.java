package com.comparadorad.bet.comparer.synchro.reader.url.maker.exception;

import com.comparadorad.bet.comparer.synchro.reader.url.core.exception.UrlCoreException;

@SuppressWarnings("serial")
public class CoreUrlMakerException extends UrlCoreException {
	
	
	/**
	 * Instantiates a new url core exception.
	 */
	public CoreUrlMakerException(){
		super();
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param exception the exception
	 */
	public CoreUrlMakerException(Exception exception){
		super(exception);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param message the message
	 */
	public CoreUrlMakerException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public CoreUrlMakerException(String message,Exception exception){
		super(message,exception);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public CoreUrlMakerException(String message,Throwable throwable){
		super(message,throwable);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param throwable the throwable
	 */
	public CoreUrlMakerException(Throwable throwable){
		super(throwable);
	}	

}
