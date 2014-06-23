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
 * The Class SportCountryCompetitionEvent.
 */
public class SportCountryCompetitionEvent extends AbstractBeanMapReduce {

	/** The value. */
	@Field
	private ValueSportCountryCompetitionEvent value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public ValueSportCountryCompetitionEvent getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(ValueSportCountryCompetitionEvent value) {
		this.value = value;
	}
}
