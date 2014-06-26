/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.exception;

/**
 * The Class FilterNotFoundException.
 */
@SuppressWarnings("serial")
public class FilterNotFoundException extends FilterException {
	
	

	/**
	 * Instantiates a new filter not found exception.
	 */
	public FilterNotFoundException(){
		super();
	}
	

	/**
	 * Instantiates a new filter not found exception.
	 *
	 * @param message the message
	 */
	public FilterNotFoundException(String message){
		super(message);
	}
	

	/**
	 * Instantiates a new filter not found exception.
	 *
	 * @param e the e
	 */
	public FilterNotFoundException(Exception e){
		super(e);
	}
	

	/**
	 * Instantiates a new filter not found exception.
	 *
	 * @param t the t
	 */
	public FilterNotFoundException(Throwable t){
		super(t);
	}
	

	/**
	 * Instantiates a new filter not found exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public FilterNotFoundException(String message,Throwable t){
		super(message,t);
	}
	

	/**
	 * Instantiates a new filter not found exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public FilterNotFoundException(String message,Exception e){
		super(message,e);
	}


}
