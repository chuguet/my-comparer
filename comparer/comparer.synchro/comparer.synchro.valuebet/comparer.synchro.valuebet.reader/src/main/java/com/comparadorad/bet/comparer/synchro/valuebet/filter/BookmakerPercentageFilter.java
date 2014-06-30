/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.valuebet.bean.DataConfiguration;
import com.comparadorad.bet.comparer.web.server.util.bookmaker.ActiveBookmakers;

/**
 * The Class BookmakerPercentageFilter.
 */
@Component
public class BookmakerPercentageFilter implements IFilterValueBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BookmakerPercentageFilter.class);

	/** The active bookmakers. */
	@Inject
	private ActiveBookmakers activeBookmakers;

	/** The data configuration. */
	@Inject
	private DataConfiguration dataConfiguration;

	/**
	 * Filter bets by num bookmakers.
	 * 
	 * @param market
	 *            the market
	 * @param minimalNumBookamkers
	 *            the minimal num bookamkers
	 * @return the set
	 */
	private Set<RtBet> filterBetsByNumBookmakers(RtMarket market,
			Integer minimalNumBookamkers) {

		Set<RtBet> filteredBets = new HashSet<RtBet>();
		List<Set<RtBet>> betsToFilter = new ArrayList<Set<RtBet>>();
		List<String> bookmakersPerBetSet;

		if (isMarketWithValue(market)) {
			betsToFilter = groupBetsByValue(market.getBets());
		} else {
			betsToFilter.add(market.getBets());
		}

		for (Set<RtBet> betSetToFilter : betsToFilter) {
			bookmakersPerBetSet = new ArrayList<String>();
			for (RtBet bet : betSetToFilter) {
				if (!bookmakersPerBetSet.contains(bet.getBookmaker()
						.getObjectId().toString())) {
					bookmakersPerBetSet.add(bet.getBookmaker().getObjectId()
							.toString());
				}
			}

			if (bookmakersPerBetSet.size() >= minimalNumBookamkers) {
				filteredBets.addAll(betSetToFilter);
			} else {
				LOG.debug(new StringBuffer("Se ignoran bets por tener solo ")
						.append(bookmakersPerBetSet.size())
						.append(" bookmakers. Posible valor final: ")
						.append(betSetToFilter.iterator().next().getAttribute()
								.getFinalValue()));
			}

		}

		return filteredBets;
	}

	/**
	 * Group bets by value.
	 * 
	 * @param bets
	 *            the bets
	 * @return the list
	 */
	private List<Set<RtBet>> groupBetsByValue(final Set<RtBet> bets) {

		List<Set<RtBet>> result = new ArrayList<Set<RtBet>>();
		Map<Double, Set<RtBet>> map = new HashMap<Double, Set<RtBet>>();
		Double betValue;
		Set<RtBet> newBetSet;

		for (RtBet bet : bets) {
			betValue = 0.0;

			if (bet.getAttribute().getFinalValue() != null) {
				betValue = bet.getAttribute().getFinalValue();
			}

			if (map.containsKey(betValue)) {
				map.get(betValue).add(bet);
			} else {
				newBetSet = new HashSet<RtBet>();
				newBetSet.add(bet);
				map.put(betValue, newBetSet);
			}
		}

		for (Set<RtBet> betSet : map.values()) {
			result.add(betSet);
		}

		return result;
	}

	/**
	 * Checks if is market with value.
	 * 
	 * @param market
	 *            the market
	 * @return the boolean
	 */
	private Boolean isMarketWithValue(RtMarket market) {
		return market.getBetType().getObjectId().toString()
				.equals(CfgBetTypeId.HANDICAP_ASIATICO.id())
				|| market.getBetType().getObjectId().toString()
						.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.id())
				|| market.getBetType().getObjectId().toString()
						.equals(CfgBetTypeId.MAS_MENOS.id());
	}

	/** {@inheritDoc} */
	public List<RtMatch> matchFilter(List<RtMatch> matchs) {

		LOG.debug("Inicio filter numero de bookmakers");

		List<RtMatch> result = new ArrayList<RtMatch>();
		Set<RtMarket> filteredMarkets = new HashSet<RtMarket>();
		RtMatch filteredMatch;
		RtMarket filteredMarket;
		Set<RtBet> filteredBets;

		Integer minimalNumBookamkers = activeBookmakers
				.getMinimalNumberOfBookmakers(Integer.valueOf(dataConfiguration
						.getQuantityPercentBookmakers()));

		for (RtMatch match : matchs) {
			LOG.debug(new StringBuffer("Procesamos match con hasKey: ")
					.append(match.getHashKey()));
			for (RtMarket market : match.getRtMarkets()) {

				LOG.debug(new StringBuffer(
						"Inicio filtrado market con hasKey: ")
						.append(market.getHashKey())
						.append(" (tipo ")
						.append(market.getBets().iterator().next()
								.getAttribute().getBetName()).append(")"));
				filteredBets = filterBetsByNumBookmakers(market,
						minimalNumBookamkers);

				if (filteredBets.size() > 0) {
					filteredMarket = (RtMarket) market.clone();
					filteredMarket.setRtBets(filteredBets);
					filteredMarkets.add(filteredMarket);
				} else {
					LOG.debug(new StringBuffer("Se ignora el mercado ").append(
							market.getHashKey()).append(
							" por no tener ningun bet despues del filtrado"));
				}
				LOG.debug(new StringBuffer("Fin filtrado market con hasKey: ")
						.append(market.getHashKey()));
			}

			if (filteredMarkets.size() > 0) {
				filteredMatch = (RtMatch) match.clone();
				filteredMatch.setRtMarkets(filteredMarkets);
				result.add(filteredMatch);
			} else {
				LOG.debug("Se ignora el partido por no tener ningun mercado con numero de bookmakers suficientes");
			}
		}

		LOG.debug(new StringBuffer(
				"Fin filtrado numero de bookmakers. Numero de matchs despues del filtrado: ")
				.append(result.size()));

		return result;
	}

}
