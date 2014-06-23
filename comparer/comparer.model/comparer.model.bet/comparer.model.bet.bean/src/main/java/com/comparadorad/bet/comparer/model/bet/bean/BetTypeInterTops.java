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
 * The Enum BetType. Al realizar la consulta solo se muestran aquellas apuestas
 * que han variado en un determinado tiempo por lo que es probable que surjan
 * nuevos literales que no se han observado hasta el momento
 */
public enum BetTypeInterTops implements IBetType {

	/**
	 * The UN o_ x_ dos. "Single Match" y "Half Time Result" se asignan a Uno X
	 * Dos por defecto pero pueden representar un Ganador Partido. Dependera del
	 * numero de bets para determinar si corresponde a Ganador partido
	 */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "Single Match",
			"Half Time Result"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "To Win Outright", "To win", "To Win Conference", 
			"Winner", "Grand Slam Winner"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId()),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "Moving Line", "Half Time Line", "Quarter Line", "Asian Lines"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), "Handicap"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Point Score",
			"Half Time Points Score", "Over/Under"),

	MAXIMO_GOLEADOR(CfgBetTypeId.MAXIMO_GOLEADOR.nameId(), "Top Goalscorer");

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeInterTops(String... pValue) {
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
		BetTypeInterTops[] values = BetTypeInterTops.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getTypes();
			for (int j = 1; j < types.length; j++) {
				if (pValue.contains(types[j])) {
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
