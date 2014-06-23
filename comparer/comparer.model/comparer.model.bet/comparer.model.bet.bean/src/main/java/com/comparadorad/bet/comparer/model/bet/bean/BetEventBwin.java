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
public enum BetEventBwin implements IBetEvent {

	/** The QUINC e_ minutos. */
	QUINCE_MINUTOS(CfgBetTypeEventId.QUINCE_MINUTOS.nameId(), "¿Cuántos goles se marcarán entre el minuto 0 y el 15:00?"),

	/** The TREINT a_ minutos. */
	TREINTA_MINUTOS(CfgBetTypeEventId.TREINTA_MINUTOS.nameId(),
			""),

	/** The PRIMER a_ parte. */
	PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "How many goals will be scored in the 1st half?","Result at half-time","Who will win the 1st period?"
			,"1st Period Handicap  (only goals scored in this period)","1st Period Totals","1st Half Totals","1st Half Handicap","Result at half-time"
			,"Team to win 2nd Half (only goals scored in 2nd Half)","Resultado al descanso","¿Cuántos goles se marcarán en el 1er tiempo?"),

	/** The SEGUND a_ parte. */
	SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "Who will win the 2nd period?","2nd Period Handicap  (only goals scored in this period)","2nd Period Totals"
			,"¿Cuántos goles se marcarán en el 2° tiempo?"),

	TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(),"Who will win the 3rd period?","3rd Period Handicap  (only goals scored in this period)","3rd Period Totals"),
	/** The PARTID o_ completo. */
	PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
			"3-way - result","2Way special (Stake returned if game ends in a draw within regular time)","Ganador del torneo","Ganador del campeonato (sin el Bayern Múnich)","Campeón",
			"League Winner","League Winner (Incl. Play-offs)","Group A - Winner","Group B - Winner","Group C - Winner","Group D - Winner","Group E - Winner","Group F - Winner",
			"Outright Winner (Incl. Play-offs)","Tournament Winner (including playoffs)","World Series Winner ","Tournament Winner (including playoffs)",
			"Super Bowl - Outright winner","Conference to win Super Bowl XLVIII"," Tournament winner","Handicap 0:1","Handicap 0:2","Handicap 0:3","Handicap 0:4","Handicap 0:5","Handicap 1:0","Handicap 2:0",
			"Handicap 3:0","Handicap 4:0","Handicap 5:0","How many goals will be scored?","Top goalscorer (others upon request)","2Way - Who will win?","Three way (result after regular time)"
			,"Handicap (regular time)","Totals (regular time)","Handicap","Totals","1 X 2","Especial 1 2 (la apuesta será reembolsada si se da el empate al final del tiempo reglamentario)"
			,"¿Cuántos goles se marcarán?","¿Quién será el máximo goleador?","1 2 - ¿Quién ganará?","1 X 2 (tiempo reglamentario)","Máximo goleador (otros a petición)","1 X 2 (sólo tiempo reglamentario)"),
	PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId()),
	SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId()),
	PRIMER_SET(CfgBetTypeEventId.PRIMER_SET.nameId(),"Who will win the first set ?"),
	SEGUNDO_SET(CfgBetTypeEventId.SEGUNDO_SET.nameId()),
	TERCER_SET(CfgBetTypeEventId.TERCER_SET.nameId()),
	PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),"Money Line (US)","Spread","2Way - result incl. overtime and penalties","Spread (including overtime and shoot-outs)"
			," Money Line","Spread","Totals","Two way - Who will win? (Extra Time/Penalty shoot-out included)","Apuesta por el ganador (US)","Apuesta por el ganador"),
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
	BetEventBwin(String... pValue) {
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
		BetEventBwin[] values = BetEventBwin.values();
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
