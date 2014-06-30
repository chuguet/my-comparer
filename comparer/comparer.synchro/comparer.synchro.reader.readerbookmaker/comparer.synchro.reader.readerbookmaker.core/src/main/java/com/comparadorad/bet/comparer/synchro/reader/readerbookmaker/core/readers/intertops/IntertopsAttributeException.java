/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.intertops;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Class IntertopsAttributeException.
 */
@SuppressWarnings("serial")
public class IntertopsAttributeException extends XmlReaderException {

	/**
	 * Instantiates a new intertops attribute exception.
	 */
	public IntertopsAttributeException() {
	}

	/**
	 * Instantiates a new intertops attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 */
	public IntertopsAttributeException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Instantiates a new intertops attribute exception.
	 * 
	 * @param pMessage
	 *            the message
	 * @param pCause
	 *            the cause
	 */
	public IntertopsAttributeException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	/**
	 * Instantiates a new intertops attribute exception.
	 * 
	 * @param pCause
	 *            the cause
	 */
	public IntertopsAttributeException(Throwable pCause) {
		super(pCause);
	}

}
