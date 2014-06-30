/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Market;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Oxip;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Participant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Response;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Type;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Williamhill;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLWilliamHillFileReader.
 */
@Component
public class XMLWilliamHillFileReader extends AbstractXmlFilereader implements MarketType {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant pSeparators. */
	private static final String[] pSeparators = { " v ", " @ " };

	/** The Constant AWAY. */
	private static final String AWAY = "AWAY";

	/** The Constant HOME. */
	private static final String HOME = "HOME";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

	/** The Constant LIVE. */
	private static final String LIVE = "Live";

	/** The Constant MATCH_BETTING. */
	private static final String MATCH_BETTING = "Match Betting";

	/** The Constant OVER. */
	private static final String OVER = "Over";

	/** The Constant UNDER. */
	private static final String UNDER = "Under";

	/** The handicap home value first. */
	private String handicapHomeValueFirst = "";

	/** The handicap home value second. */
	private String handicapHomeValueSecond = "";

	/** The ADITIONA l_ participant s_ info. */
	private static String ADITIONAL_PARTICIPANTS_INFO = " - ";

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
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Mapper mapper = getMapper();
		Oxip oxip = null;
		try {
			oxip = (Oxip) JaxbUtils.readXML(pFile, Oxip.class);
			xmlBookmakerEvents.setFileDate(getStartDate(oxip.getCreated(), DATE_FORMAT, bookmakerConfiguration.getTimeZone()));
			Response response = oxip.getResponse();
			Williamhill williamhill = response.getWilliamhill();
			com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill.Class clazz = williamhill.getClazz();
			// Los deportes de tipo virtual parece que son deportes ficticios y
			// no los tratamos
			if (!clazz.getName().contains("Virtual")) {
				XmlSport xmlSport = new XmlSport(clazz.getName());

				for (Type type : clazz.getType()) {//competiciones
					XmlTournament xmlTournament = new XmlTournament(type.getName());
					xmlTournament.setXmlSport(xmlSport);
					for (Market market : type.getMarket()) {//mercados
						try{
							XmlMatch xmlMatch = null;
							String[] splitName = market.getName().split(" - ");
							SportsWilliamHill sport = SportsWilliamHill.getSportByValue(String.valueOf(clazz.getId()));
							MarketInfoWilliamHill eventType = resolveBetType(splitName,sport,new AdicionalInfo(type.getName()));
							if(!(eventType.getBetType().equals(BetTypeWilliamHill.MAXIMO_GOLEADOR)) && !((eventType.getBetType().equals(BetTypeWilliamHill.GANADOR)))){
								xmlMatch = existXmlMatch(xmlBookmakerEvents.getXmlMatchs(), market.getName());
							}

							if (xmlMatch == null) {
								xmlMatch = mapper.map(market, XmlMatch.class, "marketToXmlMatchWilliam");
								if(!(eventType.getBetType().equals(BetTypeWilliamHill.MAXIMO_GOLEADOR)) && !((eventType.getBetType().equals(BetTypeWilliamHill.GANADOR)))){
									xmlMatch.setName(market.getName().split(" - ")[0]);
								}else{
									xmlMatch.setName(market.getName());
								}
								
								String[] participants = null;
								for (int j = 0; j < pSeparators.length && (participants == null || participants.length == 1); j++) {
									participants = xmlMatch.getName().split(pSeparators[j]);
									if (participants.length > 1) {
										String[] basura = participants[1].split(ADITIONAL_PARTICIPANTS_INFO);
										participants[1] = basura[0];
									}
								}
								if (participants != null && participants.length > 1) {
									xmlMatch.addXmlMatchParticipantHome(new XmlMatchParticipant(participants[0], xmlTournament));
									xmlMatch.addXmlMatchParticipantAway(new XmlMatchParticipant(participants[1], xmlTournament));
								} else {
									for (Participant participante : market.getParticipant()) {
										xmlMatch.addXmlMatchParticipant(new XmlMatchParticipant(participante.getName(), xmlTournament));
									}
								}
								xmlMatch.setStartDate(getStartDate(market.getDate().toString() + " " + market.getTime().toString(),
										DATE_FORMAT, bookmakerConfiguration.getTimeZone()));
								xmlMatch.setLive(market.getName().contains(LIVE));
								xmlMatch.setXmlTournament(xmlTournament);
								xmlBookmakerEvents.addXmlMatch(xmlMatch);
							}
							XmlUrl xmlUrl = new XmlUrl();
							xmlUrl.setUrl(market.getUrl());




							if (eventType != null ) {
								XmlMarket xmlMarket = null;
								XmlBetType xmlBetType = new XmlBetType();
								xmlBetType.setBetType(eventType.getBetType());
								XmlBetEvent xmlBetEvent = new XmlBetEvent();
								xmlBetEvent.setBetEvent(eventType.getBetTypeEvent());
								xmlBetType.setXmlBetEvent(xmlBetEvent);
								LOG.info(Thread.currentThread(),new StringBuffer().append("Se inicia el procesado del mercado: ").append(eventType.getBetType().getId()).append(" - ")
										.append(eventType.getBetTypeEvent().getId()).append(" para el deporte ").append(sport.name()).toString());
								try {
									if (xmlBetType.getBetType().equals(BetTypeWilliamHill.GANADOR_PARTIDO)) {
										xmlMarket = getMarketGanadorPartido(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeWilliamHill.GANADOR)) {
										xmlMarket = getMarketGanador(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeWilliamHill.HANDICAP_ASIATICO)) {
										xmlMarket = getMarketHandicapAsiatico(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeWilliamHill.MAS_MENOS)) {
										xmlMarket = getMarketMasMenos(market);
									} else if (xmlBetType.getBetType().equals(BetTypeWilliamHill.UNO_X_DOS)) {
										xmlMarket = getMarketUnoXDos(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeWilliamHill.UNO_X_DOS_HANDICAP)) {
										xmlMarket = getMarketUnoXDosHandicap(market, xmlMatch.getXmlMatchParticipants());
									}else if (xmlBetType.getBetType().equals(BetTypeWilliamHill.MAXIMO_GOLEADOR)) {
										xmlMarket = getMarketMaximoGoleador(market, xmlMatch.getXmlMatchParticipants());
									}
									xmlMarket.setXmlBetType(xmlBetType);
								} catch (WilliamHillAttributeException e) {
									LOG.error(Thread.currentThread(),new StringBuffer().append("Error al rellenar los atributos del evento, se ignora el evento. ".toString())
											.append(e.getMessage()).toString());
								}
								if (xmlMarket.getXmlBetType() != null && xmlMarket.getXmlBetType().getBetType() != null) {
									XmlTournamentEvent tournamentEvent = new XmlTournamentEvent();
									LongTerm lt = new LongTerm();
									lt.setLongTerm(eventType.isLongTerm());
									tournamentEvent.setLongTerm(lt);
									xmlMatch.setXmlTournamentEvent(tournamentEvent);
									xmlMatch.addXmlMarket(xmlMarket);
								}
							}
						}catch (NumberFormatException e) {
							LOG.error(Thread.currentThread(),"El XML tiene campos vacíos, ignoramos este mercado", e);

						} catch (NullPointerException e) {
							LOG.error(Thread.currentThread(),"Se ha producido un error en el mercado, ignoramos este mercado", e);
						}
						catch (BetTypeNotFoundException e) {
							LOG.error(Thread.currentThread(),e.getMessage());
						}
					}
				}

			}
		} catch (JAXBException e) {
			LOG.error(Thread.currentThread(),"No se puede provesar el XML, no se reconoce el elemento descargado");
			throw new XmlReaderException(e.getCause());
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(),"No se puede provesar el XML, Error al parsear el xml.");
			throw new XmlReaderException(e.getCause());
		} catch (NullPointerException e) {
			LOG.error(Thread.currentThread(),"No se puede provesar el XML, El XML no tiene información.",e);
			throw new XmlReaderException(e.getCause());
		} catch (NumberFormatException e) {
			LOG.error(Thread.currentThread(),"No se puede provesar el XML, El XML tiene campos vacíos");
			throw new XmlReaderException(e.getCause());
		}
		return xmlBookmakerEvents;
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
			throws WilliamHillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			String handicap = bet.getHandicap();
			if (bet.getName().contains("Draw") || bet.getName().contains("Tie")) {
				((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.DRAW);
				handicap = processHandicap(Result.DRAW, bet.getName(), handicap);
//				handicapHomeValueFirst = handicap;
			} else if (isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
				handicap = processHandicap(Result.ONE, bet.getName(), handicap);
//				handicapHomeValueFirst = handicap;
			} else if (!isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
				handicap = processHandicap(Result.TWO, bet.getName(), handicap);
			}
			((Xml1X2HandicapAttribute) xmlAttribute).setFirstValue(Double.parseDouble(handicap));
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
//		for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
//			((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapHomeValueFirst));
//			if (handicapHomeValueSecond != null && !handicapHomeValueSecond.equals("")) {
//				((Xml1X2HandicapAttribute) bet.getXmlAttribute()).setSecondValue(Double.parseDouble(handicapHomeValueSecond));
//			}
//		}
		return xmlMarket;
	}

	/**
	 * Obtains from the name value the handicap value (contained in name)
	 * 
	 * @param pResult
	 *            - The Result Type (Draw or Tie, One, Two)
	 * @param name
	 *            - The Bet name from with obtain the handicap value
	 * @param handicap
	 *            - the handicap value obtained by another methods. If it is
	 *            filled, this function not realizes operations.
	 * @return - The String representation as Integer of Handicap
	 * @throws WilliamHillAttributeException
	 */
	public String processHandicap(Result pResult, String name, String handicap) throws WilliamHillAttributeException {
		if (handicap == null || handicap.isEmpty() == true) {
			Pattern p = Pattern.compile("\\s*[+|-][\\d]+");
			Matcher matcher = p.matcher(name);
			if (matcher.find()) {
				handicap = name.substring(matcher.start(), matcher.end());
			}
			handicap = getStringWithSignInteger(handicap.trim());
			if (pResult == Result.TWO) {
				handicap = Integer.toString(Integer.parseInt(handicap) * -1);
			}
		}
		return handicap;
	}

	/**
	 * Integer parsing of String integer representation fails if the number
	 * begins with "-" sign. This function process the String integer
	 * representation considering the before case (it the representation begins
	 * with "+", that is eliminated, if begins with "-" process without
	 * exception)
	 * 
	 * @param stringInteger
	 *            - A String representation of an integer beginning with the
	 *            sign.
	 * @return The String representation parsed (validated)
	 * @throws WilliamHillAttributeException
	 */
	private String getStringWithSignInteger(String stringInteger) throws WilliamHillAttributeException {
		DecimalFormat df = new DecimalFormat("+#;-#");
		try {
			return df.parse(stringInteger).toString();
		} catch (ParseException e) {
			throw new WilliamHillAttributeException(e.getMessage());
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
			throws WilliamHillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			if (bet.getName().equalsIgnoreCase("Draw") || bet.getName().equalsIgnoreCase("Tie")) {
				((Xml1X2Attribute) xmlAttribute).setResult(Result.DRAW);
			} else if (isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((Xml1X2Attribute) xmlAttribute).setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
			} else if (!isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((Xml1X2Attribute) xmlAttribute).setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
			}
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketMasMenos(java.lang.Object)
	 */
	public XmlMarket getMarketMasMenos(final Object market) throws WilliamHillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = null;
			xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
			String value = bet.getName().split(" ")[0];
			if (value.equalsIgnoreCase(OVER)) {
				((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MAS);
				if (StringUtils.isNotEmpty(bet.getHandicap())) {
					((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(bet.getHandicap()));
				} else {
					if (bet.getName().split(" ").length > 1) {
						((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(bet.getName().split(" ")[1]));
					}
				}
			} else if (value.equalsIgnoreCase(UNDER)) {
				((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MENOS);
				if (StringUtils.isNotEmpty(bet.getHandicap())) {
					((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(bet.getHandicap()));
				} else {
					if (bet.getName().split(" ").length > 1) {
						((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(Double.valueOf(bet.getName().split(" ")[1]));
					}
				}
			}
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
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
			throws WilliamHillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = null;
			xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();
			String[] values = bet.getHandicap().split(" & ");
			String handicap2 = "";
			if (values.length > 1) {
				handicap2 = values[1];
			}
			if (isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.ONE);
				handicapHomeValueFirst = values[0];
				if (StringUtils.isNotEmpty(handicap2)) {
					handicapHomeValueSecond = handicap2;
				}
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
			} else if (!isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((XmlAsianHandicapAttribute) xmlAttribute).setAsianResult(AsianResult.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
			}
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
			((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setFirstValue(Double.parseDouble(handicapHomeValueFirst));
			if (handicapHomeValueSecond != null && !handicapHomeValueSecond.equals("")) {
				((XmlAsianHandicapAttribute) bet.getXmlAttribute()).setSecondValue(Double.parseDouble(handicapHomeValueSecond));
			}
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
			throws WilliamHillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlWinnerAttribute xmlAttribute = new XmlWinnerAttribute();
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
			((XmlWinnerAttribute) xmlMarketBet.getXmlAttribute()).setWinner(xmlMatchParticipant);
			xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		return xmlMarket;
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
			throws WilliamHillAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();
			XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			if (isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((XmlMatchWinnerAttribute) xmlAttribute).setResult(Result.ONE);
			} else if (!isHomeParticipant(xmlMatchParticipants, bet.getName())) {
				((XmlMatchWinnerAttribute) xmlAttribute).setResult(Result.TWO);
			}

			((XmlMatchWinnerAttribute) xmlMarketBet.getXmlAttribute()).setWinnerName(xmlMatchParticipant);
			xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);

			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
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
	{
		XmlMarket xmlMarket = new XmlMarket();
		for (Participant bet : ((Market) market).getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getOddsDecimal()));
			XmlMaximumGoalerAttribute att = new XmlMaximumGoalerAttribute();
			XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getName());
			att.setGoaler(xmlMatchParticipant);
			xmlMarketBet.setXmlAttribute(att);

			xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
			xmlMarket.addXmlBet(xmlMarketBet);
		}



		return xmlMarket;
	}

	/**
	 * Checks if is home participant.
	 * 
	 * @param pXmlMatchParticipants
	 *            the xml match participants
	 * @param pName
	 *            the name
	 * @return true, if is home participant
	 */
	private boolean isHomeParticipant(Collection<XmlMatchParticipant> pXmlMatchParticipants, String pName) {
		if (pName.equals(AWAY)) {
			return false;
		} else if (pName.equals(HOME)) {
			return true;
		} else {
			for (XmlMatchParticipant xmlMatchParticipant : pXmlMatchParticipants) {
				if (pName.trim().contains(xmlMatchParticipant.getName().trim())) {
					return xmlMatchParticipant.isHomeParticipant();
				}
			}
		}
		return false;
	}

	/**
	 * Exist xml match.
	 * 
	 * @param pXmlMatchs
	 *            the xml matchs
	 * @param pName
	 *            the name
	 * @return the xml match
	 */
	private XmlMatch existXmlMatch(Collection<XmlMatch> pXmlMatchs, String pName) {
		if (pXmlMatchs != null) {
			for (XmlMatch xmlMatch : pXmlMatchs) {
				if (xmlMatch.getName().equals(pName.split(" - ")[0])) {
					return xmlMatch;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.WILLIAMHILL_COM_ID.objectId().toString();
	}


	private MarketInfoWilliamHill resolveBetType(String[] pSplitName,
			SportsWilliamHill pSportByValue,AdicionalInfo info) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result = null; 

		result = processSplitNames(pSplitName,pSportByValue,info);

		return result;
	}


	private MarketInfoWilliamHill processSplitNames(String[] names,SportsWilliamHill pSportByValue,AdicionalInfo info) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result;
		SportResolverCreator creator = new SportResolverCreator();

		ISportResolver resolver = creator.getResolver(pSportByValue);
		result = resolver.resolve(names,info);

		return result;
	}




}
