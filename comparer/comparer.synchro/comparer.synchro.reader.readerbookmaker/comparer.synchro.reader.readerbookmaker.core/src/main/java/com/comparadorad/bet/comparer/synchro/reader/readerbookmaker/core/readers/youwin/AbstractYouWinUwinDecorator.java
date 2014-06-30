/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.youwin;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventYouWin;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeYouWin;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Bet;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Group;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Odds;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Region;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Selection;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Sport;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlFillAttributeException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractYouWinUwinDecorator.
 */
public abstract class AbstractYouWinUwinDecorator extends AbstractXmlFilereader implements MarketType {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

	/** The Constant MATCH_RESULT. */
	private static final String MATCH_WINNER = "Match Winner";

	/** The Constant MATCH_RESULT. */
	private static final String MATCH_RESULT = "Match Result";

	/** The Constant WAYS_3. */
	private static final String WAYS_3 = "3way";

	/** The Constant OUTRIGHT_MATCH. */
	private static final String OUTRIGHT_MATCH = "Outright match";

	/** The Constant OVER. */
	private static final String OVER = "Over";

	/** The Constant UNDER. */
	private static final String UNDER = "Under";

	/** The Constant DRAW. */
	private static final String DRAW = "Draw";

	/** The Constant YOUWIN_PARTICIPANTS_SEPARATOR. */
	private static final String YOUWIN_PARTICIPANTS_SEPARATOR = " v ";

	/** The Constant YOUWIN_PARTICIPANTS_SEPARATOR_TWO. */
	private static final String YOUWIN_PARTICIPANTS_SEPARATOR_TWO = " @ ";

	/** The Constant YOUWIN_PARTICIPANTS_SEPARATOR_THREE. */
	private static final String YOUWIN_PARTICIPANTS_SEPARATOR_THREE = " vs. ";

	/** The Constant YOUWIN_PARTICIPANTS_SEPARATOR_FOUR. */
	private static final String YOUWIN_PARTICIPANTS_SEPARATOR_FOUR = " vs ";

	/** The Constant YOUWIN_PARTICIPANTS_SEPARATOR_FIVE. */
	private static final String YOUWIN_PARTICIPANTS_SEPARATOR_FIVE = " at ";

	/** The handicap home value. */
	private String handicapHomeValue = "";

	/** The Constant pSeparators. */
	private static final String[] pTrashWords = { " 2nd Half Lines", " Series Winner" };

	/**
	 * Read.
	 * 
	 * @param pFile
	 *            the file
	 * @param bookmakerConfiguration
	 *            the bookmaker configuration
	 * @param pBeanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bet file reader result
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	public XmlBookmakerEvents readXml(final InputStream pFile, final CfgBookmakerConfiguration bookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		LOG.debug(Thread.currentThread(),
				new StringBuffer("[").append(Thread.currentThread().getId()).append("] - Inicio reader YouWin/Uwin").toString());
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Odds odds = null;
		try {
			odds = (Odds) JaxbUtils.readXML(pFile, Odds.class);
			for (Sport sport : odds.getSport()) {
				LOG.debug(Thread.currentThread(), new StringBuffer().append("Procesamos el deporte: ").append(sport.getName()).toString());

				XmlSport xmlSport = setSport(sport);

				for (Region region : sport.getRegion()) {

					XmlRegion xmlRegion = new XmlRegion();
					xmlRegion.setName(region.getName());
					LOG.debug(Thread.currentThread(), new StringBuffer("La region es: ").append(region.getName()).toString());

					for (Group competition : region.getGroup()) {
						LOG.debug(Thread.currentThread(),
								new StringBuffer().append("Procesamos la competicion: ").append(competition.getName()).toString());

						XmlTournament xmlTournament = new XmlTournament();
						xmlTournament.setXmlSport(xmlSport);
						if (!competition.getName().toLowerCase().contains("upcoming")
								&& !region.getName().toLowerCase().contains("upcoming")) {
							Pattern p = Pattern.compile("Week[\\s]+[\\d]+[\\s]+");
							Matcher matcher = p.matcher(competition.getName());
							if (matcher.find()) {
								xmlTournament.setName(region.getName() + " " + competition.getName().substring(matcher.end()));
							} else {
								xmlTournament.setName(region.getName() + " " + competition.getName());
							}
							xmlTournament.setRegion(xmlRegion);

							for (Event match : competition.getEvent()) {
								XmlMatch xmlMatch = new XmlMatch();

								// Para los partidos en Vivo no se envia la
								// fecha
								// con lo que consideramos la fecha actual ya
								// que
								// son en directo
								if (competition.getName().contains("LIVE") || match.getBetend() == null || match.getBetend().equals("")) {
									LOG.debug(Thread.currentThread(), "El partido es en directo");
									xmlMatch.setStartDate(new XmlDate(new Date()));
									xmlMatch.setLive(true);
								} else {
									xmlMatch.setStartDate(setMatchDate(match.getBetend(), bookmakerConfiguration.getTimeZone()));
								}

								xmlMatch.setName(match.getName());
								LOG.debug(Thread.currentThread(),
										new StringBuffer("Procesamos el partido con nombre: ").append(xmlMatch.getName()).toString());
								for (Bet market : match.getBet()) {
									// Identificamos tipo de apuesta
									XmlBetType xmlBetType = setBetType(market);
									if (xmlBetType != null && xmlBetType.getBetType() != null) {
										// Inicializamos el evento de la apuesta
										XmlBetEvent xmlBetEvent = resolveBetEvent(xmlBetType.getBetType(), 
												sport.getSportid(), market.getName()); 
										xmlBetType.setXmlBetEvent(xmlBetEvent);
										xmlMatch.setXmlTournament(xmlTournament);

										// Los participantes se pueden obtener
										// del
										// name del match o del name del choice
										if (xmlBetType.getBetType() != BetTypeYouWin.GANADOR
												&& xmlBetType.getBetType() != BetTypeYouWin.MAXIMO_GOLEADOR) {
											xmlMatch.setXmlMatchParticipants(getParticipants(match.getName(), xmlTournament));
										} else {
											xmlMatch.setXmlMatchParticipants(getAllParticipants(market.getSelection(), xmlTournament));
										}

										XmlMarket xmlMarket = null;
										try {
											if (xmlBetType.getBetType().equals(BetTypeYouWin.GANADOR_PARTIDO)) {
												xmlMarket = getMarketGanadorPartido(market, xmlMatch.getXmlMatchParticipants());
											} else if (xmlBetType.getBetType().equals(BetTypeYouWin.GANADOR)) {
												xmlMarket = getMarketGanador(market, xmlMatch.getXmlMatchParticipants());
											} else if (xmlBetType.getBetType().equals(BetTypeYouWin.HANDICAP_ASIATICO)) {
												xmlMarket = getMarketHandicapAsiatico(market, xmlMatch.getXmlMatchParticipants());
											} else if (xmlBetType.getBetType().equals(BetTypeYouWin.MAS_MENOS)) {
												xmlMarket = getMarketMasMenos(market);
											} else if (xmlBetType.getBetType().equals(BetTypeYouWin.UNO_X_DOS)) {
												xmlMarket = getMarketUnoXDos(market, xmlMatch.getXmlMatchParticipants());
											} else if (xmlBetType.getBetType().equals(BetTypeYouWin.UNO_X_DOS_HANDICAP)) {
												xmlMarket = getMarketUnoXDosHandicap(market, xmlMatch.getXmlMatchParticipants());
											} else if (xmlBetType.getBetType().equals(BetTypeYouWin.MAXIMO_GOLEADOR)) {
												xmlMarket = getMarketMaximoGoleador(market, xmlMatch.getXmlMatchParticipants());
											}
										} catch (XmlFillAttributeException e) {
											LOG.error(
													Thread.currentThread(),
													new StringBuffer()
															.append("Error al rellenar los atributos del evento, se ignora el evento. ")
															.append(e.getMessage()).toString(), e);
										}

										if (xmlMarket != null) {
											xmlMarket.setName(market.getName());
											xmlMarket.setXmlBetType(xmlBetType);

											if (xmlMarket.getXmlMarketBets().size() > 0) {
												xmlMatch.addXmlMarket(xmlMarket);
											}
										}
									}
								}
								if (xmlMatch.getXmlMarkets() != null && xmlMatch.getXmlMarkets().size() > 0) {
									xmlBookmakerEvents.addXmlMatch(xmlMatch);
								}
							}

						}

					}

				}
			}
		} catch (Exception e) {
			String errorMessage = new StringBuffer().append("Error parseando el xml: \n").append(JaxbUtils.writeXML(odds, Odds.class))
					.toString();
			LOG.error(Thread.currentThread(), errorMessage, e);
		}
		LOG.debug(Thread.currentThread(),
				new StringBuffer("[").append(Thread.currentThread().getId()).append("] - Inicio reader YouWin/Uwin").toString());
		return xmlBookmakerEvents;
	}

	/** {@inheritDoc} */
	public XmlMarket getMarketUnoXDosHandicap(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlFillAttributeException {
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado 1x2 Handicap");
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));

				String handicap = String.valueOf(bet.getHandicap());

				// // Se han visto casos de que alguno de los elementos no
				// llevan
				// // handicap, con lo que es cero.
				if (handicap == null || handicap.equals("null")) {
					handicap = betNameToHandicap(handicap, (Bet) market).trim();
				}

				if (bet.getName().contains(getParticipant(xmlMatchParticipants, true).getName()) && !bet.getName().contains("Draw")) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
					handicapHomeValue = handicap;
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (bet.getName().contains(getParticipant(xmlMatchParticipants, false).getName()) && !bet.getName().contains("Draw")) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				} else {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.DRAW);
				}
				((Xml1X2HandicapAttribute) xmlAttribute).setFirstValue(Double.parseDouble(handicapHomeValue));
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
				((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapHomeValue));
			}

		} catch (Exception e) {
			LOG.error(
					Thread.currentThread(),
					new StringBuffer("Excepcion mientras se resolvia un atributo de tipo 1x2 Handicap: ").append(e.getMessage()).toString(),
					e);
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado 1x2 Handicap");
		return xmlMarket;
	}

	/** {@inheritDoc} */
	public XmlMarket getMarketUnoXDos(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlFillAttributeException {
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado 1x2");
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));
				if (bet.getName().contains(getParticipant(xmlMatchParticipants, true).getName())) {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.ONE);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (bet.getName().equals(DRAW)) {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.DRAW);
				} else if (bet.getName().contains(getParticipant(xmlMatchParticipants, false).getName())) {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				}
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}

		} catch (Exception e) {
			LOG.error(Thread.currentThread(),
					new StringBuffer("Excepcion mientras se resolvia un atributo de tipo 1x2: ").append(e.getMessage()).toString());
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado 1x2");
		return xmlMarket;
	}

	/** {@inheritDoc} */
	public XmlMarket getMarketMasMenos(final Object market) throws XmlFillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado mas/menos");
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = null;
				xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));
				XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();

				String totalGoal = bet.getName().split(" ")[1].trim();
				totalGoal = totalGoal.replace(",", ".");

				if (bet.getName().contains(OVER)) {
					((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MAS);
					((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(totalGoal));
				} else if (bet.getName().contains(UNDER)) {
					((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MENOS);
					((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(totalGoal));
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}

		} catch (Exception e) {
			LOG.error(Thread.currentThread(),
					new StringBuffer("Excepcion mientras se resolvia un atributo de tipo Mas/Menos: ").append(e.getMessage()).toString());
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado mas/menos");
		return xmlMarket;
	}

	/** {@inheritDoc} */
	public XmlMarket getMarketHandicapAsiatico(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlFillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado handicap asiatico");
		handicapHomeValue = "";
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = null;
				xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));
				XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();

				String asianHandicap = String.valueOf(bet.getHandicap());

				// Se han visto tipos de apuestas que el handicap viene en el
				// propio nombre de la apuesta y no en un nodo propio
				if (asianHandicap == null || asianHandicap.equals("null")) {
					asianHandicap = betNameToHandicap(asianHandicap, (Bet) market);
					handicapHomeValue = asianHandicap;
				}

				if (asianHandicap.equals("-.5")) {
					asianHandicap = "-0.5";
				}
				if (bet.getName().contains(getParticipant(xmlMatchParticipants, true).getName())) {
					((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.ONE);
					if (!StringUtils.isNotEmpty(handicapHomeValue)) {
						handicapHomeValue = asianHandicap;
					}
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else {
					((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				}
				((XmlAsianHandicapAttribute) xmlAttribute).setFirstValue(Double.parseDouble(handicapHomeValue));

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);

			}
			for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
				((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapHomeValue));
			}
		} catch (Exception e) {
			LOG.error(Thread.currentThread(), new StringBuffer("Excepcion mientras se resolvia un atributo de tipo Handicap Asiatico: ")
					.append(e.getMessage()).toString());
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado handicap asiatico");
		return xmlMarket;
	}

	/** {@inheritDoc} */
	public XmlMarket getMarketGanador(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlFillAttributeException {
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado ganador");
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlWinnerAttribute attribute = new XmlWinnerAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));
				XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				attribute.setWinner(xmlMatchParticipant);

				xmlMarketBet.setXmlAttribute(attribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}

		} catch (Exception e) {
			LOG.error(Thread.currentThread(),
					new StringBuffer("Excepcion mientras se resolvia un atributo de tipo Ganador: ").append(e.getMessage()).toString());
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado ganador");
		return xmlMarket;
	}

	/** {@inheritDoc} */
	public XmlMarket getMarketGanadorPartido(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlFillAttributeException {
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado ganador partido");
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));
				XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();

				if (bet.getName().contains(getParticipant(xmlMatchParticipants, true).getName())) {
					((XmlMatchWinnerAttribute) xmlAttribute).setResult(Result.ONE);
					XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, true);
					((XmlMatchWinnerAttribute) xmlAttribute).setWinnerName(xmlMatchParticipant);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (bet.getName().contains(getParticipant(xmlMatchParticipants, false).getName())) {
					((XmlMatchWinnerAttribute) xmlAttribute).setResult(Result.TWO);
					XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, false);
					((XmlMatchWinnerAttribute) xmlAttribute).setWinnerName(xmlMatchParticipant);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		} catch (Exception e) {
			LOG.error(Thread.currentThread(), new StringBuffer("Excepcion mientras se resolvia un atributo de tipo Ganador Partido: ")
					.append(e.getMessage()).toString());
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado ganador partido");
		return xmlMarket;
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketMaximoGoleador(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlFillAttributeException {
		LOG.debug(Thread.currentThread(), "Inicio obtencion de mercado maximo goleador");
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Selection bet : ((Bet) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMaximumGoalerAttribute attribute = new XmlMaximumGoalerAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdd()));
				XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				attribute.setGoaler(xmlMatchParticipant);

				xmlMarketBet.setXmlAttribute(attribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		} catch (Exception e) {
			LOG.error(Thread.currentThread(), new StringBuffer("Excepcion mientras se resolvia un atributo de tipo Maximo goleador: ")
					.append(e.getMessage()).toString());
			throw new XmlFillAttributeException(e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion de mercado maximo goleador");
		return xmlMarket;
	}

	/**
	 * Sets the sport.
	 * 
	 * @param sportFromXml
	 *            the sport from xml
	 * @return the xml sport
	 */
	private XmlSport setSport(final Sport sportFromXml) {
		XmlSport result = new XmlSport();
		result.setName(sportFromXml.getName());
		return result;
	}

	/**
	 * Sets the match date.
	 * 
	 * @param matchDate
	 *            the match date
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @return the xml date
	 * @throws ParseException
	 *             the parse exception
	 */
	private XmlDate setMatchDate(final String matchDate, final String bookmakerTimeZone) throws ParseException {
		XmlDate result = new XmlDate();
		String correctDate = matchDate;
		result = getStartDate(correctDate, DATE_FORMAT, bookmakerTimeZone);
		return result;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param bet
	 *            the bet
	 * @return the xml bet type
	 */
	private XmlBetType setBetType(final Bet bet) {
		XmlBetType result = new XmlBetType();
		LOG.debug(Thread.currentThread(), "Inicio procesado tipo apuesta");
		// En caso de match winner, habria que ver si es el
		// tipo de apuesta es de 1x2 o de Ganador de partido
		if (bet.getName().equalsIgnoreCase(MATCH_WINNER) || bet.getName().equalsIgnoreCase(MATCH_RESULT)
				|| bet.getName().equalsIgnoreCase(OUTRIGHT_MATCH) || bet.getName().contains(WAYS_3)) {
			if (bet.getSelection().size() == 3) {
				result.setBetType(BetTypeYouWin.UNO_X_DOS);
			} else {
				result.setBetType(BetTypeYouWin.GANADOR_PARTIDO);
			}
		} else {
			result.setBetType(BetTypeYouWin.getTypeByValue(bet.getName()));
		}

		if (result.getBetType() != null) {
			if (result.getBetType().equals(BetTypeYouWin.UNO_X_DOS_HANDICAP) && bet.getSelection().size() == 2) {
				result.setBetType(BetTypeYouWin.HANDICAP_ASIATICO);
			}
		}

		if (result.getBetType() != null) {
			LOG.debug(Thread.currentThread(), new StringBuffer().append("El tipo de apuesta es: ").append(result.getBetType().getId())
					.toString());
		}
		LOG.debug(Thread.currentThread(), "Fin procesado tipo apuesta");
		return result;
	}
	
	/**
	 * Resolve bet event.
	 *
	 * @param betType the bet type
	 * @param bmInternalId the bm internal id
	 * @return the xml bet event
	 */
	private XmlBetEvent resolveBetEvent(IBetType betType, BigDecimal sportId, String marketName) {
		XmlBetEvent result = new XmlBetEvent(BetEventYouWin.getEventByValue(marketName));

		// Comprobamos si el tipo de apuesta contempla empate
		if (betType.equals(BetTypeYouWin.HANDICAP_ASIATICO) 
				|| betType.equals(BetTypeYouWin.GANADOR_PARTIDO)
				|| betType.equals(BetTypeYouWin.MAS_MENOS)){
			// Comprobamos si se trata de un deporte con tratamiento especial
			if (SportYouwinResolver.isAmericanFootball(sportId.toString())
					|| SportYouwinResolver.isBaseball(sportId.toString())
					|| SportYouwinResolver.isBasketball(sportId.toString())
					|| SportYouwinResolver.isIceHockey(sportId.toString())){
				// Comprobamos si el bet event es de tipo partido completo 
				// en tal caso lo cambiamos por partido completo mas prorroga
				if(result.getBetEvent() == null
					|| result.getBetEvent() == BetEventYouWin.PARTIDO_COMPLETO){
					result.setBetEvent(BetEventYouWin.PARTIDO_COMPLETO_PRORROGA);
				}
				// añadir a excepciones del process y quitar este if
				// Excepciones hockey				
				if (SportYouwinResolver.isIceHockey(sportId.toString())){
					if (marketName.equalsIgnoreCase("Draw no bet")){
						result.setBetEvent(BetEventYouWin.PARTIDO_COMPLETO);	
					}else if (marketName.equalsIgnoreCase("Puck Line")){
						result.setBetEvent(BetEventYouWin.PARTIDO_COMPLETO_PRORROGA);
					}
				}
			}
		}
		
		return result;
	}

	/**
	 * Bet name to handicap. En ocasiones las apuestas de tipo handicap no
	 * llevan el nodo propio que indica el valor del handicap con lo que tenemos
	 * que ver si es posible obtener dicho valor del propio nombre de la apuesta
	 * o incluso en el nombre del participante, en caso de que no sea posible
	 * elevaremos excepcion.
	 * 
	 * @param handicap
	 *            the handicap
	 * @param bet
	 *            the bet
	 * @return the string
	 * @throws XmlFillAttributeException
	 *             the youwin attribute exception
	 */
	private String betNameToHandicap(final String handicap, final Bet bet) throws XmlFillAttributeException {
		String result = handicap;
		LOG.debug(Thread.currentThread(),
				"La apuesta no tiene el handicap en su nodo, miramos a ver si lo tiene en el nombre de la apuesta");
		if (bet.getName().contains(" - ")) {
			bet.setName(bet.getName().replace(" - ", ""));
		}
		if (bet.getName().contains(":")) {
			if (bet.getName().contains(" +")) {
				result = bet.getName().substring(bet.getName().indexOf(" +") + 1, bet.getName().indexOf(":"));
			} else {
				result = "-" + bet.getName().substring(bet.getName().indexOf(":") + 1);
			}
		} else {
			if (bet.getName().contains(" -")) {
				result = bet.getName().substring(bet.getName().indexOf(" -"), bet.getName().length());
			} else if (bet.getName().contains(" +")) {
				result = bet.getName().substring(bet.getName().indexOf(" +"), bet.getName().length());
			} else if (bet.getName().contains("Goals Spread")) {
				LOG.debug(Thread.currentThread(), "Caso para goals spread que el positivo lo indica sin signo");
				result = bet.getName().replace("Goals Spread", "").trim();
			} else if (bet.getName().contains("Points Spread") || bet.getName().contains("Point Spread")
					|| bet.getName().contains("Puck Line")) {
				LOG.debug(Thread.currentThread(), "Caso especial en el que el handicap se encuentra en el nombre del participante");
				result = obtainHandicapFromParticipanName(bet.getSelection().get(0));
			} else {
				LOG.debug(Thread.currentThread(),
						"No se detecta el valor del handicap ni en un nodo propio ni en el nombre de la apuesta, lanzamos excepcion");
				throw new XmlFillAttributeException("No se ha encontrado el valor del handicap asiatico");
			}
		}

		return result;
	}

	/**
	 * Método que se encarga de a partir del nombre de un participante obtener
	 * de el el handicap, en algunas ocasiones es el unico lugar donde podemos
	 * obtener el valor del handicap.
	 * 
	 * @param selection
	 * @return
	 */
	private String obtainHandicapFromParticipanName(final Selection selection) {
		LOG.debug(Thread.currentThread(), "Inicio de la obtencion del handicap a partir del nombre del participante");
		String handicap = "";
		if (selection.getName().contains(" -")) {
			handicap = selection.getName().substring(selection.getName().indexOf(" -") + 1);
		} else {
			handicap = selection.getName().substring(selection.getName().indexOf(" +") + 1);
		}
		LOG.debug(Thread.currentThread(), "Fin de la obtencion del handicap a partir del nombre del participante");
		return handicap;
	}

	/**
	 * Obtiene los nombres de los participantes para las apuestas de largo
	 * plazo.
	 * 
	 * @param bets
	 *            the bets
	 * @param tournament
	 *            the tournament
	 * @return Lista con todos los participantes.
	 */
	private Collection<XmlMatchParticipant> getAllParticipants(final List<Selection> bets, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		LOG.debug(Thread.currentThread(), "Inicio obtencion participantes largo plazo");
		for (Selection bet : bets) {
			XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(bet.getName(), tournament);
			LOG.debug(Thread.currentThread(), new StringBuffer("Añadimos el participante: ").append(xmlMatchParticipant.getName())
					.toString());
			participants.add(xmlMatchParticipant);
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion participantes largo plazo");
		return participants;
	}

	/**
	 * Obtiene los participantes para las apuestas de corto plazo.
	 * 
	 * @param participantName
	 *            the participant name
	 * @param tournament
	 *            the tournament
	 * @return Lista de participantes
	 */
	private Collection<XmlMatchParticipant> getParticipants(final String participantName, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		LOG.debug(Thread.currentThread(), "Inicio obtencion participantes corto plazo");
		String[] participantString;
		Boolean invertParticipants = Boolean.FALSE;
		if (participantName.contains(YOUWIN_PARTICIPANTS_SEPARATOR)) {
			participantString = participantName.split(YOUWIN_PARTICIPANTS_SEPARATOR);
		} else if (participantName.contains(YOUWIN_PARTICIPANTS_SEPARATOR_TWO)) {
			participantString = participantName.split(YOUWIN_PARTICIPANTS_SEPARATOR_TWO);
		} else if (participantName.contains(YOUWIN_PARTICIPANTS_SEPARATOR_THREE)) {
			participantString = participantName.split(YOUWIN_PARTICIPANTS_SEPARATOR_THREE);
		} else if (participantName.contains(YOUWIN_PARTICIPANTS_SEPARATOR_FOUR)) {
			participantString = participantName.split(YOUWIN_PARTICIPANTS_SEPARATOR_FOUR);
		} else {
			participantString = participantName.split(YOUWIN_PARTICIPANTS_SEPARATOR_FIVE);
			invertParticipants = Boolean.TRUE;
		}
		if (invertParticipants) {
			LOG.debug(Thread.currentThread(), "El evento lleva el home y el away invertido, los damos la vuelta");
			XmlMatchParticipant homeParticipant = new XmlMatchParticipant(participantString[1].trim(), tournament);
			LOG.debug(Thread.currentThread(), new StringBuffer("El participante local es: ").append(homeParticipant.getName()).toString());
			homeParticipant.setHomeParticipant(true);
			participants.add(homeParticipant);
			if (participantString.length > 1) {
				for (int i = 0; i < pTrashWords.length; i++) {
					if (participantString[1].contains(pTrashWords[i])) {
						participantString[1] = participantString[1].replace(pTrashWords[i], "");
					}
				}
				XmlMatchParticipant awayParticipant = new XmlMatchParticipant(participantString[0].trim(), tournament);
				LOG.debug(Thread.currentThread(), new StringBuffer("El participante visitante es: ").append(awayParticipant.getName())
						.toString());
				awayParticipant.setAwayParticipant(true);
				participants.add(awayParticipant);
			}
		} else {
			XmlMatchParticipant homeParticipant = new XmlMatchParticipant(participantString[0].trim(), tournament);
			homeParticipant.setHomeParticipant(true);
			LOG.debug(Thread.currentThread(), new StringBuffer("El participante local es: ").append(homeParticipant.getName()).toString());
			participants.add(homeParticipant);
			if (participantString.length > 1) {
				for (int i = 0; i < pTrashWords.length; i++) {
					if (participantString[1].contains(pTrashWords[i])) {
						participantString[1] = participantString[1].replace(pTrashWords[i], "");
					}
				}
				XmlMatchParticipant awayParticipant = new XmlMatchParticipant(participantString[1].trim(), tournament);
				LOG.debug(Thread.currentThread(), new StringBuffer("El participante visitante es: ").append(awayParticipant.getName())
						.toString());
				awayParticipant.setAwayParticipant(true);
				participants.add(awayParticipant);
			}
		}
		LOG.debug(Thread.currentThread(), "Fin obtencion participantes corto plazo");
		return participants;
	}

}
