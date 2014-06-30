/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.unibet;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BeanUtilUnibet;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventUniBet;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeUniBet;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLUniBetFileReader.
 */
@Component
public class XMLUniBetFileReader extends AbstractXmlFilereader implements MarketType {

	private static final String WINNER = "Winner";
	private static final String OT_CROSS = "OT_CROSS";
	private static final String OT_UNDER = "OT_UNDER";
	private static final String OT_OVER = "OT_OVER";
	private static final String LINE = "line";
	private static final String OT_TWO = "OT_TWO";
	private static final String OT_ONE = "OT_ONE";
	private static final String TYPE = "type";
	private static final String ODDS = "odds";
	private static final String COMILLAS = "\"";
	private static final String Z = "Z";
	private static final String WHITE_SPACE = " ";
	private static final String T = "T";
	private static final String BET_OFFER_TYPE = "betOfferType";
	private static final String OUTCOMES = "outcomes";
	private static final String CLOSED = "closed";
	private static final String LABEL = "label";
	private static final String CRITERION = "criterion";
	private static final String BASEBALL = "BASEBALL";
	private static final String AMERICAN_FOOTBALL = "AMERICAN_FOOTBALL";
	private static final String ID = "id";
	private static final String EVENT_ID = "eventId";
	private static final String BETOFFERS = "betoffers";
	private static final String HOME_NAME = "homeName";
	private static final String AWAY_NAME = "awayName";
	private static final String START = "start";
	private static final String NAME = "name";
	private static final String SPORT = "sport";
	private static final String EMPTY_STRING = "";
	private static final String GROUP_ID = "groupId";
	private static final String GROUPS = "groups";
	private static final String GROUP = "group";
	private static final String EVENTS = "events";
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

	private static volatile String regionGlobal = EMPTY_STRING;

	@Inject
	private BeanUtilUnibet beanUtilUnibet;

	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.UNIBET_COM_ID.objectId().toString();
	}

	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile, CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "se inicia el reader UniBet");
		XmlBookmakerEvents result = new XmlBookmakerEvents();
		JsonNode nodoPadre = beanUtilUnibet.getFicheroPadre();
		try {
			JsonNode nodo = new ObjectMapper().readTree(pFile);
			JsonNode eventos = nodo.get(EVENTS);
			Iterator<JsonNode> iteradorEventos = eventos.getElements();
			List<JsonNode> listaLargoPlazo = new ArrayList<JsonNode>();

			// Recorremos todos los eventos(partidos) que encontramos en el json
			while (iteradorEventos.hasNext()) {
				XmlMatch xmlMatch = new XmlMatch();
				XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant();
				XmlTournament xmlTournament = new XmlTournament();
				XmlSport xmlSport = new XmlSport();
				XmlRegion xmlRegion = new XmlRegion();
				XmlMarket xmlMarket = new XmlMarket();
				XmlBetType xmlBetType = new XmlBetType();
				XmlBetEvent xmlBetEvent = new XmlBetEvent();
				String region = new String();
				JsonNode evento = iteradorEventos.next();

				// Buscamos el pais
				JsonNode grupoPadre = nodoPadre.get(GROUP);
				JsonNode gruposPadre = grupoPadre.get(GROUPS);
				xmlSport.setName(evento.get(SPORT).asText());
				LOG.debug(Thread.currentThread(), "El deporte es " + xmlSport.getName());
				regionGlobal = EMPTY_STRING;
				obtenerRegion(xmlSport.getName(), gruposPadre, evento.get(GROUP_ID).asText(), EMPTY_STRING);
				region = regionGlobal;
				xmlRegion.setName(region);
				LOG.debug(Thread.currentThread(), "La region es " + xmlRegion.getName());

				xmlTournament.setName(region + WHITE_SPACE + evento.get(GROUP).asText());
				xmlTournament.setRegion(xmlRegion);
				xmlTournament.setXmlSport(xmlSport);
				LOG.debug(Thread.currentThread(), "El torneo es " + xmlTournament.getName());
				xmlMatch.setName(evento.get(NAME).asText());
				xmlMatch.setStartDate(getStartDate(crearDate(evento.get(START).asText()), DATE_FORMAT,
						cfgBookmakerConfiguration.getTimeZone()));
				xmlMatch.setXmlTournament(xmlTournament);
				LOG.debug(Thread.currentThread(), "El partido es " + xmlMatch.getName());

				// Si existe la etiqueta awayName se trata de un evento
				// de corto plazo
				if (evento.get(AWAY_NAME) != null) {
					xmlMatchParticipant = new XmlMatchParticipant(evento.get(AWAY_NAME).asText(), false, true, xmlTournament);
					xmlMatch.addXmlMatchParticipant(xmlMatchParticipant);
					if (evento.get(HOME_NAME) != null) {
						xmlMatchParticipant = new XmlMatchParticipant(evento.get(HOME_NAME).asText(), true, false, xmlTournament);
						xmlMatch.addXmlMatchParticipant(xmlMatchParticipant);
					}
					LOG.debug(Thread.currentThread(), "Se procesa evento de corto plazo");
					// Recorremos las apuestas para encontrar las referentes a
					// este
					// partido. En este caso las de corto plazo. Largo plazo se
					// trata de otra forma.
					JsonNode apuestas = nodo.get(BETOFFERS);
					Iterator<JsonNode> iteradorApuestas = apuestas.getElements();
					while (iteradorApuestas.hasNext()) {
						JsonNode apuesta = iteradorApuestas.next();
						if (apuesta.get(EVENT_ID).asText().equals(evento.get(ID).asText())) {
							xmlMarket = new XmlMarket();
							xmlBetEvent = new XmlBetEvent();
							xmlBetType = new XmlBetType();

							xmlBetType = resolverBetType(apuesta);
							xmlBetEvent = resolverBetTypeEvent(apuesta);
							if (xmlBetEvent.getBetEvent().equals(BetEventUniBet.TERCER_CUARTO)) {
								xmlBetType = null;
							}
							if (xmlBetType != null && xmlBetType.getBetType() != null) {
								LOG.debug(Thread.currentThread(), "El tipo de mercado es " + xmlBetType.getBetType());
								if (evento.get(SPORT).asText() != null && xmlBetEvent.getBetEvent().equals(BetEventUniBet.PARTIDO_COMPLETO)) {
									if (evento.get(SPORT).asText().equals(AMERICAN_FOOTBALL) || evento.get(SPORT).asText().equals(BASEBALL)) {
										xmlBetEvent.setBetEvent(BetEventUniBet.PARTIDO_COMPLETO_PRORROGA);
									}
								}
								LOG.debug(Thread.currentThread(), "El tipo de evento es " + xmlBetEvent.getBetEvent());
								try {
									if (xmlBetType.getBetType().equals(BetTypeUniBet.HANDICAP_ASIATICO)) {
										xmlMarket = getMarketHandicapAsiatico(apuesta, xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(BetTypeUniBet.MAS_MENOS)) {
										xmlMarket = getMarketMasMenos(apuesta);
									} else if (xmlBetType.getBetType().equals(BetTypeUniBet.UNO_X_DOS)) {
										if (esGanadorPartido(apuesta)) {
											xmlBetType.setBetType(BetTypeUniBet.GANADOR_PARTIDO);
											xmlMarket = getMarketGanadorPartido(apuesta, xmlMatch.getXmlMatchParticipants());
										} else {
											xmlMarket = getMarketUnoXDos(apuesta, xmlMatch.getXmlMatchParticipants());
										}
									} else if (xmlBetType.getBetType().equals(BetTypeUniBet.UNO_X_DOS_HANDICAP)) {
										xmlMarket = getMarketUnoXDosHandicap(apuesta, xmlMatch.getXmlMatchParticipants());
									}
									xmlBetType.setXmlBetEvent(xmlBetEvent);
									xmlMarket.setXmlBetType(xmlBetType);
									LOG.debug(Thread.currentThread(), "Se agraga mercado a xmlmatch");
									xmlMatch.addXmlMarket(xmlMarket);
								} catch (XmlReaderException e) {
									LOG.error(Thread.currentThread(), e.getMessage());
								}
							}
						}
					}
				}
				// Si no existe la etiqueta sabemos que se trata de un evento de
				// largo plazo. Lo agregamos a una lista para tratarlos al salir
				// del bucle.
				else {
					JsonNode apuestas = nodo.get(BETOFFERS);
					Iterator<JsonNode> iteradorApuestas = apuestas.getElements();
					while (iteradorApuestas.hasNext()) {
						JsonNode apuesta = iteradorApuestas.next();
						if (apuesta.get(EVENT_ID).asText().equals(evento.get(ID).asText())) {
							JsonNode tipo = apuesta.get(BET_OFFER_TYPE);
							if (tipo.get(NAME).asText().equals(WINNER)) {
								listaLargoPlazo.add(apuesta);
							}
						}
					}
				}
				if (xmlMatch.getXmlMarkets() != null && xmlMatch.getXmlMarkets().size() > 0) {
					result.addXmlMatch(xmlMatch);
				}
			}
			// Procedemos a tratar las apuestas de largo.
			if (listaLargoPlazo != null && listaLargoPlazo.size() > 0) {
				for (JsonNode apuestaLargoPlazo : listaLargoPlazo) {
					for (JsonNode evento : eventos) {
						if (apuestaLargoPlazo.get(EVENT_ID).asText().equals(evento.get(ID).asText())) {
							LOG.debug(Thread.currentThread(), "El trata evento de largo plazo");
							XmlMatch xmlMatch = new XmlMatch();

							JsonNode criterio = apuestaLargoPlazo.get(CRITERION);
							xmlMatch.setName(evento.get(NAME).asText() + WHITE_SPACE + criterio.get(LABEL).asText());

							xmlMatch.setStartDate(getStartDate(crearDate(apuestaLargoPlazo.get(CLOSED).asText()), DATE_FORMAT,
									cfgBookmakerConfiguration.getTimeZone()));
							LOG.debug(Thread.currentThread(), "El partido es " + xmlMatch.getName());
							JsonNode grupoPadre = nodoPadre.get(GROUP);
							JsonNode gruposPadre = grupoPadre.get(GROUPS);
							XmlSport xmlSport = new XmlSport();
							xmlSport.setName(evento.get(SPORT).asText());
							LOG.debug(Thread.currentThread(), "El deporte es " + xmlSport.getName());
							regionGlobal = EMPTY_STRING;
							obtenerRegion(xmlSport.getName(), gruposPadre, evento.get(GROUP_ID).asText(), EMPTY_STRING);
							String region = regionGlobal;
							XmlRegion xmlRegion = new XmlRegion();
							xmlRegion.setName(region);
							LOG.debug(Thread.currentThread(), "La region es " + xmlRegion.getName());

							XmlTournament xmlTournament = new XmlTournament();
							xmlTournament.setName(region + WHITE_SPACE + evento.get(GROUP).asText());
							xmlTournament.setRegion(xmlRegion);
							xmlTournament.setXmlSport(xmlSport);
							LOG.debug(Thread.currentThread(), "El torneo es " + xmlTournament.getName());
							JsonNode participantes = apuestaLargoPlazo.get(OUTCOMES);
							for (JsonNode participante : participantes) {
								xmlTournament.addParticipant(participante.get(LABEL).asText());
								xmlMatch.addXmlMatchParticipant(new XmlMatchParticipant(participante.get(LABEL).asText(), xmlTournament));
								LOG.debug(Thread.currentThread(), "Se añade participante: " + participante.get(LABEL).asText());
							}
							xmlMatch.setXmlTournament(xmlTournament);

							XmlMarket xmlMarket = new XmlMarket();

							XmlBetType xmlBetType = new XmlBetType();
							xmlBetType.setBetType(BetTypeUniBet.getTypeByValue(criterio.get(LABEL).asText()));
							if (xmlBetType.getBetType() != null) {
								LOG.debug(Thread.currentThread(), "El tipo de apuesta es: " + xmlBetType.getBetType());
								try {
									if (xmlBetType.getBetType().equals(BetTypeUniBet.MAXIMO_GOLEADOR)) {
										xmlMarket = getMarketMaximoGoleador(apuestaLargoPlazo, xmlMatch.getXmlMatchParticipants());
									} else {
										xmlMarket = getMarketGanador(apuestaLargoPlazo, xmlMatch.getXmlMatchParticipants());
									}
									LOG.debug(Thread.currentThread(), "Se añade mercado al xmlmatch");
									xmlMatch.addXmlMarket(xmlMarket);
								} catch (XmlReaderException e) {
									LOG.error(Thread.currentThread(), e.getMessage());
								}
							}
							if (xmlMatch.getXmlMarkets() != null && xmlMatch.getXmlMarkets().size() > 0) {
								result.addXmlMatch(xmlMatch);
							}
						}
					}
				}
			}

		} catch (JsonProcessingException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
		} catch (IOException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "se finaliza el reader UniBet");
		return result;
	}

	private boolean esGanadorPartido(JsonNode apuesta) {
		boolean retorno = false;
		JsonNode bets = apuesta.get(OUTCOMES);
		if (bets.size() == 2) {
			retorno = true;
		}
		return retorno;
	}

	private XmlBetEvent resolverBetTypeEvent(JsonNode apuesta) {
		XmlBetEvent retorno = new XmlBetEvent();
		JsonNode eventoApuesta = apuesta.get(CRITERION);
		retorno.setBetEvent(BetEventUniBet.getEventByValue(eventoApuesta.get(LABEL).asText()));

		return retorno;
	}

	private XmlBetType resolverBetType(JsonNode apuesta) {
		// Se resuelve el tipo de apuesta
		XmlBetType retorno = new XmlBetType();
		JsonNode tipoApuesta = apuesta.get(BET_OFFER_TYPE);
		retorno.setBetType(BetTypeUniBet.getTypeByValue(tipoApuesta.get(ID).asText()));
		if (retorno.getBetType() != null) {
			if (retorno.getBetType().equals(BetTypeUniBet.GANADOR_PARTIDO)) {
				retorno.setBetType(BetTypeUniBet.UNO_X_DOS);
			}
			if (retorno.getBetType().equals(BetTypeUniBet.UNO_X_DOS)) {
				JsonNode excepcion = apuesta.get(CRITERION);
				if (BetsInvalidUniBet.getMarketByValue(excepcion.get(LABEL).asText()).equals(BetsInvalidUniBet.ganador_partido)) {
					retorno = null;
				}
			} else if (retorno.getBetType().equals(BetTypeUniBet.MAS_MENOS)) {
				JsonNode excepcion = apuesta.get(CRITERION);
				if (BetsInvalidUniBet.getMarketByValue(excepcion.get(LABEL).asText()).equals(BetsInvalidUniBet.mas_menos)) {
					retorno = null;
				}
			}else if (retorno.getBetType().equals(BetTypeUniBet.HANDICAP_ASIATICO)) {
				JsonNode excepcion = apuesta.get(CRITERION);
				if (BetsInvalidUniBet.getMarketByValue(excepcion.get(LABEL).asText()).equals(BetsInvalidUniBet.handicap_asiatico)) {
					retorno = null;
				}
			}
		}
		return retorno;
	}

	private synchronized void obtenerRegion(String deporte, JsonNode nodoBusqueda, String competicionId, String name) {
		// recorremos el nodo y los posibles subnodos en busca del id de
		// competicion. Si lo encontramos retornamos el name del padre.
		Iterator<JsonNode> iteradorBusqueda = nodoBusqueda.getElements();
		while (iteradorBusqueda.hasNext() && regionGlobal.isEmpty()) {
			JsonNode elemento = iteradorBusqueda.next();
			if (elemento.get("sport").asText().equalsIgnoreCase(deporte)) {
				if (elemento.get(ID).asText().equals(competicionId)) {
					regionGlobal = name;
				} else {
					if (elemento.get(GROUPS) != null) {
						JsonNode subElemento = elemento.get(GROUPS);
						obtenerRegion(deporte, subElemento, competicionId, elemento.get(NAME).asText());
					}
				}
			}
		}
	}

	private String crearDate(String dateXml) {
		String fechaFormateada = dateXml.replace(T, WHITE_SPACE);
		fechaFormateada = fechaFormateada.replace(Z, EMPTY_STRING);
		fechaFormateada = fechaFormateada.replace(COMILLAS, EMPTY_STRING);
		return fechaFormateada;
	}

	@Override
	public XmlMarket getMarketGanador(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants) throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		XmlWinnerAttribute xmlAttribute = new XmlWinnerAttribute();
		XmlBetType xmlBetType = new XmlBetType();
		Double cuota = 0d;
		xmlBetType.setBetType(BetTypeUniBet.GANADOR);
		retorno.setXmlBetType(xmlBetType);

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new XmlWinnerAttribute();

			xmlAttribute.setName(bet.get(LABEL).asText());

			for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
				if (xmlParticipant.getName().equals(bet.get(LABEL).asText())) {
					xmlAttribute.setWinner(xmlParticipant);
					xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
				}
			}

			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketGanadorPartido(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants) throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();
		Double cuota = 0d;

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new XmlMatchWinnerAttribute();

			if (bet.get(TYPE).asText().equals(OT_ONE)) {
				xmlAttribute.setResult(Result.ONE);
				for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
					if (xmlParticipant.isHomeParticipant()) {
						xmlAttribute.setWinnerName(xmlParticipant);
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					}
				}
			} else if (bet.get(TYPE).asText().equals(OT_TWO)) {
				xmlAttribute.setResult(Result.TWO);
				for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
					if (xmlParticipant.isAwayParticipant()) {
						xmlAttribute.setWinnerName(xmlParticipant);
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					}
				}
			}
			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketHandicapAsiatico(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		XmlAsianHandicapAttribute xmlAttribute = new XmlAsianHandicapAttribute();
		Double cuota = 0d;
		Double firstValue = 0d;

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new XmlAsianHandicapAttribute();
			firstValue = 0d;
			firstValue = (bet.get(LINE).getDoubleValue()) / 1000;

			for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
				if (bet.get(LABEL).asText().equals(xmlParticipant.getName())) {
					if (xmlParticipant.isHomeParticipant()) {
						xmlAttribute.setAsianResult(AsianResult.ONE);
						xmlAttribute.setName(xmlParticipant.getName());
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					} else if (xmlParticipant.isAwayParticipant()) {
						xmlAttribute.setAsianResult(AsianResult.TWO);
						xmlAttribute.setName(xmlParticipant.getName());
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
						firstValue = firstValue * -1;
					}
				}
			}
			xmlAttribute.setFirstValue(firstValue);
			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketMasMenos(Object market) throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
		Double cuota = 0d;
		Double total = 0d;

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new XmlMoreLessAttribute();
			cuota = 0d;
			total = 0d;

			total = (bet.get(LINE).getDoubleValue()) / 1000;
			xmlAttribute.setTotalGoal(total);
			if (bet.get(TYPE).asText().equals(OT_OVER)) {
				xmlAttribute.setMasMenos(MasMenos.MAS);
			} else if (bet.get(TYPE).asText().equals(OT_UNDER)) {
				xmlAttribute.setMasMenos(MasMenos.MENOS);
			}

			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketUnoXDos(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants) throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
		Double cuota = 0d;

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new Xml1X2Attribute();

			if (bet.get(TYPE).asText().equals(OT_ONE)) {
				xmlAttribute.setResult(Result.ONE);
				for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
					if (xmlParticipant.isHomeParticipant()) {
						xmlAttribute.setName(xmlParticipant.getName());
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					}
				}
			} else if (bet.get(TYPE).asText().equals(OT_CROSS)) {
				xmlAttribute.setResult(Result.DRAW);
			} else if (bet.get(TYPE).asText().equals(OT_TWO)) {
				xmlAttribute.setResult(Result.TWO);
				for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
					if (xmlParticipant.isAwayParticipant()) {
						xmlAttribute.setName(xmlParticipant.getName());
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					}
				}
			}

			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
		Double cuota = 0d;
		Double firstValue = 0d;

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new Xml1X2HandicapAttribute();

			if (bet.get(TYPE).asText().equals(OT_ONE)) {
				xmlAttribute.setResult(Result.ONE);
				for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
					if (xmlParticipant.isHomeParticipant()) {
						xmlAttribute.setName(xmlParticipant.getName());
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					}
				}
			} else if (bet.get(TYPE).asText().equals(OT_CROSS)) {
				xmlAttribute.setResult(Result.DRAW);
			} else if (bet.get(TYPE).asText().equals(OT_TWO)) {
				xmlAttribute.setResult(Result.TWO);
				for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
					if (xmlParticipant.isAwayParticipant()) {
						xmlAttribute.setName(xmlParticipant.getName());
						xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
					}
				}
			}
			firstValue = 0d;
			firstValue = (bet.get(LINE).getDoubleValue()) / 1000;
			xmlAttribute.setFirstValue(firstValue);
			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketMaximoGoleador(Object market, Collection<XmlMatchParticipant> xmlMatchParticipants) throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlUrl xmlUrl = new XmlUrl();
		XmlMaximumGoalerAttribute xmlAttribute = new XmlMaximumGoalerAttribute();
		XmlBetType xmlBetType = new XmlBetType();
		Double cuota = 0d;
		xmlBetType.setBetType(BetTypeUniBet.MAXIMO_GOLEADOR);
		retorno.setXmlBetType(xmlBetType);

		JsonNode bets = ((JsonNode) market).get(OUTCOMES);
		Iterator<JsonNode> iteradorBets = bets.getElements();
		while (iteradorBets.hasNext()) {
			JsonNode bet = iteradorBets.next();
			xmlMarketBet = new XmlMarketBet();
			xmlAttribute = new XmlMaximumGoalerAttribute();

			xmlAttribute.setName(bet.get(LABEL).asText());

			for (XmlMatchParticipant xmlParticipant : xmlMatchParticipants) {
				if (xmlParticipant.getName().equals(bet.get(LABEL).asText())) {
					xmlAttribute.setGoaler(xmlParticipant);
					xmlMarketBet.setXmlMatchParticipant(xmlParticipant);
				}
			}

			xmlMarketBet.setXmlAttribute(xmlAttribute);

			cuota = (bet.get(ODDS).getDoubleValue()) / 1000;
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota.toString()));

			xmlUrl = new XmlUrl();
			xmlUrl.setUrl("https://es.unibet.com/betting#/event/" + ((JsonNode) market).get(EVENT_ID).asText());
			xmlMarketBet.setXmlUrl(xmlUrl);

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}
}
