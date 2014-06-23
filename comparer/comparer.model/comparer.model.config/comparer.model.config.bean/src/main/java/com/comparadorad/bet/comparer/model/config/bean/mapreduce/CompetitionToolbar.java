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
 * The Class CompetitionToolbar.
 */
public class CompetitionToolbar extends AbstractBeanMapReduce {

	/** The value. */
	@Field
	private CompetitionToolbarValue value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public CompetitionToolbarValue getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(CompetitionToolbarValue value) {
		this.value = value;
	}
}
