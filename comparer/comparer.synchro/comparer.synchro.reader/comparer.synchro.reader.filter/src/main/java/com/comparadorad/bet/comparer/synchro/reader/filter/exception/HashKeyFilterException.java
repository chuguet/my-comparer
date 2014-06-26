package com.comparadorad.bet.comparer.synchro.reader.filter.exception;

@SuppressWarnings("serial")
public class HashKeyFilterException extends FilterException {
	
	/**
	 * Instantiates a new filter exception.
	 */
	public HashKeyFilterException(){
		super();
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 */
	public HashKeyFilterException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param e the e
	 */
	public HashKeyFilterException(Exception e){
		super(e);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param t the t
	 */
	public HashKeyFilterException(Throwable t){
		super(t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public HashKeyFilterException(String message,Throwable t){
		super(message,t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public HashKeyFilterException(String message,Exception e){
		super(message,e);
	}


}
