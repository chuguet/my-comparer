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
public enum BetTypeExpekt implements IBetType {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "Match Result", "Half Time",
			"2nd Half Result"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "Draw No Bet"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), "Handicap"),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "Asian handicap"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Over/Under"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "Winner");

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeExpekt(String... pValue) {
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
		BetTypeExpekt[] values = BetTypeExpekt.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getTypes();
			for (int j = 1; j < types.length; j++) {
				if (types[j].equalsIgnoreCase(pValue)) {
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
