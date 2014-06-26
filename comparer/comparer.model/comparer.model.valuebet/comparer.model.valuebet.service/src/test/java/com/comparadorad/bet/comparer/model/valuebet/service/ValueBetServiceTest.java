/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.valuebet.service;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetMathematicalExpectation;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;

/**
 * The Class ValueBetServiceTest.
 */
public class ValueBetServiceTest extends AbstractServiceTest<ValueBetData> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(ValueBetServiceTest.class);

	/** The secure bet service. */
	@Inject
	private IValueBetService valueBetService;

	/**
	 * Gets the bet.
	 * 
	 * @param value
	 *            the value
	 * @return the bet
	 */
	private RtBet getBet(String value) {
		RtBet bet = new RtBet();
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setObjectId(new BigInteger("19"));
		bet.setBookmaker(bookmaker);
		RtBetOdd betOdd = new RtBetOdd();
		betOdd.setOdds(value);
		betOdd.setFraOdds(value);
		betOdd.setAmericanOdds(value);
		bet.setBetOdd(betOdd);
		RtParticipant participant = new RtParticipant();
		participant.setAwayParticipant(false);
		participant.setHomeParticipant(true);
		bet.setParticipant(participant);
		return bet;
	}

	/**
	 * Gets the expectation.
	 * 
	 * @param value
	 *            the value
	 * @return the expectation
	 */
	private ValueBetMathematicalExpectation getExpectation(String value) {
		ValueBetMathematicalExpectation expectation = new ValueBetMathematicalExpectation();
		expectation.setValue(new Double(value));
		return expectation;
	}

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<ValueBetData> getIGenericService() {
		return valueBetService;
	}

	/**
	 * Gets the match.
	 * 
	 * @param pId
	 *            the id
	 * @return the match
	 */
	private InfoMatch getMatch(String pId) {
		InfoMatch match = new InfoMatch();
		match.setObjectId(new BigInteger(pId));
		return match;
	}

	/**
	 * Gets the probability.
	 * 
	 * @param value
	 *            the value
	 * @return the probability
	 */
	private ValueBetProbability getProbability(String value) {
		ValueBetProbability probability = new ValueBetProbability();
		probability.setValue(new Double(value));
		return probability;
	}

	/**
	 * Test exist.
	 */
	@Test
	public void testExist() {
	}

}
