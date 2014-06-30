/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.intertops;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.Cat;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.Data;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.L;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.M;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.Result;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.S;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops.T;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlFillAttributeException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLIntertopsFileReader.
 */
@Component
public class XMLIntertopsFileReader extends AbstractXmlFilereader implements
		MarketType {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm";

	/** The Constant NHL_LITERAL. */
	private static final String NHL_LITERAL = "NHL";

	/** The Constant INTERTOPS_PARTICIPANT_SEPARATOR. */
	private static final String INTERTOPS_PARTICIPANT_SEPARATOR = " v ";

	/**
	 * The Constant DRAW_ID.
	 */
	private static final String DRAW_LITERAL = "Draw";
	
	/** The Constant OVER_LITERAL. */
	private static final String OVER_LITERAL = "OVER";
	
	/** The Constant UNDER_LITERAL. */
	private static final String UNDER_LITERAL = "UNDER";
	
	/** Para apuestas especiales (Ganador de competicion, Ascenso de categoria, etc) en tipo de apuesta indica FreeForm y concreta el tipo de apuesta en el nombre del partido. */
	private static final String FREEFORM_LITERAL = "FreeForm";

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** {@inheritDoc} */
	@Override
	protected XmlBookmakerEvents readXml(InputStream file,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Result result = null;
		Data data = null;
		
		CloseShieldInputStream closeShieldInputStream = new CloseShieldInputStream(file);
		try {
			result = (Result) JaxbUtils.readXML(closeShieldInputStream, Result.class);
			
			data = getDataFromContent(result.getContent());
			
			for (S sport : data.getS()) {
				XmlSport xmlSport = new XmlSport();
				xmlSport.setName(SportIntertopsResolver.resolveSport(sport.getId()));
				LOG.debug(Thread.currentThread(),
						new StringBuffer().append("Se procesa el deporte: ").append(xmlSport.getName()).toString());

				LOG.debug(Thread.currentThread(),
						new StringBuffer().append("Obtenemos la lista de competiciones para el deporte ").append(xmlSport.getName()).toString());
				for (Cat competition : sport.getCat()) {
					XmlTournament xmlTournament = new XmlTournament();
					xmlTournament.setName(competition.getN());
					xmlTournament.setXmlSport(xmlSport);
					LOG.debug(Thread.currentThread(),
							new StringBuffer().append("Iteramos sobre los eventos de la competicion: ").append(competition.getN()).toString());

					for (M match : competition.getM()) {
						XmlMatch xmlMatch = new XmlMatch();
						xmlMatch.setName(match.getN());
						xmlMatch.setXmlTournament(xmlTournament);
						xmlMatch.setStartDate((getStartDate(match.getDt(), DATE_FORMAT,	cfgBookmakerConfiguration.getTimeZone())));

						LOG.debug(Thread.currentThread(),
								new StringBuffer().append("Iteramos sobre los mercados del partido: ").append(match.getN().toString()).toString());
						for (T market : match.getT()) {
							// Resolvemos el tipo de apuesta
							XmlBetType xmlBetType = resolveXmlBetType(market, match);
							if (xmlBetType.getBetType() != null) {
								// Resolvemos el tipo de evento de apuesta en
								// funcion del betType y del deporte
								XmlBetEvent xmlBetEvent = resolveXmlBetEvent(market, xmlBetType, competition.getN(), sport.getId());
								xmlBetType.setXmlBetEvent(xmlBetEvent);

								// Procesamos los participantes de largo y corto
								// plazo
								if (xmlBetType.getBetType().equals(BetTypeInterTops.GANADOR)
										|| xmlBetType.getBetType().equals(BetTypeInterTops.MAXIMO_GOLEADOR)) {
									xmlMatch.setXmlMatchParticipants(getLongTermParticipants(xmlTournament, market.getL()));
								} else {
									xmlMatch.setXmlMatchParticipants(getShortTermParticipants(match.getN(), xmlTournament, market.getL()));
								}

								XmlMarket xmlMarket = new XmlMarket();
								try {
									if (xmlBetType.getBetType().equals(BetTypeInterTops.GANADOR_PARTIDO)) {
										xmlMarket = getMarketGanadorPartido(market,	xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeInterTops.GANADOR)) {
										xmlMarket = getMarketGanador(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeInterTops.HANDICAP_ASIATICO)) {
										xmlMarket = getMarketHandicapAsiatico(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeInterTops.MAS_MENOS)) {
										xmlMarket = getMarketMasMenos(market);
									} else if (xmlBetType.getBetType().equals(BetTypeInterTops.UNO_X_DOS)) {
										xmlMarket = getMarketUnoXDos(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeInterTops.UNO_X_DOS_HANDICAP)) {
										xmlMarket = getMarketUnoXDosHandicap(market, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeInterTops.MAXIMO_GOLEADOR)) {
										xmlMarket = getMarketMaximoGoleador(market, xmlMatch.getXmlMatchParticipants());
									}

								} catch (XmlFillAttributeException e) {
									LOG.error(Thread.currentThread(),
											new StringBuffer().append("Error al rellenar los atributos del evento, se ignora el evento. ").append(e.getMessage()).toString());
								}

								if (xmlMarket != null) {
									// Actualizamos en el market el tipo de
									// apuesta
									xmlMarket.setXmlBetType(xmlBetType);
									if (xmlMarket.getXmlMarketBets().size() > 0) {
										xmlMatch.addXmlMarket(xmlMarket);
									}
								}
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
			LOG.error(Thread.currentThread(),
					new StringBuffer("XML mal construido o no reconocido.").append(convertInputStreamToString(closeShieldInputStream)).toString(), e);
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: " + JaxbUtils.writeXML(data, Data.class);
			LOG.error(Thread.currentThread(), errorMessage, e);
		}

		return xmlBookmakerEvents;
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketGanador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Se procesa el Mercado Ganador").toString());

		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (L bet : ((T) market).getL()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlWinnerAttribute attribute = new XmlWinnerAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getO()));
				XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getValue());
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				attribute.setWinner(xmlMatchParticipant);

				xmlMarketBet.setXmlAttribute(attribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketGanadorPartido(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Se procesa el Mercado Ganador Partido").toString());
		
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (L bet : ((T) market).getL()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getO()));
				XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();

				if (isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, true);
					xmlAttribute.setWinnerName(xmlMatchParticipant);
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.ONE);
					xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				} else if (!isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					XmlMatchParticipant xmlMatchParticipant = getParticipant(xmlMatchParticipants, false);
					xmlAttribute.setWinnerName(xmlMatchParticipant);
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.TWO);
					xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}

		return xmlMarket;
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketHandicapAsiatico(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(), new StringBuffer().append("Se procesa el Mercado AsianHandicap").toString());
		XmlMarket xmlMarket = new XmlMarket();
		String firstValue = "";
		try {
			for (L bet : ((T) market).getL()) {

				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
						bet.getO());

				XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();

				if (isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
					xmlAttribute.setAsianResult(AsianResult.ONE);
					firstValue = bet.getP();		
				} else if (!isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
					xmlAttribute.setAsianResult(AsianResult.TWO);
				}
				
				xmlAttribute.setFirstValue(Double.valueOf(firstValue));
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);

			}
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}
		return xmlMarket;
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketMasMenos(Object market) throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Se procesa el Mercado Mas/Menos").toString());
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (L bet : ((T) market).getL()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(bet.getO());
				XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();

				if (bet.getValue().contains(OVER_LITERAL)) {
					xmlAttribute.setMasMenos(MasMenos.MAS);

				} else if (bet.getValue().contains(UNDER_LITERAL)) {
					xmlAttribute.setMasMenos(MasMenos.MENOS);
				}

				xmlAttribute.setTotalGoal(Double.valueOf(bet.getP()));
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);

			}
			return xmlMarket;
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketUnoXDos(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Se procesa el Mercado 1X2").toString());
		
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (L bet : ((T) market).getL()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(String.valueOf(bet.getO()));
						
				if (bet.getValue().equalsIgnoreCase(DRAW_LITERAL)){
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.DRAW);
				}else if (isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.ONE);	
				} else if (!isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.TWO);
				}
				
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Se procesa el Mercado 1X2 Handicap").toString());
		
		XmlMarket xmlMarket = new XmlMarket();
		String firstValue = "";
		try {
			for (L bet : ((T) market).getL()) {

				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(bet.getO());

				Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();

				if (bet.getValue().equalsIgnoreCase(DRAW_LITERAL)){
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.DRAW);
					if (firstValue.equals("")){
						firstValue = bet.getP();	
					}
				}else if (isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.ONE);	
					if (firstValue.equals("")){
						firstValue = bet.getP();	
					}
				} else if (!isHomeParticipant(xmlMatchParticipants, bet.getValue())) {
					xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
					xmlAttribute.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.TWO);
				}

				xmlAttribute.setFirstValue(Double.valueOf(firstValue));
				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);

			}
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}
		return xmlMarket;
	}

	/** {@inheritDoc} */
	@Override
	public XmlMarket getMarketMaximoGoleador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Se procesa el Mercado Maximo goleador").toString());
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (L bet : ((T) market).getL()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(
						String.valueOf(bet.getO()));
				XmlMaximumGoalerAttribute xmlAttribute = new XmlMaximumGoalerAttribute();

				XmlMatchParticipant xmlMatchParticipant = getParticipantByName(xmlMatchParticipants, bet.getValue());
				xmlAttribute.setGoaler((xmlMatchParticipant));
				xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		} catch (Exception e) {
			throw new XmlFillAttributeException(e.getMessage());
		}

		return xmlMarket;
	}

	/** {@inheritDoc} */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.INTERTOPS_EU_ID.objectId().toString();
	}

	/**
	 * Resolve xml bet type.
	 * 
	 * @param market
	 *            the market
	 * @param match
	 *            the match
	 * @return the xml bet type
	 */
	private XmlBetType resolveXmlBetType(T market, M match) {
		XmlBetType xmlBetType = new XmlBetType();
		IBetType betType = null;
		
		// Comprobamos si se trata de una apuesta especial o de largo plazo
		if (market.getN().equalsIgnoreCase(FREEFORM_LITERAL)){
			betType = BetTypeInterTops.getTypeByValue(match.getN());	
		}else {
			betType = BetTypeInterTops.getTypeByValue(market.getN());
			if (betType!= null && betType.equals(BetTypeInterTops.UNO_X_DOS)) {
				if (market.getL().size() == 2) {
					betType = BetTypeInterTops.GANADOR_PARTIDO;
				}
			}
		}
		
	
		if (betType != null) {
			xmlBetType.setBetType(betType);
			LOG.debug(Thread.currentThread(),
					new StringBuffer().append("El tipo de apuesta es: ").append(xmlBetType.getBetType().getId()).toString());
		}
		return xmlBetType;
	}

	/**
	 * Resolve xml bet event.
	 *
	 * @param market the market
	 * @param xmlBetType the xml bet type
	 * @param competition the competition
	 * @param idSport the id sport
	 * @return the xml bet event
	 */
	private XmlBetEvent resolveXmlBetEvent(T market, XmlBetType xmlBetType,
			String competition, String idSport) {
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		IBetEvent betEvent = BetEventInterTops.getEventByValue(market.getN());
		xmlBetEvent.setBetEvent(betEvent);

		if (betEvent.equals(BetEventInterTops.PARTIDO_COMPLETO)) {
			if (xmlBetType.getBetType().equals(BetTypeInterTops.GANADOR_PARTIDO)
					|| xmlBetType.getBetType().equals(BetTypeInterTops.HANDICAP_ASIATICO)
					|| xmlBetType.getBetType().equals(BetTypeInterTops.MAS_MENOS)) {
				if (SportIntertopsResolver.isIceHockey(idSport)) {
					if (competition.contains(NHL_LITERAL)) {
						xmlBetEvent.setBetEvent(BetEventInterTops.PARTIDO_COMPLETO_PRORROGA);
					}
				} else if (SportIntertopsResolver.isBasketball(idSport)
						|| SportIntertopsResolver.isAmericanFootball(idSport)) {
					xmlBetEvent.setBetEvent(BetEventInterTops.PARTIDO_COMPLETO_PRORROGA);
				}
			}
		}
		return xmlBetEvent;
	}

	/**
	 * Gets the long term participants.
	 * 
	 * @param xmlTournament
	 *            the xml tournament
	 * @param lines
	 *            the lines
	 * @return the long term participants
	 */
	private Collection<XmlMatchParticipant> getLongTermParticipants(
			XmlTournament xmlTournament, List<L> lines) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		for (L line : lines) {
			XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
					line.getValue(), xmlTournament);
			LOG.debug(Thread.currentThread(),
					new StringBuffer().append("Participante: ").append(xmlMatchParticipant.getName()).toString());
			participants.add(xmlMatchParticipant);
		}
		return participants;
	}

	/**
	 * Gets the short term participants.
	 * 
	 * @param matchName
	 *            the match name
	 * @param xmlTournament
	 *            the xml tournament
	 * @param lines
	 *            the lines
	 * @return the short term participants
	 */
	private Collection<XmlMatchParticipant> getShortTermParticipants(
			String matchName, XmlTournament xmlTournament, List<L> lines) {
		Collection<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		String[] participantString = matchName.split(
				INTERTOPS_PARTICIPANT_SEPARATOR);
		XmlMatchParticipant homeParticipant = new XmlMatchParticipant(
				participantString[0], xmlTournament);
		LOG.debug(
				Thread.currentThread(),
				new StringBuffer().append("Participante local: ").append(homeParticipant.getName()).toString());
		homeParticipant.setHomeParticipant(true);
		participants.add(homeParticipant);
		if (participantString.length > 1) {
			XmlMatchParticipant awayParticipant = new XmlMatchParticipant(
					participantString[1], xmlTournament);
			LOG.debug(Thread.currentThread(),
					new StringBuffer().append("Participante visitante: ").append(awayParticipant.getName()).toString());
			awayParticipant.setAwayParticipant(true);
			participants.add(awayParticipant);
		}
		return participants;
	}
	
	/**
	 * Checks if is home participant.
	 *
	 * @param xmlMatchParticipants the xml match participants
	 * @param participantName the participant name
	 * @return the boolean
	 */
	private Boolean isHomeParticipant (Collection<XmlMatchParticipant> xmlMatchParticipants, String participantName) {
		for (XmlMatchParticipant xmlMatchParticipant : xmlMatchParticipants) {
			if (participantName.trim().contains(xmlMatchParticipant.getName().trim())) {
				return xmlMatchParticipant.isHomeParticipant();
			}
		}
		return false;
	}
	
	
	/**
	 * Gets the data from content.
	 *
	 * @param content the content
	 * @return the data from content
	 */
	private Data getDataFromContent (List<Object> content){
		Data result = null;
		for (Object obj : content) {
			if (obj instanceof Data) {
				result = (Data) obj;
			}
		}
		return result;
	}

}
