package com.comparadorad.bet.comparer.synchro.toolbar.filter.exception;

@SuppressWarnings("serial")
public class HashKeyToolbarFilterException extends ToolbarException {
	
	/**
	 * Instantiates a new filter exception.
	 */
	public HashKeyToolbarFilterException(){
		super();
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 */
	public HashKeyToolbarFilterException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param e the e
	 */
	public HashKeyToolbarFilterException(Exception e){
		super(e);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param t the t
	 */
	public HashKeyToolbarFilterException(Throwable t){
		super(t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public HashKeyToolbarFilterException(String message,Throwable t){
		super(message,t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public HashKeyToolbarFilterException(String message,Exception e){
		super(message,e);
	}


}
