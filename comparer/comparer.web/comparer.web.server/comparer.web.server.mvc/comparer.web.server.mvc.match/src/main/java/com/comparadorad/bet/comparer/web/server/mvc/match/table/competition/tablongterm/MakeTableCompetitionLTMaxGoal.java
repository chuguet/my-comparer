/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class MakeTableCompetitionLTMaxGoal.
 */
@Component
public class MakeTableCompetitionLTMaxGoal extends
		AbstractMakeTableCompetitionLT {

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
