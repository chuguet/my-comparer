/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.exception;

/**
 * The Class FilterException.
 */
@SuppressWarnings("serial")
public class ToolbarException extends Exception {
	
	/**
	 * Instantiates a new filter exception.
	 */
	public ToolbarException(){
		super();
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 */
	public ToolbarException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param e the e
	 */
	public ToolbarException(Exception e){
		super(e);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param t the t
	 */
	public ToolbarException(Throwable t){
		super(t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public ToolbarException(String message,Throwable t){
		super(message,t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public ToolbarException(String message,Exception e){
		super(message,e);
	}

}
