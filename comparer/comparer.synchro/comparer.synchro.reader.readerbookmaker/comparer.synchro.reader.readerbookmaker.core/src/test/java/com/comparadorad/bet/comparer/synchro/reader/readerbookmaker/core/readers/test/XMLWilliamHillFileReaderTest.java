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
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill.XMLWilliamHillFileReader;

/**
 * The Class XMLWilliamHillFileReaderTest.
 */
public class XMLWilliamHillFileReaderTest extends AbstractTest {

	/** The Constant WH_XML_LOCATION. */
	private static final String WH_BLUE_SQUARE_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamHillUKFootballBlueSquare.xml";

	private static final String WH_BLUE_SQUARE_XML_LOCATION_BUG3250 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamBug3250.xml";

	private static final String WH_BLUE_SQUARE_XML_LOCATION_BLACKLIST = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamBlackList.xml";

	/** The Constant WILLIAM_BAD_XML_LOCATION. */
	private static final String WILLIAM_BAD_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamHillBadXML.xml";

	/** The william hill reader. */
	@Inject
	private XMLWilliamHillFileReader williamHillReader;

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(williamHillReader.getBookmakerId());
		assertEquals(williamHillReader.getBookmakerId(), CfgBookmakerId.WILLIAMHILL_COM_ID.objectId().toString());
	}

	/**
	 * William hill read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void williamHillReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(WILLIAMHILL_TIMEZONE);

		// UK Football
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(WILLIAM_READER, WH_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultFootball = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultFootball.size() > 0);
		for (XmlMatch type : resultFootball) {
			if (type.getName().equals("Macclesfield v Barrow - Match Betting")) {
				assertEquals(type.getXmlTournament().getXmlSport().getName(), "UK Football");
				assertEquals(type.getXmlTournament().getName(), "English FA Cup");
				for (XmlMarket market : type.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeWilliamHill.UNO_X_DOS));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Macclesfield"));
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.62"));
						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Barrow"));
							assertTrue(bet.getXmlBetOdd().getOdds().equals("4.33"));
						} else if (dato.getResult().equals(Result.DRAW)) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.60"));
						} else {
							fail("Fallo al resolver apuesta de 1x2");
						}
					}
				}
			}
		}

		// Apuesta tipo ganador
		xmlrBetFileReaderResult = readXML(WILLIAM_READER, WH_BLUE_SQUARE_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultGanador = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultGanador.size() == 1);
		for (XmlMatch type : resultGanador) {
			Assert.isTrue(type.getXmlMatchParticipants().size() == 4);
			assertEquals(type.getXmlTournament().getXmlSport().getName(), "UK Football");
			assertEquals(type.getXmlTournament().getName(), "English Blue Square Premier");
			for (XmlMarket market : type.getXmlMarkets()) {
				assertTrue(market.getXmlBetType().getBetType().equals(BetTypeWilliamHill.GANADOR));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					XmlWinnerAttribute dato = (XmlWinnerAttribute) bet.getXmlAttribute();
					if (dato.getWinner().getName().equals("Lincoln")) {
						assertTrue(bet.getXmlBetOdd().getOdds().equals("34.00"));
					} else if (dato.getWinner().getName().equals("Luton")) {
						assertTrue(bet.getXmlBetOdd().getOdds().equals("5.00"));
					} else if (dato.getWinner().getName().equals("Kidderminster")) {
						assertTrue(bet.getXmlBetOdd().getOdds().equals("8.00"));
					} else if (dato.getWinner().getName().equals("Wrexham")) {
						assertTrue(bet.getXmlBetOdd().getOdds().equals("9.00"));
					} else {
						fail("Fallo al resolver apuesta de ganador");
					}
				}
			}
		}


		// Bug 3250
		xmlrBetFileReaderResult = readXML(WILLIAM_READER, WH_BLUE_SQUARE_XML_LOCATION_BUG3250, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3250 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3250.size() > 0);
		for (XmlMatch type : resultBug3250) {
			if (type.getName().equals("New York Knicks @ Indiana Pacers - Alternative Handicap 5")) {
				for (XmlMatchParticipant participant : type.getXmlMatchParticipants()) {
					assertTrue(participant.getName().equals("New York Knicks") || participant.getName().equals("Indiana Pacers"));
				}
				for (XmlMarket market : type.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeWilliamHill.HANDICAP_ASIATICO));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (dato.getAsianResult().equals(AsianResult.ONE)) {
							assertTrue(bet.getXmlMatchParticipant().getName().equals("New York Knicks"));
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.00"));
							assertTrue(dato.getFirstValue() == -5.0);
						} else {
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Indiana Pacers"));
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.14"));
							assertTrue(dato.getFirstValue() == -5.0);
						}
					}
				}
			} else {
				for (XmlMatchParticipant participant : type.getXmlMatchParticipants()) {
					assertTrue(participant.getName().equals("Getafe") || participant.getName().equals("Valencia"));
				}
				for (XmlMarket market : type.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeWilliamHill.MAS_MENOS));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
						if (dato.getMasMenos().equals(MasMenos.MAS)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.62"));
							assertTrue(dato.getTotalGoal() == 2.5);
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.20"));
							assertTrue(dato.getTotalGoal() == 2.5);
						}
					}
				}
			}
		}
	}

	/**
	 * William hill incomplete test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	//@Test(expected = com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException.class)
	public void williamHillIncompleteTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(WILLIAMHILL_TIMEZONE);

		// Incompleto
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(WILLIAM_READER, WH_INC_XML_LOCATION, bookmakerConfiguration, null);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size() == 0);
	}

	/**
	 * William hill bad test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test(expected = com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException.class)
	public void williamHillBadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(WILLIAMHILL_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(WILLIAM_READER, WILLIAM_BAD_XML_LOCATION, bookmakerConfiguration, null);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size() == 0);
	}

	@Test
	public void blackListTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.addBlackListWord("Vincente");
		bookmakerConfiguration.setTimeZone(WILLIAMHILL_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(WILLIAM_READER, WH_BLUE_SQUARE_XML_LOCATION_BLACKLIST,
				bookmakerConfiguration, null);
		Collection<XmlMatch> resultBlackList = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();

		assertTrue(resultBlackList.size() == 1);
		for (XmlMatch match : resultBlackList) {
			assertTrue(match.getName().equals("English Premier League - Outright - Outright"));
			assertTrue(match.getXmlMarkets().size() == 1);
			for (XmlMarket market : match.getXmlMarkets()) {
				assertTrue(market.getXmlBetType().getBetType().equals(BetTypeWilliamHill.GANADOR));
				assertTrue(market.getXmlMarketBets().size() == 20);
			}
		}

	}
}
