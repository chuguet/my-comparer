/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;

/**
 * The Class ProductionActivatorMatchTest.
 */
public class ProductionActivatorMatchTest extends ActivatorMatchTest {

	/** The activator match. */
	@Inject
	private ProductionActivatorMatch productionActivatorMatch;

	@Test
	public void executeSameGroupTest() {

		RtMatch match;
		CfgBetType cfgBetType;
		CfgBookmaker bookmakerOne = new CfgBookmaker(new BigInteger("1"),
				new BigInteger("2"));
		CfgBookmaker bookmakerTwo = new CfgBookmaker(new BigInteger("2"),
				new BigInteger("2"));
		RtMatch result;
		RtMarket market;

		match = new RtMatch();
		match.setCoreActiveElement(new CoreActiveElement(Boolean.FALSE));
		market = new RtMarket();

		cfgBetType = new CfgBetType();
		cfgBetType.setObjectId( new BigInteger("2") );

		market.setBetType(cfgBetType);
		market.add(new RtBet(bookmakerOne));
		market.add(new RtBet(bookmakerTwo));

		match.add(market);

		assertNotNull(productionActivatorMatch);

		result = productionActivatorMatch.execute(match, Boolean.FALSE);

		assertFalse(result.getCoreActiveElement().getActive());

		result = productionActivatorMatch.execute(match, Boolean.TRUE);

		assertTrue(result.getCoreActiveElement().getActive());

	}

	@Test
	public void executeDifferentGroupTest() {

		RtMatch match;
		CfgBetType cfgBetType;
		CfgBookmaker bookmakerOne = new CfgBookmaker(new BigInteger("1"),
				new BigInteger("1"));
		CfgBookmaker bookmakerTwo = new CfgBookmaker(new BigInteger("2"),
				new BigInteger("2"));
		RtMatch result;
		RtMarket market;

		match = new RtMatch();
		match.setCoreActiveElement(new CoreActiveElement(Boolean.FALSE));
		market = new RtMarket();
		
		cfgBetType = new CfgBetType();
		cfgBetType.setObjectId( new BigInteger("2") );

		market.setBetType(cfgBetType);
		market.add(new RtBet(bookmakerOne));
		market.add(new RtBet(bookmakerTwo));
		

		match.add(market);

		assertNotNull(productionActivatorMatch);

		result = productionActivatorMatch.execute(match, Boolean.FALSE);

		assertTrue(result.getCoreActiveElement().getActive());

		result = productionActivatorMatch.execute(match, Boolean.TRUE);


	}

	/**
	 * Execute test.
	 */
	@Test
	public void executeZeroGroupTest() {
		RtMatch match;
		CfgBetType cfgBetType;
		CfgBookmaker bookmakerOne = new CfgBookmaker(new BigInteger("1"),
				new BigInteger("0"));
		CfgBookmaker bookmakerTwo = new CfgBookmaker(new BigInteger("2"),
				new BigInteger("0"));
		RtMatch result;
		RtMarket market;

		match = new RtMatch();
		match.setCoreActiveElement(new CoreActiveElement(Boolean.FALSE));
		market = new RtMarket();
		
		cfgBetType = new CfgBetType();
		cfgBetType.setObjectId( new BigInteger("2") );

		market.setBetType(cfgBetType);
		market.add(new RtBet(bookmakerOne));
		market.add(new RtBet(bookmakerTwo));

		match.add(market);

		assertNotNull(productionActivatorMatch);

		result = productionActivatorMatch.execute(match, Boolean.TRUE);

		assertTrue(result.getCoreActiveElement().getActive());

		result = productionActivatorMatch.execute(match, Boolean.FALSE);

		assertTrue(result.getCoreActiveElement().getActive());

	}

	@Test
	public void executeSeveralElementTest() {
		assertNotNull(productionActivatorMatch);
	}

}
