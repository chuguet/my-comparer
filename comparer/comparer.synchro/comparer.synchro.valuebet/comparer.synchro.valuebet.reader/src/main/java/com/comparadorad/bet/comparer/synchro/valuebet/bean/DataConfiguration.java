/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class DataConfiguration.
 */
@Component
public class DataConfiguration {

	/** The bet types. */
	@Value("${quantity.limit.bet}")
	private Integer quantityLimitBets;

	/** The quantity limit matchs. */
	@Value("${quantity.limit.matchs}")
	private Integer quantityLimitMatchs;

	/** The quantity percent bookmakers. */
	@Value("${quantity.limit.percentBookmaker}")
	private Integer quantityPercentBookmakers;

	/**
	 * Gets the quantity limit bets.
	 * 
	 * @return the quantity limit bets
	 */
	public Integer getQuantityLimitBets() {
		return quantityLimitBets;
	}

	/**
	 * Gets the quantity limit matchs.
	 * 
	 * @return the quantity limit matchs
	 */
	public Integer getQuantityLimitMatchs() {
		return quantityLimitMatchs;
	}

	/**
	 * Gets the quantity percent bookmakers.
	 * 
	 * @return the quantity percent bookmakers
	 */
	public Integer getQuantityPercentBookmakers() {
		return quantityPercentBookmakers;
	}

	/**
	 * Sets the quantity limit bets.
	 * 
	 * @param quantityLimitBets
	 *            the new quantity limit bets
	 */
	public void setQuantityLimitBets(Integer quantityLimitBets) {
		this.quantityLimitBets = quantityLimitBets;
	}

	/**
	 * Sets the quantity limit matchs.
	 * 
	 * @param pQuantityLimitMatchs
	 *            the new quantity limit matchs
	 */
	public void setQuantityLimitMatchs(Integer pQuantityLimitMatchs) {
		quantityLimitMatchs = pQuantityLimitMatchs;
	}

	/**
	 * Sets the quantity percent bookmakers.
	 * 
	 * @param quantityPercentBookmakers
	 *            the new quantity percent bookmakers
	 */
	public void setQuantityPercentBookmakers(Integer quantityPercentBookmakers) {
		this.quantityPercentBookmakers = quantityPercentBookmakers;
	}

}
