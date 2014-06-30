/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.historic.exception;


/**
 * The Class FilterException.
 */
public class InvalidBenefitException extends SecureBetHistoricException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6148282645242811669L;

	/**
	 * Instantiates a new filter exception.
	 */
	public InvalidBenefitException(){
		super();
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 */
	public InvalidBenefitException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param e the e
	 */
	public InvalidBenefitException(Exception e){
		super(e);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param t the t
	 */
	public InvalidBenefitException(Throwable t){
		super(t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public InvalidBenefitException(String message,Throwable t){
		super(message,t);
	}
	
	/**
	 * Instantiates a new filter exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public InvalidBenefitException(String message,Exception e){
		super(message,e);
	}

}
