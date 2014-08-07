/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.util;

import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;

/**
 * The Interface IUtilBets.
 */
public interface IUtilBets {

	/**
	 * Gets the greater bets limit.
	 * 
	 * @param bets
	 *            the bets
	 * @param limitBets
	 *            the limit bets
	 * @return the greater bets limit
	 */
	List<RtBet> getGreaterBetsLimit(Set<RtBet> bets, Integer limitBets);

	/**
	 * Gets the market by id.
	 * 
	 * @param match
	 *            the match
	 * @param betTypeId
	 *            the bet type id
	 * @return the market by id
	 */
	RtMarket getMarketByIdAndBetTypeEvent(RtMatch match,
			CfgBetTypeId betTypeId, CfgBetTypeEventId betTypeEventId);
}
