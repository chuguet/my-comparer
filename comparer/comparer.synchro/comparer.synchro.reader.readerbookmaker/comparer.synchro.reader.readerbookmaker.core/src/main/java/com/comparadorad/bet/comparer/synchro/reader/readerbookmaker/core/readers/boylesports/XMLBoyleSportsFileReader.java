/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.boylesports;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBoyleSports;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBoyleSports;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.IXmlAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmaker;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.boylesports.Bet;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.boylesports.Bettype;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.boylesports.Category;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.boylesports.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class XMLBoyleSportsFileReader.
 */
@Component
public class XMLBoyleSportsFileReader extends AbstractXmlFilereader {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	/** The Constant DATE_FORMAT_EVENT. */
	private static final String DATE_FORMAT_EVENT = "yyyyMMddHHmm";

	/** The Constant DATE_FORMAT_EVENT. */
	private static final String DATE_FORMAT_CATEGORY = "yyyyMMddHHmm";

	/** The Constant HOME. */
	private static final String HOME = "HOME";

	/** The Constant AWAY. */
	private static final String AWAY = "AWAY";

	/** The Constant DRAW. */
	private static final String DRAW = "DRAW";

	private static final String HANDICAP_TIE = "Handicap Tie";

	/** The asian handicap value. */
	private Double asianHandicapValue;
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XMLBoyleSportsFileReader.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers
	 * .AbstractXmlFilereader#read(java.io.InputStream,
	 * com.comparadorad.bet.comparer
	 * .model.config.bean.bmconf.CfgBookmakerConfiguration)
	 */
	@Override
	public XmlBookmakerEvents readXml(final InputStream pFile, final CfgBookmakerConfiguration bookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Category category = null;
		try {
			XmlMatch xmlMatch;
			category = (Category) JaxbUtils.readXML(pFile, Category.class);

			XmlDate xmlDate = getStartDate(category.getTimeGenerated().toString(), DATE_FORMAT, bookmakerConfiguration.getTimeZone());
			XmlBookmaker xmlBookmaker = new XmlBookmaker();
			xmlBookmaker.setName(category.getBookmaker());
			xmlBookmakerEvents.setXmlBookmaker(xmlBookmaker);
			xmlBookmakerEvents.setFileDate(xmlDate);

			for (Event event : category.getEvent()) {
				// Creo el xmlMatch
				xmlMatch = new XmlMatch();
				xmlMatch.setName(event.getName());

				try {
					xmlDate = getStartDate(new StringBuffer(event.getDate()).append(event.getTime()).toString(), DATE_FORMAT_EVENT,
							bookmakerConfiguration.getTimeZone());

				} catch (ParseException e) {
					// xmlDate =
					// getStartDate(category.getTimeGenerated().toString(),
					// DATE_FORMAT, bookmakerConfiguration.getTimeZone());
					xmlDate = getStartDate("2100-01-01T00:00:00", DATE_FORMAT, bookmakerConfiguration.getTimeZone());
				}
				xmlMatch.setStartDate(xmlDate);

				// Creo el xmlTournament para cada xmlMatch
				XmlTournament xmlTournament = new XmlTournament();
				if (event.getName() != null) {
					if (event.getName().contains(" v ") || event.getName().contains(" vs. ") || event.getName().contains(" vs ")) {
						xmlTournament.setName(event.getSport());
					} else {
						xmlTournament.setName(event.getName());
					}
				} else if (event.getMeeting() != null) {
					xmlTournament.setName(event.getMeeting());
				} else if (event.getVenue() != null) {
					xmlTournament.setName(event.getMeeting());
				}
				XmlSport xmlSport = new XmlSport();
				xmlSport.setName(category.getName());
				xmlTournament.setXmlSport(xmlSport);
				xmlMatch.setXmlTournament(xmlTournament);

				// Creo los XmlMarkets
				Collection<XmlMarket> xmlMarkets = new ArrayList<XmlMarket>();
				Collection<XmlMatchParticipant> xmlParticipants = null;
				for (Bettype betType : event.getBettype()) {
					XmlMarket xmlMarket = new XmlMarket();
					xmlMarket.setXmlMatch(xmlMatch);

					// Resuelvo el tipo de apuesta
					XmlBetType xmlBetType = resolveBetType(betType);
					if (xmlBetType != null && xmlBetType.getBetType() != null) {

						if (category.getName().equals("Basketball")) {
							if (!xmlBetType.getBetType().equals(BetTypeBoyleSports.GANADOR)
									&& !xmlBetType.getBetType().equals(BetTypeBoyleSports.MAXIMO_GOLEADOR)) {
								xmlBetType.setXmlBetEvent(new XmlBetEvent(BetEventBoyleSports.PARTIDO_COMPLETO_PRORROGA));
							}
						}
						if (category.getName().equals("IceHockey")) {
							if (xmlBetType.getBetType().equals(BetTypeBoyleSports.GANADOR_PARTIDO)
									|| xmlBetType.getBetType().equals(BetTypeBoyleSports.HANDICAP_ASIATICO)
									|| xmlBetType.getBetType().equals(BetTypeBoyleSports.MAS_MENOS)) {
								xmlBetType.setXmlBetEvent(new XmlBetEvent(BetEventBoyleSports.PARTIDO_COMPLETO_PRORROGA));
							}
						}
						xmlMarket.setXmlBetType(xmlBetType);

						if (xmlParticipants == null
								|| (!xmlBetType.getBetType().equals(BetTypeBoyleSports.GANADOR) && !xmlBetType.getBetType().equals(
										BetTypeBoyleSports.MAXIMO_GOLEADOR))) {
							xmlParticipants = new ArrayList<XmlMatchParticipant>();
						}

						XmlMatchParticipant xmlMatchParticipant;
						XmlMarketBetOdd xmlMarketBetOdd;
						XmlMarketBet xmlMarketBet;
						// Creo las apuestas
						int i = 0;
						for (Bet bet : betType.getBet()) {
							xmlMarketBet = new XmlMarketBet();
							xmlMarketBetOdd = new XmlMarketBetOdd(bet.getPriceDecimal().toString(), null, bet.getPrice());
							xmlMatchParticipant = resolveXmlParticipant(xmlBetType, bet, event, xmlTournament, i);
							xmlMarketBet.setXmlMatchParticipant(xmlMatchParticipant);
							if (!contains(xmlParticipants, xmlMatchParticipant) && !xmlMatchParticipant.getName().equalsIgnoreCase(DRAW)
									&& !xmlMatchParticipant.getName().equalsIgnoreCase(HANDICAP_TIE)) {
								xmlParticipants.add(xmlMatchParticipant);
							}
							if (xmlMatchParticipant.getName().equalsIgnoreCase(DRAW)
									|| xmlMatchParticipant.getName().equalsIgnoreCase(HANDICAP_TIE)) {
								xmlMatchParticipant.setName(null);
							}
							xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
							xmlMarketBet.setXmlAttribute(getAttribute(event, betType, bet, xmlBetType, xmlTournament, xmlMatchParticipant));
							xmlMarket.addXmlBet(xmlMarketBet);
							i++;
						}
						xmlMatch.setXmlMatchParticipants(xmlParticipants);
						if (xmlMarket.getXmlBetType() != null && xmlMarket.getXmlBetType().getBetType() != null) {
							xmlMarkets.add(xmlMarket);
						}
						xmlMatch.setXmlMarkets(xmlMarkets);
					}
				}

				if (xmlMatch.getXmlMarkets() != null && !xmlMatch.getXmlMarkets().isEmpty()) {
					xmlBookmakerEvents.addXmlMatch(xmlMatch);
				}
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(errorMessage, e);
		} catch (Exception e) {
			String errorMessage = new StringBuffer("Error parseando el xml: ").append(JaxbUtils.writeXML(category, Category.class))
					.toString();
			LOG.error(errorMessage, e);
		}
		return xmlBookmakerEvents;
	}

	private XmlMatchParticipant resolveXmlParticipant(XmlBetType xmlBetType, Bet bet, Event event, XmlTournament xmlTournament, int pos) {
		XmlMatchParticipant xmlMatchParticipant;
		if (xmlBetType.getBetType().equals(BetTypeBoyleSports.MAS_MENOS)) {
			xmlMatchParticipant = new XmlMatchParticipant(event.getName().split(" v ")[pos], xmlTournament);
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.GANADOR)
				|| xmlBetType.getBetType().equals(BetTypeBoyleSports.MAXIMO_GOLEADOR)) {
			xmlMatchParticipant = new XmlMatchParticipant(bet.getName(), xmlTournament);
		} else {
			xmlMatchParticipant = new XmlMatchParticipant(bet.getName(), xmlTournament);
			if ((bet.getHadValue() != null && !bet.getHadValue().isEmpty() && bet.getHadValue().equals("HOME"))
					|| isLocal(bet.getName(), event.getName())) {
				xmlMatchParticipant.setHomeParticipant(true);
				xmlMatchParticipant.setAwayParticipant(false);
			} else if ((bet.getHadValue() != null && !bet.getHadValue().isEmpty() && bet.getHadValue().equals("AWAY"))
					|| isVisitor(bet.getName(), event.getName())) {
				xmlMatchParticipant.setHomeParticipant(false);
				xmlMatchParticipant.setAwayParticipant(true);
			} else if ((bet.getHadValue() != null && bet.getHadValue().equals("DRAW")) || (bet.getName().equalsIgnoreCase(DRAW))) {
				xmlMatchParticipant.setHomeParticipant(false);
				xmlMatchParticipant.setAwayParticipant(false);
			}
		}
		return xmlMatchParticipant;
	}

	private boolean contains(Collection<XmlMatchParticipant> xmlParticipants, XmlMatchParticipant xmlMatchParticipant) {
		boolean result = false;

		for (XmlMatchParticipant xmlParticipant : xmlParticipants) {
			if (xmlParticipant.getName().equals(xmlMatchParticipant.getName())) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * Gets the attribute.
	 * 
	 * @param betType
	 *            the bet type
	 * @param bet
	 *            the bet
	 * @return the attribute
	 */
	private IXmlAttribute getAttribute(Event event, Bettype betType, Bet bet, XmlBetType xmlBetType, final XmlTournament tournament,
			final XmlMatchParticipant xmlParticipant) {
		IXmlAttribute xmlAttribute = null;// TODO
		if (xmlBetType.getBetType().equals(BetTypeBoyleSports.HANDICAP_ASIATICO)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta Handicap asiático");
			}
			XmlAsianHandicapAttribute asianHandicap = new XmlAsianHandicapAttribute();
			if (bet.getHadValue().equals("HOME")) {
				asianHandicap.setAsianResult(AsianResult.ONE);
				this.asianHandicapValue = bet.getHandicap();
			} else if (bet.getHadValue().equals("AWAY")) {
				asianHandicap.setAsianResult(AsianResult.TWO);
			}
			asianHandicap.setFirstValue(this.asianHandicapValue);
			xmlAttribute = asianHandicap;
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.MAS_MENOS)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta Más/Menos");
			}
			XmlMoreLessAttribute masOmenos = new XmlMoreLessAttribute();
			String[] splitBet = bet.getName().split(" ");
			if (splitBet[0].equals("Over")) {
				masOmenos.setMasMenos(MasMenos.MAS);
			} else if (splitBet[0].equals("Under")) {
				masOmenos.setMasMenos(MasMenos.MENOS);
			}
			masOmenos.setTotalGoal(Double.valueOf(splitBet[1]));
			xmlAttribute = masOmenos;
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.UNO_X_DOS)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta 1X2");
			}
			Xml1X2Attribute unoXdos = new Xml1X2Attribute();
			if ((bet.getHadValue() != null && bet.getHadValue().equals(HOME)) || isLocal(bet.getName(), event.getName())) {
				unoXdos.setResult(Result.ONE);
			} else if ((bet.getHadValue() != null && bet.getHadValue().equals(AWAY)) || isVisitor(bet.getName(), event.getName())) {
				unoXdos.setResult(Result.TWO);
			} else if ((bet.getHadValue() != null && bet.getHadValue().equalsIgnoreCase(DRAW)) || bet.getName().equalsIgnoreCase(DRAW)) {
				unoXdos.setResult(Result.DRAW);
			}
			xmlAttribute = unoXdos;
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.GANADOR)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta Ganador");
			}
			XmlWinnerAttribute xmlWinnerAttribute = new XmlWinnerAttribute();
			XmlMatchParticipant winner = new XmlMatchParticipant(bet.getName(), tournament);
			xmlWinnerAttribute.setWinner(winner);
			xmlAttribute = xmlWinnerAttribute;
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.GANADOR_PARTIDO)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta Ganador Partido");
			}
			XmlMatchWinnerAttribute xmlMatchWinnerAttribute = new XmlMatchWinnerAttribute();
			if (bet.getHadValue().equals(HOME)) {
				xmlMatchWinnerAttribute.setResult(Result.ONE);
			} else if (bet.getHadValue().equals(AWAY)) {
				xmlMatchWinnerAttribute.setResult(Result.TWO);
			}
			xmlMatchWinnerAttribute.setWinnerName(xmlParticipant);
			xmlAttribute = xmlMatchWinnerAttribute;
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.MAXIMO_GOLEADOR)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta Máximo Goleador");
			}
			XmlMaximumGoalerAttribute xmlMaximumGoalerAttribute = new XmlMaximumGoalerAttribute();
			XmlMatchParticipant goaler = new XmlMatchParticipant(bet.getName(), tournament);
			xmlMaximumGoalerAttribute.setGoaler(goaler);
			xmlAttribute = xmlMaximumGoalerAttribute;
		} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.UNO_X_DOS_HANDICAP)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Resolviendo atributo de apuesta Handicap 1X2");
			}
			Xml1X2HandicapAttribute xml1X2HandicapAttribute = new Xml1X2HandicapAttribute();
			xml1X2HandicapAttribute.setFirstValue(betType.getHandicap());
			if (bet.getHadValue().equals(HOME)) {
				xml1X2HandicapAttribute.setResult(Result.ONE);
			} else if (bet.getHadValue().equals(DRAW)) {
				xml1X2HandicapAttribute.setResult(Result.DRAW);
			} else if (bet.getHadValue().equals(AWAY)) {
				xml1X2HandicapAttribute.setResult(Result.TWO);
			}
			xmlAttribute = xml1X2HandicapAttribute;
		}
		return xmlAttribute;
	}

	private boolean isVisitor(String betName, String matchName) {
		return betName.equals(matchName.split(" v ")[1]);
	}

	private boolean isLocal(String betName, String matchName) {
		return betName.equals(matchName.split(" v ")[0]);
	}

	/**
	 * Resolve bet type.
	 * 
	 * @param betType
	 *            the bet type
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(Bettype betType) {
		XmlBetType xmlBetType = new XmlBetType();

		xmlBetType.setBetType(BetTypeBoyleSports.getTypeByValue(betType.getName()));

		if (xmlBetType != null && xmlBetType.getBetType() != null) {
			if (xmlBetType.getBetType().equals(BetTypeBoyleSports.UNO_X_DOS) && (betType.getBet().size() == 2)) {
				xmlBetType.setBetType(BetTypeBoyleSports.GANADOR_PARTIDO);
			} else if (betType.getName().contains("Match Winner")) {
				xmlBetType.setBetType(BetTypeBoyleSports.GANADOR_PARTIDO);
			} else if (xmlBetType.getBetType().equals(BetTypeBoyleSports.UNO_X_DOS_HANDICAP) && betType.getBet().size() == 2) {
				xmlBetType.setBetType(BetTypeBoyleSports.HANDICAP_ASIATICO);
			}
		} else if (betType.getName().contains("Winner") || betType.getName().contains("winner")) {
			xmlBetType.setBetType(BetTypeBoyleSports.GANADOR);
		} else if (betType.getName().contains("Match Winner")) {
			xmlBetType.setBetType(BetTypeBoyleSports.GANADOR_PARTIDO);
		}
		return xmlBetType;
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
		return CfgBookmaker.CfgBookmakerId.BOYLESPORTS_COM_ID.objectId().toString();
	}

}
