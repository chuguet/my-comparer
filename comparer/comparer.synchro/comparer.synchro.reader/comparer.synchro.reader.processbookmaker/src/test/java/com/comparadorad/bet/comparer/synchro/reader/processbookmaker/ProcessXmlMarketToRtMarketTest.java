/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.ProcessXmlMarketToRtMarket;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl.IXmlToRtMatchResolver;
import com.comparadorad.bet.comparer.util.commons.date.CommonsDate;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ProcessXmlMarketToRtMarketTest.
 */
@ActiveProfiles(ProfileConstant.TEST)
public final class ProcessXmlMarketToRtMarketTest extends AbstractTest {

	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;

	/** The process xml market to rt market. */
	@Inject
	private ProcessXmlMarketToRtMarket processXmlMarketToRtMarket;

	/**
	 * New match.
	 */
	@Test
	public final void newMatch() {
		CfgBookmaker cfgBookmaker = setBookmaker();
		cfgBookmaker.setName("casaApuestas");
		CfgBookmakerXmlReader pBookmakerXmlReader = new CfgBookmakerXmlReader();
		pBookmakerXmlReader.setXmlMarketBetEnabled(false);
		cfgBookmaker.setBookmakerXmlReader(pBookmakerXmlReader);
		XmlMatch xmlMatch = createXmlMatch();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);
		xmlMatch.setXmlTournamentEvent(new XmlTournamentEvent());
		xmlMatch.getXmlTournament().setXmlSport(new XmlSport("Football"));
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		RtMatch rtMatch = processXmlMarketToRtMarket.process(xmlMatch,
				cfgBookmaker);
		rtMatch.getLiveId();

	}

	/**
	 * Resolver team not correct.
	 * 
	 */
	// @Test
	// public final void resolverTeamNotCorrect() {
	// CfgBookmaker cfgBookmaker = setBookmaker();
	// XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
	//
	// TestUtil testUtil = new TestUtil();
	// XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverTeamNotCorrect");
	//
	// RtMatch rtMatch;
	// try {
	// rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);
	// fail("An exception must be thrown");
	// } catch (ConvertException e) {
	//
	// //LOG.info("The exception is correct: " + e.getMessage());
	// throw e;
	// }
	// }

	/**
	 * All nulltest.
	 * 
	 */
	@Test
	public final void test() {
		RtMatch rtMatch;
		try {
			rtMatch = matchResolver.resolve(null, null, null);
			assertNotNull(rtMatch);

		} catch (BetBySportNotAllowedException e) {
			fail("El test no debe de dar excepcion");
		}
		
	}

	/**
	 * Creates the xml match.
	 * 
	 * @return the xml match
	 */
	private XmlMatch createXmlMatch() {
		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament xmlTournament = new XmlTournament();
		XmlMarket xmlMarket = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		xmlMarket.setXmlBetType(new XmlBetType(BetTypeBetClick.GANADOR));
		XmlMarketBetOdd pXmlMarketBetOdd = new XmlMarketBetOdd("apuestas");
		xmlTournament.setName("Euro 2012");
		XmlSport xmlSport = new XmlSport();
		xmlSport.setName("Futbol");
		xmlTournament.setXmlSport(xmlSport);
		
		pXmlMarketBetOdd.setAmericanOdds("1");
		pXmlMarketBetOdd.setFraOdds("3");
		pXmlMarketBetOdd.setOdds("4");
		xmlMarketBet.setXmlMarketBetOdd(pXmlMarketBetOdd);
		xmlMarketBet.setXmlMatchParticipant(new XmlMatchParticipant(
				"Portugal", false, false, xmlTournament));
		XmlWinnerAttribute atributo = new XmlWinnerAttribute();
		atributo.setWinner(new XmlMatchParticipant("Ganador", xmlTournament));
		xmlMarketBet.setXmlAttribute(atributo);
		xmlMarket.addXmlBet(xmlMarketBet);
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setName("Handicap");
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		xmlBetEvent.setBetEvent(BetEventBetClick.PARTIDO_COMPLETO);
		// xmlMarket.setXmlBetType(xmlBetType);
		xmlMatch.addXmlMarket(xmlMarket);
		
		xmlMatch.setXmlTournament(xmlTournament);
		XmlDate xmlDate = new XmlDate(new Date(), CommonsDate.GMT_0, new Date());
		xmlMatch.setStartDate(xmlDate);
		xmlMatch.setLiveId("idLive");
		xmlMatch.setLive(false);
		XmlMatchParticipant xmlParticipant = new XmlMatchParticipant(
				"Portugal", false, false, xmlTournament);
		xmlMatch.addXmlMatchParticipant(xmlParticipant);

		return xmlMatch;
	}

}
