/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.luckia;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventLuckia;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeLuckia;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XMLLuckiaFileReader.
 */
@Component
public class XMLLuckiaFileReader extends AbstractXmlFilereader implements
		MarketType {

	private static final String ENGLISH_NAME = "englishName";
	private static final String ET_COMPETITION = "ET_COMPETITION";
	private static final String ET_MATCH = "ET_MATCH";
	private static final String PATH = "path";
	private static final String SPORT_ID = "sportId";
	private static final String GANADOR = "Ganador";
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
	private static final String GROUP = "group";
	private static final String EVENTS = "events";
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id {@inheritDoc}
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.LUCKIA.objectId().toString();
	}

	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "se inicia el reader Luckia");
		XmlBookmakerEvents result = new XmlBookmakerEvents();
		try {
			JsonNode nodo = new ObjectMapper().readTree(pFile);
			JsonNode eventos = nodo.get(EVENTS);
			Iterator<JsonNode> iteradorEventos = eventos.getElements();

			// Recorremos todos los eventos(partidos) que encontramos en el json
			while (iteradorEventos.hasNext()) {
				JsonNode evento = iteradorEventos.next();
				String tipoEvento = evento.get("type").asText();
				// Si en la etiqueta type aparece ET_MATCH sabemos que se trata
				// de un evento de corto plazo
				if (tipoEvento.equals(ET_MATCH)) {
					LOG.debug(Thread.currentThread(),
							"Se procesa evento de corto plazo");
					XmlMatch xmlMatch = new XmlMatch();
					XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant();
					XmlTournament xmlTournament = new XmlTournament();
					XmlSport xmlSport = new XmlSport();
					XmlRegion xmlRegion = new XmlRegion();
					XmlMarket xmlMarket = new XmlMarket();
					XmlBetType xmlBetType = new XmlBetType();
					XmlBetEvent xmlBetEvent = new XmlBetEvent();
					String region = new String();

					xmlSport.setName(evento.get(SPORT).asText());
					LOG.debug(Thread.currentThread(), "El deporte es "
							+ xmlSport.getName());
					region = obtenerRegion(evento.get(GROUP_ID).asText(),
							evento.get(SPORT_ID).asText(), evento.get(PATH),
							evento.get(SPORT).asText());
					xmlRegion.setName(region);
					LOG.debug(Thread.currentThread(), "La region es "
							+ xmlRegion.getName());

					xmlTournament.setName(region + WHITE_SPACE
							+ evento.get(GROUP).asText());
					xmlTournament.setRegion(xmlRegion);
					xmlTournament.setXmlSport(xmlSport);
					LOG.debug(Thread.currentThread(), "El torneo es "
							+ xmlTournament.getName());
					xmlMatch.setName(evento.get(NAME).asText());
					xmlMatch.setStartDate(getStartDate(
							crearDate(evento.get(START).asText()), DATE_FORMAT,
							cfgBookmakerConfiguration.getTimeZone()));
					xmlMatch.setXmlTournament(xmlTournament);
					LOG.debug(Thread.currentThread(), "El partido es "
							+ xmlMatch.getName());

					if (evento.get(AWAY_NAME) != null) {
						xmlMatchParticipant = new XmlMatchParticipant(evento
								.get(AWAY_NAME).asText(), false, true,
								xmlTournament);
						xmlMatch.addXmlMatchParticipant(xmlMatchParticipant);
					}
					if (evento.get(HOME_NAME) != null) {
						xmlMatchParticipant = new XmlMatchParticipant(evento
								.get(HOME_NAME).asText(), true, false,
								xmlTournament);
						xmlMatch.addXmlMatchParticipant(xmlMatchParticipant);
					}
					JsonNode apuestas = nodo.get(BETOFFERS);
					Iterator<JsonNode> iteradorApuestas = apuestas
							.getElements();
					while (iteradorApuestas.hasNext()) {
						JsonNode apuesta = iteradorApuestas.next();
						if (apuesta.get(EVENT_ID).asText()
								.equals(evento.get(ID).asText())) {
							xmlMarket = new XmlMarket();
							xmlBetEvent = new XmlBetEvent();
							xmlBetType = new XmlBetType();

							xmlBetType = resolverBetType(apuesta);
							xmlBetEvent = resolverBetTypeEvent(apuesta);
							if (xmlBetEvent.getBetEvent().equals(
									BetEventLuckia.TERCER_CUARTO)) {
								xmlBetType = null;
							}
							if (xmlBetType != null
									&& xmlBetType.getBetType() != null) {
								LOG.debug(
										Thread.currentThread(),
										"El tipo de mercado es "
												+ xmlBetType.getBetType());
								if (evento.get(SPORT).asText() != null
										&& xmlBetEvent
												.getBetEvent()
												.equals(BetEventLuckia.PARTIDO_COMPLETO)) {
									if (evento.get(SPORT).asText()
											.equals(AMERICAN_FOOTBALL)
											|| evento.get(SPORT).asText()
													.equals(BASEBALL)) {
										xmlBetEvent
												.setBetEvent(BetEventLuckia.PARTIDO_COMPLETO_PRORROGA);
									}
								}
								LOG.debug(
										Thread.currentThread(),
										"El tipo de evento es "
												+ xmlBetEvent.getBetEvent());
								try {
									if (xmlBetType.getBetType().equals(
											BetTypeLuckia.HANDICAP_ASIATICO)) {
										xmlMarket = getMarketHandicapAsiatico(
												apuesta,
												xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType.getBetType().equals(
											BetTypeLuckia.MAS_MENOS)) {
										xmlMarket = getMarketMasMenos(apuesta);
									} else if (xmlBetType.getBetType().equals(
											BetTypeLuckia.UNO_X_DOS)) {
										if (esGanadorPartido(apuesta)) {
											xmlBetType
													.setBetType(BetTypeLuckia.GANADOR_PARTIDO);
											xmlMarket = getMarketGanadorPartido(
													apuesta,
													xmlMatch.getXmlMatchParticipants());
										} else {
											xmlMarket = getMarketUnoXDos(
													apuesta,
													xmlMatch.getXmlMatchParticipants());
										}
									} else if (xmlBetType.getBetType().equals(
											BetTypeLuckia.UNO_X_DOS_HANDICAP)) {
										xmlMarket = getMarketUnoXDosHandicap(
												apuesta,
												xmlMatch.getXmlMatchParticipants());
									}
									xmlBetType.setXmlBetEvent(xmlBetEvent);
									xmlMarket.setXmlBetType(xmlBetType);
									LOG.debug(Thread.currentThread(),
											"Se agraga mercado a xmlmatch");
									xmlMatch.addXmlMarket(xmlMarket);
								} catch (XmlReaderException e) {
									LOG.error(Thread.currentThread(),
											e.getMessage());
								}
							}
						}
					}
					if (xmlMatch.getXmlMarkets() != null
							&& xmlMatch.getXmlMarkets().size() > 0) {
						result.addXmlMatch(xmlMatch);
					}
				} else if (tipoEvento.equals(ET_COMPETITION)) {
					// Procedemos a tratar las apuestas de largo.
					JsonNode apuestas = nodo.get(BETOFFERS);
					Iterator<JsonNode> iteradorApuestas = apuestas
							.getElements();
					while (iteradorApuestas.hasNext()) {
						JsonNode apuestaLargoPlazo = iteradorApuestas.next();
						if (apuestaLargoPlazo.get(EVENT_ID).asText()
								.equals(evento.get(ID).asText())) {
							JsonNode tipo = apuestaLargoPlazo
									.get(BET_OFFER_TYPE);
							if (tipo.get(NAME).asText().equals(GANADOR)) {
								LOG.debug(Thread.currentThread(),
										"El trata evento de largo plazo");
								XmlMatch xmlMatch = new XmlMatch();

								JsonNode criterio = apuestaLargoPlazo
										.get(CRITERION);
								xmlMatch.setName(evento.get(NAME).asText()
										+ WHITE_SPACE
										+ criterio.get(LABEL).asText());

								xmlMatch.setStartDate(getStartDate(
										crearDate(apuestaLargoPlazo.get(CLOSED)
												.asText()), DATE_FORMAT,
										cfgBookmakerConfiguration.getTimeZone()));
								LOG.debug(Thread.currentThread(),
										"El partido es " + xmlMatch.getName());
								XmlSport xmlSport = new XmlSport();
								xmlSport.setName(evento.get(SPORT).asText());
								LOG.debug(Thread.currentThread(),
										"El deporte es " + xmlSport.getName());
								String region = obtenerRegion(
										evento.get(GROUP_ID).asText(), evento
												.get(SPORT_ID).asText(),
										evento.get(PATH), evento.get(SPORT)
												.asText());
								XmlRegion xmlRegion = new XmlRegion();
								xmlRegion.setName(region);
								LOG.debug(Thread.currentThread(),
										"La region es " + xmlRegion.getName());

								XmlTournament xmlTournament = new XmlTournament();
								xmlTournament.setName(region + WHITE_SPACE
										+ evento.get(GROUP).asText());
								xmlTournament.setRegion(xmlRegion);
								xmlTournament.setXmlSport(xmlSport);
								LOG.debug(
										Thread.currentThread(),
										"El torneo es "
												+ xmlTournament.getName());
								JsonNode participantes = apuestaLargoPlazo
										.get(OUTCOMES);
								for (JsonNode participante : participantes) {
									xmlTournament.addParticipant(participante
											.get(LABEL).asText());
									xmlMatch.addXmlMatchParticipant(new XmlMatchParticipant(
											participante.get(LABEL).asText(),
											xmlTournament));
									LOG.debug(Thread.currentThread(),
											"Se añade participante: "
													+ participante.get(LABEL)
															.asText());
								}
								xmlMatch.setXmlTournament(xmlTournament);

								XmlMarket xmlMarket = new XmlMarket();

								XmlBetType xmlBetType = new XmlBetType();
								xmlBetType.setBetType(BetTypeLuckia
										.getTypeByValue(criterio.get(LABEL)
												.asText()));
								if (xmlBetType.getBetType() != null) {
									LOG.debug(Thread.currentThread(),
											"El tipo de apuesta es: "
													+ xmlBetType.getBetType());
									try {
										if (xmlBetType.getBetType().equals(
												BetTypeLuckia.MAXIMO_GOLEADOR)) {
											xmlMarket = getMarketMaximoGoleador(
													apuestaLargoPlazo,
													xmlMatch.getXmlMatchParticipants());
										} else {
											xmlMarket = getMarketGanador(
													apuestaLargoPlazo,
													xmlMatch.getXmlMatchParticipants());
										}
										LOG.debug(Thread.currentThread(),
												"Se añade mercado al xmlmatch");
										xmlMatch.addXmlMarket(xmlMarket);
									} catch (XmlReaderException e) {
										LOG.error(Thread.currentThread(),
												e.getMessage());
									}
								}
								if (xmlMatch.getXmlMarkets() != null
										&& xmlMatch.getXmlMarkets().size() > 0) {
									result.addXmlMatch(xmlMatch);
								}
							}
						}
					}
				} else {
					LOG.debug(Thread.currentThread(),
							"Tipo de evento desconocido");
				}
			}

		} catch (JsonProcessingException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
		} catch (IOException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
		} catch (ParseException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
		}
		LOG.debug(Thread.currentThread(), "se finaliza el reader Luckia");
		return result;
	}

	private String obtenerRegion(String idGrupo, String idDeporte,
			JsonNode Paths, String deporte) {
		String result = "";
		Iterator<JsonNode> iteradorPaths = Paths.getElements();
		while (iteradorPaths.hasNext()) {
			JsonNode Path = iteradorPaths.next();
			String id = Path.get(ID).asText();
			if (!idGrupo.equals(id) && !idDeporte.equals(id)) {
				result = Path.get(ENGLISH_NAME).asText();
			}
		}
		if (result.equals("")) {
			result = deporte;
		}
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
		retorno.setBetEvent(BetEventLuckia.getEventByValue(eventoApuesta.get(
				LABEL).asText()));

		return retorno;
	}

	private XmlBetType resolverBetType(JsonNode apuesta) {
		// Se resuelve el tipo de apuesta
		XmlBetType retorno = new XmlBetType();
		JsonNode tipoApuesta = apuesta.get(BET_OFFER_TYPE);
		retorno.setBetType(BetTypeLuckia.getTypeByValue(tipoApuesta.get(ID)
				.asText()));
		if (retorno.getBetType() != null) {
			if (retorno.getBetType().equals(BetTypeLuckia.GANADOR_PARTIDO)) {
				retorno.setBetType(BetTypeLuckia.UNO_X_DOS);
			}
			if (retorno.getBetType().equals(BetTypeLuckia.UNO_X_DOS)) {
				JsonNode excepcion = apuesta.get(CRITERION);
				if (BetsInvalidLuckia.getMarketByValue(
						excepcion.get(LABEL).asText()).equals(
						BetsInvalidLuckia.ganador_partido)) {
					retorno = null;
				}
			} else if (retorno.getBetType().equals(BetTypeLuckia.MAS_MENOS)) {
				JsonNode excepcion = apuesta.get(CRITERION);
				if (BetsInvalidLuckia.getMarketByValue(
						excepcion.get(LABEL).asText()).equals(
						BetsInvalidLuckia.mas_menos)) {
					retorno = null;
				}
			} else if (retorno.getBetType().equals(
					BetTypeLuckia.HANDICAP_ASIATICO)) {
				JsonNode excepcion = apuesta.get(CRITERION);
				if (BetsInvalidLuckia.getMarketByValue(
						excepcion.get(LABEL).asText()).equals(
						BetsInvalidLuckia.handicap_asiatico)) {
					retorno = null;
				}
			}
		}
		return retorno;
	}

	private String crearDate(String dateXml) {
		String fechaFormateada = dateXml.replace(T, WHITE_SPACE);
		fechaFormateada = fechaFormateada.replace(Z, EMPTY_STRING);
		fechaFormateada = fechaFormateada.replace(COMILLAS, EMPTY_STRING);
		return fechaFormateada;
	}

	@Override
	public XmlMarket getMarketGanador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlWinnerAttribute xmlAttribute = new XmlWinnerAttribute();
		XmlBetType xmlBetType = new XmlBetType();
		Double cuota = 0d;
		xmlBetType.setBetType(BetTypeLuckia.GANADOR);
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketGanadorPartido(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketHandicapAsiatico(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketMasMenos(Object market) throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketUnoXDos(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			
			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			
			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}

	@Override
	public XmlMarket getMarketMaximoGoleador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		XmlMarket retorno = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlMaximumGoalerAttribute xmlAttribute = new XmlMaximumGoalerAttribute();
		XmlBetType xmlBetType = new XmlBetType();
		Double cuota = 0d;
		xmlBetType.setBetType(BetTypeLuckia.MAXIMO_GOLEADOR);
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
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(cuota
					.toString()));

			retorno.addXmlBet(xmlMarketBet);
		}
		return retorno;
	}
}
