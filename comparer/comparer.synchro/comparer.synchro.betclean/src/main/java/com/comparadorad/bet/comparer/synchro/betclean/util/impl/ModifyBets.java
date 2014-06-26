/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.util.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.model.activator.service.IActivatorMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.betclean.exception.RemoveBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.exception.UpdateBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class ModifyBets.
 */
@Component
final class ModifyBets implements IModifyBets {

	/** The activator match. */
	@Inject
	private IActivatorMatch activatorMatch;

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The match repository. */
	@Inject
	private RtMatchRepository matchRepository;

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets#removeBets
	 * (java.util.List)
	 */
	/** {@inheritDoc} */ 
	@Override
	public List<RtMatch> removeBets(List<RtMatch> matchs)
			throws RemoveBetsException {
		RtMatch matchResult;
		BigInteger bookmakerId;
		Long time;
		Date actualizeDate;
		Set<RtBet> rtBets;
		Set<RtMarket> markets;
		List<RtMatch> result = new ArrayList<RtMatch>();
		Map<BigInteger, Long> timesForDeleteBets = bookmakerRepository
				.findAllTimesForDeleteBets();

		LOG.debug(Thread.currentThread(), "Se inicia el metodo removeBets");

		for (RtMatch rtMatch : matchs) {
			if (!rtMatch.getMatchId().getCompetitionEvent().getLongTerm()
					.getLongTerm()) {
				markets = new HashSet<RtMarket>();
				for (RtMarket market : rtMatch.getRtMarkets()) {
					rtBets = new HashSet<RtBet>();
					for (RtBet rtBet : market.getBets()) {
						if (rtBet.getActualizeDate() != null) {
							bookmakerId = rtBet.getBookmaker().getObjectId();
							if (timesForDeleteBets.containsKey(bookmakerId)) {
								time = timesForDeleteBets.get(bookmakerId);
								actualizeDate = new Date(rtBet
										.getActualizeDate().getTime() + time);
								if (actualizeDate.after(new Date())) {
									rtBets.add(rtBet);
								} else {
									LOG.debug(Thread.currentThread(),
											new StringBuffer(
													"Se borra la apuesta: ")
													.append(rtBet.getHashKey())
													.toString());
								}
							}
						}
					}
					market.setRtBets(rtBets);
					if (market.getBets().size() != 0) {
						markets.add(market);
					} else {
						LOG.debug(Thread.currentThread(),
								new StringBuffer("Se el borra mercado: ")
										.append(market.getHashKey()).toString());
					}
				}
				rtMatch.setRtMarkets(markets);
				if (rtMatch.getRtMarkets().size() != 0) {
					LOG.debug(Thread.currentThread(),
							new StringBuffer("Se actualiza el partido: ")
									.append(rtMatch.getHashKey()).toString());
					matchResult = activatorMatch.execute(rtMatch, false);
					matchRepository.save(matchResult);
					result.add(matchResult);
				} else {
					LOG.debug(
							Thread.currentThread(),
							new StringBuffer("Se borra el partido: ").append(
									rtMatch.getHashKey()).toString());
					matchRepository.delete(rtMatch);
				}
			} else {
				result.add(rtMatch);
			}
		}

		LOG.debug(Thread.currentThread(), "Se finaliza el metodo removeBets");

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets#updateBets
	 * (com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO)
	 */
	/** {@inheritDoc} */ 
	@Override
	public List<RtMatch> updateBets(UpdaterBetsTO updaterBetsTO)
			throws UpdateBetsException {
		List<RtMatch> matchs;
		Boolean flag = Boolean.FALSE;

		LOG.debug(Thread.currentThread(), "Se inicia el metodo updateBets");

		matchs = matchRepository.getMatchsByHashKeyBetClean(updaterBetsTO
				.getHashKeysMatch());
		if (matchs.isEmpty()) {
			throw new UpdateBetsException(new StringBuffer(
					"No se ha encontrado ningun partido con el hash: ").append(
					updaterBetsTO.getHashKeysMatch()).toString());
		}

		for (RtMatch match : matchs) {
			flag = Boolean.FALSE;
			for (RtMarket market : match.getRtMarkets()) {
				for (String hashkey : updaterBetsTO.getMarketsHashKeys()) {
					if (market.getHashKeyDB().equals(hashkey)) {
						for (RtBet bet : market.getBets()) {
							if (updaterBetsTO.getBookmakerId().equals(
									bet.getBookmaker().getObjectId())) {
								bet.setActualizeDate(new Date());
								flag = Boolean.TRUE;
								LOG.debug(
										Thread.currentThread(),
										new StringBuffer(
												"Se actualiza la apuesta del bookmker: ")
												.append(bet.getBookmaker()
														.getObjectId()
														.toString()).toString());
							}
						}
					}
				}
			}
			if (flag) {
				matchRepository.saveWithoutValidation(match);
				LOG.debug(Thread.currentThread(),
						new StringBuffer("Se actualiza el match con hashKey: ")
								.append(match.getHashKey()).toString());
			} else {
				LOG.debug(
						Thread.currentThread(),
						new StringBuffer(
								"No se realiza la actualizacion del match con hashKey: ")
								.append(match.getHashKey()).toString());
			}
		}

		LOG.debug(Thread.currentThread(), "Se finaliza el metodo updateBets");

		return matchs;
	}
}
