/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.convert;

import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBetDataToResultValueBet.
 */
@Component
class CalculateValueBetDataToResultValueBet implements
		ICalculateValueBetDataToResultValueBet {

	/**
	 * Convert.
	 * 
	 * @param match
	 *            the match
	 * @param market
	 *            the market
	 * @param bets
	 *            the bets
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the result value bet {@inheritDoc}
	 */
	@Override
	public ResultValueBet convert(RtMatch match, RtMarket market,
			List<CalculateValueBetData> bets, RtBetTypeEvent betTypeEvent) {
		ResultValueBet result = new ResultValueBet();

		for (CalculateValueBetData bet : bets) {
			InfoMatch infoMatch = convertMatchToInfoMatch(match, market);
			ValueBetData valueBetData = new ValueBetData(infoMatch,
					bet.getBet(), bet.getProbability(), bet.getExpectation(),
					betTypeEvent);
			result.add(valueBetData);
		}

		return result;
	}

	/**
	 * Convert match to info match.
	 * 
	 * @param match
	 *            the match
	 * @param market
	 *            the market
	 * @return the info match
	 */
	private InfoMatch convertMatchToInfoMatch(RtMatch match, RtMarket market) {
		InfoMatch infoMatch = new InfoMatch();
		infoMatch.setMarket(market);
		infoMatch.setObjectId(match.getObjectId());
		infoMatch.setDate(match.getMatchId().getStartDate()
				.getZeroGmtMatchDate());
		infoMatch.setName(match.getI18n());
		infoMatch.setCompetition(match.getMatchId().getCompetition());
		return infoMatch;
	}
}
