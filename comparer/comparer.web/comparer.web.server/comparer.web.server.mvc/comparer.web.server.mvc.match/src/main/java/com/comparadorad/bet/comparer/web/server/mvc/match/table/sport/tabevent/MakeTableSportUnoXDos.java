/**
 *
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
 * The Class MakeTableOneXTwo.
 */
@Component
public class MakeTableSportUnoXDos extends
		AbstractMakeTableDecoratorGanadorPartido_1X2SportCountry {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetType.CfgBetTypeId.UNO_X_DOS;
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
		Set<RtBet> setBets1 = new HashSet<RtBet>();
		Set<RtBet> setBetsX = new HashSet<RtBet>();
		Set<RtBet> setBets2 = new HashSet<RtBet>();
		for (RtBet bet : bets) {
			if (bet.getParticipant().isHomeParticipant()) {
				setBets1.add(bet);
			} else if (bet.getParticipant().isAwayParticipant()) {
				setBets2.add(bet);
			} else {
				setBetsX.add(bet);
			}
		}
		// Tengo 3 Sets con apuetas de 1 - X - 2 Ahora saco el mayor de cada
		// conjunto y lo devuelvo
		if (!setBets1.isEmpty() && !setBetsX.isEmpty() && !setBets2.isEmpty()) {
			listBets.add(greaterBet(setBets1));
			listBets.add(greaterBet(setBetsX));
			listBets.add(greaterBet(setBets2));
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
