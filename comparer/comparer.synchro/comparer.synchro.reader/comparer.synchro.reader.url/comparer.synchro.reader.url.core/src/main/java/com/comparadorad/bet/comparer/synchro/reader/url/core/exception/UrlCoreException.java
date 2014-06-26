/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.core.exception;

/**
 * The Class UrlCoreException.
 */
@SuppressWarnings("serial")
public class UrlCoreException extends Exception {
	
	/**
	 * Instantiates a new url core exception.
	 */
	public UrlCoreException(){
		super();
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param exception the exception
	 */
	public UrlCoreException(Exception exception){
		super(exception);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param message the message
	 */
	public UrlCoreException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public UrlCoreException(String message,Exception exception){
		super(message,exception);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public UrlCoreException(String message,Throwable throwable){
		super(message,throwable);
	}
	
	/**
	 * Instantiates a new url core exception.
	 *
	 * @param throwable the throwable
	 */
	public UrlCoreException(Throwable throwable){
		super(throwable);
	}	

}
