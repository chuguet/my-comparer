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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.XMLInterwettenFileReader;

/**
 * The Class XMLInterwettenFileReaderTest.
 */
public class XMLInterwettenFileReaderTest extends AbstractTest {

	/** The Constant BAD_XML_STRUCTURE_FOR_OVER_UNDER_BET__XML_LOCATION. */
	private static final String BAD_XML_STRUCTURE_FOR_OVER_UNDER_BET__XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\badXmlStructureForOverUnderBet.xml";

	/** The Constant BET_TYPE_NOT_FOUND_XML_LOCATION. */
	private static final String BET_TYPE_NOT_FOUND_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\betTypeNotFoundTest.xml";

	/** The Constant DATE_XML_LOCATION. */
	private static final String DATE_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\dateTest.xml";

	/** The Constant GANADOR_PARTIDO_XML_LOCATION. */
	private static final String GANADOR_PARTIDO_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\ganadorPartidoTest.xml";
	

	/** The Constant PRORROGA_ICE_HOCKEY_XML_LOCATION. */
	private static final String PRORROGA_ICE_HOCKEY_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\prorrogaIceHockeyTest.xml";
	
	/** The Constant PRORROGA_BASKETBALL_XML_LOCATION. */
	private static final String PRORROGA_BASKETBALL_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\prorrogaBasketballTest.xml";

	/** The Constant GANADOR_XML_LOCATION. */
	private static final String GANADOR_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\ganadorTest.xml";

	/** The Constant HANDICAP_ASIATICO_XML_LOCATION. */
	private static final String HANDICAP_ASIATICO_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\handicapAsiaticoTest.xml";

	/** The Constant HANDICAP_UNO_X_DOS_XML_LOCATION. */
	private static final String HANDICAP_UNO_X_DOS_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\handicapUnoXDosTest.xml";

	/** The Constant INTERWETTEN_TIMEZONE. */
	private static final String INTERWETTEN_TIMEZONE = "Europe/Vienna";

	/** The Constant MAS_MENOS_XML_LOCATION. */
	private static final String MAS_MENOS_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\masMenosTest.xml";

	/** The Constant READ_SEVERAL_MARKETS_TEST_XML_LOCATION. */
	private static final String READ_SEVERAL_MARKETS_TEST_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\readSeveralMarketsTest.xml";

	/** The Constant UNO_X_DOS_XML_LOCATION. */
	private static final String UNO_X_DOS_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\unoXDosTest.xml";
	
	private static final String BUG_4334_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\interwettenBug4334.xml";
	
	private static final String INTERWETTEN_TENNIS_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\interwetten\\interwettenTennis.xml";

	/** The interwetten reader. */
	@Inject
	private XMLInterwettenFileReader interwettenReader;

	/**
	 * Bad xml structure for over under bet test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void badXmlStructureForOverUnderBetTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER,
				BAD_XML_STRUCTURE_FOR_OVER_UNDER_BET__XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals(2, match.getXmlMarkets().size());
		}
	}

	/**
	 * Bet type not found test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betTypeNotFoundTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, BET_TYPE_NOT_FOUND_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals(7, match.getXmlMarkets().size());
		}
	}

	/**
	 * Ganador partido test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void ganadorPartidoTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, GANADOR_PARTIDO_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals(1, match.getXmlMarkets().size());
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(CfgBetTypeId.GANADOR_PARTIDO.nameId(), market
						.getXmlBetType().getBetType().getId());
				assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
						market.getXmlBetType().getXmlBetEvent().getBetEvent()
								.getId());
				assertEquals(2, market.getXmlMarketBets().size());
				boolean one = false;
				boolean two = false;
				if (match.getName().equalsIgnoreCase(
						"Arizona Cardinals vs Seattle Seahawks")) {
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute attr = (XmlMatchWinnerAttribute) bet
								.getXmlAttribute();
						if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Arizona Cardinals")) {
							assertEquals("Arizona Cardinals", attr
									.getWinnerName().getName());
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("2.75", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Seattle Seahawks")) {
							assertEquals("Seattle Seahawks", attr
									.getWinnerName().getName());
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("1.37", bet.getXmlBetOdd().getOdds());
							two = true;
						} else {
							fail(new StringBuffer()
									.append("No se ha reconocido el participante: ")
									.append(bet.getXmlMatchParticipant()
											.getName()).toString());
						}
					}
					assertTrue(one && two);
				} else {
					fail(new StringBuffer()
							.append("No se ha reconocido el partido: ")
							.append(match.getName()).toString());
				}
			}
		}
	}
	
	
	/**
	 * Prorroga ice hockey test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void prorrogaIceHockeyTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, PRORROGA_ICE_HOCKEY_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals(1, match.getXmlMarkets().size());
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(CfgBetTypeId.GANADOR_PARTIDO.nameId(), market
						.getXmlBetType().getBetType().getId());
				assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
						market.getXmlBetType().getXmlBetEvent().getBetEvent()
								.getId());
				assertEquals(2, market.getXmlMarketBets().size());
			}
		}
	}
	

	/**
	 * Prorroga basketball test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void prorrogaBasketballTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, PRORROGA_BASKETBALL_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals(3, match.getXmlMarkets().size());
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			for (XmlMarket market : match.getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().getId() == CfgBetTypeId.GANADOR_PARTIDO
						.nameId()
						|| market.getXmlBetType().getBetType().getId() == CfgBetTypeId.HANDICAP_ASIATICO
								.nameId()
						|| market.getXmlBetType().getBetType().getId() == CfgBetTypeId.MAS_MENOS
								.nameId()) {
					assertEquals(
							CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
									.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				} 
			}
		}
	}

	/**
	 * Test para el bug 4334
	 * @throws Exception
	 */
	@Test
	public void bug4334Test() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, BUG_4334_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(0, result.size());
	}

	
	/**
	 * Ganador test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	@Test
	public void ganadorTest() throws FileNotFoundException, XmlReaderException {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, GANADOR_XML_LOCATION,
				bookmakerConfiguration, null);
		Map<String, String> participantOdds;
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(3, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {

			assertTrue(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			if (xmlMatch.getName().equalsIgnoreCase("ABL Champion 2013/14")) {
				participantOdds = new HashMap<String, String>();
				participantOdds.put("Allianz Swans Gmunden", "6.00");
				participantOdds.put("BC Vienna", "3.00");
				participantOdds.put("BSC Raiffeisen Panthers Furstenfeld",
						"100.00");
				participantOdds.put("Guessing Knights", "30.00");
				participantOdds.put("Kapfenberg Bulls", "4.00");
				participantOdds.put("Oberwart Gunners", "10.00");
				participantOdds.put("St Polten", "100.00");

				assertEquals(7, xmlMatch.getXmlMatchParticipants().size());
				for (XmlMatchParticipant participant : xmlMatch
						.getXmlMatchParticipants()) {
					assertTrue(participantOdds.containsKey(participant
							.getName()));
				}
				assertEquals(1, xmlMatch.getXmlMarkets().size());
				for (XmlMarket market : xmlMatch.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.GANADOR.nameId()));
					assertEquals(7, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
								.getXmlAttribute();
						assertTrue(participantOdds.containsKey(attr.getWinner()
								.getName()));
						assertTrue(participantOdds.get(
								attr.getWinner().getName()).equalsIgnoreCase(
								bet.getXmlBetOdd().getOdds()));
					}
				}
			} else if (xmlMatch.getName().equalsIgnoreCase(
					"ATP Moscow 2013 Winner")) {
				participantOdds = new HashMap<String, String>();
				participantOdds.put("Dolgopolov A.", "5.50");
				participantOdds.put("Donskoy E.", "30.00");
				participantOdds.put("Gabashvili T.", "60.00");
				participantOdds.put("Gasquet R.", "2.20");
				participantOdds.put("Golubev A.", "20.00");
				participantOdds.put("Istomin D.", "10.00");

				assertEquals(6, xmlMatch.getXmlMatchParticipants().size());
				for (XmlMatchParticipant participant : xmlMatch
						.getXmlMatchParticipants()) {
					assertTrue(participantOdds.containsKey(participant
							.getName()));
				}
				assertEquals(1, xmlMatch.getXmlMarkets().size());
				for (XmlMarket market : xmlMatch.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.GANADOR.nameId()));
					assertEquals(6, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
								.getXmlAttribute();
						assertTrue(participantOdds.containsKey(attr.getWinner()
								.getName()));
						assertTrue(participantOdds.get(
								attr.getWinner().getName()).equalsIgnoreCase(
								bet.getXmlBetOdd().getOdds()));
					}
				}
			} else if (xmlMatch.getName().equalsIgnoreCase(
					"World Champion 2014")) {
				participantOdds = new HashMap<String, String>();
				participantOdds.put("Mexico", "150.00");
				participantOdds.put("Netherlands", "16.00");
				participantOdds.put("Nigeria", "150.00");
				participantOdds.put("Sweden", "200.00");

				assertEquals(4, xmlMatch.getXmlMatchParticipants().size());
				for (XmlMatchParticipant participant : xmlMatch
						.getXmlMatchParticipants()) {
					assertTrue(participantOdds.containsKey(participant
							.getName()));
				}
				assertEquals(1, xmlMatch.getXmlMarkets().size());
				for (XmlMarket market : xmlMatch.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.GANADOR.nameId()));
					assertEquals(4, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
								.getXmlAttribute();
						assertTrue(participantOdds.containsKey(attr.getWinner()
								.getName()));
						assertTrue(participantOdds.get(
								attr.getWinner().getName()).equalsIgnoreCase(
								bet.getXmlBetOdd().getOdds()));
					}
				}
			}
		}
	}

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(interwettenReader.getBookmakerId());
		assertEquals(interwettenReader.getBookmakerId(),
				CfgBookmakerId.INTERWETTEN_COM_ID.objectId().toString());
	}

	/**
	 * Handicap asiatico test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void handicapAsiaticoTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, HANDICAP_ASIATICO_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(3, result.size());
		for (XmlMatch match : result) {
			assertEquals(1, match.getXmlMarkets().size());
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			boolean one;
			boolean two;
			for (XmlMarket market : match.getXmlMarkets()) {
				one = false;
				two = false;
				assertEquals(CfgBetTypeId.HANDICAP_ASIATICO.nameId(), market
						.getXmlBetType().getBetType().getId());
				assertEquals(2, market.getXmlMarketBets().size());

				if (match.getName().equalsIgnoreCase(
						"Detroit Tigers vs Boston Red Sox")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
								.getXmlAttribute();
						assertEquals("-1.5", attr.getFirstValue().toString());
						assertNull(attr.getSecondValue());
						if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Detroit Tigers")) {
							assertEquals(AsianResult.ONE, attr.getAsianResult());
							assertEquals("2.35", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Boston Red Sox")) {
							assertEquals(AsianResult.TWO, attr.getAsianResult());
							assertEquals("1.50", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"KC Royals vs Cincinnati Reds")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
								.getXmlAttribute();
						assertEquals("6.0", attr.getFirstValue().toString());
						assertNull(attr.getSecondValue());
						if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("KC Royals")) {
							assertEquals(AsianResult.ONE, attr.getAsianResult());
							assertEquals("1.75", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Cincinnati Reds")) {
							assertEquals(AsianResult.TWO, attr.getAsianResult());
							assertEquals("1.85", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"Detroit Lions vs Cincinnati Bengals")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
								.getXmlAttribute();
						assertEquals("-2.5", attr.getFirstValue().toString());
						assertNull(attr.getSecondValue());
						if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Detroit Lions")) {
							assertEquals(AsianResult.ONE, attr.getAsianResult());
							assertEquals("1.85", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Cincinnati Bengals")) {
							assertEquals(AsianResult.TWO, attr.getAsianResult());
							assertEquals("1.75", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else {
					fail(new StringBuffer()
							.append("No se ha reconocido el partido: ")
							.append(match.getName()).toString());
				}
				assertTrue(one && two);
			}
		}
	}

	/**
	 * Handicap uno x dos test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void handicapUnoXDosTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, HANDICAP_UNO_X_DOS_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(2, result.size());
		for (XmlMatch match : result) {
			assertEquals(1, match.getXmlMarkets().size());
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			boolean one;
			boolean draw;
			boolean two;
			for (XmlMarket market : match.getXmlMarkets()) {
				one = false;
				draw = false;
				two = false;
				assertEquals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId(), market
						.getXmlBetType().getBetType().getId());
				assertEquals(3, market.getXmlMarketBets().size());

				if (match.getName().equalsIgnoreCase(
						"Argentinos Jrs. vs Estudiantes LP")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2HandicapAttribute attr = (Xml1X2HandicapAttribute) bet
								.getXmlAttribute();
						assertEquals("1.0", attr.getFirstValue().toString());
						assertEquals(null, attr.getSecondValue());
						if (bet.getXmlMatchParticipant() == null) {
							assertEquals(Result.DRAW, attr.getResult());
							assertEquals("4.20", bet.getXmlBetOdd().getOdds());
							draw = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Argentinos Jrs.")) {
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("1.44", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Estudiantes LP")) {
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("5.00", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"CA Tigre vs Arsenal Sarandi")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2HandicapAttribute attr = (Xml1X2HandicapAttribute) bet
								.getXmlAttribute();
						assertEquals("-1.0", attr.getFirstValue().toString());
						assertEquals(null, attr.getSecondValue());
						if (bet.getXmlMatchParticipant() == null) {
							assertEquals(Result.DRAW, attr.getResult());
							assertEquals("4.00", bet.getXmlBetOdd().getOdds());
							draw = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("CA Tigre")) {
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("5.00", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Arsenal Sarandi")) {
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("1.44", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"The Sharks vs Free State Cheetahs")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2HandicapAttribute attr = (Xml1X2HandicapAttribute) bet
								.getXmlAttribute();
						assertEquals("-7.0", attr.getFirstValue().toString());
						assertEquals(null, attr.getSecondValue());
						if (bet.getXmlMatchParticipant() == null) {
							assertEquals(Result.DRAW, attr.getResult());
							assertEquals("17.0", bet.getXmlBetOdd().getOdds());
							draw = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("CA Tigre")) {
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("1.85", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Arsenal Sarandi")) {
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("1.75", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else {
					fail(new StringBuffer()
							.append("No se ha reconocido el partido: ")
							.append(match.getName()).toString());
				}
				assertTrue(one && two && draw);
			}
		}
	}

	/**
	 * Mas menos test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void masMenosTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, MAS_MENOS_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(7, result.size());
		for (XmlMatch match : result) {
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			boolean mas;
			boolean menos;
			boolean first = false;
			boolean second = false;
			boolean third = false;
			for (XmlMarket market : match.getXmlMarkets()) {
				mas = false;
				menos = false;
				assertEquals(CfgBetTypeId.MAS_MENOS.nameId(), market
						.getXmlBetType().getBetType().getId());
				assertEquals(2, market.getXmlMarketBets().size());

				if (match.getName().equalsIgnoreCase(
						"CA Tigre vs Arsenal Sarandi")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						assertEquals("156.5", attr.getTotalGoal().toString());
						if (attr.getMasMenos().equals(MasMenos.MAS)) {
							assertEquals("1.75", bet.getXmlBetOdd().getOdds());
							mas = true;
						} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
							assertEquals("1.85", bet.getXmlBetOdd().getOdds());
							menos = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"Argentinos Jrs. vs Estudiantes LP")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						assertEquals("2.5", attr.getTotalGoal().toString());
						if (attr.getMasMenos().equals(MasMenos.MAS)) {
							assertEquals("2.50", bet.getXmlBetOdd().getOdds());
							mas = true;
						} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
							assertEquals("1.40", bet.getXmlBetOdd().getOdds());
							menos = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"Rosenborg IHK vs Lillehammer")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						assertEquals("6.5", attr.getTotalGoal().toString());
						if (attr.getMasMenos().equals(MasMenos.MAS)) {
							assertEquals("1.80", bet.getXmlBetOdd().getOdds());
							mas = true;
						} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
							assertEquals("1.70", bet.getXmlBetOdd().getOdds());
							menos = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"Valerenga vs Stjernen")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						assertEquals("7.5", attr.getTotalGoal().toString());
						if (attr.getMasMenos().equals(MasMenos.MAS)) {
							assertEquals("1.80", bet.getXmlBetOdd().getOdds());
							mas = true;
						} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
							assertEquals("1.85", bet.getXmlBetOdd().getOdds());
							menos = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase("Bozen vs Villach")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						assertEquals("5.5", attr.getTotalGoal().toString());
						if (attr.getMasMenos().equals(MasMenos.MAS)) {
							assertEquals("1.65", bet.getXmlBetOdd().getOdds());
							mas = true;
						} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
							assertEquals("2.00", bet.getXmlBetOdd().getOdds());
							menos = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"DEG Metro Stars vs Ingolstadt")) {
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent()
							.getId()
							.equals(CfgBetTypeEventId.PRIMERA_PARTE.nameId())) {
						first = true;
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							assertEquals("0.5", attr.getTotalGoal().toString());
							if (attr.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("1.17", bet.getXmlBetOdd()
										.getOdds());
								mas = true;
							} else if (attr.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("3.80", bet.getXmlBetOdd()
										.getOdds());
								menos = true;
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent()
							.getBetEvent().getId()
							.equals(CfgBetTypeEventId.SEGUNDA_PARTE.nameId())) {
						second = true;
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							assertEquals("1.5", attr.getTotalGoal().toString());
							if (attr.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("1.70", bet.getXmlBetOdd()
										.getOdds());
								mas = true;
							} else if (attr.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("1.90", bet.getXmlBetOdd()
										.getOdds());
								menos = true;
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent()
							.getBetEvent().getId()
							.equals(CfgBetTypeEventId.TERCERA_PARTE.nameId())) {
						third = true;
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							assertEquals("2.5", attr.getTotalGoal().toString());
							if (attr.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("3.20", bet.getXmlBetOdd()
										.getOdds());
								mas = true;
							} else if (attr.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("1.25", bet.getXmlBetOdd()
										.getOdds());
								menos = true;
							}
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"Estudiantes LP vs Quilmes")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						if (attr.getTotalGoal().toString()
								.equalsIgnoreCase("0.5")) {
							if (attr.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("1.03", bet.getXmlBetOdd()
										.getOdds());
								mas = true;
							} else if (attr.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("8.50", bet.getXmlBetOdd()
										.getOdds());
								menos = true;
							}
						} else if (attr.getTotalGoal().toString()
								.equalsIgnoreCase("3.5")) {
							if (attr.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("4.50", bet.getXmlBetOdd()
										.getOdds());
								mas = true;
							} else if (attr.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("1.13", bet.getXmlBetOdd()
										.getOdds());
								menos = true;
							}
						} else if (attr.getTotalGoal().toString()
								.equalsIgnoreCase("4.5")) {
							if (attr.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("9.00", bet.getXmlBetOdd()
										.getOdds());
								mas = true;
							} else if (attr.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("1.02", bet.getXmlBetOdd()
										.getOdds());
								menos = true;
							}
						}
					}
				} else {
					fail(new StringBuffer()
							.append("No se ha reconocido el partido: ")
							.append(match.getName()).toString());
				}
				assertTrue(mas && menos);
			}
			if (match.getName().equalsIgnoreCase(
					"DEG Metro Stars vs Ingolstadt")) {
				assertTrue(first && second && third);
			}
		}
	}

	/**
	 * Match date test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	@Test
	public void matchDateTest() throws FileNotFoundException,
			XmlReaderException {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, DATE_XML_LOCATION, bookmakerConfiguration,
				null);

		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(3, xmlMatchs.size());
		for (XmlMatch match : xmlMatchs) {
			assertNotNull(match.getStartDate());
			assertNotNull(match.getStartDate().getProviderDate());
			if (match.getName().equalsIgnoreCase(
					"BC Khimki Moscow vs CSU Asesoft Ploiesti")) {
				// Date (2013-10-16T17:30:00)
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(match.getStartDate().getProviderDate());
				assertEquals(2013, cal.get(Calendar.YEAR));
				assertEquals(9, cal.get(Calendar.MONTH));
				assertEquals(16, cal.get(Calendar.DAY_OF_MONTH));
				assertEquals(17, cal.get(Calendar.HOUR_OF_DAY));
				assertEquals(30, cal.get(Calendar.MINUTE));
				assertEquals(0, cal.get(Calendar.SECOND));
			} else if (match.getName().equalsIgnoreCase(
					"BC Nizhny Novgorod vs Alba Fehervar")) {
				// Date (2013-10-16T17:40:00)
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(match.getStartDate().getProviderDate());
				assertEquals(2013, cal.get(Calendar.YEAR));
				assertEquals(9, cal.get(Calendar.MONTH));
				assertEquals(16, cal.get(Calendar.DAY_OF_MONTH));
				assertEquals(17, cal.get(Calendar.HOUR_OF_DAY));
				assertEquals(40, cal.get(Calendar.MINUTE));
				assertEquals(0, cal.get(Calendar.SECOND));
			} else if (match.getName().equalsIgnoreCase(
					"Bamberg vs Strasbourg IG")) {
				// Date (2014-01-01T20:00:00)
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(match.getStartDate().getProviderDate());
				assertEquals(2014, cal.get(Calendar.YEAR));
				assertEquals(0, cal.get(Calendar.MONTH));
				assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
				assertEquals(20, cal.get(Calendar.HOUR_OF_DAY));
				assertEquals(0, cal.get(Calendar.MINUTE));
				assertEquals(0, cal.get(Calendar.SECOND));
			} else {
				fail(new StringBuffer()
						.append("No se ha reconocido el partido: ")
						.append(match.getName()).toString());
			}
		}
	}

	/**
	 * Interwetten read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void readSeveralMarketsTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, READ_SEVERAL_MARKETS_TEST_XML_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(2, result.size());

		for (XmlMatch xmlMatch : result) {

			if (xmlMatch.getName()
					.equals("Cincinnati Reds vs Colorado Rockies")) {
				assertEquals(3, xmlMatch.getXmlMarkets().size());
				boolean ganadorPartido = false;
				boolean masMenos = false;
				boolean handicapAsiatico = false;
				for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					if (xmlMarket.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {
						ganadorPartido = true;
					} else if (xmlMarket.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.MAS_MENOS.nameId())) {

						masMenos = true;
					} else if (xmlMarket.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
						handicapAsiatico = true;
					} else {
						fail(new StringBuffer()
								.append("No se estaba esperando leer el mercado: ")
								.append(xmlMarket.getXmlBetType().getBetType()
										.getId()).toString());
					}
				}
				assertTrue(ganadorPartido && masMenos && handicapAsiatico);
			} else if (xmlMatch.getName().equals("Belgium vs Serbia")) {
				assertEquals(3, xmlMatch.getXmlMarkets().size());
				boolean unoXDos = false;
				boolean handicapUnoXDos = false;
				for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {
					if (xmlMarket.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
						unoXDos = true;
						assertTrue(CfgBetTypeEventId.PARTIDO_COMPLETO
								.nameId()
								.equals(xmlMarket.getXmlBetType()
										.getXmlBetEvent().getBetEvent().getId())
								|| CfgBetTypeEventId.PRIMERA_PARTE.nameId()
										.equals(xmlMarket.getXmlBetType()
												.getXmlBetEvent().getBetEvent()
												.getId()));
					} else if (xmlMarket.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
						handicapUnoXDos = true;
					} else {
						fail(new StringBuffer()
								.append("No se estaba esperando leer el mercado: ")
								.append(xmlMarket.getXmlBetType().getBetType()
										.getId()).toString());
					}
				}
				assertTrue(unoXDos && handicapUnoXDos);
			} else if (xmlMatch.getName().equals("Andreozzi Guido - Copil M.")) {
				assertEquals(xmlMatch.getXmlMarkets().size(), 2);
			} else if (xmlMatch.getName().equals("Ghem Andre - Ungur Adrian")) {
				assertEquals(xmlMatch.getXmlMarkets().size(), 1);
			} else {
				fail(new StringBuffer()
						.append("No se ha reconocido el partido: ")
						.append(xmlMatch.getName()).toString());
			}
		}
	}

	/**
	 * Uno x dos test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void unoXDosTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, UNO_X_DOS_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(3, result.size());
		for (XmlMatch match : result) {
			assertEquals(1, match.getXmlMarkets().size());
			assertFalse(match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());
			boolean one;
			boolean draw;
			boolean two;
			for (XmlMarket market : match.getXmlMarkets()) {
				one = false;
				draw = false;
				two = false;
				assertEquals(CfgBetTypeId.UNO_X_DOS.nameId(), market
						.getXmlBetType().getBetType().getId());
				assertEquals(3, market.getXmlMarketBets().size());

				if (match.getName().equalsIgnoreCase(
						"Benatky nad Jizerou vs Kadan")) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute attr = (Xml1X2Attribute) bet
								.getXmlAttribute();
						if (bet.getXmlMatchParticipant() == null) {
							assertEquals(Result.DRAW, attr.getResult());
							assertEquals("4.00", bet.getXmlBetOdd().getOdds());
							draw = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Benatky nad Jizerou")) {
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("2.30", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Kadan")) {
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("2.30", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase(
						"Argentinos Jrs. vs Estudiantes LP")) {
					assertEquals(CfgBetTypeEventId.PRIMERA_PARTE.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute attr = (Xml1X2Attribute) bet
								.getXmlAttribute();
						if (bet.getXmlMatchParticipant() == null) {
							assertEquals(Result.DRAW, attr.getResult());
							assertEquals("2.00", bet.getXmlBetOdd().getOdds());
							draw = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Argentinos Jrs.")) {
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("3.25", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Estudiantes LP")) {
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("3.10", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else if (match.getName().equalsIgnoreCase("Bozen vs Villach")) {
					assertEquals(CfgBetTypeEventId.PRIMERA_PARTE.nameId(),
							market.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute attr = (Xml1X2Attribute) bet
								.getXmlAttribute();
						if (bet.getXmlMatchParticipant() == null) {
							assertEquals(Result.DRAW, attr.getResult());
							assertEquals("2.55", bet.getXmlBetOdd().getOdds());
							draw = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Bozen")) {
							assertEquals(Result.ONE, attr.getResult());
							assertEquals("2.60", bet.getXmlBetOdd().getOdds());
							one = true;
						} else if (bet.getXmlMatchParticipant().getName()
								.equalsIgnoreCase("Villach")) {
							assertEquals(Result.TWO, attr.getResult());
							assertEquals("2.70", bet.getXmlBetOdd().getOdds());
							two = true;
						}
					}
				} else {
					fail(new StringBuffer()
							.append("No se ha reconocido el partido: ")
							.append(match.getName()).toString());
				}
				assertTrue(one && two && draw);
			}
		}
	}
	
	/**
	 * Uno x dos test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void intewettenTennisTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERWETTEN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERWETTEN_READER, INTERWETTEN_TENNIS_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertEquals(2, result.size());
		for (XmlMatch match : result) {
			if (!match.getXmlTournamentEvent().getLongTerm()
					.getLongTerm()){
				assertEquals(2, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						String betOdds = bet.getXmlBetOdd().getOdds();
						if (bet.getXmlMatchParticipant().isHomeParticipant()) {
							assertEquals("Almagro Nicolas", bet.getXmlMatchParticipant().getName());
							if (market.getXmlBetType().getBetType().getId().equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())){
								XmlAsianHandicapAttribute attrHandicapH = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
								assertEquals("-1.5", attrHandicapH.getFirstValue().toString());
								assertEquals("1.35", betOdds);
								
							} else if (market.getXmlBetType().getBetType().getId().equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())){
								assertEquals("1.12", betOdds);
							}
						} else if (bet.getXmlMatchParticipant()
								.isHomeParticipant()) {
							assertEquals("Daniel Taro", bet.getXmlMatchParticipant().getName());
							if (market.getXmlBetType().getBetType().getId().equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())){
								XmlAsianHandicapAttribute attrHandicapV = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
								assertEquals("-1.5", attrHandicapV.getFirstValue().toString());
								assertEquals("2.80", bet.getXmlBetOdd().getOdds());
								
							} else if (market.getXmlBetType().getBetType().getId().equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())){
								assertEquals("5.00", betOdds);
							}
						}
					}
				}
				
			}else{
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					assertEquals(8, market.getXmlMarketBets().size());
				}
			}
		}
	}

}
