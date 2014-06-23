/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.exception;

/**
 * The Class InvalidEncodingMessageGetResponseException.
 */
@SuppressWarnings("serial")
public class InvalidEncodingMessageGetResponseException extends GetResponseException{

	/**
	 * Instantiates a new invalid encoding message get response exception.
	 */
	public InvalidEncodingMessageGetResponseException() {
		super();
	}

	/**
	 * Instantiates a new invalid encoding message get response exception.
	 *
	 * @param arg0 the arg0
	 */
	public InvalidEncodingMessageGetResponseException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiates a new invalid encoding message get response exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public InvalidEncodingMessageGetResponseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiates a new invalid encoding message get response exception.
	 *
	 * @param arg0 the arg0
	 */
	public InvalidEncodingMessageGetResponseException(Throwable arg0) {
		super(arg0);
	}

}
