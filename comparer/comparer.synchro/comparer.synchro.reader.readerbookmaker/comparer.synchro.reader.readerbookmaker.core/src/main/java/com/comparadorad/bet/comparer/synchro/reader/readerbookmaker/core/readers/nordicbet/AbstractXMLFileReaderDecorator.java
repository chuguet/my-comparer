/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet;

import java.io.InputStream;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeNordicbet;
import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet.Game;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet.Odds;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet.Outcome;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet.OutcomeSet;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet.Participant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.nordicbet.SportsNordicbet;

/**
 * Clase decorador para las casas de apuestas de NORDICBET y TRIOBET.
 */
public abstract class AbstractXMLFileReaderDecorator extends AbstractXmlFilereader implements MarketType {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	/** The Constant RESULT. */
	private static final String RESULT = "Result";

	private static final String RESULT_WINNER = "Result Winner";

	/** The Constant HANDICAP. */
	private static final String HANDICAP = "Handicap";

	/** The MoneyLine Constant */
	private static final String MONEYLYNE = "Moneyline";
	
	/** Mas Menos Literal*/
	private static final String UNDER_OVER = "Under/Over";
	
	/** The Constant INTERNATIONAL. */
	private static final String INTERNATIONAL = "International";

	private static final String SINGLES = "Singles";

	private static final String DOUBLES = "Doubles";

	/** The Constant ONE. */
	private static final String ONE = "1";

	/** The Constant TWO. */
	private static final String TWO = "2";

	/** The Constant OVER. */
	private static final String OVER = "over";

	/** The Constant UNDER. */
	private static final String UNDER = "under";

	/** The Constant DRAW. */
	private static final String DRAW = "X";
	
	/** The NHL Literal*/
	private static final String NHL_ICEHOCKEY = "NHL";	
	
	/** The handicap home value first. */
	private String handicapHomeValueFirst = "";

	/** The handicap home value second. */
	private String handicapHomeValueSecond = "";

	/** The handicap home value first. */
	private String handicapAwayValueFirst = "";

	/** The handicap home value second. */
	private String handicapAwayValueSecond = "";

	/**
	 * Read.
	 * 
	 * @param pFile
	 *            the file
	 * @param bookmakerConfiguration
	 *            the bookmaker configuration
	 * @return the xml bet file reader result
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	public XmlBookmakerEvents readXml(final InputStream pFile, final CfgBookmakerConfiguration bookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Mapper mapper = getMapper();
		Odds odds = null;
		try {
			odds = (Odds) JaxbUtils.readXML(pFile, Odds.class);
			for (Game game : odds.getGame()) {

				Boolean specialGame = checkSpecialGame(game);
				if (!specialGame) {
					XmlMatch xmlMatch = mapper.map(game, XmlMatch.class, "gameToXmlMatchNordicbet");
					XmlTournament xmlTournament = setTournament(game);
					LOG.debug(Thread.currentThread(),
							new StringBuffer("Se procede a leer el match del la competicion: ").append(xmlTournament.getName().toString())
									.toString());
					String dateCorrectFormat = getCorrectDate(game);

					xmlMatch.setStartDate(getStartDate(dateCorrectFormat, DATE_FORMAT, bookmakerConfiguration.getTimeZone()));
					xmlMatch.setLive(Boolean.valueOf(game.getLiveBet()));
					xmlMatch.setXmlTournament(xmlTournament);
					// Resolvemos los participantes
					for (Participant participant : game.getParticipant()) {
						String nombreParticipant = participant.getValue().replaceAll("\\n", "");
						nombreParticipant = nombreParticipant.replaceAll("\\t", "");
						if (participant.getRole() != null && participant.getRole().equals(ONE)) {
							xmlMatch.addXmlMatchParticipantHome(new XmlMatchParticipant(nombreParticipant, xmlTournament));
						} else if (participant.getRole() != null && participant.getRole().equals(TWO)) {
							xmlMatch.addXmlMatchParticipantAway(new XmlMatchParticipant(nombreParticipant, xmlTournament));
						} else {
							xmlMatch.addXmlMatchParticipant(new XmlMatchParticipant(nombreParticipant, xmlTournament));
						}
					}
					for (OutcomeSet outcomeSet : game.getOutcomeSet()) {
						if(outcomeSet.getType()==null) {
							resolveBetTypeWithName(outcomeSet);
						}
						
						// Identificamos tipo de apuesta
						if (outcomeSet.getType() != null) {

							XmlBetType xmlBetType = resolveBetType(outcomeSet);
							if (xmlBetType != null && xmlBetType.getBetType() != null) {

								XmlMarket xmlMarket = null;
								try {
									if (xmlBetType.getBetType().equals(BetTypeNordicbet.GANADOR_PARTIDO)) {
										xmlMarket = getMarketGanadorPartido(outcomeSet, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeNordicbet.GANADOR)) {
										xmlMarket = getMarketGanador(outcomeSet, xmlMatch.getXmlMatchParticipants());
										// Solución bug a diferentes tipos de apuesta de ganador
										// Al torneo se le añade el nombre de tipode ganador de apuesta, es
										// decir, puede ser un tipo de apuesta ganador de grupo o un tipo de
										// apuesta ganador pero segundo de grupo.
										// Eso lo indica el name del nodo OutComeSet
										StringBuffer xmlTournamentAux = new StringBuffer(xmlMatch.getXmlTournament().getName());
										xmlTournamentAux.append(" ");
										xmlTournamentAux.append(((OutcomeSet) outcomeSet).getName());
										xmlMatch.setName(xmlTournamentAux.toString());
										// FIN solucion Bug
									} else if (xmlBetType.getBetType().equals(BetTypeNordicbet.HANDICAP_ASIATICO)) {
										xmlMarket = getMarketHandicapAsiatico(outcomeSet, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeNordicbet.MAS_MENOS)) {
										xmlMarket = getMarketMasMenos(outcomeSet);
									} else if (xmlBetType.getBetType().equals(BetTypeNordicbet.UNO_X_DOS)) {
										xmlMarket = getMarketUnoXDos(outcomeSet, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeNordicbet.UNO_X_DOS_HANDICAP)) {
										xmlMarket = getMarketUnoXDosHandicap(outcomeSet, xmlMatch.getXmlMatchParticipants());
									} /*else if (xmlBetType.getBetType().equals(BetTypeNordicbet.MONEYLINE)) {
										xmlMarket = getMarketGanadorPartido(outcomeSet, xmlMatch.getXmlMatchParticipants());
									}*/
																		
									xmlMarket.setXmlBetType(xmlBetType);
								} catch (TrioNordicbetAttributeException e) {
									LOG.error(Thread.currentThread(),
											new StringBuffer().append("Error al rellenar los atributos del evento, se ignora el evento. ")
													.append(e.getMessage()).toString(), e);
								}

								if (xmlMarket != null && xmlMarket.getXmlBetType() != null
										&& xmlMarket.getXmlBetType().getBetType() != null) {
									xmlMatch.addXmlMarket(xmlMarket);
								}
							}
							
							// FER: Asignar el xmlBetEvent para hockey ... arriesgado.		
							markAsOvertime(outcomeSet.getType(), game, xmlBetType);
/*							
							IBetEvent pEvent = BetEventNordicbet.PARTIDO_COMPLETO;
							XmlBetEvent xmlBetEvent = new XmlBetEvent(pEvent);
							
							if(game.getSport().contains(SportsNordicbet.ICECHOKEY.getId()) && xmlBetType.getBetType()!=null) {
								// 1) Mas Menos y NHL, PRORROGA{
								if(xmlBetType.getBetType().equals(BetTypeNordicbet.MAS_MENOS)){
									if(game.getBreadCrumbs().contains(NHL_ICEHOCKEY)) {
										pEvent = BetEventNordicbet.PARTIDO_COMPLETO_PRORROGA;
									}
								}
								// 2) MoneyLyne Prorroga.
								if(outcomeSet.getType().equalsIgnoreCase(MONEYLYNE)){
									pEvent = BetEventNordicbet.PARTIDO_COMPLETO_PRORROGA;
								}
								
								xmlBetEvent.setBetEvent(pEvent);
								
							} else if(markAsOvertimeOtherSports(game.getSport(), xmlBetType.getBetType())) {
								xmlBetEvent.setBetEvent(BetEventNordicbet.PARTIDO_COMPLETO_PRORROGA);
							}							
							
							xmlBetType.setXmlBetEvent(xmlBetEvent);
*/							
						}											
					}

					if (xmlMatch.getXmlMarkets() != null && xmlMatch.getXmlMarkets().size() > 0) {
						xmlBookmakerEvents.addXmlMatch(xmlMatch);
					}
				}
			}
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: \n" + JaxbUtils.writeXML(odds, Odds.class);
			LOG.error(Thread.currentThread(), errorMessage, e);
		}
		return xmlBookmakerEvents;
	}

	/**
	 * Se encarga de a partir de un determinado partido comprobar si dicho
	 * partido es un partido "especial" es decir un partido inventado que no
	 * existe realmente en la competicion pero que la casa de apuestas lo crea
	 * para crear nuevos tipos de apuestas posibles
	 * 
	 * @param game
	 *            el partido leido del xml
	 * @return booleano indicando si es especial o no
	 */
	private Boolean checkSpecialGame(Game game) {
		Boolean result = Boolean.FALSE;
		if (game.getSeason().toLowerCase().contains("special")) {
			LOG.debug(Thread.currentThread(), "El partido es un partido especial, no lo tratamos");
			result = Boolean.TRUE;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketUnoXDosHandicap(java.lang.Object,
	 * java.util.Collection)
	 */
	public XmlMarket getMarketUnoXDosHandicap(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws TrioNordicbetAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Outcome bet : ((OutcomeSet) market).getOutcome()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));

				String handicap = "";
				String handicap2 = "";

				handicap = bet.getOptionalValue1();
				if (bet.getOptionalValue2() != null) {
					handicap2 = bet.getOptionalValue2();
				}

				if (bet.getName().equalsIgnoreCase(DRAW)) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.DRAW);
				} else if (bet.getName().equalsIgnoreCase(ONE)) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
					handicapHomeValueFirst = handicap;
					handicapHomeValueSecond = handicap2;
				} else if (bet.getName().equalsIgnoreCase(TWO)) {
					((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
					handicapAwayValueFirst = handicap;
					handicapAwayValueSecond = handicap2;
				}

				// Marcamos para todas las apuestas el valor del handicap del
				// home
				if (handicapHomeValueFirst != null && !handicapHomeValueFirst.equals("")) {
					((Xml1X2HandicapAttribute) xmlAttribute).setFirstValue(Double.parseDouble(handicapHomeValueFirst));
				}
				if (handicapHomeValueSecond != null && !handicapHomeValueSecond.equals("")) {
					((Xml1X2HandicapAttribute) xmlAttribute).setSecondValue(Double.parseDouble(handicapHomeValueSecond));
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			if (handicapHomeValueFirst != null && !handicapHomeValueFirst.equals("") && Double.parseDouble(handicapHomeValueFirst) == 0.0) {
				handicapHomeValueFirst = String.valueOf(Double.parseDouble(handicapAwayValueFirst) * -1);
			}
			if (handicapHomeValueSecond != null && !handicapAwayValueSecond.equals("")
					&& Double.parseDouble(handicapHomeValueSecond) == 0.0) {
				handicapHomeValueSecond = String.valueOf(Double.parseDouble(handicapAwayValueSecond) * -1);
			}
			for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
				((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapHomeValueFirst));
				if (handicapHomeValueSecond != null && !handicapHomeValueSecond.equals("")) {
					((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setSecondValue(Double.parseDouble(handicapHomeValueSecond));
				}
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new TrioNordicbetAttributeException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketUnoXDos(java.lang.Object, java.util.Collection)
	 */
	public XmlMarket getMarketUnoXDos(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws TrioNordicbetAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Outcome bet : ((OutcomeSet) market).getOutcome()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				if (bet.getName().equals(ONE)) {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.ONE);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (bet.getName().equals(DRAW)) {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.DRAW);
				} else if (bet.getName().equals(TWO)) {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				}
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new TrioNordicbetAttributeException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketMasMenos(java.lang.Object)
	 */
	public XmlMarket getMarketMasMenos(final Object market) throws TrioNordicbetAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Outcome bet : ((OutcomeSet) market).getOutcome()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = null;
				xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();

				if (bet.getName().equalsIgnoreCase(OVER)) {
					((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MAS);
					if(bet.getOptionalValue1()!=null){
						((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(bet.getOptionalValue1()));
					} else {
						((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(getUnderOverTotalGoalFromName(((OutcomeSet) market).getType())));
					}
				} else if (bet.getName().equalsIgnoreCase(UNDER)) {
					((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MENOS);
					if(bet.getOptionalValue1()!=null)
						((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(bet.getOptionalValue1()));
					else {
						((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(getUnderOverTotalGoalFromName(((OutcomeSet) market).getType())));
					}
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new TrioNordicbetAttributeException(e.getMessage());
		}
	}
	
	private String getUnderOverTotalGoalFromName(/*final OutcomeSet outcomeSet*/String name) {
		int indexOfTwoDots = /*outcomeSet.getType()*/name.indexOf(":");
		if(indexOfTwoDots!=-1) {
			return /*outcomeSet.getType()*/name.substring(indexOfTwoDots+1).trim();
		}

		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketHandicapAsiatico(java.lang.Object,
	 * java.util.Collection)
	 */
	public XmlMarket getMarketHandicapAsiatico(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws TrioNordicbetAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Outcome bet : ((OutcomeSet) market).getOutcome()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = null;
				xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();

				String handicap = "";
				String handicap2 = "";

				handicap = bet.getOptionalValue1();
				if (bet.getOptionalValue2() != null) {
					handicap2 = bet.getOptionalValue2();
				}

				if (bet.getName().equalsIgnoreCase(ONE)) {
					((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.ONE);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
					handicapHomeValueFirst = handicap;
					handicapHomeValueSecond = handicap2;
				} else if (bet.getName().equalsIgnoreCase(TWO)) {
					((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.TWO);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
					handicapAwayValueFirst = handicap;
					handicapAwayValueSecond = handicap2;
				}

				// Marcamos para todas las apuestas el valor del handicap del
				// home
				if (handicapHomeValueFirst != null && !handicapHomeValueFirst.equals("")) {
					((XmlAsianHandicapAttribute) xmlAttribute).setFirstValue(Double.parseDouble(handicapHomeValueFirst));
				}
				if (handicapHomeValueSecond != null && !handicapHomeValueSecond.equals("")) {
					((XmlAsianHandicapAttribute) xmlAttribute).setSecondValue(Double.parseDouble(handicapHomeValueSecond));
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);

			}
			if (handicapHomeValueFirst != null && !handicapHomeValueFirst.equals("") && Double.parseDouble(handicapHomeValueFirst) == 0.0) {
				handicapHomeValueFirst = String.valueOf(Double.parseDouble(handicapAwayValueFirst) * -1);
			}
			if (handicapHomeValueSecond != null && !handicapAwayValueSecond.equals("")
					&& Double.parseDouble(handicapHomeValueSecond) == 0.0) {
				handicapHomeValueSecond = String.valueOf(Double.parseDouble(handicapAwayValueSecond) * -1);
			}
			for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
				((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapHomeValueFirst));
				if (handicapHomeValueSecond != null && !handicapHomeValueSecond.equals("")) {
					((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setSecondValue(Double.parseDouble(handicapHomeValueSecond));
				}
			}
		} catch (Exception e) {
			throw new TrioNordicbetAttributeException(e.getMessage());
		}
		return xmlMarket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketGanador(java.lang.Object, java.util.Collection)
	 */
	public XmlMarket getMarketGanador(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws TrioNordicbetAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {

			for (Outcome bet : ((OutcomeSet) market).getOutcome()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlWinnerAttribute xmlAttribute = new XmlWinnerAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
				((XmlWinnerAttribute) xmlAttribute).setWinner(xmlMatchParticipant);
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new TrioNordicbetAttributeException(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketGanadorPartido(java.lang.Object,
	 * java.util.Collection)
	 */
	public XmlMarket getMarketGanadorPartido(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws TrioNordicbetAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Outcome bet : ((OutcomeSet) market).getOutcome()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOdds()));
				XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();

				String betNameThatIsParticipant = bet.getName();
				if(((OutcomeSet) market).getType().equals(MONEYLYNE)) {
					// El participante se recoge de un nodo interior.
					betNameThatIsParticipant = bet.getParticipant().getValue();
				}				
				
				if (betNameThatIsParticipant.equals(getParticipant(xmlMatchParticipants, true).getName())) {
					((XmlMatchWinnerAttribute) xmlAttribute).setResult(Result.ONE);
					XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, true);
					((XmlMatchWinnerAttribute) xmlAttribute).setWinnerName(xmlMatchParticipant);
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				} else if (betNameThatIsParticipant.equals(getParticipant(xmlMatchParticipants, false).getName())) {
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
			throw new TrioNordicbetAttributeException(e.getMessage());
		}

		return xmlMarket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketMaximoGoleador(java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketMaximoGoleador(final Object market, final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws TrioNordicbetAttributeException {
		// TODO

		return null;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param outcomeSet
	 *            the outcome set
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(final OutcomeSet outcomeSet) {
		XmlBetType xmlBetType = new XmlBetType();

		// Si el tipo de apuesta es Result puede ser de tipo 1X2
		// o Ganador_partido, dependiendo si tiene 2 o 3
		// elementos
		if (outcomeSet.getType().equalsIgnoreCase(RESULT) && outcomeSet.getOutcome().size() == 3) {
			xmlBetType.setBetType(BetTypeNordicbet.UNO_X_DOS);

		} else if ((outcomeSet.getType().equalsIgnoreCase(RESULT) || outcomeSet.getType().equalsIgnoreCase(RESULT_WINNER))
				&& outcomeSet.getOutcome().size() == 2) {
			xmlBetType.setBetType(BetTypeNordicbet.GANADOR_PARTIDO);
		} else if (outcomeSet.getType().equalsIgnoreCase(HANDICAP) && outcomeSet.getOutcome().size() == 2) {
			xmlBetType.setBetType(BetTypeNordicbet.HANDICAP_ASIATICO);
		} else if (outcomeSet.getType().equalsIgnoreCase(HANDICAP) && outcomeSet.getOutcome().size() == 3) {
			xmlBetType.setBetType(BetTypeNordicbet.UNO_X_DOS_HANDICAP					);			
		} else  if (outcomeSet.getType().toLowerCase().contains(UNDER_OVER.toLowerCase()) && outcomeSet.getOutcome().size() == 2) {
			xmlBetType.setBetType(BetTypeNordicbet.MAS_MENOS);
		} else  if (outcomeSet.getType().toLowerCase().contains(MONEYLYNE.toLowerCase()) && outcomeSet.getOutcome().size() == 2) {
			xmlBetType.setBetType(BetTypeNordicbet.GANADOR_PARTIDO);
	    } else {
			IBetType betType = BetTypeNordicbet.getTypeByValue(outcomeSet.getType());
			xmlBetType.setBetType(betType);
		}

		return xmlBetType;
	}
	
	/**
	 * Resolve bet type in OutcomeSet name attribute. Examples:
	 * Minnesota Wild - Philadelphia Flyers (Total goals - 1st period ) (under/over: 1.5)
	 * Minnesota Wild - Philadelphia Flyers (1st period winner)
	 * New York Rangers - Winnipeg Jets (Total goals - 3rd period) (under/over: 2.5)
	 * 
	 * @param outcomeSet
	 * @return
	 */
	private IBetType resolveBetTypeWithName(OutcomeSet outcomeSet) {
		IBetType betType = null;
		String name = outcomeSet.getName();
		
		String betTypeStringWithBrackets = name;
		// El tipo aparece en en los últimos parentesis.
		if(name!=null && name.contains("(")) {
			// Recoger los dos ultimos parentesis			
			boolean bMore = true;
			while(bMore) {
				String regExpr = "[\\(].[\\d\\D)]*[\\)].";
				Pattern pattern = Pattern.compile(regExpr);
				Matcher matcher = pattern.matcher(betTypeStringWithBrackets);
			
				// Queremos los ultimos, que los recorra todos, y al final
				int start = -1;
				int end = -1;
				while(matcher.find()) {
		            start = matcher.start();
		            end = matcher.end();
				}
				if(start!=-1 && end!=-1){
					String inBrackets = name.substring(start, end).trim();
					if(inBrackets.contains("(")== false) {
						bMore = false;
						betTypeStringWithBrackets = inBrackets;
					} else {
						betTypeStringWithBrackets = betTypeStringWithBrackets.substring(end);
					}					
				} else {
					break;
				}
			}
		}
		// Viene con paréntesis, hay que quitárselos.
		betTypeStringWithBrackets = betTypeStringWithBrackets.replace('(', ' ');
		betTypeStringWithBrackets = betTypeStringWithBrackets.replace(')', ' ');
		betTypeStringWithBrackets = betTypeStringWithBrackets.trim();
		
		outcomeSet.setType(betTypeStringWithBrackets);
		
		
		return betType;
	}

	/**
	 * Gets the correct date.
	 * 
	 * @param game
	 *            the game
	 * @return the correct date
	 */
	private String getCorrectDate(final Game game) {
		String dateCorrectFormat = "";
		if (game.getGameStartTime().contains("CET")) {
			dateCorrectFormat = game.getGameStartTime().replace(" CET", "");
		} else {
			dateCorrectFormat = game.getGameStartTime().replace(" EET", "");
		}
		return dateCorrectFormat;
	}

	/**
	 * Método que asigna el torneo.
	 * 
	 * @param game
	 *            the game
	 * @return the xml tournament
	 */
	private XmlTournament setTournament(final Game game) {
		XmlTournament xmlTournament = new XmlTournament();
		xmlTournament.setXmlSport(new XmlSport(game.getSport()));
		xmlTournament.setRegion(new XmlRegion(game.getRegion()));
		String region = "";
		String tournamentName = "";
		if (StringUtils.isNotEmpty(game.getRegion())) {
			String[] breadCrumb = game.getBreadCrumbs().split(" - ");
			region = game.getRegion();
			if (game.getRegion().equalsIgnoreCase(INTERNATIONAL)) {
				if (breadCrumb.length > 2) {
					tournamentName = breadCrumb[1].trim() + " " + breadCrumb[2].trim();
				} else {
					region = game.getRegion();
					tournamentName = breadCrumb[1].trim();
				}
			} else {
				tournamentName = new StringBuffer().append(region).append(" ").append(game.getSeason()).toString();
			}

			// Caso especial para Tenis
			if (game.getSport().equals("Tennis")) {
				if (StringUtils.isNotEmpty(game.getSeason())) {
					if (game.getSeason().equalsIgnoreCase(SINGLES) || game.getSeason().equals(DOUBLES)) {
						xmlTournament.setName(new StringBuffer().append(region).append(" ").append(tournamentName).toString());
					} else {
						xmlTournament.setName(new StringBuffer().append(region).append(" ").append(game.getSeason()).toString());
					}
				}
			} else {
				xmlTournament.setName(tournamentName);
			}

		}
		LOG.debug(Thread.currentThread(), new StringBuffer("Se asigna la competicion ").append(xmlTournament.getName()).toString());
		return xmlTournament;
	}

	/**
	 * Process cases associated with Overtime 
	 * 
	 * @param outcomesetBetType
	 * @param game
	 * @param xmlBetType
	 */
	private void markAsOvertime(String outcomesetBetType, Game game, XmlBetType xmlBetType) {
		IBetEvent pEvent = BetEventNordicbet.PARTIDO_COMPLETO;
		XmlBetEvent xmlBetEvent = new XmlBetEvent(pEvent);
		
		if(game.getSport().contains(SportsNordicbet.ICECHOKEY.getId()) && xmlBetType.getBetType()!=null) {
			// 1) Mas Menos y NHL, PRORROGA{
			if(xmlBetType.getBetType().equals(BetTypeNordicbet.MAS_MENOS)){
				if(game.getBreadCrumbs().contains(NHL_ICEHOCKEY)) {
					pEvent = BetEventNordicbet.PARTIDO_COMPLETO_PRORROGA;
				}
			}
			// 2) MoneyLyne Prorroga.
			if(outcomesetBetType.equalsIgnoreCase(MONEYLYNE)){
				pEvent = BetEventNordicbet.PARTIDO_COMPLETO_PRORROGA;
			}
			
			xmlBetEvent.setBetEvent(pEvent);
			
		} else if(markAsOvertimeOtherSports(game.getSport(), xmlBetType.getBetType())) {
			xmlBetEvent.setBetEvent(BetEventNordicbet.PARTIDO_COMPLETO_PRORROGA);
		}
		
		xmlBetType.setXmlBetEvent(xmlBetEvent);
	}
	
	/**
	 * Special sports overtime control
	 * 
	 * @param sport
	 * @param betType
	 * @return
	 */
	private boolean markAsOvertimeOtherSports(String sport, IBetType betType) {
		// Si es el deporte
		if(sport.contains(SportsNordicbet.AMERICAN_FOOTBALL.getId()) ||
			sport.contains(SportsNordicbet.BASEBALL.getId()) ||
		   sport.contains(SportsNordicbet.BASKETBALL.getId())) {
			// Si es el TypeEvnet
			if(betType==BetTypeNordicbet.GANADOR_PARTIDO ||
				betType==BetTypeNordicbet.HANDICAP_ASIATICO ||
				betType==BetTypeNordicbet.MAS_MENOS) {
				return true;
			}
		}
		
		return false;
	}
	
}
