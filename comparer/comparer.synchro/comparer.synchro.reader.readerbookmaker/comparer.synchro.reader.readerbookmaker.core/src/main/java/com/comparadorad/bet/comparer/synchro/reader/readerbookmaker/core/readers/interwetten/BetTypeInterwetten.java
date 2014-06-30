/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Enum BetTypeInterwetten.
 */
public enum BetTypeInterwetten implements IBetType {

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId()),

	/** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId()),

	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId()),

	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId()),

	/** The MAXIM o_ goleador. */
	MAXIMO_GOLEADOR(CfgBetTypeId.MAXIMO_GOLEADOR.nameId()),

	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId()),

	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId());

	/** The value. */
	private final String[] type;

	/**
	 * Instantiates a new bet type.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeInterwetten(String... pValue) {
		this.type = pValue;
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return type[0];
	}

	/** {@inheritDoc} */
	@Override
	public String[] getTypes() {
		return type;
	}

}
