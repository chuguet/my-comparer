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

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.util.TestUtil;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class XmlToRtMarketResolverTest.
 */
public final class XmlToRtMatchResolverTest extends AbstractTest {

	// /** The Constant LOG. */
	// private static final Log LOG = LogFactory
	// .getLog(XmlToRtMarketResolverTest.class);


	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;

	/**
	 * Resolver market and bet.
	 */
	@Test
	public final void resolverMarketAndBet() {
		CfgBookmaker cfgBookmaker = this.setBookmaker();
		
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarketAndBet");

		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);
		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertNotNull(rtMatch.getRtMarkets());
		for (RtMarket market : rtMatch.getRtMarkets()) {
			//assertNotNull(market.getBetType());
			for (RtBet bet : market.getBets()) {
				assertNotNull(bet);
				assertNotNull(bet.getBetOdd());
				assertEquals(bet.getBetOdd().getAmericanOdds(), "1.5");
				assertEquals(bet.getBetOdd().getFraOdds(), "1/5");
				assertEquals(bet.getBetOdd().getOdds(), "1");
			}
		}

	}

	/**
	 * Resolver market and bet and participant.
	 */
	@Test
	public final void resolverMarketAndBetAndParticipant() {
		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil
				.readXmlMatchFile("resolverMarketAndBetAndParticipant");

		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);
		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertNotNull(rtMatch.getMatchId().getParticipiants());
		for (RtParticipant participant : rtMatch.getMatchId()
				.getParticipiants()) {
			assertNotNull(participant);
		}

	}

	/**
	 * Tournament and sport not correct test.
	 * 
	 */
	@Test
	public final void tournamentAndSportNotCorrectTest() {
		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament xmlTournament = new XmlTournament();
		XmlSport xmlSport = new XmlSport();
		xmlSport.setName("Baloncesto");
		xmlTournament.setName("Euro 2012");
		xmlMatch.setXmlTournament(xmlTournament);
		xmlTournament.setXmlSport(xmlSport);

		@SuppressWarnings("unused")
		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, null);
	}

	/**
	 * Resolver tournament test.
	 * 
	 */
	@Test
	public final void resolverTournamentTest() {
		CfgBookmaker cfgBookmaker = setBookmaker();
		
		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament xmlTournament = new XmlTournament();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		xmlTournament.setName("Euro 2012");
		xmlMatch.setXmlTournament(xmlTournament);
		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);
		assertNotNull(rtMatch);
		assertEquals(rtMatch.getMatchId().getCompetition().getObjectId(),
				new BigInteger("2"));
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList()
				.size(), 1);

	}

	/**
	 * Resolver tournament and add id test.
	 * 
	 */
	@Test
	public final void resolverTournamentAndAddIdTest() {

		CfgBookmaker cfgBookmaker = setBookmaker();
		
		XmlMatch xmlMatch = new XmlMatch();
		
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		BmInternalId bmInternalId = new BmInternalId("1");
		cfgBookmaker.setObjectId(BigInteger.ONE);
		XmlTournament xmlTournament = new XmlTournament();
		xmlTournament.setName("Euro 2012");
		xmlMatch.setXmlTournament(xmlTournament);
		xmlMatch.setBmInternalId(bmInternalId);

		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);
		assertNotNull(rtMatch);
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList()
				.size(), 1);

	}

	/**
	 * Resolver team test.
	 * 
	 */
	@Test
	public final void resolverTeamTest() {

		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverTeamTest");
		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);

		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList()
				.size(), 1);

	}

	/**
	 * Resolver market.
	 * 
	 */
	@Test
	public final void resolverMarket() {
		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);

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
	 * All nulltest.
	 * 
	 */
	@Test
	public final void test() {
		RtMatch rtMatch = matchResolver.resolve(null,null, null);
		assertNotNull(rtMatch);

	}

}
