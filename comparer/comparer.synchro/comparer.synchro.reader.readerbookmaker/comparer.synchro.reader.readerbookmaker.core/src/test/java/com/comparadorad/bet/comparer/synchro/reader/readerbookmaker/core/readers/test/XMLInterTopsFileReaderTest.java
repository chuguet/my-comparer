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

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.intertops.XMLIntertopsFileReader;

/**
 * The Class XMLInterTopsFileReaderTest.
 */
public class XMLInterTopsFileReaderTest extends AbstractTest {

	/** The Constant INTERTOPS_XML_LOCATION_HANDICAP_ASIATICO. */
	private static final String INTERTOPS_XML_LOCATION_HANDICAP_ASIATICO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_AsianHandicap.xml";

	/** The Constant INTERTOPS_XML_LOCATION_GANADOR_PARTIDO. */
	private static final String INTERTOPS_XML_LOCATION_GANADOR_PARTIDO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_GanadorPartido.xml";

	/** The Constant INTERTOPS_XML_LOCATION_MAS_MENOS. */
	private static final String INTERTOPS_XML_LOCATION_MAS_MENOS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_MasMenos.xml";

	/** The Constant INTERTOPS_XML_LOCATION_GANDOR. */
	private static final String INTERTOPS_XML_LOCATION_GANDOR = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_Ganador.xml";

	/** The Constant INTERTOPS_XML_LOCATION_MAXIMO_GOLEADOR. */
	private static final String INTERTOPS_XML_LOCATION_MAXIMO_GOLEADOR = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_MaximoGoleador.xml";

	/** The Constant INTERTOPS_XML_LOCATION_1X2. */
	private static final String INTERTOPS_XML_LOCATION_1X2 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_1X2.xml";

	/** The Constant INTERTOPS_XML_LOCATION_PRORROGA_ICE_HOCKEY. */
	private static final String INTERTOPS_XML_LOCATION_PRORROGA_ICE_HOCKEY = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_ProrrogaIceHockey.xml";

	/** The Constant INTERTOPS_XML_LOCATION_FULL. */
	private static final String INTERTOPS_XML_LOCATION_FULL = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_Full.xml";

	/** The Constant INTERTOPS_XML_TENNIS_CORTO_PLAZO. */
	private static final String INTERTOPS_XML_TENNIS_CORTO_PLAZO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\intertops\\Intertops_TennisCortoPlazo.xml";
	/** The bet click reader. */
	@Inject
	private XMLIntertopsFileReader interTopsReader;

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(interTopsReader.getBookmakerId());
		assertEquals(interTopsReader.getBookmakerId(),
				CfgBookmakerId.INTERTOPS_EU_ID.objectId().toString());
	}

	/**
	 * Red allports test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void redAllportsTest() {
		try {
			CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
			bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);

			XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
					INTERTOPS_READER, INTERTOPS_XML_LOCATION_FULL,
					bookmakerConfiguration, null);
			if (xmlrBetFileReaderResult == null) {
				fail("Error Procesando el xml completo con todos los deportes");
			}
		} catch (Exception e) {
			fail("Error Procesando el xml completo con todos los deportes");
		}
	}

	/**
	 * Inter tops ganador partido test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsGanadorPartidoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_GANADOR_PARTIDO,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 1);
		for (XmlMatch match : result) {
			if (match.getName().equals("Colorado State v Washington State")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.GANADOR_PARTIDO)) {
						assertEquals(2, market.getXmlMarketBets().size());
						assertEquals(market.getXmlBetType().getXmlBetEvent()
								.getBetEvent(),
								BetEventInterTops.PARTIDO_COMPLETO_PRORROGA);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertEquals("Colorado State", bet
										.getXmlMatchParticipant().getName());
								assertEquals("2.65", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (dato.getResult().equals(Result.TWO)) {
								assertEquals("Washington State", bet
										.getXmlMatchParticipant().getName());
								assertEquals("1.5263", bet.getXmlMarketBetOdd()
										.getOdds());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Inter tops mas menos test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsMasMenosTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_MAS_MENOS,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 1);
		for (XmlMatch match : result) {
			if (match.getName().equals("Colorado State v Washington State")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.MAS_MENOS)) {
						assertEquals(2, market.getXmlMarketBets().size());
						assertEquals(market.getXmlBetType().getXmlBetEvent()
								.getBetEvent(),
								BetEventInterTops.PARTIDO_COMPLETO_PRORROGA);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS)) {
								assertEquals("1.9091", bet.getXmlBetOdd()
										.getOdds());
								assertTrue(dato.getTotalGoal() == 66);
							} else if (dato.getMasMenos()
									.equals(MasMenos.MENOS)) {
								assertEquals("1.9091", bet.getXmlBetOdd()
										.getOdds());
								assertTrue(dato.getTotalGoal() == 66);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Inter tops handicap asiatico test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsHandicapAsiaticoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_HANDICAP_ASIATICO,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 1);
		for (XmlMatch match : result) {
			if (match.getName().equals("Colorado State v Washington State")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.HANDICAP_ASIATICO)) {
						assertEquals(2, market.getXmlMarketBets().size());
						assertEquals(market.getXmlBetType().getXmlBetEvent()
								.getBetEvent(),
								BetEventInterTops.PARTIDO_COMPLETO_PRORROGA);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							if (dato.getAsianResult().equals(AsianResult.ONE)) {

								assertEquals("Colorado State", bet
										.getXmlMatchParticipant().getName());
								assertEquals("1.9091", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("4.5", dato.getFirstValue()
										.toString());
							} else if (dato.getAsianResult().equals(
									AsianResult.TWO)) {

								assertEquals("Washington State", bet
										.getXmlMatchParticipant().getName());
								assertEquals("1.9091", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("4.5", dato.getFirstValue()
										.toString());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Inter tops prorroga ice hockey test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsProrrogaIceHockeyTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_PRORROGA_ICE_HOCKEY,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 2);
		for (XmlMatch match : result) {
			if (match.getName().equals("Sweden v Russia")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.UNO_X_DOS)) {
						assertEquals(3, market.getXmlMarketBets().size());
						assertEquals(market.getXmlBetType().getXmlBetEvent()
								.getBetEvent(),
								BetEventInterTops.PARTIDO_COMPLETO);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertEquals("Sweden", bet
										.getXmlMatchParticipant().getName());
								assertEquals("5.25", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (dato.getResult().equals(Result.TWO)) {
								assertEquals("Russia", bet
										.getXmlMatchParticipant().getName());
								assertEquals("1.4", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (dato.getResult().equals(Result.DRAW)) {
								assertEquals("5", bet.getXmlMarketBetOdd()
										.getOdds());
							}
						}
					}
				}
			} else if (match.getName().equals(
					"Nashville Predators v Tampa Bay Lightning")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						assertEquals(market.getXmlBetType().getXmlBetEvent()
								.getBetEvent(),
								BetEventInterTops.PARTIDO_COMPLETO_PRORROGA);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertEquals("Nashville Predators", bet
										.getXmlMatchParticipant().getName());
								assertEquals("2.2", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (dato.getResult().equals(Result.TWO)) {
								assertEquals("Tampa Bay Lightning", bet
										.getXmlMatchParticipant().getName());
								assertEquals("1.7143", bet.getXmlMarketBetOdd()
										.getOdds());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Inter tops1 x2 test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTops1X2Test() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_1X2,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			if (match.getName().equals("Banni Yas v Al Jazeera")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.UNO_X_DOS)) {
						assertEquals(3, market.getXmlMarketBets().size());
						assertEquals(market.getXmlBetType().getXmlBetEvent()
								.getBetEvent(),
								BetEventInterTops.PARTIDO_COMPLETO);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertEquals("Banni Yas", bet
										.getXmlMatchParticipant().getName());
								assertEquals("2.7", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (dato.getResult().equals(Result.TWO)) {
								assertEquals("Al Jazeera", bet
										.getXmlMatchParticipant().getName());
								assertEquals("2.3", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (dato.getResult().equals(Result.DRAW)) {
								assertEquals("3.3", bet.getXmlMarketBetOdd()
										.getOdds());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Inter tops ganador test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsGanadorTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_GANDOR,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			if (match.getName().contains("To Win")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.GANADOR)) {
						assertEquals(32, market.getXmlMarketBets().size());
						assertEquals(BetEventInterTops.PARTIDO_COMPLETO, market
								.getXmlBetType().getXmlBetEvent().getBetEvent());
					} else {
						fail("BetType resuelto erroneamente. Deberia ser un Ganador y el resultado fue: "
								+ market.getXmlBetType().getBetType());
					}
				}
			}
		}
	}

	/**
	 * Inter tops maximo goleador test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsMaximoGoleadorTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_LOCATION_MAXIMO_GOLEADOR,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 1);
		for (XmlMatch match : result) {
			if (match.getName().contains("Goalscorer")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.MAXIMO_GOLEADOR)) {
						assertEquals(24, market.getXmlMarketBets().size());
						assertEquals(BetEventInterTops.PARTIDO_COMPLETO, market
								.getXmlBetType().getXmlBetEvent().getBetEvent());
					} else {
						fail("BetType resuelto erroneamente. Deberia ser un Maximo Goleador y el resultado fue: "
								+ market.getXmlBetType().getBetType());
					}
				}
			}
		}

	}

	/**
	 * Inter tops test para competicion tennis.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void interTopsTennisCortoPlazoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(INTERTOPS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				INTERTOPS_READER, INTERTOPS_XML_TENNIS_CORTO_PLAZO,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 2);
		for (XmlMatch match : result) {

			// Gandor partido - Corto plazo
			if (match.getName().equals(
					"Guillermo Garcia Lopez v Julian Reister")) {
				for (XmlMarket market : match.getXmlMarkets()) {

					assertEquals(BetTypeInterTops.GANADOR_PARTIDO, market
							.getXmlBetType().getBetType());
					assertEquals(2, market.getXmlMarketBets().size());
					assertEquals(market.getXmlBetType().getXmlBetEvent()
							.getBetEvent(), BetEventInterTops.PARTIDO_COMPLETO);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet
								.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertEquals("Guillermo Garcia Lopez", bet
									.getXmlMatchParticipant().getName());
							assertEquals("1.3846", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (dato.getResult().equals(Result.TWO)) {
							assertEquals("Julian Reister", bet
									.getXmlMatchParticipant().getName());
							assertEquals("3", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					}

				}
			} else if (match.getName()
					.equals("2014 Davis Cup: To Win Outright")) {
				for (XmlMarket market : match.getXmlMarkets()) {

					assertEquals(BetTypeInterTops.GANADOR, market
							.getXmlBetType().getBetType());
					assertEquals(8, market.getXmlMarketBets().size());
					assertEquals(market.getXmlBetType().getXmlBetEvent()
							.getBetEvent(), BetEventInterTops.PARTIDO_COMPLETO);
				}

			}
		}

	}
}
