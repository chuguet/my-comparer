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

import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyAsianHandicap;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.StrategyResolverAsianHandicap;

/**
 * The Class StrategyResolverBetClickTest.
 */
public class StrategyResolverAsianHandTest extends AbstractTest {

	/** The strategy resolver bet click. */
	@Inject
	@Resource(name = "strategyResolverAsianHandicap")
	private StrategyResolverAsianHandicap strategyResolverAsianHandicap;

	/**
	 * Handicap test.
	 */
	@Test
	public final void asianHandicapTest() {
		CfgBookmaker bookmaker = setBookmaker();
		CfgBookmakerBetTypeStrategyAsianHandicap cfgBookmakerBetTypeStrategyAsianHandicap 
			= new CfgBookmakerBetTypeStrategyAsianHandicap();
		cfgBookmakerBetTypeStrategyAsianHandicap.setOneTwoPatternStrategy(
				"%1%", "%2%");
		bookmaker.getBookmakerConfiguration().getBookmakerBetTypeStrategies()
				.addBetTypeStrategy(cfgBookmakerBetTypeStrategyAsianHandicap);
		CfgBetType cfgBetType = new CfgBetType();
		cfgBetType.setNameId("APUESTACONHANDICAPASIATICO");
		cfgBetType.setName("Handicap Asiatico");
		StrategyData pStrategyData = new StrategyData(cfgBetType, bookmaker,
				"Handicap Asiatico");

		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setName("%1% -2.5");
		RtAsianHandicapAttribute attribute = (RtAsianHandicapAttribute) strategyResolverAsianHandicap
				.resolverAbstractRtResult(pStrategyData, xmlMarketBet, null);
		assertNotNull(attribute);
		int result = Double.compare(attribute.getFirstValue(),
				Double.parseDouble("-2.5"));
		assertEquals(result, 0);
		assertNotSame(attribute, RtAsianHandicapAttribute.class);
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
