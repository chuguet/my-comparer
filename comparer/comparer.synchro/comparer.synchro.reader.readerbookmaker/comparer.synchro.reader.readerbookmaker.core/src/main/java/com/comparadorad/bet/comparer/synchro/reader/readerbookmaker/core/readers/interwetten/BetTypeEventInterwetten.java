/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;

/**
 * The Enum BetTypeEventInterwetten.
 */
public enum BetTypeEventInterwetten implements IBetEvent {

	/** The CINC o_ primera s_ entradas. */
	CINCO_PRIMERAS_ENTRADAS(CfgBetTypeEventId.CINCO_PRIMERAS_ENTRADAS.nameId()),

	/** The CUART o_ cuarto. */
	CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId()),

	/** The CUART o_ set. */
	CUARTO_SET(CfgBetTypeEventId.CUARTO_SET.nameId()),

	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId()),

	/** The PARTID o_ complet o_ prorroga. */
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
			.nameId()),

	/** The PRIME r_ cuarto. */
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId()),

	/** The PRIME r_ set. */
	PRIMER_SET(CfgBetTypeEventId.PRIMER_SET.nameId()),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId()),

	/** The QUINC e_ minutos. */
	QUINCE_MINUTOS(CfgBetTypeEventId.QUINCE_MINUTOS.nameId()),

	/** The QUINT o_ set. */
	QUINTO_SET(CfgBetTypeEventId.QUINTO_SET.nameId()),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId()),

	/** The SEGUND o_ cuarto. */
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId()),

	/** The SEGUND o_ set. */
	SEGUNDO_SET(CfgBetTypeEventId.SEGUNDO_SET.nameId()),

	/** The TERCE r_ cuarto. */
	TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId()),

	/** The TERCE r_ set. */
	TERCER_SET(CfgBetTypeEventId.TERCER_SET.nameId()),

	/** The TERCER a_ parte. */
	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId()),

	/** The TREINT a_ minutos. */
	TREINTA_MINUTOS(CfgBetTypeEventId.TREINTA_MINUTOS.nameId());

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet type event interwetten.
	 * 
	 * @param pValue
	 *            the value
	 */
	private BetTypeEventInterwetten(String... pValue) {
		this.events = pValue;
	}

	/** {@inheritDoc} */
	@Override
	public String[] getEvents() {
		return events;
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return events[0];
	}

}
