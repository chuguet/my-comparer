/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class XmlSampleFootballMatchTest.
 */
public class XmlSampleFootballMatchTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlSampleFootballMatchTest.class);

	/**
	 * Gets the date.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	private XmlDate getDate(final String date, final String format)
			throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(format);
		String dateStr = date;
		Date matchDate = dateFormat.parse(dateStr);
		LOG.debug("Date = " + dateFormat.format(matchDate));
		return new XmlDate(matchDate);
	}

	/**
	 * Log result.
	 * 
	 * @param obj
	 *            the obj
	 */
	private void logResult(Object obj) {
		String result = XStreamUtil.createXStream().toXML(obj);
		LOG.info(result);
	}

	/**
	 * Test bet click.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testBetClick() throws Exception {
		/*
		 * 
		 * <sports file_date="2012-06-26T22:19:19.063"> <sport name="Football"
		 * id="1"> <event name="Euro 2012" id="122"> <match
		 * name="Portugal - Spain" id="463874" start_date="2012-06-27T19:45:00"
		 * live_id="54026" streaming="0"> <bets> <bet code="Ftb_Htf"
		 * name="Half-Time / Full-Time" id="3507642"> <choice name="%1% / Draw"
		 * id="29462478" odd="16.00"/> <choice name="Draw / %1%" id="29462480"
		 * odd="8.50"/> <choice name="Draw / Draw" id="29462481" odd="4.75"/>
		 * <choice name="Draw / %2%" id="29462482" odd="4.50"/> <choice
		 * name="%2% / Draw" id="29462484" odd="16.00"/> <choice
		 * name="%1% / %1%" id="29462477" odd="7.50"/> <choice name="%2% / %1%"
		 * id="29462483" odd="40.00"/> <choice name="%1% / %2%" id="29462479"
		 * odd="25.00"/> <choice name="%2% / %2%" id="29462485" odd="3.00"/>
		 * </bet> </bets> </match> </event> </sport> </sports>
		 */

		XmlTournament xmlTournament = new XmlTournament("Euro 2012");// torneo

		XmlSport xmlSport = new XmlSport("Football", new BmInternalId("1"));// tipo
																			// de
																			// deporte

		xmlTournament.setXmlSport(xmlSport);

		XmlMatch xmlMatch = new XmlMatch("Portugal - Spain",
				getDate("2012-06-27T19:45:00".replace("T", " "),
						"yyyy-MM-dd HH:mm:ss"), true,
				new BmInternalId("463874"));

		xmlMatch.setLiveId("54026");
		xmlMatch.setStreaming("0");

		ParticipiantNames participiantNames = new ParticipiantNames(
				"Portugal - Spain", " - ", "PERCENTIL");

		XmlMatchParticipant xmlMatchParticipant1 = new XmlMatchParticipant(
				participiantNames.get("%1%"), "%1%", xmlTournament);
		xmlMatchParticipant1.setHomeParticipant(true);
		xmlMatch.addXmlMatchParticipant(xmlMatchParticipant1);

		XmlMatchParticipant xmlMatchParticipant2 = new XmlMatchParticipant(
				participiantNames.get("%2%"), "%2%", xmlTournament);
		xmlMatchParticipant2.setHomeParticipant(false);
		xmlMatch.addXmlMatchParticipantAway(xmlMatchParticipant2);

		XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType(
				"Half-Time / Full-Time"), new BmInternalId("3507642"));

		XmlMarketBet bet1 = new XmlMarketBet(new XmlMarketBetOdd("16.00"),
				xmlMatchParticipant1, new BmInternalId("29462478"));
		bet1.setName("%1% / Draw");
		xmlMarket.addXmlBet(bet1);

		XmlMarketBet bet2 = new XmlMarketBet(new XmlMarketBetOdd("8.50"),
				xmlMatchParticipant1, new BmInternalId("29462480"));
		bet2.setName("Draw / %1%");
		xmlMarket.addXmlBet(bet2);
		/*
		 * Se puede añadir más choice, serÃ­a igual...
		 */
		xmlMatch.addXmlMarket(xmlMarket);

		logResult(xmlMatch);

	}

	/**
	 * Test betdaq.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testBetdaq() throws Exception {
		/*
		 * <SPORT NAME="Soccer" ID="100003"> <EVENT NAME="Euro 2012"
		 * ID="797302"> <SUBEVENT NAME="Semi Finals" ID="1082178"
		 * DATE="2012-06-27 18:45:00"> <SUBEVENT1
		 * NAME="(Wed) Portugal v Spain (TV)" ID="1096002"
		 * DATE="2012-06-27 19:45:00"> <MARKET NAME="Match Odds" ID="2643003"
		 * ODDS_SYSTEM="BL"> <LINK URL="http://www.betdaq.com?mktid=2643003"/>
		 * <SELECTION NAME="Portugal" ID="14275446"> <OUTCOME
		 * NAME="|BACK| Portugal"> <ODDS POLARITY="BACK"> <PRICE VALUE="4.80">
		 * <AMOUNT CURRENCY="USD" VALUE="1898"/> <AMOUNT CURRENCY="GBP"
		 * VALUE="1214"/> <AMOUNT CURRENCY="EUR" VALUE="1520"/> </PRICE> <PRICE
		 * VALUE="4.70"> <AMOUNT CURRENCY="USD" VALUE="5907"/> <AMOUNT
		 * CURRENCY="GBP" VALUE="3777"/> <AMOUNT CURRENCY="EUR" VALUE="4729"/>
		 * </PRICE> <PRICE VALUE="4.60"> <AMOUNT CURRENCY="USD" VALUE="6806"/>
		 * <AMOUNT CURRENCY="GBP" VALUE="4351"/> <AMOUNT CURRENCY="EUR"
		 * VALUE="5448"/> </PRICE> </ODDS> </OUTCOME> <OUTCOME
		 * NAME="|LAY| Portugal"> <ODDS POLARITY="LAY"> <PRICE VALUE="4.90">
		 * <AMOUNT CURRENCY="USD" VALUE="2849"/> <AMOUNT CURRENCY="GBP"
		 * VALUE="1822"/> <AMOUNT CURRENCY="EUR" VALUE="2281"/> </PRICE> <PRICE
		 * VALUE="5.00"> <AMOUNT CURRENCY="USD" VALUE="5255"/> <AMOUNT
		 * CURRENCY="GBP" VALUE="3360"/> <AMOUNT CURRENCY="EUR" VALUE="4207"/>
		 * </PRICE> <PRICE VALUE="5.10"> <AMOUNT CURRENCY="USD" VALUE="3455"/>
		 * <AMOUNT CURRENCY="GBP" VALUE="2209"/> <AMOUNT CURRENCY="EUR"
		 * VALUE="2766"/> </PRICE> </ODDS> </OUTCOME> </SELECTION> <SELECTION
		 * NAME="Spain" ID="14275447"> <OUTCOME NAME="|BACK| Spain"> <ODDS
		 * POLARITY="BACK"> <PRICE VALUE="1.99"> <AMOUNT CURRENCY="USD"
		 * VALUE="1667"/> <AMOUNT CURRENCY="GBP" VALUE="1066"/> <AMOUNT
		 * CURRENCY="EUR" VALUE="1335"/> </PRICE> <PRICE VALUE="1.98"> <AMOUNT
		 * CURRENCY="USD" VALUE="4008"/> <AMOUNT CURRENCY="GBP" VALUE="2563"/>
		 * <AMOUNT CURRENCY="EUR" VALUE="3209"/> </PRICE> <PRICE VALUE="1.97">
		 * <AMOUNT CURRENCY="USD" VALUE="10095"/> <AMOUNT CURRENCY="GBP"
		 * VALUE="6454"/> <AMOUNT CURRENCY="EUR" VALUE="8082"/> </PRICE> </ODDS>
		 * </OUTCOME> <OUTCOME NAME="|LAY| Spain"> <ODDS POLARITY="LAY"> <PRICE
		 * VALUE="2.00"> <AMOUNT CURRENCY="USD" VALUE="1630"/> <AMOUNT
		 * CURRENCY="GBP" VALUE="1042"/> <AMOUNT CURRENCY="EUR" VALUE="1305"/>
		 * </PRICE> <PRICE VALUE="2.01"> <AMOUNT CURRENCY="USD" VALUE="6079"/>
		 * <AMOUNT CURRENCY="GBP" VALUE="3887"/> <AMOUNT CURRENCY="EUR"
		 * VALUE="4867"/> </PRICE> <PRICE VALUE="2.02"> <AMOUNT CURRENCY="USD"
		 * VALUE="8366"/> <AMOUNT CURRENCY="GBP" VALUE="5349"/> <AMOUNT
		 * CURRENCY="EUR" VALUE="6698"/> </PRICE> </ODDS> </OUTCOME>
		 * </SELECTION> <SELECTION NAME="Draw" ID="14275448"> <OUTCOME
		 * NAME="|BACK| Draw"> <ODDS POLARITY="BACK"> <PRICE VALUE="3.40">
		 * <AMOUNT CURRENCY="USD" VALUE="10852"/> <AMOUNT CURRENCY="GBP"
		 * VALUE="6939"/> <AMOUNT CURRENCY="EUR" VALUE="8688"/> </PRICE> <PRICE
		 * VALUE="3.35"> <AMOUNT CURRENCY="USD" VALUE="7692"/> <AMOUNT
		 * CURRENCY="GBP" VALUE="4918"/> <AMOUNT CURRENCY="EUR" VALUE="6158"/>
		 * </PRICE> <PRICE VALUE="3.30"> <AMOUNT CURRENCY="USD" VALUE="9363"/>
		 * <AMOUNT CURRENCY="GBP" VALUE="5986"/> <AMOUNT CURRENCY="EUR"
		 * VALUE="7496"/> </PRICE> </ODDS> </OUTCOME> <OUTCOME
		 * NAME="|LAY| Draw"> <ODDS POLARITY="LAY"> <PRICE VALUE="3.45"> <AMOUNT
		 * CURRENCY="USD" VALUE="6483"/> <AMOUNT CURRENCY="GBP" VALUE="4145"/>
		 * <AMOUNT CURRENCY="EUR" VALUE="5190"/> </PRICE> <PRICE VALUE="3.50">
		 * <AMOUNT CURRENCY="USD" VALUE="8622"/> <AMOUNT CURRENCY="GBP"
		 * VALUE="5513"/> <AMOUNT CURRENCY="EUR" VALUE="6903"/> </PRICE> <PRICE
		 * VALUE="3.55"> <AMOUNT CURRENCY="USD" VALUE="8065"/> <AMOUNT
		 * CURRENCY="GBP" VALUE="5157"/> <AMOUNT CURRENCY="EUR" VALUE="6457"/>
		 * </PRICE> </ODDS> </OUTCOME> </SELECTION> </MARKET>
		 */

		XmlTournament xmlTournament = new XmlTournament("Euro 2012");// torneo
		// Esta casa tiene subeventos, dónde meterlos??? Ej--><SUBEVENT
		// NAME="Semi Finals" ID="1082178" DATE="2012-06-27 18:45:00">
		XmlSport xmlSport = new XmlSport("Soccer", new BmInternalId("100003"));// tipo
																				// de
																				// deporte

		xmlTournament.setXmlSport(xmlSport);

		XmlMatch xmlMatch = new XmlMatch("(Wed) Portugal v Spain (TV)",
				getDate("2012-06-27 19:45:00", "yyyy-MM-dd HH:mm:ss"), false,
				new BmInternalId("1096002"));

		XmlMatchParticipant xmlMatchParticipant1 = new XmlMatchParticipant(
				"Portugal", "14275446", xmlTournament);
		xmlMatch.addXmlMatchParticipant(xmlMatchParticipant1);

		XmlMatchParticipant xmlMatchParticipant2 = new XmlMatchParticipant(
				"Spain", "14275447", xmlTournament);
		xmlMatch.addXmlMatchParticipantAway(xmlMatchParticipant2);

		XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType(
				"Match Odds"), new BmInternalId("2643003")); // Qué pasa con el
																// sistema de
																// ODD?? EN el
																// ejemplo-->
																// ODDS_SYSTEM="BL"

		// POLARITY indica si el BACK o LAY, harÃ­a falta añadir algo al modelo
		// para guardar esto?? sólo se refleja en el nombre del BET.
		// Cada LAY o BACK tiene 3 <AMOUNT>, uno para los 3 tipos de moneda, que
		// indican la cantidad de dinero que la gente ha apostado en esa bet.
		// harÃ­a falta guardar esto en el modelo??
		XmlMarketBet bet1 = new XmlMarketBet(new XmlMarketBetOdd("4.80"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE ID"));// Falta
																		// un
																		// constructor
																		// que
																		// no
																		// tenga
																		// ID o
																		// los
																		// set
																		// apropiados.
		bet1.setName("|BACK| Portugal");
		xmlMarket.addXmlBet(bet1);

		XmlMarketBet bet2 = new XmlMarketBet(new XmlMarketBetOdd("4.70"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE ID"));
		bet2.setName("|BACK| Portugal");
		xmlMarket.addXmlBet(bet2);

		XmlMarketBet bet3 = new XmlMarketBet(new XmlMarketBetOdd("4.60"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE ID"));
		bet3.setName("|BACK| Portugal");
		xmlMarket.addXmlBet(bet3);

		XmlMarketBet bet4 = new XmlMarketBet(new XmlMarketBetOdd("4.90"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE ID"));// Falta
																		// un
																		// constructor
																		// que
																		// no
																		// tenga
																		// ID o
																		// los
																		// set
																		// apropiados.
		bet4.setName("|LAY| Portugal");
		xmlMarket.addXmlBet(bet4);

		XmlMarketBet bet5 = new XmlMarketBet(new XmlMarketBetOdd("5.00"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE ID"));
		bet5.setName("|LAY| Portugal");
		xmlMarket.addXmlBet(bet5);

		XmlMarketBet bet6 = new XmlMarketBet(new XmlMarketBetOdd("5.10"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE ID"));
		bet6.setName("|LAY| Portugal");
		xmlMarket.addXmlBet(bet6);
		/*
		 * Se añadirÃ­a igual españa y DRAW.......
		 */
		xmlMatch.addXmlMarket(xmlMarket);

		XmlBookmaker xmlBookmaker = new XmlBookmaker("BetDaq",
				new BmInternalId("6"));
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents(
				"BetDaqfile", xmlBookmaker, new BmInternalId("internalIdTmp"));
		xmlBookmakerEvents.addXmlMatch(xmlMatch);
		logResult(xmlBookmakerEvents);

	}

	/**
	 * Test bet fred.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testBetFred() throws Exception {

	}

	/**
	 * Test bluesq.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testBluesq() throws Exception {

	}

	/**
	 * Test centre bet.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testCentreBet() throws Exception {

	}

	/**
	 * Test gamingsys.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGamingsys() throws Exception {

	}

	/**
	 * Test nordic bet.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testNordicBet() throws Exception {

	}

	/**
	 * Test pinnacle.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testPinnacle() throws Exception {
		/*
		 * <event> <event_datetimeGMT>2012-06-30 13:59</event_datetimeGMT>
		 * <gamenumber>249812397</gamenumber> <sporttype>Soccer</sporttype>
		 * <league>Allsvenskan</league> <IsLive>No</IsLive> <participants>
		 * <participant> <participant_name>Mjallby</participant_name>
		 * <contestantnum>3008</contestantnum> <rotnum>3008</rotnum>
		 * <visiting_home_draw>Home</visiting_home_draw> </participant>
		 * <participant> <participant_name>IFK Norrkoping FK</participant_name>
		 * <contestantnum>3009</contestantnum> <rotnum>3009</rotnum>
		 * <visiting_home_draw>Visiting</visiting_home_draw> </participant>
		 * <participant> <participant_name>Draw</participant_name>
		 * <contestantnum>3010</contestantnum> <rotnum>3010</rotnum>
		 * <visiting_home_draw>Draw</visiting_home_draw> </participant>
		 * </participants> <periods> <period> <period_number>0</period_number>
		 * <period_description>Game</period_description>
		 * <periodcutoff_datetimeGMT>2012-06-30 13:59</periodcutoff_datetimeGMT>
		 * <period_status>I</period_status> <period_update>open</period_update>
		 * <spread_maximum>2000</spread_maximum>
		 * <moneyline_maximum>1000</moneyline_maximum>
		 * <total_maximum>2000</total_maximum> <moneyline>
		 * <moneyline_visiting>362</moneyline_visiting>
		 * <moneyline_home>-118</moneyline_home>
		 * <moneyline_draw>274</moneyline_draw> </moneyline> <spread>
		 * <spread_visiting>0.5</spread_visiting>
		 * <spread_adjust_visiting>109</spread_adjust_visiting>
		 * <spread_home>-0.5</spread_home>
		 * <spread_adjust_home>-118</spread_adjust_home> </spread> <total>
		 * <total_points>2.5</total_points> <over_adjust>-103</over_adjust>
		 * <under_adjust>-107</under_adjust> </total> </period> </periods>
		 * </event>
		 */

		XmlTournament xmlTournament = new XmlTournament("Allsvenskan");// torneo

		XmlSport xmlSport = new XmlSport("Soccer");// tipo de
													// deporte

		xmlTournament.setXmlSport(xmlSport);

		XmlMatch xmlMatch = new XmlMatch(getDate("2012-06-30 13:59",
				"yyyy-MM-dd HH:mm"), false, new BmInternalId("249812397"));

		XmlMatchParticipant xmlMatchParticipant1 = new XmlMatchParticipant(
				"Mjallby", "3008", xmlTournament);
		xmlMatchParticipant1.setHomeParticipant(true);
		xmlMatch.addXmlMatchParticipant(xmlMatchParticipant1);

		XmlMatchParticipant xmlMatchParticipant2 = new XmlMatchParticipant(
				"IFK Norrkoping FK", "3009", xmlTournament);
		xmlMatchParticipant2.setHomeParticipant(false);
		xmlMatch.addXmlMatchParticipantAway(xmlMatchParticipant2);

		XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType(
				"MoneyLine"), new BmInternalId("0"));
		// Esta parte es confusa, dónde se especifica el tipo de apuesta????
		xmlMarket.setName("Game");

		XmlMarketBet bet1 = new XmlMarketBet(new XmlMarketBetOdd("362"),
				xmlMatchParticipant1, new BmInternalId("NO TIENE"));
		// <moneyline_visiting> indica el multiplicador que hay si gana el
		// visitante?

		bet1.setName("VISITING");// ???
		xmlMarket.addXmlBet(bet1);

		XmlMarketBet bet2 = new XmlMarketBet(new XmlMarketBetOdd("-118"),
				xmlMatchParticipant1, new BmInternalId("29462480"));
		bet2.setName("HOME");// ???
		xmlMarket.addXmlBet(bet2);

		XmlMarketBet bet3 = new XmlMarketBet(new XmlMarketBetOdd("274"),
				new BmInternalId("29462480"));
		bet3.setName("DRAW");// ???
		xmlMarket.addXmlBet(bet3);
		/*
		 * <spread_visiting>0.5</spread_visiting>
		 * <spread_adjust_visiting>109</spread_adjust_visiting>
		 * <spread_home>-0.5</spread_home>
		 * <spread_adjust_home>-118</spread_adjust_home>
		 * 
		 * Esto parecen los datos de un HANDICAP, dónde se guardan estos datos
		 * en el modeloÂ¿???
		 */

		xmlMatch.addXmlMarket(xmlMarket);

		logResult(xmlMatch);

	}

	/**
	 * Test titan bet.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testTitanBet() throws Exception {
		/*
		 * <sport id="6" name="Football"> <group id="46439"
		 * name="Europe - Euro 2012"> <event id="799459" name="Spain - Portugal"
		 * date="2012-06-27 18:45:00"> <participants> <participant id="46440"
		 * team="Spain" type="1"/> <participant id="46445" team="Portugal"
		 * type="2"/> </participants> <market tid="1" name="Match Result">
		 * <outcome id="19149005" name="Spain" odds="1.92" american_odds="-109"
		 * fra_odds="9/10"/> <outcome id="19149006" name="Draw" odds="3.35"
		 * american_odds="235" fra_odds="47/20"/> <outcome id="19149007"
		 * name="Portugal" odds="4.33" american_odds="333" fra_odds="33/10"/>
		 * </market> </event> </group> <sport>
		 */

		XmlTournament xmlTournament = new XmlTournament("Europe - Euro 2012");// torneo

		XmlSport xmlSport = new XmlSport("Football", new BmInternalId("6"));// tipo
																			// de
																			// deporte

		xmlTournament.setXmlSport(xmlSport);

		XmlMatch xmlMatch = new XmlMatch("Spain - Portugal", getDate(
				"2012-06-27 18:45:00", "yyyy-MM-dd HH:mm:ss"),
				new BmInternalId("799459"));

		// No tiene live ni streaming

		XmlMatchParticipant xmlMatchParticipant1 = new XmlMatchParticipant( // el
																			// type
																			// hace
																			// falta
																			// para
																			// algo??
				"Spain", "46440", xmlTournament);
		xmlMatch.addXmlMatchParticipant(xmlMatchParticipant1);

		XmlMatchParticipant xmlMatchParticipant2 = new XmlMatchParticipant(
				"Portugal", "46445", xmlTournament);
		xmlMatch.addXmlMatchParticipantAway(xmlMatchParticipant2);

		XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType(
				"Match Result"), new BmInternalId("1"));

		XmlMarketBet bet1 = new XmlMarketBet(new XmlMarketBetOdd("1.92",
				"-109", "9/10"), xmlMatchParticipant1, new BmInternalId(
				"19149005"));
		bet1.setName("Spain");
		xmlMarket.addXmlBet(bet1);

		XmlMarketBet bet2 = new XmlMarketBet(new XmlMarketBetOdd("3.35", "235",
				"47/20"), new BmInternalId("19149006"));
		bet2.setName("Draw");
		xmlMarket.addXmlBet(bet2);

		XmlMarketBet bet3 = new XmlMarketBet(new XmlMarketBetOdd("4.33", "333",
				"33/10"), xmlMatchParticipant2, new BmInternalId("19149007"));
		bet2.setName("Portugal");
		xmlMarket.addXmlBet(bet3);

		xmlMatch.addXmlMarket(xmlMarket);

		logResult(xmlMatch);
	}

	/**
	 * Test triobet.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testTriobet() throws Exception {
		/*
		 * Game id="50000129078" name="JJK - FC Honka"> <Sport>Football</Sport>
		 * <Region>Finland</Region> <Season>Veikkausliiga</Season>
		 * <BreadCrumbs>Football - Finland - Veikkausliiga</BreadCrumbs>
		 * <GameStartTime>2012-06-28 18:30:00 EEST</GameStartTime>
		 * <BettingEndTime>2012-06-28 18:30:00 EEST</BettingEndTime>
		 * <LiveBet>True</LiveBet> <Participant info="FIN, football, men"
		 * role="1" id="9000006957">JJK</Participant> <Participant
		 * info="FIN, Football, Men" role="2" id="9000000765">FC
		 * Honka</Participant> <OutcomeSet type="Result" id="50001042233"
		 * name="JJK - FC Honka"> <Outcome odds="2.45" id="50042897083"
		 * name="1"> <Participant info="FIN, football, men"
		 * id="9000006957">JJK</Participant> </Outcome> <Outcome odds="3.25"
		 * id="50042897084" name="X"/> <Outcome odds="2.8" id="50042897085"
		 * name="2"> <Participant info="FIN, Football, Men" id="9000000765">FC
		 * Honka</Participant> </Outcome> </OutcomeSet> </Game>
		 */
		// también valdrÃ­a Football - Finland - Veikkausliiga
		XmlTournament xmlTournament = new XmlTournament("Veikkausliiga");

		XmlSport xmlSport = new XmlSport("Football");

		xmlTournament.setXmlSport(xmlSport);

		XmlMatch xmlMatch = new XmlMatch("JJK - FC Honka", getDate(
				"2012-06-28 18:30:00", "yyyy-MM-dd HH:mm:ss"), true,
				new BmInternalId("50000129078"));

		// No tiene streaming

		XmlMatchParticipant xmlMatchParticipant1 = new XmlMatchParticipant(
		// EL role y el info merece la pena guardarlosÂ¿?
				"JJ", "9000006957", xmlTournament);
		xmlMatch.addXmlMatchParticipant(xmlMatchParticipant1);

		XmlMatchParticipant xmlMatchParticipant2 = new XmlMatchParticipant(
				"FC Honka", "9000000765", xmlTournament);
		xmlMatch.addXmlMatchParticipantAway(xmlMatchParticipant2);

		// OutcomeSet = market
		XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType("Result"),
				new BmInternalId("50001042233"));
		xmlMarket.setName("JJK - FC Honka");

		XmlMarketBet bet1 = new XmlMarketBet(new XmlMarketBetOdd("2.45"),
				xmlMatchParticipant1, new BmInternalId("50042897083"));
		bet1.setName("1");
		xmlMarket.addXmlBet(bet1);

		XmlMarketBet bet2 = new XmlMarketBet(new XmlMarketBetOdd("3.25"),
				new BmInternalId("50042897084"));
		bet2.setName("X");
		xmlMarket.addXmlBet(bet2);

		XmlMarketBet bet3 = new XmlMarketBet(new XmlMarketBetOdd("2.8"),
				xmlMatchParticipant2, new BmInternalId("50042897085"));
		bet2.setName("2");
		xmlMarket.addXmlBet(bet3);

		xmlMatch.addXmlMarket(xmlMarket);

		logResult(xmlMatch);

	}

}
