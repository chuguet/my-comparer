/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.mapreduce;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class SportToolbar.
 */
public class SportToolbar extends AbstractBeanMapReduce {

	/** The value. */
	@Field
	private SportToolbarValue value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public SportToolbarValue getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(SportToolbarValue value) {
		this.value = value;
	}
}
