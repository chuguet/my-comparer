/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.bean.DataConfiguration;

/**
 * The Class NumBetFilter.
 */
@Component
public class NumBetFilter implements IFilterValueBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(NumBetFilter.class);

	/** The data configuration. */
	@Inject
	private DataConfiguration dataConfiguration;

	/**
	 * Filter markets by num bets.
	 * 
	 * @param markets
	 *            the markets
	 * @return the set
	 */
	private Set<RtMarket> filterMarketsByNumBets(Set<RtMarket> markets) {

		Set<RtMarket> filteredMarkets = new HashSet<RtMarket>();

		for (RtMarket market : markets) {
			if (market.getBets().size() >= Integer.valueOf(dataConfiguration
					.getQuantityLimitBets())) {
				filteredMarkets.add(market);
			} else {
				LOG.debug(new StringBuffer("Se ignora el mercado con hashKey: ")
						.append(market.getHashKey())
						.append(" por tener menos de ")
						.append(dataConfiguration.getQuantityLimitBets())
						.append(" bets.").toString());
			}
		}

		return filteredMarkets;
	}

	/** {@inheritDoc} */
	@Override
	public List<RtMatch> matchFilter(List<RtMatch> matchs) {

		LOG.debug(new StringBuffer()
				.append("Inicio filter numero de bets. Numero de matchs inicialmente: ")
				.append(matchs.size()).toString());
		List<RtMatch> result = new ArrayList<RtMatch>();
		Set<RtMarket> filteredMarkets;
		for (RtMatch match : matchs) {
			LOG.debug(new StringBuffer("Procesamos match con hasKey: ")
					.append(match.getHashKey()));
			LOG.debug(new StringBuffer()
					.append("Numero de mercados inicialmente: ")
					.append(match.getRtMarkets().size()).toString());
			filteredMarkets = filterMarketsByNumBets(match.getRtMarkets());
			LOG.debug(new StringBuffer()
					.append("Numero de mercados despues del filtrado: ")
					.append(filteredMarkets.size()).toString());
			if (!filteredMarkets.isEmpty()) {
				match.setRtMarkets(filteredMarkets);
				result.add(match);
			}
		}
		LOG.debug(new StringBuffer(
				"Fin filter numero de bets. Numero de matchs despues del filtrado: ")
				.append(result.size()));

		return result;
	}

}
