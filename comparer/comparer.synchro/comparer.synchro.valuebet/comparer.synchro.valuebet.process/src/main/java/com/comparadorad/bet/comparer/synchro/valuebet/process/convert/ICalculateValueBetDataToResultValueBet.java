/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.convert;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Interface ICalculateValueBetDataToResultValueBet.
 */
public interface ICalculateValueBetDataToResultValueBet {

	/**
	 * Convert.
	 * 
	 * @param match
	 *            the match
	 * @param market
	 *            the market
	 * @param listBets
	 *            the list bets
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the result value bet
	 */
	ResultValueBet convert(RtMatch match, RtMarket market,
			List<CalculateValueBetData> listBets, RtBetTypeEvent betTypeEvent);
}
