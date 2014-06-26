/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.xsom;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.ParticipiantNames;
import com.comparadorad.bet.comparer.synchro.reader.model.ParticipiantNames.ParticipantName;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderRuntimeException;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class BetAtClickXomReaderTest.
 */
public class BetAtClickXomReaderTest {

	private static final String ID = "id";
	private static final String ODD = "odd";
	private static final String NAME = "name";
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BetAtClickXomReaderTest.class);

	/**
	 * Gets the date.
	 * 
	 * @param date
	 *            the date
	 * @param removeChars
	 *            the remove chars
	 * @param format
	 *            the format
	 * @return the date
	 */
	private static XmlDate getDate(final String date,
			final String[] removeChars, final String format) {
		String tmpDate = date;
		if (removeChars != null) {
			for (String removeChar : removeChars) {
				tmpDate = tmpDate.replace(removeChar, " ");
			}
		}
		DateFormat dateFormat = new SimpleDateFormat(format);

		Date matchDate;
		try {
			matchDate = dateFormat.parse(tmpDate);
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
			throw new XmlReaderRuntimeException(e.getMessage(), e);
		}
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
	 * Read market bets.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param xmlBookmakerEvents
	 *            the xml bookmaker events
	 * @param marketBetElements
	 *            the market bet elements
	 */
	private void readMarketBets(XmlMarket xmlMarket,
			final XmlBookmakerEvents xmlBookmakerEvents,
			Elements marketBetElements) {
		/*
		 * XmlBet xmlBet11 = new XmlBet(new XmlBetOdd("1.61", "-164", "3/5"),
		 * matchParticipant1, new BmInternalId("18785869"));
		 */
		for (int i = 0; i < marketBetElements.size(); i++) {
			Element marketBetElement = marketBetElements.get(i);

			XmlMatchParticipant matchParticipant = xmlMarket.getXmlMatch()
					.getXmlMatchParticipant(
							marketBetElement.getAttributeValue(NAME));
			XmlMarketBet xmlMarketBet = new XmlMarketBet(new XmlMarketBetOdd(
					marketBetElement.getAttributeValue(ODD)), matchParticipant,
					new BmInternalId(marketBetElement.getAttributeValue(ID)));
			xmlMarket.addXmlBet(xmlMarketBet);
			// TODO ver cuando hay cosas diferentes al participante
		}
	}

	/**
	 * Read markets.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @param xmlBookmakerEvents
	 *            the xml bookmaker events
	 * @param marketElements
	 *            the market elements
	 */
	private void readMarkets(XmlMatch xmlMatch,
			final XmlBookmakerEvents xmlBookmakerEvents, Elements marketElements) {
		for (int i = 0; i < marketElements.size(); i++) {
			Element marketElement = marketElements.get(i);
			XmlMarket xmlMarket = new XmlMarket(xmlMatch, new XmlBetType(
					marketElement.getAttributeValue("code"),
					marketElement.getAttributeValue(NAME)), new BmInternalId(
					marketElement.getAttributeValue(ID)));
			xmlMatch.addXmlMarket(xmlMarket);

			// <choice
			Elements marketBetElements = marketElement
					.getChildElements("choice");
			readMarketBets(xmlMarket, xmlBookmakerEvents, marketBetElements);
		}

	}

	/**
	 * Read matches.
	 * 
	 * @param xmlTournament
	 *            the xml tournament
	 * @param xmlBookmakerEvents
	 *            the xml bookmaker events
	 * @param matchesElements
	 *            the matches elements
	 */
	private void readMatches(XmlTournament xmlTournament,
			final XmlBookmakerEvents xmlBookmakerEvents,
			Elements matchesElements) {
		for (int i = 0; i < matchesElements.size(); i++) {
			Element matchElement = matchesElements.get(i);
			XmlMatch xmlMatch = new XmlMatch(
					matchElement.getAttributeValue(NAME), new BmInternalId(
							matchElement.getAttributeValue(ID)));
			xmlMatch.setStartDate(getDate(
					matchElement.getAttributeValue("start_date"),
					new String[] { "T" }, "yyyy-MM-dd HH:mm"));
			xmlMatch.setLiveId(matchElement.getAttributeValue("live_id"));
			xmlMatch.setStreaming(matchElement.getAttributeValue("streaming"));
			xmlMatch.setXmlTournament(xmlTournament);

			// SET the players
			// no tenemos home, tenemos posiciones
			ParticipiantNames participiantNames = new ParticipiantNames(
					matchElement.getAttributeValue(NAME), " - ", "PERCENTIL");
			for (ParticipantName participantName : participiantNames
					.getParticipantNameArray()) {
				XmlMatchParticipant matchParticipant = new XmlMatchParticipant(
						participantName.getName(), participantName.getRole());
				xmlMatch.addXmlMatchParticipant(matchParticipant);
			}

			xmlBookmakerEvents.addXmlMatch(xmlMatch);

			Elements marketElements = matchElement.getFirstChildElement("bets")
					.getChildElements("bet");
			readMarkets(xmlMatch, xmlBookmakerEvents, marketElements);
		}
	}

	/**
	 * Read sports.
	 * 
	 * @param xmlBookmakerEvents
	 *            the xml bookmaker events
	 * @param sportElements
	 *            the sport elements
	 */
	private void readSports(final XmlBookmakerEvents xmlBookmakerEvents,
			Elements sportElements) {

		for (int i = 0; i < sportElements.size(); i++) {
			Element sportElement = sportElements.get(i);
			XmlSport xmlSport = new XmlSport(
					sportElement.getAttributeValue(NAME), new BmInternalId(
							sportElement.getAttributeValue(ID)));
			// <event
			Elements tournamentElements = sportElement
					.getChildElements("event");
			readTournaments(xmlSport, xmlBookmakerEvents, tournamentElements);
		}
	}

	/**
	 * Read tournaments.
	 * 
	 * @param xmlSport
	 *            the xml sport type
	 * @param xmlBookmakerEvents
	 *            the xml bookmaker events
	 * @param tournamentElements
	 *            the tournament elements
	 */
	private void readTournaments(XmlSport xmlSport,
			final XmlBookmakerEvents xmlBookmakerEvents,
			Elements tournamentElements) {
		for (int i = 0; i < tournamentElements.size(); i++) {
			Element tournamentElement = tournamentElements.get(i);
			XmlTournament xmlTournament = new XmlTournament(
					tournamentElement.getAttributeValue(NAME),
					new BmInternalId(tournamentElement.getAttributeValue(ID)));
			xmlTournament.setXmlSport(xmlSport);
			// <match>
			Elements matchElements = tournamentElement
					.getChildElements("match");
			readMatches(xmlTournament, xmlBookmakerEvents, matchElements);

		}
	}

	/**
	 * Read xsom.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the document
	 */
	private Document readXsom(String fileName) {
		try {
			Date initTime = new Date();
			Builder parser = new Builder();
			Document doc = parser.build(this.getClass().getResourceAsStream(
					fileName));

			Date endTime = new Date();
			LOG.info("initTime: " + initTime + "  endTime: " + endTime);
			return doc;
		} catch (ParsingException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new XmlReaderRuntimeException(ex.getMessage(), ex);
		} catch (IOException ex) {
			LOG.error(ex.getMessage(), ex);
			throw new XmlReaderRuntimeException(ex.getMessage(), ex);
		}
	}

	/**
	 * Test read.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testRead() throws Exception {
		Document document = readXsom(getClass().getSimpleName() + ".xml");
		Element root = document.getRootElement();
		String strFileDate = root.getAttribute("file_date").getValue();
		XmlDate fileDate = getDate(strFileDate, new String[] { "T" },
				"yyyy-MM-dd HH:mm");
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents(fileDate);
		XmlBookmaker xmlBookmaker = new XmlBookmaker("BetAtClick");
		xmlBookmakerEvents.setXmlBookmaker(xmlBookmaker);
		// ///////////////////////////////////
		// <sport>
		Elements sportElements = root.getChildElements("sport");
		readSports(xmlBookmakerEvents, sportElements);

		XmlBetFileReaderResult xmlBetFileReaderResult = new XmlBetFileReaderResult(
				xmlBookmakerEvents);
		// /////////////////////////////////////////////////////////
		logResult(xmlBetFileReaderResult);
	}
}
