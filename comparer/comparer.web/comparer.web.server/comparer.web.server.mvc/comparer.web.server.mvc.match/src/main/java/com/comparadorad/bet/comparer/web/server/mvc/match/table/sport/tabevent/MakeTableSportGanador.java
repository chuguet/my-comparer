/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.sport.tabevent;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.AbstractMakeTableDecoratorGanadorSportCountry;

/**
 * The Class MakeTableWinner.
 */
@Component
public class MakeTableSportGanador extends
		AbstractMakeTableDecoratorGanadorSportCountry {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetType.CfgBetTypeId.GANADOR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.
	 * IMakeTableShortTerm#getLevelType()
	 */
	@Override
	public LevelType getLevelType() {
		return LevelType.SPORT;
	}

}