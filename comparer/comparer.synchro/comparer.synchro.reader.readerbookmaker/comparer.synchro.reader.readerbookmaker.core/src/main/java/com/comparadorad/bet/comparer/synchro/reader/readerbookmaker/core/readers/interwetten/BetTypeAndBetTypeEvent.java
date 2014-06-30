/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;

/**
 * The Class BetTypeAndBetTypeEvent.
 */
public class BetTypeAndBetTypeEvent {

	/** The bet event. */
	private IBetEvent betEvent;

	/** The bet type. */
	private IBetType betType;

	/**
	 * Instantiates a new bet type and bet type event.
	 * 
	 * @param betType
	 *            the bet type
	 * @param betEvent
	 *            the bet event
	 */
	public BetTypeAndBetTypeEvent(IBetType betType, IBetEvent betEvent) {
		super();
		this.betType = betType;
		this.betEvent = betEvent;
	}

	/**
	 * Gets the bet event.
	 * 
	 * @return the bet event
	 */
	public IBetEvent getBetEvent() {
		return betEvent;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public IBetType getBetType() {
		return betType;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "BetTypeAndBetTypeEvent: [betType=" + betType + ", betEvent="
				+ betEvent + "]";
	}
	
	
	/**
	 * Sets the bet event.
	 *
	 * @param betEvent the new bet event
	 */
	public void setBetEvent (IBetEvent betEvent){
		this.betEvent = betEvent; 
	}

}
