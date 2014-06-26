/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.beans;

/**
 * The Class Range.
 */
public class Range {

	/** The finish. */
	private Integer finish;

	/** The init. */
	private Integer init;

	/**
	 * Instantiates a new range.
	 */
	public Range() {

	}

	/**
	 * Instantiates a new range.
	 * 
	 * @param init
	 *            the init
	 * @param finish
	 *            the finish
	 */
	public Range(Integer init, Integer finish) {
		super();
		this.init = init;
		this.finish = finish;
	}

	/**
	 * Gets the finish.
	 * 
	 * @return the finish
	 */
	public Integer getFinish() {
		return finish;
	}

	/**
	 * Gets the inits the.
	 * 
	 * @return the inits the
	 */
	public Integer getInit() {
		return init;
	}

	/**
	 * Sets the finish.
	 * 
	 * @param finish
	 *            the new finish
	 */
	public void setFinish(Integer finish) {
		this.finish = finish;
	}

	/**
	 * Sets the inits the.
	 * 
	 * @param init
	 *            the new inits the
	 */
	public void setInit(Integer init) {
		this.init = init;
	}
}
