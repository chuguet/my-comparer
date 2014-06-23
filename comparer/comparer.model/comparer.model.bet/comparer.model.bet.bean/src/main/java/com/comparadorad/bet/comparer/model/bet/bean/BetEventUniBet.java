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
public enum BetEventUniBet implements IBetEvent {

	/** The TERCER CUARTO. */
	TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId(), "Quarter 3", "quarter 3"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "Full Time", "Result at end", "Match Odds"),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "Half Time", "1st Half", "Period 1"),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2nd Half", "Period 2"),

	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "Period 3"),

	/** The PRIMER CUARTO. */
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId(), "Quarter 1"),

	/** The SEGUNDO CUARTO. */
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId(), "Quarter 2"),

	/** The CUARTO CUARTO. */
	CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId(), "Quarter 4"),

	/** The CUARTO CUARTO. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(), "Overtime", "overtime"),

	/** The PRIMER SET. */
	PRIMER_SET(CfgBetTypeEventId.PRIMER_SET.nameId(), "Set 1", "set 1"),

	/** The CUARTO CUARTO. */
	SEGUNDO_SET(CfgBetTypeEventId.SEGUNDO_SET.nameId(), "Set 2", "set 2");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventUniBet(String... pValue) {
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
		BetEventUniBet[] values = BetEventUniBet.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getEvents();
			for (int j = 1; j < types.length; j++) {
				if (pValue.contains(types[j])) {
					return values[i];
				}
			}
		}
		return values[1];
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
