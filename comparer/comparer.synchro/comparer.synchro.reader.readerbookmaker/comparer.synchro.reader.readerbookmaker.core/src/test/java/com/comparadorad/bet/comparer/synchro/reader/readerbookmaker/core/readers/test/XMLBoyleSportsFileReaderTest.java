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

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBoyleSports;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.boylesports.XMLBoyleSportsFileReader;

/**
 * The Class XMLBoyleSportsFileReaderTest.
 */
public class XMLBoyleSportsFileReaderTest extends AbstractTest {

	/** The boyle sports file reader. */
	@Inject
	private XMLBoyleSportsFileReader boyleSportsFileReader;

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(boyleSportsFileReader.getBookmakerId());
		assertEquals(boyleSportsFileReader.getBookmakerId(),
				CfgBookmakerId.BOYLESPORTS_COM_ID.objectId().toString());
	}

	/**
	 * Boyle sports read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void boyleSportsReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOYLESPORTS_TIMEZONE);

		// Soccer
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOYLESPORTS_READER, BS_XML_LOCATION, bookmakerConfiguration,
				null);
		Collection<XmlMatch> resultSoccer = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultSoccer.size() > 0);
		for (XmlMatch event : resultSoccer) {
			if (event.getName().equals("Premier League 2012/2013")) {
				assertEquals(event.getXmlMarkets().size(), 2);
				for (XmlMarket market : event.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().toString()
							.equals("GANADOR")) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Man City")) {
								assertEquals(bet.getXmlBetOdd().getOdds(),
										"12.00");
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Man United")) {
								assertEquals(bet.getXmlBetOdd().getOdds(),
										"1.04");
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Arsenal")) {
								assertEquals(bet.getXmlBetOdd().getOdds(),
										"301.00");
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea")) {
								assertEquals(bet.getXmlBetOdd().getOdds(),
										"101.00");
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Tottenham")) {
								assertEquals(bet.getXmlBetOdd().getOdds(),
										"251.00");
							}
						}
					}
				}
			}
		}

		// Basketball
		xmlrBetFileReaderResult = readXML(BOYLESPORTS_READER,
				BOYLESPORTS_BASKETBALL_XML_LOCATION, bookmakerConfiguration,
				null);
		Collection<XmlMatch> resultBasketball = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBasketball.size() > 0);
		for (XmlMatch event : resultBasketball) {
			if (event.getName().equals("Trefl Sopot v PGE Turow Zgorzelec")) {
				assertEquals(event.getXmlMarkets().size(), 2);
				for (XmlMatchParticipant participant : event
						.getXmlMatchParticipants()) {
					assertTrue(participant.getName().equals("Trefl Sopot")
							|| participant.getName().equals(
									"PGE Turow Zgorzelec"));
				}
			}
		}

		// Baseball
		xmlrBetFileReaderResult = readXML(BOYLESPORTS_READER,
				BOYLESPORTS_BASEBALL_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBaseball = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBaseball.size() > 0);
		for (XmlMatch event : resultBaseball) {
			if (event.getName().equals("MLB 2013")) {
				assertEquals(event.getXmlMarkets().size(), 3);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertTrue(market.getXmlMarketBets().size() == 30
							|| market.getXmlMarketBets().size() == 15);
				}
			}
		}

		// Tennis Ganador Partido
		xmlrBetFileReaderResult = readXML(BOYLESPORTS_READER,
				BS_XML_LOCATION_GANADOR_PARTIDO_TENNIS, bookmakerConfiguration,
				null);
		Collection<XmlMatch> resultGanadorPartidoTennis = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultGanadorPartidoTennis.size() == 1);
		for (XmlMatch event : resultGanadorPartidoTennis) {
			for (XmlMatchParticipant participante : event
					.getXmlMatchParticipants()) {
				assertTrue(participante.getName().equals("Gilles Simon")
						|| participante.getName().equals("Roger Federer"));
			}
			assertTrue(event.getName().equals("Gilles Simon v Roger Federer"));
			assertEquals(event.getXmlMarkets().size(), 1);
			for (XmlMarket market : event.getXmlMarkets()) {
				assertTrue(market.getXmlBetType().getBetType()
						.equals(BetTypeBoyleSports.GANADOR_PARTIDO));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet
							.getXmlAttribute();
					if (dato.getResult().equals(Result.ONE)) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds()
								.equals("5.00"));
					} else {
						assertTrue(bet.getXmlMarketBetOdd().getOdds()
								.equals("1.17"));
					}
				}
			}
		}

		// Tennis
		xmlrBetFileReaderResult = readXML(BOYLESPORTS_READER,
				BOYLESPORTS_TENNIS_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> resultTennis = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultTennis.size() > 0);
		boolean correcto = false;
		for (XmlMatch event : resultTennis) {
			if (event.getName().equals("Galina Voskoboeva v Roberta Vinci")) {
				for (XmlMarket market : event.getXmlMarkets()) {
					if ((market.getXmlBetType().getBetType()
							.equals(BetTypeBoyleSports.MAS_MENOS))) {
						for (XmlMarketBet xmlBet : market.getXmlMarketBets()) {
							assertNotNull(xmlBet.getXmlMatchParticipant());
							correcto = true;
						}
					}
				}
				assertTrue(event.getXmlMatchParticipants().size() == 2);
				for (XmlMatchParticipant xmlParticipant : event
						.getXmlMatchParticipants()) {
					assertTrue(xmlParticipant.getName().equals(
							"Galina Voskoboeva")
							|| xmlParticipant.getName().equals("Roberta Vinci"));
				}
			}
		}
		assertTrue(correcto);
	}

	/**
	 * Boyle sports bad read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void boyleSportsBadReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOYLESPORTS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOYLESPORTS_READER, BOYLESPORTS_BAD_XML_LOCATION,
				bookmakerConfiguration, null);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size() == 0);
	}

	@Test
	public void boyleSports1X2OnlyReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOYLESPORTS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOYLESPORTS_READER, BS_XML_LOCATION_1X2_ONLY,
				bookmakerConfiguration, null);
		Collection<XmlMatch> resultSoccer = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultSoccer.size() > 0);
		for (XmlMatch event : resultSoccer) {
			if (event.getName().equals("Real Madrid v Atletico Madrid")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertEquals(market.getXmlBetType().getBetType(),
							BetTypeBoyleSports.UNO_X_DOS);
					for (XmlMarketBet xmlBet : market.getXmlMarketBets()) {
						if (xmlBet.getXmlBetOdd().getOdds().equals("3.75")) {
							assertTrue(xmlBet.getXmlMatchParticipant()
									.getName().equals("Atletico Madrid"));
							assertTrue(((Xml1X2Attribute) xmlBet
									.getXmlAttribute()).getResult().equals(
									Result.TWO));
							assertTrue(xmlBet.getXmlMatchParticipant()
									.getName().equals("Atletico Madrid"));
						} else if (xmlBet.getXmlBetOdd().getOdds()
								.equals("1.25")) {
							assertTrue(xmlBet.getXmlMatchParticipant()
									.getName().equals("Real Madrid"));
							assertTrue(((Xml1X2Attribute) xmlBet
									.getXmlAttribute()).getResult().equals(
									Result.ONE));
						} else if (xmlBet.getXmlBetOdd().getOdds()
								.equals("2.25")) {
							assertTrue(((Xml1X2Attribute) xmlBet
									.getXmlAttribute()).getResult().equals(
									Result.DRAW));
						}
					}
				}
			}
		}
	}

	@Test
	public void boyleSportsHandicap1X2OnlyReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BOYLESPORTS_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BOYLESPORTS_READER, BS_XML_LOCATION_HANDICAP_1X2_ONLY,
				bookmakerConfiguration, null);
		Collection<XmlMatch> resultSoccer = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultSoccer.size() > 0);
		for (XmlMatch event : resultSoccer) {
			if (event.getName().equals("Mallorca v Betis")) {
				assertEquals(event.getXmlMarkets().size(), 1);
				for (XmlMarket market : event.getXmlMarkets()) {
					assertEquals(market.getXmlBetType().getBetType(),
							BetTypeBoyleSports.UNO_X_DOS_HANDICAP);
					for (XmlMarketBet xmlBet : market.getXmlMarketBets()) {
						if (xmlBet.getXmlBetOdd().getOdds().equals("1.14")) {
							assertTrue(xmlBet.getXmlMatchParticipant()
									.getName().equals("Betis"));
							assertTrue(((Xml1X2HandicapAttribute) xmlBet
									.getXmlAttribute()).getResult().equals(
									Result.TWO));
							assertTrue(((Xml1X2HandicapAttribute) xmlBet
									.getXmlAttribute()).getFirstValue().equals(
									-1.0d));
						} else if (xmlBet.getXmlBetOdd().getOdds()
								.equals("5.50")) {
							assertTrue(xmlBet.getXmlMatchParticipant()
									.getName().equals("Mallorca"));
							assertTrue(((Xml1X2HandicapAttribute) xmlBet
									.getXmlAttribute()).getResult().equals(
									Result.ONE));
							assertTrue(((Xml1X2HandicapAttribute) xmlBet
									.getXmlAttribute()).getFirstValue().equals(
									-1.0d));
						} else if (xmlBet.getXmlBetOdd().getOdds()
								.equals("3.50")) {
							assertTrue(((Xml1X2HandicapAttribute) xmlBet
									.getXmlAttribute()).getResult().equals(
									Result.DRAW));
							assertTrue(((Xml1X2HandicapAttribute) xmlBet
									.getXmlAttribute()).getFirstValue().equals(
									-1.0d));
						}
						assertTrue(((Xml1X2HandicapAttribute) xmlBet
								.getXmlAttribute()).getFirstValue().equals(-1d));
					}
				}
			}
		}
	}
}
