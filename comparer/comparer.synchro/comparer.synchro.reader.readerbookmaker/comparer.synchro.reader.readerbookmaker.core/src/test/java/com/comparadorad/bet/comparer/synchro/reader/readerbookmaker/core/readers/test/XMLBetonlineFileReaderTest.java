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

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline.XMLBetonlineFileReader;

/**
 * The Class XMLBetonlineFileReaderTest.
 */
public class XMLBetonlineFileReaderTest extends AbstractTest {

	/** The Constant BETONLINE_TIMEZONE. */
	protected static final String BETONLINE_TIMEZONE = "GMT+0";

	/** The Constant TEST_LOCATION_1. */
	protected static final String TEST_LOCATION_1 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\soccer1X2MasMenosHandicapAsiatico.xml";

	/** The Constant TEST_LOCATION_2. */
	protected static final String TEST_LOCATION_2 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\tennisGanadorPartido.xml";

	/** The Constant TEST_LOCATION_3. */
	protected static final String TEST_LOCATION_3 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\basketballNoMatchWinnerOr1X2.xml";

	/** The Constant TEST_LOCATION_4. */
	protected static final String TEST_LOCATION_4 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\americanFootballFullSize.xml";

	/** The Constant TEST_LOCATION_5. */
	protected static final String TEST_LOCATION_5 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\hockeyInvalidXml.xml";

	/** The Constant TEST_LOCATION_6. */
	protected static final String TEST_LOCATION_6 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\parseDateException.xml";

	/** The Constant TEST_LOCATION_7. */
	protected static final String TEST_LOCATION_7 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\noData.xml";
	
	/** The Constant TEST_LOCATION_8. */
	protected static final String TEST_LOCATION_8 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betonline\\FootballOverUnder.xml";

	/** The betonline reader. */
	@Inject
	private XMLBetonlineFileReader betonlineReader;

	/**
	 * American futball full size test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void americanFutballFullSizeTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETONLINE_READER, TEST_LOCATION_4, bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(60, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			assertNotNull(xmlMatch.getStartDate());
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertTrue(xmlMatch.getXmlTournament().getName()
					.equalsIgnoreCase("NCAA")
					|| xmlMatch.getXmlTournament().getName()
							.equalsIgnoreCase("NFL"));
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("American Football", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			// TournamentEvent
			assertNotNull(xmlMatch.getXmlTournamentEvent());
			assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(2, xmlMatch.getXmlMatchParticipants().size());

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			
			for(XmlMarket market : xmlMatch.getXmlMarkets()){
				IBetType betType = market.getXmlBetType().getBetType();
				if (betType.getId().equals(CfgBetTypeId.UNO_X_DOS.nameId())
					|| betType.getId().equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())){
					
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
							market.getXmlBetType().getXmlBetEvent().getBetEvent()
									.getId());		
				}else{
					assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId(),
							market.getXmlBetType().getXmlBetEvent().getBetEvent()
									.getId());		
				}	
			}
		}
	}

	/**
	 * Basketball no match winner or1 x2 test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void basketballNoMatchWinnerOr1X2Test() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETONLINE_READER, TEST_LOCATION_3, bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(xmlMatchs.size(), 1);
		for (XmlMatch xmlMatch : xmlMatchs) {
			assertNotNull(xmlMatch.getStartDate());
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("NBA", xmlMatch.getXmlTournament().getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Basketball", xmlMatch.getXmlTournament()
					.getXmlSport().getName());
			// TournamentEvent
			assertNotNull(xmlMatch.getXmlTournamentEvent());
			assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(2, xmlMatch.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : xmlMatch
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
				assertTrue(participant.getName().equalsIgnoreCase(
						"Indiana Pacers")
						|| participant.getName().equalsIgnoreCase("Miami Heat"));
				if (participant.getName().equalsIgnoreCase("Indiana Pacers")) {
					assertTrue(participant.isAwayParticipant());
					assertFalse(participant.isHomeParticipant());
				}
				if (participant.getName().equalsIgnoreCase("Miami Heat")) {
					assertTrue(participant.isHomeParticipant());
					assertFalse(participant.isAwayParticipant());
				}
			}

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			assertEquals(2, xmlMatch.getXmlMarkets().size());
			for (XmlMarket market : xmlMatch.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				IBetType betType = market.getXmlBetType().getBetType();
				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertEquals(CfgBetTypeEventId.TERCER_CUARTO.nameId(), market
						.getXmlBetType().getXmlBetEvent().getBetEvent().getId());
				assertNotNull(market.getXmlMarketBets());
				assertTrue(betType.getId().equals(
						CfgBetTypeId.MAS_MENOS.nameId())
						|| betType.getId().equals(
								CfgBetTypeId.HANDICAP_ASIATICO.nameId()));
				assertFalse(betType.getId().equals(
						CfgBetTypeId.UNO_X_DOS.nameId())
						|| betType.getId().equals(
								CfgBetTypeId.GANADOR_PARTIDO.nameId()));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
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
		assertNotNull(betonlineReader.getBookmakerId());
		assertEquals(betonlineReader.getBookmakerId(),
				CfgBookmakerId.BETONLINE_COM_ID.objectId().toString());
	}

	/**
	 * Hockey invalid xml test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void hockeyInvalidXmlTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETONLINE_READER, TEST_LOCATION_5, bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(0, xmlMatchs.size());
	}

	/**
	 * No data in xml test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void noDataInXmlTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult;
		xmlrBetFileReaderResult = readXML(BETONLINE_READER, TEST_LOCATION_7,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(0, xmlMatchs.size());
	}

	/**
	 * Parses the date exception test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void parseDateExceptionTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult;
		xmlrBetFileReaderResult = readXML(BETONLINE_READER, TEST_LOCATION_6,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(0, xmlMatchs.size());
	}

	/**
	 * Soccer1 x2 mas menos handicap asiatico test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void soccer1X2MasMenosHandicapAsiaticoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETONLINE_READER, TEST_LOCATION_1, bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(xmlMatchs.size(), 1);
		for (XmlMatch xmlMatch : xmlMatchs) {
			assertNotNull(xmlMatch.getStartDate());
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("FIFA - Confederations Cup 2013", xmlMatch
					.getXmlTournament().getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Football", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			// TournamentEvent
			assertNotNull(xmlMatch.getXmlTournamentEvent());
			assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(2, xmlMatch.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : xmlMatch
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
				assertTrue(participant.getName().equalsIgnoreCase("Brazil")
						|| participant.getName().equalsIgnoreCase("Japan"));
				if (participant.getName().equalsIgnoreCase("Brazil")) {
					assertTrue(participant.isAwayParticipant());
					assertFalse(participant.isHomeParticipant());
				}
				if (participant.getName().equalsIgnoreCase("Japan")) {
					assertTrue(participant.isHomeParticipant());
					assertFalse(participant.isAwayParticipant());
				}
			}

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			assertEquals(3, xmlMatch.getXmlMarkets().size());
			for (XmlMarket market : xmlMatch.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				IBetType betType = market.getXmlBetType().getBetType();
				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
						market.getXmlBetType().getXmlBetEvent().getBetEvent()
								.getId());
				assertNotNull(market.getXmlMarketBets());
				assertTrue(betType.getId().equals(
						CfgBetTypeId.MAS_MENOS.nameId())
						|| betType.getId().equals(
								CfgBetTypeId.UNO_X_DOS.nameId())
						|| betType.getId().equals(
								CfgBetTypeId.HANDICAP_ASIATICO.nameId()));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
				}

				if (betType.getId().equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
					boolean one = false;
					boolean two = false;
					boolean draw = false;
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertTrue(bet.getXmlAttribute() instanceof Xml1X2Attribute);
						Xml1X2Attribute attr = (Xml1X2Attribute) bet
								.getXmlAttribute();
						Result result = attr.getResult();
						if (result.getNameId().equals(Result.ONE.getNameId())) {
							one = true;
							assertEquals("10.50", bet.getXmlMarketBetOdd()
									.getOdds()); // 950
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Japan", bet.getXmlMatchParticipant()
									.getName());
						} else if (result.getNameId().equals(
								Result.TWO.getNameId())) {
							two = true;
							assertEquals("1.25", bet.getXmlMarketBetOdd()
									.getOdds()); // -400
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Brazil", bet.getXmlMatchParticipant()
									.getName());
						} else if (result.getNameId().equals(
								Result.DRAW.getNameId())) {
							draw = true;
							assertEquals("5.40", bet.getXmlMarketBetOdd()
									.getOdds()); // 440
						}
					}
					assertTrue(one && two && draw);

				} else if (betType.getId().equals(
						CfgBetTypeId.MAS_MENOS.nameId())) {
					boolean over = false;
					boolean under = false;
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertTrue(bet.getXmlAttribute() instanceof XmlMoreLessAttribute);
						XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
								.getXmlAttribute();
						assertEquals(String.valueOf(3.0), attr.getTotalGoal().toString());
						if (attr.getMasMenos().nameId()
								.equals(MasMenos.MAS.getNameId())) {
							over = true;
							assertEquals("1.94", bet.getXmlMarketBetOdd()
									.getOdds()); // -106
						} else if (attr.getMasMenos().nameId()
								.equals(MasMenos.MENOS.getNameId())) {
							under = true;
							assertEquals("1.88", bet.getXmlMarketBetOdd()
									.getOdds()); // -114
						}
					}
					assertTrue(over && under);

				} else if (betType.getId().equals(
						CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
					boolean one = false;
					boolean two = false;
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						assertTrue(bet.getXmlAttribute() instanceof XmlAsianHandicapAttribute);
						XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
								.getXmlAttribute();
						AsianResult result = attr.getAsianResult();
						if (result.getNameId().equals(Result.ONE.getNameId())) {
							one = true;
							assertEquals(new Double(1.5), attr.getFirstValue());
							assertEquals("2.10", bet.getXmlMarketBetOdd()
									.getOdds()); // 110
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Japan", bet.getXmlMatchParticipant()
									.getName());
						} else if (result.getNameId().equals(
								Result.TWO.getNameId())) {
							two = true;
							assertEquals(new Double(1.5), attr.getFirstValue());
							assertEquals("1.77", bet.getXmlMarketBetOdd()
									.getOdds()); // -130
							assertNotNull(bet.getXmlMatchParticipant());
							assertEquals("Brazil", bet.getXmlMatchParticipant()
									.getName());
						}
					}
					assertTrue(one && two);
				}
			}

		}
	}

	/**
	 * Tennis ganador partido test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void tennisGanadorPartidoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETONLINE_READER, TEST_LOCATION_2, bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(xmlMatchs.size(), 1);
		for (XmlMatch xmlMatch : xmlMatchs) {
			assertNotNull(xmlMatch.getStartDate());
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("WTA - French Open - R16", xmlMatch.getXmlTournament()
					.getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Tennis", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			// TournamentEvent
			assertNotNull(xmlMatch.getXmlTournamentEvent());
			assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(2, xmlMatch.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : xmlMatch
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
				assertTrue(participant.getName().equalsIgnoreCase(
						"Sloane Stephens")
						|| participant.getName().equalsIgnoreCase(
								"Maria Sharapova"));
				if (participant.getName().equalsIgnoreCase("Sloane Stephens")) {
					assertTrue(participant.isAwayParticipant());
					assertFalse(participant.isHomeParticipant());
				}
				if (participant.getName().equalsIgnoreCase("Maria Sharapova")) {
					assertTrue(participant.isHomeParticipant());
					assertFalse(participant.isAwayParticipant());
				}
			}

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			assertEquals(1, xmlMatch.getXmlMarkets().size());
			for (XmlMarket market : xmlMatch.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				IBetType betType = market.getXmlBetType().getBetType();
				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertEquals(CfgBetTypeEventId.PRIMER_SET.nameId(), market
						.getXmlBetType().getXmlBetEvent().getBetEvent().getId());
				assertNotNull(market.getXmlMarketBets());
				assertTrue(betType.getId().equals(
						CfgBetTypeId.GANADOR_PARTIDO.nameId()));

				boolean one = false;
				boolean two = false;

				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlMatchWinnerAttribute);
					XmlMatchWinnerAttribute attr = (XmlMatchWinnerAttribute) bet
							.getXmlAttribute();
					Result result = attr.getResult();
					if (result.getNameId().equals(Result.ONE.getNameId())) {
						one = true;
						assertEquals("1.17", bet.getXmlMarketBetOdd().getOdds()); // -590
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Maria Sharapova", bet
								.getXmlMatchParticipant().getName());
					} else if (result.getNameId()
							.equals(Result.TWO.getNameId())) {
						two = true;
						assertEquals("5.75", bet.getXmlMarketBetOdd().getOdds()); // 475
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Sloane Stephens", bet
								.getXmlMatchParticipant().getName());
					}
				}
				assertTrue(one && two);
			}

		}
	}
	
	
	/**
	 * American football over under test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void americanFootballOverUnderTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETONLINE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETONLINE_READER, TEST_LOCATION_8, bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			assertNotNull(xmlMatch.getStartDate());
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertTrue(xmlMatch.getXmlTournament().getName()
							.equalsIgnoreCase("NFL"));
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("American Football", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			// TournamentEvent
			assertNotNull(xmlMatch.getXmlTournamentEvent());
			assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			assertFalse(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(2, xmlMatch.getXmlMatchParticipants().size());

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			
			for(XmlMarket market : xmlMatch.getXmlMarkets()){
				IBetType betType = market.getXmlBetType().getBetType();
					assertEquals(CfgBetTypeEventId.CUARTO_CUARTO.nameId(),
							market.getXmlBetType().getXmlBetEvent().getBetEvent()
									.getId());		
			}
		}
	}

}
