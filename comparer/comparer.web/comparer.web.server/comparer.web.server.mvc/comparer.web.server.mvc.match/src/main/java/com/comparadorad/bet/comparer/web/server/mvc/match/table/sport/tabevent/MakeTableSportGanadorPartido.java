/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.sport.tabevent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.AbstractMakeTableDecoratorGanadorPartido_1X2SportCountry;

/**
 * The Class MakeTableWinnerMatch.
 */
@Component
public class MakeTableSportGanadorPartido extends
		AbstractMakeTableDecoratorGanadorPartido_1X2SportCountry {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetType.CfgBetTypeId.GANADOR_PARTIDO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.sport.tabevent
	 * .AbstractMakeTableDecoratorGanadorPartido_1X2
	 * #getGreatestBets(java.util.Set)
	 */
	@Override
	protected List<RtBet> getGreatestBets(Set<RtBet> bets) {
		List<RtBet> listBets = new ArrayList<RtBet>();
		Set<RtBet> setBetsLocal = new HashSet<RtBet>();
		Set<RtBet> setBetsVisitante = new HashSet<RtBet>();
		for (RtBet bet : bets) {
			if (bet.getParticipant().isHomeParticipant()) {
				setBetsLocal.add(bet);
			} else if (bet.getParticipant().isAwayParticipant()) {
				setBetsVisitante.add(bet);
			}
		}
		// Tengo 2 Sets con apuetas de Local y visitante Ahora saco el mayor de
		// cada
		// conjunto y lo devuelvo
		if (!setBetsLocal.isEmpty() && !setBetsVisitante.isEmpty()) {
			listBets.add(greaterBet(setBetsLocal));
			listBets.add(greaterBet(setBetsVisitante));
		}
		return listBets;
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
