/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.io.Serializable;

/**
 * The Class BmInternalId.
 */
@SuppressWarnings("serial")
public class BmInternalId implements Serializable {

	/** The value. */
	private String value;

	/**
	 * Instantiates a new bm internal id.
	 */
	public BmInternalId() {
		super();
	}

	/**
	 * Instantiates a new bm internal id.
	 * 
	 * @param pValue
	 *            the value
	 */
	public BmInternalId(final String pValue) {
		super();
		value = pValue;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}