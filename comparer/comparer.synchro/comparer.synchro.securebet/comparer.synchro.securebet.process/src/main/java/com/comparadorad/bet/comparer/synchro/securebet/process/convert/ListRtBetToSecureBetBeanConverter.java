/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.convert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;

/**
 * The Class ListListRtBetToCalculateToSecureBetBean.
 */
@Component
public class ListRtBetToSecureBetBeanConverter implements
		IListRtBetToSecureBetBeanConverter<List<List<RtBet>>, SureBetsMarket> {

	/**
	 * formula de calculo de apuesta segura (1/Sumatorio(1/Odds)) > 1 Calculo de
	 * beneficios de apuesta segura (1/Sumatorio(1/Odds)) - 1.
	 * 
	 * @param match
	 *            the match
	 * @param market
	 *            the market
	 * @param t
	 *            the t
	 * @return the secure bet bean
	 */
	@Override
	public SureBetsMarket convert(RtMatch match, RtMarket market,
			List<List<RtBet>> t) {
		SureBetsMarket result = new SureBetsMarket();
		Map<SecureBeanBenefit, List<RtBet>> secureBetAgrupation = new HashMap<SecureBeanBenefit, List<RtBet>>();
		result.setMatch(match);
		result.setBetType(market.getBetType());
		result.setBetTypeEvent(market.getBetTypeEvent());
		CoreDate date = getCoreDateGMT0();
		result.setCreateDate(date);
		RtBet bet;
		Float criteria;
		SecureBeanBenefit benefitBean;
		Double odd, benefit, probabilityOdd, probabilityStake, stake;
		for (List<RtBet> rtBetList : t) {
			criteria = 0f;
			for (RtBet rtBet : rtBetList) {
				criteria += 1 / Float.valueOf(rtBet.getBetOdd().getOdds());
			}
			benefit = 0d;
			if (rtBetList.size() > 0) {
				bet = rtBetList.get(0);
				odd = Double.valueOf(bet.getBetOdd().getOdds());
				probabilityOdd = 1 / odd;
				probabilityStake = probabilityOdd / criteria;
				stake = probabilityStake * 100;
				benefit = (stake * odd) - 100;
				benefitBean = new SecureBeanBenefit(benefit);
				secureBetAgrupation.put(benefitBean, rtBetList);
			}
		}
		result.setSecureBetAgrupation(secureBetAgrupation);
		return result;
	}

	/**
	 * Gets the core date gm t0.
	 * 
	 * @return the core date gm t0
	 */
	private CoreDate getCoreDateGMT0() {
		CoreDate date = new CoreDate();
		date.setZeroGmtMatchDate(new Date());
		date.setZeroGmtMatchTimeZoneStr();
		return date;
	}

}
