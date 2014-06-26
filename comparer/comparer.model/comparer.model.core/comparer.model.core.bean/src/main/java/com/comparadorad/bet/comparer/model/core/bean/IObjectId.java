/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.math.BigInteger;

/**
 * The Interface IObjectId.
 */
public interface IObjectId {

	/**
	 * Gets the object id.
	 * 
	 * @return the object id
	 */
	BigInteger getObjectId();

	/**
	 * Sets the object id.
	 * 
	 * @param pBigInteger
	 *            the new object id
	 */
	void setObjectId(BigInteger pBigInteger);

	/**
	 * Sets the object id.
	 * 
	 * @param pCoreObjectId
	 *            the new object id
	 */
	void setObjectId(String pCoreObjectId);
}
