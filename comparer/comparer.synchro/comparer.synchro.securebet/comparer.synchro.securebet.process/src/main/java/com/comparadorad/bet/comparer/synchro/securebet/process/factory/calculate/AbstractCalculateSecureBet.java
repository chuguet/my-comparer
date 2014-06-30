/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.securebet.process.beans.SureBetConfiguration;
import com.comparadorad.bet.comparer.synchro.securebet.process.combination.RtBetCombination;
import com.comparadorad.bet.comparer.synchro.securebet.process.convert.IListRtBetToSecureBetBeanConverter;
import com.comparadorad.bet.comparer.synchro.securebet.process.filter.IFilterSureBet;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractCalculateSecureBet.
 */
public abstract class AbstractCalculateSecureBet implements ICalculateSecureBet {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The convert. */
	@Inject
	private IListRtBetToSecureBetBeanConverter<List<List<RtBet>>, SureBetsMarket> convert;

	/** The filter sure bet. */
	@Inject
	private IFilterSureBet filterSureBet;

	/** The sure bet configuration. */
	@Inject
	private SureBetConfiguration sureBetConfiguration;

	/**
	 * Calculate secure bet for rt market.
	 * 
	 * @param match
	 *            the match
	 * @param rtMarket
	 *            the rt market
	 * @return the calculate secure bet bean {@inheritDoc}
	 */
	@Override
	public SureBetsMatch calculateSecureBetForRtMarket(RtMatch match,
			RtMarket rtMarket) {
		SureBetsMatch result = new SureBetsMatch();
		if (isPossibleCalculateSecureBet(rtMarket, match.getMatchId()
				.getParticipiants().size())) {
			List<List<RtBet>> findSecureBet = findBetSecure(rtMarket.getBets(),
					match.getMatchId().getParticipiants());
			result.add(convert.convert(match, rtMarket, findSecureBet));
		} else {
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer()
							.append("Se ha descartado la apuesta de tipo ")
							.append(rtMarket.getBetType().getNameId())
							.append(" por superar el numero de participantes configurados, tiene ")
							.append(match.getMatchId().getParticipiants()
									.size()).append(" participantes.")
							.toString());
		}
		return result;
	}

	/**
	 * Calculate.
	 * 
	 * @param rtBets
	 *            the rt bets
	 * @param participants
	 *            the participants
	 * @return the secure bean data
	 */
	protected List<List<RtBet>> findBetSecure(Set<RtBet> rtBets,
			Set<RtParticipant> participants) {
		List<List<RtBet>> combinationsRtBet;
		List<List<RtBet>> secureBet;
		Map<RtParticipant, Set<RtBet>> rtBetForParticipant;
		rtBetForParticipant = getRtBetForParticipant(rtBets);
		combinationsRtBet = getRtBetCombinations(rtBetForParticipant,
				participants.size());
		secureBet = searchBetsecure(combinationsRtBet);
		return secureBet;
	}

	/**
	 * Gets the convert.
	 * 
	 * @return the convert
	 */
	protected IListRtBetToSecureBetBeanConverter<List<List<RtBet>>, SureBetsMarket> getConvert() {
		return convert;
	}

	/**
	 * Gets the order combinations.
	 * 
	 * @param numParticipants
	 *            the num participants
	 * @return the order combinations
	 */
	protected abstract Integer getOrderCombinations(Integer numParticipants);

	/**
	 * Gets the rt bet combinations.
	 * 
	 * @param map
	 *            the map
	 * @param numParticipants
	 *            the num participants
	 * @return the rt bet combinations
	 */
	protected List<List<RtBet>> getRtBetCombinations(
			Map<RtParticipant, Set<RtBet>> map, Integer numParticipants) {
		RtBetCombination combination;
		List<RtBet[]> groupbets = new ArrayList<RtBet[]>();
		for (RtParticipant participant : map.keySet()) {
			List<RtBet> bets = new ArrayList<RtBet>();
			for (RtBet rtBet : map.get(participant)) {
				bets.add(rtBet);
			}
			groupbets.add(bets.toArray(new RtBet[bets.size()]));
		}
		combination = new RtBetCombination(groupbets);
		return combination
				.getCombinations(getOrderCombinations(numParticipants));

	}

	/**
	 * Gets the rt bet for participant.
	 * 
	 * @param rtBets
	 *            the rt bets
	 * @return the rt bet for participant
	 */
	protected Map<RtParticipant, Set<RtBet>> getRtBetForParticipant(
			Set<RtBet> rtBets) {
		Map<RtParticipant, Set<RtBet>> result = new HashMap<RtParticipant, Set<RtBet>>();
		RtParticipant participant;
		Set<RtBet> bets;
		for (RtBet rtBet : rtBets) {
			participant = rtBet.getParticipant();
			if (result.containsKey(participant)) {
				bets = result.get(participant);
				bets.add(rtBet);
				result.put(participant, bets);
			} else {
				bets = new HashSet<RtBet>();
				bets.add(rtBet);
				result.put(participant, bets);
			}
		}
		return result;
	}

	/**
	 * Checks if is active.
	 * 
	 * @return the boolean
	 */
	protected Boolean isActive() {
		return Boolean.TRUE;
	}

	/**
	 * Checks if is possible calculate secure bet.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @param sizeParticipants
	 *            the size participants
	 * @return the boolean
	 */
	protected Boolean isPossibleCalculateSecureBet(RtMarket rtMarket,
			Integer sizeParticipants) {
		Set<CfgParticipant> cfgParticipants = new HashSet<CfgParticipant>();
		Boolean result = Boolean.FALSE;
		if (sizeParticipants <= sureBetConfiguration.getMaxParticipant()
				&& isActive()) {
			if (rtMarket != null) {
				for (RtBet rtBet : rtMarket.getBets()) {
					cfgParticipants.add(rtBet.getParticipant()
							.getCfgParticipant());
				}
				if (cfgParticipants.size() <= sureBetConfiguration
						.getMaxParticipant()) {
					result = Boolean.TRUE;
				}
			}
		}
		return result;
	}

	/**
	 * Search betsecure.
	 * 
	 * formula de calculo de apuesta segura (Sumatorio(1/Odds)) > 1
	 * 
	 * @param rtBets
	 *            the rt bets
	 * @return the list
	 */
	protected List<List<RtBet>> searchBetsecure(List<List<RtBet>> rtBets) {
		List<List<RtBet>> result = new ArrayList<List<RtBet>>();
		Double oddforBenefit, benefit, probabilityOdd, probabilityStake, summation, stake, odd;
		Boolean valid;
		for (List<RtBet> rtBetlist : rtBets) {
			summation = 0d;
			valid = Boolean.TRUE;
			for (RtBet rtBet : rtBetlist) {
				odd = Double.parseDouble(rtBet.getBetOdd().getOdds());
				if (odd > 0) {
					summation += 1 / odd;
				} else {
					valid = Boolean.FALSE;
					break;
				}
			}
			if (valid) {
				oddforBenefit = Double.parseDouble(rtBetlist.get(0).getBetOdd()
						.getOdds());
				probabilityOdd = 1 / oddforBenefit;
				probabilityStake = probabilityOdd / summation;
				stake = probabilityStake * 100;
				benefit = (stake * oddforBenefit) - 100;

				if (filterSureBet.filterMeetsRanges(benefit)) {
					LOG.info(Thread.currentThread(), new StringBuffer(
							"Se encuentra una apuesta segura [BENEFIT: ")
							.append(benefit).append("]").toString());
					result.add(rtBetlist);
				}
			}

		}
		return result;
	}
}
