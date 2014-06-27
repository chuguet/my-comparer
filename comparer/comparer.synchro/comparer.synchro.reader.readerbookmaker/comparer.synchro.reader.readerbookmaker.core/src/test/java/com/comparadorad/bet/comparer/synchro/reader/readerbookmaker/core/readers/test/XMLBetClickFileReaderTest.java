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
import static org.junit.Assert.fail;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betclick.XMLBetClickFileReader;

/**
 * The Class XMLBetClickFileReaderTest.
 */
public class XMLBetClickFileReaderTest extends AbstractTest {

	/** The bet click reader. */
	@Inject
	private XMLBetClickFileReader betClickReader;

	private static final String BETCLICK_TIMEZONE = "GMT+0";

	/** The Constant XML_LOCATION. */
	private static final String BC_XML_LOCATION_SHORT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick4.xml";

	/** The Constant XML_LOCATION. */
	private static final String BETCLICK_COMPLETO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_completo.xml";

	/** The Constant BETCLICK_BAD_XML_LOCATION. */
	private static final String BETCLICK_BAD_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_badXml.xml";

	/** The Constant XML_LOCATION. */
	private static final String BC_XML_LOCATION_FECHA_LP = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_FechaLargoPlazo.xml";

	private static final String HANDICAP_ASIATICO_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_handicap_asiatico.xml";

	private static final String UNO_X_DOS_HANDICAP_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_handicap_1x2.xml";

	private static final String UNO_X_DOS_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_1x2.xml";

	private static final String GANADOR_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_ganador.xml";

	private static final String GANADOR_DE_PARTIDO_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_ganador_de_partido.xml";

	private static final String BUG_3374_HANDICAP_ASIATICO_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_bug3374.xml";

	private static final String MAS_MENOS_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_mas_menos.xml";

	private static final String MAS_MENOS_SEVERAL_BETS_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_mas_menos_severalBets.xml";

	private static final String WINNER_OVERTIME_BYSPORT_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_overtime_bysport.xml";
	
	private static final String TENNIS_TEST_FILE_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick_tennis.xml";

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(betClickReader.getBookmakerId());
		assertEquals(betClickReader.getBookmakerId(),
				CfgBookmakerId.BETCLIC_COM_ID.objectId().toString());
	}

	/**
	 * Bet click read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betClickReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, BC_XML_LOCATION_SHORT, bookmakerConfiguration,
				null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch match : result) {
			if (match.getName().equals("Manchester United - Aston Villa")) {
				assertEquals(match.getXmlMarkets().size(), 3);
				assertEquals(match.getLiveId(), "68282");
			} else if (match.getName().equals("Manchester City - West Ham")) {
				assertEquals(match.getXmlMarkets().size(), 2);
				assertEquals(match.getLiveId(), "");
			}
		}
	}

	/**
	 * Bet click read big test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betClickReadBigTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, BETCLICK_COMPLETO, bookmakerConfiguration,
				null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch match : result) {
			if (match.getName().equals("Arsenal - Manchester United")) {
				assertEquals(8, match.getXmlMarkets().size());
				assertEquals(match.getLiveId(), "");
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent() != null
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetClick.PARTIDO_COMPLETO)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							assertEquals(bet.getXmlAttribute()
									.getCfgBetTypeId(), "1X2");
							assertTrue(bet.getXmlBetOdd().getOdds().toString()
									.equals("2.15")
									|| bet.getXmlBetOdd().getOdds().toString()
											.equals("3.40")
									|| bet.getXmlBetOdd().getOdds().toString()
											.equals("3.20"));
						}
					}
				}
			} else if (match.getName().equals("Manchester City - West Ham")) {
				assertEquals(9, match.getXmlMarkets().size());
				assertEquals(match.getLiveId(), "");
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent() != null
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetClick.PRIMERA_PARTE)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							assertEquals(bet.getXmlAttribute()
									.getCfgBetTypeId(), "1X2");
							assertTrue(bet.getXmlBetOdd().getOdds().toString()
									.equals("1.60")
									|| bet.getXmlBetOdd().getOdds().toString()
											.equals("2.60")
									|| bet.getXmlBetOdd().getOdds().toString()
											.equals("8.50"));
						}
					}
				}
			}
		}
	}

	@Test
	public void betClickOvertimeBySport() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, WINNER_OVERTIME_BYSPORT_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() > 0);
		for (XmlMatch match : result) {
			if (match.getName().equals("Ana Ivanovic - Petkovic, Andrea")) {
				assertEquals(1, match.getXmlMarkets().size());
				assertEquals(match.getLiveId(), "");
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent() != null
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetClick.PARTIDO_COMPLETO)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							assertEquals(bet.getXmlAttribute()
									.getCfgBetTypeId(),
									CfgBetTypeId.GANADOR_PARTIDO.nameId());
							assertTrue(bet.getXmlBetOdd().getOdds().toString()
									.equals("1.35")
									|| bet.getXmlBetOdd().getOdds().toString()
											.equals("2.90"));
						}
					}
				}
			} else if (match.getName().equals("Miami Heat - Milwaukee Bucks")) {
				assertEquals(4, match.getXmlMarkets().size());
				assertEquals(match.getLiveId(), "");
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent() != null) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlAttribute()
									.getCfgBetTypeId()
									.equals(CfgBetTypeId.GANADOR_PARTIDO
											.nameId())
									|| bet.getXmlAttribute()
											.getCfgBetTypeId()
											.equals(CfgBetTypeId.HANDICAP_ASIATICO
													.nameId())
									|| bet.getXmlAttribute()
											.getCfgBetTypeId()
											.equals(CfgBetTypeId.MAS_MENOS
													.nameId())) {
								assertEquals(
										market.getXmlBetType().getXmlBetEvent()
												.getBetEvent(),
										BetEventBetClick.PARTIDO_COMPLETO_PRORROGA);
							} else if (bet
									.getXmlAttribute()
									.getCfgBetTypeId()
									.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP
											.nameId())
									|| bet.getXmlAttribute()
											.getCfgBetTypeId()
											.equals(CfgBetTypeId.UNO_X_DOS
													.nameId())) {
								assertEquals(market.getXmlBetType()
										.getXmlBetEvent().getBetEvent(),
										BetEventBetClick.PARTIDO_COMPLETO);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Bet click read bad test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betClickReadBadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, BETCLICK_BAD_XML_LOCATION,
				bookmakerConfiguration, null);
		assertTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size() == 0);
	}

	@Test
	public void betClickReadFechaLPTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, BC_XML_LOCATION_FECHA_LP,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(result.size() == 1);
		for (XmlMatch match : result) {
			if (match.getName().equals("Champions League 2012-2013")) {
				assertEquals(match.getXmlMarkets().size(), 1);
			}
		}
	}

	@Test
	public void handicapAsiaticoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, HANDICAP_ASIATICO_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("Philadelphia Eagles - Carolina Panthers",
					match.getName());
			assertNotNull(match.getXmlTournament());
			assertEquals("NFL", match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());
			assertEquals("American Football", match.getXmlTournament()
					.getXmlSport().getName());
			assertNotNull(match.getXmlMatchParticipants());
			assertEquals(2, match.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : match
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
				assertTrue(participant.getName().equalsIgnoreCase(
						"Philadelphia Eagles")
						|| participant.getName().equalsIgnoreCase(
								"Carolina Panthers"));
				if (participant.getName().equalsIgnoreCase(
						"Philadelphia Eagles")) {
					assertTrue(participant.isHomeParticipant());
					assertFalse(participant.isAwayParticipant());
				}
				if (participant.getName().equalsIgnoreCase("Carolina Panthers")) {
					assertFalse(participant.isHomeParticipant());
					assertTrue(participant.isAwayParticipant());
				}
			}
			assertNotNull(match.getXmlMarkets());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(2, market.getXmlMarketBets().size());

				boolean one = false;
				boolean two = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlAsianHandicapAttribute);
					XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
							.getXmlAttribute();
					AsianResult asianResult = attr.getAsianResult();
					if (asianResult.getNameId().equals(Result.ONE.getNameId())) {
						one = true;
						assertEquals(new Double(2.5), attr.getFirstValue());
						assertEquals("1.95", bet.getXmlMarketBetOdd().getOdds()); // 110
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Philadelphia Eagles", bet
								.getXmlMatchParticipant().getName());
					} else if (asianResult.getNameId().equals(
							Result.TWO.getNameId())) {
						two = true;
						assertEquals(new Double(2.5), attr.getFirstValue());
						assertEquals("1.75", bet.getXmlMarketBetOdd().getOdds()); // -130
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Carolina Panthers", bet
								.getXmlMatchParticipant().getName());
					}
				}
				assertTrue(one && two);

			}
		}
	}

	@Test
	public void masMenosSmallTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, MAS_MENOS_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("Philadelphia Eagles - Carolina Panthers",
					match.getName());
			assertNotNull(match.getXmlMarkets());
			assertEquals(2, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.MAS_MENOS.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(2, market.getXmlMarketBets().size());

				boolean mas = false;
				boolean menos = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlMoreLessAttribute);
					XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
							.getXmlAttribute();
					MasMenos masMenos = attr.getMasMenos();
					assertEquals(String.valueOf(40.5), attr.getTotalGoal()
							.toString());
					if (masMenos.getNameId().equals(MasMenos.MAS.getNameId())) {
						mas = true;
						assertEquals("1.85", bet.getXmlMarketBetOdd().getOdds());
					} else if (attr.getMasMenos().nameId()
							.equals(MasMenos.MENOS.getNameId())) {
						menos = true;
						assertEquals("1.85", bet.getXmlMarketBetOdd().getOdds());
					}
				}
				assertTrue(mas && menos);
			}
		}
	}

	/**
	 * Comprueba una apuesta de tipo mas menos con varias apuestas de tipo mas
	 * menos en el mismo mercado y desoclocadas
	 * 
	 * @throws Exception
	 */
	@Test
	public void masMenosSeveralBetsTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, MAS_MENOS_SEVERAL_BETS_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("Philadelphia Eagles - Carolina Panthers",
					match.getName());
			assertNotNull(match.getXmlMarkets());
			assertEquals(7, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.MAS_MENOS.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(2, market.getXmlMarketBets().size());

				boolean mas = false;
				boolean menos = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlMoreLessAttribute);
					XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
							.getXmlAttribute();
					if (attr.getTotalGoal() == 0.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("1.01", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("11.00", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					} else if (attr.getTotalGoal() == 1.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("1.12", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("5.25", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					} else if (attr.getTotalGoal() == 2.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("1.52", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("2.35", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					} else if (attr.getTotalGoal() == 3.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("2.40", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("1.50", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					} else if (attr.getTotalGoal() == 4.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("4.25", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("1.18", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					} else if (attr.getTotalGoal() == 5.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("8.50", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("1.04", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					} else if (attr.getTotalGoal() == 6.5) {
						MasMenos masMenos = attr.getMasMenos();
						if (masMenos.getNameId().equals(
								MasMenos.MAS.getNameId())) {
							mas = true;
							assertEquals("11.00", bet.getXmlMarketBetOdd()
									.getOdds());
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							menos = true;
							assertEquals("1.01", bet.getXmlMarketBetOdd()
									.getOdds());
						}
					}
				}
				assertTrue(mas && menos);
			}
		}
	}

	@Test
	public void bug3374handicapAsiaticoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, BUG_3374_HANDICAP_ASIATICO_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("Indiana Fever - Connecticut Sun", match.getName());
			assertNotNull(match.getXmlTournament());
			assertEquals("WNBA", match.getXmlTournament().getName());
			assertNotNull(match.getXmlTournament().getXmlSport());
			assertEquals("American Football", match.getXmlTournament()
					.getXmlSport().getName());
			assertNotNull(match.getXmlMatchParticipants());
			assertEquals(2, match.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : match
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
				assertTrue(participant.getName().equalsIgnoreCase(
						"Indiana Fever")
						|| participant.getName().equalsIgnoreCase(
								"Connecticut Sun"));
				if (participant.getName().equalsIgnoreCase("Indiana Fever")) {
					assertTrue(participant.isHomeParticipant());
					assertFalse(participant.isAwayParticipant());
				}
				if (participant.getName().equalsIgnoreCase("Connecticut Sun")) {
					assertFalse(participant.isHomeParticipant());
					assertTrue(participant.isAwayParticipant());
				}
			}
			assertNotNull(match.getXmlMarkets());
			assertEquals(3, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				IBetType betType = market.getXmlBetType().getBetType();

				assertTrue(betType.getId().equals(
						CfgBetTypeId.MAS_MENOS.nameId())
						|| betType.getId().equals(
								CfgBetTypeId.GANADOR_PARTIDO.nameId())
						|| betType.getId().equals(
								CfgBetTypeId.HANDICAP_ASIATICO.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(2, market.getXmlMarketBets().size());

				if (betType.getId().equals(
						CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
					boolean one = false;
					boolean two = false;
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertNotNull(bet.getXmlMarketBetOdd());
						assertNotNull(bet.getXmlMarketBetOdd().getOdds());

						assertNotNull(bet.getXmlAttribute());
						assertTrue(bet.getXmlAttribute() instanceof XmlAsianHandicapAttribute);
						XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
								.getXmlAttribute();
						AsianResult asianResult = attr.getAsianResult();
						if (asianResult.getNameId().equals(
								Result.ONE.getNameId())) {
							one = true;
							assertEquals(new Double(-4.5), attr.getFirstValue());
							assertEquals("1.88", bet.getXmlMarketBetOdd()
									.getOdds()); // 110
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Indiana Fever", bet
									.getXmlMatchParticipant().getName());
						} else if (asianResult.getNameId().equals(
								Result.TWO.getNameId())) {
							two = true;
							assertEquals(new Double(-4.5), attr.getFirstValue());
							assertEquals("1.88", bet.getXmlMarketBetOdd()
									.getOdds()); // -130
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Connecticut Sun", bet
									.getXmlMatchParticipant().getName());
						}
					}
					assertTrue(one && two);
				}

			}
		}
	}

	@Test
	public void UnoXDoshandicapSmallTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, UNO_X_DOS_HANDICAP_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("Florida Panthers - New York Rangers", match.getName());
			assertNotNull(match.getXmlMarkets());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(3, market.getXmlMarketBets().size());

				boolean one = false;
				boolean two = false;
				boolean draw = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof Xml1X2HandicapAttribute);
					Xml1X2HandicapAttribute attr = (Xml1X2HandicapAttribute) bet
							.getXmlAttribute();
					Result unoXDosResult = attr.getResult();
					if (unoXDosResult.getNameId()
							.equals(Result.ONE.getNameId())) {
						one = true;
						assertEquals(new Double(1.5), attr.getFirstValue());
						assertEquals("1.65", bet.getXmlMarketBetOdd().getOdds());
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Florida Panthers", bet
								.getXmlMatchParticipant().getName());
					} else if (unoXDosResult.getNameId().equals(
							Result.TWO.getNameId())) {
						two = true;
						assertEquals(new Double(1.5), attr.getFirstValue());
						assertEquals("2.10", bet.getXmlMarketBetOdd().getOdds());
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("New York Rangers", bet
								.getXmlMatchParticipant().getName());
					} else if (unoXDosResult.getNameId().equals(
							Result.DRAW.getNameId())) {
						draw = true;
						assertEquals(new Double(1.5), attr.getFirstValue());
						assertEquals("1.10", bet.getXmlMarketBetOdd().getOdds());
					}
				}
				assertTrue(one && two && draw);
			}
		}
	}

	@Test
	public void unoXDosSmallTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, UNO_X_DOS_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("New Jersey Devils - Montreal Canadiens",
					match.getName());
			assertNotNull(match.getXmlMarkets());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.UNO_X_DOS.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(3, market.getXmlMarketBets().size());

				boolean one = false;
				boolean two = false;
				boolean draw = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof Xml1X2Attribute);
					Xml1X2Attribute attr = (Xml1X2Attribute) bet
							.getXmlAttribute();
					Result unoXDosResult = attr.getResult();
					if (unoXDosResult.getNameId()
							.equals(Result.ONE.getNameId())) {
						one = true;
						assertEquals("2.65", bet.getXmlMarketBetOdd().getOdds());
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("New Jersey Devils", bet
								.getXmlMatchParticipant().getName());
					} else if (unoXDosResult.getNameId().equals(
							Result.TWO.getNameId())) {
						two = true;
						assertEquals("2.25", bet.getXmlMarketBetOdd().getOdds());
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Montreal Canadiens", bet
								.getXmlMatchParticipant().getName());
					} else if (unoXDosResult.getNameId().equals(
							Result.DRAW.getNameId())) {
						draw = true;
						assertEquals("3.80", bet.getXmlMarketBetOdd().getOdds());
					}
				}
				assertTrue(one && two && draw);
			}
		}
	}

	@Test
	public void ganadorDePartidoSmallTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, GANADOR_DE_PARTIDO_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("New Jersey Devils - Montreal Canadiens",
					match.getName());
			assertNotNull(match.getXmlMarkets());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(2, market.getXmlMarketBets().size());

				boolean one = false;
				boolean two = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlMatchWinnerAttribute);
					XmlMatchWinnerAttribute attr = (XmlMatchWinnerAttribute) bet
							.getXmlAttribute();
					Result ganadorPartidoResult = attr.getResult();
					if (ganadorPartidoResult.getNameId().equals(
							Result.ONE.getNameId())) {
						one = true;
						assertEquals("2.00", bet.getXmlMarketBetOdd().getOdds());
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("New Jersey Devils", bet
								.getXmlMatchParticipant().getName());
					} else if (ganadorPartidoResult.getNameId().equals(
							Result.TWO.getNameId())) {
						two = true;
						assertEquals("1.72", bet.getXmlMarketBetOdd().getOdds());
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Montreal Canadiens", bet
								.getXmlMatchParticipant().getName());
					}
				}
				assertTrue(one && two);
			}
		}
	}

	@Test
	public void ganadorSmallTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, GANADOR_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertNotNull(result);
		assertEquals(1, result.size());
		for (XmlMatch match : result) {
			assertEquals("ECB 40 League 2013", match.getName());
			assertNotNull(match.getXmlMarkets());
			assertEquals(1, match.getXmlMarkets().size());
			for (XmlMarket market : match.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				assertTrue(market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.GANADOR.nameId()));

				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertEquals(21, market.getXmlMarketBets().size());

				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());

					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlWinnerAttribute);
					XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
							.getXmlAttribute();
					assertNotNull(bet.getXmlMatchParticipant());
					assertEquals(bet.getXmlMatchParticipant().getName(), attr
							.getWinner().getName());
				}
			}
		}
	}
	
	@Test
	public void betclickTennisTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETCLICK_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETCLICK_READER, TENNIS_TEST_FILE_LOCATION,
				bookmakerConfiguration, null);
		
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
				
		assertEquals(2, result.size());

		for (XmlMatch match : result) {
			// Test evento corto plazo
			if (match.getXmlTournament().getName().equals("French Open M.")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					assertNotNull(market.getXmlBetType());
					assertNotNull(market.getXmlBetType().getBetType());
					assertTrue(market.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.GANADOR.nameId()));

					assertNotNull(market.getXmlBetType().getXmlBetEvent());
					assertNotNull(market.getXmlMarketBets());
					assertEquals(5, market.getXmlMarketBets().size());

					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertNotNull(bet.getXmlMarketBetOdd());
						assertNotNull(bet.getXmlMarketBetOdd().getOdds());

						assertNotNull(bet.getXmlAttribute());
						assertTrue(bet.getXmlAttribute() instanceof XmlWinnerAttribute);
						XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
								.getXmlAttribute();
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals(bet.getXmlMatchParticipant().getName(),
								attr.getWinner().getName());
					}
				}

			} else if (match.getXmlTournament().getName().equals("Dubai ATP")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					assertNotNull(market.getXmlBetType());
					assertNotNull(market.getXmlBetType().getBetType());
					assertTrue(market.getXmlBetType().getBetType().getId()
							.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId()));

					assertNotNull(market.getXmlBetType().getXmlBetEvent());
					assertNotNull(market.getXmlMarketBets());
					assertEquals(2, market.getXmlMarketBets().size());

					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertNotNull(bet.getXmlMarketBetOdd());
						assertNotNull(bet.getXmlMarketBetOdd().getOdds());

						assertNotNull(bet.getXmlAttribute());
						assertTrue(bet.getXmlAttribute() instanceof XmlMatchWinnerAttribute);
						XmlMatchWinnerAttribute attr = (XmlMatchWinnerAttribute) bet
								.getXmlAttribute();
						Result ganadorPartidoResult = attr.getResult();
						if (ganadorPartidoResult.getNameId().equals(
								Result.ONE.getNameId())) {
							assertEquals("1.03", bet.getXmlMarketBetOdd()
									.getOdds());
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Roger Federer", bet
									.getXmlMatchParticipant().getName());
						} else if (ganadorPartidoResult.getNameId().equals(
								Result.TWO.getNameId())) {
							assertEquals("11.00", bet.getXmlMarketBetOdd()
									.getOdds());
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Benjamin Becker", bet
									.getXmlMatchParticipant().getName());
						}
					}
				}
			} else {
				fail("No se han leido correctamente las competiciones");
			}
			
		}

	}

}
