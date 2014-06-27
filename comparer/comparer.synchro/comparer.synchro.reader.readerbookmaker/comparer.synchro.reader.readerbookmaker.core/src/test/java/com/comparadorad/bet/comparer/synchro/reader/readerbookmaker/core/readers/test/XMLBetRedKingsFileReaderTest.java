/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetRedKings;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betredkings.XMLBetRedKingsFileReader;
import com.neovisionaries.i18n.CountryCode;

/**
 * The Class XMLBetRedKingsFileReaderTest.
 */
public class XMLBetRedKingsFileReaderTest extends AbstractTest {
	/** The bet click reader. */
	@Inject
	private XMLBetRedKingsFileReader betRedKingsReader;
	
	/** The Constant BRK_XML_FOOTBALL. */
	private static final String BRK_XML_FOOTBALL = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betredkings\\BetRedKings_Football.xml";
	
	private static final String BETREDKINGS_BUG_4239 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betredkings\\BetRedKings_Bug4239.xml";

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(betRedKingsReader.getBookmakerId());
		assertEquals(betRedKingsReader.getBookmakerId(),
				CfgBookmakerId.BETREDKINGS_ID.objectId().toString());
	}

	/**
	 * Bet click read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betRedKingsReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETREDKINGS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETREDKINGS_READER, BRK_XML_FOOTBALL, bookmakerConfiguration,
				null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertTrue(result.size() > 0);
		for (XmlMatch xmlMatch : result) {
			assertNotNull(xmlMatch.getStartDate());
			assertTrue(xmlMatch.getXmlMatchParticipants().size() > 1);
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {
				if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBetRedKings.GANADOR)) {
					assertTrue(xmlMatch.getXmlTournamentEvent().getLongTerm()
							.getLongTerm());
					for (XmlMarketBet xmlBet : xmlMarket.getXmlMarketBets()) {
						assertNotNull(xmlBet.getXmlMarketBetOdd().getOdds());
						assertTrue(xmlBet.getXmlAttribute().getClass()
								.equals(XmlWinnerAttribute.class));
						assertNotNull(xmlBet.getXmlMatchParticipant());
						assertNotNull(((XmlWinnerAttribute) xmlBet
								.getXmlAttribute()).getWinner());
						assertNotNull(xmlBet.getXmlMatchParticipant().getName());
					}
				} else if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBetRedKings.GANADOR_PARTIDO)) {
					assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
							.getLongTerm());
					for (XmlMarketBet xmlBet : xmlMarket.getXmlMarketBets()) {
						assertNotNull(xmlBet.getXmlMarketBetOdd().getOdds());
						assertTrue(xmlBet.getXmlAttribute().getClass()
								.equals(XmlMatchWinnerAttribute.class));
						assertNotNull(xmlBet.getXmlMatchParticipant());
						assertNotNull(((XmlMatchWinnerAttribute) xmlBet
								.getXmlAttribute()).getResult());
						assertNotNull(((XmlMatchWinnerAttribute) xmlBet
								.getXmlAttribute()).getWinnerName());
					}
				} else if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBetRedKings.UNO_X_DOS)) {
					assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
							.getLongTerm());
					for (XmlMarketBet xmlBet : xmlMarket.getXmlMarketBets()) {
						assertNotNull(xmlBet.getXmlMarketBetOdd().getOdds());
						assertTrue(xmlBet.getXmlAttribute().getClass()
								.equals(Xml1X2Attribute.class));
						assertNotNull(xmlBet.getXmlMatchParticipant());
						assertNotNull(((Xml1X2Attribute) xmlBet
								.getXmlAttribute()).getResult());
					}
				} else if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBetRedKings.HANDICAP_ASIATICO)) {
					assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
							.getLongTerm());
					for (XmlMarketBet xmlBet : xmlMarket.getXmlMarketBets()) {
						assertNotNull(xmlBet.getXmlMarketBetOdd().getOdds());
						assertTrue(xmlBet.getXmlAttribute().getClass()
								.equals(XmlAsianHandicapAttribute.class));
						assertNotNull(((XmlAsianHandicapAttribute) xmlBet
								.getXmlAttribute()).getAsianResult());
						assertNotNull(((XmlAsianHandicapAttribute) xmlBet
								.getXmlAttribute()).getFirstValue());
					}
				} else if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBetRedKings.MAS_MENOS)) {
					assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
							.getLongTerm());
					for (XmlMarketBet xmlBet : xmlMarket.getXmlMarketBets()) {
						assertNotNull(xmlBet.getXmlMarketBetOdd().getOdds());
						assertTrue(xmlBet.getXmlAttribute().getClass()
								.equals(XmlMoreLessAttribute.class));
						assertNotNull(((XmlMoreLessAttribute) xmlBet
								.getXmlAttribute()).getMasMenos());
						assertNotNull(((XmlMoreLessAttribute) xmlBet
								.getXmlAttribute()).getTotalGoal());
					}
				}
			}

		}
	}
	
	
	@Test
	public void betRedKingsReadBug4239Test() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETREDKINGS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETREDKINGS_READER, BETREDKINGS_BUG_4239, bookmakerConfiguration,
				null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

	}

	/**
	 * Alfanumeric code country.
	 */
	@Test
	public void alfanumericCodeCountry() {
		CountryCode cc = CountryCode.getByCode("JP");
		assertEquals(cc.getName(), "Japan");
	}
}
