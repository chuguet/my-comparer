/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CorrectCoreDate;
import com.comparadorad.bet.comparer.model.valuebet.validator.MatchExistInBD;

/**
 * The Class AbstractValueBet.
 */
@SuppressWarnings("serial")
public class AbstractValueBetData extends AbstractId implements IValueBetData {

	/** The bet. */
	@Field
	@NotNull
	private RtBet bet;

	/** The bet type event. */
	@Field
	@NotNull
	private RtBetTypeEvent betTypeEvent;

	/** The create date. */
	@Field
	@CorrectCoreDate
	private CoreDate createDate;

	/** The last verification date. */
	@Field
	@CorrectCoreDate
	private CoreDate lastVerificationDate;

	/**
	 * Gets the last verification date.
	 * 
	 * @return the last verification date
	 */
	public CoreDate getLastVerificationDate() {
		return lastVerificationDate;
	}

	/**
	 * Sets the last verification date.
	 * 
	 * @param pLastVerificationDate
	 *            the new last verification date
	 */
	public void setLastVerificationDate(CoreDate pLastVerificationDate) {
		lastVerificationDate = pLastVerificationDate;
	}

	/** The bet hope. */
	@Field
	@NotNull
	private ValueBetMathematicalExpectation expectation;

	/** The historic. */
	@Field
	private HistoricInfo historic;

	/** The match. */
	@Field
	@NotNull
	@MatchExistInBD
	private InfoMatch infoMatch;

	/** The probability. */
	@Field
	@NotNull
	private ValueBetProbability probability;

	/**
	 * Instantiates a new abstract value bet data.
	 */
	public AbstractValueBetData() {
		super();
	}

	/**
	 * Instantiates a new abstract value bet data.
	 * 
	 * @param infoMatch
	 *            the info match
	 * @param bet
	 *            the bet
	 * @param probability
	 *            the probability
	 * @param expectation
	 *            the expectation
	 * @param betTypeEvent
	 *            the bet type event
	 */
	public AbstractValueBetData(InfoMatch infoMatch, RtBet bet,
			ValueBetProbability probability,
			ValueBetMathematicalExpectation expectation,
			RtBetTypeEvent betTypeEvent) {
		super();
		this.infoMatch = infoMatch;
		this.bet = bet;
		this.probability = probability;
		this.expectation = expectation;
		this.betTypeEvent = betTypeEvent;
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
	 * Gets the bet type event.
	 * 
	 * @return the bet type event
	 */
	public RtBetTypeEvent getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Gets the creates the date.
	 * 
	 * @return the creates the date
	 */
	public CoreDate getCreateDate() {
		return createDate;
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
	 * Gets the historic.
	 * 
	 * @return the historic
	 */
	public HistoricInfo getHistoric() {
		return historic;
	}

	/**
	 * Gets the info match.
	 * 
	 * @return the info match
	 */
	public InfoMatch getInfoMatch() {
		return infoMatch;
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
	 * Sets the bet type event.
	 * 
	 * @param betTypeEvent
	 *            the new bet type event
	 */
	public void setBetTypeEvent(RtBetTypeEvent betTypeEvent) {
		this.betTypeEvent = betTypeEvent;
	}

	/**
	 * Sets the creates the date.
	 * 
	 * @param date
	 *            the new creates the date
	 */
	public void setCreateDate(CoreDate date) {
		createDate = date;
		setLastVerificationDate(date);
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
	 * Sets the historic.
	 * 
	 * @param pHistoric
	 *            the new historic
	 */
	public void setHistoric(HistoricInfo pHistoric) {
		historic = pHistoric;
	}

	/**
	 * Sets the info match.
	 * 
	 * @param infoMatch
	 *            the new info match
	 */
	public void setInfoMatch(InfoMatch infoMatch) {
		this.infoMatch = infoMatch;
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
