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
public class ValueSportCountryCompetitionEvent {

	/** The region. */
	@Field
	private Region region;

	/** The counter competitions. */
	@Field
	private Double counterCompetitions;

	/** The counter events. */
	@Field
	private Double counterEvents;

	/**
	 * Gets the counter competitions.
	 * 
	 * @return the counter competitions
	 */
	public Double getCounterCompetitions() {
		return counterCompetitions;
	}

	/**
	 * Sets the counter competitions.
	 * 
	 * @param counterCompetitions
	 *            the new counter competitions
	 */
	public void setCounterCompetitions(Double counterCompetitions) {
		this.counterCompetitions = counterCompetitions;
	}

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

	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Sets the region.
	 * 
	 * @param region
	 *            the new region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
}
