/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.enume;

/**
 * The Enum MessageAndError.
 */
public enum MessageAndError {

	/** The MISSIN g_ recipients. */
	MISSING_RECIPIENTS("Missing recipients",-1);

	/** The message. */
	private String message;

	/** The code. */
	private Integer code;

	/**
	 * Instantiates a new message and error.
	 *
	 * @param message the message
	 * @param code the code
	 */
	private MessageAndError(String message, Integer code) {
		this.message = message;
		this.code = code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

}
