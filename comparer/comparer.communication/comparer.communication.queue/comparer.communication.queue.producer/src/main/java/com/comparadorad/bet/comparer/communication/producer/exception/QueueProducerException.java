/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer.exception;

/**
 * The Class QueueProducerException.
 */
@SuppressWarnings("serial")
public class QueueProducerException extends Exception {
	
	
	/**
	 * Instantiates a new queue producer exception.
	 *
	 * @param message the message
	 */
	public QueueProducerException(String message){
		super(message);
	}
	

	/**
	 * Instantiates a new queue producer exception.
	 *
	 * @param t the t
	 */
	public QueueProducerException(Throwable t){
		super(t);
	}
	

	/**
	 * Instantiates a new queue producer exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public QueueProducerException(String message, Throwable t){
		super(message, t);
	}
	

	/**
	 * Instantiates a new queue producer exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public QueueProducerException(String message, Exception e){
		super(message, e);
	}

	/**
	 * Instantiates a new queue producer exception.
	 *
	 * @param e the e
	 */
	public QueueProducerException(Exception e){
		super(e);
	}
	

}
