/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tabevent;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.AbstractMakeTableDecoratorGanadorCompetition;

/**
 * The Class MakeTableWinner.
 */
@Component
public class MakeTableCompetitionGanador extends
		AbstractMakeTableDecoratorGanadorCompetition {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetType.CfgBetTypeId.GANADOR;
	}

	@Override
	public LevelType getLevelType() {
		return LevelType.COMPETITION;
	}
}
