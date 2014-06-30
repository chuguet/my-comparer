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
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBet1X2Test.
 */
public final class CalculateValueBetHandicapAsiaticoTest extends
		AbstractValueBetCalculateTest {

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate value bet handicap asiatico. */
	@Inject
	private CalculateValueBetHandicapAsiatico calculateValueBetHandicapAsiatico;

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
	 * @param primero
	 *            the primero
	 * @param ganador
	 *            the ganador
	 * @return the rt bet
	 */
	private RtBet createBet(String odd, RtParticipant participant,
			String idBookmaker, String urlBookamker, Double primero,
			String ganador) {
		RtBet bet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		betOdd.setOdds(odd);
		bet.setBetOdd(betOdd);
		bet.setParticipant(participant);

		RtAsianHandicapAttribute handicapAttribute = new RtAsianHandicapAttribute();

		handicapAttribute.setFirstValue(primero);
		handicapAttribute.setFinalValue(primero);
		handicapAttribute.setAsianResult(AsianResult.valueOf(ganador));

		bet.setAttribute(handicapAttribute);

		bet.setBookmaker(this.bookmakerRepository.findOne(new BigInteger(
				idBookmaker)));
		return bet;
	}

	/**
	 * No value bet test.
	 */
	@Test
	public void noValueBetTest() {

		List<CalculateValueBetData> calculateValueBetData;

		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);

		List<RtBet> bets = new ArrayList<RtBet>();

		// Handicap -3
		// ****************************************************************

		// BETBOO
		bets.add(createBet("1.45", homeRtparticipant, "17", "www.betboo.com",
				-3d, "ONE"));
		bets.add(createBet("3.10", awayRtparticipant, "17", "www.betboo.com",
				-3d, "TWO"));

		// BETCLICK
		bets.add(createBet("1.43", homeRtparticipant, "19", "www.betclick.com",
				-3d, "ONE"));
		bets.add(createBet("3.00", awayRtparticipant, "19", "www.betclick.com",
				-3d, "TWO"));

		// BETGUN
		bets.add(createBet("1.44", homeRtparticipant, "27", "www.betgun.com",
				-3d, "ONE"));
		bets.add(createBet("3.10", awayRtparticipant, "27", "www.betgun.com",
				-3d, "TWO"));

		// PINNACLE
		bets.add(createBet("1.43", homeRtparticipant, "85", "www.betgun.com",
				-3d, "ONE"));
		bets.add(createBet("3.00", awayRtparticipant, "85", "www.betgun.com",
				-3d, "TWO"));

		calculateValueBetData = calculateValueBetHandicapAsiatico
				.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(0, calculateValueBetData.size());

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

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);

		List<RtBet> bets = new ArrayList<RtBet>();

		// Handicap 1 (1 valuebet)
		// ****************************************************************

		// BETBOO
		bets.add(createBet("1.50", homeRtparticipant, "17", "www.betboo.com",
				1d, "ONE"));
		bets.add(createBet("2.85", awayRtparticipant, "17", "www.betboo.com",
				1d, "TWO")); // Valuebet (exp = 1.00)

		// BETCLICK
		bets.add(createBet("1.50", homeRtparticipant, "19", "www.betclick.com",
				1d, "ONE"));
		bets.add(createBet("2.70", awayRtparticipant, "19", "www.betclick.com",
				1d, "TWO"));

		// BETGUN
		bets.add(createBet("1.45", homeRtparticipant, "27", "www.betgun.com",
				1d, "ONE"));
		bets.add(createBet("2.65", awayRtparticipant, "27", "www.betgun.com",
				1d, "TWO"));

		// Handicap -1 (2 valuebets)
		// ****************************************************************

		// BETBOO
		bets.add(createBet("2.50", homeRtparticipant, "17", "www.betboo.com",
				-1d, "ONE"));
		bets.add(createBet("1.55", awayRtparticipant, "17", "www.betboo.com",
				-1d, "TWO"));

		// BETCLICK
		bets.add(createBet("2.65", homeRtparticipant, "19", "www.betclick.com",
				-1d, "ONE")); // Valuebet (exp=1.03)
		bets.add(createBet("1.60", awayRtparticipant, "19", "www.betclick.com",
				-1d, "TWO"));

		// BETGUN
		bets.add(createBet("2.50", homeRtparticipant, "27", "www.betgun.com",
				-1d, "ONE"));
		bets.add(createBet("1.60", awayRtparticipant, "27", "www.betgun.com",
				-1d, "TWO"));

		// PINNACLE
		bets.add(createBet("2.40", homeRtparticipant, "85", "www.betgun.com",
				-1d, "ONE"));
		bets.add(createBet("1.65", awayRtparticipant, "85", "www.betgun.com",
				-1d, "TWO")); // Valuebet (exp=1.01)

		calculateValueBetData = calculateValueBetHandicapAsiatico
				.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(3, calculateValueBetData.size());

		for (CalculateValueBetData beanValueBetData : calculateValueBetData) {

			Double expectation = beanValueBetData.getExpectation().getValue();

			if (1.00d != expectation && 1.01d != expectation
					&& 1.03d != expectation) {
				fail("La esperanza matemática no es la esperada");
			}

			if (expectation == 1.00d) {
				assertEquals("2.85", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("17"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
				assertEquals(Double.valueOf(0.35d), beanValueBetData
						.getProbability().getValue());
			}
			if (expectation == 1.01d) {
				assertEquals("1.65", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("85"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
				assertEquals(new Double(0.61), beanValueBetData
						.getProbability().getValue());
			}
			if (expectation == 1.03d) {
				assertEquals("2.65", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("19"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
				assertEquals(new Double(0.39), beanValueBetData
						.getProbability().getValue());
			}
		}

	}

}
