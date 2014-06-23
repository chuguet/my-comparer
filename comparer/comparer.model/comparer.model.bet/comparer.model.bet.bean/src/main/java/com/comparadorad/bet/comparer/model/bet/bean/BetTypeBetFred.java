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
 * The Enum BetTypeBetFred.
 */
public enum BetTypeBetFred implements IBetType {
	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "Match Betting", "Match Result",
			"Bout 3 way", "Match Result (With Draw)", "Half-Time Result", "2nd Half Result"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "Outright", "Outright Winner",
			"World Series Outright", "Group"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "Draw No Bet",
			"Match Winner", "Race Winner", "Match Prices", "Money Line"),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "Asian Handicap", "Handicap Result (No Tie)", "Point Spread", "Puck Line"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(),
			"Match Handicap", "Handicap", "Match Handicaps"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Under/Over", "Over/Under"),

	/** The MAXIM o_ goleador. */
	MAXIMO_GOLEADOR(CfgBetTypeId.MAXIMO_GOLEADOR.nameId(), "Top Goalscorer");

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeBetFred(String... pValue) {
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
		BetTypeBetFred[] values = BetTypeBetFred.values();
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

	/**
	 * Gets the id.
	 * 
	 * @return the id {@inheritDoc}
	 */
	@Override
	public String getId() {
		return type[0];
	}
}
