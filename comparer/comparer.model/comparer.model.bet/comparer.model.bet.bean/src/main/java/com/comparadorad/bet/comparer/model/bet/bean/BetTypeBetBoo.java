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
public enum BetTypeBetBoo implements IBetType {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "3W"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "Outright"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "2W"),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(),
			"Spread"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Total");

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeBetBoo(String... pValue) {
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
		BetTypeBetBoo[] values = BetTypeBetBoo.values();
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
