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
public enum BetEventWilliamHill implements IBetEvent {

	/** The QUINC e_ minutos. */
	QUINCE_MINUTOS(CfgBetTypeEventId.QUINCE_MINUTOS.nameId(), "15 Minutes Betting"),

	/** The TREINT a_ minutos. */
	TREINTA_MINUTOS(CfgBetTypeEventId.TREINTA_MINUTOS.nameId(),
			"30 Minutes Betting"),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "1st Half Betting","1st Half Handicaps"),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2nd Half Betting","2nd Half Handicaps"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
			"Match Betting","Total Points"),
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId()),
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId()),
	PRIMER_SET(CfgBetTypeEventId.PRIMER_SET.nameId()),
	SEGUNDO_SET(CfgBetTypeEventId.SEGUNDO_SET.nameId()),
	TERCER_SET(CfgBetTypeEventId.TERCER_SET.nameId()),
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId()),
	PRIMERA_ENTRADA(CfgBetTypeEventId.PRIMERA_ENTRADA.nameId()),
	TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId()),
	CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId());
	
	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventWilliamHill(String... pValue) {
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
		BetEventWilliamHill[] values = BetEventWilliamHill.values();
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
