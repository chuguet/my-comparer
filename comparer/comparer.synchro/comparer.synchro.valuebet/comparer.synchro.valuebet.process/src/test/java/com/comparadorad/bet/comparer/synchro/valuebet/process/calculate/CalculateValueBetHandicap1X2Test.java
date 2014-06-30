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

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBet1X2Test.
 */
public final class CalculateValueBetHandicap1X2Test extends
		AbstractValueBetCalculateTest {

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate value bet handicap1 x2. */
	@Inject
	private CalculateValueBetHandicap1X2 calculateValueBetHandicap1X2;

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

		Rt1X2HandicapAttribute handicapAttribute = new Rt1X2HandicapAttribute();

		handicapAttribute.setFirstValue(primero);
		handicapAttribute.setFinalValue(primero);
		handicapAttribute.setResult(Result.valueOf(ganador));

		bet.setAttribute(handicapAttribute);

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

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);

		RtParticipant drawRtparticipant = new RtParticipant();
		drawRtparticipant.setAwayParticipant(false);
		drawRtparticipant.setHomeParticipant(false);

		List<RtBet> bets = new ArrayList<RtBet>();

		// Handicap 1 (4 valuebets)
		// ****************************************************************

		// BETBOO
		bets.add(createBet("2.50", homeRtparticipant, "17", "www.betboo.com",
				1d, "ONE"));
		bets.add(createBet("3.10", drawRtparticipant, "17", "www.betboo.com",
				1d, "DRAW")); // Valuebet exp = 1.00
		bets.add(createBet("3.40", awayRtparticipant, "17", "www.betboo.com",
				1d, "TWO"));

		// BETCLICK
		bets.add(createBet("2.40", homeRtparticipant, "19", "www.betclick.com",
				1d, "ONE"));
		bets.add(createBet("3.00", drawRtparticipant, "19", "www.betclick.com",
				1d, "DRAW"));
		bets.add(createBet("3.50", awayRtparticipant, "19", "www.betclick.com",
				1d, "TWO")); // Valuebet exp = 1.03

		// BETGUN
		bets.add(createBet("2.70", homeRtparticipant, "27", "www.betgun.com",
				1d, "ONE")); // Valuebet exp = 1.04
		bets.add(createBet("2.9", drawRtparticipant, "27", "www.betgun.com",
				1d, "DRAW"));
		bets.add(createBet("3.10", awayRtparticipant, "27", "www.betgun.com",
				1d, "TWO"));

		// PINNACLE
		bets.add(createBet("2.60", homeRtparticipant, "85", "www.betgun.com",
				1d, "ONE"));
		bets.add(createBet("3.12", drawRtparticipant, "85", "www.betgun.com",
				1d, "DRAW")); // Valuebet exp = 1.00
		bets.add(createBet("3.30", awayRtparticipant, "85", "www.betgun.com",
				1d, "TWO"));

		// Handicap -1 (2 valuebets)
		// ****************************************************************
		// BETBOO
		bets.add(createBet("2.50", homeRtparticipant, "17", "www.betboo.com",
				-1d, "ONE"));
		bets.add(createBet("3.10", drawRtparticipant, "17", "www.betboo.com",
				-1d, "DRAW")); // Valuebet exp = 1.01
		bets.add(createBet("3.40", awayRtparticipant, "17", "www.betboo.com",
				-1d, "TWO"));

		// BETCLICK
		bets.add(createBet("2.40", homeRtparticipant, "19", "www.betclick.com",
				-1d, "ONE"));
		bets.add(createBet("3.00", drawRtparticipant, "19", "www.betclick.com",
				-1d, "DRAW"));
		bets.add(createBet("3.50", awayRtparticipant, "19", "www.betclick.com",
				-1d, "TWO"));

		// BETGUN
		bets.add(createBet("2.60", homeRtparticipant, "27", "www.betgun.com",
				-1d, "ONE")); // Valuebet exp = 1.02
		bets.add(createBet("2.90", drawRtparticipant, "27", "www.betgun.com",
				-1d, "DRAW"));
		bets.add(createBet("3.40", awayRtparticipant, "27", "www.betgun.com",
				-1d, "TWO"));

		// Handicap -2.5 (Ningun valuebet)
		// ****************************************************************
		// BETBOO
		bets.add(createBet("2.40", homeRtparticipant, "17", "www.betboo.com",
				-2.5d, "ONE"));
		bets.add(createBet("3.10", drawRtparticipant, "17", "www.betboo.com",
				-2.5d, "DRAW"));
		bets.add(createBet("3.40", awayRtparticipant, "17", "www.betboo.com",
				-2.5d, "TWO"));

		// BETCLICK
		bets.add(createBet("2.40", homeRtparticipant, "19", "www.betclick.com",
				-2.5d, "ONE"));
		bets.add(createBet("3.00", drawRtparticipant, "19", "www.betclick.com",
				-2.5d, "DRAW"));
		bets.add(createBet("3.50", awayRtparticipant, "19", "www.betclick.com",
				-2.5d, "TWO"));

		calculateValueBetData = calculateValueBetHandicap1X2
				.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(6, calculateValueBetData.size());

		for (CalculateValueBetData beanValueBetData : calculateValueBetData) {

			Double expectation = beanValueBetData.getExpectation().getValue();

			if (beanValueBetData.getBet().getAttribute().getFinalValue() == 1d) {
				if (1.00d != expectation && 1.01d != expectation
						&& 1.03d != expectation && 1.04d != expectation) {
					fail("La esperanza matemática no es la esperada");
				}
				if (expectation == 1.00d) {
					assertEquals("3.10", beanValueBetData.getBet().getBetOdd()
							.getOdds());
					assertEquals(new BigInteger("17"), beanValueBetData
							.getBet().getBookmaker().getObjectId());
					assertEquals(Double.valueOf(0.32d), beanValueBetData
							.getProbability().getValue());
				} else if (expectation == 1.01d) {
					assertEquals("3.12", beanValueBetData.getBet().getBetOdd()
							.getOdds());
					assertEquals(new BigInteger("85"), beanValueBetData
							.getBet().getBookmaker().getObjectId());
					assertEquals(Double.valueOf(0.32d), beanValueBetData
							.getProbability().getValue());
				} else if (expectation == 1.03d) {
					assertEquals("3.50", beanValueBetData.getBet().getBetOdd()
							.getOdds());
					assertEquals(new BigInteger("19"), beanValueBetData
							.getBet().getBookmaker().getObjectId());
					assertEquals(Double.valueOf(0.29d), beanValueBetData
							.getProbability().getValue());
				} else if (expectation == 1.04d) {
					assertEquals("2.70", beanValueBetData.getBet().getBetOdd()
							.getOdds());
					assertEquals(new BigInteger("27"), beanValueBetData
							.getBet().getBookmaker().getObjectId());
					assertEquals(Double.valueOf(0.38d), beanValueBetData
							.getProbability().getValue());
				}
			} else if (beanValueBetData.getBet().getAttribute().getFinalValue() == -1d) {
				if (1.01d != expectation && 1.02d != expectation) {
					fail("La esperanza matemática no es la esperada");
				}
				if (expectation == 1.01d) {
					assertEquals("3.10", beanValueBetData.getBet().getBetOdd()
							.getOdds());
					assertEquals(new BigInteger("17"), beanValueBetData
							.getBet().getBookmaker().getObjectId());
					assertEquals(Double.valueOf(0.33d), beanValueBetData
							.getProbability().getValue());
				} else if (expectation == 1.02d) {
					assertEquals("2.60", beanValueBetData.getBet().getBetOdd()
							.getOdds());
					assertEquals(new BigInteger("27"), beanValueBetData
							.getBet().getBookmaker().getObjectId());
					assertEquals(Double.valueOf(0.39d), beanValueBetData
							.getProbability().getValue());
				}
			} else {
				fail("No se ha encontrado el valuebet esperado");
			}

		}

	}

}
