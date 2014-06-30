/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betboo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetBoo;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo.Competitor;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo.List;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo.OddsData;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo.OddsObject;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class XMLPinnacleSportsFileReader.
 */
@Component
public class XMLBetBooFileReader extends AbstractXmlFilereader {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XMLBetBooFileReader.class);

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:SS";

	private ArrayList<XmlMarketBet> processBets(OddsObject event,
			XmlTournament tournament) {
		ArrayList<XmlMarketBet> result = new ArrayList<XmlMarketBet>();
		XmlMarketBet bet;
		XmlMatchParticipant participant1;
		XmlMatchParticipant participant2;
		if (event.getOddsType().equals("Outright")) {// ganador
			XmlWinnerAttribute attribute;
			for (Competitor competitor : event.getOddsData().getCompetitor()) {
				bet = new XmlMarketBet();
				participant1 = new XmlMatchParticipant(competitor.getTeam(),
						tournament);
				bet.setXmlMatchParticipant(participant1);
				bet.setXmlMarketBetOdd(new XmlMarketBetOdd(competitor.getOdds()
						.toString()));
				attribute = new XmlWinnerAttribute();
				attribute.setWinner(participant1);
				bet.setXmlAttribute(attribute);
				result.add(bet);
			}
		}
		if (event.getOddsType().equals("3W")) {// 1x2
			// 1
			bet = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(event.getOddsData()
					.getHomeTeam(), tournament);
			participant1.setHomeParticipant(true);
			bet.setXmlMatchParticipant(participant1);
			bet.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getHomeOdds().toString()));
			Xml1X2Attribute attribute1 = new Xml1X2Attribute();
			attribute1.setResult(Result.ONE);
			bet.setXmlAttribute(attribute1);
			result.add(bet);

			// x
			XmlMarketBet betDRAW = new XmlMarketBet();
			Xml1X2Attribute attributeDRAW = new Xml1X2Attribute();
			attributeDRAW.setResult(Result.DRAW);
			betDRAW.setXmlAttribute(attributeDRAW);
			betDRAW.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getDrawOdds().toString()));
			result.add(betDRAW);

			// 2
			XmlMarketBet betTWO = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(event.getOddsData()
					.getAwayTeam(), tournament);
			participant2.setAwayParticipant(true);
			betTWO.setXmlMatchParticipant(participant2);
			betTWO.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getAwayOdds().toString()));
			Xml1X2Attribute attribute2 = new Xml1X2Attribute();
			attribute2.setResult(Result.TWO);
			betTWO.setXmlAttribute(attribute2);
			result.add(betTWO);

		}
		if (event.getOddsType().equals("2W")) {// gandor de partido
			// 1
			bet = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(event.getOddsData()
					.getHomeTeam(), tournament);
			participant1.setHomeParticipant(true);
			bet.setXmlMatchParticipant(participant1);
			bet.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getHomeOdds().toString()));
			XmlMatchWinnerAttribute attribute1 = new XmlMatchWinnerAttribute();
			attribute1.setResult(Result.ONE);
			attribute1.setWinnerName(participant1);
			bet.setXmlAttribute(attribute1);
			result.add(bet);

			// 2
			XmlMarketBet betTWO = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(event.getOddsData()
					.getAwayTeam(), tournament);
			participant2.setAwayParticipant(true);
			betTWO.setXmlMatchParticipant(participant2);
			betTWO.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getAwayOdds().toString()));
			XmlMatchWinnerAttribute attribute2 = new XmlMatchWinnerAttribute();
			attribute2.setResult(Result.TWO);
			attribute2.setWinnerName(participant2);
			betTWO.setXmlAttribute(attribute2);
			result.add(betTWO);
		}
		if (event.getOddsType().equals("Spread")) {// handicap
			// 1
			bet = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(event.getOddsData()
					.getHomeTeam(), tournament);
			participant1.setHomeParticipant(true);
			bet.setXmlMatchParticipant(participant1);
			bet.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getSpreadOddsHome().toString()));
			XmlAsianHandicapAttribute attribute1 = new XmlAsianHandicapAttribute();
			attribute1.setAsianResult(AsianResult.ONE);
			if (!event.getOddsData().getSpreadHome().equals("")) {
				attribute1.setFirstValue(Double.parseDouble(event.getOddsData()
						.getSpreadHome()));
			}
			bet.setXmlAttribute(attribute1);
			if (!bet.getXmlMarketBetOdd().getOdds().equals("")
					&& attribute1.getFirstValue() != null) {
				result.add(bet);
			}

			// 2
			XmlMarketBet betTWO = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(event.getOddsData()
					.getAwayTeam(), tournament);
			participant2.setAwayParticipant(true);
			betTWO.setXmlMatchParticipant(participant2);
			betTWO.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getSpreadOddsAway().toString()));
			XmlAsianHandicapAttribute attribute2 = new XmlAsianHandicapAttribute();
			attribute2.setAsianResult(AsianResult.TWO);
			if (!event.getOddsData().getSpreadHome().equals("")) {
				attribute2.setFirstValue(Double.parseDouble(event.getOddsData()
						.getSpreadHome()));
			}
			// attribute2.setFirstValue(Double.parseDouble(event.getOddsData().getSpreadAway()));
			betTWO.setXmlAttribute(attribute2);
			if (!bet.getXmlMarketBetOdd().getOdds().equals("")
					&& attribute1.getFirstValue() != null) {
				result.add(betTWO);
			}

		}
		if (event.getOddsType().equals("Total")) {// masmenos
			// 1
			bet = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(event.getOddsData()
					.getHomeTeam(), tournament);
			participant1.setHomeParticipant(true);
			bet.setXmlMatchParticipant(participant1);
			bet.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getUnderOdds().toString()));
			XmlMoreLessAttribute attribute1 = new XmlMoreLessAttribute();
			attribute1.setTotalGoal(Double.valueOf(event.getOddsData().getTotal()));
			attribute1.setMasMenos(MasMenos.MENOS);
			bet.setXmlAttribute(attribute1);
			result.add(bet);

			// 2
			XmlMarketBet betTWO = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(event.getOddsData()
					.getAwayTeam(), tournament);
			participant2.setAwayParticipant(true);
			betTWO.setXmlMatchParticipant(participant2);
			betTWO.setXmlMarketBetOdd(new XmlMarketBetOdd(event.getOddsData()
					.getOverOdds().toString()));
			XmlMoreLessAttribute attribute2 = new XmlMoreLessAttribute();
			attribute2.setTotalGoal(Double.valueOf(event.getOddsData().getTotal()));
			attribute2.setMasMenos(MasMenos.MAS);
			betTWO.setXmlAttribute(attribute2);
			result.add(betTWO);
		}
		return result;
	}

	private IBetType proceesBet(OddsObject event) {
		BetTypeBetBoo result = null;
		if (event.getOddsType().equals("Outright")) {
			result = BetTypeBetBoo.GANADOR;
		}
		if (event.getOddsType().equals("3W")) {
			result = BetTypeBetBoo.UNO_X_DOS;
		}
		if (event.getOddsType().equals("2W")) {
			result = BetTypeBetBoo.GANADOR_PARTIDO;
		}
		if (event.getOddsType().equals("Spread")) {
			result = BetTypeBetBoo.HANDICAP_ASIATICO;
		}
		if (event.getOddsType().equals("Total")) {
			result = BetTypeBetBoo.MAS_MENOS;
		}
		return result;
	}

	private Collection<XmlMatchParticipant> getParticipants(OddsData oddsData,
			XmlTournament tournament) {
		ArrayList<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant matchParticipant1;
		XmlMatchParticipant matchParticipant2;
		if (oddsData.getCompetitor() != null
				&& oddsData.getCompetitor().size() > 0) {// ganador
			for (Competitor competitor : oddsData.getCompetitor()) {
				matchParticipant1 = new XmlMatchParticipant(
						competitor.getTeam(), tournament);
				participants.add(matchParticipant1);
			}
		} else {// las demas
			matchParticipant1 = new XmlMatchParticipant(oddsData.getHomeTeam(),
					tournament);
			matchParticipant1.setHomeParticipant(true);
			participants.add(matchParticipant1);

			matchParticipant2 = new XmlMatchParticipant(oddsData.getAwayTeam(),
					tournament);
			matchParticipant2.setAwayParticipant(true);
			participants.add(matchParticipant2);
		}

		return participants;
	}

	private Collection<XmlMatch> reduce(java.util.List<XmlMatch> matchList) {
		// TODO Auto-generated method stub
		return matchList;
	}

	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BETBOO_ID.objectId().toString();
	}

	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {

		XmlBookmakerEvents result = new XmlBookmakerEvents();
		java.util.List<XmlMatch> matchList = new ArrayList<XmlMatch>();
		String time;
		List events = null;
		XmlDate xmlDate = new XmlDate();
		// xmlDate.setProviderTimeZone(cfgBookmakerConfiguration.getTimeZone());
		result.setFileDate(xmlDate);
		try {
			events = (List) JaxbUtils.readXML(pFile, List.class);
			XmlMatch match;
			XmlTournament tournament;
			XmlMarket market;
			XmlBetType betType;
			ArrayList<XmlMarketBet> bets;
			for (OddsObject event : events.getOddsObject()) {
				try {
					match = new XmlMatch();
					// Date
					time = event.getDate().toString().replace("T", " ");
					match.setStartDate(getStartDate(time, DATE_FORMAT,
							cfgBookmakerConfiguration.getTimeZone()));

					match.setName(event.getTournament());
					// Competition
					tournament = new XmlTournament();
					tournament.setName(event.getCategory() + event.getTournament());
					tournament.setRegion(new XmlRegion(event.getCategory()));
					tournament.setXmlSport(new XmlSport(event.getSport()));
					match.setXmlTournament(tournament);

					// Participants
					match.setXmlMatchParticipants(getParticipants(
							event.getOddsData(), tournament));

					// market
					market = new XmlMarket();
					betType = new XmlBetType(proceesBet(event));
					market.setXmlBetType(betType);

					// bets
					bets = processBets(event, tournament);
					for (XmlMarketBet xmlbet : bets) {
						market.addXmlBet(xmlbet);
					}
					ArrayList<XmlMarket> markets = new ArrayList<XmlMarket>();
					markets.add(market);
					match.setXmlMarkets(markets);

					if (betType.getBetType() != null) {
						matchList.add(match);
					}
				} catch (Exception e) {
					LOG.error("XML mal construido o no reconocido.", e);
					LOG.error("El xml que no se ha podido leer es: ");
					LOG.error(convertInputStreamToString(pFile));
				}

			}

			result.setXmlMatchs(reduce(matchList));

		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(errorMessage, e);
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: "
					+ JaxbUtils.writeXML(events, List.class);
			LOG.error(errorMessage, e);
		}

		return result;
	}

}
