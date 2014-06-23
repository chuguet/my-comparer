/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.util;

/**
 * The Interface Queue.
 * 
 * @param <T>
 *            the generic type
 */
public interface Queue<T> {

	/**
	 * Pop.
	 * 
	 * @return the t
	 * @throws IsEmpty
	 *             the is empty
	 */
	T pop() throws IsEmpty;

	/**
	 * Push.
	 * 
	 * @param t
	 *            the t
	 * @throws AlreadyContains
	 *             the already contains
	 */
	void push(T t) throws AlreadyContains;

}
