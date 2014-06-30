/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;

/**
 * The Class MarketInfoWilliamHill.
 */
public class MarketInfoWilliamHill {

	
	/** The bet type. */
	private BetTypeWilliamHill betType;
	
	/** The bet type event. */
	private BetEventWilliamHill betTypeEvent;
	
	/** The long term. */
	private Boolean longTerm;

	
	/**
	 * Instantiates a new market info william hill.
	 *
	 * @param pBetType the bet type
	 * @param pBetTypeEvent the bet type event
	 * @param pLongTerm the long term
	 */
	public MarketInfoWilliamHill(BetTypeWilliamHill pBetType,
			BetEventWilliamHill pBetTypeEvent, Boolean pLongTerm) {
		super();
		betType = pBetType;
		betTypeEvent = pBetTypeEvent;
		longTerm = pLongTerm;
	}

	/**
	 * Gets the bet type.
	 *
	 * @return the bet type
	 */
	public BetTypeWilliamHill getBetType() {
		return betType;
	}

	/**
	 * Sets the bet type.
	 *
	 * @param pBetType the new bet type
	 */
	public void setBetType(BetTypeWilliamHill pBetType) {
		betType = pBetType;
	}

	/**
	 * Gets the bet type event.
	 *
	 * @return the bet type event
	 */
	public BetEventWilliamHill getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Sets the bet type event.
	 *
	 * @param pBetTypeEvent the new bet type event
	 */
	public void setBetTypeEvent(BetEventWilliamHill pBetTypeEvent) {
		betTypeEvent = pBetTypeEvent;
	}

	/**
	 * Checks if is long term.
	 *
	 * @return the boolean
	 */
	public Boolean isLongTerm() {
		return longTerm;
	}

	/**
	 * Sets the long term.
	 *
	 * @param pLongTerm the new long term
	 */
	public void setLongTerm(Boolean pLongTerm) {
		longTerm = pLongTerm;
	}
	
	
	
	
	
	
	
}
