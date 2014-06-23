/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;

/**
 * The Enum BetEventBetClick.
 */
public enum BetEventBetClick implements IBetEvent {

	/** The A l_ descanso. */
//	AL_DESCANSO(CfgBetTypeEventId.AL_DESCANSO.nameId(), "Half-Time Result"),
	
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "Half-Time Result"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
			"Match Result"),
	
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(), "Match Winner");	

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventBetClick(String... pValue) {
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
		BetEventBetClick[] values = BetEventBetClick.values();
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
