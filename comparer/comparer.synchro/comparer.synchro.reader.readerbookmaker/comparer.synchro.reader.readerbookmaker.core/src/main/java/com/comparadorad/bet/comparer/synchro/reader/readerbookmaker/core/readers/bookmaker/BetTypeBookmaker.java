package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

public enum BetTypeBookmaker implements IBetType {

	/** The GANADOR. */
	GANADOR(CfgBetTypeId.GANADOR.nameId()), /** The GANADO r_ partido. */
	GANADOR_PARTIDO(CfgBetTypeId.GANADOR_PARTIDO.nameId()),
	/** The HANDICA p_ asiatico. */
	HANDICAP_ASIATICO(CfgBetTypeId.HANDICAP_ASIATICO.nameId()),
	/** The MA s_ menos. */
	MAS_MENOS(CfgBetTypeId.MAS_MENOS.nameId()),
	/** The UN o_ x_ dos. */
	UNO_X_DOS(CfgBetTypeId.UNO_X_DOS.nameId()),
	/** The UN o_ x_ do s_ handicap. */
	UNO_X_DOS_HANDICAP(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId());

	/** The type. */
	private final String[] type;

	/**
	 * Instantiates a new bet type pinnacle sports.
	 * 
	 * @param pValue
	 *            the value
	 */
	BetTypeBookmaker(String... pValue) {
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
