/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.beans;

/**
 * The Class ValueBetTo.
 */
public class ValueBetTo extends AbstractBet {

	/** The tipo_apuesta. */
	private String betType;

	/** The casa_apuesta. */
	private String bookmaker;

	/** The evento. */
	private String event;

	/** The esperanza. */
	private Float mathematicalExpectation;

	/** The cuotas. */
	private Float odds;

	/** The probabilidad. */
	private Float probability;

	/** The resultado. */
	private String result;

	/**
	 * Instantiates a new value bet to.
	 */
	public ValueBetTo() {
		super();
	}

	/**
	 * Instantiates a new value bet to.
	 * 
	 * @param event
	 *            the event
	 * @param betType
	 *            the bet type
	 * @param result
	 *            the result
	 * @param bookmaker
	 *            the bookmaker
	 * @param odds
	 *            the odds
	 * @param probabilidad
	 *            the probabilidad
	 * @param esperanza
	 *            the esperanza
	 */
	public ValueBetTo (String event, String betType, String result,
			String bookmaker, Float odds, Float probability,
			Float mathematicalExpectation) {
		super();
		this.event = event;
		this.betType = betType;
		this.result = result;
		this.bookmaker = bookmaker;
		this.odds = odds;
		this.probability = probability;
		this.mathematicalExpectation = mathematicalExpectation;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public String getBetType() {
		return betType;
	}

	/**
	 * Gets the bookmaker.
	 * 
	 * @return the bookmaker
	 */
	public String getBookmaker() {
		return bookmaker;
	}

	/**
	 * Gets the event.
	 * 
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * Gets the esperanza.
	 * 
	 * @return the esperanza
	 */
	public Float getMathematicalExpectation() {
		return mathematicalExpectation;
	}

	/**
	 * Gets the odds.
	 * 
	 * @return the odds
	 */
	public Float getOdds() {
		return odds;
	}

	/**
	 * Gets the probabilidad.
	 * 
	 * @return the probabilidad
	 */
	public Float getProbability() {
		return probability;
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param betType
	 *            the new bet type
	 */
	public void setBetType(String betType) {
		this.betType = betType;
	}

	/**
	 * Sets the bookmaker.
	 * 
	 * @param bookmaker
	 *            the new bookmaker
	 */
	public void setBookmaker(String bookmaker) {
		this.bookmaker = bookmaker;
	}

	/**
	 * Sets the event.
	 * 
	 * @param event
	 *            the new event
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * Sets the esperanza.
	 * 
	 * @param esperanza
	 *            the new esperanza
	 */
	public void setMathematicalExpectation(Float mathematicalExpectation) {
		this.mathematicalExpectation = mathematicalExpectation;
	}

	/**
	 * Sets the odds.
	 * 
	 * @param odds
	 *            the new odds
	 */
	public void setOdds(Float odds) {
		this.odds = odds;
	}

	/**
	 * Sets the probabilidad.
	 * 
	 * @param probabilidad
	 *            the new probabilidad
	 */
	public void setProbability(Float probability) {
		this.probability = probability;
	}

	/**
	 * Sets the result.
	 * 
	 * @param result
	 *            the new result
	 */
	public void setResult(String result) {
		this.result = result;
	}


	

	


}
