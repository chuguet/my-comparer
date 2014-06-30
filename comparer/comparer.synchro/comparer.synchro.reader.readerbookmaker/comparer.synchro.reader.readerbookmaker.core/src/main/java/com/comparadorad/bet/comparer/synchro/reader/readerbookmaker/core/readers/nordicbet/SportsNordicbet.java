/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;

/**
 * The Enum BetEventBetClick.
 */
public enum SportsNordicbet implements IBetEvent {

	/** The A l_ descanso. */
//	AL_DESCANSO(CfgBetTypeEventId.AL_DESCANSO.nameId(), "Half-Time Result"),
	
	/** The Sport. */
	ICECHOKEY("Ice Hockey", "Ice Hockey"),	
	AMERICAN_FOOTBALL("American Football"),
	BASKETBALL("Basketball"),
	BASEBALL("Baseball");	

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	SportsNordicbet(String... pValue) {
		this.events = pValue;
	}

	/** {@inheritDoc} */
	@Override
	public String[] getEvents() {
		return events;
	}

	/**
	 * Gets the type by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the type by value
	 */
	public static IBetEvent getEventByValue(String pValue) {
		SportsNordicbet[] values = SportsNordicbet.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getEvents();
			for (int j = 1; j < types.length; j++) {
				if (pValue.contains(types[j])) {
					return values[i];
				}
			}
		}
		return null;
	}
	

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return events[0];
	}
	
}
