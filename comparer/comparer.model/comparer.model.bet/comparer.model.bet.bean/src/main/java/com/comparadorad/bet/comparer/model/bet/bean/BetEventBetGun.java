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
public enum BetEventBetGun implements IBetEvent {

//	/** The A l_ descanso. */
//	AL_DESCANSO(CfgBetTypeEventId.AL_DESCANSO.nameId(), "halftime result"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId()),
			
	/** The PARTID o_ completo_prorroga. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
					"final result"),

	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(),
			"under/over in the first half", "first period",
			"under/over - 1st period", "halftime result"),

	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "second period",
			"under/over - 2nd period"),

	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "Third period",
			"under/over - 3rd period");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventBetGun(String... pValue) {
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
		BetEventBetGun[] values = BetEventBetGun.values();
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
