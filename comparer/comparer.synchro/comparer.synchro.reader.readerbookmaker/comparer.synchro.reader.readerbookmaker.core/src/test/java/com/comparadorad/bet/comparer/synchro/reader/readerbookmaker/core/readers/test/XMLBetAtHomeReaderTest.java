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
import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome.XMLBetAtHomeReader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome.XMLBetAtHomeReader.BetTypeBetatHome;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome.XMLBetAtHomeReader.BetTypeEventBetatHome;

/**
 * The Class XMLBetAtHomeReaderTest.
 */
public final class XMLBetAtHomeReaderTest extends AbstractTest {

	/** The bet at home reader. */
	@Inject
	private XMLBetAtHomeReader betAtHomeReader;

	/** The Constant BET_AT_HOME_XML_LOCATION_1X2. */
	private static final String BET_AT_HOME_XML_LOCATION_1X2 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_1X2.xml";

	/** The Constant BET_AT_HOME_XML_LOCATION_WINNER. */
	private static final String BET_AT_HOME_XML_LOCATION_WINNER = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_Winner.xml";

	/** The Constant BET_AT_HOME_XML_LOCATION_GAME_WINNER. */
	private static final String BET_AT_HOME_XML_LOCATION_GAME_WINNER = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_Game_Winner.xml";

	/** The Constant BET_AT_HOME_XML_LOCATION_HANDICAP. */
	private static final String BET_AT_HOME_XML_LOCATION_HANDICAP = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_handicap.xml";

	/** The Constant BET_AT_HOME_XML_LOCATION_ASIAN_HANDICAP. */
	private static final String BET_AT_HOME_XML_LOCATION_ASIAN_HANDICAP = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_Asian_Handicap.xml";

	/** The Constant BET_AT_HOME_XML_LOCATION_ALL. */
	private static final String BET_AT_HOME_XML_LOCATION_ALL = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_All.xml";

	/** The Constant BET_AT_HOME_XML_LOCATION_MAS_MENOS. */
	private static final String BET_AT_HOME_XML_LOCATION_MAS_MENOS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_Mas_Menos.xml";

	private static final String BET_AT_HOME_XML_LOCATION_TOP_SCORER = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_top_scorer.xml";

	private static final String BET_AT_HOME_XML_LOCATION_BUG_3807 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_1X2_Bug3807.xml";

	private static final String BET_AT_HOME_XML_LOCATION_BUG_3947 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_Bug3947.xml";

	private static final String BET_AT_HOME_XML_LOCATION_BUG_3943 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betathome\\bet-at-home_Bug3943.xml";

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(betAtHomeReader.getBookmakerId());
		assertEquals(betAtHomeReader.getBookmakerId(),
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString());
	}

	@Test
	public void xMLBetAtHomeReaderBug3807Test() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		Xml1X2Attribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_BUG_3807, bookmakerConfiguration, null);

		assertNotNull(xmlrBetFileReaderResult);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		assertNotNull(xmlrBetFileReaderResult);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("England Premier League", match.getXmlTournament()
					.getName());
			assertEquals("Football", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals("Manchester City VS Newcastle United", match.getName());
			assertEquals(2, match.getXmlMatchParticipants().size());

			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.UNO_X_DOS);
				assertEquals(market.getXmlBetType().getXmlBetEvent()
						.getBetEvent(),
						XMLBetAtHomeReader.BetTypeEventBetatHome.PRIMERA_PARTE);
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (Xml1X2Attribute) marketBet.getXmlAttribute();
					switch (attribute.getResult()) {
					case ONE:
						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Manchester City");
						assertEquals(marketBet.getXmlMatchParticipant()
								.isHomeParticipant(), true);
						assertEquals(marketBet.getXmlMatchParticipant()
								.isAwayParticipant(), false);
						assertEquals("1.85", marketBet.getXmlBetOdd().getOdds());
						break;
					case DRAW:
						assertEquals(marketBet.getXmlMatchParticipant(), null);
						assertEquals("2.35", marketBet.getXmlBetOdd().getOdds());
						break;
					case TWO:
						assertEquals("Newcastle United", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(marketBet.getXmlMatchParticipant()
								.isHomeParticipant(), false);
						assertEquals(marketBet.getXmlMatchParticipant()
								.isAwayParticipant(), true);
						assertEquals("5.3", marketBet.getXmlBetOdd().getOdds());
						break;
					default:
						fail("El resultado no esta entre los esperados");
						break;
					}
				}
			}

		}
	}

	@Test
	public void xMLBetAtHomeReader1X2Test() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		Xml1X2Attribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_1X2, bookmakerConfiguration, null);

		assertNotNull(xmlrBetFileReaderResult);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("England Premier League", match.getXmlTournament()
					.getName());
			assertEquals("Football", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals("Manchester City VS Newcastle United", match.getName());
			assertEquals(2, match.getXmlMatchParticipants().size());

			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.UNO_X_DOS);
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (Xml1X2Attribute) marketBet.getXmlAttribute();
					switch (attribute.getResult()) {
					case ONE:
						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Manchester City");
						assertEquals(marketBet.getXmlMatchParticipant()
								.isHomeParticipant(), true);
						assertEquals(marketBet.getXmlMatchParticipant()
								.isAwayParticipant(), false);
						assertEquals("1.25", marketBet.getXmlBetOdd().getOdds());
						break;
					case DRAW:
						assertEquals(marketBet.getXmlMatchParticipant(), null);
						assertEquals("5.4", marketBet.getXmlBetOdd().getOdds());
						break;
					case TWO:
						assertEquals("Newcastle United", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(marketBet.getXmlMatchParticipant()
								.isHomeParticipant(), false);
						assertEquals(marketBet.getXmlMatchParticipant()
								.isAwayParticipant(), true);
						assertEquals(marketBet.getXmlBetOdd().getOdds(), "11.5");
						break;
					default:
						fail("El resultado no esta entre los esperados");
						break;
					}
				}
			}

		}
	}

	@Test
	public void xMLBetAtHomeReaderWinnerTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		XmlWinnerAttribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_WINNER, bookmakerConfiguration, null);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {

			assertNotNull(match.getName());
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("Spain ACB Champion", match.getXmlTournament()
					.getName());
			assertEquals("Basketball", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals("ACB Champion", match.getName());
			assertEquals(18, match.getXmlMatchParticipants().size());

			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(BetTypeBetatHome.GANADOR, market.getXmlBetType()
						.getBetType());
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (XmlWinnerAttribute) marketBet
							.getXmlAttribute();
					if ("Real Madrid".equals(attribute.getName())) {

						assertEquals("Real Madrid", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals("1.95", marketBet.getXmlBetOdd().getOdds());
					} else if ("Regal FC Barcelona".equals(attribute.getName())) {
						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Regal FC Barcelona");
						assertEquals("2.2", marketBet.getXmlBetOdd().getOdds());
					}
				}
			}

		}
	}

	@Test
	public void xMLBetAtHomeReaderGameWinnerTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		XmlMatchWinnerAttribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_GAME_WINNER, bookmakerConfiguration,
				null);

		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());
		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {

			assertNotNull(match.getName());
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("ATP Winston Salem Doubles", match.getXmlTournament()
					.getName());
			assertEquals("Tennis", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals(
					"Bopanna R./Roger-Vasselin E. VS Cermak F./Polasek F.",
					match.getName());
			assertEquals(2, match.getXmlMatchParticipants().size());

			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.GANADOR_PARTIDO);
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (XmlMatchWinnerAttribute) marketBet
							.getXmlAttribute();
					switch (attribute.getResult()) {
					case ONE:
						assertEquals("Bopanna R./Roger-Vasselin E.", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(true, marketBet.getXmlMatchParticipant()
								.isHomeParticipant());
						assertEquals(false, marketBet.getXmlMatchParticipant()
								.isAwayParticipant());
						assertEquals("1.5", marketBet.getXmlBetOdd().getOdds());
						break;
					case TWO:
						assertEquals("Cermak F./Polasek F.", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(false, marketBet.getXmlMatchParticipant()
								.isHomeParticipant());
						assertEquals(true, marketBet.getXmlMatchParticipant()
								.isAwayParticipant());
						assertEquals("2.1", marketBet.getXmlBetOdd().getOdds());
						break;

					}
				}
			}

		}

	}

	@Test
	public void xMLBetAtHomeReaderHandicapTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		Xml1X2HandicapAttribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_HANDICAP, bookmakerConfiguration, null);

		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());
		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {

			assertNotNull(match.getName());
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("England Premier League", match.getXmlTournament()
					.getName());
			assertEquals("Football", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals("Manchester City VS Newcastle United", match.getName());
			assertEquals(2, match.getXmlMatchParticipants().size());

			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.UNO_X_DOS_HANDICAP);
				assertEquals(3, market.getXmlMarketBets().size());
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (Xml1X2HandicapAttribute) marketBet
							.getXmlAttribute();
					switch (attribute.getResult()) {
					case ONE:
						assertEquals("Manchester City", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(true, marketBet.getXmlMatchParticipant()
								.isHomeParticipant());
						assertEquals(false, marketBet.getXmlMatchParticipant()
								.isAwayParticipant());
						assertEquals("1.6", marketBet.getXmlBetOdd().getOdds());
						break;
					case DRAW:
						assertEquals(marketBet.getXmlMatchParticipant(), null);
						assertEquals("3.6", marketBet.getXmlBetOdd().getOdds());
						break;
					case TWO:
						assertEquals("Newcastle United", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(false, marketBet.getXmlMatchParticipant()
								.isHomeParticipant());
						assertEquals(true, marketBet.getXmlMatchParticipant()
								.isAwayParticipant());
						assertEquals("3.65", marketBet.getXmlBetOdd().getOdds());
						break;
					default:
						fail("El resultado no esta entre los esperados");
						break;
					}
				}

			}

		}
	}

	@Test
	public void xMLBetAtHomeReaderAsianHandicapTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		XmlAsianHandicapAttribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_ASIAN_HANDICAP,
				bookmakerConfiguration, null);

		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {

			assertNotNull(match.getName());
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("ATP Winston Salem", match.getXmlTournament()
					.getName());
			assertEquals("Tennis", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals("Isner J. VS Bogomolov Jr A.", match.getName());
			assertEquals(2, match.getXmlMatchParticipants().size());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.HANDICAP_ASIATICO);
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (XmlAsianHandicapAttribute) marketBet
							.getXmlAttribute();
					switch (attribute.getAsianResult()) {
					case ONE:
						assertEquals("Isner J.", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(true, marketBet.getXmlMatchParticipant()
								.isHomeParticipant());
						assertEquals(false, marketBet.getXmlMatchParticipant()
								.isAwayParticipant());

						assertEquals("1.6", marketBet.getXmlBetOdd().getOdds());
						break;
					case TWO:
						assertEquals("Bogomolov Jr A.", marketBet
								.getXmlMatchParticipant().getName());
						assertEquals(false, marketBet.getXmlMatchParticipant()
								.isHomeParticipant());
						assertEquals(true, marketBet.getXmlMatchParticipant()
								.isAwayParticipant());
						assertEquals("2.0", marketBet.getXmlBetOdd().getOdds());
						break;
					default:
						fail("El resultado no esta entre los esperados");
						break;
					}
					if (-1.5f != attribute.getFirstValue()) {
						fail("El valor de handicap es incorrecto");
					}
				}
			}
		}
	}

	@Test
	public void xMLBetAtHomeReaderMasMenosTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		XmlMoreLessAttribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_MAS_MENOS, bookmakerConfiguration,
				null);

		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {

			assertNotNull(match.getName());
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals("England Premier League", match.getXmlTournament()
					.getName());
			assertEquals("Manchester City VS Newcastle United", match.getName());
			assertEquals("Football", match.getXmlTournament().getXmlSport()
					.getName());
			assertEquals(2, match.getXmlMatchParticipants().size());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.MAS_MENOS);
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (XmlMoreLessAttribute) marketBet
							.getXmlAttribute();
					switch (attribute.getMasMenos()) {
					case MAS:
						assertEquals(String.valueOf(2.5), attribute.getTotalGoal().toString());
						assertEquals("1.55", marketBet.getXmlBetOdd().getOdds());
						break;
					case MENOS:
						assertEquals(String.valueOf(2.5), attribute.getTotalGoal().toString());
						assertEquals("2.2", marketBet.getXmlBetOdd().getOdds());
						break;
					default:
						fail("El resultado no esta entre los esperados");
						break;

					}
				}
			}

		}

	}

	@Test
	public void xMLBetAtHomeReaderAllTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_ALL, bookmakerConfiguration, null);

		assertEquals(2190, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());
	}

	@Test
	public void xMLBetAtHomeReaderTopScorerTest() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		XmlMaximumGoalerAttribute attribute;

		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_TOP_SCORER, bookmakerConfiguration,
				null);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {

			assertNotNull(match.getName());
			assertNotNull(match.getStartDate());
			assertNotNull(match.getXmlTournament());
			assertNotNull(match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());

			assertEquals(match.getXmlTournament().getName(),
					"Italy Serie A Top Goal scorer");
			assertEquals(match.getXmlTournament().getXmlSport().getName(),
					"Football");
			assertEquals(match.getName(), "Italy Serie A top scorer 2013/14");
			assertEquals(4, match.getXmlMatchParticipants().size());

			for (XmlMarket market : match.getXmlMarkets()) {
				assertEquals(market.getXmlBetType().getBetType(),
						BetTypeBetatHome.MAXIMO_GOLEADOR);
				for (XmlMarketBet marketBet : market.getXmlMarketBets()) {
					attribute = (XmlMaximumGoalerAttribute) marketBet
							.getXmlAttribute();
					if ("Mario Balotelli".equals(attribute.getGoaler()
							.getName())) {

						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Mario Balotelli");
						assertEquals(marketBet.getXmlBetOdd().getOdds(), "2.9");
					} else if ("Mario Gomez".equals(attribute.getGoaler()
							.getName())) {
						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Mario Gomez");
						assertEquals(marketBet.getXmlBetOdd().getOdds(), "4.75");
					} else if ("Antonio Di Natale".equals(attribute.getGoaler()
							.getName())) {
						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Antonio Di Natale");
						assertEquals(marketBet.getXmlBetOdd().getOdds(), "6.35");
					} else if ("Miroslav Klose".equals(attribute.getGoaler()
							.getName())) {
						assertEquals(marketBet.getXmlMatchParticipant()
								.getName(), "Miroslav Klose");
						assertEquals(marketBet.getXmlBetOdd().getOdds(), "9.5");
					} else {
						fail("Error en la apuesta maximo goleador");
					}
				}
			}

		}

	}

	@Test
	public void xMLBetAtHomeReaderBug_3947() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_BUG_3947, bookmakerConfiguration, null);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());
		XmlMatch match = xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().iterator().next();
		assertEquals("Bopanna R./Roger-Vasselin E. VS Cermak F./Polasek F.",
				match.getName());
		assertEquals(1, match.getXmlMarkets().size());
		XmlMarket market = match.getXmlMarkets().iterator().next();
		assertEquals(BetTypeBetatHome.GANADOR_PARTIDO, market.getXmlBetType()
				.getBetType());
		assertEquals(2, market.getXmlMarketBets().size());

		for (XmlMarketBet bet : market.getXmlMarketBets()) {
			if (((XmlMatchWinnerAttribute) bet.getXmlAttribute()).getResult()
					.equals(Result.ONE)) {
				assertEquals("1.5", bet.getXmlMarketBetOdd().getOdds());
			} else if (((XmlMatchWinnerAttribute) bet.getXmlAttribute())
					.getResult().equals(Result.TWO)) {
				assertEquals("2.1", bet.getXmlMarketBetOdd().getOdds());
			} else {
				fail("Las cuotas son incorrectas");
			}
		}
	}

	@Test
	public void xMLBetAtHomeReaderBug_3943() throws Exception {

		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETATHOME_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BET_AT_HOME,
				BET_AT_HOME_XML_LOCATION_BUG_3943, bookmakerConfiguration, null);
		assertEquals(2, xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size());

		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs()) {
			if (match.getName().equals(
					"Bopanna R./Roger-Vasselin E. VS Cermak F./Polasek F.")) {
				assertEquals(1, match.getXmlMarkets().size());
				XmlMarket market = match.getXmlMarkets().iterator().next();
				assertEquals(BetTypeBetatHome.GANADOR_PARTIDO, market
						.getXmlBetType().getBetType());
				assertEquals(BetTypeEventBetatHome.PARTIDO_COMPLETO, market
						.getXmlBetType().getXmlBetEvent().getBetEvent());
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					if (((XmlMatchWinnerAttribute) bet.getXmlAttribute())
							.getResult().equals(Result.ONE)) {
						assertEquals("1.5", bet.getXmlMarketBetOdd().getOdds());
					} else if (((XmlMatchWinnerAttribute) bet.getXmlAttribute())
							.getResult().equals(Result.TWO)) {
						assertEquals("2.1", bet.getXmlMarketBetOdd().getOdds());
					} else {
						fail("Las cuotas son incorrectas");
					}
				}
			} else if (match.getName().equals(
					"Lopanna R./Roger-Vasselin E. VS Cermak F./Polasek F.")) {
				assertEquals(1, match.getXmlMarkets().size());
				XmlMarket market = match.getXmlMarkets().iterator().next();
				assertEquals(BetTypeBetatHome.GANADOR_PARTIDO, market
						.getXmlBetType().getBetType());
				assertEquals(BetTypeEventBetatHome.PRIMERA_PARTE, market
						.getXmlBetType().getXmlBetEvent().getBetEvent());
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					if (((XmlMatchWinnerAttribute) bet.getXmlAttribute())
							.getResult().equals(Result.ONE)) {
						assertEquals("1.5", bet.getXmlMarketBetOdd().getOdds());
					} else if (((XmlMatchWinnerAttribute) bet.getXmlAttribute())
							.getResult().equals(Result.TWO)) {
						assertEquals("2.1", bet.getXmlMarketBetOdd().getOdds());
					} else {
						fail("Las cuotas son incorrectas");
					}
				}
			} else {
				fail("Los partidos son incorrectos");
			}
		}
	}

}
