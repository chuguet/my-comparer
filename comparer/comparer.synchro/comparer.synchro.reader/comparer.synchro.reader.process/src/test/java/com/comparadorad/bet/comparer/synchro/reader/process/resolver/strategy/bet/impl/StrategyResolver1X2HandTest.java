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

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategy1X2Handicap;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.StrategyResolver1X2Handicap;

/**
 * The Class StrategyResolverBetClickTest.
 */
public class StrategyResolver1X2HandTest extends AbstractTest {

	/** The strategy resolver bet click. */
	@Inject
	@Resource(name = "strategyResolver1X2Handicap")
	private StrategyResolver1X2Handicap strategyResolverHandicap;

	/**
	 * Handicap test.
	 */
	@Test
	public final void handicapTest() {
		CfgBookmaker bookmaker = setBookmaker();
		CfgBookmakerBetTypeStrategy1X2Handicap cfgBookmakerBetTypeStrategyHandicap 
			= new CfgBookmakerBetTypeStrategy1X2Handicap();
		cfgBookmakerBetTypeStrategyHandicap.setDrawPatternStrategy("Draw",
				"%1%", "%2%");
		bookmaker.getBookmakerConfiguration().getBookmakerBetTypeStrategies()
				.addBetTypeStrategy(cfgBookmakerBetTypeStrategyHandicap);
		CfgBetType cfgBetType = new CfgBetType();
		cfgBetType.setNameId("Handicap");
		cfgBetType.setName("Handicap");
		StrategyData pStrategyData = new StrategyData(cfgBetType, bookmaker,
				"Handicap");

		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setName("%1% -1");
		Rt1X2HandicapAttribute attribute = (Rt1X2HandicapAttribute) strategyResolverHandicap
				.resolverAbstractRtResult(pStrategyData, xmlMarketBet, null);
		assertNotNull(attribute);
		int result = Double.compare(attribute.getValue(),
				Double.parseDouble("-1"));
		assertEquals(result, 0);
		assertNotSame(attribute, Rt1X2HandicapAttribute.class);
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
