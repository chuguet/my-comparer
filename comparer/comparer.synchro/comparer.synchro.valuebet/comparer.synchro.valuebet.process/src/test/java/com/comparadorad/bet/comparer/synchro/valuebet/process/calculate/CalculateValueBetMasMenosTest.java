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

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBetMasMenosTest.
 */
public class CalculateValueBetMasMenosTest extends
		AbstractValueBetCalculateTest {

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate value bet mas menos. */
	@Inject
	private CalculateValueBetMasMenos calculateValueBetMasMenos;

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
	 * @param masMenos
	 *            the mas menos
	 * @param totalGoles
	 *            the total goles
	 * @return the rt bet
	 */
	private RtBet createBet(String odd, RtParticipant participant,
			String idBookmaker, String urlBookamker, String masMenos,
			String totalGoles) {
		RtBet bet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		RtMasMenosAttribute attribute = new RtMasMenosAttribute();

		attribute = new RtMasMenosAttribute();
		attribute.setTotalGoalValue(Double.valueOf(totalGoles));
		attribute.setFinalValue(Double.valueOf(totalGoles));
		attribute.setMasMenos(MasMenos.valueOf(masMenos));

		betOdd.setOdds(odd);
		bet.setBetOdd(betOdd);
		bet.setParticipant(participant);
		bet.setAttribute(attribute);
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

		RtParticipant overRtparticipant = new RtParticipant();
		overRtparticipant.setAwayParticipant(false);
		overRtparticipant.setHomeParticipant(false);
		overRtparticipant.setOver(true);

		RtParticipant underRtparticipant = new RtParticipant();
		underRtparticipant.setAwayParticipant(false);
		underRtparticipant.setHomeParticipant(false);
		underRtparticipant.setUnder(true);

		List<RtBet> bets = new ArrayList<RtBet>();

		// Goles 1.5 (1 valuebet)
		// ****************************************************************

		// BETBOO
		bets.add(createBet("1.50", underRtparticipant, "17", "www.betboo.com",
				"MENOS", "1.5"));
		bets.add(createBet("2.85", overRtparticipant, "17", "www.betboo.com",
				"MAS", "1.5")); // Valuebet (exp = 1.00)

		// BETCLICK
		bets.add(createBet("1.50", underRtparticipant, "19",
				"www.betclick.com", "MENOS", "1.5"));
		bets.add(createBet("2.70", overRtparticipant, "19", "www.betclick.com",
				"MAS", "1.5"));

		// BETGUN
		bets.add(createBet("1.45", underRtparticipant, "27", "www.betgun.com",
				"MENOS", "1.5"));
		bets.add(createBet("2.65", overRtparticipant, "27", "www.betgun.com",
				"MAS", "1.5"));

		// Goles 2 (2 valuebets)
		// ****************************************************************

		// BETBOO
		bets.add(createBet("1.42", underRtparticipant, "17", "www.betboo.com",
				"MENOS", "2"));
		bets.add(createBet("3.20", overRtparticipant, "17", "www.betboo.com",
				"MAS", "2")); // Valuebet (exp = 1.11)

		// BETCLICK
		bets.add(createBet("1.60", underRtparticipant, "19",
				"www.betclick.com", "MENOS", "2")); // Valuebet (exp = 1.05)
		bets.add(createBet("2.50", overRtparticipant, "19", "www.betclick.com",
				"MAS", "2"));

		calculateValueBetData = calculateValueBetMasMenos
				.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(3, calculateValueBetData.size());

		for (CalculateValueBetData beanValueBetData : calculateValueBetData) {

			Double expectation = beanValueBetData.getExpectation().getValue();

			if (1.00d != expectation && 1.05d != expectation
					&& 1.11d != expectation) {
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
			if (expectation == 1.05d) {
				assertEquals(new Double(0.65), beanValueBetData
						.getProbability().getValue());
				assertEquals("1.60", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("19"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
			}
			if (expectation == 1.11d) {
				assertEquals(new Double(0.35), beanValueBetData
						.getProbability().getValue());
				assertEquals("3.20", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("17"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
			}
		}

	}

}
