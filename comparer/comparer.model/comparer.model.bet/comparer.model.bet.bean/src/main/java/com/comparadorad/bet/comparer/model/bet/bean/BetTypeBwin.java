/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Enum BetType.
 */
public enum BetTypeBwin implements IBetType {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "1 X 2","Resultado al descanso","3-way - result","Result at half-time","1 X 2 (tiempo reglamentario)"
			,"Three way (result after regular time)","Who will win the 1st period?","Who will win the 2nd period?","Who will win the 2nd period?",
			"Who will win the 3rd period?","Team to win 2nd Half (only goals scored in 2nd Half)","1 X 2 (sólo tiempo reglamentario)"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "Ganador del torneo","Ganador del campeonato (sin el Bayern Múnich)","Campeón",
			"League Winner","League Winner (Incl. Play-offs)","Group A - Winner","Group B - Winner","Group C - Winner","Group D - Winner","Group E - Winner","Group F - Winner",
			"Outright Winner (Incl. Play-offs)","Tournament Winner (including playoffs)","World Series Winner ","Tournament Winner (including playoffs)",
			"Super Bowl - Outright winner","Conference to win Super Bowl XLVIII"," Tournament winner"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "Especial 1 2 (la apuesta será reembolsada si se da el empate al final del tiempo reglamentario)","2Way special (Stake returned if game ends in a draw within regular time)"
			,"1 2 - ¿Quién ganará?","Money Line (US)","2Way - Who will win?","Who will win the first set ?"," Money Line","Two way - Who will win? (Extra Time/Penalty shoot-out included)","2Way - result incl. overtime and penalties"
			,"Apuesta por el ganador (US)","Apuesta por el ganador"),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(),
			"Asian Handicap", "Handicap Betting", "Alternative Handicap","Spread","Handicap (regular time)",
			"1st Period Handicap  (only goals scored in this period)","2nd Period Handicap  (only goals scored in this period)",
			"3rd Period Handicap  (only goals scored in this period)","Spread","Handicap","1st Half Handicap","Spread (including overtime and shoot-outs)"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(),
			"Handicap 0:1","Handicap 0:2","Handicap 0:3","Handicap 0:4","Handicap 0:5","Handicap 1:0","Handicap 2:0",
			"Handicap 3:0","Handicap 4:0","Handicap 5:0"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "¿Cuántos goles se marcarán?","¿Cuántos goles se marcarán en el 1er tiempo?",
			"¿Cuántos goles se marcarán en el 2° tiempo?","¿Cuántos goles se marcarán entre el minuto 0 y el 15:00?","How many goals will be scored?"
			,"How many goals will be scored in the 1st half?","How many goals will be scored in the 2nd half?",
			"How many games will be played in the match?","Totals (regular time)","1st Period Totals","2nd Period Totals","3rd Period Totals","Totals","Totals"
			,"1st Half Totals"),
	
	MAXIMO_GOLEADOR(CfgBetTypeId.MAXIMO_GOLEADOR.nameId(),"¿Quién será el máximo goleador? (otros a petición)","Top goalscorer (others upon request)"
			,"Máximo goleador (otros a petición)");		

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeBwin(String... pValue) {
		this.type = pValue;
	}

	/**
	 * Gets the types.
	 * 
	 * @return the types {@inheritDoc}
	 */
	@Override
	public String[] getTypes() {
		return type;
	}

	/**
	 * Gets the type by value.
	 * 
	 * @param pValue
	 *            the value
	 * @return the type by value
	 */
	public static IBetType getTypeByValue(String pValue) {
		BetTypeBwin[] values = BetTypeBwin.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getTypes();
			for (int j = 1; j < types.length; j++) {
				if (pValue.equals(types[j])) {
					return values[i];
				}
			}
		}
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return type[0];
	}

}
