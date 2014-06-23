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
 * The Enum BetTypeYouWin.
 */
public enum BetTypeYouWin implements IBetType {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "Match Result", "Outright Match", "Half-time Result", "2nd Half Result", "Match betting",
			"3way", "3-way"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "Draw No Bet", "Draw no bet", "Match Winner", "Set 1 Winner",
			"First Set Winner", "Second Set Winner", "2way", "2-way", "Money Line", "1st  Set Winner", "2nd  Set Winner", "2nd Set Winner"),

	GANADOR(CfgBetTypeId.GANADOR.nameId(), "Winner", "Conference Champion", "Division Champion"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), "Handicap", "European handicaps"),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "Asian Handicap", "Handicap (No Draw)", "Points Spread", "Point Spread",
			"Goals Spread", "Puck Line"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Over/Under", "Round Over/Under", "Half-time Totals Over/Under", "Total goals Over/Under",
			"Half Totals", "Total Spread", "Total Points"), MAXIMO_GOLEADOR(CfgBetTypeId.MAXIMO_GOLEADOR.nameId(), "Top Goalscorer");

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeYouWin(String... pValue) {
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
		BetTypeYouWin[] values = BetTypeYouWin.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getTypes();
			for (int j = 1; j < types.length; j++) {
				if (pValue.equalsIgnoreCase(types[j])) {
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
