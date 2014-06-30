/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bluesquare;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBlueSquare;
import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare.BSQCUBS;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare.Market;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare.Occurrence;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare.Type;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class XMLBlueSquareFileReader.
 */
@Component
public class XMLBlueSquareFileReader extends AbstractXmlFilereader implements
		MarketType {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XMLBlueSquareFileReader.class);

	/** The Constant FORMATTER_DATE. */
	private static final SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static final String PARTICIPANTS_SEPARATOR = " v ";

	private static Double handicapFirstValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#readXml(java.io.InputStream,
	 * com.comparadorad.bet.comparer
	 * .model.config.bean.bmconf.CfgBookmakerConfiguration)
	 */
	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws XmlReaderException {
		LOG.info("Entramos en el reader de BlueSquare");
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		BSQCUBS bsqcubs = null;

		try {
			bsqcubs = (BSQCUBS) JaxbUtils.readXML(pFile, BSQCUBS.class);
			Collection<XmlMatch> xmlMatchs = new ArrayList<XmlMatch>();

			LOG.info("Parseamos el xml");

			XmlMatch xmlMatch;
			if (bsqcubs != null && bsqcubs.getClazz() != null
					&& bsqcubs.getClazz().getType() != null) {
				for (Type type : bsqcubs.getClazz().getType()) {
					for (Event event : type.getEvent()) {
						xmlMatch = new XmlMatch();
						LOG.info(new StringBuffer(
								"Se procede a resolver el match: ").append(
								event.getDescription()).toString());
						xmlMatch.setName(event.getDescription());
						xmlMatch.setStartDate(new XmlDate(parseDate(event
								.getStartTime())));

						XmlSport xmlSport = new XmlSport();
						xmlSport.setName(bsqcubs.getClazz().getTitle());

						XmlTournament xmlTournament = new XmlTournament(
								type.getTitle());
						xmlTournament.setXmlSport(xmlSport);

						Collection<XmlMatchParticipant> xmlParticipants = new ArrayList<XmlMatchParticipant>();
						for (Market market : event.getMarket()) {
							XmlBetType xmlBetType = resolveBetType(market);
							if (xmlBetType != null
									&& xmlBetType.getBetType() != null) {
								xmlParticipants = resolveXmlParticipants(event,
										xmlTournament);
								xmlMatch.setXmlTournament(xmlTournament);
								xmlMatch.setXmlMatchParticipants(xmlParticipants);

								XmlMarket xmlMarket = null;
								try {
									if (xmlBetType.getBetType().equals(
											BetTypeBlueSquare.GANADOR_PARTIDO)) {
										xmlMarket = getMarketGanadorPartido(
												market,
												xmlMatch.getXmlMatchParticipants());
										// } else if
										// (xmlBetType.getBetType().equals(
										// BetTypeBlueSquare.GANADOR)) {
										// xmlMarket = getMarketGanador(
										// market,
										// xmlMatch.getXmlMatchParticipants());
										// } else if (xmlBetType
										// .getBetType()
										// .equals(BetTypeBlueSquare.HANDICAP_ASIATICO))
										// {
										// xmlMarket =
										// getMarketHandicapAsiatico(
										// market,
										// xmlMatch.getXmlMatchParticipants());
										// } else if
										// (xmlBetType.getBetType().equals(
										// BetTypeBlueSquare.MAS_MENOS)) {
										// xmlMarket =
										// getMarketMasMenos(market);
									} else if (xmlBetType.getBetType().equals(
											BetTypeBlueSquare.UNO_X_DOS)) {
										xmlMarket = getMarketUnoXDos(
												market,
												xmlMatch.getXmlMatchParticipants());
									} else if (xmlBetType
											.getBetType()
											.equals(BetTypeBlueSquare.UNO_X_DOS_HANDICAP)) {
										xmlMarket = getMarketUnoXDosHandicap(
												market,
												xmlMatch.getXmlMatchParticipants());
										// } else if (xmlBetType
										// .getBetType()
										// .equals(BetTypeBlueSquare.MAXIMO_GOLEADOR))
										// {
										// xmlMarket =
										// getMarketMaximoGoleador(
										// outcomeSet,
										// xmlMatch.getXmlMatchParticipants());
									}
									xmlMarket.setXmlBetType(xmlBetType);
								} catch (BlueSquareAttributeException e) {
									LOG.error(new StringBuffer()
											.append("Error al rellenar los atributos del evento, se ignora el evento. ")
											.append(e.getMessage()).toString());
								}

								// XmlMarketBet xmlBet;
								// for (Occurrence occurrence : market
								// .getOccurrence()) {
								// try {
								//
								//
								//
								// xmlBet = resolveBet(market, occurrence,
								// betType, xmlTournament,
								// xmlParticipants);
								//
								// xmlMarket.addXmlBet(xmlBet);
								// } catch (BlueSquareAttributeException e) {
								// LOG.error(new StringBuffer()
								// .append("Error al rellenar los atributos del evento, se ignora el evento.")
								// .append(e.getMessage())
								// .toString());
								// }
								// }
								if (xmlMarket != null) {
									xmlMarket.setXmlBetType(xmlBetType);
								}

								if (xmlMarket != null
										&& xmlMarket.getXmlMarketBets().size() > 0) {
									xmlMatch.addXmlMarket(xmlMarket);
									xmlMatchs.add(xmlMatch);
									LOG.info(new StringBuffer(
											"Se resuelve satisfactoriamente el match: ")
											.append(event.getDescription())
											.append(" de la competicion ")
											.append(xmlMatch.getXmlTournament()
													.getName())
											.append(" y el deporte ")
											.append(xmlMatch.getXmlTournament()
													.getXmlSport().getName())
											.toString());
								}
							}
						}
					}
				}
				LOG.info(new StringBuffer("Se resuelven ")
						.append(xmlMatchs.size()).append(" partidos.")
						.toString());
				xmlBookmakerEvents.setXmlMatchs(xmlMatchs);
			} else {
				LOG.info("El xml esta vacío.");
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(errorMessage, e);
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: "
					+ JaxbUtils.writeXML(bsqcubs, BSQCUBS.class);
			LOG.error(errorMessage, e);
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
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws BlueSquareAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Occurrence bet : ((Market) market).getOccurrence()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2HandicapAttribute xmlAttribute = new Xml1X2HandicapAttribute();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(bet
						.getDecimal().toString());

				String participanteString = "";
				if (bet.getDescription().contains("+")) {
					participanteString = bet.getDescription().split("\\+")[0]
							.trim();
				} else {
					participanteString = bet.getDescription().split("\\-")[0]
							.trim();
				}
				xmlAttribute = new Xml1X2HandicapAttribute();
				XmlMatchParticipant participante = getParticipantByName(
						xmlMatchParticipants, participanteString);
				xmlMarketBet.setXmlMatchParticipant(participante);

				if (participante != null) {
					if (participante.isHomeParticipant()) {
						xmlAttribute.setResult(Result.ONE);
						if (bet.getDescription().contains("+")) {
							handicapFirstValue = Double
									.valueOf(bet.getDescription()
											.substring(
													bet.getDescription()
															.indexOf("+") + 1));
						} else {
							handicapFirstValue = Double.valueOf(bet
									.getDescription().substring(
											bet.getDescription().indexOf("-")));
						}
					} else if (participante.isAwayParticipant()) {
						xmlAttribute.setResult(Result.TWO);
					}
				} else {
					xmlAttribute.setResult(Result.DRAW);
				}
				((Xml1X2HandicapAttribute) xmlAttribute)
						.setFirstValue(handicapFirstValue);

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			for (XmlMarketBet marketBet : xmlMarket.getXmlMarketBets()) {
				((Xml1X2HandicapAttribute) marketBet.getXmlAttribute())
						.setFirstValue(handicapFirstValue);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new BlueSquareAttributeException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketUnoXDos(java.lang.Object, java.util.Collection)
	 */
	public XmlMarket getMarketUnoXDos(final Object market,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws BlueSquareAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Occurrence bet : ((Market) market).getOccurrence()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();

				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(bet
						.getDecimal().toString());

				XmlMatchParticipant participante = getParticipantByName(
						xmlMatchParticipants, bet.getDescription());
				xmlMarketBet.setXmlMatchParticipant(participante);
				if (participante != null) {
					if (participante.isHomeParticipant()) {
						((Xml1X2Attribute) xmlAttribute).setResult(Result.ONE);
					} else {
						((Xml1X2Attribute) xmlAttribute).setResult(Result.TWO);
					}
				} else {
					((Xml1X2Attribute) xmlAttribute).setResult(Result.DRAW);
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
			return xmlMarket;
		} catch (Exception e) {
			throw new BlueSquareAttributeException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketMasMenos(java.lang.Object)
	 */
	public XmlMarket getMarketMasMenos(final Object market)
			throws BlueSquareAttributeException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketHandicapAsiatico(java.lang.Object,
	 * java.util.Collection)
	 */
	public XmlMarket getMarketHandicapAsiatico(final Object market,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws BlueSquareAttributeException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketGanador(java.lang.Object, java.util.Collection)
	 */
	public XmlMarket getMarketGanador(final Object market,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws BlueSquareAttributeException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .IMarketType#getMarketGanadorPartido(java.lang.Object,
	 * java.util.Collection)
	 */
	public XmlMarket getMarketGanadorPartido(final Object market,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws BlueSquareAttributeException {
		XmlMarket xmlMarket = new XmlMarket();
		try {
			for (Occurrence bet : ((Market) market).getOccurrence()) {
				XmlMarketBet xmlMarketBet = new XmlMarketBet();
				XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(bet
						.getDecimal().toString());
				XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();

				XmlMatchParticipant participante = getParticipantByName(
						xmlMatchParticipants, bet.getDescription());
				((XmlMatchWinnerAttribute) xmlAttribute)
						.setWinnerName(participante);
				xmlMarketBet.setXmlMatchParticipant(participante);
				if (participante.isHomeParticipant()) {
					((XmlMatchWinnerAttribute) xmlAttribute)
							.setResult(Result.ONE);
				} else {
					((XmlMatchWinnerAttribute) xmlAttribute)
							.setResult(Result.TWO);
				}

				xmlMarketBet.setXmlAttribute(xmlAttribute);
				xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
				xmlMarket.addXmlBet(xmlMarketBet);
			}
		} catch (Exception e) {
			throw new BlueSquareAttributeException(e.getMessage());
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
	public XmlMarket getMarketMaximoGoleador(final Object market,
			final Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws BlueSquareAttributeException {

		return null;
	}

	private Collection<XmlMatchParticipant> resolveXmlParticipants(
			final Event event, final XmlTournament xmlTournament) {
		Collection<XmlMatchParticipant> xmlParticipants = new ArrayList<XmlMatchParticipant>();

		XmlMatchParticipant participante = new XmlMatchParticipant();

		String participants[] = event.getDescription().split(
				PARTICIPANTS_SEPARATOR);

		participante = new XmlMatchParticipant(participants[0], true, false,
				xmlTournament);
		xmlParticipants.add(participante);

		participante = new XmlMatchParticipant(participants[1], false, true,
				xmlTournament);
		xmlParticipants.add(participante);

		return xmlParticipants;
	}

	// private XmlMarketBet resolveBet(Market market, Occurrence occurrence,
	// XmlBetType betType, XmlTournament xmlTournament,
	// Collection<XmlMatchParticipant> xmlParticipants)
	// throws BlueSquareAttributeException {
	// XmlMarketBet xmlBet = null;
	// try {
	// xmlBet = new XmlMarketBet(new XmlMarketBetOdd(occurrence
	// .getDecimal().toString()));
	//
	// IXmlAttribute xmlAttribute = null;
	// if (betType.getBetType().equals(BetTypeBlueSquare.UNO_X_DOS)
	// && market.getOccurrence().size() == 3) {
	// xmlAttribute = new Xml1X2Attribute();
	// XmlMatchParticipant participante = getParticipantByName(
	// xmlParticipants, occurrence.getDescription());
	// xmlBet.setXmlMatchParticipant(participante);
	// if (participante != null) {
	// if (participante.isHomeParticipant()) {
	// ((Xml1X2Attribute) xmlAttribute).setResult(Result.ONE);
	// } else {
	// ((Xml1X2Attribute) xmlAttribute).setResult(Result.TWO);
	// }
	// } else {
	// ((Xml1X2Attribute) xmlAttribute).setResult(Result.DRAW);
	// }
	// } else if (betType.getBetType().equals(
	// BetTypeBlueSquare.UNO_X_DOS_HANDICAP)
	// && market.getOccurrence().size() == 3) {
	// String participanteString = "";
	// if (occurrence.getDescription().contains("+")) {
	// participanteString = occurrence.getDescription().split(
	// "\\+")[0].trim();
	// } else {
	// participanteString = occurrence.getDescription().split(
	// "\\-")[0].trim();
	// }
	// xmlAttribute = new Xml1X2HandicapAttribute();
	// XmlMatchParticipant participante = getParticipantByName(
	// xmlParticipants, participanteString);
	// xmlBet.setXmlMatchParticipant(participante);
	//
	// if (occurrence.getDescription().contains("+")) {
	// if (handicapFirstValue == null) {
	// handicapFirstValue = Double.valueOf(occurrence
	// .getDescription().substring(
	// occurrence.getDescription()
	// .indexOf("+") + 1));
	// }
	// ((Xml1X2HandicapAttribute) xmlAttribute)
	// .setFirstValue(handicapFirstValue);
	// } else if (occurrence.getDescription().contains("-")) {
	// if (handicapFirstValue == null) {
	// handicapFirstValue = Double.valueOf(occurrence
	// .getDescription().substring(
	// occurrence.getDescription()
	// .indexOf("-") + 1));
	// String hand = "-" + String.valueOf(handicapFirstValue);
	// handicapFirstValue = Double.parseDouble(hand);
	// }
	//
	// ((Xml1X2HandicapAttribute) xmlAttribute)
	// .setFirstValue(handicapFirstValue);
	// }
	//
	// if (participante != null) {
	// if (participante.isHomeParticipant()) {
	// ((Xml1X2HandicapAttribute) xmlAttribute)
	// .setResult(Result.ONE);
	// } else {
	// ((Xml1X2HandicapAttribute) xmlAttribute)
	// .setResult(Result.TWO);
	// }
	// } else {
	// ((Xml1X2HandicapAttribute) xmlAttribute)
	// .setResult(Result.DRAW);
	// ((Xml1X2HandicapAttribute) xmlAttribute)
	// .setFirstValue(handicapFirstValue);
	// }
	//
	// } else if (betType.getBetType().equals(
	// BetTypeBlueSquare.GANADOR_PARTIDO)
	// && market.getOccurrence().size() == 2) {
	// xmlAttribute = new XmlMatchWinnerAttribute();
	//
	// XmlMatchParticipant participante = getParticipantByName(
	// xmlParticipants, occurrence.getDescription());
	// ((XmlMatchWinnerAttribute) xmlAttribute)
	// .setWinnerName(participante);
	// xmlBet.setXmlMatchParticipant(participante);
	// if (participante.isHomeParticipant()) {
	// ((XmlMatchWinnerAttribute) xmlAttribute)
	// .setResult(Result.ONE);
	// } else {
	// ((XmlMatchWinnerAttribute) xmlAttribute)
	// .setResult(Result.TWO);
	// }
	//
	// }
	// xmlBet.setXmlAttribute(xmlAttribute);
	// } catch (Exception e) {
	// throw new BlueSquareAttributeException(e.getMessage());
	// }
	//
	// return xmlBet;
	// }

	/**
	 * Resolve bet type.
	 * 
	 * @param market
	 *            the market
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(Market market) {
		XmlBetType result = null;
		IBetType betType = BetTypeBlueSquare.getTypeByValue(market.getMktTyp());
		if ((betType != null)
				&& ((betType.equals(BetTypeBlueSquare.UNO_X_DOS) && market
						.getOccurrence().size() == 3)
						|| (betType.equals(BetTypeBlueSquare.GANADOR_PARTIDO) && market
								.getOccurrence().size() == 2) || (betType
						.equals(BetTypeBlueSquare.UNO_X_DOS_HANDICAP) && market
						.getOccurrence().size() == 3))) {
			result = new XmlBetType();

			if ((betType.equals(BetTypeBlueSquare.UNO_X_DOS) && market
					.getOccurrence().size() == 3)) {
				betType = BetTypeBlueSquare.UNO_X_DOS;
			} else if (betType.equals(BetTypeBlueSquare.GANADOR_PARTIDO)
					&& market.getOccurrence().size() == 2) {
				betType = BetTypeBlueSquare.GANADOR_PARTIDO;
			} else if (betType.equals(BetTypeBlueSquare.UNO_X_DOS_HANDICAP)
					&& market.getOccurrence().size() == 3) {
				betType = BetTypeBlueSquare.UNO_X_DOS_HANDICAP;
			}

			result.setBetType(betType);

		}
		return result;
	}

	/**
	 * Parses the date.
	 * 
	 * @param startTime
	 *            the start time
	 * @return the date
	 */
	private Date parseDate(String startTime) {
		Date result = null;
		try {
			result = FORMATTER_DATE.parse(startTime);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#getBookmakerId()
	 */
	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BLUESQUARE_COM_ID.objectId()
				.toString();
	}

}
