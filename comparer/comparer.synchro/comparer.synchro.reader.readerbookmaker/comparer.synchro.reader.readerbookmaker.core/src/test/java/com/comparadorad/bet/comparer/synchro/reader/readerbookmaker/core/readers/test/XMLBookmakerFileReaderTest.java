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
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker.BetTypeBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker.XMLBookmakerFileReader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.commons.betOdds.CuotaConverterUtil;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

/**
 * The Class XMLBookmakerFileReaderTest.
 */
public class XMLBookmakerFileReaderTest extends AbstractTest {

	/** The Constant BOOKMAKER_EU_TIMEZONE. */
	protected static final String BOOKMAKER_EU_TIMEZONE = "PST";

	/** The Constant BOOKMAKER_XML_1X2. */
	private static final String BOOKMAKER_XML_1X2 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmaker1X2.xml";

	/** The Constant BOOKMAKER_XML_BUG_3990_LONG_TERM. */
	private static final String BOOKMAKER_XML_BUG_3990_LONG_TERM = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBug3990LongTerm.xml";

	/** The Constant BOOKMAKER_XML_BUG_3996_BET_EVENT. */
	private static final String BOOKMAKER_XML_BUG_3996_BET_EVENT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBug3996BetEvent.xml";

	/** The Constant BOOKMAKER_XML_BUG_4004_AVOID_BETS. */
	private static final String BOOKMAKER_XML_BUG_4004_AVOID_BETS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBug4004AvoidBets.xml";

	/** The Constant BOOKMAKER_XML_BET_EVENT_NOT_FOUND_EXCEPTION_TEST. */
	private static final String BOOKMAKER_XML_BET_EVENT_NOT_FOUND_EXCEPTION_TEST = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBetEventNotFoundExceptionTest.xml";

	/** The Constant BOOKMAKER_XML_BUG_4019_TOURNAMENT_NAME. */
	private static final String BOOKMAKER_XML_BUG_4019_TOURNAMENT_NAME = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBug4019TournamentName.xml";

	/** The Constant BOOKMAKER_XML_BUG_4030_GANADOR. */
	private static final String BOOKMAKER_XML_BUG_4030_GANADOR = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBug4030Ganador.xml";

	/** The Constant BOOKMAKER_XML_BUG_4036_DIFF_USE_OF_NODE_ATTR_FOR_BET_TYPES. */
	private static final String BOOKMAKER_XML_BUG_4036_DIFF_USE_OF_NODE_ATTR_FOR_BET_TYPES = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerBug4036DiffUseOfNodeAttrForBetTypes.xml";

	/** The Constant BOOKMAKER_XML_GANADOR_PARTIDO. */
	private static final String BOOKMAKER_XML_GANADOR_PARTIDO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerGanadorPartido.xml";

	/** The Constant BOOKMAKER_XML_HANDICAP_ASIATICO. */
	private static final String BOOKMAKER_XML_HANDICAP_ASIATICO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerHandicapAsiatico.xml";

	/** The Constant BOOKMAKER_XML_LOCATION. */
	private static final String BOOKMAKER_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmaker.xml";

	/** The Constant BOOKMAKER_XML_MASMENOS. */
	private static final String BOOKMAKER_XML_MASMENOS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\bookmakerMasMenos.xml";
	
	/** The Constant BOOKMAKER_XML_MASMENOS. */
	private static final String BOOKMAKER_XML_PRORROGA = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bookmaker\\prorrogaHockey.xml";

	/** The bookmaker reader. */
	@Inject
	private XMLBookmakerFileReader bookmakerReader;

	/**
	 * Bookmaker1 x2 only read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmaker1X2OnlyReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("12247", "SOCCER");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_1X2, bookmakerConfiguration,
				beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch sport : result) {

			if (sport.getName().equals(
					"1H OLIMPIA (PAR) vs 1H IND SANTA FE (COL)")) {
				for (XmlMarket xmlMarket : sport.getXmlMarkets()) {
					assertEquals(xmlMarket.getXmlBetType().getBetType(),
							BetTypeBookmaker.UNO_X_DOS);
					for (XmlMarketBet xmlMarketBet : xmlMarket
							.getXmlMarketBets()) {
						if (xmlMarketBet
								.getXmlBetOdd()
								.getOdds()
								.equals(CuotaConverterUtil
										.americanToDecimalOdds("270"))) {
							assertTrue(xmlMarketBet.getXmlMatchParticipant()
									.getName().equals("1H IND SANTA FE (COL)"));
							assertTrue(((Xml1X2Attribute) xmlMarketBet
									.getXmlAttribute()).getResult().equals(
									Result.TWO));
						} else {
							if (xmlMarketBet
									.getXmlBetOdd()
									.getOdds()
									.equals(CuotaConverterUtil
											.americanToDecimalOdds("160"))) {
								assertTrue(xmlMarketBet
										.getXmlMatchParticipant().getName()
										.equals("1H OLIMPIA (PAR)"));
								assertTrue(((Xml1X2Attribute) xmlMarketBet
										.getXmlAttribute()).getResult().equals(
										Result.ONE));
							} else {
								if (xmlMarketBet
										.getXmlBetOdd()
										.getOdds()
										.equals(CuotaConverterUtil
												.americanToDecimalOdds("105"))) {

									assertTrue(((Xml1X2Attribute) xmlMarketBet
											.getXmlAttribute()).getResult()
											.equals(Result.DRAW));
								}
							}
						}

					}
				}

			}
		}
	}

	/**
	 * Bookmaker bug3990 long term test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBug3990LongTermTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("12450", "FOOTBALL");
		map.put("12068", "SOCCER");
		map.put("12191", "NASCAR");
		map.put("12003", "GOLF");
		map.put("12138", "CRICKET");
		map.put("12008", "ENTERTAINMENT");
		map.put("12195", "FOOTBALL");
		map.put("12068", "SOCCER");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_BUG_3990_LONG_TERM,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(4, result.size());
		boolean ganadorUEFA = false;
		boolean ganadorNascar = false;
		boolean ganadorWorlCup = false;
		boolean ganadorEnglandPremierLeague = false;
		for (XmlMatch match : result) {
			if (match.getName().equals("UEFA CHAMPIONS LEAGUE 2013/14")) {
				ganadorUEFA = true;
				assertEquals("UEFA CHAMPIONS LEAGUE 2013/14", match
						.getXmlTournament().getName());
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					assertEquals(BetTypeBookmaker.GANADOR, market
							.getXmlBetType().getBetType());
					assertEquals(24, market.getXmlMarketBets().size());
				}
			} else if (match.getName().equals(
					"2013 NASCAR SPRINT CUP CHAMPIONSHIP")) {
				ganadorNascar = true;
				assertEquals("2013 NASCAR SPRINT CUP CHAMPIONSHIP", match
						.getXmlTournament().getName());
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					assertEquals(BetTypeBookmaker.GANADOR, market
							.getXmlBetType().getBetType());
					assertEquals(4, market.getXmlMarketBets().size());
				}
			} else if (match.getName().equals("WORLD CUP 2015")) {
				ganadorWorlCup = true;
				assertEquals("WORLD CUP 2015", match.getXmlTournament()
						.getName());
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					assertEquals(BetTypeBookmaker.GANADOR, market
							.getXmlBetType().getBetType());
					assertEquals(9, market.getXmlMarketBets().size());
				}
			} else if (match.getName().equals("ENGLAND PREMIER LEAGUE 2013/14")) {
				ganadorEnglandPremierLeague = true;
				assertEquals("ENGLAND PREMIER LEAGUE 2013/14", match
						.getXmlTournament().getName());
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					assertEquals(BetTypeBookmaker.GANADOR, market
							.getXmlBetType().getBetType());
					assertEquals(5, market.getXmlMarketBets().size());
				}

			} else {
				fail("No se ha recuperado los partidos esperados");
			}
		}
		assertTrue(ganadorUEFA && ganadorNascar && ganadorWorlCup
				&& ganadorEnglandPremierLeague);
	}

	/**
	 * Bookmaker bug3996 bet type event test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBug3996BetEventTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "FOOTBALL");
		map.put("104", "FOOTBALL");
		map.put("12070", "FOOTBALL");
		map.put("6", "BASEBALL");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_BUG_3996_BET_EVENT,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(8, result.size());
		for (XmlMatch match : result) {
			if (match.getXmlTournament().getXmlSport().getName()
					.equals("BASEBALL")) {
				assertEquals("MLB", match.getXmlTournament().getName());
			} else {
				assertEquals("NFL", match.getXmlTournament().getName());
			}
			if (match.getName().equals("CLEVELAND vs BUFFALO")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("TENNESSEE vs KANSAS CITY")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.PRIMERA_PARTE.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("CHICAGO vs NEW ORLEANS")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("MIAMI vs BALTIMORE")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.PRIMER_CUARTO.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("ST. LOUIS vs JACKSONVILLE")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("CINCINNATI vs NEW ENGLAND")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.TERCER_CUARTO.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("INDIANAPOLIS vs SEATTLE")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(CfgBetTypeEventId.CUARTO_CUARTO.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else if (match.getName().equals("STL vs PIT")) {
				for (XmlMarket xmlMarket : match.getXmlMarkets()) {
					assertEquals(
							CfgBetTypeEventId.CINCO_PRIMERAS_ENTRADAS.nameId(),
							xmlMarket.getXmlBetType().getXmlBetEvent()
									.getBetEvent().getId());
				}
			} else {
				fail("No se ha reconocido el evento: " + match.getName());
			}
		}
	}

	/**
	 * Bookmaker bug4004 avoid bets test. No ponemos nada en el mapa lo que debe
	 * hacer que el reader no trate ninguno de los eventos del xml.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBug4004AvoidBetsTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_BUG_4004_AVOID_BETS,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(0, result.size());
	}

	/**
	 * Bookmaker bet event not found exception test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBetEventNotFoundExceptionTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("10009", "SOCCER");
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER,
				BOOKMAKER_XML_BET_EVENT_NOT_FOUND_EXCEPTION_TEST,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(3, result.size());
	}

	/**
	 * Bookmaker bug4019 tournament name test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBug4019TournamentNameTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("12412", "BASKETBALL");
		map.put("12267", "BASKETBALL");
		map.put("12757", "HOCKEY");
		map.put("12758", "HANDBALL");
		map.put("12331", "TENNIS");
		map.put("12332", "TENNIS");
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_BUG_4019_TOURNAMENT_NAME,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(13, result.size());
		for (XmlMatch match : result) {
			if (match.getName().equalsIgnoreCase(
					"ASVEL LYON-VILLEURBANNE vs STRASBOURG IG")) {
				assertEquals("BASKETBALL - FRANCE", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase(
					"S.OLIVER BASKETS vs RATIOPHARM ULM")) {
				assertEquals("BASKETBALL - GERMANY", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase(
					"ILVES TAMPERE vs PELICANS LAHTI")) {
				assertEquals("ICE HOCKEY - FINLAND", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase(
					"AVANGARD OMSK vs HC DYNAMO MOSCOW")) {
				assertEquals("ICE HOCKEY - RUSSIA", match.getXmlTournament()
						.getName());
			} else if (match.getName()
					.equalsIgnoreCase("AIK IF vs FROLUNDA HC")) {
				assertEquals("ICE HOCKEY - SWEDEN", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase(
					"FARJESTADS BK vs BRYNAS IF")) {
				assertEquals("ICE HOCKEY - SWEDEN", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase("HV71 vs LEKSANDS IF")) {
				assertEquals("ICE HOCKEY - SWEDEN", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase(
					"EV ZUG vs HC AMBRI PIOTTA")) {
				assertEquals("ICE HOCKEY - SWITZERLAND", match
						.getXmlTournament().getName());
			} else if (match.getName().equalsIgnoreCase(
					"SKIVE FH vs SONDERJYSKE")) {
				assertEquals("HANDBALL - DENMARK", match.getXmlTournament()
						.getName());
			} else if (match.getName().equalsIgnoreCase("I DODIG vs J MELZER")) {
				assertEquals("ATP - SHANGHAI MASTERS @ SHANGHAI, CHINA", match
						.getXmlTournament().getName());
			} else if (match.getName().equalsIgnoreCase(
					"M RYBARIKOVA vs S STEPHENS")) {
				assertEquals("WTA - GENERALI LADIES LINZ @ LINZ, AUSTRIA",
						match.getXmlTournament().getName());
			} else if (match.getName().equalsIgnoreCase(
					"K RISONOVA vs A BOCHER")) {
				assertEquals("WTA - GENERALI LADIES LINZ @ LINZ, AUSTRIA",
						match.getXmlTournament().getName());
			} else if (match.getName().equalsIgnoreCase(
					"D HANTUCHOVA vs K KNAPP")) {
				assertEquals("WTA - GENERALI LADIES LINZ @ LINZ, AUSTRIA",
						match.getXmlTournament().getName());
			}
		}
	}

	/**
	 * Bookmaker bug4030 ganador test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBug4030GanadorTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("12000", "BASEBALL");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_BUG_4030_GANADOR,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("2013 NATIONAL LEAGUE PENNANT", match.getName());
			assertEquals("2013 NATIONAL LEAGUE PENNANT", match
					.getXmlTournament().getName());
			assertEquals(1, match.getXmlMarkets().size());

			for (XmlMarket xmlMarket : match.getXmlMarkets()) {
				assertEquals(xmlMarket.getXmlBetType().getBetType(),
						BetTypeBookmaker.GANADOR);
				assertEquals(3, xmlMarket.getXmlMarketBets().size());
				boolean LAD = false;
				boolean PIT = false;
				boolean CAD = false;
				for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
					assertTrue(bet.getXmlAttribute() instanceof XmlWinnerAttribute);
					XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
							.getXmlAttribute();
					assertEquals(attr.getWinner().getName(), bet
							.getXmlMatchParticipant().getName());
					if (bet.getXmlMatchParticipant().getName()
							.equalsIgnoreCase("LOS ANGELES DODGERS")) {
						assertEquals("1.65", bet.getXmlBetOdd().getOdds());
						LAD = true;
					} else if (bet.getXmlMatchParticipant().getName()
							.equalsIgnoreCase("PITTSBURGH PIRATES")) {
						assertEquals("5.67", bet.getXmlBetOdd().getOdds());
						PIT = true;
					} else if (bet.getXmlMatchParticipant().getName()
							.equalsIgnoreCase("ST LOUIS CARDINALS")) {
						assertEquals("3.17", bet.getXmlBetOdd().getOdds());
						CAD = true;
					}
				}
				assertTrue(LAD && PIT && CAD);
			}
		}
	}

	/**
	 * Bookmaker bug4036 diff use of node attr for bet type test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerBug4036DiffUseOfNodeAttrForBetTypeTest()
			throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("7", "SOCCER");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER,
				BOOKMAKER_XML_BUG_4036_DIFF_USE_OF_NODE_ATTR_FOR_BET_TYPES,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("BOS BRUINS vs COL AVALANCHE", match.getName());
			assertEquals(2, match.getXmlMarkets().size());
			boolean ganadorPartido = false;
			boolean masMenos = false;
			for (XmlMarket xmlMarket : match.getXmlMarkets()) {
				if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBookmaker.GANADOR_PARTIDO)) {
					ganadorPartido = true;
				} else if (xmlMarket.getXmlBetType().getBetType()
						.equals(BetTypeBookmaker.MAS_MENOS)) {
					masMenos = true;
				} else {
					fail("El reader ha recuperado un bet type que no existe en el xml: "
							+ xmlMarket.getXmlBetType().getBetType().getId());
				}
			}
			assertTrue(ganadorPartido && masMenos);
		}
	}

	/**
	 * Bookmaker ganador partido only read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerGanadorPartidoOnlyReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("505", "BASEBALL");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_GANADOR_PARTIDO,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch sport : result) {

			if (sport.getName().equals("NATIONALS SERIES vs BREWERS SERIES")) {
				for (XmlMarket xmlMarket : sport.getXmlMarkets()) {
					assertEquals(xmlMarket.getXmlBetType().getBetType(),
							BetTypeBookmaker.GANADOR_PARTIDO);
					for (XmlMarketBet xmlMarketBet : xmlMarket
							.getXmlMarketBets()) {
						if (xmlMarketBet
								.getXmlBetOdd()
								.getOdds()
								.equals(CuotaConverterUtil
										.americanToDecimalOdds("235"))) {
							assertTrue(xmlMarketBet.getXmlMatchParticipant()
									.getName().equals("BREWERS SERIES"));
							assertTrue(((XmlMatchWinnerAttribute) xmlMarketBet
									.getXmlAttribute()).getResult().equals(
									Result.TWO));
						} else {
							if (xmlMarketBet
									.getXmlBetOdd()
									.getOdds()
									.equals(CuotaConverterUtil
											.americanToDecimalOdds("-275"))) {
								assertTrue(xmlMarketBet
										.getXmlMatchParticipant().getName()
										.equals("NATIONALS SERIES"));
								assertTrue(((XmlMatchWinnerAttribute) xmlMarketBet
										.getXmlAttribute()).getResult().equals(
										Result.ONE));
							} else {
								if (xmlMarketBet
										.getXmlBetOdd()
										.getOdds()
										.equals(CuotaConverterUtil
												.americanToDecimalOdds("105"))) {

									assertTrue(((Xml1X2Attribute) xmlMarketBet
											.getXmlAttribute()).getResult()
											.equals(Result.DRAW));
								}
							}
						}

					}
				}

			}
		}
	}
	
	/**
	 * Bookmaker ganador partido only read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerProrrogaTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("7", "HOCKEY");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_PRORROGA,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch sport : result) {

			if (sport.getName().equals("COLUMBUS vs PITTSBURGH")) {
				for (XmlMarket xmlMarket : sport.getXmlMarkets()) {
					assertEquals(xmlMarket.getXmlBetType().getBetType(),
							CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId());
					
				}

			}
		}
	}

	/**
	 * Bookmaker handicap asiatico only read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerHandicapAsiaticoOnlyReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "FOOTBALL");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_HANDICAP_ASIATICO,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch sport : result) {

			if (sport.getName().equals("DENVER vs BALTIMORE")) {
				for (XmlMarket xmlMarket : sport.getXmlMarkets()) {

					for (XmlMarketBet xmlMarketBet : xmlMarket
							.getXmlMarketBets()) {

						if (((XmlAsianHandicapAttribute) xmlMarketBet
								.getXmlAttribute()).getAsianResult().equals(
								AsianResult.ONE)) {
							assertEquals(
									xmlMarket.getXmlBetType().getBetType(),
									BetTypeBookmaker.HANDICAP_ASIATICO);
							assertTrue(((XmlAsianHandicapAttribute) xmlMarketBet
									.getXmlAttribute()).getFirstValue().equals(
									Double.parseDouble("-8.5")));
							assertTrue(xmlMarketBet
									.getXmlBetOdd()
									.getOdds()
									.equals(CuotaConverterUtil
											.americanToDecimalOdds("-110")));
						}

						else {
							if (((XmlAsianHandicapAttribute) xmlMarketBet
									.getXmlAttribute()).getAsianResult()
									.equals(AsianResult.TWO)) {
								assertEquals(xmlMarket.getXmlBetType()
										.getBetType(),
										BetTypeBookmaker.HANDICAP_ASIATICO);
								assertTrue(((XmlAsianHandicapAttribute) xmlMarketBet
										.getXmlAttribute()).getFirstValue()
										.equals(Double.parseDouble("-8.5")));
								assertTrue(xmlMarketBet
										.getXmlBetOdd()
										.getOdds()
										.equals(CuotaConverterUtil
												.americanToDecimalOdds("-110")));
							}

						}

					}
				}

			}
		}
	}

	/**
	 * Bookmaker mas menos only read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerMasMenosOnlyReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("12247", "SOCCER");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);
		StringUtil util = new StringUtil();
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_MASMENOS,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch sport : result) {

			if (sport.getName().equals("OLIMPIA (PAR) vs IND SANTA FE (COL)")) {
				for (XmlMarket xmlMarket : sport.getXmlMarkets()) {

					for (XmlMarketBet xmlMarketBet : xmlMarket
							.getXmlMarketBets()) {
						if (xmlMarketBet
								.getXmlBetOdd()
								.getOdds()
								.equals(CuotaConverterUtil
										.americanToDecimalOdds("-140"))) {
							assertEquals(
									xmlMarket.getXmlBetType().getBetType(),
									BetTypeBookmaker.MAS_MENOS);
							assertTrue(((XmlMoreLessAttribute) xmlMarketBet
									.getXmlAttribute())
									.getTotalGoal()
									.toString()
									.equals(util.replaceCharacter("-2.0", "-",
											"")));
							assertTrue(((XmlMoreLessAttribute) xmlMarketBet
									.getXmlAttribute()).getMasMenos().equals(
									MasMenos.MAS));
						} else {
							if (xmlMarketBet
									.getXmlBetOdd()
									.getOdds()
									.equals(CuotaConverterUtil
											.americanToDecimalOdds("110"))) {

								assertTrue(((XmlMoreLessAttribute) xmlMarketBet
										.getXmlAttribute())
										.getTotalGoal()
										.toString()
										.equals(util.replaceCharacter("2.0",
												"+", "")));
								assertTrue(((XmlMoreLessAttribute) xmlMarketBet
										.getXmlAttribute()).getMasMenos()
										.equals(MasMenos.MENOS));
							}

						}

					}
				}

			}
		}
	}

	/**
	 * Bookmaker read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bookmakerReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOOKMAKER_EU_TIMEZONE);

		Map<String, String> map = new HashMap<String, String>();
		map.put("12195", "FOOTBALL");
		map.put("12618", "FOOTBALL");
		map.put("12234", "SOCCER");
		map.put("12428", "SOCCER");
		map.put("10007", "SOCCER");

		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader(
				map);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOOKMAKER_READER, BOOKMAKER_XML_LOCATION,
				bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch sport : result) {
			if (sport.getName().equals("HOME UNITED vs TANJONG PAGAR UTD")) {
				assertEquals(sport.getXmlTournament().getName(),
						"SINGAPORE - S LEAGUE");
				assertEquals(sport.getXmlMarkets().size(), 2);
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
		assertNotNull(bookmakerReader.getBookmakerId());
		assertEquals(bookmakerReader.getBookmakerId(),
				CfgBookmakerId.BOOKMAKER_EU_ID.objectId().toString());
	}

}
