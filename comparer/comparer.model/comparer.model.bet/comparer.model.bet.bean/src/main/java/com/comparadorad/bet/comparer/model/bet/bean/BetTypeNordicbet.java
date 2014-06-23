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
public enum BetTypeNordicbet implements IBetType {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId(), "Result"),

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId(), "Result Winner"),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId(), "Result", "MoneyLine"),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), "Handicap"),
	
	/** The UN o_ x_ do s_ handicap. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), "Handicap"),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId(), "Under/Over Match"),

	/** Money Line bet. */
	//TODO: Esta apuesta no está todavía como tipo (no en CfgBetTypeId), pero se utiliza aquí
	// para identificar el Hockey con prorroga.
	MONEYLINE("MONEYLINE", "MoneyLine");

	
	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeNordicbet(String... pValue) {
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
		BetTypeNordicbet[] values = BetTypeNordicbet.values();
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

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return type[0];
	}

}
