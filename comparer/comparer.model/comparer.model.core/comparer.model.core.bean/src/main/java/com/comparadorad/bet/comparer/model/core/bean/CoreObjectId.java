/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;

/**
 * The Class CoreObjectId.
 */
@SuppressWarnings("serial")
public class CoreObjectId implements Serializable {

	/** The id. */
	@Id
	private BigInteger internalId;

	/**
	 * Gets the internal id.
	 * 
	 * @return the internal id
	 */
	public BigInteger getInternalId() {
		return internalId;
	}

	/**
	 * Sets the internal id.
	 * 
	 * @param pInternalId
	 *            the new internal id
	 */
	public void setInternalId(BigInteger pInternalId) {
		internalId = pInternalId;
	}

}
