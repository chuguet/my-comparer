/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;

/**
 * The Enum CalculateSecureBetEnum.
 */
public enum CalculateSecureBetEnum {

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetType.CfgBetTypeId.UNO_X_DOS),

	/** The GANADOR. */
	GANADOR(CfgBetType.CfgBetTypeId.GANADOR),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetType.CfgBetTypeId.MAS_MENOS),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO),

	/** The MAXIM o_ goleador. */
	MAXIMO_GOLEADOR(CfgBetType.CfgBetTypeId.MAXIMO_GOLEADOR),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP);

	/** The bet type id. */
	private CfgBetType.CfgBetTypeId betTypeId;

	/**
	 * Instantiates a new calculate secure bet enum.
	 * 
	 * @param betTypeId
	 *            the bet type id
	 */
	private CalculateSecureBetEnum(CfgBetType.CfgBetTypeId betTypeId) {
		this.betTypeId = betTypeId;
	}

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	public CfgBetType.CfgBetTypeId getBetTypeId() {
		return betTypeId;
	}

}
