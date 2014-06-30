/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.calculate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBet1X2Test.
 */
public final class CalculateValueBet1X2Test extends
		AbstractValueBetCalculateTest {

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate value bet1 x2. */
	@Inject
	private CalculateValueBet1X2 calculateValueBet1X2;

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

	/**
	 * Test.
	 */
	@Test
	public void test() {

		List<CalculateValueBetData> calculateValueBetData;

		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);

		RtParticipant drawRtparticipant = new RtParticipant();
		drawRtparticipant.setAwayParticipant(false);
		drawRtparticipant.setHomeParticipant(false);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);

		List<RtBet> bets = new ArrayList<RtBet>();

		// BETBOO
		bets.add(createBet("3.47", homeRtparticipant, "17", "www.betboo.com"));
		bets.add(createBet("3.19", drawRtparticipant, "17", "www.betboo.com"));
		bets.add(createBet("2.19", awayRtparticipant, "17", "www.betboo.com"));

		// BETCLICK
		bets.add(createBet("3.55", homeRtparticipant, "19", "www.betclick.com"));
		bets.add(createBet("3.20", drawRtparticipant, "19", "www.betclick.com"));
		bets.add(createBet("2.40", awayRtparticipant, "19", "www.betclick.com")); // Valuebet

		// BETGUN
		bets.add(createBet("3.44", homeRtparticipant, "27", "www.betgun.com"));
		bets.add(createBet("3.14", drawRtparticipant, "27", "www.betgun.com"));
		bets.add(createBet("2.27", awayRtparticipant, "27", "www.betgun.com"));

		calculateValueBetData = calculateValueBet1X2.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(1, calculateValueBetData.size());

		CalculateValueBetData beanValueBetData = calculateValueBetData.get(0);

		// Odd
		assertEquals("2.40", beanValueBetData.getBet().getBetOdd().getOdds());

		// Bookmaker
		assertEquals(new BigInteger("19"), beanValueBetData.getBet()
				.getBookmaker().getObjectId());

		// Expectation
		assertEquals(Double.valueOf(1.01d), beanValueBetData.getExpectation()
				.getValue());

		// Probabilidad
		assertEquals(Double.valueOf(0.42d), beanValueBetData.getProbability()
				.getValue());

	}

}
