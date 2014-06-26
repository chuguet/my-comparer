/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.exception;

/**
 * The Class BatchReaderAppParameterException.
 */
@SuppressWarnings("serial")
public class BatchReaderAppParameterException extends Exception  {
	
	/**
	 * Instantiates a new batch reader exception.
	 */
	public BatchReaderAppParameterException(){
		super();
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param message the message
	 */
	public BatchReaderAppParameterException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param exception the exception
	 */
	public BatchReaderAppParameterException(Exception exception){
		super(exception);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param throwable the throwable
	 */
	public BatchReaderAppParameterException(Throwable throwable ){
		super(throwable);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public BatchReaderAppParameterException(String message, Exception exception){
		super(message,exception);
	}
	
	/**
	 * Instantiates a new batch reader exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public BatchReaderAppParameterException(String message, Throwable throwable){
		super(message,throwable);
	}

}
