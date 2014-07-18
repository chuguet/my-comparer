/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class MakeTableCountryLongWinner.
 */
@Component
public class MakeTableCountryLongWinner extends AbstractMakeTableCountryLT {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable#
	 * getBetTypeId()
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.GANADOR;
	}

}
