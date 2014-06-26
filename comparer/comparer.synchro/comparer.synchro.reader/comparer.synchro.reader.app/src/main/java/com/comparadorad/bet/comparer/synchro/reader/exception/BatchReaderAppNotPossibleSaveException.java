/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.exception;

/**
 * The Class BatchReaderAppNotPossibleSaveException.
 */
@SuppressWarnings("serial")
public class BatchReaderAppNotPossibleSaveException extends BatchReaderAppException {
	
	/**
	 * Instantiates a new batch reader app not possible save exception.
	 */
	public BatchReaderAppNotPossibleSaveException(){
		super();
	}
	

	/**
	 * Instantiates a new batch reader app not possible save exception.
	 *
	 * @param message the message
	 */
	public BatchReaderAppNotPossibleSaveException(String message){
		super(message);
	}
	

	/**
	 * Instantiates a new batch reader app not possible save exception.
	 *
	 * @param exception the exception
	 */
	public BatchReaderAppNotPossibleSaveException(Exception exception){
		super(exception);
	}
	

	/**
	 * Instantiates a new batch reader app not possible save exception.
	 *
	 * @param throwable the throwable
	 */
	public BatchReaderAppNotPossibleSaveException(Throwable throwable ){
		super(throwable);
	}
	

	/**
	 * Instantiates a new batch reader app not possible save exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public BatchReaderAppNotPossibleSaveException(String message, Exception exception){
		super(message,exception);
	}
	

	/**
	 * Instantiates a new batch reader app not possible save exception.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public BatchReaderAppNotPossibleSaveException(String message, Throwable throwable){
		super(message,throwable);
	}


}
