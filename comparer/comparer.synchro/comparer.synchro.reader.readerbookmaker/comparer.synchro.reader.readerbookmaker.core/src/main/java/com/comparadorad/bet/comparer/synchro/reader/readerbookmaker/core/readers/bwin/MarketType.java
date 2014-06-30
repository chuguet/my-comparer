/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventBwin;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBwin;

/**
 * The Class MarketType.
 */
public class MarketType {

	/** The bet type. */
	private BetTypeBwin betType;

	/** The bet type event. */
	private BetEventBwin betTypeEvent;


	/**
	 * Gets the bet type.
	 *
	 * @return the bet type
	 */
	public BetTypeBwin getBetType() {
		return betType;
	}

	/**
	 * Sets the bet type.
	 *
	 * @param betType the new bet type
	 */
	public void setBetType(BetTypeBwin betType) {
		this.betType = betType;
	}

	/**
	 * Instantiates a new market type.
	 *
	 * @param betType the bet type
	 * @param betTypeEvent the bet type event
	 * @param maxOdds the max odds
	 */
	public MarketType(BetTypeBwin betType, BetEventBwin betTypeEvent) {
		super();
		this.betType = betType;
		this.betTypeEvent = betTypeEvent;
	}

	/**
	 * Gets the bet type event.
	 *
	 * @return the bet type event
	 */
	public BetEventBwin getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Sets the bet type event.
	 *
	 * @param betTypeEvent the new bet type event
	 */
	public void setBetTypeEvent(BetEventBwin betTypeEvent) {
		this.betTypeEvent = betTypeEvent;
	}






}
