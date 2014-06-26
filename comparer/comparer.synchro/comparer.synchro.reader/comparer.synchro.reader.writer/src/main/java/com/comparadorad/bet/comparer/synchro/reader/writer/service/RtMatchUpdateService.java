/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class RtMatchUpdateService.
 */
@Component
class RtMatchUpdateService {

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Combine rt bets.
	 * 
	 * @param bets
	 *            the bets
	 * @param betsDB
	 *            the bets db
	 * @return the set
	 */
	private Set<RtBet> combineRtBets(Set<RtBet> bets, Set<RtBet> betsDB) {

		Set<RtBet> combinedRtBets = new HashSet<RtBet>();
		List<String> betHashKeys = new ArrayList<String>();

		Boolean encontrado;
		RtBet updatedBet;
		for (RtBet bet : bets) {
			encontrado = Boolean.FALSE;
			LOG.debug(Thread.currentThread(), new StringBuffer(
					"Vamos a procesar el bet ").append(bet.getHashKey())
					.toString());
			for (RtBet betDB : betsDB) {
				if (isTheSameBet(bet, betDB)) {
					LOG.debug(Thread.currentThread(),
							"Ya existia el bet con lo que actualizamos sus coutas");
					encontrado = Boolean.TRUE;
					updatedBet = updateRtBet(betDB, bet.getBetOdd());
					combinedRtBets.add(updatedBet);
					betHashKeys.add(updatedBet.getHashKey());
					break;
				}
			}
			if (!encontrado) {
				LOG.debug(Thread.currentThread(),
						"No existia el bet con lo que lo damos de alta como nuevo.");
				combinedRtBets.add(bet);
			}
		}
		// Añadir los bets del betsDB que no se hayan incluido
		for (RtBet betDB : betsDB) {
			if (!betHashKeys.contains(betDB.getHashKey())) {
				betHashKeys.add(betDB.getHashKey());
				combinedRtBets.add(betDB);
			}
		}
		return combinedRtBets;
	}

	/**
	 * Combine rt markets.
	 * 
	 * @param rtMarkets
	 *            the rt markets
	 * @param rtMarketsDB
	 *            the rt markets db
	 * @return the set
	 */
	private Set<RtMarket> combineRtMarkets(Set<RtMarket> rtMarkets,
			Set<RtMarket> rtMarketsDB) {

		Set<RtMarket> combinedMarkets = new HashSet<RtMarket>();
		List<String> marketHashKeys = new ArrayList<String>();
		RtMarket combinedMarket;
		Boolean encontrado;

		for (RtMarket market : rtMarkets) {
			encontrado = Boolean.FALSE;
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer("Vamos a procesar el mercado ").append(
							market.getBetType().getNameId()).toString());
			for (RtMarket marketDB : rtMarketsDB) {
				if (isTheSameMarket(market, marketDB)) {
					LOG.debug(Thread.currentThread(),
							"Ya existia el mercado con lo que actualizamos sus bets.");
					encontrado = Boolean.TRUE;
					combinedMarket = marketDB;
					combinedMarket.setBets(combineRtBets(market.getBets(),
							marketDB.getBets()));
					combinedMarkets.add(combinedMarket);
					marketHashKeys.add(market.getHashKey());
					break;
				}
			}
			if (!encontrado) {
				LOG.debug(Thread.currentThread(),
						"No existia el mercado con lo que lo damos de alta como nuevo.");
				combinedMarkets.add(market);
				marketHashKeys.add(market.getHashKey());
			}
		}
		// Añadir los mercados del marketsDB que no se hayan incluido
		for (RtMarket marketDB : rtMarketsDB) {
			if (!marketHashKeys.contains(marketDB.getHashKey())) {
				combinedMarkets.add(marketDB);
			}
		}

		return combinedMarkets;
	}

	/**
	 * Combine rt matchs.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param rtMatchDB
	 *            the rt match db
	 * @return the rt match
	 */
	public RtMatch combineRtMatchs(RtMatch rtMatch, RtMatch rtMatchDB) {
		LOG.debug(Thread.currentThread(), "Inicio actualizacion del partido");

		RtMatch combinedRtMatch = rtMatchDB;

		combinedRtMatch.setRtMarkets(combineRtMarkets(rtMatch.getRtMarkets(),
				rtMatchDB.getRtMarkets()));

		LOG.debug(Thread.currentThread(), "Fin actualizacion del partido");
		return combinedRtMatch;
	}

	/**
	 * Checks if is the same bet.
	 * 
	 * @param bet
	 *            the bet
	 * @param betDB
	 *            the bet db
	 * @return the boolean
	 */
	private Boolean isTheSameBet(RtBet bet, RtBet betDB) {
		return betDB.getHashKey().equals(bet.getHashKey());
	}

	/**
	 * Checks if is the same market.
	 * 
	 * @param market
	 *            the market
	 * @param marketDB
	 *            the market db
	 * @return true, if is the same market
	 */
	private boolean isTheSameMarket(RtMarket market, RtMarket marketDB) {
		return market.getHashKey().equals(marketDB.getHashKey());
	}

	/**
	 * Update rt bet.
	 * 
	 * @param betDB
	 *            the bet db
	 * @param newBetOdd
	 *            the new bet odd
	 * @return the rt bet
	 */
	private RtBet updateRtBet(RtBet betDB, RtBetOdd newBetOdd) {

		RtBetOdd oldBetOdd = betDB.getBetOdd();

		LOG.debug(Thread.currentThread(),
				new StringBuffer("couta antigua = ")
						.append(oldBetOdd.getOdds()).append(", couta nueva = ")
						.append(newBetOdd.getOdds()).toString());

		if (Float.parseFloat(oldBetOdd.getOdds()) != (Float
				.parseFloat(newBetOdd.getOdds()))) {

			betDB.setBetOdd(newBetOdd);

			if (betDB.getBetOddhistoric() != null) {
				betDB.getBetOddhistoric().add(oldBetOdd);
			} else {
				List<RtBetOdd> odds = new ArrayList<RtBetOdd>();
				odds.add(oldBetOdd);
				betDB.setBetOddhistoric(odds);
			}
		}

		return betDB;
	}

}
