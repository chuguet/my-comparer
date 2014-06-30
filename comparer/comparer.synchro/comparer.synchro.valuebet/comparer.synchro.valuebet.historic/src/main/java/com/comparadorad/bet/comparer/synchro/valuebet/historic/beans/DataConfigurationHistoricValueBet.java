/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.historic.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class DataConfiguration.
 */
@Component
public class DataConfigurationHistoricValueBet {

	/** The limit value bets. */
	@Value("${limit.valuebets}")
	private Integer limitValueBets;

	/**
	 * Gets the limit value bets.
	 * 
	 * @return the limit value bets
	 */
	public Integer getLimitValueBets() {
		return limitValueBets;
	}

	/**
	 * Sets the limit value bets.
	 * 
	 * @param limitValueBets
	 *            the new limit value bets
	 */
	public void setLimitValueBets(Integer limitValueBets) {
		this.limitValueBets = limitValueBets;
	}
}
