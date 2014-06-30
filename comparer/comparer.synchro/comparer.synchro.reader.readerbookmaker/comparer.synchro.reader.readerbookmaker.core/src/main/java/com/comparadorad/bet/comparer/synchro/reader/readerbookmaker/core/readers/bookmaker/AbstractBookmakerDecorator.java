/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker.Banner;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker.Game;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker.League;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker.Line;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker.Xml;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.commons.betOdds.CuotaConverterUtil;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

/**
 * The Class AbstractBookmakerDecorator.
 */
public abstract class AbstractBookmakerDecorator extends AbstractXmlFilereader
		implements MarketType {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyyMMdd HH:mm:ss";

	/** The Constant EMPTY. */
	private static final String EMPTY = "";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XMLBookmakerFileReader.class);

	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = " ";

	/**
	 * Gets the market ganador. Ver metodo resolveMarketLongTerm.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketGanador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the market ganador partido.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador partido {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketGanadorPartido(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		XmlMarketBet xmlMarketBet;
		XmlMatchWinnerAttribute xmlMatchWinnerAttribute;
		Line line = (Line) market;
		XmlMatchParticipant xmlParticipant;
		// 2
		xmlParticipant = getParticipant(xmlMatchParticipants, false);
		XmlMarketBetOdd xmlMarketBetOdd1 = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getVoddst()),
				line.getVoddst(), null);
		xmlMatchWinnerAttribute = new XmlMatchWinnerAttribute();
		xmlMatchWinnerAttribute.setResult(Result.TWO);
		xmlMatchWinnerAttribute.setWinnerName(xmlParticipant);
		xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setXmlAttribute(xmlMatchWinnerAttribute);
		xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd1);
		xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
		xmlMarket.addXmlBet(xmlMarketBet);

		// 1
		xmlParticipant = getParticipant(xmlMatchParticipants, true);
		XmlMarketBetOdd xmlMarketBetOdd2 = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getHoddst()),
				line.getHoddst(), null);
		xmlMatchWinnerAttribute = new XmlMatchWinnerAttribute();
		xmlMatchWinnerAttribute.setResult(Result.ONE);
		xmlMatchWinnerAttribute.setWinnerName(xmlParticipant);
		xmlMarketBet = new XmlMarketBet();
		xmlMarketBet.setXmlAttribute(xmlMatchWinnerAttribute);
		xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
		xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd2);
		xmlMarket.addXmlBet(xmlMarketBet);

		return xmlMarket;
	}

	/**
	 * Gets the market handicap asiatico.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market handicap asiatico {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketHandicapAsiatico(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();

		XmlAsianHandicapAttribute xmlAttribute;

		Line line = (Line) market;
		// 2
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		XmlMarketBetOdd xmlMarketBetOdd2 = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getVsprdoddst()),
				line.getVsprdoddst(), null);
		xmlAttribute = new XmlAsianHandicapAttribute();
		xmlAttribute.setAsianResult(AsianResult.TWO);
		xmlAttribute.setFirstValue(Double.parseDouble(line.getHsprdt()));
		xmlMarketBetAway.setXmlAttribute(xmlAttribute);
		xmlMarketBetAway.setXmlMarketBetOdd(xmlMarketBetOdd2);
		xmlMarketBetAway.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, false));
		xmlMarket.addXmlBet(xmlMarketBetAway);

		// 1
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		XmlMarketBetOdd xmlMarketBetOdd1 = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getHsprdoddst()),
				line.getHsprdoddst(), null);
		xmlAttribute = new XmlAsianHandicapAttribute();
		xmlAttribute.setAsianResult(AsianResult.ONE);
		xmlAttribute.setFirstValue(Double.parseDouble(line.getHsprdt()));
		xmlMarketBetHome.setXmlAttribute(xmlAttribute);
		xmlMarketBetHome.setXmlMarketBetOdd(xmlMarketBetOdd1);
		xmlMarketBetHome.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, true));
		xmlMarket.addXmlBet(xmlMarketBetHome);

		return xmlMarket;
	}

	/**
	 * Gets the market mas menos.
	 * 
	 * @param market
	 *            the market
	 * @return the market mas menos {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketMasMenos(Object market) {
		XmlMarket xmlMarket = new XmlMarket();
		Line line = (Line) market;
		// Mas
		XmlMarketBet xmlMarketBetMas = new XmlMarketBet();
		xmlMarketBetMas.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getOvoddst()),
				line.getOvoddst(), null));
		XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
		xmlAttribute.setMasMenos(MasMenos.MAS);
		StringUtil util = new StringUtil();
		String mas = util.replaceCharacter(line.getOvt(), "-", "");

		xmlAttribute.setTotalGoal(Double.valueOf(mas));
		xmlMarketBetMas.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetMas);

		// Menos
		XmlMarketBet xmlMarketBetMenos = new XmlMarketBet();
		xmlMarketBetMenos.setXmlMarketBetOdd(new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getUnoddst()),
				line.getUnoddst(), null));
		xmlAttribute = new XmlMoreLessAttribute();
		xmlAttribute.setMasMenos(MasMenos.MENOS);
		String menos = util.replaceCharacter(line.getUnt(), "+", "");

		xmlAttribute.setTotalGoal(Double.valueOf(menos));
		xmlMarketBetMenos.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetMenos);

		return xmlMarket;
	}

	/**
	 * Gets the market maximo goleador. Hasta hoy no se ha visto este tipo de
	 * apuesta en los xmls.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market maximo goleador
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketMaximoGoleador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @param xmlBetEvent
	 *            the bet event description
	 * @param line
	 *            the line
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the bet type
	 */
	private List<XmlMarket> getMarkets(XmlBetEvent xmlBetEvent, Line line,
			Collection<XmlMatchParticipant> xmlMatchParticipants) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Resolvemos los mercados del evento");
		}
		List<XmlMarket> markets = new ArrayList<XmlMarket>();
		XmlBetType xmlBetType;
		if (isMarketUnoXDos(line)) {
			// Apuesta 1X2
			
			// En el filtro por deporte se introduce un error para los eventos
			// que contemplan el empate por lo que invertimos el valor mediante
			// la llamada al metodo filterBetEventForDrawEvent para solventarlo
			xmlBetEvent = BetEventBookmaker.filterBetEventForDrawEvent(xmlBetEvent);

			xmlBetType = new XmlBetType();
			XmlMarket xmlMarket = new XmlMarket();
			xmlBetType.setBetType(BetTypeBookmaker.UNO_X_DOS);
			xmlBetType.setXmlBetEvent(xmlBetEvent);
			xmlMarket = getMarketUnoXDos(line, xmlMatchParticipants);
			xmlMarket.setXmlBetType(xmlBetType);
			markets.add(xmlMarket);
		}
		if (isMarketGanadorPartido(line)) {
			// Apuesta Ganador partido
			xmlBetType = new XmlBetType();
			XmlMarket xmlMarket = new XmlMarket();
			xmlBetType.setBetType(BetTypeBookmaker.GANADOR_PARTIDO);
			xmlBetType.setXmlBetEvent(xmlBetEvent);
			xmlMarket = getMarketGanadorPartido(line, xmlMatchParticipants);
			xmlMarket.setXmlBetType(xmlBetType);
			markets.add(xmlMarket);
		}
		if (isMarketHandicapAsiatico(line)) {
			// Apuesta Handicap asiatico
			xmlBetType = new XmlBetType();
			XmlMarket xmlMarket = new XmlMarket();
			xmlBetType.setBetType(BetTypeBookmaker.HANDICAP_ASIATICO);
			xmlBetType.setXmlBetEvent(xmlBetEvent);
			xmlMarket = getMarketHandicapAsiatico(line, xmlMatchParticipants);
			xmlMarket.setXmlBetType(xmlBetType);
			markets.add(xmlMarket);
		}
		if (isMarketMasMenos(line)) {
			// Apuesta mas menos
			xmlBetType = new XmlBetType();
			XmlMarket xmlMarket = new XmlMarket();
			xmlBetType.setBetType(BetTypeBookmaker.MAS_MENOS);
			xmlBetType.setXmlBetEvent(xmlBetEvent);
			xmlMarket = getMarketMasMenos(line);
			xmlMarket.setXmlBetType(xmlBetType);
			markets.add(xmlMarket);
		}

		return markets;
	}

	/**
	 * Gets the market uno x dos. Hasta hoy no se ha visto este tipo de apuesta
	 * en los xmls.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketUnoXDos(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		List<XmlMarketBet> xmlMarketBets = new ArrayList<XmlMarketBet>();

		Line line = (Line) market;

		// 2
		XmlMarketBet xmlMarketBet2 = new XmlMarketBet();
		Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
		XmlMarketBetOdd xmlMarketBetOdd2 = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getVoddst()),
				line.getVoddst(), null);
		xmlAttribute.setResult(Result.TWO);
		xmlMarketBet2.setXmlAttribute(xmlAttribute);
		xmlMarketBet2.setXmlMarketBetOdd(xmlMarketBetOdd2);
		xmlMarketBet2.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, false));
		xmlMarketBet2.setParent(xmlMarket);
		xmlMarketBets.add(xmlMarketBet2);

		// 1
		XmlMarketBet xmlMarketBet1 = new XmlMarketBet();
		Xml1X2Attribute xmlAttribute1 = new Xml1X2Attribute();
		XmlMarketBetOdd xmlMarketBetOdd1 = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getHoddst()),
				line.getHoddst(), null);
		xmlAttribute1.setResult(Result.ONE);
		xmlMarketBet1.setXmlAttribute(xmlAttribute1);
		xmlMarketBet1.setXmlMarketBetOdd(xmlMarketBetOdd1);
		xmlMarketBet1.setXmlMatchParticipant(getParticipant(
				xmlMatchParticipants, true));
		xmlMarketBet1.setParent(xmlMarket);
		xmlMarketBets.add(xmlMarketBet1);

		// X
		XmlMarketBet xmlMarketBetX = new XmlMarketBet();
		Xml1X2Attribute xmlAttributeX = new Xml1X2Attribute();
		XmlMarketBetOdd xmlMarketBetOddX = new XmlMarketBetOdd(
				CuotaConverterUtil.americanToDecimalOdds(line.getVspoddst()),
				line.getVspoddst(), null);
		xmlAttributeX.setResult(Result.DRAW);
		xmlMarketBetX.setXmlAttribute(xmlAttributeX);
		xmlMarketBetX.setXmlMarketBetOdd(xmlMarketBetOddX);
		xmlMarketBetX.setParent(xmlMarket);
		xmlMarketBets.add(xmlMarketBetX);

		xmlMarket.setXmlMarketBets(xmlMarketBets);

		return xmlMarket;
	}

	/**
	 * Gets the market uno x dos handicap. Hasta hoy no se ha visto este tipo de
	 * apuesta en los xmls.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos handicap
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the match date.
	 * 
	 * @param matchDate
	 *            the match date
	 * @param mathHour
	 *            the math hour
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @return the match date
	 * @throws ParseException
	 *             the parse exception
	 */
	private XmlDate getMatchDate(final String matchDate, String mathHour,
			final String bookmakerTimeZone) throws ParseException {
		XmlDate result = new XmlDate();
		StringBuffer correctDate = new StringBuffer(matchDate);
		correctDate.append(SEPARATOR);
		correctDate.append(mathHour);
		result = getStartDate(correctDate.toString(), DATE_FORMAT,
				bookmakerTimeZone);
		return result;
	}

	/**
	 * Gets the read league matchs log msg.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @return the read league matchs log msg
	 */
	private String getReadLeagueMatchsLogMsg(XmlMatch xmlMatch) {
		StringBuffer logMsg = new StringBuffer();
		logMsg.append("Hemos resuelto el evento: ");
		logMsg.append(xmlMatch.getName());
		logMsg.append(". Hemos encontrado los siguientes mercados: ");
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			logMsg.append(market.getXmlBetType().getBetType().getId());
			if (market.getXmlBetType().getXmlBetEvent() != null) {
				logMsg.append(" : ");
				logMsg.append(market.getXmlBetType().getXmlBetEvent()
						.getBetEvent().getId());
				logMsg.append("; ");
			} else {
				logMsg.append("No se ha resuelto ningún mercado del evento: ");
				logMsg.append(xmlMatch.getName());
			}
		}
		return logMsg.toString();
	}

	/**
	 * Gets the xml match.
	 * 
	 * @param lastBanner
	 *            the last banner
	 * @param game
	 *            the game
	 * @param league
	 *            the league
	 * @param sport
	 *            the sport
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BookmakerEuReaderException
	 *             the bookmaker eu reader exception
	 * @throws BookmakerEuMatchWillNotBeProcessedException
	 *             the bookmaker eu match will not be processed exception
	 */
	private XmlMatch getXmlMatch(Banner lastBanner, Game game, League league,
			XmlSport sport, CfgBookmakerConfiguration configuration)
			throws BookmakerEuReaderException,
			BookmakerEuMatchWillNotBeProcessedException {
		XmlMatch xmlMatch;
		if (ShortTermLongTermResolver.isLongTermEvent(game.getLine().size(),
				league.getDescription(), game.getHtm())) {
			xmlMatch = readLongTermEvent(sport, game, configuration);
		} else if (ShortTermLongTermResolver.isShortTermEvent(game.getLine()
				.size())) {
			xmlMatch = readShortTermEvent(league, sport, game, lastBanner,
					configuration);
		} else {
			throw new BookmakerEuMatchWillNotBeProcessedException(
					new StringBuffer()
							.append("El siguiente evento no se ha podido interpretar como un evento de largo plazo ni como un evento de corto plazo: ")
							.append(game.toString()).toString());
		}
		return xmlMatch;
	}

	/**
	 * Checks if is market ganador partido.
	 * 
	 * @param line
	 *            the line
	 * @return true, if is market ganador partido
	 */
	private boolean isMarketGanadorPartido(Line line) {
		boolean attrForGanadorPartido = line.getVoddst() != null
				&& !line.getVoddst().isEmpty() && line.getHoddst() != null
				&& !line.getHoddst().isEmpty();
		boolean attrFor1X2 = line.getVspoddst() != null
				&& !line.getVspoddst().isEmpty();
		boolean attrsForFake1X2 = line.getHspoddst() != null
				&& !line.getHspoddst().isEmpty();
		if (attrForGanadorPartido && !attrFor1X2) {
			return true;
		} else if (attrForGanadorPartido && attrFor1X2 && attrsForFake1X2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if is market handicap asiatico.
	 * 
	 * @param line
	 *            the line
	 * @return true, if is market handicap asiatico
	 */
	private boolean isMarketHandicapAsiatico(Line line) {
		return (line.getHsprdt() != null
				&& !String.valueOf(line.getHsprdt()).equals(EMPTY)
				&& line.getVsprdt() != null
				&& !String.valueOf(line.getVsprdt()).equals(EMPTY)
				&& line.getHsprdoddst() != null
				&& !String.valueOf(line.getHsprdoddst()).equals(EMPTY)
				&& line.getVsprdoddst() != null && !String.valueOf(
				line.getVsprdoddst()).equals(EMPTY));
	}

	/**
	 * Checks if is market mas menos.
	 * 
	 * @param line
	 *            the line
	 * @return true, if is market mas menos
	 */
	private boolean isMarketMasMenos(Line line) {
		return (line.getOvt() != null
				&& !String.valueOf(line.getOvt()).equals(EMPTY)
				&& line.getUnt() != null
				&& !String.valueOf(line.getUnt()).equals(EMPTY)
				&& line.getOvoddst() != null
				&& !String.valueOf(line.getOvoddst()).equals(EMPTY)
				&& line.getUnoddst() != null && !String.valueOf(
				line.getUnoddst()).equals(EMPTY));
	}

	/**
	 * Checks if is market uno x dos.
	 * 
	 * @param line
	 *            the line
	 * @return true, if is market uno x dos
	 */
	private boolean isMarketUnoXDos(Line line) {
		boolean attrFor1X2 = line.getVoddst() != null
				&& !line.getVoddst().isEmpty() && line.getHoddst() != null
				&& !line.getHoddst().isEmpty() && line.getVspoddst() != null
				&& !line.getVspoddst().isEmpty();
		boolean attrsForFake1X2 = line.getHspoddst() != null
				&& !line.getHspoddst().isEmpty();
		if (attrFor1X2 && !attrsForFake1X2) {
			return true;
		} else if (attrFor1X2 && attrsForFake1X2) {
			return false;
		} else {
			return false;
		}

	}

	/**
	 * Read xml match.
	 * 
	 * @param league
	 *            the league
	 * @param sport
	 *            the sport
	 * @param configuration
	 *            the configuration
	 * @param leaguesBySport
	 *            the leagues by sport
	 * @return the list
	 * @throws BookmakerEuReaderException
	 *             the bookmaker eu reader exception
	 */
	public List<XmlMatch> readLeagueMatchs(League league, XmlSport sport,
			CfgBookmakerConfiguration configuration,
			Map<String, String> leaguesBySport)
			throws BookmakerEuReaderException {

		List<XmlMatch> xmlLeagueMatches = new ArrayList<XmlMatch>();
		Banner lastBanner = null;
		XmlMatch xmlMatch = null;

		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer().append(
					"Iteramos sobre el nodo league con descripcion: ").append(
					league.getDescription()));
		}

		for (Object xmlNode : league.getContent()) {
			try {
				if (xmlNode instanceof Banner) {
					lastBanner = (Banner) xmlNode;
				} else if (xmlNode instanceof Game) {
					xmlMatch = getXmlMatch(lastBanner, (Game) xmlNode, league,
							sport, configuration);

					if (xmlMatch.getXmlMarkets() != null
							&& xmlMatch.getXmlMarkets().size() > 0) {
						xmlLeagueMatches.add(xmlMatch);
						if (LOG.isDebugEnabled()) {
							LOG.debug(getReadLeagueMatchsLogMsg(xmlMatch));
						}
					}

				}
			} catch (BookmakerEuMatchWillNotBeProcessedException e) {
				LOG.error(
						"No vamos a procesar el match por un error que ha ocurrido antes: ",
						e);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer().append("En total hemos recuperado ")
					.append(xmlLeagueMatches.size())
					.append(" eventos del nodo: ")
					.append(league.getDescription()));
		}

		return xmlLeagueMatches;
	}

	/**
	 * Read long term event.
	 * 
	 * @param sport
	 *            the sport
	 * @param game
	 *            the game
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BookmakerEuMatchWillNotBeProcessedException
	 *             the bookmaker eu match will not be processed exception
	 */
	private XmlMatch readLongTermEvent(XmlSport sport, Game game,
			CfgBookmakerConfiguration configuration)
			throws BookmakerEuMatchWillNotBeProcessedException {

		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament tournament = new XmlTournament();
		Collection<XmlMatchParticipant> xmlParticipants;

		tournament.setXmlSport(sport);
		tournament.setName(TournamentNameResolver
				.resolveLongTermTournamentName(game.getHtm()));

		xmlParticipants = resolveParticipantsFutureEvents(game.getLine(),
				tournament);

		XmlMarket xmlMarket = resolveMarketLongTerm(game.getLine(), tournament);

		xmlMatch.setXmlTournament(tournament);
		xmlMatch.setName(tournament.getName());
		xmlMatch.setXmlMatchParticipants(xmlParticipants);
		xmlMatch.addXmlMarket(xmlMarket);
		try {
			xmlMatch.setStartDate(getMatchDate(game.getGmdt(), game.getGmtm(),
					configuration.getTimeZone()));
		} catch (ParseException e) {
			LOG.error("Error al parsear la fecha del partido: ", e);
			throw new BookmakerEuMatchWillNotBeProcessedException(e);
		}

		return xmlMatch;
	}

	/**
	 * Read short term event.
	 * 
	 * @param league
	 *            the league
	 * @param sport
	 *            the sport
	 * @param game
	 *            the game
	 * @param banner
	 *            the banner
	 * @param configuration
	 *            the configuration
	 * @return the xml match
	 * @throws BookmakerEuReaderException
	 *             the bookmaker eu reader exception
	 * @throws BookmakerEuMatchWillNotBeProcessedException
	 *             the bookmaker eu match will not be processed exception
	 */
	private XmlMatch readShortTermEvent(League league, XmlSport sport,
			Game game, Banner banner, CfgBookmakerConfiguration configuration)
			throws BookmakerEuReaderException,
			BookmakerEuMatchWillNotBeProcessedException {

		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament tournament = new XmlTournament();
		Collection<XmlMatchParticipant> participants;
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		List<XmlMarket> markets = null;

		try {
			xmlBetEvent.setBetEvent(BetEventBookmaker.getBetEvent(
					sport.getName(), game.getGpd()));

			xmlMatch.setStartDate(getMatchDate(game.getGmdt(), game.getGmtm(),
					configuration.getTimeZone()));

			tournament.setXmlSport(sport);
			tournament.setName(TournamentNameResolver.resolveTournamentName(
					tournament.getXmlSport().getName(),
					league.getDescription(), banner.getVtm()));

			participants = resolveParticipants(game, tournament);

			for (Line line : game.getLine()) {
				markets = getMarkets(xmlBetEvent, line, participants);
			}

			xmlMatch.setXmlTournament(tournament);
			xmlMatch.setXmlMatchParticipants(participants);
			xmlMatch.setXmlMarkets(markets);
			xmlMatch.setName(MatchNameResolver.resolveShortTermMatchName(
					getParticipant(participants, true).getName(),
					getParticipant(participants, false).getName()));
		} catch (ParseException e) {
			LOG.error("Error al parsear la fecha del partido: ", e);
			throw new BookmakerEuMatchWillNotBeProcessedException(e);
		} catch (BookmakerEuBetEventNotFoundException e) {
			LOG.error("Excepcion: ", e);
			throw new BookmakerEuMatchWillNotBeProcessedException(e);
		}

		return xmlMatch;
	}

	/**
	 * Read xml.
	 * 
	 * @param pFile
	 *            the file
	 * @param configuration
	 *            the configuration
	 * @param beanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bookmaker events
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile,
			CfgBookmakerConfiguration configuration,
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader)
			throws XmlReaderException {

		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		List<XmlMatch> xmlMatchs = new ArrayList<XmlMatch>();
		Xml xml;

		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer()
					.append("Inicio reader del bookmaker: ").append(
							getBookmakerId()));
		}

		try {
			xml = (Xml) JaxbUtils.readXML(pFile, Xml.class);
			for (League league : xml.getLeagues().getLeague()) {
				String sportName = SportNameResolver.resolveSport(
						league.getIdLeague(),
						beanAdditionalXmlInfoReader.getMapLeaguesBySport());
				if (sportName != null) {
					xmlMatchs
							.addAll(readLeagueMatchs(league, new XmlSport(
									sportName), configuration,
									beanAdditionalXmlInfoReader
											.getMapLeaguesBySport()));
				} else {
					LOG.warn(new StringBuffer()
							.append("El reader no va a procesar la liga con descripcion: ")
							.append(league.getDescription())
							.append(". Probablemente porque se incluye en la lista negra definida en la BD"));
				}
			}
			xmlBookmakerEvents.setXmlMatchs(xmlMatchs);
		} catch (JAXBException e) {
			LOG.error("Se ha producido un error leyendo el siguiente fichero:");
			LOG.error(convertInputStreamToString(pFile));
			LOG.error(new StringBuffer("Mesaje de error: ").append(e
					.getMessage()));
			throw new XmlReaderException(e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer().append("Fin reader del bookmaker: ")
					.append(getBookmakerId()));
		}

		return xmlBookmakerEvents;
	}

	/**
	 * Resolve market long term.
	 * 
	 * @param lines
	 *            the lines
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the xml market
	 */
	private XmlMarket resolveMarketLongTerm(List<Line> lines,
			XmlTournament xmlTournament) {
		XmlMarket xmlMarket = new XmlMarket();
		XmlMarketBet xmlMarketBet;
		XmlMatchParticipant xmlMatchParticipant;

		xmlMarket.setXmlBetType(new XmlBetType(BetTypeBookmaker.GANADOR));
		for (Line line : lines) {
			if (line.getOddsh() != null && !line.getOddsh().isEmpty()) {
				xmlMarketBet = new XmlMarketBet();
				xmlMatchParticipant = new XmlMatchParticipant(line.getTmname(),
						xmlTournament);
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(line
						.getOddsh().trim(), line.getOdds().trim(), null));
				XmlWinnerAttribute winnerAttribute = new XmlWinnerAttribute();
				winnerAttribute.setWinner(xmlMatchParticipant);
				xmlMarketBet.setXmlAttribute(winnerAttribute);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		}

		return xmlMarket;
	}

	/**
	 * Resolve participants.
	 * 
	 * @param game
	 *            the game
	 * @param tournament
	 *            the tournament
	 * @return the collection
	 */
	private Collection<XmlMatchParticipant> resolveParticipants(Game game,
			XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant xmlMatchParticipantAway = new XmlMatchParticipant(
				ParticipantNameResolver.resolveParticipantName(game.getVtm()),
				tournament);
		xmlMatchParticipantAway.setAwayParticipant(true);
		participants.add(xmlMatchParticipantAway);

		XmlMatchParticipant xmlMatchParticipantHome = new XmlMatchParticipant(
				ParticipantNameResolver.resolveParticipantName(game.getHtm()),
				tournament);
		xmlMatchParticipantHome.setHomeParticipant(true);
		participants.add(xmlMatchParticipantHome);
		return participants;
	}

	/**
	 * Resolve participants future events.
	 * 
	 * @param lines
	 *            the lines
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the collection
	 */
	private Collection<XmlMatchParticipant> resolveParticipantsFutureEvents(
			List<Line> lines, XmlTournament xmlTournament) {
		Collection<XmlMatchParticipant> result = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant xmlParticipant;
		for (Line line : lines) {
			xmlParticipant = new XmlMatchParticipant(line.getTmname(),
					xmlTournament);
			result.add(xmlParticipant);
		}
		return result;
	}

}
