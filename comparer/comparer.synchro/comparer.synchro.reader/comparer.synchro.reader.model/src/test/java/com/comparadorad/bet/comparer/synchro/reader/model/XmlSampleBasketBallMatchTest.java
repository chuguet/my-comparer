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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class XmlSampleBasketBallMatch.
 */
public class XmlSampleBasketBallMatchTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlSampleBasketBallMatchTest.class);

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
		// <sport name="Basketball" id="4">
		// <event name="Spain ACB" id="154">
		// <match name="Caja Laboral - Real Madrid" id="458435"
		// start_date="2012-05-29T19:45:00" live_id="52764" streaming="0">
		// <bets>
		// <bet code="Bkb_Mr2" name="Match Winner" id="3440728">
		// <choice name="%1%" id="29083697" odd="1.68"/>
		// <choice name="%2%" id="29083698" odd="2.05"/>
		// </bet>
		// <bet code="Bkb_Han" name="Handicap Result" id="3440734">
		// <choice name="%1% -2.5" id="29132931" odd="1.90"/>
		// <choice name="%2% +2.5" id="29132932" odd="1.80"/>
		// </bet>
		// <bet code="Bkb_Mrs" name="Match Result" id="3440731">
		// <choice name="%1%" id="29083720" odd="1.72"/>
		// <choice name="Draw" id="29083721" odd="14.00"/>
		// <choice name="%2%" id="29083722" odd="2.15"/>
		// </bet>
		// <bet code="Bkb_Tpt" name="Total Points" id="3440735">
		// <choice name="Under 151.5" id="29132934" odd="1.85"/>
		// <choice name="Over 151.5" id="29132933" odd="1.85"/>
		// </bet>
		// </bets>
		// </match>
		// </sport>

		XmlTournament xmlTournament = new XmlTournament("Spain ACB");
		xmlTournament.setXmlSport(new XmlSport("Basketball", new BmInternalId(
				"4")));

		String date = "2012-05-29T19:45:00".replace("T", " ");
		String matchName = "Caja Laboral - Real Madrid";
		XmlMatch xmlMatch = new XmlMatch(matchName, getDate(date,
				"yyyy-MM-dd HH:mm:ss"), new BmInternalId("458435"));
		xmlMatch.setLiveId("52764");
		xmlMatch.setStreaming("0");
		// no tenemos home, tenemos posiciones
		ParticipiantNames participiantNames = new ParticipiantNames(matchName,
				" - ", "PERCENTIL");
		XmlMatchParticipant matchParticipant1 = new XmlMatchParticipant(
				participiantNames.get("%1%"), "%1%", xmlTournament);
		xmlMatch.addXmlMatchParticipant(matchParticipant1);
		XmlMatchParticipant matchParticipant2 = new XmlMatchParticipant(
				participiantNames.get("%2%"), "%2%", xmlTournament);

		xmlMatch.addXmlMatchParticipantAway(matchParticipant2);
		// MARKET
		XmlMarket xmlMarket1 = new XmlMarket(xmlMatch, new XmlBetType(
				"Moneyline"), new BmInternalId("154"));
		XmlMarketBet xmlBet11 = new XmlMarketBet(new XmlMarketBetOdd("1.61",
				"-164", "3/5"), matchParticipant1, new BmInternalId("18785869"));
		XmlMarketBet xmlBet12 = new XmlMarketBet(new XmlMarketBetOdd("2.25",
				"125", "5/4"), matchParticipant2, new BmInternalId("18785870"));
		xmlMarket1.addXmlBet(xmlBet11);
		xmlMarket1.addXmlBet(xmlBet12);
		xmlMatch.addXmlMarket(xmlMarket1);
		// /////////////////////////////////////////////////////////
		XmlBookmaker xmlBookmaker = new XmlBookmaker("BetAtclick",
				new BmInternalId("5"));
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents(
				"BetAtclicksample", xmlBookmaker, new BmInternalId(
						"internalIdTmp"));
		xmlBookmakerEvents.addXmlMatch(xmlMatch);
		logResult(xmlBookmakerEvents);
	}

	/**
	 * Test sample bet at home.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testPinnacleFeed() throws Exception {
		// <event>
		// <event_datetimeGMT>2012-05-29 18:45</event_datetimeGMT>
		// <gamenumber>249091851</gamenumber>
		// <sporttype>Basketball</sporttype>
		// <league>Spain ACB</league>
		// <IsLive>No</IsLive>
		// <participants>
		// <participant>
		// <participant_name>Caja Laboral</participant_name>
		// <contestantnum>6931</contestantnum>
		// <rotnum>6931</rotnum>
		// <visiting_home_draw>Home</visiting_home_draw>
		// </participant>
		// <participant>
		// <participant_name>Real Madrid</participant_name>
		// <contestantnum>6932</contestantnum>
		// <rotnum>6932</rotnum>
		// <visiting_home_draw>Visiting</visiting_home_draw>
		// </participant>
		// </participants>
		// <periods>
		// <period>
		// <period_number>0</period_number>
		// <period_description>Game</period_description>
		// <periodcutoff_datetimeGMT>2012-05-29 18:45</periodcutoff_datetimeGMT>
		// <period_status>O</period_status>
		// <period_update>open</period_update>
		// <spread_maximum>3000</spread_maximum>
		// <moneyline_maximum>2000</moneyline_maximum>
		// <total_maximum>2000</total_maximum>
		// <moneyline>
		// <moneyline_visiting>139</moneyline_visiting>
		// <moneyline_home>-154</moneyline_home>
		// </moneyline>
		// <spread>
		// <spread_visiting>3</spread_visiting>
		// <spread_adjust_visiting>-101</spread_adjust_visiting>
		// <spread_home>-3</spread_home>
		// <spread_adjust_home>-109</spread_adjust_home>
		// </spread>
		// <total>
		// <total_points>152</total_points>
		// <over_adjust>-102</over_adjust>
		// <under_adjust>-108</under_adjust>
		// </total>
		// </period>
		// </periods>

		XmlTournament xmlTournament = new XmlTournament("Spain ACB");
		xmlTournament.setXmlSport(new XmlSport("Basketball"));

		XmlMatch xmlMatch = new XmlMatch(getDate("2012-05-29 18:45",
				"yyyy-MM-dd HH:mm"), false, new BmInternalId("249091851"));
		// <visiting_home_draw>Home</visiting_home_draw> nos dice que es home
		XmlMatchParticipant homeMatchParticipant = new XmlMatchParticipant(
				"Caja Laboral Baskonia", xmlTournament);
		xmlMatch.addXmlMatchParticipantHome(homeMatchParticipant);
		XmlMatchParticipant awayMatchParticipant = new XmlMatchParticipant(
				"Real Madrid", xmlTournament);

		xmlMatch.addXmlMatchParticipantAway(awayMatchParticipant);
		// MARKET
		// TODO no entiendo los periods
		logResult(xmlMatch);
	}

	/**
	 * Test sample bet at home.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testSampleBetAtHome() throws Exception {
		// <OO>
		// <Sport>Basketball</Sport>
		// <Category />
		// <Tournament>Spain ACB</Tournament>
		// <Date>2012-05-29T20:45:00</Date>
		// <AC>1</AC>
		// <OddsType>2W</OddsType>
		// <OddsData>
		// <HomeTeam>Caja Laboral Baskonia</HomeTeam>
		// <AwayTeam>Real Madrid</AwayTeam>
		// <HomeOdds>1.65</HomeOdds>
		// <AwayOdds>2.00</AwayOdds>
		// </OddsData>
		// </OO>
		XmlTournament xmlTournament = new XmlTournament("Spain ACB");
		xmlTournament.setXmlSport(new XmlSport("Basketball"));

		XmlMatch xmlMatch = new XmlMatch();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = "2012-05-29 20:45:00";
		dateStr = StringUtils.replace(dateStr, "T", " ");
		Date matchDate = dateFormat.parse(dateStr);
		LOG.debug("Date = " + dateFormat.format(matchDate));
		xmlMatch.setStartDate(new XmlDate(matchDate));
		XmlMatchParticipant homeMatchParticipant = new XmlMatchParticipant(
				"Caja Laboral Baskonia", xmlTournament);
		xmlMatch.addXmlMatchParticipantHome(homeMatchParticipant);
		XmlMatchParticipant awayMatchParticipant = new XmlMatchParticipant(
				"Real Madrid", xmlTournament);

		xmlMatch.addXmlMatchParticipantAway(awayMatchParticipant);

		XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType("2W"));
		// TODO no se que es <AC>1</AC>
		XmlMarketBet xmlBet1 = new XmlMarketBet("1.65", homeMatchParticipant);
		XmlMarketBet xmlBet2 = new XmlMarketBet("2.00", awayMatchParticipant);
		xmlMarket.addXmlBet(xmlBet1);
		xmlMarket.addXmlBet(xmlBet2);
		xmlMatch.addXmlMarket(xmlMarket);
		logResult(xmlMatch);
	}

	/**
	 * Test sample bet at home.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testSampleTitanBet() throws Exception {
		// <sport id="5" name="Basketball">
		// <group id="41135" name="Spain - Liga ACB">
		// <event id="790239" name="Caja Laboral - Real Madrid"
		// date="2012-05-29 18:45:00">
		// <participants>
		// <participant id="41454" team="Caja Laboral" type="1"/>
		// <participant id="41143" team="Real Madrid" type="2"/>
		// </participants>
		// <market tid="154" name="Moneyline">
		// <outcome id="18785869" name="Caja Laboral" odds="1.61"
		// american_odds="-164" fra_odds="3/5"/>
		// <outcome id="18785870" name="Real Madrid" odds="2.25"
		// american_odds="125" fra_odds="5/4"/>
		// </market>
		// <market tid="90" name="Handicap">
		// <outcome id="18781629" name="Caja Laboral (-3)" odds="1.87"
		// american_odds="-115" fra_odds="17/20"/>
		// <outcome id="18781630" name="Real Madrid (+3)" odds="1.91"
		// american_odds="-110" fra_odds="9/10"/>
		// </market>
		// <market tid="91" name="Totals">
		// <outcome id="18781295" name="Over 152" odds="1.91"
		// american_odds="-110" fra_odds="9/10"/>
		// <outcome id="18781296" name="Under 152" odds="1.87"
		// american_odds="-115" fra_odds="17/20"/>
		// </market>
		// </event>
		// </group>
		// </sport>

		XmlTournament xmlTournament = new XmlTournament("Spain - Liga ACB");
		xmlTournament.setXmlSport(new XmlSport("Basketball", new BmInternalId(
				"5")));

		XmlMatch xmlMatch = new XmlMatch("Caja Laboral - Real Madrid", getDate(
				"2012-05-29 18:45:00", "yyyy-MM-dd HH:mm:ss"),
				new BmInternalId("790239"));
		// type="1" nos dice que es home
		XmlMatchParticipant homeMatchParticipant = new XmlMatchParticipant(
				"Caja Laboral Baskonia", xmlTournament);
		xmlMatch.addXmlMatchParticipantHome(homeMatchParticipant);
		XmlMatchParticipant awayMatchParticipant = new XmlMatchParticipant(
				"Real Madrid", xmlTournament);

		xmlMatch.addXmlMatchParticipantAway(awayMatchParticipant);
		// MARKET
		XmlMarket xmlMarket1 = new XmlMarket(xmlMatch, new XmlBetType(
				"Moneyline"), new BmInternalId("154"));
		XmlMarketBet xmlBet11 = new XmlMarketBet(new XmlMarketBetOdd("1.61",
				"-164", "3/5"), homeMatchParticipant, new BmInternalId(
				"18785869"));
		XmlMarketBet xmlBet12 = new XmlMarketBet(new XmlMarketBetOdd("2.25",
				"125", "5/4"), homeMatchParticipant, new BmInternalId(
				"18785870"));
		xmlMarket1.addXmlBet(xmlBet11);
		xmlMarket1.addXmlBet(xmlBet12);
		xmlMatch.addXmlMarket(xmlMarket1);
		// MARKET
		XmlMarket xmlMarket2 = new XmlMarket(xmlMatch, new XmlBetType(
				"Handicap"), new BmInternalId("90"));
		XmlMarketBet xmlBet21 = new XmlMarketBet("Caja Laboral (-3)",
				new XmlMarketBetOdd("1.87", "-115", "17/20"),
				homeMatchParticipant, new BmInternalId("18781629"));
		XmlMarketBet xmlBet22 = new XmlMarketBet("Real Madrid (+3)",
				new XmlMarketBetOdd("1.91", "-110", "9/10"),
				homeMatchParticipant, new BmInternalId("18781630"));
		xmlMarket2.addXmlBet(xmlBet21);
		xmlMarket2.addXmlBet(xmlBet22);
		xmlMatch.addXmlMarket(xmlMarket2);

		XmlBookmaker xmlBookmaker = new XmlBookmaker("TitanBet",
				new BmInternalId("5"));
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents(
				"titanfilesample", xmlBookmaker, new BmInternalId(
						"internalIdTmp"));
		xmlBookmakerEvents.addXmlMatch(xmlMatch);
		logResult(xmlBookmakerEvents);
	}
}
