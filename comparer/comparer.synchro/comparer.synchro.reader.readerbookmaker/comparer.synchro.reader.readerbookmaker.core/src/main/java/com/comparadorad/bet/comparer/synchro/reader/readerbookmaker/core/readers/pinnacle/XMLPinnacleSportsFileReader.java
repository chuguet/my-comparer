/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.BeanParameterPinnacle;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Events;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Moneyline;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Odds;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Participant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Participants;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Period;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Periods;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.PinnacleLineFeed;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Spread;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Total;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.commons.betOdds.CuotaConverterUtil;

/**
 * The Class XMLPinnacleSportsFileReader.
 */
@Component
public class XMLPinnacleSportsFileReader extends AbstractXmlFilereader
		implements MarketType {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XMLPinnacleSportsFileReader.class);

	/** The time zone. */
	private String timeZone;

	/**
	 * Adds the one minute to time. Muchas de la horas de pinnacle vienen como
	 * 20:19, 20:29, 20:49, 20:59. Estos partidos realmente empiezan a las
	 * 20:20, 20:30, 20:50, 21:00. Sumamos un minuto. Referencia: Bug 3726.
	 * 
	 * @param pDate
	 *            the date
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	private String addOneMinuteToTime(String pDate) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				PinnacleSports.DATE_FORMAT);
		Date date = dateFormat.parse(pDate);
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Gets the bean parameter pinnacle.
	 * 
	 * @param pinnacleLineFeed
	 *            the pinnacle line feed
	 * @return the bean parameter pinnacle
	 */
	private BeanParameterPinnacle getBeanParameterPinnacle(
			PinnacleLineFeed pinnacleLineFeed) {
		BeanParameterPinnacle beanParameterPinnacle = new BeanParameterPinnacle();
		beanParameterPinnacle.setIdTimePinnacle(String.valueOf(pinnacleLineFeed
				.getPinnacleFeedTime()));
		LOG.debug(new StringBuffer(
				"Se obtiene el id para generar el siguiente XML ==> ").append(
				beanParameterPinnacle.getIdTimePinnacle()).toString());
		return beanParameterPinnacle;
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId()
				.toString();
	}

	/**
	 * Gets the market ganador.
	 * 
	 * @param objParticipants
	 *            the obj participants
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	public XmlMarket getMarketGanador(Object objParticipants,
			Collection<XmlMatchParticipant> pXmlMatchParticipants)
			throws XmlReaderException {
		Participants pParticipants = (Participants) objParticipants;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypePinnacleSports.GANADOR);
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		xmlBetType.setXmlBetEvent(xmlBetEvent);
		xmlMarket.setXmlBetType(xmlBetType);
		for (Participant participant : pParticipants.getParticipant()) {
			XmlMatchParticipant part = getParticipantByName(
					pXmlMatchParticipants, participant.getParticipantName());
			if (participant.getOdds() != null) {
				Odds odds = participant.getOdds();
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(
						CuotaConverterUtil.americanToDecimalOdds(odds
								.getMoneylineValue())));
				XmlWinnerAttribute xmlAttribute = new XmlWinnerAttribute();
				xmlAttribute.setWinner(part);
				xmlMarketBet.setXmlMatchParticipant(part);
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		}
		return xmlMarket;
	}

	/**
	 * Sets the match winner.
	 * 
	 * @param objMoneyline
	 *            the obj moneyline
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the xml market
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketGanadorPartido(final Object objMoneyline,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		LOG.debug("Bet type = GANADOR_PARTIDO");
		Moneyline moneyline = (Moneyline) objMoneyline;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();

		xmlBetType.setBetType(BetTypePinnacleSports.GANADOR_PARTIDO);

		xmlMarket.setXmlBetType(xmlBetType);

		// Home
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		xmlMarketBetHome.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineHome()))));
		XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();
		xmlAttribute.setResult(Result.ONE);
		xmlAttribute.setWinnerName(getParticipant(xmlMatchParticipants, true));
		xmlMarketBetHome.setXmlAttribute(xmlAttribute);
		xmlMarketBetHome.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, true));
		xmlMarket.addXmlBet(xmlMarketBetHome);

		// Away
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		xmlMarketBetAway.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineVisiting()))));
		xmlAttribute = new XmlMatchWinnerAttribute();
		xmlAttribute.setResult(Result.TWO);
		xmlAttribute.setWinnerName(getParticipant(xmlMatchParticipants, false));
		xmlMarketBetAway.setXmlAttribute(xmlAttribute);
		xmlMarketBetAway.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, false));
		xmlMarket.addXmlBet(xmlMarketBetAway);

		return xmlMarket;
	}

	/**
	 * Sets the asian handicap.
	 * 
	 * @param objSpread
	 *            the obj spread
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the xml market
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketHandicapAsiatico(final Object objSpread,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		LOG.debug("Bet type = HANDICAP_ASIATICO");
		Spread spread = (Spread) objSpread;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();

		xmlBetType.setBetType(BetTypePinnacleSports.HANDICAP_ASIATICO);

		xmlMarket.setXmlBetType(xmlBetType);

		// Home
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		xmlMarketBetHome.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short.toString(spread
						.getSpreadAdjustHome()))));
		XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();
		xmlAttribute.setAsianResult(AsianResult.ONE);
		xmlAttribute.setFirstValue(Double.parseDouble(spread.getSpreadHome()
				.toString()));
		xmlMarketBetHome.setXmlAttribute(xmlAttribute);
		xmlMarketBetHome.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, true));
		xmlMarket.addXmlBet(xmlMarketBetHome);

		// Away
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		xmlMarketBetAway.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short.toString(spread
						.getSpreadAdjustVisiting()))));
		xmlAttribute = new XmlAsianHandicapAttribute();
		xmlAttribute.setAsianResult(AsianResult.TWO);
		xmlAttribute.setFirstValue(Double.parseDouble(spread.getSpreadHome()
				.toString()));
		xmlMarketBetAway.setXmlAttribute(xmlAttribute);
		xmlMarketBetAway.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, false));
		xmlMarket.addXmlBet(xmlMarketBetAway);

		return xmlMarket;
	}

	/**
	 * Sets the over under.
	 * 
	 * @param objTotal
	 *            the obj total
	 * @return the xml market
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketMasMenos(final Object objTotal)
			throws XmlReaderException {
		LOG.debug("Bet type = MAS_MENOS");
		Total total = (Total) objTotal;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();

		xmlBetType.setBetType(BetTypePinnacleSports.MAS_MENOS);

		xmlMarket.setXmlBetType(xmlBetType);

		// Home
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		xmlMarketBetHome.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short.toString(total
						.getOverAdjust()))));
		XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
		xmlAttribute.setMasMenos(MasMenos.MAS);
		xmlAttribute.setTotalGoal(Double.valueOf(total.getTotalPoints()
				.toString()));
		xmlMarketBetHome.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetHome);

		// Away
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		xmlMarketBetAway.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short.toString(total
						.getUnderAdjust()))));
		xmlAttribute = new XmlMoreLessAttribute();
		xmlAttribute.setMasMenos(MasMenos.MENOS);
		xmlAttribute.setTotalGoal(Double.valueOf(total.getTotalPoints()
				.toString()));
		xmlMarketBetAway.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetAway);

		return xmlMarket;
	}

	/**
	 * Gets the market maximo goleador.
	 * 
	 * @param pMarket
	 *            the market
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market maximo goleador
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	public XmlMarket getMarketMaximoGoleador(Object pMarket,
			Collection<XmlMatchParticipant> pXmlMatchParticipants)
			throws XmlReaderException {
		// De momento no se ha visto ninguna apuesta de tipo Maximo Goleador en
		// el xml de pinnacle
		return null;
	}

	/**
	 * Sets the one x two.
	 * 
	 * @param objMmoneyline
	 *            the obj mmoneyline
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the xml market
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketUnoXDos(final Object objMmoneyline,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		LOG.debug("Bet type = UNO_X_DOS");
		Moneyline moneyline = (Moneyline) objMmoneyline;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();

		xmlBetType.setBetType(BetTypePinnacleSports.UNO_X_DOS);

		xmlMarket.setXmlBetType(xmlBetType);

		// Home
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		xmlMarketBetHome.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineHome()))));
		Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
		xmlAttribute.setResult(Result.ONE);
		xmlMarketBetHome.setXmlAttribute(xmlAttribute);
		xmlMarketBetHome.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, true));
		xmlMarket.addXmlBet(xmlMarketBetHome);

		// Away
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		xmlMarketBetAway.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineVisiting()))));
		xmlAttribute = new Xml1X2Attribute();
		xmlAttribute.setResult(Result.TWO);
		xmlMarketBetAway.setXmlAttribute(xmlAttribute);
		xmlMarketBetAway.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, false));
		xmlMarket.addXmlBet(xmlMarketBetAway);

		// Draw
		XmlMarketBet xmlMarketBetDraw = new XmlMarketBet();
		xmlMarketBetDraw.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineDraw()))));
		xmlAttribute = new Xml1X2Attribute();
		xmlAttribute.setResult(Result.DRAW);
		xmlMarketBetDraw.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetDraw);

		return xmlMarket;
	}

	/**
	 * Gets the market uno x dos handicap.
	 * 
	 * @param pMarket
	 *            the market
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos handicap
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	public XmlMarket getMarketUnoXDosHandicap(Object pMarket,
			Collection<XmlMatchParticipant> pXmlMatchParticipants)
			throws XmlReaderException {
		// De momento no se ha visto ninguna apuesta de tipo 1X2 Handicap en el
		// xml de pinnacle
		return null;
	}

	/**
	 * Sets the match date. Nombre del nodo: <event_datetimeGMT>. Posición en
	 * eventContent: 0.
	 * 
	 * @param eventContent
	 *            the event content
	 * @param xmlMatch
	 *            the xml match
	 * @return the match date
	 * @throws ParseException
	 *             the parse exception
	 */
	@SuppressWarnings("rawtypes")
	private XmlDate getMatchDate(List<Object> eventContent, XmlMatch xmlMatch)
			throws ParseException {
		JAXBElement elem = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_EVENT_DATETIMEGMT_INDEX);
		String startDate = elem.getValue().toString();
		if (startDate.endsWith("9")) {
			startDate = addOneMinuteToTime(startDate);
		}
		return getStartDate(startDate, PinnacleSports.DATE_FORMAT, timeZone);
	}

	/**
	 * Gets the normal event sport name.
	 * 
	 * @param pSportName
	 *            the sport name
	 * @return the normal event sport name
	 */
	private String getNormalEventSportName(String pSportName) {
		String sportName = pSportName;
		PinnacleNormalEventSportName sportNameLookUp = PinnacleNormalEventSportName
				.getSportNameByValue(pSportName);
		if (sportNameLookUp != null) {
			sportName = sportNameLookUp.getSportName();
		}
		return sportName;
	}

	/**
	 * Gets the participants normal event.
	 * 
	 * @param participants
	 *            the participants
	 * @param tournament
	 *            the tournament
	 * @return the participants normal event
	 */
	private Collection<XmlMatchParticipant> getParticipantsNormalEvent(
			final Participants participants, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> xmlParticipants = new ArrayList<XmlMatchParticipant>();
		for (Participant participant : participants.getParticipant()) {
			if (participant.getVisitingHomeDraw().equalsIgnoreCase(
					PinnacleSports.HOME)) {
				XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
						participant.getParticipantName(), tournament);
				LOG.debug(new StringBuffer().append("Participant name: ")
						.append(participant.getParticipantName()));
				xmlMatchParticipant.setHomeParticipant(true);
				xmlParticipants.add(xmlMatchParticipant);
			} else if (participant.getVisitingHomeDraw().equalsIgnoreCase(
					PinnacleSports.VISITING)) {
				XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
						participant.getParticipantName(), tournament);
				LOG.debug(new StringBuffer().append("Participant name: ")
						.append(participant.getParticipantName()));
				xmlMatchParticipant.setAwayParticipant(true);
				xmlParticipants.add(xmlMatchParticipant);
			}
		}
		return xmlParticipants;
	}

	/**
	 * Gets the special event participants.
	 * 
	 * @param pParticipants
	 *            the participants
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the special event participants
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public Collection<XmlMatchParticipant> getSpecialEventParticipants(
			Participants pParticipants, XmlTournament xmlTournament)
			throws XmlReaderException {
		Collection<XmlMatchParticipant> xmlMatchParticipants = new HashSet<XmlMatchParticipant>();
		for (Participant participant : pParticipants.getParticipant()) {
			XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
					participant.getParticipantName(), xmlTournament);
			LOG.debug("Participant name = " + participant.getParticipantName());
			xmlMatchParticipants.add(xmlMatchParticipant);
		}
		return xmlMatchParticipants;
	}

	/**
	 * Gets the special event sport name. En general, un evento especial en el
	 * xml de pinnacle no indica claramente el deporte en el nodo <sporttype>.
	 * Muchas veces ponen el nombre de la competicion. Unos ejemplos son: 'NBA
	 * Series Prices', 'NCAA Football Futures', 'NFL Futures', 'NFL
	 * Propositions', 'NHL Draw', 'NRL Win Margin Props: Week 14', 'Soccer
	 * Futures', 'Soccer Props', 'Tennis: ATP Aegon International', 'Tennis: ATP
	 * Wimbledon', 'Tennis: Fed Cup' etc. Para resolver el nombre del deporte
	 * con mas presicion lo pasamos por un enum en un tipo de 'lookup'.
	 * 
	 * @param pSportName
	 *            the sport name
	 * @return the special event sport name
	 */
	private String getSpecialEventSportName(String pSportName) {
		String sportName = pSportName;
		PinnacleSpecialEventSportName sportNameLookUp = PinnacleSpecialEventSportName
				.getSportNameByValue(pSportName);
		if (sportNameLookUp != null) {
			sportName = sportNameLookUp.getSportName();
		}
		return sportName;
	}

	/**
	 * Gets the sport special event. Nombre del nodo: <sporttype> Posición en
	 * eventContent: 2.
	 * 
	 * @param eventContent
	 *            the event content
	 * @param specialEvent
	 *            the special event
	 * @return the sport special event
	 */
	@SuppressWarnings("rawtypes")
	private XmlSport getSport(List<Object> eventContent, boolean specialEvent) {
		JAXBElement elem = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_SPORTTYPE_INDEX);
		XmlSport xmlSport = new XmlSport();
		String sportName = elem.getValue().toString();
		if (specialEvent) {
			sportName = getSpecialEventSportName(sportName);
		} else {
			sportName = getNormalEventSportName(sportName);
		}
		xmlSport.setName(sportName);
		LOG.debug(new StringBuffer().append("Sport name: ")
				.append(elem.getValue().toString()).toString());
		return xmlSport;
	}

	/**
	 * Gets the tournament special event. Nombre del nodo: <league>. Posición en
	 * eventContent: 3.
	 * 
	 * @param eventContent
	 *            the event content
	 * @return the tournament special event
	 */
	@SuppressWarnings("rawtypes")
	private XmlTournament getTournamentNormalEvent(List<Object> eventContent) {
		JAXBElement elem = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_LEAGUE_INDEX);
		XmlTournament xmlTournament = new XmlTournament();
		xmlTournament.setName(elem.getValue().toString());
		LOG.debug(new StringBuffer().append("Tournament name: ").append(
				elem.getValue().toString()));
		return xmlTournament;
	}

	/**
	 * Gets the tournament special event. Nombre del nodo1: <league>. Posición
	 * en eventContent: 3. Nombre del nodo2: <description>. Posición en
	 * eventContent: 5. El xml de pinnacle indica el nombre de la competicion
	 * para un evento especial o en el nodo <league>, en el nodo <description> o
	 * en ambos, pero siempre con otras palabras. Ejemplo1: 'Division Winners:
	 * Winner of 2013 AL Central' y 'Winner of 2013 AL Central'. Ejemplo2:
	 * 'Player To Win' y 'Player To Win 2013 French Open? (All In)'. Ejemplo3:
	 * '100* Puerto Rico Open: Odds To Win The Tournament' y 'Odds To Win Puerto
	 * Rico Open'.
	 * 
	 * @param eventContent
	 *            the event content
	 * @return the tournament special event
	 */
	@SuppressWarnings("rawtypes")
	private XmlTournament getTournamentSpecialEvent(List<Object> eventContent) {
		XmlTournament xmlTournament = new XmlTournament();
		PinnacleSpecialEventTournamentName stringUtil = new PinnacleSpecialEventTournamentName();
		JAXBElement elemLeauge = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_LEAGUE_INDEX);
		JAXBElement elemDescription = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_DESCRIPTION_INDEX);
		String tournamentName = elemLeauge.getValue().toString();
		String tournamentDescription = elemDescription.getValue().toString();
		tournamentName = stringUtil.getPinncaleTournamentName(tournamentName,
				tournamentDescription);
		xmlTournament.setName(tournamentName);
		LOG.debug(new StringBuffer().append("Tournament name: ").append(
				tournamentName));
		return xmlTournament;
	}

	/**
	 * Gets the xml bet event. Nombre del nodo: <period_description>. Posición
	 * en period: 1.
	 * 
	 * @param period
	 *            the period
	 * @return the xml bet event
	 */
	@SuppressWarnings("rawtypes")
	private XmlBetEvent getXmlBetEvent(Period period) {
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		JAXBElement elem = (JAXBElement) period.getContent().get(
				PinnacleSports.PERIODS_PERIOD_DESCRIPTION_INDEX);
		xmlBetEvent.setBetEvent(BetEventPinnacleSports.getEventByValue(elem
				.getValue().toString()));
		return xmlBetEvent;
	}

	/**
	 * Checks if is active and has odds. El evento tiene apuestas y es activo si
	 * el nodo <period> tenga hijos y el hijo <period_update> tenga valor
	 * "open".
	 * 
	 * @param event
	 *            the event
	 * @return true, if is active and has odds
	 */
	private boolean isActiveAndHasOdds(final Event event) {
		for (Object eventObj : event.getContent()) {
			if (eventObj instanceof Periods) {
				for (Object periodObj : ((Periods) eventObj).getContent()) {
					if (periodObj instanceof Period) {
						if (periodIsActive((Period) periodObj)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks if is live event.
	 * 
	 * @param eventContent
	 *            the event content
	 * @return true, if is live event
	 */
	@SuppressWarnings("rawtypes")
	private boolean isLiveEvent(List<Object> eventContent) {
		boolean isLive = false;
		JAXBElement elem = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_ISLIVE_INDEX);
		if (elem.getValue().toString().equalsIgnoreCase(PinnacleSports.YES)) {
			isLive = true;
		} else if (elem.getValue().toString()
				.equalsIgnoreCase(PinnacleSports.NO)) {
			isLive = false;
		}
		return isLive;
	}

	/**
	 * Checks if is special event. El xml de pinnacle tiene dos estructuras
	 * distintas entre los nodos <event> y </event>. Un evento "normal" tiene
	 * nodos <event_datetimeGMT> <gamenumber> <sporttype> <league> <IsLive>
	 * <participants> <periods>. Un evento "especial" tiene nodos <event>
	 * <event_datetimeGMT> <gamenumber> <sporttype> <league> <contest_maximum>
	 * <description> <participants>. El evento es "especial" si el sexto hijo
	 * del nodo <event> es el nodo <periods>.
	 * 
	 * @param event
	 *            the event
	 * @return true, if is special event
	 */
	private boolean isSpecialEvent(Event event) {
		if (event.getContent().get(PinnacleSports.EVENT_PERIODS_INDEX) instanceof Periods) {
			return false;
		}
		return true;
	}

	/**
	 * Market is handicap set.
	 * 
	 * @param participants
	 *            the participants
	 * @return true, if successful
	 */
	private boolean marketIsHandicapSet(
			Collection<XmlMatchParticipant> participants) {
		boolean result = false;
		Pattern pattern = Pattern.compile("\\([-+][0-9]+.[0-9]+ Sets\\)");
		for (XmlMatchParticipant participant : participants) {
			Matcher matcher = pattern.matcher(participant.getName());
			if (matcher.find()) {
				result = true;
				break;
			}
		}

		return result;
	}

	/**
	 * Match contains bet of type winner. El evento es de tipo Ganador si el
	 * nodo <description> o <league> contiene el string 'win' o 'winner' pero no
	 * el string 'vs' o 'Props', si hay mas de 3 participantes y el nombre del
	 * primer participante no contiene 'Yes', 'Over', 'Mayor' ni ninguna cifra.
	 * 
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	@SuppressWarnings("rawtypes")
	private boolean matchContainsBetOfTypeWinner(Event event) {
		String descripction = ((JAXBElement) event.getContent().get(
				PinnacleSports.EVENT_DESCRIPTION_INDEX)).getValue().toString();
		String league = ((JAXBElement) event.getContent().get(
				PinnacleSports.EVENT_LEAGUE_INDEX)).getValue().toString();
		// Contiene 'win' o 'winner' pero no 'Props' ni 'vs'.
		if ((descripction.toLowerCase(Locale.ENGLISH).contains(
				PinnacleSports.WIN)
				|| descripction.toLowerCase(Locale.ENGLISH).contains(
						PinnacleSports.WINNER)
				|| league.toLowerCase(Locale.ENGLISH).contains(
						PinnacleSports.WIN) || league.toLowerCase(
				Locale.ENGLISH).contains(PinnacleSports.WINNER))
				&& (!descripction.contains(PinnacleSports.VS)
						&& !league.contains(PinnacleSports.VS)
						&& !league.contains(PinnacleSports.PROPS) && !descripction
							.contains(PinnacleSports.PROPS))) {
			for (Object eventObj : event.getContent()) {
				if (eventObj instanceof Participants) {
					List<Participant> listPart = ((Participants) eventObj)
							.getParticipant();
					// Mas de 3 participantes
					if (listPart.size() > 3) {
						String partName = listPart.get(0).getParticipantName();
						// Nombre sin 'Yes', 'Over', 'Mayor' o cifra.
						if (!partName.equalsIgnoreCase(PinnacleSports.YES)
								&& !partName
										.equalsIgnoreCase(PinnacleSports.OVER)
								&& !partName.contains(PinnacleSports.MAYOR)
								&& !partName.matches(".*\\d.*")) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Period is active. El evento es activo si el nodo <period_update> tenga
	 * valor "open" (tambien existe valor "offline"). Solo los eventos de estado
	 * "open" muestran los odds en la página web de pinnacle.
	 * 
	 * @param period
	 *            the period
	 * @return true, if successful
	 */
	@SuppressWarnings("rawtypes")
	private boolean periodIsActive(final Period period) {
		JAXBElement elem = (JAXBElement) period.getContent().get(
				PinnacleSports.PERIOD_PERIOD_UPDATE_INDEX);
		boolean flag = false;
		if (elem.getValue().toString().equalsIgnoreCase(PinnacleSports.OPEN)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Read normal event.
	 * 
	 * @param eventContent
	 *            the event content
	 * @return the xml match
	 * @throws ParseException
	 *             the parse exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	@SuppressWarnings("rawtypes")
	private XmlMatch readNormalEvent(final List<Object> eventContent)
			throws ParseException, XmlReaderException {
		LOG.debug("readEvent()");
		XmlMatch xmlMatch = new XmlMatch();

		// Fecha
		xmlMatch.setStartDate(getMatchDate(eventContent, xmlMatch));

		// Deporte
		XmlSport xmlSport = getSport(eventContent, false);
		boolean specialSport = isSpecialSport(eventContent);

		// Competition
		XmlTournament xmlTournament = getTournamentNormalEvent(eventContent);
		xmlTournament.setXmlSport(xmlSport);
		xmlMatch.setXmlTournament(xmlTournament);

		// Live
		// Nombre del nodo: <IsLive>. Posición en eventContent: 4.
		setIsLive(xmlMatch,
				(JAXBElement) eventContent
						.get(PinnacleSports.EVENT_IS_LIVE_INDEX));

		// Participantes
		// Nombre del nodo: <participants>. Posición en eventContent: 5.
		Participants participants = (Participants) eventContent
				.get(PinnacleSports.EVENT_PARTICIPANTS_INDEX);
		xmlMatch.setXmlMatchParticipants(getParticipantsNormalEvent(
				participants, xmlTournament));

		// Informacion de Markets
		// Nombre del nodo: <periods>. Posición en eventContent: 6.
		Periods periods = (Periods) eventContent
				.get(PinnacleSports.EVENT_PERIODS_INDEX);
		for (Object obj : periods.getContent()) {
			if (obj instanceof Period && periodIsActive((Period) obj)) {
				Period period = (Period) obj;

				// Recorriendo los objetos del contenido del period sacando los
				// tipos de apuesta que se encuentran en los nodos con nombre
				// moneyline, total y spread
				for (Object object : period.getContent()) {
					if (!(object instanceof JAXBElement)) {
						XmlMarket xmlMarket = null;
						if (object instanceof Moneyline) {
							Moneyline moneyline = (Moneyline) object;
							if (moneyline.getMoneylineDraw() == null) {
								if (marketIsHandicapSet(xmlMatch
										.getXmlMatchParticipants())
										&& specialSport) {
									xmlMarket = getMarketSpecialSport(
											moneyline,
											xmlMatch.getXmlMatchParticipants());
								} else {
									xmlMarket = getMarketGanadorPartido(
											moneyline,
											xmlMatch.getXmlMatchParticipants());
								}
							} else if (moneyline.getMoneylineDraw() != null) {
								xmlMarket = getMarketUnoXDos(moneyline,
										xmlMatch.getXmlMatchParticipants());
							}
						} else if (object instanceof Total) {
							Total total = (Total) object;
							xmlMarket = getMarketMasMenos(total);
						} else if (object instanceof Spread && !specialSport) {
							Spread spread = (Spread) object;
							xmlMarket = getMarketHandicapAsiatico(spread,
									xmlMatch.getXmlMatchParticipants());
						}
						if (xmlMarket != null) {
							// BetEvent
							XmlBetEvent xmlBetEvent = getXmlBetEvent(period);
							if (xmlBetEvent.getBetEvent() == null
									|| xmlBetEvent
											.getBetEvent()
											.equals(BetEventPinnacleSports.PARTIDO_COMPLETO)) {
								if (xmlMarket.getXmlBetType().getBetType() == BetTypePinnacleSports.GANADOR_PARTIDO
										|| xmlMarket.getXmlBetType()
												.getBetType() == BetTypePinnacleSports.HANDICAP_ASIATICO
										|| xmlMarket.getXmlBetType()
												.getBetType() == BetTypePinnacleSports.MAS_MENOS) {

									// Etiquetas "Alt OT" y "OT Incl"
									// identifican partidos con prorroga para
									// hockey (NHL)
									if (xmlTournament.getName().toString()
											.contains("Alt OT")
											|| xmlTournament.getName()
													.toString()
													.contains("OT Incl")) {
										xmlBetEvent
												.setBetEvent(BetEventPinnacleSports.PARTIDO_COMPLETO_PRORROGA);
									} else if (PinnacleSpecialEventSportName
											.isBasketball(xmlSport.getName())
											|| PinnacleSpecialEventSportName
													.isBaseball(xmlSport
															.getName())
											|| PinnacleSpecialEventSportName
													.isAmericanFootbal(xmlSport
															.getName())) {
										xmlBetEvent
												.setBetEvent(BetEventPinnacleSports.PARTIDO_COMPLETO_PRORROGA);
									}
								}
							}

							xmlMarket.getXmlBetType().setXmlBetEvent(
									xmlBetEvent);
							xmlMatch.addXmlMarket(xmlMarket);
						}
					}
				}
			}
		}
		return xmlMatch;
	}

	private XmlMarket getMarketSpecialSport(final Object objMoneyline,
			final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		Moneyline moneyline = (Moneyline) objMoneyline;
		XmlMarket result = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		XmlAsianHandicapAttribute xmlAsianHandicapAttribute;
		Double handicapValue;

		LOG.debug("Bet type = HANDICAP");

		xmlBetType.setBetType(BetTypePinnacleSports.HANDICAP_ASIATICO);

		handicapValue = getHandicapValueForParticipant(xmlMatchParticipants);

		result.setXmlBetType(xmlBetType);

		// Home
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		xmlMarketBetHome.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineHome()))));
		xmlAsianHandicapAttribute = new XmlAsianHandicapAttribute();
		xmlAsianHandicapAttribute.setAsianResult(AsianResult.ONE);
		xmlAsianHandicapAttribute.setFirstValue(handicapValue);
		xmlMarketBetHome.setXmlAttribute(xmlAsianHandicapAttribute);
		xmlMarketBetHome
				.setXmlMatchParticipant(getHandicapXmlMatchParticipantSpecialSport(
						xmlMatchParticipants, true));
		result.addXmlBet(xmlMarketBetHome);

		// Away
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		xmlMarketBetAway.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(Short
						.toString(moneyline.getMoneylineVisiting()))));
		xmlAsianHandicapAttribute = new XmlAsianHandicapAttribute();
		xmlAsianHandicapAttribute.setAsianResult(AsianResult.TWO);
		xmlAsianHandicapAttribute.setFirstValue(handicapValue);
		xmlMarketBetAway.setXmlAttribute(xmlAsianHandicapAttribute);
		xmlMarketBetAway
				.setXmlMatchParticipant(getHandicapXmlMatchParticipantSpecialSport(
						xmlMatchParticipants, false));
		result.addXmlBet(xmlMarketBetAway);

		return result;
	}

	private Double getHandicapValueForParticipant(
			final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		Double result = 0d;
		String string;
		XmlMatchParticipant xmlMatchParticipant;
		Integer characterPosition;

		xmlMatchParticipant = getParticipant(xmlMatchParticipants, true);
		characterPosition = xmlMatchParticipant.getName().indexOf("(");
		string = xmlMatchParticipant.getName().substring(characterPosition+1,
				characterPosition + 5);

		result = Double.parseDouble(string);

		return result;
	}

	private XmlMatchParticipant getHandicapXmlMatchParticipantSpecialSport(
			final Collection<XmlMatchParticipant> xmlMatchParticipants,
			final boolean homeParticipant) {
		XmlMatchParticipant result = getParticipant(xmlMatchParticipants,
				homeParticipant);
		result.setName(result.getName().substring(0,
				result.getName().indexOf("(")));
		return result;
	}

	/**
	 * Read special event.
	 * 
	 * @param eventContent
	 *            the event content
	 * @return the xml match
	 * @throws ParseException
	 *             the parse exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	private XmlMatch readSpecialEvent(final List<Object> eventContent)
			throws ParseException, XmlReaderException {
		LOG.debug("readSpecialEvent()");
		XmlMatch xmlMatch = new XmlMatch();

		// Fecha
		xmlMatch.setStartDate(getMatchDate(eventContent, xmlMatch));

		// Deporte
		XmlSport xmlSport = getSport(eventContent, true);

		// Competition
		XmlTournament xmlTournament = getTournamentSpecialEvent(eventContent);
		xmlTournament.setXmlSport(xmlSport);
		xmlMatch.setXmlTournament(xmlTournament);

		// Participantes y el market Ganador
		// Nombre del nodo: <participants>. Posición en eventContent: 6.
		Participants participants = (Participants) eventContent
				.get(PinnacleSports.EVENT_PARTICIPANTS_SPECIAL_INDEX);
		xmlMatch.setXmlMatchParticipants(getSpecialEventParticipants(
				participants, xmlTournament));
		XmlMarket xmlMarket = getMarketGanador(participants,
				xmlMatch.getXmlMatchParticipants());
		xmlMatch.addXmlMarket(xmlMarket);
		return xmlMatch;
	}

	/**
	 * Read xml.
	 * 
	 * @param pFile
	 *            the file
	 * @param cfgBookmakerConfiguration
	 *            the cfg bookmaker configuration
	 * @param pBeanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bookmaker events
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public XmlBookmakerEvents readXml(final InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {
		timeZone = cfgBookmakerConfiguration.getTimeZone();
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		PinnacleLineFeed pinnacleLineFeed = null;
		try {
			pinnacleLineFeed = (PinnacleLineFeed) JaxbUtils.readXML(pFile,
					PinnacleLineFeed.class);
			Events events = pinnacleLineFeed.getEvents();
			List<Event> eventList = events.getEvent();
			for (Event event : eventList) {

				// El xml de pinnacle tiene dos estructuras distintos entre los
				// nodos <event> y </event>. La primera estructura (un evento
				// "normal") incluye los tipos de apuesta 1X2, MasMenos,
				// GanadorPartido, mientras que la segunda estructura (un evento
				// "especial") incluye el tipo de apuesta Ganador.
				XmlMatch xmlMatch = null;
				List<Object> eventContent = event.getContent();

				if (!isSpecialEvent(event) && isActiveAndHasOdds(event)) {
					if (!isLiveEvent(eventContent)) {
						xmlMatch = readNormalEvent(eventContent);
					}
				} else if (isSpecialEvent(event)
						&& matchContainsBetOfTypeWinner(event)) {
					xmlMatch = readSpecialEvent(eventContent);
				}

				if (xmlMatch != null) {
					// Id para la descarga del proximo xml
					xmlMatch.setAbstractBeanParameters(getBeanParameterPinnacle(pinnacleLineFeed));

					xmlBookmakerEvents.addXmlMatch(xmlMatch);
				}
				if (xmlMatch != null) {
					String name = ((JAXBElement) eventContent
							.get(PinnacleSports.EVENT_LEAGUE_INDEX)).getValue()
							.toString();
					xmlMatch.setName(name);
				}
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(errorMessage, e);
		} catch (ParseException e) {
			String errorMessage = new StringBuffer(
					"Error al parsear una fecha en el xml: ")
					.append(JaxbUtils.writeXML(pinnacleLineFeed,
							PinnacleLineFeed.class)).toString();
			LOG.error(errorMessage, e);
		}
		return xmlBookmakerEvents;
	}

	private boolean isSpecialSport(final List<Object> eventContent) {
		boolean flag = false;
		JAXBElement elem = (JAXBElement) eventContent
				.get(PinnacleSports.EVENT_SPORTTYPE_INDEX);
		String sportName = elem.getValue().toString();
		if (sportName.equals(PinnacleSports.TENNIS)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Sets the is live.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @param elem
	 *            the elem
	 */
	@SuppressWarnings("rawtypes")
	private void setIsLive(final XmlMatch xmlMatch, final JAXBElement elem) {
		if (elem.getValue().toString().equalsIgnoreCase(PinnacleSports.YES)) {
			xmlMatch.setLive(true);
		} else if (elem.getValue().toString()
				.equalsIgnoreCase(PinnacleSports.NO)) {
			xmlMatch.setLive(false);
		}
	}

}
