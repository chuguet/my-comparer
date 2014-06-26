/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.exception;

/**
 * The Class BatchReaderException.
 */
@SuppressWarnings("serial")
public class BatchReaderAppException extends Exception {
	
	/**
	 * Instantiates a new batch reader exception.
	 */
	public BatchReaderAppException(){
		super();
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param message the message
	 */
	public BatchReaderAppException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param exception the exception
	 */
	public BatchReaderAppException(Exception exception){
		super(exception);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param throwable the throwable
	 */
	public BatchReaderAppException(Throwable throwable ){
		super(throwable);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public BatchReaderAppException(String message, Exception exception){
		super(message,exception);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public BatchReaderAppException(String message, Throwable throwable){
		super(message,throwable);
	}
	
	

}
