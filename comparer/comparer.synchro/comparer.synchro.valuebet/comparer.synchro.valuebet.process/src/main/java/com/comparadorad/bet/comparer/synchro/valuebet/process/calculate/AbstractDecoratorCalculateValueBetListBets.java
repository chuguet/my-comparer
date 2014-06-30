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

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.HandicapOddsSortedByAttribute;

/**
 * The Class AbstractDecoratorCalculateValueBetListBets.
 */
abstract class AbstractDecoratorCalculateValueBetListBets extends
		AbstractCalculateValueBet<HandicapOddsSortedByAttribute> {

	/** {@inheritDoc} */
	@Override
	protected Map<Double, Double> getAveragePayout(
			List<HandicapOddsSortedByAttribute> columnOdds) {

		Map<Double, Double> result = new HashMap<Double, Double>();
		Map<Double, List<Double>> finalValueAndMeans = new HashMap<Double, List<Double>>();

		for (HandicapOddsSortedByAttribute column : columnOdds) {
			Double finalValue = column.getFinalValue();

			if (finalValueAndMeans.containsKey(finalValue)) {
				finalValueAndMeans.get(finalValue).add(column.getMean());
			} else {
				List<Double> means = new ArrayList<Double>();
				means.add(column.getMean());
				finalValueAndMeans.put(finalValue, means);
			}

		}

		List<Double> means;
		for (Double key : finalValueAndMeans.keySet()) {
			means = finalValueAndMeans.get(key);
			Double quota = 0.0d;
			Double payout;
			for (Double mean : means) {
				quota += 1 / mean;
			}
			payout = 1 / quota;
			result.put(key, payout);
		}

		return result;

	}

	/** {@inheritDoc} */
	@Override
	protected List<HandicapOddsSortedByAttribute> sortedBetsByAttributeOrParticipant(
			List<RtBet> bets) {

		List<HandicapOddsSortedByAttribute> result = new ArrayList<HandicapOddsSortedByAttribute>();
		Map<AbstractRtAttribute, List<RtBet>> oddsToAttributeMapping = new HashMap<AbstractRtAttribute, List<RtBet>>();
		HandicapOddsSortedByAttribute noHandicapOddsSortedByParticipant;

		for (RtBet bet : bets) {
			if (oddsToAttributeMapping.containsKey(bet.getAttribute())) {
				oddsToAttributeMapping.get(bet.getAttribute()).add(bet);
			} else {
				List<RtBet> content = new ArrayList<RtBet>();
				content.add(bet);
				oddsToAttributeMapping.put(bet.getAttribute(), content);
			}
		}

		for (AbstractRtAttribute attribute : oddsToAttributeMapping.keySet()) {
			noHandicapOddsSortedByParticipant = new HandicapOddsSortedByAttribute();
			noHandicapOddsSortedByParticipant.setAttribute(attribute);
			noHandicapOddsSortedByParticipant.setBets(oddsToAttributeMapping
					.get(attribute));
			result.add(noHandicapOddsSortedByParticipant);
		}

		return result;
	}

}
