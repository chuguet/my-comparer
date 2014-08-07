/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.web.server.mvc.core.comparator.SortedBetsByOdd;

/**
 * The Class UtilBets.
 */
@Component
public class UtilBets implements IUtilBets {

	/** The Constant APUESTA_INFIMA. */
	private static final String APUESTA_INFIMA = "0";

	/** The Constant APUESTA_INFINITA. */
	private static final String APUESTA_INFINITA = "999999999999999999999999999";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.util.IUtilBets#
	 * getGreaterBetsLimit(java.util.Set, java.lang.Integer)
	 */
	@Override
	public List<RtBet> getGreaterBetsLimit(Set<RtBet> bets, Integer limitBets) {
		List<RtParticipant> participants = getParticipantsWorstPayed(bets,
				limitBets);
		List<RtBet> result = getBestBetForEachParticipant(participants, bets);
		return result;
	}

	/**
	 * Gets the participants worst payed.
	 * 
	 * @param bets
	 *            the bets
	 * @param limit
	 *            the limit
	 * @return the participants worst payed
	 */
	private List<RtParticipant> getParticipantsWorstPayed(Set<RtBet> bets,
			Integer limit) {
		List<RtParticipant> participants = getAllParticipantFromBetNotRepeat(bets);
		List<RtBet> worstBetEachParticipant = getWorstBetForEachParticipant(
				participants, bets);
		List<RtParticipant> result = getWorstBetsFromParticipant(
				worstBetEachParticipant, limit);
		return result;
	}

	/**
	 * Gets the best bet for each participant.
	 * 
	 * @param participants
	 *            the participants
	 * @param bets
	 *            the bets
	 * @return the best bet for each participant
	 */
	private List<RtBet> getBestBetForEachParticipant(
			List<RtParticipant> participants, Set<RtBet> bets) {
		List<RtBet> result = new ArrayList<RtBet>();
		RtBet bet;
		for (RtParticipant participant : participants) {
			bet = getBestBetForParticipant(participant, bets);
			result.add(bet);
		}
		return result;
	}

	/**
	 * Gets the all participant from bet not repeat.
	 * 
	 * @param bets
	 *            the bets
	 * @return the all participant from bet not repeat
	 */
	private List<RtParticipant> getAllParticipantFromBetNotRepeat(
			Set<RtBet> bets) {
		List<RtParticipant> result = new ArrayList<RtParticipant>();
		for (RtBet bet : bets) {
			if (!result.contains(bet.getParticipant())) {
				result.add(bet.getParticipant());
			}
		}
		return result;
	}

	/**
	 * Gets the best bet for participant.
	 * 
	 * @param participant
	 *            the participant
	 * @param bets
	 *            the bets
	 * @return the best bet for participant
	 */
	private RtBet getBestBetForParticipant(RtParticipant participant,
			Set<RtBet> bets) {
		RtBet bestBet = new RtBet();
		bestBet.setBetOdd(new RtBetOdd());
		bestBet.getBetOdd().setOdds(APUESTA_INFIMA);

		for (RtBet bet : bets) {
			if (Float.valueOf(bestBet.getBetOdd().getOdds()) < Float
					.valueOf(bet.getBetOdd().getOdds())
					&& bet.getParticipant()
							.getCfgParticipant()
							.getObjectId()
							.equals(participant.getCfgParticipant()
									.getObjectId())) {
				bestBet = bet;
			}
		}
		return bestBet;
	}

	/**
	 * Gets the worst bets from participant.
	 * 
	 * @param bets
	 *            the bets
	 * @param limit
	 *            the limit
	 * @return the worst bets from participant
	 */
	private List<RtParticipant> getWorstBetsFromParticipant(List<RtBet> bets,
			Integer limit) {
		List<RtParticipant> result = new ArrayList<RtParticipant>();
		Collections.sort(bets, new SortedBetsByOdd());
		if (bets != null) {
			if (bets.size() >= limit) {
				for (int i = 0; i < limit; i++) {
					result.add(bets.get(i).getParticipant());
				}
			} else {
				for (int i = 0; i < bets.size(); i++) {
					result.add(bets.get(i).getParticipant());
				}
			}
		}
		return result;
	}

	/**
	 * Gets the worst bet for each participant.
	 * 
	 * @param participants
	 *            the participants
	 * @param bets
	 *            the bets
	 * @return the worst bet for each participant
	 */
	private List<RtBet> getWorstBetForEachParticipant(
			List<RtParticipant> participants, Set<RtBet> bets) {
		List<RtBet> result = new ArrayList<RtBet>();
		RtBet bet;
		for (RtParticipant participant : participants) {
			bet = getWorstBetForParticipant(participant, bets);
			result.add(bet);
		}
		return result;
	}

	/**
	 * Gets the worst bet for participant.
	 * 
	 * @param participant
	 *            the participant
	 * @param bets
	 *            the bets
	 * @return the worst bet for participant
	 */
	private RtBet getWorstBetForParticipant(RtParticipant participant,
			Set<RtBet> bets) {
		RtBet worstBet = new RtBet();
		worstBet.setBetOdd(new RtBetOdd());
		worstBet.getBetOdd().setOdds(APUESTA_INFINITA);

		for (RtBet bet : bets) {
			if (Float.valueOf(worstBet.getBetOdd().getOdds()) > Float
					.valueOf(bet.getBetOdd().getOdds())
					&& bet.getParticipant()
							.getCfgParticipant()
							.getObjectId()
							.equals(participant.getCfgParticipant()
									.getObjectId())) {
				worstBet = bet;
			}
		}
		return worstBet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.util.IUtilBets#
	 * getMarketById(com.comparadorad.bet.comparer.model.bet.bean.RtMatch,
	 * com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId)
	 */
	@Override
	public RtMarket getMarketByIdAndBetTypeEvent(RtMatch match,
			CfgBetTypeId betTypeId, CfgBetTypeEventId betTypeEventId) {
		RtMarket result = null;
		for (RtMarket market : match.getRtMarkets()) {
			if(betTypeEventId!=null) {
				if (market.getBetType().getNameId().equals(betTypeId.nameId())
						&& market.getBetTypeEvent().getBetTypeEvent().getNameId()
								.equals(betTypeEventId.nameId())) {
					result = market;
					break;
				}
			} else {
				if (market.getBetType().getNameId().equals(betTypeId.nameId())) {
					result = market;
					break;
				}				
			}
		}
		return result;
	}

}
