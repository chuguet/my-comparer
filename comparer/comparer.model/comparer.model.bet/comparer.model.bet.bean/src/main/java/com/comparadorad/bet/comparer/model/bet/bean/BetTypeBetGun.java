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
public enum BetTypeBetGun implements IBetType {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "Match odds", "Match Odds", "Regular game time", "halftime result", "first period",
			"second period", "Third period"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "winner", "winner of the group"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "final result", "Draw no bet"),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "handicap"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), "dummy, no se puede dar nunca, siempre preguntaremos por handicap asiatico"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "under/over", "number of sets", "Number of sets", "under/over in the first half", "under/over - 1st period",
			"under/over - 2nd period", "under/over - 3rd period");

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeBetGun(String... pValue) {
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
		BetTypeBetGun[] values = BetTypeBetGun.values();
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
