/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betfred;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetFred;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetFred;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred.Bet;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred.Bettype;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred.Category;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class XMLBetFredFileReader.
 */
@Component
public class XMLBetFredFileReader extends AbstractXmlFilereader implements
		MarketType {

	/** The Constant AWAY. */
	private static final String AWAY = "AWAY";

	/** The Constant BETFRED_1X2_BETTYPE_SEPARATOR. */
	private static final String BETFRED_1X2_BETTYPE_SEPARATOR = " V ";

	/** The Constant BETFRED_PARTICIPANT_SEPARATOR_1. */
	private static final String BETFRED_PARTICIPANT_SEPARATOR_1 = " v ";

	/** The Constant BETFRED_PARTICIPANT_SEPARATOR_2. */
	private static final String BETFRED_PARTICIPANT_SEPARATOR_2 = " @ ";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyyMMdd";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_TIME_FORMAT = "yyyyMMddHHmm";

	/** The Constant DRAW. */
	private static final String DRAW = "DRAW";

	/** The Constant HOME. */
	private static final String HOME = "HOME";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XMLBetFredFileReader.class);

	/** The Constant OVER. */
	private static final String OVER = "Over";

	/** The Constant UNDER. */
	private static final String UNDER = "Under";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#getBookmakerId()
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BETFRED_COM_ID.objectId().toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketGanador(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketGanador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarketBet xmlBet;
		XmlMatchParticipant participant;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			participant = getParticipantByName(xmlMatchParticipants,
					bet.getName());
			xmlBet = new XmlMarketBet();
			xmlBet.setXmlMatchParticipant(participant);
			xmlBet.setXmlAttribute(new XmlWinnerAttribute(participant));
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketGanadorPartido(java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketGanadorPartido(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarketBet xmlBet;
		XmlMatchParticipant participant;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			xmlBet = new XmlMarketBet();
			if (bet.getHadValue() != null) {
				if (bet.getHadValue().equals(HOME)) {
					participant = getParticipant(xmlMatchParticipants, true);
					xmlBet.setXmlAttribute(new XmlMatchWinnerAttribute(
							Result.ONE, participant));
					xmlBet.setXmlMatchParticipant(participant);
				} else if (bet.getHadValue().equals(AWAY)) {
					participant = getParticipant(xmlMatchParticipants, false);
					xmlBet.setXmlAttribute(new XmlMatchWinnerAttribute(
							Result.TWO, participant));
					xmlBet.setXmlMatchParticipant(participant);
				}
			} else {
				participant = getParticipantByName(xmlMatchParticipants,
						bet.getName());
				if (participant.isHomeParticipant()) {
					xmlBet.setXmlAttribute(new XmlMatchWinnerAttribute(
							Result.ONE, participant));
				} else if (participant.isAwayParticipant()) {
					xmlBet.setXmlAttribute(new XmlMatchWinnerAttribute(
							Result.TWO, participant));
				}
				xmlBet.setXmlMatchParticipant(participant);
			}
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketHandicapAsiatico(java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketHandicapAsiatico(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarketBet xmlBet;
		XmlMatchParticipant participant;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			xmlBet = new XmlMarketBet();
			if (bet.getHadValue().equals(HOME)) {
				participant = getParticipant(xmlMatchParticipants, true);
				xmlBet.setXmlAttribute(new XmlAsianHandicapAttribute(
						AsianResult.ONE, Double.valueOf(betType.getHandicap())));
				xmlBet.setXmlMatchParticipant(participant);
			} else if (bet.getHadValue().equals(AWAY)) {
				participant = getParticipant(xmlMatchParticipants, false);
				xmlBet.setXmlAttribute(new XmlAsianHandicapAttribute(
						AsianResult.TWO, Double.valueOf(betType.getHandicap())));
				xmlBet.setXmlMatchParticipant(participant);
			}
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketMasMenos(java.lang.Object)
	 */
	@Override
	public XmlMarket getMarketMasMenos(Object market) throws XmlReaderException {
		XmlMarketBet xmlBet;
		Double totalGoalValue;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			xmlBet = new XmlMarketBet();
			totalGoalValue = Double.valueOf(bet.getName().split(" ")[1].trim());
			if (bet.getName().contains(OVER)) {
				xmlBet.setXmlAttribute(new XmlMoreLessAttribute(MasMenos.MAS,
						totalGoalValue));
			} else if (bet.getName().contains(UNDER)) {
				xmlBet.setXmlAttribute(new XmlMoreLessAttribute(MasMenos.MENOS,
						totalGoalValue));
			}
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketMaximoGoleador(java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketMaximoGoleador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarketBet xmlBet;
		XmlMatchParticipant participant;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		XmlTournament tournament = xmlMatchParticipants.iterator().next()
				.getXmlTournament();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			participant = new XmlMatchParticipant(bet.getName(), tournament);
			xmlBet = new XmlMarketBet();
			xmlBet.setXmlMatchParticipant(participant);
			xmlBet.setXmlAttribute(new XmlMaximumGoalerAttribute(participant));
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketUnoXDos(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketUnoXDos(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarketBet xmlBet;
		XmlMatchParticipant participant;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			xmlBet = new XmlMarketBet();
			if (bet.getHadValue().equals(HOME)) {
				participant = getParticipant(xmlMatchParticipants, true);
				xmlBet.setXmlAttribute(new Xml1X2Attribute(Result.ONE));
				xmlBet.setXmlMatchParticipant(participant);
			} else if (bet.getHadValue().equals(AWAY)) {
				participant = getParticipant(xmlMatchParticipants, false);
				xmlBet.setXmlAttribute(new Xml1X2Attribute(Result.TWO));
				xmlBet.setXmlMatchParticipant(participant);
			} else if (bet.getHadValue().equals(DRAW)) {
				xmlBet.setXmlAttribute(new Xml1X2Attribute(Result.DRAW));
				xmlBet.setXmlMatchParticipant(getDrawParticipant());
			}
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .MarketType#getMarketUnoXDosHandicap(java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarketBet xmlBet;
		XmlMatchParticipant participant;
		Bettype betType = (Bettype) market;
		XmlMarket result = new XmlMarket();
		Collection<XmlMarketBet> xmlBets = new ArrayList<XmlMarketBet>();

		for (Bet bet : betType.getBet()) {
			xmlBet = new XmlMarketBet();
			if (bet.getHadValue().equals(HOME)) {
				participant = getParticipant(xmlMatchParticipants, true);
				xmlBet.setXmlAttribute(new Xml1X2HandicapAttribute(Result.ONE,
						Double.valueOf(betType.getHandicap())));
				xmlBet.setXmlMatchParticipant(participant);
			} else if (bet.getHadValue().equals(AWAY)) {
				participant = getParticipant(xmlMatchParticipants, false);
				xmlBet.setXmlAttribute(new Xml1X2HandicapAttribute(Result.TWO,
						Double.valueOf(betType.getHandicap())));
				xmlBet.setXmlMatchParticipant(participant);
			} else if (bet.getHadValue().equals(DRAW)) {
				xmlBet.setXmlAttribute(new Xml1X2HandicapAttribute(Result.DRAW,
						Double.valueOf(betType.getHandicap())));
				xmlBet.setXmlMatchParticipant(getDrawParticipant());
			}
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(bet.getPriceDecimal()
					.toString(), bet.getPriceUS().toString(), bet.getPrice()
					.toString()));
			xmlBets.add(xmlBet);
		}

		result.setXmlMarketBets(xmlBets);
		return result;
	}

	/**
	 * Checks if is short term.
	 * 
	 * @param event
	 *            the event
	 * @return the boolean
	 */
	private Boolean isShortTerm(Event event) {
		return event.getName().contains(BETFRED_PARTICIPANT_SEPARATOR_1)
				|| event.getName().contains(BETFRED_PARTICIPANT_SEPARATOR_2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#read(java.io.InputStream,
	 * com.comparadorad.bet.comparer
	 * .model.config.bean.bmconf.CfgBookmakerConfiguration)
	 */
	@Override
	public XmlBookmakerEvents readXml(InputStream pFile,
			final CfgBookmakerConfiguration bookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Category category = null;
		try {
			XmlMatch xmlMatch;
			category = (Category) JaxbUtils.readXML(pFile, Category.class);

			for (Event event : category.getEvent()) {
				// Creo el date
				XmlDate xmlDate = resolveDate(event,
						bookmakerConfiguration.getTimeZone());

				if (isShortTerm(event)) {
					xmlMatch = resolveEventShortTerm(category, event, xmlDate);
					if (!xmlMatch.getXmlMarkets().isEmpty()) {
						xmlBookmakerEvents.addXmlMatch(xmlMatch);
					}
				} else {
					Collection<XmlMatch> matchs = resolveEventsLongTerm(
							category, event, xmlDate);
					for (XmlMatch match : matchs) {
						if (!match.getXmlMarkets().isEmpty()) {
							xmlBookmakerEvents.addXmlMatch(match);
						}
					}
				}
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(errorMessage, e);
		} catch (XmlReaderException e) {
			LOG.error("El xml no ha sido leido correctamente", e);
		} catch (Exception e) {
			String errorMessage = new StringBuffer("Error parseando el xml: ")
					.append(JaxbUtils.writeXML(category, Category.class))
					.toString();
			LOG.error(errorMessage, e);
		}

		if (xmlBookmakerEvents.getXmlMatchs() != null
				&& !xmlBookmakerEvents.getXmlMatchs().isEmpty()) {
			LOG.debug(new StringBuffer("Se generan ")
					.append(xmlBookmakerEvents.getXmlMatchs().size())
					.append(" partidos.").toString());
		}

		return xmlBookmakerEvents;
	}

	/**
	 * Resolve bet type.
	 * 
	 * @param event
	 *            the event
	 * @param betType
	 *            the bet type
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(Event event, Bettype betType) {
		XmlBetType xmlBetType = new XmlBetType();
		IBetType matchBetType = BetTypeBetFred
				.getTypeByValue(betType.getName());

		if (matchBetType != null) {
			xmlBetType.setBetType(matchBetType);

			if (xmlBetType.getBetType().equals(BetTypeBetFred.UNO_X_DOS)) {
				if (betType.getBet().size() == 2) {
					if (LOG.isDebugEnabled()) {
						LOG.debug("La apuesta se habia marcado como 1x2 pero solo tiene 2 participantes con lo que se marca como ganador partido");
					}
					xmlBetType.setBetType(BetTypeBetFred.GANADOR_PARTIDO);
				}
			} else if (xmlBetType.getBetType().equals(
					BetTypeBetFred.UNO_X_DOS_HANDICAP)) {
				if (betType.getBet().size() == 2) {
					if (LOG.isDebugEnabled()) {
						LOG.debug("La apuesta se habia marcado como 1x2Handicap pero solo tiene 2 participantes con lo que se marca como handicap asiatico");
					}
					xmlBetType.setBetType(BetTypeBetFred.HANDICAP_ASIATICO);
				}
			}
		} else {
			if (betType.getName().contains(BETFRED_1X2_BETTYPE_SEPARATOR)
					&& betType.getBet().size() == 3) {
				xmlBetType.setBetType(BetTypeBetFred.UNO_X_DOS);
			} else if (betType.getName()
					.contains(BETFRED_1X2_BETTYPE_SEPARATOR)
					&& betType.getBet().size() == 2
					&& !betType.getName().contains("+")) {
				xmlBetType.setBetType(BetTypeBetFred.GANADOR_PARTIDO);
			} else if (betType.getName().contains("Run Line")) {
				xmlBetType.setBetType(BetTypeBetFred.HANDICAP_ASIATICO);
			}
		}

		return xmlBetType;
	}

	/**
	 * Resolve bet type event.
	 * 
	 * @param betType
	 *            the bet type
	 * @return the xml bet event
	 */
	private XmlBetEvent resolveBetTypeEvent(Bettype betType) {
		XmlBetEvent result = new XmlBetEvent();
		result.setBetEvent(BetEventBetFred.getEventByValue(betType.getName()));
		if (result.getBetEvent() == null) {
			result.setBetEvent(BetEventBetFred.PARTIDO_COMPLETO);
		}
		return result;
	}

	/**
	 * Resolve bet type event.
	 * 
	 * @param betType
	 *            the bet type
	 * @return the xml bet event
	 */
	private XmlBetEvent resolveBetTypeEventShortTerm(XmlBetType betType,
			Bettype bettype, XmlSport sport) {
		XmlBetEvent result = new XmlBetEvent();
		result.setBetEvent(BetEventBetFred.getEventByValue(bettype.getName()));
		// Caso de partido completo o valor nulo
		if (result.getBetEvent() == null
				|| result.getBetEvent()
						.equals(BetEventBetFred.PARTIDO_COMPLETO)) {

			if (SportBetFredResolver.isAmericanFootball(sport.getName())
					|| SportBetFredResolver.isBaseball(sport.getName())
					|| SportBetFredResolver.isBasketball(sport.getName())) {
				if (betType.getBetType().equals(BetTypeBetFred.GANADOR_PARTIDO)
						|| betType.getBetType().equals(
								BetTypeBetFred.HANDICAP_ASIATICO)
						|| betType.getBetType()
								.equals(BetTypeBetFred.MAS_MENOS)) {
					result.setBetEvent(BetEventBetFred.PARTIDO_COMPLETO_PRORROGA);
				}
			} else if (SportBetFredResolver.isIceHockey(sport.getName())) {
				if (betType.getBetType().equals(BetTypeBetFred.GANADOR_PARTIDO)) {
					result.setBetEvent(BetEventBetFred.PARTIDO_COMPLETO_PRORROGA);
				}
			} else {
				result.setBetEvent(BetEventBetFred.PARTIDO_COMPLETO);
			}

		}

		return result;
	}

	/**
	 * Resolve date.
	 * 
	 * @param event
	 *            the event
	 * @param timeZone
	 *            the time zone
	 * @return the xml date
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	private XmlDate resolveDate(Event event, String timeZone)
			throws XmlReaderException {
		XmlDate xmlDate = null;
		try {
			if (event.getDate().equals("") && event.getTime().equals("")) {
				xmlDate = getStartDate("210001010000", DATE_FORMAT, timeZone);
			} else {
				if (event.getTime().isEmpty()) {
					xmlDate = getStartDate(
							new StringBuffer(String.valueOf(event.getDate()))
									.toString(),
							DATE_FORMAT, timeZone);
				} else {
					xmlDate = getStartDate(
							new StringBuffer(String.valueOf(event.getDate()))
									.append(String.valueOf(event.getTime()))
									.toString(), DATE_TIME_FORMAT, timeZone);
				}
			}
		} catch (ParseException e) {
			LOG.error("La fecha no se ha resuelto correctamente");
			throw new XmlReaderException("", e);
		}
		return xmlDate;
	}

	/**
	 * Resolve event short term.
	 * 
	 * @param category
	 *            the category
	 * @param event
	 *            the event
	 * @param xmlDate
	 *            the xml date
	 * @return the xml match
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	private XmlMatch resolveEventShortTerm(Category category, Event event,
			XmlDate xmlDate) throws XmlReaderException {
		LOG.debug("Se comienza a leer un XmlMatch");

		XmlMatch result = null;
		XmlTournament xmlTournament;

		// Creo el xmlTournament para cada xmlMatch
		xmlTournament = resolveTournamentShortTerm(event, category);

		// Creo el xmlMatch
		result = new XmlMatch(event.getName(), xmlTournament, xmlDate);
		LOG.debug(new StringBuffer("Se esta leyendo el partido: ").append(
				result.getName()).toString());

		// Creo los participantes
		Collection<XmlMatchParticipant> xmlMatchParticipants = resolveShortTermParticipants(
				event, xmlTournament);
		result.setXmlMatchParticipants(xmlMatchParticipants);

		// Creo los XmlMarkets
		Collection<XmlMarket> xmlMarkets = new ArrayList<XmlMarket>();
		XmlMarket xmlMarket = null;
		for (Bettype betType : event.getBettype()) {
			// Resuelvo el tipo de apuesta
			XmlBetType xmlBetType = resolveBetType(event, betType);
			XmlBetEvent xmlBetEvent = resolveBetTypeEventShortTerm(xmlBetType,
					betType, xmlTournament.getXmlSport());
			if (xmlBetType.getBetType() != null) {

				if (xmlBetType.getBetType().equals(BetTypeBetFred.UNO_X_DOS)
						&& (betType.getBet().size() == 3)) {
					xmlMarket = getMarketUnoXDos(betType, xmlMatchParticipants);
				} else if (xmlBetType.getBetType().equals(
						BetTypeBetFred.GANADOR_PARTIDO)
						&& (betType.getBet().size() == 2)) {
					xmlMarket = getMarketGanadorPartido(betType,
							xmlMatchParticipants);
				} else if (xmlBetType.getBetType().equals(
						BetTypeBetFred.UNO_X_DOS_HANDICAP)
						&& (betType.getBet().size() == 3)) {
					xmlMarket = getMarketUnoXDosHandicap(betType,
							xmlMatchParticipants);
				} else if (xmlBetType.getBetType().equals(
						BetTypeBetFred.HANDICAP_ASIATICO)
						&& (betType.getBet().size() == 2)) {
					xmlMarket = getMarketHandicapAsiatico(betType,
							xmlMatchParticipants);
				} else if (xmlBetType.getBetType().equals(
						BetTypeBetFred.MAS_MENOS)
						&& (betType.getBet().size() == 2)) {
					xmlMarket = getMarketMasMenos(betType);
				} else if (xmlBetType.getBetType().equals(
						BetTypeBetFred.MAXIMO_GOLEADOR)) {
					xmlMarket = getMarketMaximoGoleador(betType,
							xmlMatchParticipants);
				}

				xmlBetType.setXmlBetEvent(xmlBetEvent);
				if (xmlMarket != null) {
					xmlMarket.setXmlBetType(xmlBetType);
					xmlMarkets.add(xmlMarket);
					LOG.debug(new StringBuffer("Se resuelve un mercado tipo ")
							.append(xmlBetType.getBetType().getId()).toString());
				}
			}
		}
		result.setXmlMarkets(xmlMarkets);

		return result;
	}

	/**
	 * Resolve events long term.
	 * 
	 * @param category
	 *            the category
	 * @param event
	 *            the event
	 * @param xmlDate
	 *            the xml date
	 * @return the collection
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	private Collection<XmlMatch> resolveEventsLongTerm(Category category,
			Event event, XmlDate xmlDate) throws XmlReaderException {
		Collection<XmlMatch> result = new ArrayList<XmlMatch>();
		XmlMatch xmlMatch;
		XmlTournament xmlTournament;
		for (Bettype betType : event.getBettype()) {
			xmlTournament = resolveTournamentLongTerm(category, event, betType);
			xmlMatch = new XmlMatch(xmlTournament.getName(), xmlTournament,
					xmlDate);
			Collection<XmlMatchParticipant> xmlMatchParticipants = resolveLongTermParticipants(
					betType.getBet(), xmlTournament);
			xmlMatch.setXmlMatchParticipants(xmlMatchParticipants);
			XmlBetType xmlBetType = resolveBetType(event, betType);
			XmlBetEvent xmlBetEvent = resolveBetTypeEvent(betType);
			XmlMarket xmlMarket = null;
			Collection<XmlMarket> xmlMarkets = new ArrayList<XmlMarket>();
			if (xmlBetType.getBetType() != null) {
				xmlBetType.setXmlBetEvent(xmlBetEvent);
				if (xmlBetType.getBetType().equals(BetTypeBetFred.GANADOR)) {
					xmlMarket = getMarketGanador(betType, xmlMatchParticipants);
				} else if (xmlBetType.getBetType().equals(
						BetTypeBetFred.MAXIMO_GOLEADOR)) {
					xmlMarket = getMarketMaximoGoleador(betType,
							xmlMatchParticipants);
				}
				// TODO para los casos en que sea largo plazo (To Qualify) quien
				// se va a clasificar
				// else if (xmlBetType.getBetType().equals(
				// BetTypeBetFred.GANADOR_PARTIDO)) {
				// xmlMarket = getMarketGanadorPartido(betType,
				// xmlMatchParticipants);
				// } else if (xmlBetType.getBetType().equals(
				// BetTypeBetFred.UNO_X_DOS)) {
				// xmlMarket = getMarketUnoXDos(betType, xmlMatchParticipants);
				// }
				if (xmlMarket != null) {
					xmlMarket.setXmlBetType(xmlBetType);
					xmlMarkets.add(xmlMarket);
					xmlMatch.setXmlMarkets(xmlMarkets);
					LOG.debug(new StringBuffer("Se resuelve un mercado tipo ")
							.append(xmlBetType.getBetType().getId()).toString());
					result.add(xmlMatch);
				}
			}
		}
		return result;
	}

	/**
	 * Resolve long term participants.
	 * 
	 * @param bets
	 *            the bets
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the collection
	 */
	private Collection<XmlMatchParticipant> resolveLongTermParticipants(
			List<Bet> bets, XmlTournament xmlTournament) {
		Collection<XmlMatchParticipant> result = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant participant;
		for (Bet bet : bets) {
			participant = new XmlMatchParticipant(bet.getName(), xmlTournament);
			if (bet.getHadValue() != null && bet.getHadValue().equals(HOME)) {
				participant.setHomeParticipant(true);
				participant.setAwayParticipant(false);
			} else if (bet.getHadValue() != null
					&& bet.getHadValue().equals(AWAY)) {
				participant.setHomeParticipant(false);
				participant.setAwayParticipant(true);
			}
			result.add(participant);
		}
		return result;
	}

	/**
	 * Resolve participants.
	 * 
	 * @param event
	 *            the event
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the collection
	 */
	private Collection<XmlMatchParticipant> resolveShortTermParticipants(
			Event event, XmlTournament xmlTournament) {
		Collection<XmlMatchParticipant> result = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant participant;

		if (event.getName().contains(BETFRED_PARTICIPANT_SEPARATOR_1)) {
			participant = new XmlMatchParticipant(event.getName().split(
					BETFRED_PARTICIPANT_SEPARATOR_1)[0], true, false,
					xmlTournament);
			result.add(participant);
			participant = new XmlMatchParticipant(event.getName().split(
					BETFRED_PARTICIPANT_SEPARATOR_1)[1], false, true,
					xmlTournament);
			result.add(participant);
		} else if (event.getName().contains(BETFRED_PARTICIPANT_SEPARATOR_2)) {
			participant = new XmlMatchParticipant(event.getName().split(
					BETFRED_PARTICIPANT_SEPARATOR_2)[0], false, true,
					xmlTournament);
			result.add(participant);
			participant = new XmlMatchParticipant(event.getName().split(
					BETFRED_PARTICIPANT_SEPARATOR_2)[1], true, false,
					xmlTournament);
			result.add(participant);
		}
		return result;
	}

	/**
	 * Gets the sport name.
	 * 
	 * @param category
	 *            the category
	 * @return the sport name
	 */
	private XmlSport resolveSport(Category category) {
		String sportName = category.getName();
		XmlSport result = new XmlSport();
		if (sportName.contains("-")) {
			sportName = sportName.split("-")[0];
		}
		result.setName(sportName);
		LOG.debug(new StringBuffer("Creo un xmlSport con nombre ")
				.append(sportName));
		return result;
	}

	/**
	 * Resolve tournament long term.
	 * 
	 * @param category
	 *            the category
	 * @param event
	 *            the event
	 * @param betType
	 *            the bet type
	 * @return the xml tournament
	 */
	private XmlTournament resolveTournamentLongTerm(Category category,
			Event event, Bettype betType) {
		XmlSport sport = resolveSport(category);
		String nameTournament;
		if (betType.getName().contains(BETFRED_1X2_BETTYPE_SEPARATOR)) {
			nameTournament = event.getName();
		} else {
			nameTournament = new StringBuffer(event.getName()).append(" ")
					.append(betType.getName()).toString();
		}
		XmlTournament result = new XmlTournament(nameTournament);
		result.setXmlSport(sport);
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer("Creo un xmlTournament con nombre ")
					.append(result.getName()));
		}
		return result;
	}

	/**
	 * Resolve tournament.
	 * 
	 * @param event
	 *            the event
	 * @param category
	 *            the category
	 * @return the xml tournament
	 */
	private XmlTournament resolveTournamentShortTerm(Event event,
			Category category) {
		XmlSport sport = resolveSport(category);
		XmlTournament result = new XmlTournament(category.getName());
		result.setXmlSport(sport);
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer("Creo un xmlTournament con nombre ")
					.append(result.getName()));
		}
		return result;
	}
}
