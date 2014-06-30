/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenHandicapUtil.getFirstHandicap;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenHandicapUtil.getSecondHandicap;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenOverUnderUtil.getOverUnderAttribute;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenUtil.betGroupToString;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenUtil.groupBet;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE.EVENT;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE.EVENT.BET;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLInterwettenFileReader.
 * 
 * Este reader consta de tres partes.
 * 
 * 1) El reader recupera todas las bets de un evento y las agrupa en lista de
 * listas de bets cada lista de lista es un mercado y va agrupado en funcion del
 * typeId.
 * 
 * 2) Resolvemos el tipo de mercado evento y las apuestas (cuotas, nombre de
 * bettype, etc)
 * 
 * 3) Se mergean los mercados que tengan mismo bettype y mismo bettypeevent
 * dejando en una sola lista todas sus bets.
 * 
 */
@Component
public class XMLInterwettenFileReader extends AbstractXmlFilereader implements
		MarketType {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Read name.
	 * 
	 * @param origName
	 *            the orig name
	 * @param longTermEvent
	 *            the long term event
	 * @return the string
	 */
	private static String readName(final String origName, boolean longTermEvent) {
		String result;
		if (longTermEvent) {
			result = origName;
		} else {
			result = origName.replace("-", "vs");
		}

		return result;
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.INTERWETTEN_COM_ID.objectId()
				.toString();
	}

	/**
	 * Gets the market ganador.
	 * 
	 * @param object
	 *            the object
	 * @param participants
	 *            the participants
	 * @return the market ganador
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XmlMarket getMarketGanador(Object object,
			Collection<XmlMatchParticipant> participants) {

		XmlMarket market = new XmlMarket();
		XmlTournamentEvent tournamentEvent = new XmlTournamentEvent();
		XmlWinnerAttribute winnerAttribute;
		XmlMatchParticipant matchParticipant;
		XmlMarketBet marketBet;
		LongTerm longTerm = new LongTerm();

		List<BET> bets = (List<BET>) object;

		XmlTournament tournament = getTournamentFromParticipants(participants);

		longTerm.setLongTerm(Boolean.TRUE);
		tournamentEvent.setLongTerm(longTerm);

		for (BET bet : bets) {
			matchParticipant = new XmlMatchParticipant(bet.getPLAYER2().trim(),
					tournament);

			winnerAttribute = new XmlWinnerAttribute();
			winnerAttribute.setWinner(matchParticipant);
			winnerAttribute.setName(matchParticipant.getName());

			marketBet = new XmlMarketBet();
			marketBet.setXmlAttribute(winnerAttribute);
			marketBet.setXmlMarketBetOdd(normalizeXmlOdd(bet.getQUOTE()));
			marketBet.setXmlMatchParticipant(matchParticipant);
			market.addXmlBet(marketBet);
		}

		return market;
	}

	/**
	 * Gets the market ganador partido.
	 * 
	 * @param object
	 *            the object
	 * @param participants
	 *            the participants
	 * @return the market ganador partido
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XmlMarket getMarketGanadorPartido(Object object,
			Collection<XmlMatchParticipant> participants) {

		XmlMarket market = new XmlMarket();
		XmlMatchWinnerAttribute xmlMatchWinnerAttribute;
		XmlMatchParticipant homeParticipant = null;
		XmlMatchParticipant awayParticipant = null;
		XmlMarketBet marketBet;

		List<BET> bets = (List<BET>) object;

		for (BET bet : bets) {

			marketBet = new XmlMarketBet();
			xmlMatchWinnerAttribute = new XmlMatchWinnerAttribute();

			if (getResultType(bet).equals(Result.ONE)) {
				homeParticipant = getParticipant(participants, true);
				xmlMatchWinnerAttribute.setResult(Result.ONE);
				xmlMatchWinnerAttribute.setWinnerName(homeParticipant);
				marketBet.setXmlMatchParticipant(homeParticipant);
			} else if (getResultType(bet).equals(Result.TWO)) {
				awayParticipant = getParticipant(participants, false);
				xmlMatchWinnerAttribute.setResult(Result.TWO);
				xmlMatchWinnerAttribute.setWinnerName(awayParticipant);
				marketBet.setXmlMatchParticipant(awayParticipant);
			}
			marketBet.setXmlAttribute(xmlMatchWinnerAttribute);
			marketBet.setXmlMarketBetOdd(normalizeXmlOdd(bet.getQUOTE()));
			market.addXmlBet(marketBet);
		}

		return market;
	}

	/**
	 * Gets the market handicap asiatico.
	 * 
	 * @param object
	 *            the object
	 * @param participants
	 *            the participants
	 * @return the market handicap asiatico
	 * @throws InterwettenUnknowHandicapNodeStructureException
	 *             the interwetten unknow handicap exception
	 * @throws InterwettenHandicapException
	 *             the interwetten handicap exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XmlMarket getMarketHandicapAsiatico(Object object,
			Collection<XmlMatchParticipant> participants)
			throws InterwettenUnknowHandicapNodeStructureException,
			InterwettenHandicapException {

		XmlMarket market = new XmlMarket();
		XmlAsianHandicapAttribute attribute;
		XmlMarketBet marketBet;
		Double asianHandicap;

		List<BET> bets = (List<BET>) object;
		asianHandicap = getFirstHandicap(bets);

		if (asianHandicap != 0 && asianHandicap != 0.0) {

			for (BET bet : bets) {
				attribute = new XmlAsianHandicapAttribute();
				marketBet = new XmlMarketBet();
				if (getResultType(bet).equals(Result.ONE)) {
					attribute.setAsianResult(AsianResult.ONE);
					marketBet.setXmlMatchParticipant(getParticipant(
							participants, true));
				} else if (getResultType(bet).equals(Result.TWO)) {
					attribute.setAsianResult(AsianResult.TWO);
					marketBet.setXmlMatchParticipant(getParticipant(
							participants, false));
				}
				attribute.setFirstValue(asianHandicap);
				marketBet.setXmlAttribute(attribute);
				marketBet.setXmlMarketBetOdd(normalizeXmlOdd(bet.getQUOTE()));
				market.addXmlBet(marketBet);
			}
		}

		return market;
	}

	/**
	 * Gets the market mas menos.
	 * 
	 * @param object
	 *            the object
	 * @return the market mas menos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XmlMarket getMarketMasMenos(Object object) {

		XmlMarket market = new XmlMarket();
		XmlMoreLessAttribute attribute;
		XmlMarketBet marketBet;

		List<BET> bets = (List<BET>) object;

		for (BET bet : bets) {
			marketBet = new XmlMarketBet();
			attribute = getOverUnderAttribute(bet);
			marketBet.setXmlAttribute(attribute);
			marketBet.setXmlMarketBetOdd(normalizeXmlOdd(bet.getQUOTE()));
			market.addXmlBet(marketBet);
		}

		return market;
	}

	/**
	 * Gets the market maximo goleador.
	 * 
	 * @param pMarket
	 *            the market
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market maximo goleador
	 */
	@Override
	public XmlMarket getMarketMaximoGoleador(Object pMarket,
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the market uno x dos.
	 * 
	 * @param object
	 *            the object
	 * @param participants
	 *            the participants
	 * @return the market uno x dos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XmlMarket getMarketUnoXDos(Object object,
			Collection<XmlMatchParticipant> participants) {

		XmlMarket market = new XmlMarket();
		Xml1X2Attribute xml1x2Attribute;
		XmlMarketBet marketBet;

		List<BET> bets = (List<BET>) object;

		for (BET bet : bets) {
			marketBet = new XmlMarketBet();
			xml1x2Attribute = new Xml1X2Attribute();
			if (getResultType(bet).equals(Result.ONE)) {
				xml1x2Attribute.setResult(Result.ONE);
				marketBet.setXmlMatchParticipant(getParticipant(participants,
						true));
			} else if (getResultType(bet).equals(Result.DRAW)) {
				xml1x2Attribute.setResult(Result.DRAW);
			} else if (getResultType(bet).equals(Result.TWO)) {
				xml1x2Attribute.setResult(Result.TWO);
				marketBet.setXmlMatchParticipant(getParticipant(participants,
						false));
			}
			marketBet.setXmlAttribute(xml1x2Attribute);
			marketBet.setXmlMarketBetOdd(normalizeXmlOdd(bet.getQUOTE()));
			market.addXmlBet(marketBet);
		}

		return market;
	}

	/**
	 * Gets the market uno x dos handicap.
	 * 
	 * @param object
	 *            the object
	 * @param participants
	 *            the participants
	 * @return the market uno x dos handicap
	 * @throws InterwettenUnknowHandicapNodeStructureException
	 *             the interwetten unknow handicap exception
	 * @throws InterwettenHandicapException
	 *             the interwetten handicap exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object object,
			Collection<XmlMatchParticipant> participants)
			throws InterwettenUnknowHandicapNodeStructureException,
			InterwettenHandicapException {

		XmlMarket market = new XmlMarket();
		Xml1X2HandicapAttribute attribute;
		XmlMarketBet marketBet;
		Double firstHandicap;
		Double secondHandicap;

		List<BET> bets = (List<BET>) object;

		firstHandicap = getFirstHandicap(bets);
		secondHandicap = getSecondHandicap(bets);

		for (BET bet : bets) {
			marketBet = new XmlMarketBet();
			attribute = new Xml1X2HandicapAttribute();

			switch (getResultType(bet)) {
			case ONE:
				marketBet.setXmlMatchParticipant(getParticipant(participants,
						true));
				attribute.setResult(Result.ONE);
				break;
			case DRAW:
				attribute.setResult(Result.DRAW);
				break;
			case TWO:
				marketBet.setXmlMatchParticipant(getParticipant(participants,
						false));
				attribute.setResult(Result.TWO);
				break;
			}
			attribute.setFirstValue(firstHandicap);
			attribute.setSecondValue(secondHandicap);
			marketBet.setXmlAttribute(attribute);
			marketBet.setXmlMarketBetOdd(normalizeXmlOdd(bet.getQUOTE()));
			market.addXmlBet(marketBet);
		}

		return market;
	}

	/**
	 * Gets the result type.
	 * 
	 * @param bet
	 *            the bet
	 * @return the result type
	 */
	private Result getResultType(final BET bet) {
		Result result = null;
		if (bet.getTIP().equals("1")) {
			result = Result.ONE;
		} else if (bet.getTIP().equals("X")) {
			result = Result.DRAW;
		} else if (bet.getTIP().equals("2")) {
			result = Result.TWO;
		}
		return result;
	}

	/**
	 * Gets the tournament from participants.
	 * 
	 * @param participants
	 *            the participants
	 * @return the tournament from participants
	 */
	private XmlTournament getTournamentFromParticipants(
			Collection<XmlMatchParticipant> participants) {
		for (XmlMatchParticipant p : participants) {
			return p.getXmlTournament();
		}
		return null;
	}

	/**
	 * Gets the xml date.
	 * 
	 * @param event
	 *            the event
	 * @param cfgBookmakerConfiguration
	 *            the cfg bookmaker configuration
	 * @return the xml date
	 * @throws MatchWillNotBeProcessedException
	 *             the match will not be processed exception
	 */
	private XmlDate getXmlDate(final EVENT event,
			CfgBookmakerConfiguration cfgBookmakerConfiguration)
			throws MatchWillNotBeProcessedException {
		XmlDate result = null;
		try {
			result = getStartDate(event.getSTARTTIME().toString(), DATE_FORMAT,
					cfgBookmakerConfiguration.getTimeZone());
		} catch (ParseException e) {
			StringBuffer buffer = new StringBuffer(
					"No se ha podido convertir la fecha: ").append(event
					.getSTARTTIME().toString());
			LOG.error(Thread.currentThread(), buffer.toString());
			throw new MatchWillNotBeProcessedException(
					"Parse exception de la fecha del partido: "
							+ buffer.toString());
		}
		return result;
	}

	@Inject
	private InterwettenUtil interwettenUtil;

	/**
	 * Gets the xml market.
	 * 
	 * @param bets
	 *            the bets
	 * @param participants
	 *            the participants
	 * @param sport
	 *            the sport
	 * @return the xml market
	 * @throws MarketWillNotBeProcessedException
	 *             the market will not be processed exception
	 */
	private XmlMarket getXmlMarket(List<BET> bets,
			Collection<XmlMatchParticipant> participants, XmlSport sport)
			throws MarketWillNotBeProcessedException {

		XmlMarket result = new XmlMarket();

		try {
			BetTypeAndBetTypeEvent betTypeAndBetTypeEvent = interwettenUtil.getBetType(bets,
					sport);

			if (betTypeAndBetTypeEvent != null) {
				if (betTypeAndBetTypeEvent.getBetType().equals(
						BetTypeInterwetten.UNO_X_DOS)) {
					result = getMarketUnoXDos(bets, participants);
				} else if (betTypeAndBetTypeEvent.getBetType().equals(
						BetTypeInterwetten.GANADOR_PARTIDO)) {
					result = getMarketGanadorPartido(bets, participants);
				} else if (betTypeAndBetTypeEvent.getBetType().equals(
						BetTypeInterwetten.MAS_MENOS)) {
					result = getMarketMasMenos(bets);
				} else if (betTypeAndBetTypeEvent.getBetType().equals(
						BetTypeInterwetten.HANDICAP_ASIATICO)) {
					result = getMarketHandicapAsiatico(bets, participants);
				} else if (betTypeAndBetTypeEvent.getBetType().equals(
						BetTypeInterwetten.UNO_X_DOS_HANDICAP)) {
					result = getMarketUnoXDosHandicap(bets, participants);
				} else if (betTypeAndBetTypeEvent.getBetType().equals(
						BetTypeInterwetten.GANADOR)) {
					result = getMarketGanador(bets, participants);
				}

				XmlBetType betType = new XmlBetType();
				XmlBetEvent betEvent = new XmlBetEvent();
				betType.setBetType(betTypeAndBetTypeEvent.getBetType());
				betEvent.setBetEvent(betTypeAndBetTypeEvent.getBetEvent());
				betType.setXmlBetEvent(betEvent);
				result.setXmlBetType(betType);

			} else {
				StringBuffer logMsg = new StringBuffer();
				logMsg.append("No ha sido posible determinar el tipo de apuesta.");
				throw new InterwettenBetTypeNotFoundException(logMsg.toString());
			}
		} catch (InterwettenBetTypeNotFoundException e) {
			throw new MarketWillNotBeProcessedException(e);
		} catch (InterwettenBetTypeEventNotFoundException e) {
			throw new MarketWillNotBeProcessedException(e);
		} catch (InterwettenUnknowHandicapNodeStructureException e) {
			LOG.error(Thread.currentThread(),
					"Ha ocurrido un error al resolver un handicap: ", e);
			throw new MarketWillNotBeProcessedException(e);
		} catch (InterwettenHandicapException e) {
			LOG.error(Thread.currentThread(),
					"Ha ocurrido un error al resolver un handicap: ", e);
			throw new MarketWillNotBeProcessedException(e);
		}

		return result;
	}

	/**
	 * Gets the xml match.
	 * 
	 * @param event
	 *            the event
	 * @param lstBets
	 *            the lst bets
	 * @param xmlTournament
	 *            the xml tournament
	 * @param cfgBookmakerConfiguration
	 *            the cfg bookmaker configuration
	 * @return the xml match
	 * @throws MatchWillNotBeProcessedException
	 *             the match will not be processed exception
	 */
	private XmlMatch getXmlMatch(EVENT event, List<List<BET>> lstBets,
			final XmlTournament xmlTournament,
			final CfgBookmakerConfiguration cfgBookmakerConfiguration)
			throws MatchWillNotBeProcessedException {

		XmlMatch match = new XmlMatch();
		XmlTournamentEvent tournamentEvent;
		boolean longTermEvent;

		try {
			longTermEvent = isLongTermMatch(event);
			match.setXmlMatchParticipants(getXmlParticipants(event.getNAME(),
					lstBets, xmlTournament, longTermEvent));
			tournamentEvent = getXmlTournamentEvent(longTermEvent);
			match.setXmlTournamentEvent(tournamentEvent);
			match.setName(readName(event.getNAME(), longTermEvent));
			match.setXmlTournament(xmlTournament);
			match.setStartDate(getXmlDate(event, cfgBookmakerConfiguration));

			for (List<BET> bets : lstBets) {

				try {
					XmlMarket market = getXmlMarket(bets,
							match.getXmlMatchParticipants(),
							xmlTournament.getXmlSport());
					if (market.getXmlMarketBets().size() > 0) {
						match.addXmlMarket(getXmlMarket(bets,
								match.getXmlMatchParticipants(),
								xmlTournament.getXmlSport()));
					}
				} catch (MarketWillNotBeProcessedException e) {
					StringBuffer buffer = new StringBuffer();
					buffer.append("MarketWillNotBeProcessedException: No vamos a procesar el grupo:\n");
					buffer.append(betGroupToString(bets));
					buffer.append("\n porque ha saltado una excepcion: ");
					buffer.append(e.getMessage());
					LOG.debug(Thread.currentThread(), buffer.toString());
				}
			}

			if (match.getXmlMarkets().isEmpty()) {
				throw new MatchWillNotBeProcessedException(
						new StringBuffer()
								.append("No se ha resulto ningun mercado para el partido con nombre: ")
								.append(event.getNAME()).toString());
			} else {
				List<XmlMarket> xmlMarkets = mergeMarkets(match.getXmlMarkets());
				match.setXmlMarkets(xmlMarkets);
			}

		} catch (InterwettenParticipantsCantBeResolvedException e) {
			LOG.error(Thread.currentThread(),
					"No se ha podido resolver los participantes del evento: ",
					e);
			throw new MatchWillNotBeProcessedException(e);
		}

		return match;
	}

	/**
	 * Merge markets.
	 * 
	 * Este metodo se encarga de recibir una lista de mercados y fusionar las
	 * apuestas que pertenezcan a un mismo mercado. Por mismo mercado se
	 * entiende a un mercado con el mismo bettype y bettypeevent
	 * 
	 * @param xmlMarkets
	 *            the xml markets
	 * @return the list
	 */
	private List<XmlMarket> mergeMarkets(Collection<XmlMarket> xmlMarkets) {
		List<XmlMarket> result = new ArrayList<XmlMarket>();
		XmlMarket xmlMarketResult;
		for (XmlMarket xmlMarketIt : xmlMarkets) {
			if (!result.contains(xmlMarketIt)) {
				xmlMarketResult = new XmlMarket();
				xmlMarketResult.setParent(xmlMarketIt.getParent());
				xmlMarketResult.setXmlBetType(xmlMarketIt.getXmlBetType());
				xmlMarketResult.setXmlMarketBets(new ArrayList<XmlMarketBet>());
				for (XmlMarket xmlMarket : xmlMarkets) {
					if (xmlMarketIt.equals(xmlMarket)) {
						xmlMarketResult.getXmlMarketBets().addAll(
								xmlMarket.getXmlMarketBets());
					}
				}
				result.add(xmlMarketResult);
			}
		}
		return result;
	}

	/**
	 * Gets the xml participants.
	 * 
	 * @param matchNameWithParticipantNames
	 *            the match name with participant names
	 * @param bets
	 *            the bets
	 * @param tournament
	 *            the tournament
	 * @param longTermEvent
	 *            the long term event
	 * @return the xml participants
	 * @throws InterwettenParticipantsCantBeResolvedException
	 *             the interwetten match name exception
	 */
	private Collection<XmlMatchParticipant> getXmlParticipants(
			String matchNameWithParticipantNames, List<List<BET>> bets,
			XmlTournament tournament, boolean longTermEvent)
			throws InterwettenParticipantsCantBeResolvedException {

		if (longTermEvent) {
			return getXmlParticipantsLongTermEvent(bets, tournament);
		} else {
			return getXmlParticipantsShortTermEvent(
					matchNameWithParticipantNames, tournament);
		}

	}

	/**
	 * Gets the xml participants long term event.
	 * 
	 * @param bets
	 *            the bets
	 * @param tournament
	 *            the tournament
	 * @return the xml participants long term event
	 */
	private Collection<XmlMatchParticipant> getXmlParticipantsLongTermEvent(
			List<List<BET>> bets, XmlTournament tournament) {

		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant matchParticipant;

		List<BET> betsLongTerm = bets.get(0);

		for (BET bet : betsLongTerm) {
			matchParticipant = new XmlMatchParticipant(bet.getPLAYER2().trim(),
					tournament);
			participants.add(matchParticipant);
		}

		return participants;
	}

	/**
	 * Gets the xml participants short term event.
	 * 
	 * @param matchNameWithParticipantNames
	 *            the match name with participant names
	 * @param tournament
	 *            the tournament
	 * @return the xml participants short term event
	 * @throws InterwettenParticipantsCantBeResolvedException
	 *             the interwetten match name exception
	 * @throws StringIndexOutOfBoundsException
	 *             the string index out of bounds exception
	 */
	private Collection<XmlMatchParticipant> getXmlParticipantsShortTermEvent(
			final String matchNameWithParticipantNames,
			final XmlTournament tournament)
			throws InterwettenParticipantsCantBeResolvedException,
			StringIndexOutOfBoundsException {

		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant homeParticipant;
		XmlMatchParticipant awayParticipant;

		try {
			homeParticipant = new XmlMatchParticipant(
					matchNameWithParticipantNames.substring(0,
							matchNameWithParticipantNames.indexOf("-")), true,
					false, tournament);

			awayParticipant = new XmlMatchParticipant(
					matchNameWithParticipantNames.substring(
							matchNameWithParticipantNames.indexOf("-") + 2,
							matchNameWithParticipantNames.length()), false,
					true, tournament);
			participants.add(homeParticipant);
			participants.add(awayParticipant);

		} catch (StringIndexOutOfBoundsException e) {
			throw new InterwettenParticipantsCantBeResolvedException(
					new StringBuffer()
							.append("Se esperaba un nombre de evento con formato 'Participante1 - Participante2' pero se encontro con: ")
							.append(matchNameWithParticipantNames).toString());
		}

		return participants;
	}

	/**
	 * Gets the xml sport.
	 * 
	 * @param kindofsport
	 *            the kindofsport
	 * @return the xml sport
	 */
	private XmlSport getXmlSport(final KINDOFSPORT kindofsport) {
		XmlSport result = new XmlSport();

		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Vamos a procesar el deporte: ")
						.append(kindofsport.getNAME()).toString());

		result.setName(kindofsport.getNAME());
		return result;
	}

	/**
	 * Gets the xml tournament.
	 * 
	 * @param xmlSport
	 *            the xml sport
	 * @param league
	 *            the league
	 * @return the xml tournament
	 */
	private XmlTournament getXmlTournament(final XmlSport xmlSport,
			final LEAGUE league) {
		XmlTournament result = new XmlTournament();

		LOG.debug(
				Thread.currentThread(),
				new StringBuffer().append("Vamos a procesar la liga: ")
						.append(league.getNAME()).toString());

		result.setName(league.getNAME());
		result.setXmlSport(xmlSport);
		return result;
	}

	/**
	 * Gets the xml tournament event.
	 * 
	 * @param longTermEvent
	 *            the long term event
	 * @return the xml tournament event
	 */
	private XmlTournamentEvent getXmlTournamentEvent(boolean longTermEvent) {
		XmlTournamentEvent result = new XmlTournamentEvent();
		LongTerm longTerm;
		longTerm = new LongTerm();
		if (longTermEvent) {
			longTerm.setLongTerm(Boolean.TRUE);
		} else {
			longTerm.setLongTerm(Boolean.FALSE);
		}
		return result;
	}

	/**
	 * Checks if is long term match.
	 * 
	 * @param event
	 *            the event
	 * @return true, if is long term match
	 */
	private boolean isLongTermMatch(EVENT event) {

		if (InterwettenWinnerUtil.isWinner(event.getBET().get(0).getTYPEID())) {
			return true;
		}
		return false;
	}

	/**
	 * Normalize xml odd.
	 * 
	 * @param quote
	 *            the quote
	 * @return the xml market bet odd
	 */
	private XmlMarketBetOdd normalizeXmlOdd(String quote) {
		return new XmlMarketBetOdd(String.valueOf(quote.replace(',', '.')));
	}

	/**
	 * Read xml.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @param cfgBookmakerConfiguration
	 *            the cfg bookmaker configuration
	 * @param pBeanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bookmaker events
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	protected XmlBookmakerEvents readXml(InputStream inputStream,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {

		FEED feed;
		KINDOFSPORT kindofsport;
		XmlSport xmlSport;
		XmlTournament xmlTournament;
		XmlBookmakerEvents result = new XmlBookmakerEvents();
		CloseShieldInputStream closeShieldInputStream = new CloseShieldInputStream(
				inputStream);
		List<List<BET>> lstBets;

		LOG.debug(Thread.currentThread(), "Inicio reader Interwetten");

		try {
			feed = (FEED) JaxbUtils.readXML(closeShieldInputStream, FEED.class);
			kindofsport = feed.getKINDOFSPORT();
			if (kindofsport != null) {
				xmlSport = getXmlSport(kindofsport);
				for (LEAGUE league : kindofsport.getLEAGUE()) {
					xmlTournament = getXmlTournament(xmlSport, league);
					for (EVENT event : league.getEVENT()) {
						lstBets = groupBet(event);
						try {
							result.addXmlMatch(getXmlMatch(event, lstBets,
									xmlTournament, cfgBookmakerConfiguration));
						} catch (MatchWillNotBeProcessedException e) {
							StringBuffer buffer = new StringBuffer();
							buffer.append("MatchWillNotBeProcessedException: No vamos a procesar el event con nombre: ");
							buffer.append(event.getNAME());
							buffer.append("\n porque ha saltado una excepcion: ");
							buffer.append(e.getMessage());
							LOG.debug(Thread.currentThread(), buffer.toString());
						}
					}
				}
			} else {
				LOG.info(Thread.currentThread(),
						"El xml no contiene informacion de apuestas");
			}
		} catch (JAXBException e) {
			StringBuffer buffer = new StringBuffer(
					"XML mal construido o no reconocido.")
					.append(convertInputStreamToString(closeShieldInputStream));
			LOG.error(Thread.currentThread(), buffer.toString(), e);
			throw new XmlReaderException(e);
		} catch (NullPointerException e) {
			StringBuffer buffer = new StringBuffer(
					"Se ha producido un NullPointer leyendo el fichero: ")
					.append(convertInputStreamToString(closeShieldInputStream));
			LOG.error(Thread.currentThread(), buffer.toString());
			throw new XmlReaderException(buffer.toString());
		}
		LOG.debug(Thread.currentThread(), "Fin reader Interwetten");
		return result;
	}

}