/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betgun;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetGun;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetGun;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betgun.Betbrain;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betgun.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betgun.Selection;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betgun.Subevent;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLBetGunFileReader.
 */
@Component
public class XMLBetGunFileReader extends AbstractXmlFilereader implements MarketType {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	/** The Constant BETGUN_PARTICIPANTS_SEPARATOR. */
	private static final String BETGUN_PARTICIPANTS_SEPARATOR = "-";

	/** The Constant ONE. */
	private static final String ONE = "home";

	/** The Constant ALTERNATE_ONE. */
	private static final String ALTERNATE_ONE = "1";

	/** The Constant TWO. */
	private static final String TWO = "away";

	/** The Constant ALTERNATE_TWO. */
	private static final String ALTERNATE_TWO = "2";

	/** The Constant DRAW. */
	private static final String DRAW = "draw";

	/** The Constant ALTERNATE_DRAW. */
	private static final String ALTERNATE_DRAW = "x";

	/** The Constant OVER. */
	private static final String OVER = "over";

	private static final String ALTERNATE_OVER = "2";

	/** The Constant UNDER. */
	private static final String UNDER = "under";

	private static final String ALTERNATE_UNDER = "1";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#readXml(java.io.InputStream,
	 * com.comparadorad.bet.comparer
	 * .model.config.bean.bmconf.CfgBookmakerConfiguration,
	 * com.comparadorad.bet.
	 * comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader)
	 */
	/** {@inheritDoc} */
	@Override
	protected XmlBookmakerEvents readXml(final InputStream file, final CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		LOG.info(Thread.currentThread(), "Inicio del lector de betgun para la competicion " + pBeanAdditionalXmlInfoReader.getCompetitionName());

		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Betbrain betBrain = null;

		try {
			betBrain = (Betbrain) JaxbUtils.readXML(file, Betbrain.class);

			// Deporte
			XmlSport sport = new XmlSport(betBrain.getSport().toLowerCase());

			// Matches
			for (Event match : betBrain.getEvent()) {
				LOG.debug(Thread.currentThread(), "Resolvemos el evento " + match.getEventName());
				XmlMatch xmlMatch = new XmlMatch();

				// Nombre match
				xmlMatch.setName(match.getEventName());

				// Competicion
				XmlTournament tournament = new XmlTournament(pBeanAdditionalXmlInfoReader.getCompetitionName());
				tournament.setXmlSport(sport);
				xmlMatch.setXmlTournament(tournament);

				// Fecha Evento
				String dateTime = match.getDatetime().toString();
				dateTime = dateTime.split("\\+")[0];
				xmlMatch.setStartDate(getStartDate(dateTime, DATE_FORMAT, cfgBookmakerConfiguration.getTimeZone()));

				// Markets
				for (Subevent market : match.getSubevent()) {
					LOG.debug(Thread.currentThread(), "Resolvemos los mercados del evento");

					// Tipo de apuesta
					XmlBetType xmlBetType = resolveBetType(market);
					if (xmlBetType != null && xmlBetType.getBetType() != null) {
						// Evento de apuesta
						XmlBetEvent xmlBetEvent = resolverBetTypeEvent(market, sport, xmlBetType);
						if (xmlBetEvent.getBetEvent() != null) {
							xmlBetType.setXmlBetEvent(xmlBetEvent);
						}

						// Participantes
						if (xmlBetType.getBetType() != BetTypeBetGun.GANADOR) {
							xmlMatch.setXmlMatchParticipants(getParticipants(match.getEventName(), BETGUN_PARTICIPANTS_SEPARATOR,
									tournament));
						} else {
							xmlMatch.setXmlMatchParticipants(getAllParticipants(market.getSelection(), tournament));
						}

						List<XmlMarket> xmlMarket = new ArrayList<XmlMarket>();
						IBetType betType = xmlBetType.getBetType();
						if (betType.equals(BetTypeBetGun.GANADOR)) {
							XmlMarket marketGanador = getMarketGanador(market, xmlMatch.getXmlMatchParticipants());
							if (marketGanador.getXmlMarketBets() != null && marketGanador.getXmlMarketBets().size() > 0) {
								marketGanador.setXmlBetType(xmlBetType);
								xmlMarket.add(marketGanador);
							}
						} else if (betType.equals(BetTypeBetGun.GANADOR_PARTIDO)) {
							XmlMarket marketGanadorPartido = getMarketGanadorPartido(market, xmlMatch.getXmlMatchParticipants());
							if (marketGanadorPartido.getXmlMarketBets() != null && marketGanadorPartido.getXmlMarketBets().size() > 0) {
								marketGanadorPartido.setXmlBetType(xmlBetType);
								xmlMarket.add(marketGanadorPartido);
							}

						} else if (betType.equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
							if (market.getSelection().size() > 2) {
								LOG.debug(Thread.currentThread(), "El mercado tiene varias apuestas de tipo handicap asiatico o incluso handicap 1x2 dentro del mismo nodo, separamos las apuestas para procesarlas como mercados diferentes");

								// proceso las de handicap asiatico
								LOG.debug(Thread.currentThread(), "Separo del mercado que leemos en el xml las apuestas de tipo handicap Asiatico");
								List<Selection> handicapAsiaticoBets = processAsianHandicapMarketBets(market.getSelection());
								if (handicapAsiaticoBets != null && handicapAsiaticoBets.size() > 0) {
									LOG.debug(Thread.currentThread(), "El mercado tiene varias apuestas de tipo handicap asiatico dentro del mismo nodo, separamos las apuestas de dos en dos para procesarlas como mercados diferentes");
									for (int i = 0; i < handicapAsiaticoBets.size(); i = i + 2) {
										List<Selection> handicapAsiatico = new ArrayList<Selection>();
										int betCounter = i;
										handicapAsiatico.add(handicapAsiaticoBets.get(betCounter));
										handicapAsiatico.add(handicapAsiaticoBets.get(betCounter + 1));
										XmlMarket marketHandicapAsiatico = getMarketAsianHandicapSeveralBets(handicapAsiatico,
												xmlMatch.getXmlMatchParticipants());
										if (marketHandicapAsiatico != null && marketHandicapAsiatico.getXmlMarketBets().size() > 0) {
											marketHandicapAsiatico.setXmlBetType(xmlBetType);
											xmlMarket.add(marketHandicapAsiatico);
										}
									}
								} else {
									XmlMarket marketHandicapAsiatico = getMarketHandicapAsiatico(market, xmlMatch.getXmlMatchParticipants());
									if (marketHandicapAsiatico != null && marketHandicapAsiatico.getXmlMarketBets().size() > 0) {
										marketHandicapAsiatico.setXmlBetType(xmlBetType);
										xmlMarket.add(marketHandicapAsiatico);
									}
								}

								List<Selection> handicap1x2Bets = process1x2HandicapMarketBets(market.getSelection());
								if (handicap1x2Bets != null && handicap1x2Bets.size() > 0) {
									LOG.debug(Thread.currentThread(), "El mercado tiene varias apuestas de tipo 1x2 handicap dentro del mismo nodo, separamos las apuestas de dos en dos para procesarlas como mercados diferentes");
									for (int i = 0; i < handicap1x2Bets.size(); i = i + 3) {
										List<Selection> handicap1x2 = new ArrayList<Selection>();
										int betCounter = i;
										handicap1x2.add(handicap1x2Bets.get(betCounter));
										handicap1x2.add(handicap1x2Bets.get(betCounter + 1));
										handicap1x2.add(handicap1x2Bets.get(betCounter + 2));
										XmlMarket market1x2handicap = getMarket1x2HandicapSeveralBets(handicap1x2,
												xmlMatch.getXmlMatchParticipants());
										if (market1x2handicap != null && market1x2handicap.getXmlMarketBets().size() > 0) {
											XmlBetType bet1x2 = new XmlBetType();
											bet1x2.setBetType(BetTypeBetGun.UNO_X_DOS_HANDICAP);
											market1x2handicap.setXmlBetType(bet1x2);
											xmlMarket.add(market1x2handicap);
										}
									}
								} else {
									XmlMarket market1x2handicap = getMarketUnoXDosHandicap(market, xmlMatch.getXmlMatchParticipants());
									if (market1x2handicap != null && market1x2handicap.getXmlMarketBets().size() > 0) {
										XmlBetType bet1x2 = new XmlBetType();
										bet1x2.setBetType(BetTypeBetGun.UNO_X_DOS_HANDICAP);
										market1x2handicap.setXmlBetType(bet1x2);
										xmlMarket.add(market1x2handicap);
									}
								}

							} else {
								XmlMarket marketHandicapAsiatico = getMarketHandicapAsiatico(market, xmlMatch.getXmlMatchParticipants());
								if (marketHandicapAsiatico != null && marketHandicapAsiatico.getXmlMarketBets().size() > 0) {
									marketHandicapAsiatico.setXmlBetType(xmlBetType);
									xmlMarket.add(marketHandicapAsiatico);
								}
							}
						} else if (betType.equals(BetTypeBetGun.MAS_MENOS)) {
							if (market.getSelection().size() >= 2) {
								LOG.debug(Thread.currentThread(), "El mercado tiene varias apuestas de tipo masmenos dentro del mismo nodo, separamos las apuestas de dos en dos para procesarlas como mercados diferentes");
								for (int i = 0; i < market.getSelection().size(); i = i + 2) {
									List<Selection> masMenosBets = new ArrayList<Selection>();
									int betCounter = i;
									if (market.getSelection().get(betCounter).getValue().split("-")[0].trim().equals("")) {
										masMenosBets.add(market.getSelection().get(betCounter));
										masMenosBets.add(market.getSelection().get(++betCounter));
										XmlMarket marketMasMenos = getMarketMasMenosSeveralBets(masMenosBets);
										if (marketMasMenos != null && marketMasMenos.getXmlMarketBets().size() > 0) {
											marketMasMenos.setXmlBetType(xmlBetType);
											xmlMarket.add(marketMasMenos);
										}
									}
								}
							} else {
								XmlMarket marketMasMenos = getMarketMasMenos(market);
								if (marketMasMenos.getXmlMarketBets() != null && marketMasMenos.getXmlMarketBets().size() > 0) {
									marketMasMenos.setXmlBetType(xmlBetType);
									xmlMarket.add(marketMasMenos);
								}
							}

						} else if (betType.equals(BetTypeBetGun.UNO_X_DOS)) {
							XmlMarket market1x2 = getMarketUnoXDos(market, xmlMatch.getXmlMatchParticipants());
							if (market1x2.getXmlMarketBets() != null && market1x2.getXmlMarketBets().size() > 0) {
								market1x2.setXmlBetType(xmlBetType);
								xmlMarket.add(market1x2);
							}
						}
						// } else if (betType
						// .equals(BetTypeBetGun.UNO_X_DOS_HANDICAP)) {
						// xmlMarket = getMarketUnoXDosHandicap(
						// market.getSelection(),
						// xmlMatch.getXmlMatchParticipants());
						// }

						if (xmlMarket != null) {
							for (XmlMarket marketList : xmlMarket) {
								if (marketList.getXmlMarketBets().size() > 0) {
									xmlMatch.addXmlMarket(marketList);
								}
							}

						}

					}
				}

				if (xmlMatch.getXmlMarkets() != null && xmlMatch.getXmlMarkets().size() > 0) {
					xmlBookmakerEvents.addXmlMatch(xmlMatch);
				}
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(Thread.currentThread(), errorMessage, e);
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: " + JaxbUtils.writeXML(betBrain, Betbrain.class);
			LOG.error(Thread.currentThread(), errorMessage, e);
		}

		LOG.info(Thread.currentThread(), "Fin del lector de betgun");
		return xmlBookmakerEvents;
	}

	/**
	 * Gets the market1x2 handicap several bets.
	 * 
	 * @param handicap1x2
	 *            the handicap1x2
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market1x2 handicap several bets
	 */
	private XmlMarket getMarket1x2HandicapSeveralBets(final List<Selection> handicap1x2,
			final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		String handicap = "";
		for (Selection bet : handicap1x2) {
			String[] resultSplit = bet.getValue().split("-");
			if (bet.getValue().startsWith("0")) {
				handicap = "-" + resultSplit[1];
			} else {
				handicap = resultSplit[0];
			}
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
			Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
			if (bet.getName().equals(ONE) || bet.getName().equals(ALTERNATE_ONE)) {
				((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
			} else if (bet.getName().equals(TWO) || bet.getName().equals(ALTERNATE_TWO)) {
				((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
			} else if (bet.getName().equals(DRAW) || bet.getName().equals(ALTERNATE_DRAW)) {
				((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.DRAW);
			}
			// Url de la apuesta
			XmlUrl beturl = new XmlUrl();
			beturl.setUrl(bet.getSlipURL());
			xmlMarketBet.setXmlUrl(beturl);
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}

		for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
			((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicap));
		}
		return xmlMarket;
	}

	/**
	 * Gets the market asian handicap several bets.
	 * 
	 * @param handicapAsiatico
	 *            the handicap asiatico
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market asian handicap several bets
	 */
	private XmlMarket getMarketAsianHandicapSeveralBets(final List<Selection> handicapAsiatico,
			final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		String asianHandicap = "";
		for (Selection bet : handicapAsiatico) {
			String[] resultSplit = bet.getValue().split("-");
			if (bet.getValue().startsWith("0")) {
				asianHandicap = "-" + resultSplit[1];
			} else {
				asianHandicap = resultSplit[0];
			}
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
			XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();
			if (bet.getName().equals(ONE) || bet.getName().equals(ALTERNATE_ONE)) {
				((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
			} else if (bet.getName().equals(TWO) || bet.getName().equals(ALTERNATE_TWO)) {
				((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
			}
			// Url de la apuesta
			XmlUrl beturl = new XmlUrl();
			beturl.setUrl(bet.getSlipURL());
			xmlMarketBet.setXmlUrl(beturl);
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}

		for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
			((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(asianHandicap));
		}
		return xmlMarket;
	}

	/**
	 * Separa del mercado las apuestas correspondientes a handicap 1x2.
	 * 
	 * @param selection
	 *            el mercado del xml
	 * @return List result el conjunto de apuestas correspondientes solo a
	 *         handicap asiatico
	 */
	private List<Selection> process1x2HandicapMarketBets(final List<Selection> selection) {
		List<Selection> result = new ArrayList<Selection>();
		for (Selection bet : selection) {
			if (!bet.getValue().contains(".5")) {
				result.add(bet);
			}
		}

		return result;
	}

	/**
	 * Separa del mercado las apuestas correspondientes a handicap asiatico.
	 * 
	 * @param selection
	 *            el mercado del xml
	 * @return List result el conjunto de apuestas correspondientes solo a
	 *         handicap asiatico
	 */
	private List<Selection> processAsianHandicapMarketBets(final List<Selection> selection) {
		List<Selection> result = new ArrayList<Selection>();
		for (Selection bet : selection) {
			if (bet.getValue().contains(".5")) {
				result.add(bet);
			}
		}

		return result;
	}

	/**
	 * Gets the market mas menos several bets.
	 * 
	 * @param masMenosBets
	 *            the mas menos bets
	 * @return the market mas menos several bets
	 */
	private XmlMarket getMarketMasMenosSeveralBets(final List<Selection> masMenosBets) {
		XmlMarket xmlMarket = new XmlMarket();
		for (Selection bet : masMenosBets) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
			StringUtil util = new StringUtil();
			String masMenos = bet.getValue().substring(bet.getValue().indexOf("-"));
			masMenos = util.replaceCharacter(masMenos, "-", "");
			masMenos = util.replaceCharacter(masMenos, "+", "");
			if (bet.getName().equalsIgnoreCase(OVER) || bet.getName().equalsIgnoreCase(ALTERNATE_OVER)) {
				((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MAS);
			} else if (bet.getName().equalsIgnoreCase(UNDER) || bet.getName().equalsIgnoreCase(ALTERNATE_UNDER)) {
				((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MENOS);
			}
			((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(masMenos));

			// Url de la apuesta
			XmlUrl beturl = new XmlUrl();
			beturl.setUrl(bet.getSlipURL());
			xmlMarketBet.setXmlUrl(beturl);
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Gets the market uno x dos.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos
	 */
	public XmlMarket getMarketUnoXDos(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();

		for (Selection bet : ((Subevent) market).getSelection()) {
			Boolean agregar = Boolean.FALSE;
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			Xml1X2Attribute attribute = new Xml1X2Attribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
			if (bet.getName().equals(ONE) || bet.getName().equals(ALTERNATE_ONE)) {
				attribute.setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				agregar = Boolean.TRUE;
			} else if (bet.getName().equals(DRAW) || bet.getName().equals(ALTERNATE_DRAW)) {
				xmlMarketBet.setXmlMatchParticipant(getDrawParticipant());
				attribute.setResult(Result.DRAW);
				agregar = Boolean.TRUE;
			} else if (bet.getName().equals(TWO) || bet.getName().equals(ALTERNATE_TWO)) {
				attribute.setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				agregar = Boolean.TRUE;
			}
			if (agregar) {
				// Url de la apuesta
				XmlUrl beturl = new XmlUrl();
				beturl.setUrl(bet.getSlipURL());
				xmlMarketBet.setXmlUrl(beturl);
				xmlMarketBet.setXmlAttribute(attribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		}
		return xmlMarket;
	}

	/**
	 * Gets the market mas menos.
	 * 
	 * @param market
	 *            the market
	 * @return the market mas menos
	 */
	public XmlMarket getMarketMasMenos(final Object market) {
		XmlMarket xmlMarket = new XmlMarket();
		if (((Subevent) market).getSelection().size() == 2) {
			for (Selection bet : ((Subevent) market).getSelection()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				StringUtil util = new StringUtil();
				String masMenos = util.replaceCharacter(bet.getValue(), "-", "");
				masMenos = util.replaceCharacter(masMenos, "+", "");
				if (bet.getName().equalsIgnoreCase(OVER)) {
					((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MAS);
				} else if (bet.getName().equalsIgnoreCase(UNDER)) {
					((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MENOS);
				}
				((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(masMenos));

				// Url de la apuesta
				XmlUrl beturl = new XmlUrl();
				beturl.setUrl(bet.getSlipURL());
				xmlMarketBet.setXmlUrl(beturl);
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} else {
			return null;
		}
	}

	/**
	 * Gets the market handicap asiatico.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market handicap asiatico
	 */
	public XmlMarket getMarketHandicapAsiatico(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		String handicapAsiatico = "";
		if (((Subevent) market).getSelection().size() == 2) {
			for (Selection bet : ((Subevent) market).getSelection()) {
				String[] resultSplit = bet.getValue().split("-");
				if (bet.getValue().startsWith("0")) {
					handicapAsiatico = "-" + resultSplit[1];
				} else {
					handicapAsiatico = resultSplit[0];
				}
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();
				if (bet.getName().equals(ONE) || bet.getName().equals(ALTERNATE_ONE)) {
					((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.ONE);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (bet.getName().equals(TWO) || bet.getName().equals(ALTERNATE_TWO)) {
					((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				}
				// Url de la apuesta
				XmlUrl beturl = new XmlUrl();
				beturl.setUrl(bet.getSlipURL());
				xmlMarketBet.setXmlUrl(beturl);
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}

			for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
				((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapAsiatico));
			}
			return xmlMarket;
		} else {
			return null;
		}

	}

	/**
	 * Gets the market ganador partido.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador partido
	 */
	public XmlMarket getMarketGanadorPartido(final Object market, Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		for (Selection bet : ((Subevent) market).getSelection()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
			XmlMatchWinnerAttribute attribute = new XmlMatchWinnerAttribute();
			if (bet.getName().equals(ONE) || bet.getName().equals(ALTERNATE_ONE)) {
				XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, true);
				attribute.setWinnerName(xmlMatchParticipant);
				attribute.setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			} else if (bet.getName().equals(TWO) || bet.getName().equals(ALTERNATE_TWO)) {
				XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, false);
				attribute.setWinnerName(xmlMatchParticipant);
				attribute.setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			}
			// Url de la apuesta
			XmlUrl beturl = new XmlUrl();
			beturl.setUrl(bet.getSlipURL());
			xmlMarketBet.setXmlUrl(beturl);
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Gets the market ganador.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador
	 */
	public XmlMarket getMarketGanador(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants) {
		XmlMarket xmlMarket = new XmlMarket();
		for (Selection bet : ((Subevent) market).getSelection()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlWinnerAttribute attribute = new XmlWinnerAttribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
			XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
			xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			attribute.setWinner(xmlMatchParticipant);
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			// Url de la apuesta
			XmlUrl beturl = new XmlUrl();
			beturl.setUrl(bet.getSlipURL());
			xmlMarketBet.setXmlUrl(beturl);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Resolve bet type.
	 * 
	 * @param pMarket
	 *            the market
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(final Subevent pMarket) {
		LOG.debug(Thread.currentThread(), "Resolvemos el tipo de apuesta");
		XmlBetType xmlBetType = new XmlBetType();

		xmlBetType.setBetType(BetTypeBetGun.getTypeByValue(pMarket.getTitle()));

		if (xmlBetType.getBetType() != null) {
			if (xmlBetType.getBetType().equals(BetTypeBetGun.UNO_X_DOS) && pMarket.getSelection().size() == 2) {
				xmlBetType.setBetType(BetTypeBetGun.GANADOR_PARTIDO);
			}
			LOG.debug(Thread.currentThread(), "El tipo de apuesta resuelto es: " + xmlBetType.getBetType().getId());
		}

		return xmlBetType;
	}

	/**
	 * Resolver bet type event.
	 * 
	 * @param market
	 *            the market
	 * @return the xml bet event
	 */
	private XmlBetEvent resolverBetTypeEvent(final Subevent market, final XmlSport sport, final XmlBetType betType) {
		LOG.debug(Thread.currentThread(), "Resolvemos el evento de apuesta");

		XmlBetEvent xmlBetEvent = new XmlBetEvent();

		xmlBetEvent.setBetEvent(BetEventBetGun.getEventByValue(market.getTitle()));
		
		// añadimos el tratamiento especial segun el tipo de deporte
		if (betType.getBetType().equals(BetTypeBetGun.GANADOR_PARTIDO) 
				|| betType.getBetType().equals(BetTypeBetGun.HANDICAP_ASIATICO)
				|| betType.getBetType().equals(BetTypeBetGun.MAS_MENOS)){
			if (SportBetGunResolver.isBasketball(sport.getName()) 
					&& (xmlBetEvent.getBetEvent() == null || xmlBetEvent.getBetEvent().equals(BetEventBetGun.PARTIDO_COMPLETO))){
				xmlBetEvent.setBetEvent(BetEventBetGun.PARTIDO_COMPLETO_PRORROGA);
			}
		}

		return xmlBetEvent;
	}

	/**
	 * Gets the participants.
	 * 
	 * @param pName
	 *            the name
	 * @param separator
	 *            the separator
	 * @param tournament
	 *            the tournament
	 * @return the participants
	 */
	private Collection<XmlMatchParticipant> getParticipants(String pName, String separator, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		String[] participantString = pName.split(separator);
		XmlMatchParticipant homeParticipant = new XmlMatchParticipant(participantString[0].trim(), tournament);
		homeParticipant.setHomeParticipant(true);
		participants.add(homeParticipant);
		if (participantString.length > 1) {
			XmlMatchParticipant awayParticipant = new XmlMatchParticipant(participantString[1].trim(), tournament);
			awayParticipant.setAwayParticipant(true);
			participants.add(awayParticipant);
		}
		return participants;
	}

	/**
	 * Gets the all participants.
	 * 
	 * @param pChoice
	 *            the choice
	 * @param tournament
	 *            the tournament
	 * @return the all participants
	 */
	private Collection<XmlMatchParticipant> getAllParticipants(List<Selection> pChoice, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		for (Selection choice : pChoice) {
			XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(choice.getName(), tournament);
			participants.add(xmlMatchParticipant);
		}
		return participants;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#getBookmakerId()
	 */
	/** {@inheritDoc} */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BETGUN_COM_ID.objectId().toString();
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket xmlMarket = new XmlMarket();
		String handicap = "";
		if (((Subevent) market).getSelection().size() == 3) {
			for (Selection bet : ((Subevent) market).getSelection()) {
				String[] resultSplit = bet.getValue().split("-");
				if (bet.getValue().startsWith("0")) {
					handicap = "-" + resultSplit[1];
				} else {
					handicap = resultSplit[0];
				}
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
				if (bet.getName().equals(ONE) || bet.getName().equals(ALTERNATE_ONE)) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (bet.getName().equals(TWO) || bet.getName().equals(ALTERNATE_TWO)) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				} else if (bet.getName().equals(DRAW) || bet.getName().equals(ALTERNATE_DRAW)) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.DRAW);
				}
				// Url de la apuesta
				XmlUrl beturl = new XmlUrl();
				beturl.setUrl(bet.getSlipURL());
				xmlMarketBet.setXmlUrl(beturl);
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}

			for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
				((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicap));
			}
			return xmlMarket;
		} else {
			return null;
		}

	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketMaximoGoleador(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants) throws XmlReaderException {
		// TODO Auto-generated method stub
		return null;
	}

}
