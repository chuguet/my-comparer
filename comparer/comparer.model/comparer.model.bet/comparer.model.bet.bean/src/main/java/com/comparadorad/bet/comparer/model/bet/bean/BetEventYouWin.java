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
 * The Enum BetEventYouWin.
 */
public enum BetEventYouWin implements IBetEvent {

		
	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "1st Half", "1st  Period", "Half time", "1st  Half", "Half-time"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "Total goals Over/Under"),
	
	/** The PARTID o_ completo_prorroga. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId()),
	
	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2nd Half", "2nd Period", "2nd  Half"),
	
	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(),"3rd  Period"),
	
	/** The PRIME r_ set. */
	PRIMER_SET(CfgBetTypeEventId.PRIMER_SET.nameId(), "First Set Winner", "Set 1 Winner", "1st Set", "1st  Set Winner"),
	
	/** The SEGUND o_ set. */
	SEGUNDO_SET(CfgBetTypeEventId.PRIMER_SET.nameId(), "Second Set Winner", "2nd Set");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet click.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventYouWin(String... pValue) {
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
		BetEventYouWin[] values = BetEventYouWin.values();
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
