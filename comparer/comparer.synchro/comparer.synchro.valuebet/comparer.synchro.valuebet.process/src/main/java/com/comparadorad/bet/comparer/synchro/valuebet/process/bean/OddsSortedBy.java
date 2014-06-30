/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.bean;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class OddsSortedBy.
 */
public class OddsSortedBy implements ISearchBean {

	/** The bets. */
	private List<RtBet> bets;

	/** The final value. */
	private Double finalValue;

	/** The mean. */
	private Double mean;

	/** The probability. */
	private Double probability;

	/**
	 * Gets the bets.
	 * 
	 * @return the bets
	 */
	public List<RtBet> getBets() {
		return bets;
	}

	/**
	 * Gets the final value.
	 * 
	 * @return the final value
	 */
	public Double getFinalValue() {
		return finalValue;
	}

	/**
	 * Gets the mean.
	 * 
	 * @return the mean
	 */
	public Double getMean() {
		return mean;
	}

	/**
	 * Gets the probability.
	 * 
	 * @return the probability
	 */
	public Double getProbability() {
		return probability;
	}

	/**
	 * Sets the bets.
	 * 
	 * @param pBets
	 *            the new bets
	 */
	public void setBets(List<RtBet> pBets) {
		bets = pBets;
	}

	/**
	 * Sets the final value.
	 * 
	 * @param pFinalValue
	 *            the new final value
	 */
	public void setFinalValue(Double pFinalValue) {
		finalValue = pFinalValue;
	}

	/**
	 * Sets the mean.
	 * 
	 * @param mean
	 *            the new mean
	 */
	public void setMean(Double mean) {
		this.mean = mean;
	}

	/**
	 * Sets the probability.
	 * 
	 * @param pProbability
	 *            the new probability
	 */
	public void setProbability(Double pProbability) {
		probability = pProbability;
	}

}
