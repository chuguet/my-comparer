/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.bean;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetMathematicalExpectation;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;

/**
 * The Class CalculateValueBetData.
 */
public class CalculateValueBetData {

	/** The bet. */
	private RtBet bet;

	/** The bet hope. */
	private ValueBetMathematicalExpectation expectation;

	/** The probability. */
	private ValueBetProbability probability;

	/**
	 * Instantiates a new calculate value bet data.
	 */
	public CalculateValueBetData() {
	}

	/**
	 * Instantiates a new calculate value bet data.
	 * 
	 * @param pBet
	 *            the bet
	 * @param pExpectation
	 *            the expectation
	 * @param pValueBetProbability
	 *            the value bet probability
	 */
	public CalculateValueBetData(RtBet pBet,
			ValueBetMathematicalExpectation pExpectation,
			ValueBetProbability pValueBetProbability) {
		this.bet = pBet;
		this.expectation = pExpectation;
		this.probability = pValueBetProbability;
	}

	/**
	 * Gets the bet.
	 * 
	 * @return the bet
	 */
	public RtBet getBet() {
		return bet;
	}

	/**
	 * Gets the expectation.
	 * 
	 * @return the expectation
	 */
	public ValueBetMathematicalExpectation getExpectation() {
		return expectation;
	}

	/**
	 * Gets the probability.
	 * 
	 * @return the probability
	 */
	public ValueBetProbability getProbability() {
		return probability;
	}

	/**
	 * Sets the bet.
	 * 
	 * @param bet
	 *            the new bet
	 */
	public void setBet(RtBet bet) {
		this.bet = bet;
	}

	/**
	 * Sets the expectation.
	 * 
	 * @param expectation
	 *            the new expectation
	 */
	public void setExpectation(ValueBetMathematicalExpectation expectation) {
		this.expectation = expectation;
	}

	/**
	 * Sets the probability.
	 * 
	 * @param probability
	 *            the new probability
	 */
	public void setProbability(ValueBetProbability probability) {
		this.probability = probability;
	}

}
