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
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyMasMenos;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGanadorPart;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.StrategyResolverMasMenos;

/**
 * The Class StrategyResolverBetClickTest.
 */
public class StrategyResolverMasMenTest extends AbstractTest {

	/** The strategy resolver bet click. */
	@Inject
	@Resource(name = "strategyResolverMasMenos")
	private StrategyResolverMasMenos strategyResolverUnderOver;

	/**
	 * Handicap test.
	 */
	@Test
	public final void winWinHandicapTest() {
		CfgBookmaker bookmaker = setBookmaker();
		CfgBookmakerBetTypeStrategyMasMenos cfgBookmakerBetTypeStrategyUnderOver 
			= new CfgBookmakerBetTypeStrategyMasMenos();
		cfgBookmakerBetTypeStrategyUnderOver.setGoalsPatternStrategy();
		bookmaker.getBookmakerConfiguration().getBookmakerBetTypeStrategies()
				.addBetTypeStrategy(cfgBookmakerBetTypeStrategyUnderOver);
		CfgBetType cfgBetType = new CfgBetType();
		cfgBetType.setNameId("MasMenos");
		cfgBetType.setName("Under Over");
		StrategyData pStrategyData = new StrategyData(cfgBetType, bookmaker,
				"Under Over");

		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setName("No Goals");
		RtMasMenosAttribute attribute = (RtMasMenosAttribute) strategyResolverUnderOver
				.resolverAbstractRtResult(pStrategyData, xmlMarketBet, null);
		assertNotNull(attribute);
		MasMenos result = attribute.getMasMenos();
		assertEquals(result, MasMenos.MENOS);
		assertNotSame(attribute, RtMasMenosAttribute.class);
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
