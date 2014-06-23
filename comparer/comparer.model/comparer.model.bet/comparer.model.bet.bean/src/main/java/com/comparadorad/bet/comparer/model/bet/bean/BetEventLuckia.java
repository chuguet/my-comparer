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
public enum BetEventLuckia implements IBetEvent {

	/** The TERCER CUARTO. */
	TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId(), "Cuarto 3", "cuarto 3"),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "Partido completo", "Final del partido"),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "Primer tiempo", "primer tiempo", "1a parte", "1a Parte", "1ª parte",
			"1.ª parte", "1ª Parte", "1.ª Parte", "mitad", "Mitad", "1ª Mitad", "1.ª Mitad", "1ª mitad", "1.ª mitad", "Periodo 1",
			"periodo 1"),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "2a Parte", "2a parte", "2ª Mitad", "2.ª Mitad", "2ª mitad", "2.ª mitad",
			"Periodo 2", "periodo 2", "2ª parte", "2.ª parte", "2ª Parte", "2.ª Parte", "Segunto tiempo", "segundo tiempo"),

	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "Periodo 3", "periodo 3"),

	/** The PRIMER CUARTO. */
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId(), "Cuarto 1", "cuarto 1"),

	/** The SEGUNDO CUARTO. */
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId(), "Cuarto 2", "cuarto 2"),

	/** The CUARTO CUARTO. */
	CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId(), "Cuarto 4", "cuarto 4"),

	/** The CUARTO CUARTO. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(), "Prórroga", "prórroga"),

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
	BetEventLuckia(String... pValue) {
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
		BetEventLuckia[] values = BetEventLuckia.values();
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
