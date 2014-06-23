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
 * The Class CountryLVLCompetitionLongTerm.
 */
public class CountryCompetitionEvent extends AbstractBeanMapReduce {

	/** The value. */
	@Field
	private ValueCountryCompetitionEvent value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public ValueCountryCompetitionEvent getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(ValueCountryCompetitionEvent value) {
		this.value = value;
	}
}
