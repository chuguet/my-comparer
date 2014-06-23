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
 * The Class ValueCountryCompetitionEvent.
 */
public class ValueCountryCompetitionEvent extends AbstractValue {

	/** The counter. */
	@Field
	private Double counter;

	/**
	 * Gets the counter.
	 * 
	 * @return the counter
	 */
	public Double getCounter() {
		return counter;
	}

	/**
	 * Sets the counter.
	 * 
	 * @param counter
	 *            the new counter
	 */
	public void setCounter(Double counter) {
		this.counter = counter;
	}

}
