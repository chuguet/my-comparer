/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import com.comparadorad.bet.comparer.model.bet.bean.hashkey.AbstractHashKey;

/**
 * The Interface IHashKey.
 * 
 * @param <T>
 *            the generic type
 */
public interface IHashKey<T extends IRtData> {

	/**
	 * Gets the abstract key.
	 * 
	 * @return the abstract key
	 */
	AbstractHashKey<T> getAbstractKey();

	/**
	 * Gets the hash key.
	 * 
	 * @return the hash key
	 */
	String getHashKey();

}
