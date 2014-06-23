/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class PreproductionActivatorMatchTest.
 */
public class PreproductionActivatorMatchTest extends ActivatorMatchTest {

	/** The activator match. */
	@Inject
	private PreproductionActivatorMatch preproductionActivatorMatch;

	/**
	 * Execute test.
	 */
	@Test
	public void executeOneElementTest() {
		RtMatch match = new RtMatch();
		CfgBookmaker bookmakerOne = new CfgBookmaker(new BigInteger("1"),
				new BigInteger("0"));
		CfgBookmaker bookmakerTwo = new CfgBookmaker(new BigInteger("2"),
				new BigInteger("0"));
		RtMatch result;
		RtMarket market;

		market = new RtMarket();

		market.add(new RtBet(bookmakerOne));
		market.add(new RtBet(bookmakerTwo));

		match.add(market);

		assertNotNull(preproductionActivatorMatch);

		result = preproductionActivatorMatch.execute(match, Boolean.TRUE);

		assertTrue(result.getCoreActiveElement().getActive());
	}

	/**
	 * Execute several element test.
	 */
	@Test
	public void executeSeveralElementTest() {
		List<RtMatch> matchs = new ArrayList<RtMatch>();
		CfgBookmaker bookmakerOne = new CfgBookmaker(new BigInteger("1"),
				new BigInteger("0"));
		CfgBookmaker bookmakerTwo = new CfgBookmaker(new BigInteger("2"),
				new BigInteger("0"));
		RtMatch match;
		List<RtMatch> result;
		RtMarket market;

		match = new RtMatch();
		market = new RtMarket();

		market.add(new RtBet(bookmakerOne));
		market.add(new RtBet(bookmakerTwo));

		match.add(market);

		matchs.add(match);

		match = new RtMatch();
		market = new RtMarket();

		market.add(new RtBet(bookmakerOne));
		market.add(new RtBet(bookmakerTwo));

		match.add(market);

		matchs.add(match);

		assertNotNull(preproductionActivatorMatch);

		result = preproductionActivatorMatch.execute(matchs, Boolean.TRUE);

		for (RtMatch rtMatch : result) {
			assertTrue(rtMatch.getCoreActiveElement().getActive());
		}

	}

}
