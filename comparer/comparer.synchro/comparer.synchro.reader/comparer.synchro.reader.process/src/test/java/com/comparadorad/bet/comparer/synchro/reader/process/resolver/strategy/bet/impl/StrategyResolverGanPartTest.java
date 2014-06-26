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
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGanadorPart;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.StrategyResolverGanadorPartido;

/**
 * The Class StrategyResolverBetClickTest.
 */
public class StrategyResolverGanPartTest extends AbstractTest {

	/** The strategy resolver bet click. */
	@Inject
	@Resource(name = "strategyResolverGanadorPartido")
	private StrategyResolverGanadorPartido strategyResolverWinWin;

	/**
	 * Handicap test.
	 */
	@Test
	public final void winWinHandicapTest() {
		CfgBookmaker bookmaker = setBookmaker();
		CfgBookmakerBetTypeStrategyGanadorPart cfgBookmakerBetTypeStrategyWinWin 
			= new CfgBookmakerBetTypeStrategyGanadorPart();
		cfgBookmakerBetTypeStrategyWinWin
				.setOneTwoPatternStrategy("%1%", "%2%");
		bookmaker.getBookmakerConfiguration().getBookmakerBetTypeStrategies()
				.addBetTypeStrategy(cfgBookmakerBetTypeStrategyWinWin);
		CfgBetType cfgBetType = new CfgBetType();
		cfgBetType.setNameId("MatchWinner");
		cfgBetType.setName("Match Winner");
		StrategyData pStrategyData = new StrategyData(cfgBetType, bookmaker,
				"Match Winner");

		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setName("%1%");
		RtGanadorPartidoAttribute attribute = (RtGanadorPartidoAttribute) strategyResolverWinWin
				.resolverAbstractRtResult(pStrategyData, xmlMarketBet, null);
		assertNotNull(attribute);
		Result result = attribute.getResult();
		assertEquals(result, Result.ONE);
		assertNotSame(attribute, RtGanadorPartidoAttribute.class);
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
