package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBlueSquare;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bluesquare.XMLBlueSquareFileReader;

public class XMLBlueSquareFileReaderTest extends AbstractTest {

	private static final String BLUESQUARE_XML_BUG3354 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bluesquare\\blueSquare _bug3354.xml";

	private static final String BLUESQUARE_XML_BUG3353 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bluesquare\\blueSquare _bug3353.xml";

	/** The bet click reader. */
	@Inject
	private XMLBlueSquareFileReader blueSquareReader;

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(blueSquareReader.getBookmakerId());
		assertEquals(blueSquareReader.getBookmakerId(),
				CfgBookmakerId.BLUESQUARE_COM_ID.objectId().toString());
	}

	// Bug 3354
	@Test
	public void testBug3354() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BLUESQUARE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BLUESQUARE_READER, BLUESQUARE_XML_BUG3354,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertTrue(result.size() == 3);
		for (XmlMatch match : result) {
			if (match.getName().equals("Real Madrid v Atletico Madrid")) {
				assertTrue(match.getXmlTournament().getName()
						.equals("Liga BBVA"));
				assertTrue(match.getXmlTournament().getXmlSport().getName()
						.equals("Football Matches"));
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType()
							.equals(BetTypeBlueSquare.UNO_X_DOS));
					assertTrue(market.getXmlMarketBets().size() == 3);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute dato = (Xml1X2Attribute) bet
								.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("3.2"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Real Madrid"));
						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("2.2"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Atletico Madrid"));
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("2.875"));
							assertTrue(bet.getXmlMatchParticipant() == null);
						}
					}
				}
			} else if (match.getName().equals(
					"Boca Juniors v Newell's Old Boys")) {
				assertTrue(match.getXmlTournament().getName()
						.equals("Liga BBVA"));
				assertTrue(match.getXmlTournament().getXmlSport().getName()
						.equals("Football Matches"));
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType()
							.equals(BetTypeBlueSquare.UNO_X_DOS_HANDICAP));
					assertTrue(market.getXmlMarketBets().size() == 3);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2HandicapAttribute dato = (Xml1X2HandicapAttribute) bet
								.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("5"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Boca Juniors"));
						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("1.5333333333333"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Newell's Old Boys"));
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("3.75"));
							assertTrue(bet.getXmlMatchParticipant() == null);
						}
					}
				}
			} else if (match.getName().equals(
					"Borussia Dortmund v Bayern Munich")) {
				assertTrue(match.getXmlTournament().getName()
						.equals("Liga BBVA"));
				assertTrue(match.getXmlTournament().getXmlSport().getName()
						.equals("Football Matches"));
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType()
							.equals(BetTypeBlueSquare.GANADOR_PARTIDO));
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet
								.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("3.25"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Borussia Dortmund"));
							assertTrue(dato.getWinnerName().getName()
									.equals("Borussia Dortmund"));
							assertTrue(dato.getWinnerName().isHomeParticipant());
							assertFalse(dato.getWinnerName()
									.isAwayParticipant());

						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("1.3636363636364"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Bayern Munich"));
							assertTrue(dato.getWinnerName().isAwayParticipant());
							assertFalse(dato.getWinnerName()
									.isHomeParticipant());
						}
					}
				}
			} else {
				fail("Debe de existir uno de los eventos superiores");
			}

		}
	}

	// Bug 3253
	@Test
	public void testBug3253() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BLUESQUARE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BLUESQUARE_READER, BLUESQUARE_XML_BUG3353,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();

		assertTrue(result.size() == 1);
		for (XmlMatch match : result) {
			assertTrue(match.getName().equals("Mallorca v Betis"));
			assertTrue(match.getXmlTournament().getName().equals("Liga BBVA"));
			assertTrue(match.getXmlTournament().getXmlSport().getName()
					.equals("Football Matches"));
			for (XmlMarket market : match.getXmlMarkets()) {
				assertTrue(market.getXmlBetType().getBetType()
						.equals(BetTypeBlueSquare.UNO_X_DOS_HANDICAP));
				assertTrue(market.getXmlMarketBets().size() == 3);
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					Xml1X2HandicapAttribute dato = (Xml1X2HandicapAttribute) bet
							.getXmlAttribute();
					if (dato.getResult().equals(Result.ONE)) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds()
								.equals("1.5714285714286"));
						assertTrue(bet.getXmlMatchParticipant().getName()
								.equals("Mallorca"));
						assertTrue(bet.getXmlMatchParticipant().isHomeParticipant());
						assertFalse(bet.getXmlMatchParticipant().isAwayParticipant());
						assertTrue(dato.getFirstValue() == -1.0);
					} else if (dato.getResult().equals(Result.TWO)) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds()
								.equals("4"));
						assertTrue(bet.getXmlMatchParticipant().getName()
								.equals("Betis"));
						assertTrue(bet.getXmlMatchParticipant().isAwayParticipant());
						assertFalse(bet.getXmlMatchParticipant().isHomeParticipant());
						assertTrue(dato.getFirstValue() == -1.0);
					} else {
						assertTrue(bet.getXmlMarketBetOdd().getOdds()
								.equals("4.3333333333333"));
						assertTrue(bet.getXmlMatchParticipant() == null);
						assertTrue(dato.getFirstValue() == -1.0);
					}
				}
			}
		}
	}
}
