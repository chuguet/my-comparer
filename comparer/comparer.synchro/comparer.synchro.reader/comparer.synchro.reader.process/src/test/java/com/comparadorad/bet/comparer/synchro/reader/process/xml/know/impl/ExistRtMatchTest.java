/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.impl;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistMatchData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl.IXmlToRtMatchResolver;

/**
 * The Class XmlToRtMarketResolverTest.
 */
public final class ExistRtMatchTest extends AbstractTest {

	// /** The Constant LOG. */
	// private static final Log LOG = LogFactory
	// .getLog(XmlToRtMarketResolverTest.class);

	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;

	/** The exist rt match. */
	@Inject
	private IExistRtMatch existRtMatch;

	/**
	 * Existe match.
	 */
	@Test
	public void existeMatchTest() {
		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament xmlTournament = new XmlTournament();
		XmlMarket xmlMarket = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		BmInternalId bmInternalId = new BmInternalId("pruebaActualizadorMAtch");
		BmInternalId bmInternalIdMarket = new BmInternalId(
				"pruebaActualizadorMAtch");
		BmInternalId bmInternalIdBet = new BmInternalId("pruebaActualizadorBet");
		xmlMarket.setBmInternalId(bmInternalIdMarket);
		xmlMarketBet.setBmInternalId(bmInternalIdBet);
		XmlMarketBetOdd pXmlMarketBetOdd = new XmlMarketBetOdd("apuestas");
		pXmlMarketBetOdd.setAmericanOdds("1");
		pXmlMarketBetOdd.setFraOdds("3");
		pXmlMarketBetOdd.setOdds("4");
		xmlMarketBet.setXmlMarketBetOdd(pXmlMarketBetOdd);
		xmlMarket.addXmlBet(xmlMarketBet);
		xmlMatch.addXmlMarket(xmlMarket);
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setName("casaApuestas");
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		ExistData existData = new ExistData();
		existData.setXmlToRtResolverData(resolverData);
		existData.setBookmaker(cfgBookmaker);
		xmlTournament.setName("Euro 2012");
		xmlMatch.setXmlTournament(xmlTournament);
		xmlMatch.setBmInternalId(bmInternalId);
		ExistMatchData existMatchData = existRtMatch.exist(xmlMatch, existData);
		// RtMatch rtMatch = (RtMatch)existMatchData.getRtData();

	}

	/**
	 * All nulltest.
	 * 
	 */
	@Test
	public void test() {
		RtMatch rtMatch = matchResolver.resolve(null,null, null);
		assertNotNull(rtMatch);

	}

}
