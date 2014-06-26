/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBmInternalId;
import com.comparadorad.bet.comparer.model.bet.bean.RtInternalId;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.util.TestUtil;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class XmlToRtMarketResolverTest.
 */
public final class XmlToRtMarketResolverTest extends AbstractTest {

	// /** The Constant LOG. */
	// private static final Log LOG = LogFactory
	// .getLog(XmlToRtMarketResolverTest.class);

	/** The xml to rt market resolver. */
	@SuppressWarnings("rawtypes")
	@Inject
	private IXmlToRtMarketResolver xmlToRtMarketResolver;
	
	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;
	
	/** The market resolver. */
	@Inject
	private IXmlToRtMarketResolver marketResolver;



	/**
	 * All nulltest.
	 * 
	 */
	@Test
	public final void allNullTest() {
		RtMarket rtMarket = xmlToRtMarketResolver.resolve(null, null,null);
		assertNotNull(rtMarket);
	}

	/**
	 * Test.
	 * 
	 */
	@Test
	public final void test() {
		XmlMarket xmlMarket = new XmlMarket();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setObjectId(BigInteger.ONE);
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		RtMarket rtMarket = xmlToRtMarketResolver.resolve(xmlMarket,null,
				resolverData);
		assertNotNull(rtMarket);

	}
	
	/**
	 * Resolver market by hash key.
	 */
	@Test
	public final void resolverMarketByHashKey() {
		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarket");
		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);

		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList()
				.size(), 1);

	}
	
	/**
	 * Resolve by hash key market.
	 */
	@Test
	public final void resolveByHashKeyMarket() {
		XmlMarket xmlMarket = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		BmInternalId bmInternalId = new BmInternalId("pruebaActualizadorMarket");
		// BmInternalId bmInternalIdBet = new
		// BmInternalId("pruebaActualizadorBet");
		BmInternalId bmInternalIdBet = new BmInternalId(
				"pruebaActualizadorMarket");
		xmlMarket.setBmInternalId(bmInternalId);
		xmlMarketBet.setBmInternalId(bmInternalIdBet);
		XmlMarketBetOdd pXmlMarketBetOdd = new XmlMarketBetOdd("apuestas");
		pXmlMarketBetOdd.setAmericanOdds("1");
		pXmlMarketBetOdd.setFraOdds("3");
		pXmlMarketBetOdd.setOdds("4");
		xmlMarketBet.setXmlMarketBetOdd(pXmlMarketBetOdd);
		xmlMarket.addXmlBet(xmlMarketBet);
		//CfgBookmaker bookmarket = new CfgBookmaker(BigInteger.ONE);
		CfgBookmaker bookmarket = setBookmaker();
		bookmarket.setObjectId(BigInteger.ONE);
		bookmarket.setName("nombre");
		CfgBookmaker bookmarketBD = setBookmaker();
		bookmarketBD.setObjectId(BigInteger.TEN);

		// CfgBookmaker bookmarketBD = new CfgBookmaker(BigInteger.ONE);
		RtMarket rtMarket = new RtMarket();
		Set<RtInternalId> rtInternalId = new HashSet<RtInternalId>();
		RtBet rtBet = new RtBet();
		RtBetOdd rtBetOdd = new RtBetOdd();
		rtBetOdd.setAmericanOdds("0");
		rtBetOdd.setFraOdds("3");
		rtBetOdd.setOdds("4");
		rtBet.setBetOdd(rtBetOdd);
		rtBet.setBookmaker(bookmarketBD);

		RtBmInternalId bminternalId = new RtBmInternalId(
				"pruebaActualizadorMarket");
		// internalID.setRtBmInternalId(bminternalId);
		RtInternalId internalID = new RtInternalId(bookmarket, bminternalId);
		rtInternalId.add(internalID);
		internalID = new RtInternalId(bookmarket, bminternalId);
		rtMarket.add(internalID);
		rtBet.add(internalID);
		rtMarket.add(rtBet);
		marketResolver.resolveByHashKey(xmlMarket,null, rtMarket,
				new XmlToRtResolverData(bookmarket));

	}


}
