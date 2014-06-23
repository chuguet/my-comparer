/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.mapreduce.beans;

import java.util.Date;
import java.util.List;

/**
 * The Class NextEvent.
 */
public class NextEvent {

	/** The date. */
	private Date date;

	/** The markets. */
	private List<MarketNextEvent> markets;

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the markets.
	 * 
	 * @return the markets
	 */
	public List<MarketNextEvent> getMarkets() {
		return markets;
	}

	/**
	 * Sets the markets.
	 * 
	 * @param markets
	 *            the new markets
	 */
	public void setMarkets(List<MarketNextEvent> markets) {
		this.markets = markets;
	}
}
