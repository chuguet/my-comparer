/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;

/**
 * The Enum BetEventBetOnline.
 */
enum BetEventBetOnline implements IBetEvent {

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "Game",
			"Match"),
			
	/** The PARTID o_ completo_prorroga. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId()),

	/** The PRIME r_ cuarto. */
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId(), "1st Quarter"),

	/** The PRIME r_ set. */
	PRIMER_SET(CfgBetTypeEventId.PRIMER_SET.nameId(), "1st Set"),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "1st Half",
			"1st Period"),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2nd Half",
			"2nd Period"),

	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "3rd Period"),

	/** The SEGUND o_ cuarto. */
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId(), "2nd Quarter"),

	/** The TERCE r_ cuarto. */
	TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId(), "3rd Quarter"),
	
		/** The SEGUND o_ cuarto. */
	CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId(), "4th Quarter");

	/**
	 * Gets the event by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the event by value
	 */
	public static IBetEvent getEventByValue(String pValue) {
		BetEventBetOnline[] values = BetEventBetOnline.values();
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

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bet online.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetEventBetOnline(String... pValue) {
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
