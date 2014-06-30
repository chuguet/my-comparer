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

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Class CalculateValueBetMaximoGoleadorTest.
 */
public final class CalculateValueBetMaximoGoleadorTest extends
		AbstractValueBetCalculateTest {

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The calculate value bet maximo goleador. */
	@Inject
	private CalculateValueBetMaximoGoleador calculateValueBetMaximoGoleador;

	/** The participant repository. */
	@Inject
	private CfgParticipantRepository participantRepository;

	/**
	 * Creates the bet.
	 * 
	 * @param odd
	 *            the odd
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param urlBookamker
	 *            the url bookamker
	 * @param idParticipante
	 *            the id participante
	 * @return the rt bet
	 */
	private RtBet createBet(String odd, String idBookmaker,
			String urlBookamker, String idParticipante) {
		RtBet bet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		RtGanadorAttribute attribute = new RtGanadorAttribute();

		RtParticipant participant = new RtParticipant();
		participant.setCfgParticipant(this.participantRepository
				.findOne(new BigInteger(idParticipante)));

		String winnerName = participant.getCfgParticipant().getName(null);

		attribute.setWinnerName(winnerName);

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

		List<RtBet> bets = new ArrayList<RtBet>();

		// BETBOO
		bets.add(createBet("1.05", "17", "www.betboo.com", "829"));
		bets.add(createBet("25.00", "17", "www.betboo.com", "593886791")); // Valuebet
																			// (exp=1.15)
		bets.add(createBet("35.00", "17", "www.betboo.com", "824027119"));
		bets.add(createBet("401.00", "17", "www.betboo.com", "693494267"));

		// BETCLICK
		bets.add(createBet("1.05", "19", "www.betclick.com", "829"));
		bets.add(createBet("18.00", "19", "www.betclick.com", "593886791"));
		bets.add(createBet("34.00", "19", "www.betclick.com", "824027119"));
		bets.add(createBet("218.00", "19", "www.betclick.com", "839725429")); // Valuebet
																				// (exp=1.01)
		bets.add(createBet("401.00", "19", "www.betclick.com", "693494267"));

		// BETGUN
		bets.add(createBet("1.06", "27", "www.betboo.com", "829"));
		bets.add(createBet("20.00", "27", "www.betboo.com", "593886791"));
		bets.add(createBet("35.00", "27", "www.betboo.com", "824027119"));
		bets.add(createBet("200.00", "27", "www.betclick.com", "839725429"));

		calculateValueBetData = calculateValueBetMaximoGoleador
				.calculateValueBet(bets);
		assertNotNull(calculateValueBetData);
		assertEquals(2, calculateValueBetData.size());

		for (CalculateValueBetData beanValueBetData : calculateValueBetData) {

			Double expectation = beanValueBetData.getExpectation().getValue();

			if (1.15d != expectation && 1.01d != expectation) {
				fail("La esperanza matemática no es la esperada");
			}

			if (expectation == 1.15d) {
				assertEquals(new Double(0.05), beanValueBetData
						.getProbability().getValue());
				assertEquals("25.00", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("17"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
			}
			if (expectation == 1.01d) {
				assertEquals(new Double(0.0), beanValueBetData.getProbability()
						.getValue());
				assertEquals("218.00", beanValueBetData.getBet().getBetOdd()
						.getOdds());
				assertEquals(new BigInteger("19"), beanValueBetData.getBet()
						.getBookmaker().getObjectId());
			}

		}
	}

}
