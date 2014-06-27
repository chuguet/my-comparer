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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle.XMLPinnacleSportsFileReader;

/**
 * The Class XMLPinnacleSportsFileReaderTest.
 */
public class XMLPinnacleSportsFileReaderTest extends AbstractTest {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

	/** The Constant PINNACLE_BAD_XML_LOCATION. */
	protected static final String PINNACLE_BAD_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSports_badXml.xml";

	/** The Constant PINNACLE_COMPETITION_NAME_XML_LOCATION. */
	protected static final String PINNACLE_COMPETITION_NAME_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsTournamentNameTest.xml";

	/** The Constant PINNACLE_TIMEZONE. */
	protected static final String PINNACLE_TIMEZONE = "GMT-1";

	/** The Constant PINNACLE_XML_LOCATION. */
	protected static final String PINNACLE_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSports.xml";

	/** The Constant PINNACLE_XML_LOCATION_AMERICAN_FOOTBALL_NAME_TEST. */
	protected static final String PINNACLE_XML_LOCATION_AMERICAN_FOOTBALL_NAME_TEST = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\americanFootballNameTest.xml";

	/** The Constant PINNACLE_XML_LOCATION_BUG_3704. */
	protected static final String PINNACLE_XML_LOCATION_BUG_3704 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\Bug3704.xml";

	/** The Constant PINNACLE_XML_LOCATION_BUG3726_ADD_ONE_MINUTE_TO_MATCH_DATE. */
	protected static final String PINNACLE_XML_LOCATION_BUG3726_ADD_ONE_MINUTE_TO_MATCH_DATE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\Bug3726AddOneMinuteToMatchDate.xml";

	/** The Constant PINNACLE_XML_LOCATION_BUG3813_IGNORE_LIVE_MATCHS. */
	protected static final String PINNACLE_XML_LOCATION_BUG3813_IGNORE_LIVE_MATCHS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\Bug3813IgnoreLiveMatchs.xml";

	/** The Constant PINNACLE_XML_LOCATION. */
	protected static final String PINNACLE_XML_LOCATION_GANADOR = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsGanador.xml";

	/** The Constant PINNACLE_XML_LOCATION_GANADOR_DE_PARTIDO. */
	protected static final String PINNACLE_XML_LOCATION_GANADOR_DE_PARTIDO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsGanadorDePartido.xml";

	/** The Constant PINNACLE_XML_LOCATION_HANDICAP_ASIATICO. */
	protected static final String PINNACLE_XML_LOCATION_HANDICAP_ASIATICO = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsHandicapAsiatico.xml";

	/** The Constant PINNACLE_XML_LOCATION_MAS_MENOS. */
	protected static final String PINNACLE_XML_LOCATION_MAS_MENOS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsMasMenos.xml";

	/** The Constant PINNACLE_XML_LOCATION. */
	protected static final String PINNACLE_XML_LOCATION_SHORT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsShort.xml";

	/** The Constant PINNACLE_XML_LOCATION_UNO_X_DOS. */
	protected static final String PINNACLE_XML_LOCATION_UNO_X_DOS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSports1X2.xml";

	/** The Constant PINNACLE_XML_LOCATION_TENNIS. */
	protected static final String PINNACLE_XML_LOCATION_TENNIS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\pinnacleSportsTennisTest.xml";

	protected static final String PINNACLE_XML_LOCATION_BUG_4773_1 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\Bug4773-1.xml";

	protected static final String PINNACLE_XML_LOCATION_BUG_4773_2 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\pinnaclesports\\Bug4773-2.xml";

	/** The pinnacle reader. */
	@Inject
	private XMLPinnacleSportsFileReader pinnacleReader;

	/**
	 * American football name test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void americanFootballNameTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER,
				PINNACLE_XML_LOCATION_AMERICAN_FOOTBALL_NAME_TEST,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("American Football", xmlMatch.getXmlTournament()
					.getXmlSport().getName());
		}
	}

	/**
	 * Bug3726 addne minute to match date.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bug3726AddneMinuteToMatchDate() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER,
				PINNACLE_XML_LOCATION_BUG3726_ADD_ONE_MINUTE_TO_MATCH_DATE,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(2, xmlMatchs.size());
		boolean matchAflTested = false;
		boolean matchRomania1Tested = false;
		for (XmlMatch xmlMatch : xmlMatchs) {
			if (xmlMatch.getName().equalsIgnoreCase("AFL")) {
				assertNotNull(xmlMatch.getStartDate());
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(xmlMatch.getStartDate().getProviderDate());
				// 2009-12-31 23:59 cambio de año
				assertEquals(2010, cal.get(Calendar.YEAR));
				assertEquals(1, cal.get(Calendar.MONTH) + 1);
				assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
				assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
				assertEquals(0, cal.get(Calendar.MINUTE));
				matchAflTested = true;
			} else if (xmlMatch.getName().equalsIgnoreCase("Romania 1")) {
				assertNotNull(xmlMatch.getStartDate());
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(xmlMatch.getStartDate().getProviderDate());
				// 2000-02-28 23:59 año bisiesto :)
				assertEquals(2000, cal.get(Calendar.YEAR));
				assertEquals(2, cal.get(Calendar.MONTH) + 1);
				assertEquals(29, cal.get(Calendar.DAY_OF_MONTH));
				assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
				assertEquals(0, cal.get(Calendar.MINUTE));
				matchRomania1Tested = true;
			}
		}
		assertTrue(matchAflTested && matchRomania1Tested);
	}

	/**
	 * Bug3813 ignore live matchs.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void bug3813IgnoreLiveMatchs() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER,
				PINNACLE_XML_LOCATION_BUG3813_IGNORE_LIVE_MATCHS,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
	}

	/**
	 * Ganador de partido test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void ganadorDePartidoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_GANADOR_DE_PARTIDO,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			// Date
			assertNotNull(xmlMatch.getStartDate());
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(xmlMatch.getStartDate().getProviderDate());
			assertEquals(15, cal.get(Calendar.MINUTE));
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("AFL", xmlMatch.getXmlTournament().getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Aussie Rules", xmlMatch.getXmlTournament()
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
						"Hawthorn Hawks")
						|| participant.getName().equalsIgnoreCase(
								"Geelong Cats"));
				if (participant.getName().equalsIgnoreCase("Hawthorn Hawks")) {
					assertTrue(participant.isAwayParticipant());
					assertFalse(participant.isHomeParticipant());
				}
				if (participant.getName().equalsIgnoreCase("Geelong Cats")) {
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
				assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
						market.getXmlBetType().getXmlBetEvent().getBetEvent()
								.getId());
				assertNotNull(market.getXmlMarketBets());
				assertTrue(betType.getId().equals(
						CfgBetTypeId.GANADOR_PARTIDO.nameId()));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
				}
				boolean one = false;
				boolean two = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertTrue(bet.getXmlAttribute() instanceof XmlMatchWinnerAttribute);
					XmlMatchWinnerAttribute attr = (XmlMatchWinnerAttribute) bet
							.getXmlAttribute();
					Result result = attr.getResult();
					if (result.getNameId().equals(Result.ONE.getNameId())) {
						one = true;
						assertEquals("2.67", bet.getXmlMarketBetOdd().getOdds()); // 167
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Geelong Cats", bet
								.getXmlMatchParticipant().getName());
					} else if (result.getNameId()
							.equals(Result.TWO.getNameId())) {
						two = true;
						assertEquals("1.54", bet.getXmlMarketBetOdd().getOdds()); // -186
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Hawthorn Hawks", bet
								.getXmlMatchParticipant().getName());
					}
				}
				assertTrue(one && two);
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
		assertNotNull(pinnacleReader.getBookmakerId());
		assertEquals(pinnacleReader.getBookmakerId(),
				CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId().toString());
	}

	/**
	 * Gets the start date.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @return the start date
	 * @throws ParseException
	 *             the parse exception
	 */
	protected Date getStartDate(final String date, final String format,
			String bookmakerTimeZone) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date providerDate = dateFormat.parse(date);
		return providerDate;
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
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_HANDICAP_ASIATICO,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			// Date
			assertNotNull(xmlMatch.getStartDate());
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(xmlMatch.getStartDate().getProviderDate());
			assertEquals(30, cal.get(Calendar.MINUTE));
			assertEquals(1, xmlMatch.getXmlMarkets().size());
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
						CfgBetTypeId.HANDICAP_ASIATICO.nameId()));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
				}
				boolean one = false;
				boolean two = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertTrue(bet.getXmlAttribute() instanceof XmlAsianHandicapAttribute);
					XmlAsianHandicapAttribute attr = (XmlAsianHandicapAttribute) bet
							.getXmlAttribute();
					AsianResult result = attr.getAsianResult();
					assertEquals(new Double(0.75), attr.getFirstValue());
					if (result.getNameId().equals(Result.ONE.getNameId())) {
						one = true;
						assertEquals("2.06", bet.getXmlMarketBetOdd().getOdds()); // 106
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Ceahlaul Piatra Neamt", bet
								.getXmlMatchParticipant().getName());
					} else if (result.getNameId()
							.equals(Result.TWO.getNameId())) {
						two = true;
						assertEquals("1.85", bet.getXmlMarketBetOdd().getOdds()); // -118
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Steaua Bucuresti", bet
								.getXmlMatchParticipant().getName());
					}
				}
				assertTrue(one && two);
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
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_MAS_MENOS,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			// Date
			assertNotNull(xmlMatch.getStartDate());
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(xmlMatch.getStartDate().getProviderDate());
			assertEquals(20, cal.get(Calendar.HOUR_OF_DAY));
			assertEquals(0, cal.get(Calendar.MINUTE));
			assertNotNull(xmlMatch.getXmlMarkets());
			assertEquals(1, xmlMatch.getXmlMarkets().size());
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
						CfgBetTypeId.MAS_MENOS.nameId()));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
				}
				boolean mas = false;
				boolean menos = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertTrue(bet.getXmlAttribute() instanceof XmlMoreLessAttribute);
					XmlMoreLessAttribute attr = (XmlMoreLessAttribute) bet
							.getXmlAttribute();
					assertEquals(String.valueOf(2.5), attr.getTotalGoal()
							.toString());
					if (attr.getMasMenos().equals(MasMenos.MAS)) {
						mas = true;
						assertEquals("2.09", bet.getXmlMarketBetOdd().getOdds()); // 109
					} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
						menos = true;
						assertEquals("1.79", bet.getXmlMarketBetOdd().getOdds()); // -126
					}
				}
				assertTrue(mas && menos);
			}
		}
	}

	/**
	 * Pinnacle sports competition name test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void pinnacleSportsCompetitionNameTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_COMPETITION_NAME_XML_LOCATION,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(6, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {

			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());

			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			xmlMatch.getStartDate().getProviderDate();
			xmlMatch.getStartDate().getZeroGmtMatchDate();
			Date startDateEvent1 = getStartDate("2013-03-07 19:05",
					DATE_FORMAT, PINNACLE_TIMEZONE);
			Date startDateEvent2 = getStartDate("2013-06-28 09:00",
					DATE_FORMAT, PINNACLE_TIMEZONE);
			Date startDateEvent3 = getStartDate("2013-09-01 19:00",
					DATE_FORMAT, PINNACLE_TIMEZONE);
			Date startDateEvent4 = getStartDate("2013-08-25 16:00",
					DATE_FORMAT, PINNACLE_TIMEZONE);
			Date startDateEvent5 = getStartDate("2013-06-28 09:35",
					DATE_FORMAT, PINNACLE_TIMEZONE);
			Date startDateEvent6 = getStartDate("2013-06-24 09:00",
					DATE_FORMAT, PINNACLE_TIMEZONE);
			Date matchDate = xmlMatch.getStartDate().getProviderDate();
			assertTrue(matchDate.equals(startDateEvent1)
					|| matchDate.equals(startDateEvent2)
					|| matchDate.equals(startDateEvent3)
					|| matchDate.equals(startDateEvent4)
					|| matchDate.equals(startDateEvent5)
					|| matchDate.equals(startDateEvent6));
			if (startDateEvent1.equals(matchDate)) {
				assertEquals("US Open", xmlMatch.getXmlTournament().getName());
			} else if (startDateEvent2.equals(matchDate)) {
				assertEquals("Constructors Championship", xmlMatch
						.getXmlTournament().getName());
			} else if (startDateEvent3.equals(matchDate)) {
				assertEquals("Super Bowl XLVIII", xmlMatch.getXmlTournament()
						.getName());
			} else if (startDateEvent4.equals(matchDate)) {
				assertEquals("2014 BCS National Championship", xmlMatch
						.getXmlTournament().getName());
			} else if (startDateEvent5.equals(matchDate)) {
				assertEquals("Grand Final 2013", xmlMatch.getXmlTournament()
						.getName());
			} else if (startDateEvent6.equals(matchDate)) {
				assertEquals("2013 Wimbledon", xmlMatch.getXmlTournament()
						.getName());
			}
		}

	}

	/**
	 * Pinnacle sports read bad test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void pinnacleSportsReadBadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_BAD_XML_LOCATION,
				bookmakerConfiguration, null);
		assertTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents()
				.getXmlMatchs().size() == 0);
	}

	/**
	 * Pinnacle sports read ganador test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void pinnacleSportsReadGanadorTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_GANADOR,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(result.size(), 1);
		for (XmlMatch xmlMatch : result) {
			// Date
			assertNotNull(xmlMatch.getStartDate());
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(xmlMatch.getStartDate().getProviderDate());
			assertEquals(05, cal.get(Calendar.MINUTE));
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("2013 BNP Paribas Open", xmlMatch.getXmlTournament()
					.getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Tennis", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			// TournamentEvent
			assertNotNull(xmlMatch.getXmlTournamentEvent());
			assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			assertTrue(xmlMatch.getXmlTournamentEvent().getLongTerm()
					.getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(28, xmlMatch.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : xmlMatch
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
			}

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			assertEquals(1, xmlMatch.getXmlMarkets().size());
			for (XmlMarket market : xmlMatch.getXmlMarkets()) {
				assertNotNull(market.getXmlBetType());
				assertNotNull(market.getXmlBetType().getBetType());
				IBetType betType = market.getXmlBetType().getBetType();
				assertNotNull(market.getXmlBetType().getXmlBetEvent());
				assertNotNull(market.getXmlMarketBets());
				assertTrue(betType.getId()
						.equals(CfgBetTypeId.GANADOR.nameId()));

				boolean hasProcessedOddForNadal = false;
				boolean hasProcessedOddForFerrer = false;
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
					assertTrue(bet.getXmlAttribute() instanceof XmlWinnerAttribute);
					XmlWinnerAttribute attr = (XmlWinnerAttribute) bet
							.getXmlAttribute();
					if (attr.getWinner().getName().equalsIgnoreCase("R. Nadal")) {
						assertEquals("11.00", bet.getXmlMarketBetOdd()
								.getOdds()); // 1000
						hasProcessedOddForNadal = true;
					}
					if (attr.getWinner().getName()
							.equalsIgnoreCase("D. Ferrer")) {
						assertEquals("26.00", bet.getXmlMarketBetOdd()
								.getOdds()); // 2500
						hasProcessedOddForFerrer = true;
					}
				}
				assertTrue(hasProcessedOddForNadal && hasProcessedOddForFerrer);
			}

		}
	}

	/**
	 * Pinnacle sports read short test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void pinnacleSportsReadShortTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_SHORT,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		// Aunque en el xml aparecen tres eventos, solo devuelve dos: aquellos
		// cuyo estado está en open
		assertEquals(result.size(), 2);
		for (XmlMatch event : result) {
			if (event.getXmlTournament().getXmlSport().getName()
					.equals("Tennis")) {
				assertEquals(event.getXmlMatchParticipants().size(), 2);
			} else if (event.getXmlTournament().getXmlSport().getName()
					.equals("Soccer")) {
				assertEquals(event.getXmlMatchParticipants().size(), 2);
				assertEquals(event.isLive(), false);
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
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_UNO_X_DOS,
				bookmakerConfiguration, null);
		Collection<XmlMatch> xmlMatchs = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, xmlMatchs.size());
		for (XmlMatch xmlMatch : xmlMatchs) {
			// Date
			assertNotNull(xmlMatch.getStartDate());
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(xmlMatch.getStartDate().getProviderDate());
			assertEquals(30, cal.get(Calendar.MINUTE));
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("Romania 1", xmlMatch.getXmlTournament().getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Soccer", xmlMatch.getXmlTournament().getXmlSport()
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
						"Ceahlaul Piatra Neamt")
						|| participant.getName().equalsIgnoreCase(
								"Steaua Bucuresti"));
				if (participant.getName().equalsIgnoreCase("Steaua Bucuresti")) {
					assertTrue(participant.isAwayParticipant());
					assertFalse(participant.isHomeParticipant());
				}
				if (participant.getName().equalsIgnoreCase(
						"Ceahlaul Piatra Neamt")) {
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
				assertEquals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(),
						market.getXmlBetType().getXmlBetEvent().getBetEvent()
								.getId());
				assertNotNull(market.getXmlMarketBets());
				assertTrue(betType.getId().equals(
						CfgBetTypeId.UNO_X_DOS.nameId()));
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertNotNull(bet.getXmlMarketBetOdd());
					assertNotNull(bet.getXmlMarketBetOdd().getOdds());
					assertNotNull(bet.getXmlAttribute());
				}
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
						assertEquals("6.02", bet.getXmlMarketBetOdd().getOdds()); // 502
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Ceahlaul Piatra Neamt", bet
								.getXmlMatchParticipant().getName());
					} else if (result.getNameId()
							.equals(Result.TWO.getNameId())) {
						two = true;
						assertEquals("1.63", bet.getXmlMarketBetOdd().getOdds()); // -158
						assertNotNull(bet.getXmlMatchParticipant());
						assertEquals("Steaua Bucuresti", bet
								.getXmlMatchParticipant().getName());
					} else if (result.getNameId().equals(
							Result.DRAW.getNameId())) {
						draw = true;
						assertEquals("3.88", bet.getXmlMarketBetOdd().getOdds()); // 288
					}
				}
				assertTrue(one && two && draw);
			}
		}
	}

	@Test
	public void pinnacleSportsTennisTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_TENNIS,
				bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(result.size(), 1);
		for (XmlMatch xmlMatch : result) {
			// Date
			assertNotNull(xmlMatch.getStartDate());
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(xmlMatch.getStartDate().getProviderDate());
			assertEquals(05, cal.get(Calendar.MINUTE));
			// Tournament
			assertNotNull(xmlMatch.getXmlTournament());
			assertNotNull(xmlMatch.getXmlTournament().getName());
			assertEquals("Chile R1", xmlMatch.getXmlTournament().getName());
			// Sport
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport());
			assertNotNull(xmlMatch.getXmlTournament().getXmlSport().getName());
			assertEquals("Tennis", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			// TournamentEvent
			// assertNotNull(xmlMatch.getXmlTournamentEvent());
			// assertNotNull(xmlMatch.getXmlTournamentEvent().getLongTerm());
			// assertTrue(xmlMatch.getXmlTournamentEvent().getLongTerm()
			// .getLongTerm());

			// Participants
			assertNotNull(xmlMatch.getXmlMatchParticipants());
			assertEquals(2, xmlMatch.getXmlMatchParticipants().size());
			for (XmlMatchParticipant participant : xmlMatch
					.getXmlMatchParticipants()) {
				assertNotNull(participant.getName());
				assertNotNull(participant.getXmlTournament());
			}

			// Markets
			assertNotNull(xmlMatch.getXmlMarkets());
			assertEquals(3, xmlMatch.getXmlMarkets().size());
			for (XmlMarket market : xmlMatch.getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {

					assertNotNull(market.getXmlBetType());
					assertNotNull(market.getXmlBetType().getBetType());
					XmlBetEvent betEvent = market.getXmlBetType()
							.getXmlBetEvent();
					assertNotNull(betEvent);
					if (betEvent.getBetEvent().getId()
							.equals(CfgBetTypeEventId.PRIMER_SET)) {
						assertNotNull(market.getXmlMarketBets());
					} else {
						assertNotNull(market.getXmlMarketBets());
					}
				} else if (market.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.MAS_MENOS.nameId())) {
					assertNotNull(market.getXmlBetType());
					assertNotNull(market.getXmlBetType().getBetType());
					assertNotNull(market.getXmlBetType().getXmlBetEvent());
					assertNotNull(market.getXmlMarketBets());
				}
			}
		}
	}

	@Test
	public void Bug4773InputTennisAsianHandicapTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_BUG_4773_1,
				bookmakerConfiguration, null);
		XmlAsianHandicapAttribute asianHandicapAttribute;

		for (XmlMatch xmlMatch : xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs()) {
			assertEquals("Tennis", xmlMatch.getXmlTournament().getXmlSport()
					.getName());
			assertEquals("Dusseldor 16", xmlMatch.getXmlTournament().getName());
			for (XmlMatchParticipant xmlMatchParticipant : xmlMatch
					.getXmlMatchParticipants()) {
				if ("Mate Delic".equals(xmlMatchParticipant.getName())) {
					assertTrue(xmlMatchParticipant.isAwayParticipant());
				} else if ("Dustin Brown".equals(xmlMatchParticipant.getName())) {
					assertTrue(xmlMatchParticipant.isHomeParticipant());
				} else {
					fail("El nombre de los participantes no es correcto");
				}

			}

			for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {

				assertEquals(xmlMarket.getXmlBetType().getBetType().getId(),
						CfgBetTypeId.HANDICAP_ASIATICO.nameId());

				assertEquals(xmlMarket.getXmlBetType().getXmlBetEvent()
						.getBetEvent().getId(),
						CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO
								.nameId());

				for (XmlMarketBet xmlMarketBet : xmlMarket.getXmlMarketBets()) {
					if (xmlMarketBet.getXmlAttribute() instanceof XmlAsianHandicapAttribute) {
						asianHandicapAttribute = (XmlAsianHandicapAttribute) xmlMarketBet
								.getXmlAttribute();
						if ("Mate Delic".equals(xmlMarketBet
								.getXmlMatchParticipant().getName())) {
							assertTrue(xmlMarketBet.getXmlMatchParticipant()
									.isAwayParticipant());
							assertEquals("1.53", xmlMarketBet.getXmlBetOdd()
									.getOdds());
							assertEquals(new Double("-1.5"),
									asianHandicapAttribute.getFirstValue());
							assertEquals(
									asianHandicapAttribute.getAsianResult(),
									AsianResult.TWO);

						} else if ("Dustin Brown".equals(xmlMarketBet
								.getXmlMatchParticipant().getName())) {
							assertTrue(xmlMarketBet.getXmlMatchParticipant()
									.isHomeParticipant());
							assertEquals("2.71", xmlMarketBet.getXmlBetOdd()
									.getOdds());
							assertEquals(new Double("-1.5"),
									asianHandicapAttribute.getFirstValue());
						} else {
							fail("No es correcto el participant en una apuesta");
						}
					} else {
						fail("El tipo de atributo no es correcto");
					}

				}
			}

		}
	}

	@Test
	public void Bug4773NoInputTennisAsianHandicapTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(PINNACLE_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				PINNACLE_READER, PINNACLE_XML_LOCATION_BUG_4773_2,
				bookmakerConfiguration, null);
		for (XmlMatch xmlMatch : xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs()) {
			assertEquals(2, xmlMatch.getXmlMarkets().size());
			for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {
				if (xmlMarket.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {

				} else if (xmlMarket.getXmlBetType().getBetType().getId()
						.equals(CfgBetTypeId.MAS_MENOS.nameId())) {

				} else {
					fail("Se esta resolviendo Handicap Asiatico de forma incorrecta");
				}

			}

		}
	}
}
