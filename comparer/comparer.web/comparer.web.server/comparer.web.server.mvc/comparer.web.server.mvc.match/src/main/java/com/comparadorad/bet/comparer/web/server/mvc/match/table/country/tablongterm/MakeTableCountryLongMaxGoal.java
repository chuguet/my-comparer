/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class MakeTableCountryLongMaxGoal.
 */
public class MakeTableCountryLongMaxGoal extends AbstractMakeTableCountryLT {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable#
	 * getBetTypeId()
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.MAXIMO_GOLEADOR;
	}

}
