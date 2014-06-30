/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.NoHandicapOddsSortedByParticipant;

/**
 * The Class AbstractDecoratorCalculateValueBetNoListBets.
 */
abstract class AbstractDecoratorCalculateValueBetNoListBets extends
		AbstractCalculateValueBet<NoHandicapOddsSortedByParticipant> {

	/** {@inheritDoc} */
	protected Map<Double, Double> getAveragePayout(
			List<NoHandicapOddsSortedByParticipant> columnOdds) {

		Map<Double, Double> result = new HashMap<Double, Double>();

		Double quota = 0.0d;
		Double payout = 0.0d;
		for (NoHandicapOddsSortedByParticipant column : columnOdds) {
			quota = quota + (1 / column.getMean());
		}
		payout = 1 / quota;
		result.put(null, payout);

		return result;

	}

	/**
	 * Gets the results.
	 * 
	 * @param bets
	 *            the bets
	 * @return the results {@inheritDoc}
	 */
	@Override
	protected List<NoHandicapOddsSortedByParticipant> sortedBetsByAttributeOrParticipant(
			List<RtBet> bets) {

		List<NoHandicapOddsSortedByParticipant> result = new ArrayList<NoHandicapOddsSortedByParticipant>();
		Map<RtParticipant, List<RtBet>> oddsToParticipantMapping = new HashMap<RtParticipant, List<RtBet>>();
		NoHandicapOddsSortedByParticipant noHandicapOddsSortedByParticipant;

		for (RtBet bet : bets) {
			if (oddsToParticipantMapping.containsKey(bet.getParticipant())) {
				oddsToParticipantMapping.get(bet.getParticipant()).add(bet);
			} else {
				List<RtBet> content = new ArrayList<RtBet>();
				content.add(bet);
				oddsToParticipantMapping.put(bet.getParticipant(), content);
			}
		}

		for (RtParticipant participant : oddsToParticipantMapping.keySet()) {
			noHandicapOddsSortedByParticipant = new NoHandicapOddsSortedByParticipant();
			noHandicapOddsSortedByParticipant.setParticipant(participant);
			noHandicapOddsSortedByParticipant.setBets(oddsToParticipantMapping
					.get(participant));
			result.add(noHandicapOddsSortedByParticipant);
		}

		return result;
	}

}
