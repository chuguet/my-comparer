/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.exception;

/**
 * The Class FilterException.
 */
@SuppressWarnings("serial")
public class FilterException extends Exception {
	
	/**
	 * Instantiates a new filter exception.
	 */
	public FilterException(){
		super();
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 */
	public FilterException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param e the e
	 */
	public FilterException(Exception e){
		super(e);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param t the t
	 */
	public FilterException(Throwable t){
		super(t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public FilterException(String message,Throwable t){
		super(message,t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public FilterException(String message,Exception e){
		super(message,e);
	}

}
