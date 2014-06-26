/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategy1x2;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.StrategyResolver1X2;

/**
 * The Class StrategyResolverBetClickTest.
 */
public class StrategyResolver1X2Test extends AbstractTest {

	/** The strategy resolver bet click. */
	@Inject
	@Resource(name = "strategyResolver1X2")
	private StrategyResolver1X2 strategyResolverMatchResult;

	/**
	 * Handicap test.
	 */
	@Test
	public final void matchResultHandicapTest() {
		CfgBookmaker bookmaker = setBookmaker();
		CfgBookmakerBetTypeStrategy1x2 cfgBookmakerBetTypeStrategyMatchResult 
			= new CfgBookmakerBetTypeStrategy1x2();
		cfgBookmakerBetTypeStrategyMatchResult.setDrawPatternStrategy("Draw",
				"%1%", "%2%");
		bookmaker.getBookmakerConfiguration().getBookmakerBetTypeStrategies()
				.addBetTypeStrategy(cfgBookmakerBetTypeStrategyMatchResult);
		CfgBetType cfgBetType = new CfgBetType();
		cfgBetType.setNameId("MatchResult");
		cfgBetType.setName("Match Result");
		StrategyData pStrategyData = new StrategyData(cfgBetType, bookmaker,
				"Match Result");

		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setName("%1%");
		Rt1X2Attribute attribute = (Rt1X2Attribute) strategyResolverMatchResult
				.resolverAbstractRtResult(pStrategyData, xmlMarketBet, null);
		assertNotNull(attribute);
		Result result = attribute.getResult();
		assertEquals(result, Result.ONE);
		assertNotSame(attribute, Rt1X2Attribute.class);
	}

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Override
	public final void test() {
		StrategyData pStrategyData = new StrategyData(null, null, null);
		assertNotNull(pStrategyData);
	}

}
