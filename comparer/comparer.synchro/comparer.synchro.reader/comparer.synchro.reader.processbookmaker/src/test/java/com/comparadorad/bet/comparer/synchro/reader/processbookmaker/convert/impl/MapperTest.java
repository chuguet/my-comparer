/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.Date;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.dozer.Mapper;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class MapperTest.
 */
public class MapperTest extends AbstractTest {

	/** The mapper. */
	@Inject
	@Resource(name = "process")
	private Mapper mapper;

	/** {@inheritDoc} */
	@Test
	public final void test() {
		assertNotNull(mapper);
	}

	// /**
	// * Xml market to rt market test.
	// */
	// @Test
	// public void xmlMarketToRtMarketTest() {
	// XmlMarket xmlMarket = new XmlMarket();
	// RtMarket rtMarket;
	//
	// XmlBetType pXmlBetType = new XmlBetType();
	// pXmlBetType.setName("Win-Win");
	// xmlMarket.setXmlBetType(pXmlBetType);
	// rtMarket = mapper.map(xmlMarket, RtMarket.class, "xmlMarketToRtMarket");
	// assertEquals(rtMarket.getBetType().getObjectId(), new BigInteger("4"));
	// }

	/**
	 * Xml match to rt match id test.
	 */
	@Test
	public void xmlMatchToRtMatchIdTest() {
		XmlMatch xmlMatch = new XmlMatch();
		RtMatchId rtMatchId;
		CfgBookmaker bookmaker = new CfgBookmaker("19");

		XmlDate pXmlDate = new XmlDate(new Date(), "GMT+0", new Date());
		xmlMatch.setStartDate(pXmlDate);

		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		xmlMatch.setXmlTournament(torneo);
		XmlMatchParticipant pXmlMatchParticipant = new XmlMatchParticipant(
				"Real Madrid", torneo);
		xmlMatch.addXmlMatchParticipant(pXmlMatchParticipant);

		rtMatchId = mapper
				.map(xmlMatch, RtMatchId.class, "xmlMatchToRtMatchId");
		assertEquals(rtMatchId.getCompetition().getObjectId(), new BigInteger(
				"656935033"));
		assertNotNull(rtMatchId.getStartDate());
		assertEquals(rtMatchId.getParticipiants().size(), 1);
		for (RtParticipant element : rtMatchId.getParticipiants()) {
			assertEquals(element.getCfgParticipant().getObjectId(),
					new BigInteger("20"));
		}
	}

	/**
	 * Xml match to rt match test.
	 */
	@Test
	public void xmlMatchToRtMatchTest() {
		XmlMatch xmlMatch = new XmlMatch();
		RtMatch rtMatch;
		XmlDate pXmlDate = new XmlDate(new Date(), "GMT+0", new Date());
		xmlMatch.setStartDate(pXmlDate);
		xmlMatch.setLiveId("1");
		xmlMatch.setStreaming("Streaming");
		xmlMatch.setLive(true);
		rtMatch = mapper.map(xmlMatch, RtMatch.class, "xmlMatchToRtMatch");
		assertEquals(rtMatch.getLiveId(), "1");
		assertEquals(rtMatch.getStreaming(), "Streaming");
		assertEquals(rtMatch.isLive(), true);

	}

}
