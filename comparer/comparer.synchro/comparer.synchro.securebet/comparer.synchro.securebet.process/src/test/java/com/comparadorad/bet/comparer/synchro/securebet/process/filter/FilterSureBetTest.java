/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.securebet.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate.Calculate1X2SecureBet;

/**
 * The Class FilterSureBetTest.
 */
public class FilterSureBetTest extends AbstractTest {

	/** The bet type repository. */
	@Inject
	private CfgBetTypeRepository betTypeRepository;

	/** The bet type event repository. */
	@Inject
	private CfgBetTypeEventRepository betTypeEventRepository;

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate1x2 secure bet. */
	@Inject
	private Calculate1X2SecureBet calculate1x2SecureBet;

	/**
	 * Testt.
	 */
	@Test
	public void passFilter() {
		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();
		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		RtParticipant drawRtparticipant = new RtParticipant();
		drawRtparticipant.setAwayParticipant(false);
		drawRtparticipant.setHomeParticipant(false);
		rtParticipants.add(drawRtparticipant);

		cfgCompetition.setObjectId(BigInteger.ONE);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("1"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;

		// BETBOO
		bet = createBet("3.11", awayRtparticipant, "19", "www.betboo.com");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com");
		bets.add(bet);

		bet = createBet("1.31", drawRtparticipant, "19", "www.betboo.com");
		bets.add(bet);

		// BETCLICK
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com");
		bets.add(bet);

		bet = createBet("3.21", homeRtparticipant, "17", "www.betclick.com");
		bets.add(bet);

		bet = createBet("3.13", drawRtparticipant, "17", "www.betclick.com");
		bets.add(bet);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);

		match.setMatchId(matchId);
		match.add(rtMarket);

		calculateSecureBetBean = calculate1x2SecureBet
				.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(1, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetTypeEvent());
		assertEquals(cfgCompetition, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getMatch().getMatchId().getCompetition());
		SureBetsMarket bean = calculateSecureBetBean.getSureBetsMarket().get(0);
		for (SecureBeanBenefit beanBenefit : bean.getSecureBetAgrupation()
				.keySet()) {
			Double number = Math.rint(beanBenefit.getValue() * 100) / 100;
			assertEquals((Double) 4.98, number);
		}
	}

	/**
	 * Testt.
	 */
	@Test
	public void notPassFilter() {
		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();
		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		RtParticipant drawRtparticipant = new RtParticipant();
		drawRtparticipant.setAwayParticipant(false);
		drawRtparticipant.setHomeParticipant(false);
		rtParticipants.add(drawRtparticipant);

		cfgCompetition.setObjectId(BigInteger.ONE);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("1"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;

		// BETBOO
		bet = createBet("13.11", awayRtparticipant, "19", "www.betboo.com");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com");
		bets.add(bet);

		bet = createBet("1.31", drawRtparticipant, "19", "www.betboo.com");
		bets.add(bet);

		// BETCLICK
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com");
		bets.add(bet);

		bet = createBet("3.21", homeRtparticipant, "17", "www.betclick.com");
		bets.add(bet);

		bet = createBet("3.13", drawRtparticipant, "17", "www.betclick.com");
		bets.add(bet);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);

		match.setMatchId(matchId);
		match.add(rtMarket);

		calculateSecureBetBean = calculate1x2SecureBet
				.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(1, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetTypeEvent());
		assertEquals(cfgCompetition, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getMatch().getMatchId().getCompetition());
		SureBetsMarket bean = calculateSecureBetBean.getSureBetsMarket().get(0);
		assertTrue(bean.getSecureBetAgrupation().isEmpty());
	}

	/**
	 * Creates the bet.
	 * 
	 * @param odd
	 *            the odd
	 * @param participant
	 *            the participant
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param urlBookamker
	 *            the url bookamker
	 * @return the rt bet
	 */
	private RtBet createBet(String odd, RtParticipant participant,
			String idBookmaker, String urlBookamker) {
		RtBet bet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		betOdd.setOdds(odd);
		bet.setBetOdd(betOdd);
		bet.setParticipant(participant);
		bet.setBookmaker(this.bookmakerRepository.findOne(new BigInteger(
				idBookmaker)));
		return bet;
	}
}
