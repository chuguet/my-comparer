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
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetFred;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetFred;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betfred.XMLBetFredFileReader;

/**
 * The Class XMLBetFredFileReaderTest.
 */
public class XMLBetFredFileReaderTest extends AbstractTest {

	/** The bet fred file reader. */
	@Inject
	private XMLBetFredFileReader betFredFileReader;

	/** The Constant BETFRED_DARTS_XML_LOCATION. */
	private static final String BETFRED_DARTS_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_darts.xml";

	/** The Constant BETFRED_DARTS_XML_MAXIMO_LOCATION. */
	private static final String BETFRED_DARTS_XML_MAXIMO_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_maximoGol.xml";

	/** The Constant BETFRED_DARTS_XML_HANDICAP. */
	private static final String BETFRED_DARTS_XML_HANDICAP = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_soccer_Handicap.xml";

	/** The Constant BETFRED_DARTS_XML_MASMENOS. */
	private static final String BETFRED_DARTS_XML_MASMENOS = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_soccer_MasMenos.xml";

	/** The Constant BETFRED_DARTS_XML_HANDICAP_ASIATICO. */
	private static final String BETFRED_DARTS_XML_HANDICAP_ASIATICO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_soccer_HandicapAsiatico.xml";

	/** The Constant BETFRED_DARTS_XML_LOCATION. */
	private static final String BETFRED_DARTS_XML_FECHA3214 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_Fecha3214.xml";

	/** The Constant BETFRED_BUG_3562. */
	private static final String BETFRED_BUG_3562 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred\\bug3562.xml";

	/** The Constant BETFRED_BUG_3887. */
	private static final String BETFRED_BUG_3887 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred\\bug3887.xml";

	/** The Constant BETFRED_BUG_4003. */
	private static final String BETFRED_BUG_4003 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred\\bug4003.xml";

	/** The Constant BETFRED_BUG_4217. */
	private static final String BETFRED_BUG_4217 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred\\Betfred_Bug4217.xml";

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(betFredFileReader.getBookmakerId());
		assertEquals(betFredFileReader.getBookmakerId(), CfgBookmakerId.BETFRED_COM_ID.objectId().toString());
	}

	/**
	 * Bet fred read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betFredReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETFRED_TIMEZONE);

		// Darts
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_DARTS_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultDarts = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultDarts.size() > 0);
		for (XmlMatch event : resultDarts) {
			assertEquals(event.getName(), "Wade, J v Van Barneveld, R");
			assertEquals(event.getXmlMarkets().size(), 3);
		}

		// Baseball
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_BASEBALL_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBaseball = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBaseball.size() > 0);
		for (XmlMatch event : resultBaseball) {
			if (event.getName().equals("MLB World Series 2013")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertEquals(market.getXmlBetType().getBetType().toString(), "GANADOR");
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), "Ganador");
					}
				}
			}
		}

		// Soccer
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_SOCCER_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultSoccer = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultSoccer.size() > 0);
		assertEquals(resultSoccer.size(), 10);
		for (XmlMatch event : resultSoccer) {
			if (event.getName().equals("Getafe v Real Zaragoza")) {
				assertEquals(event.getXmlMarkets().size(), 2);
				for (XmlMarket market : event.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().toString().equals("UNO_X_DOS")) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), "1X2");
							if (bet.getXmlMatchParticipant().getName().equals("Getafe")) {
								assertEquals(bet.getXmlBetOdd().getOdds(), "1.80");
							} else if (bet.getXmlMatchParticipant().getName().equals("Real Zaragoza")) {
								assertEquals(bet.getXmlBetOdd().getOdds(), "3.75");
							} else {
								assertEquals(bet.getXmlBetOdd().getOdds(), "3.40");
							}
						}
					}
				}
			}
		}

		// Ganador y maximo goleador
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_DARTS_XML_MAXIMO_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultGanador = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultGanador.size() > 0);
		assertEquals(resultGanador.size(), 1);
		for (XmlMatch event : resultGanador) {
			if (event.getName().equals("Champions League 2012-2013")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.MAXIMO_GOLEADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							assertTrue(bet.getXmlAttribute().getCfgBetTypeId().equals("Maximo_Goleador"));

						}
					}
				}
			}
		}

		// Handicap
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_DARTS_XML_HANDICAP, bookmakerConfiguration, null);
		Collection<XmlMatch> resultHandicap = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(resultHandicap.size(), 1);
		for (XmlMatch event : resultHandicap) {
			for (XmlMatchParticipant participant : event.getXmlMatchParticipants()) {
				if (participant.isAwayParticipant() || participant.isHomeParticipant()) {
					assertTrue(participant.getName().equals("Real Mallorca") || participant.getName().equals("Real Betis"));
				}
			}
			assertTrue(event.getXmlTournament().getName().equals("Football-Spanish-Primera"));
			if (event.getName().equals("Real Mallorca v Real Betis")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetFred.UNO_X_DOS_HANDICAP));
					assertTrue(market.getXmlMarketBets().size() == 3);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertTrue(bet.getXmlAttribute().getCfgBetTypeId().equals("1X2_Handicap"));

					}
				}
			}
		}

		// MasMenos
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_DARTS_XML_MASMENOS, bookmakerConfiguration, null);
		Collection<XmlMatch> resultMasMenos = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(resultMasMenos.size(), 1);
		for (XmlMatch event : resultMasMenos) {
			assertTrue(event.getXmlTournament().getName().equals("Football-Spanish-Primera"));
			for (XmlMatchParticipant participante : event.getXmlMatchParticipants()) {
				assertTrue(participante.getName().equals("Valencia") || participante.getName().equals("Getafe"));
			}
			if (event.getName().equals("Getafe v Valencia")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetFred.MAS_MENOS));
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
						if (dato.getMasMenos().equals(MasMenos.MAS)) {
							assertTrue(dato.getTotalGoal() == 2.5);
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.62"));
						} else {
							assertTrue(dato.getTotalGoal() == 2.5);
							assertTrue(bet.getXmlBetOdd().getOdds().equals("2.20"));
						}
						assertTrue(bet.getXmlAttribute().getCfgBetTypeId().equals("Mas_Menos"));

					}
				}
			}
		}

		// Handicap Asiatico
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_DARTS_XML_HANDICAP_ASIATICO, bookmakerConfiguration, null);
		Collection<XmlMatch> resultHandicapAsiatico = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(resultHandicapAsiatico.size(), 1);
		for (XmlMatch event : resultHandicapAsiatico) {
			assertTrue(event.getXmlTournament().getName().equals("Basketball-NBA"));
			for (XmlMatchParticipant participant : event.getXmlMatchParticipants()) {
				assertTrue(participant.getName().equals("New York Knicks") || participant.getName().equals("Indiana Pacers"));
			}
			if (event.getName().equals("New York Knicks @ Indiana Pacers")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetFred.HANDICAP_ASIATICO));
					assertTrue(market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetFred.PARTIDO_COMPLETO_PRORROGA));
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (dato.getAsianResult().equals(AsianResult.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.91"));
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.91"));
						}
						assertTrue(dato.getFirstValue() == -5.0);
						assertTrue(bet.getXmlAttribute().getCfgBetTypeId().equals("Handicap_Asiatico"));

					}
				}
			}
		}

		// Fecha Bug 3214
		xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_DARTS_XML_FECHA3214, bookmakerConfiguration, null);
		Collection<XmlMatch> resultFecha = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(resultFecha.size(), 1);
		for (XmlMatch event : resultFecha) {
			assertTrue(event.getXmlTournament().getName().equals("Champions League 2012-2013 Top Goalscorer"));

		}

	}

	/**
	 * Bet fred read bad test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betFredReadBadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETFRED_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_BAD_XML_LOCATION, bookmakerConfiguration, null);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size() == 0);
	}

	/**
	 * Bet fred read bug3562.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betFredReadBug3562() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETFRED_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_BUG_3562, bookmakerConfiguration, null);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size() == 1);
		XmlMatch match = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().iterator().next();
		assertTrue(match.getName().equals("San Diego Padres v Chicago Cubs"));
		assertEquals(3, match.getXmlMarkets().size());
		int i = 0;
		int j = 0;
		int k = 0;
		for (XmlMarket market : match.getXmlMarkets()) {
			if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.GANADOR_PARTIDO)) {
				i++;
			} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.HANDICAP_ASIATICO)) {
				j++;
			} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.MAS_MENOS)) {
				k++;
			}
		}
		assertEquals(1, i);
		assertEquals(1, j);
		assertEquals(1, k);
	}

	/**
	 * Bet fred read bug3887.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betFredReadBug3887() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETFRED_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_BUG_3887, bookmakerConfiguration, null);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size() == 1);
		XmlMatch match = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().iterator().next();
		assertEquals(BetEventBetFred.PRIMERA_PARTE, match.getXmlMarkets().iterator().next().getXmlBetType().getXmlBetEvent().getBetEvent());
	}

	/**
	 * Test que verifica que en una apuesta de corto plazo con varias apuestas
	 * resuelve correctamente el home y away.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betFredReadBug4003() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETFRED_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_BUG_4003, bookmakerConfiguration, null);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size());
		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs()) {
			assertEquals("Winnipeg Jets v Los Angeles Kings", match.getName());
			assertEquals("nhl", match.getXmlTournament().getName());
			assertEquals(3, match.getXmlMarkets().size());
			assertEquals(2, match.getXmlMatchParticipants().size());
			for (XmlMatchParticipant matchParticipant : match.getXmlMatchParticipants()) {
				if (matchParticipant.getName().equals("Winnipeg Jets")) {
					assertEquals(true, matchParticipant.isHomeParticipant());
					assertEquals(false, matchParticipant.isAwayParticipant());
				} else if (matchParticipant.getName().equals("Los Angeles Kings")) {
					assertEquals(false, matchParticipant.isHomeParticipant());
					assertEquals(true, matchParticipant.isAwayParticipant());
				}
			}
			for (XmlMarket market : match.getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.GANADOR_PARTIDO)) {
					assertEquals(2, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
						if (atributo.getResult().equals(Result.ONE)) {
							assertEquals("Winnipeg Jets", bet.getXmlMatchParticipant().getName());
							assertEquals(true, bet.getXmlMatchParticipant().isHomeParticipant());
							assertEquals(false, bet.getXmlMatchParticipant().isAwayParticipant());
							assertEquals("1.91", bet.getXmlBetOdd().getOdds());
						} else if (atributo.getResult().equals(Result.TWO)) {
							assertEquals("Los Angeles Kings", bet.getXmlMatchParticipant().getName());
							assertEquals(false, bet.getXmlMatchParticipant().isHomeParticipant());
							assertEquals(true, bet.getXmlMatchParticipant().isAwayParticipant());
							assertEquals("1.91", bet.getXmlBetOdd().getOdds());
						} else {
							fail("Error en los atributos de apuesta.");
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.HANDICAP_ASIATICO)) {
					assertEquals(2, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (atributo.getAsianResult().equals(AsianResult.ONE)) {
							assertEquals("Winnipeg Jets", bet.getXmlMatchParticipant().getName());
							assertEquals(true, bet.getXmlMatchParticipant().isHomeParticipant());
							assertEquals(false, bet.getXmlMatchParticipant().isAwayParticipant());
							assertEquals("1.30", bet.getXmlBetOdd().getOdds());
							assertEquals(new Double(1.50), atributo.getFirstValue());
						} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
							assertEquals("Los Angeles Kings", bet.getXmlMatchParticipant().getName());
							assertEquals(false, bet.getXmlMatchParticipant().isHomeParticipant());
							assertEquals(true, bet.getXmlMatchParticipant().isAwayParticipant());
							assertEquals("3.50", bet.getXmlBetOdd().getOdds());
							assertEquals(new Double(1.50), atributo.getFirstValue());
						} else {
							fail("Error en los atributos de apuesta.");
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.MAS_MENOS)) {
					assertEquals(2, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
						if (atributo.getMasMenos().equals(MasMenos.MAS)) {
							assertEquals("1.95", bet.getXmlBetOdd().getOdds());
							assertEquals(new Double(5.5), atributo.getTotalGoal());
						} else if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
							assertEquals("1.87", bet.getXmlBetOdd().getOdds());
							assertEquals(new Double(5.5), atributo.getTotalGoal());
						} else {
							fail("Error en los atributos de apuesta.");
						}
					}
				} else {
					fail("Error en el mercado.");
				}
			}

		}

	}

	/**
	 * Test que verifica y resuelve el bug 4217.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betFredReadBug4217() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETFRED_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETFREDD_READER, BETFRED_BUG_4217, bookmakerConfiguration, null);
		assertEquals(1, xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size());
		for (XmlMatch match : xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs()) {
			assertEquals("Los Angeles Clippers v New York Knicks", match.getName());
			assertEquals("basketball", match.getXmlTournament().getName());
			assertEquals(1, match.getXmlMarkets().size());
			assertEquals(2, match.getXmlMatchParticipants().size());
			for (XmlMatchParticipant matchParticipant : match.getXmlMatchParticipants()) {
				if (matchParticipant.getName().equals("Los Angeles Clippers")) {
					assertEquals(true, matchParticipant.isHomeParticipant());
					assertEquals(false, matchParticipant.isAwayParticipant());
				} else if (matchParticipant.getName().equals("New York Knicks")) {
					assertEquals(false, matchParticipant.isHomeParticipant());
					assertEquals(true, matchParticipant.isAwayParticipant());
				}
			}
			for (XmlMarket market : match.getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.HANDICAP_ASIATICO)) {
					assertEquals(BetEventBetFred.PRIMERA_PARTE, market.getXmlBetType().getXmlBetEvent().getBetEvent());
					assertEquals(2, market.getXmlMarketBets().size());
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (atributo.getAsianResult().equals(AsianResult.ONE)) {
							assertEquals("Los Angeles Clippers", bet.getXmlMatchParticipant().getName());
							assertEquals(true, bet.getXmlMatchParticipant().isHomeParticipant());
							assertEquals(false, bet.getXmlMatchParticipant().isAwayParticipant());
							assertEquals("1.91", bet.getXmlBetOdd().getOdds());
							assertEquals(new Double(-5.50), atributo.getFirstValue());
						} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
							assertEquals("New York Knicks", bet.getXmlMatchParticipant().getName());
							assertEquals(false, bet.getXmlMatchParticipant().isHomeParticipant());
							assertEquals(true, bet.getXmlMatchParticipant().isAwayParticipant());
							assertEquals("1.91", bet.getXmlBetOdd().getOdds());
							assertEquals(new Double(-5.50), atributo.getFirstValue());
						} else {
							fail("Error en los atributos de apuesta.");
						}
					}
				} else {
					fail("Error en el mercado.");
				}
			}

		}

	}

}
