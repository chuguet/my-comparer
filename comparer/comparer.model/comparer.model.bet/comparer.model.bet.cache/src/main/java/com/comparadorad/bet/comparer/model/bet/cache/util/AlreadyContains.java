package com.comparadorad.bet.comparer.model.bet.cache.util;

@SuppressWarnings("serial")
public class AlreadyContains extends Exception {
	/**
	 * Instantiates a new checks if is empty.
	 */
	public AlreadyContains() {
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param e
	 *            the e
	 */
	public AlreadyContains(Exception e) {
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
	public AlreadyContains(String m, Exception e) {
		super(m, e);
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param t
	 *            the t
	 */
	public AlreadyContains(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new checks if is empty.
	 * 
	 * @param m
	 *            the m
	 */
	public AlreadyContains(String m) {
		super(m);
	}
}
