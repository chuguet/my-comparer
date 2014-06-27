/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeNordicbet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet.XMLNordicBetFileReader;

/**
 * The Class XMLNordicBetFileReaderTest.
 */
public class XMLNordicBetFileReaderTest extends AbstractTest {

	/** The nordic reader. */
	@Inject
	private XMLNordicBetFileReader nordicReader;

	/** The Constant NB_XML_TENNIS_LOCATION. */
	private static final String NB_XML_TENNIS_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_tennis.xml";

	/** The Constant NB_XML_GANADOR_LOCATION. */
	private static final String NB_XML_GANADOR_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_ganador.xml";

	/** The Constant NB_XML_SPECIAL_CHARACTERS. */
	private static final String NB_XML_SPECIAL_CHARACTERS = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_specialCharacters.xml";

	/** The Constant NB_XML_HANDICAP_ASIATICO. */
	private static final String NB_XML_HANDICAP_ASIATICO = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_handicapAsiatico.xml";

	/** The Constant NB_XML_TENNIS_LOCATION. */
	private static final String NB_XML_BLACK_LIST = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_blackList.xml";

	private static final String NB_XML_NBA_WINNER = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\NordicBet_NBAWinner.xml";

	/** The Constant NB_XML_LOCATION. */
	private static final String NB_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet.xml";

	/** The Constant NB_XML_LOCATION. */
	private static final String NB_XML_LOCATION_SHORT = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_short.xml";

	/** The Constant NORDIC_BAD_XML_LOCATION. */
	private static final String NORDIC_BAD_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_badXml.xml";

	/** The Constant NORDIC_BAD_XML_LOCATION. */
	private static final String NORDIC_BUG_4251 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_bug4251.xml";

	private static final String NORDIC_ICEHOCKEY = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_ichehockey_pcp.xml";
	
	private static final String NORDIC_MONEYLINE = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\nordicbet\\nordicbet_moneyline_pcp.xml";
	
	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(nordicReader.getBookmakerId());
		assertEquals(nordicReader.getBookmakerId(), CfgBookmakerId.NORDICBET_COM_ID.objectId().toString());
	}

	/**
	 * Nordic bet read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void nordicBetReadBigTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);
	}

	/**
	 * Nordic bet tennis test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void nordicBetTennisTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_TENNIS_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 2);
		for (XmlMatch match : result) {
			Assert.isTrue(!match.getXmlTournament().getName().equals("Singles") || !match.getXmlTournament().getName().equals("Doubles"));
		}

	}

	/**
	 * Nordic bet read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void nordicBetReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_LOCATION_SHORT, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);
		for (XmlMatch game : result) {
			if (game.getName().equals("CAF Qualifiers")) {
				assertEquals(game.getXmlMarkets().size(), 3);
				for (XmlMarket market : game.getXmlMarkets()) {
					assertEquals(market.getXmlBetType().getBetType().toString(), "MAS_MENOS");
				}
			}
		}

		// Ganador
		xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_GANADOR_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultGanador = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultGanador.size() == 1);
		for (XmlMatch game : resultGanador) {
			if (game.getName().equals("CAF - Champions League")) {
				assertEquals(game.getXmlMarkets().size(), 3);
				for (XmlMarket market : game.getXmlMarkets()) {
					assertEquals(market.getXmlBetType().getBetType().toString(), "GANADOR");
				}
			}
		}

		// Special Characters
		xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_SPECIAL_CHARACTERS, bookmakerConfiguration, null);
		Collection<XmlMatch> resultSpecialCharacters = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultSpecialCharacters.size() == 1);
		for (XmlMatch game : resultSpecialCharacters) {
			assertTrue(game.getName().equals("Orebro SK - Ostersunds FK"));
			assertEquals(game.getXmlMarkets().size(), 1);
			for (XmlMarket market : game.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(), BetTypeNordicbet.UNO_X_DOS);
			}
		}

		// Handicap Asiatico
		xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_HANDICAP_ASIATICO, bookmakerConfiguration, null);
		Collection<XmlMatch> resultHandicapAsiatico = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultHandicapAsiatico.size() == 1);
		for (XmlMatch game : resultHandicapAsiatico) {
			assertTrue(game.getName().equals("New York Knicks v Indiana Pacers"));
			assertTrue(game.getXmlTournament().getName().equals("World Cup 2014 Outrights"));

			assertEquals(game.getXmlMarkets().size(), 1);
			for (XmlMarket market : game.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(), BetTypeNordicbet.HANDICAP_ASIATICO);
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
					if (dato.getAsianResult().equals(AsianResult.ONE)) {
						assertTrue(dato.getFirstValue() == -5.0);
						bet.getXmlMatchParticipant().getName().equals("New York Knicks");
					} else {
						assertTrue(dato.getFirstValue() == -5.0);
						bet.getXmlMatchParticipant().getName().equals("Indiana Pacers");
					}
				}

			}
		}
	}

	@Test
	public void nordicBetBlackListTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		bookmakerConfiguration.addBlackListWord("Region BlackList");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_BLACK_LIST, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 0);
	}

	@Test
	public void nordicNBAWinnerTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NB_XML_NBA_WINNER, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		assertEquals(result.iterator().next().getXmlMarkets().iterator().next().getXmlBetType().getBetType(), BetTypeNordicbet.GANADOR);
		assertEquals(1, result.iterator().next().getXmlMarkets().size());
		assertEquals(30, result.iterator().next().getXmlMarkets().iterator().next().getXmlMarketBets().size());
	}

	/**
	 * Clase que comprueba que de dos partidos existentes en el xml del bug uno
	 * de ellos que es un partido "especial" es decir inventado no se trata.
	 * 
	 * @throws Exception
	 */
	@Test
	public void nordicBug4251Test() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NORDIC_BUG_4251, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
	}

	@Test
	/**
	 * Test to verify the Event Type overtime game.
	 * 
	 * @throws Exception
	 */
	public void nordicIcheHockey() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NORDIC_ICEHOCKEY, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		Assert.isTrue(result.iterator().next().getXmlMarkets().iterator().next().getXmlBetType().getBetType() ==
				BetTypeNordicbet.MAS_MENOS);
		
		Collection<XmlMatch> resultIceNHl = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultIceNHl.size() == 1);
		for (XmlMatch game : resultIceNHl) {
			for (XmlMarket market : game.getXmlMarkets()) {
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					XmlMoreLessAttribute dato = (XmlMoreLessAttribute)bet.getXmlAttribute();
					Assert.isTrue(dato.getTotalGoal() == 2.5d);
				}
			}
		}
	} 
	
	@Test
	/**
	 * Test to verify the Event Type overtime game.
	 * 
	 * @throws Exception
	 */
	public void nordicMoneyLine() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(NORDICBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(NORDIC_READER, NORDIC_MONEYLINE, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		Assert.isTrue(result.iterator().next().getXmlMarkets().iterator().next().getXmlBetType().getBetType() ==
				BetTypeNordicbet.GANADOR_PARTIDO);
		Collection<XmlMatch> resultIceNHl = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultIceNHl.size() == 1);
		for (XmlMatch game : resultIceNHl) {
			for (XmlMarket market : game.getXmlMarkets()) {
				for (XmlMarketBet bet : market.getXmlMarketBets()) {					
					XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute)bet.getXmlAttribute();
					Assert.isTrue(dato.getWinnerName().getName().equals("HPK") ||
							dato.getWinnerName().getName().equals("KalPa") );
				}
			}
		}
		
		// Aun no se considera MoneyLine
	} 
}
