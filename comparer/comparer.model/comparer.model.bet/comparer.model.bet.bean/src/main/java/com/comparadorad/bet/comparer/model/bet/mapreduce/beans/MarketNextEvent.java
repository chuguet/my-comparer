/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.mapreduce.beans;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class MarketNextEvent.
 */
public class MarketNextEvent {

	/** The num bets. */
	@Field
	private Double numBets;

	/**
	 * Gets the num bets.
	 * 
	 * @return the num bets
	 */
	public Double getNumBets() {
		return numBets;
	}

	/**
	 * Sets the num bets.
	 * 
	 * @param numBets
	 *            the new num bets
	 */
	public void setNumBets(Double numBets) {
		this.numBets = numBets;
	}

}
