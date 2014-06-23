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
 * The Class SportToolbarValue.
 */
public class SportToolbarValue {

	/** The counter events. */
	@Field
	private Double counterEvents;

	/**
	 * Gets the counter events.
	 * 
	 * @return the counter events
	 */
	public Double getCounterEvents() {
		return counterEvents;
	}

	/**
	 * Sets the counter events.
	 * 
	 * @param counterEvents
	 *            the new counter events
	 */
	public void setCounterEvents(Double counterEvents) {
		this.counterEvents = counterEvents;
	}

}
