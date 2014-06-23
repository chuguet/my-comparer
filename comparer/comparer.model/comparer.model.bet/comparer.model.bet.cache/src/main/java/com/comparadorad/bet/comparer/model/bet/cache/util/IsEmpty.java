/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.util;

/**
 * The Class IsEmpty.
 */
@SuppressWarnings("serial")
public class IsEmpty extends Exception {

	/**
	 * Instantiates a new checks if is empty.
	 */
	public IsEmpty() {
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param e
	 *            the e
	 */
	public IsEmpty(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param m
	 *            the m
	 * @param e
	 *            the e
	 */
	public IsEmpty(String m, Exception e) {
		super(m, e);
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param t
	 *            the t
	 */
	public IsEmpty(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param m
	 *            the m
	 */
	public IsEmpty(String m) {
		super(m);
	}

}
