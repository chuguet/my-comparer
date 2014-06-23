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
public enum BetEventBetFred implements IBetEvent {

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "Half-Time",
			"1st Period", "1st Half"),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2nd Period",
			"2nd Half"),

	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "3rd Period"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId()),
	
	/** The PARTID o_ completo_prorroga. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId());

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventBetFred(String... pValue) {
		this.events = pValue;
	}

	/**
	 * Gets the events.
	 * 
	 * @return the events {@inheritDoc}
	 */
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
		BetEventBetFred[] values = BetEventBetFred.values();
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

	/**
	 * Gets the id.
	 * 
	 * @return the id {@inheritDoc}
	 */
	@Override
	public String getId() {
		return events[0];
	}

}
