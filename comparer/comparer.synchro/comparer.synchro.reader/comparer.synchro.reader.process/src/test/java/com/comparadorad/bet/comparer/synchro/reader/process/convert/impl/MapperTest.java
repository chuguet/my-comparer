/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.Date;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;

/**
 * The Class MapperTest.
 */
public class MapperTest extends AbstractTest {

	/** The mapper. */
	@Inject
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
		XmlTournament pXmlTournament = new XmlTournament();

		pXmlTournament.setName("Euro 2012");
		XmlDate pXmlDate = new XmlDate(new Date());
		xmlMatch.setStartDate(pXmlDate);
		xmlMatch.setXmlTournament(pXmlTournament);
		XmlMatchParticipant pXmlMatchParticipant = new XmlMatchParticipant();
		pXmlMatchParticipant.setName("F.C. Barcelona");
		xmlMatch.addXmlMatchParticipant(pXmlMatchParticipant);
		rtMatchId = mapper
				.map(xmlMatch, RtMatchId.class, "xmlMatchToRtMatchId");
		assertEquals(rtMatchId.getCompetition().getObjectId(), new BigInteger(
				"2"));
		assertNotNull(rtMatchId.getStartDate());
		assertEquals(rtMatchId.getParticipiants().size(), 1);
		for (RtParticipant element : rtMatchId.getParticipiants()) {
			assertEquals(element.getCfgParticipant().getObjectId(),
					new BigInteger("12"));
		}
	}

	/**
	 * Xml match to rt match test.
	 */
	@Test
	public void xmlMatchToRtMatchTest() {
		XmlMatch xmlMatch = new XmlMatch();
		RtMatch rtMatch;
		xmlMatch.setLiveId("1");
		xmlMatch.setStreaming("Streaming");
		xmlMatch.setLive(true);
		rtMatch = mapper.map(xmlMatch, RtMatch.class, "xmlMatchToRtMatch");
		assertEquals(rtMatch.getLiveId(), "1");
		assertEquals(rtMatch.getStreaming(), "Streaming");
		assertEquals(rtMatch.isLive(), true);

	}

}
