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
 * The Enum BetEventBetRedKings.
 */
public enum BetEventBetRedKings implements IBetEvent {

	/** The CUART o_ cuarto. */
	CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId(), "4th quarter"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
			"Full time excluding overtime"),

	/** The PARTID o_ complet o_ prorroga. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
			.nameId(), "Full time including overtime"),

	/** The PRIME r_ cuarto. */
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId(), "1st quarter"),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "First half",
			"first period"),
	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "Second half", "second period"),

	/** The SEGUND o_ cuarto. */
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId(), "2nd quarter"),

	/** The TERCE r_ cuarto. */
	TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId(), "3rd quarter"),

	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "third period");

	/**
	 * Gets the type by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the type by value
	 */
	public static IBetEvent getEventByValue(String pValue) {
		BetEventBetRedKings[] values = BetEventBetRedKings.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getEvents();
			for (int j = 1; j < types.length; j++) {
				if (pValue.equals(types[j])) {
					return values[i];
				}
			}
		}
		return null;
	}

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventBetRedKings(String... pValue) {
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
	 * Gets the id.
	 * 
	 * @return the id {@inheritDoc}
	 */
	@Override
	public String getId() {
		return events[0];
	}
}
