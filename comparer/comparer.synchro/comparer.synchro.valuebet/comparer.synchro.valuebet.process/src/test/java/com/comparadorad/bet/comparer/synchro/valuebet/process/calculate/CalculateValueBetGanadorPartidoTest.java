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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBetGanadorPartidoTest.
 */
public final class CalculateValueBetGanadorPartidoTest extends
		AbstractValueBetCalculateTest {

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate value bet ganador partido. */
	@Inject
	private CalculateValueBetGanadorPartido calculateValueBetGanadorPartido;

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

		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();
		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		List<RtBet> bets = new ArrayList<RtBet>();

		// BETBOO
		bets.add(createBet("1.50", homeRtparticipant, "17", "www.betboo.com"));
		bets.add(createBet("2.15", awayRtparticipant, "17", "www.betboo.com")); // Valuebet

		// BETCLICK
		bets.add(createBet("2.10", homeRtparticipant, "19", "www.betclick.com")); // Valuebet
		bets.add(createBet("1.30", awayRtparticipant, "19", "www.betclick.com"));

		// BETGUN
		bets.add(createBet("1.45", homeRtparticipant, "27", "www.betgun.com"));
		bets.add(createBet("1.40", awayRtparticipant, "27", "www.betgun.com"));

		calculateValueBetData = calculateValueBetGanadorPartido
				.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(2, calculateValueBetData.size());

		for (CalculateValueBetData beanValueBetData : calculateValueBetData) {

			Double expectation = beanValueBetData.getExpectation().getValue();

			if (1.10d != expectation && 1.03d != expectation) {
				fail("La esperanza matemática no es la esperada");
			}

			if (expectation == 1.10) {
				assertEquals("2.15", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("17"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
				assertEquals(Double.valueOf(0.51d), beanValueBetData
						.getProbability().getValue());
			}
			if (expectation == 1.03d) {
				assertEquals("2.10", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("19"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
				assertEquals(Double.valueOf(0.49d), beanValueBetData
						.getProbability().getValue());
			}

		}

	}

}
