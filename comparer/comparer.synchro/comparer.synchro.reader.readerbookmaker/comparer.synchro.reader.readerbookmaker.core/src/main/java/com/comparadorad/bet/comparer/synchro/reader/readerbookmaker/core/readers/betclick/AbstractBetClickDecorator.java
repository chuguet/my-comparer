/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betclick;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Bet;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Bets;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Choice;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Match;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Sport;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Sports;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractBetClickDecorator.
 */
public abstract class AbstractBetClickDecorator extends AbstractXmlFilereader {

	/** The Constant MATCH_RESULT. */
	private static final String MATCH_RESULT = "Match Result";

	/** The Constant HANDICAP_RESULT. */
	private static final String HANDICAP_RESULT = "Handicap Result";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	/** The Constant ONE. */
	private static final String ONE = "%1%";

	/** The Constant TWO. */
	private static final String TWO = "%2%";

	/** The Constant DRAW. */
	private static final String DRAW = "Draw";

	/** The Constant OVER. */
	private static final String OVER = "Over";

	/** The Constant UNDER. */
	private static final String UNDER = "Under";

	/** The Constant MATCH_WINNER. */
	private static final String MATCH_WINNER = "Match Winner";

	/** The Constant BETCLICK_PARTICIPANTS_SEPARATOR. */
	private static final String BETCLICK_PARTICIPANTS_SEPARATOR = " - ";

	/** The Constant TOTAL_GOALS. */
	private static final String TOTAL_GOALS = "Total Goals";

	/** The Constant _BLANK. */
	private static final String _BLANK = " ";

	@Autowired
	private ComparerWrapperLog LOG;

	/**
	 * Read.
	 * 
	 * @param file
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
	public XmlBookmakerEvents readXml(final InputStream file,
			final CfgBookmakerConfiguration bookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "Inicio reader BetClick/Expekt");
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Mapper mapper = getMapper();
		Sports sports = null;
		try {
			sports = (Sports) JaxbUtils.readXML(file, Sports.class);
			XmlDate xmlDate = new XmlDate(new Date(Long.valueOf(sports
					.getFileDate().toGregorianCalendar().getTimeInMillis())));
			xmlDate.setProviderTimeZone(bookmakerConfiguration.getTimeZone());
			xmlBookmakerEvents.setFileDate(xmlDate);
			XmlMatch xmlMatch = null;
			for (Sport sport : sports.getSport()) {
				XmlSport xmlSport = mapper.map(sport, XmlSport.class,
						"sportToXmlSportBetClick");
				LOG.debug(Thread.currentThread(),
						new StringBuffer().append("Se procesa deporte ")
								.append(xmlSport.getName()).toString());
				for (Event event : sport.getEvent()) {
					XmlTournament xmlTournament = mapper
							.map(event, XmlTournament.class,
									"eventToXmlTournamentBetClick");
					xmlTournament.setXmlSport(xmlSport);
					for (Match match : event.getMatch()) {

						xmlMatch = mapper.map(match, XmlMatch.class,
								"matchToXmlMatchBetClick");
						xmlMatch.setName(match.getName());
						xmlDate = getStartDate(match.getStartDate().toString(),
								DATE_FORMAT,
								bookmakerConfiguration.getTimeZone());
						xmlMatch.setStartDate(xmlDate);

						xmlMatch.setXmlTournament(xmlTournament);
						xmlMatch.setBmInternalId(new BmInternalId(String
								.valueOf(match.getId())));
						Bets bets = match.getBets();
						for (Bet bet : bets.getBet()) {
							try{
							// Resolvemos el tipo de apuesta
							XmlBetType xmlBetType = resolveBetType(bet);
							if (xmlBetType.getBetType() != null) {

								// Inicializamos el evento de la apuesta
								XmlBetEvent xmlBetEvent = resolveBetEvent(
										Integer.toString((int) sport.getId()),
										bet.getName(), xmlBetType);
								xmlBetType.setXmlBetEvent(xmlBetEvent);
								// Actualizamos en el market el tipo de apuesta
								xmlBetType.setCode(bet.getCode());

								// Los participantes se pueden obtener del name
								// del match o del name del choice
								if (xmlBetType.getBetType() != BetTypeBetClick.GANADOR) {
									xmlMatch.setXmlMatchParticipants(getParticipants(
											match.getName(),
											BETCLICK_PARTICIPANTS_SEPARATOR,
											xmlTournament));
								} else {
									xmlMatch.setXmlMatchParticipants(getAllParticipants(
											bet.getChoice(), xmlTournament));
								}

								List<XmlMarket> xmlMarkets = new ArrayList<XmlMarket>();
								XmlMarket xmlMarket = null;
								IBetType betType = xmlBetType.getBetType();
								if (betType.equals(BetTypeBetClick.GANADOR)) {
									xmlMarket = getMarketGanador(
											bet.getChoice(),
											xmlMatch.getXmlMatchParticipants());
									xmlMarkets.add(xmlMarket);
								} else if (betType
										.equals(BetTypeBetClick.GANADOR_PARTIDO)) {
									xmlMarket = getMarketGanadorPartido(
											bet.getChoice(),
											xmlMatch.getXmlMatchParticipants());
									xmlMarkets.add(xmlMarket);
								} else if (betType
										.equals(BetTypeBetClick.HANDICAP_ASIATICO)) {
									xmlMarket = getMarketHandicapAsiatico(
											bet.getChoice(),
											xmlMatch.getXmlMatchParticipants());
									xmlMarkets.add(xmlMarket);
								} else if (betType
										.equals(BetTypeBetClick.MAS_MENOS)) {

									if (bet.getChoice().size() > 2
											&& !bet.getName()
													.trim()
													.equalsIgnoreCase(
															TOTAL_GOALS)) {
										LOG.debug(Thread.currentThread(),
												"El mercado tiene varias apuestas de tipo mas menos dentro de el");
										xmlMarkets = getMarketMasMenosSeveralBets(bet
												.getChoice());
									} else {
										// TODO: Por ahora, el tipo de apuesta
										// MAS_MENOS
										// con literal Total Goals lo
										// contemplamos
										// solo para deportes tipo balonmano que
										// traen un solo resultado de MAS_MENOS,
										// queda
										// implementar para futbol que tendria
										// tres
										// resultados
										if (bet.getChoice().size() == 2) {
											xmlMarket = getMarketMasMenos(bet
													.getChoice());
											xmlMarkets.add(xmlMarket);
										}
									}
								} else if (betType
										.equals(BetTypeBetClick.UNO_X_DOS)) {
									xmlMarket = getMarketUnoXDos(
											bet.getChoice(),
											xmlMatch.getXmlMatchParticipants());
									xmlMarkets.add(xmlMarket);
								} else if (betType
										.equals(BetTypeBetClick.UNO_X_DOS_HANDICAP)) {
									xmlMarket = getMarketUnoXDosHandicap(
											bet.getChoice(),
											xmlMatch.getXmlMatchParticipants());
									xmlMarkets.add(xmlMarket);
								} else {
									LOG.warn(
											Thread.currentThread(),
											new StringBuffer()
													.append("El tipo de apuesta ")
													.append(betType.getId())
													.append(" no se va a procesar")
													.toString());
								}
								for (XmlMarket market : xmlMarkets) {
									market.setXmlBetType(xmlBetType);
									if (market != null
											&& market.getXmlMarketBets() != null) {
										xmlMatch.addXmlMarket(market);
									}
								}
							}
						} catch (Exception e) {
							String errorMessage = "Error parseando el mercado: "
									+ JaxbUtils.writeXML(bet, Bet.class);
							LOG.error(Thread.currentThread(), errorMessage, e);
						}
						}
						if (xmlMatch.getXmlMarkets() != null
								&& xmlMatch.getXmlMarkets().size() > 0) {
							xmlBookmakerEvents.addXmlMatch(xmlMatch);
						}
					}
				}
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(Thread.currentThread(), errorMessage, e);
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: "
					+ JaxbUtils.writeXML(sports, Sports.class);
			LOG.error(Thread.currentThread(), errorMessage, e);
		}

		return xmlBookmakerEvents;
	}

	/**
	 * Gets the market uno x dos handicap.
	 * 
	 * @param pChoice
	 *            the choice
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos handicap
	 */
	private XmlMarket getMarketUnoXDosHandicap(List<Choice> pChoice,
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		LOG.debug(Thread.currentThread(), "Resolvemos market 1X2 Handicap");
		XmlMarket xmlMarket = new XmlMarket();
		String handicapHomeValueFirst = "";
		for (Choice choice : pChoice) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			Xml1X2HandicapAttribute attribute = new Xml1X2HandicapAttribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
					String.valueOf(choice.getOdd()));
			String[] resultSplit = choice.getName().split(" ");
			if ((resultSplit[0]).equals(ONE)) {
				attribute.setResult(Result.ONE);
				handicapHomeValueFirst = resultSplit[1];
				xmlMarketBet.setXmlMatchParticipant(getParticipant(
						pXmlMatchParticipants, true));
			} else if ((resultSplit[0]).equals(DRAW)) {
				attribute.setResult(Result.DRAW);
			} else if ((resultSplit[0]).equals(TWO)) {
				attribute.setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(
						pXmlMatchParticipants, false));
			}
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
			((Xml1X2HandicapAttribute) bet.getXmlAttribute())
					.setFirstValue(Double.parseDouble(handicapHomeValueFirst));
		}
		return xmlMarket;
	}

	/**
	 * Gets the market uno x dos.
	 * 
	 * @param pChoice
	 *            the choice
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos
	 */
	private XmlMarket getMarketUnoXDos(List<Choice> pChoice,
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		LOG.debug(Thread.currentThread(), "Resolvemos market 1X2");
		XmlMarket xmlMarket = new XmlMarket();
		for (Choice choice : pChoice) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			Xml1X2Attribute attribute = new Xml1X2Attribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
					String.valueOf(choice.getOdd()));
			if (choice.getName().equals(ONE)) {
				attribute.setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(
						pXmlMatchParticipants, true));
			} else if (choice.getName().equals(DRAW)) {
				attribute.setResult(Result.DRAW);
			} else if (choice.getName().equals(TWO)) {
				attribute.setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(
						pXmlMatchParticipants, false));
			}
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Gets the market mas menos.
	 * 
	 * @param pChoice
	 *            the choice
	 * @return the market mas menos
	 */
	private XmlMarket getMarketMasMenos(List<Choice> pChoice) {
		LOG.debug(Thread.currentThread(), "Resolvemos market MasMenos");
		XmlMarket xmlMarket = new XmlMarket();
		for (Choice choice : pChoice) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMoreLessAttribute attribute = new XmlMoreLessAttribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
					String.valueOf(choice.getOdd()));
			String[] resultSplit = choice.getName().split(_BLANK);
			if ((resultSplit[0]).equalsIgnoreCase(OVER)) {
				attribute.setMasMenos(MasMenos.MAS);
			} else if ((resultSplit[0]).equalsIgnoreCase(UNDER)) {
				attribute.setMasMenos(MasMenos.MENOS);
			}
			attribute.setTotalGoal(Double.valueOf(resultSplit[1]));
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Obtiene la lista de mercados para apuestas de mas menos en la que en un
	 * mismo mercado del xml vengan varias.
	 * 
	 * @param choice
	 *            the choice
	 * @return the market mas menos several bets
	 */
	private List<XmlMarket> getMarketMasMenosSeveralBets(
			final List<Choice> choice) {
		List<XmlMarket> result = new ArrayList<XmlMarket>();
		List<Choice> listaUnder = new ArrayList<Choice>();
		List<Choice> listaOver = new ArrayList<Choice>();

		// Recorro el choice y separo en under y en over
		for (Choice bet : choice) {
			if (bet.getName().contains(UNDER)) {
				listaUnder.add(bet);
			} else {
				listaOver.add(bet);
			}
		}

		// Solo sigo si las listas son iguales, sino el xml viene mal informado.
		if (listaUnder.size() == listaOver.size()) {
			// Recorro el under para ir formando los mercados
			for (Choice betUnder : listaUnder) {
				String valorUnder = betUnder.getName().replace(UNDER, "")
						.trim();
				// Recorro la lista over para tener tanto el under y el over del
				// mismo valor juntos
				for (Choice betOver : listaOver) {
					String valorOver = betOver.getName().replace(OVER, "")
							.trim();
					// Hemos encontrado la pareja del under sobre el que estamos
					// iterando con lo que formamos el mercado
					if (valorUnder.equals(valorOver)) {
						XmlMarket xmlMarket = new XmlMarket();
						XmlMarketBet xmlMarketBetUnder = new XmlMarketBet();
						XmlMarketBetOdd xmlMarketBetOddUnder = new XmlMarketBetOdd(
								String.valueOf(betUnder.getOdd()));
						xmlMarketBetUnder
								.setXmlMarketBetOdd(xmlMarketBetOddUnder);

						XmlMarketBet xmlMarketBetOver = new XmlMarketBet();
						XmlMarketBetOdd xmlMarketBetOddOver = new XmlMarketBetOdd(
								String.valueOf(betOver.getOdd()));
						xmlMarketBetOver
								.setXmlMarketBetOdd(xmlMarketBetOddOver);

						XmlMoreLessAttribute attributeUnder = new XmlMoreLessAttribute();
						attributeUnder.setMasMenos(MasMenos.MENOS);
						attributeUnder.setTotalGoal(Double.valueOf(valorUnder));
						xmlMarketBetUnder.setXmlAttribute(attributeUnder);

						XmlMoreLessAttribute attributeOver = new XmlMoreLessAttribute();
						attributeOver.setMasMenos(MasMenos.MAS);
						attributeOver.setTotalGoal(Double.valueOf(valorOver));
						xmlMarketBetOver.setXmlAttribute(attributeOver);

						xmlMarket.addXmlBet(xmlMarketBetUnder);
						xmlMarket.addXmlBet(xmlMarketBetOver);
						result.add(xmlMarket);
						break;
					}
				}
			}
		}

		return result;
	}

	/**
	 * Gets the market handicap asiatico.
	 * 
	 * @param pChoice
	 *            the choice
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market handicap asiatico
	 */
	private XmlMarket getMarketHandicapAsiatico(List<Choice> pChoice,
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		LOG.debug(Thread.currentThread(), "Resolvemos market Handicap Asiatico");
		XmlMarket xmlMarket = new XmlMarket();
		for (Choice choice : pChoice) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
					String.valueOf(choice.getOdd()));
			XmlAsianHandicapAttribute attribute = new XmlAsianHandicapAttribute();
			String[] resultSplit = choice.getName().split("%");
			if ((resultSplit[1]).equals("1")) {
				attribute.setAsianResult(AsianResult.ONE);
				attribute.setFirstValue(Double.parseDouble(resultSplit[2]));
				xmlMarketBet.setXmlMatchParticipant(getParticipant(
						pXmlMatchParticipants, true));
			} else if ((resultSplit[1]).equals("2")) {
				attribute.setAsianResult(AsianResult.TWO);
				attribute
						.setFirstValue(Double.parseDouble(resultSplit[2]) * -1);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(
						pXmlMatchParticipants, false));
			}
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Gets the market ganador partido.
	 * 
	 * @param pChoice
	 *            the choice
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador partido
	 */
	private XmlMarket getMarketGanadorPartido(List<Choice> pChoice,
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		LOG.debug(Thread.currentThread(), "Resolvemos market Ganador Partido");
		XmlMarket xmlMarket = new XmlMarket();
		for (Choice choice : pChoice) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
					String.valueOf(choice.getOdd()));
			XmlMatchWinnerAttribute attribute = new XmlMatchWinnerAttribute();
			if (choice.getName().equals(ONE)) {
				XmlMatchParticipant xmlMatchParticipant = getParticipant(
						pXmlMatchParticipants, true);
				attribute.setWinnerName(xmlMatchParticipant);
				attribute.setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			} else if (choice.getName().equals(TWO)) {
				XmlMatchParticipant xmlMatchParticipant = getParticipant(
						pXmlMatchParticipants, false);
				attribute.setWinnerName(xmlMatchParticipant);
				attribute.setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			}
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Gets the market ganador.
	 * 
	 * @param pChoice
	 *            the choice
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador
	 */
	private XmlMarket getMarketGanador(List<Choice> pChoice,
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		LOG.debug(Thread.currentThread(), "Resolvemos market Ganador");
		XmlMarket xmlMarket = new XmlMarket();
		for (Choice choice : pChoice) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlWinnerAttribute attribute = new XmlWinnerAttribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
					String.valueOf(choice.getOdd()));
			XmlMatchParticipant xmlMatchParticipant = getParticipantByName(
					pXmlMatchParticipants, choice.getName());
			xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			attribute.setWinner(xmlMatchParticipant);
			xmlMarketBet.setXmlAttribute(attribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/**
	 * Resolve bet type.
	 * 
	 * @param pBet
	 *            the bet
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(final Bet pBet) {
		XmlBetType xmlBetType = new XmlBetType();
		// En caso de match winner seguro que la apuesta es ganador de partido
		if (pBet.getName().contains(MATCH_WINNER)) {
			xmlBetType.setBetType(BetTypeBetClick.GANADOR_PARTIDO);
			// En caso de match result, habria que ver si es el
			// tipo de apuesta es de 1x2 o de Ganador de partido
		} else if (pBet.getName().contains(MATCH_RESULT)) {
			if (pBet.getChoice().size() == 3) {
				xmlBetType.setBetType(BetTypeBetClick.UNO_X_DOS);
			} else {
				xmlBetType.setBetType(BetTypeBetClick.GANADOR_PARTIDO);
			}
			// En caso de handicap result, habria que ver si es el
			// tipo de apuesta es de 1x2 handicap o de handicap asiatico
		} else if (pBet.getName().contains(HANDICAP_RESULT)) {
			if (pBet.getChoice().size() == 3) {
				xmlBetType.setBetType(BetTypeBetClick.UNO_X_DOS_HANDICAP);
			} else {
				xmlBetType.setBetType(BetTypeBetClick.HANDICAP_ASIATICO);
			}
		} else {
			IBetType betType = BetTypeBetClick.getTypeByValue(pBet.getName());
			if (betType != null) {
				xmlBetType.setBetType(betType);
			} else {
				LOG.warn(
						Thread.currentThread(),
						new StringBuffer()
								.append("Tipo de apuesta no reconocido: ")
								.append(pBet.getName()).toString());
			}
		}
		return xmlBetType;
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
	private Collection<XmlMatchParticipant> getAllParticipants(
			List<Choice> pChoice, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		for (Choice choice : pChoice) {
			XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
					choice.getName(), tournament);
			participants.add(xmlMatchParticipant);
		}
		return participants;
	}

	/**
	 * Gets the participants.
	 * 
	 * Participants arrive as <match
	 * name="DET Tigers (A. Sanchez) - WAS Nationals (S. Strasburg)" id="578846"
	 * start_date="2013-07-31T00:05:00" live_id="" streaming="0">
	 * 
	 * With the pitcher name within brackets. Brackets an text in brackets is
	 * eliminated with expression regular: "\([^\(\)]*\)"
	 * 
	 * @param pName
	 *            the name
	 * @param separator
	 *            the separator
	 * @param tournament
	 *            the tournament
	 * @return the participants
	 */
	private Collection<XmlMatchParticipant> getParticipants(String pName,
			String separator, final XmlTournament tournament) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		String nameWithoutPitchers = pName.replaceAll("\\([^\\(\\)]*\\)", "");
		String[] participantString = /* pName */nameWithoutPitchers
				.split(separator);

		XmlMatchParticipant homeParticipant = new XmlMatchParticipant(
				participantString[0], tournament);
		homeParticipant.setHomeParticipant(true);
		participants.add(homeParticipant);
		if (participantString.length > 1) {
			XmlMatchParticipant awayParticipant = new XmlMatchParticipant(
					participantString[1], tournament);
			awayParticipant.setAwayParticipant(true);
			participants.add(awayParticipant);
		}
		return participants;
	}

	private XmlBetEvent resolveBetEvent(String sport, String value,
			XmlBetType betType) {
		IBetEvent betEvent = BetEventBetClick.getEventByValue(value);
		XmlBetEvent result;

		if (betType.getBetType().equals(BetTypeBetClick.HANDICAP_ASIATICO)
				|| betType.getBetType().equals(BetTypeBetClick.MAS_MENOS)) {
			if (SportBetclickResolver.isAmericanFootball(sport)
					|| SportBetclickResolver.isBaseball(sport)
					|| SportBetclickResolver.isBasketball(sport)) {
				betEvent = BetEventBetClick.PARTIDO_COMPLETO_PRORROGA;
			}
		} else if (SportBetclickResolver.isTennis(sport)
				&& betEvent == BetEventBetClick.PARTIDO_COMPLETO_PRORROGA) {
			betEvent = BetEventBetClick.PARTIDO_COMPLETO;
		}
		result = new XmlBetEvent(betEvent);
		return result;
	}

}
