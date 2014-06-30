package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline.BestlinesportsLineFeed;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline.Participant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline.Period;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline.Spread;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline.Total;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.commons.betOdds.CuotaConverterUtil;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

public abstract class AbstractBetonlineDecorator extends AbstractXmlFilereader implements MarketType {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

	/** The Constant HOME. */
	private static final String HOME = "Home";

	@Autowired
	private ComparerWrapperLog LOG;

	/** The Constant NO_ADDITIONAL_TOURNAMENT_NAME. */
	private static final String NO_ADDITIONAL_TOURNAMENT_NAME = "null";

	/** The Constant VISITING. */
	private static final String VISITING = "Visiting";

	/** The time zone. */
	private String timeZone;

	/**
	 * Event has bet type ganador partido.
	 * 
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	private boolean eventHasBetTypeGanadorPartido(Event event) {
		List<Participant> participants = event.getParticipant();
		return !participants.get(0).getOdds().getMoneyline().isEmpty();
	}

	/**
	 * Event has bet type handicap asiatico.
	 * 
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	private boolean eventHasBetTypeHandicapAsiatico(Event event) {
		return !event.getPeriod().getSpread().getSpreadAdjustHome().isEmpty();
	}

	/**
	 * Event has bet type mas menos.
	 * 
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	private boolean eventHasBetTypeMasMenos(Event event) {
		return !event.getPeriod().getTotal().getOverAdjust().isEmpty();
	}

	/**
	 * Event has bet type uno x dos.
	 * 
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	private boolean eventHasBetTypeUnoXDos(Event event) {
		return !event.getDrawmoneyline().isEmpty() && !event.getDrawmoneyline().equalsIgnoreCase("0");
	}

	/**
	 * Gets the bet type event.
	 * 
	 * @param event
	 *            the event
	 * @return the bet type event
	 */
	private XmlBetEvent getBetTypeEvent(Event event, BetTypeBetOnline betType) {
		XmlSport sport = getSport(event);
		XmlBetEvent xmlBetEvent = new XmlBetEvent();
		Period period = event.getPeriod();
		xmlBetEvent.setBetEvent(BetEventBetOnline.getEventByValue(period.getPeriodDescription()));

		// añadimos el tratamiento especial segun el tipo de deporte
		if (betType.equals(BetTypeBetOnline.MAS_MENOS) || betType.equals(BetTypeBetOnline.GANADOR_PARTIDO)
				|| betType.equals(BetTypeBetOnline.HANDICAP_ASIATICO)) {
			if (BetOnlineSportName.isBasketball(sport.getName()) || BetOnlineSportName.isIceHockey(sport.getName())
					|| BetOnlineSportName.isAmericanFootball(sport.getName()) || BetOnlineSportName.isBaseball(sport.getName())) {

				if (xmlBetEvent.getBetEvent() == null || xmlBetEvent.getBetEvent() == (BetEventBetOnline.PARTIDO_COMPLETO)) {

					xmlBetEvent.setBetEvent(BetEventBetOnline.PARTIDO_COMPLETO_PRORROGA);
				}
			}
		}
		return xmlBetEvent;
	}

	/**
	 * Gets the market ganador partido.
	 * 
	 * @param event
	 *            the event
	 * @param xmlParticipants
	 *            the xml participants
	 * @param xmlBetEvent
	 *            the xml bet event
	 * @return the market ganador partido
	 */
	public XmlMarket getMarketGanadorPartido(final Object objEvent, final Collection<XmlMatchParticipant> xmlParticipants)
			throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "Se procesa market Ganador de Partido");
		Event event = (Event) objEvent;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetOnline.GANADOR_PARTIDO);
		xmlBetType.setXmlBetEvent(getBetTypeEvent(event, BetTypeBetOnline.GANADOR_PARTIDO));
		xmlMarket.setXmlBetType(xmlBetType);
		for (Participant participant : event.getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(participant.getOdds()
					.getMoneyline())));
			XmlMatchWinnerAttribute xmlAttribute = new XmlMatchWinnerAttribute();
			// Home
			if (participant.getVisitingHomeDraw().equalsIgnoreCase(HOME)) {
				xmlAttribute.setResult(Result.ONE);
				xmlAttribute.setWinnerName(getParticipant(xmlParticipants, true));
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlParticipants, true));
			}
			// Away
			else if (participant.getVisitingHomeDraw().equalsIgnoreCase(VISITING)) {
				xmlAttribute.setResult(Result.TWO);
				xmlAttribute.setWinnerName(getParticipant(xmlParticipants, false));
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlParticipants, false));
			}
			xmlMarket.addXmlBet(xmlMarketBet);
			xmlMarketBet.setXmlAttribute(xmlAttribute);
		}
		return xmlMarket;
	}

	/**
	 * Gets the market handicap asiatico.
	 * 
	 * @param event
	 *            the event
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @param xmlBetEvent
	 *            the xml bet event
	 * @return the market handicap asiatico
	 */
	public XmlMarket getMarketHandicapAsiatico(Object objEvent, Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "Se procesa market Handicap Asiatico");
		Event event = (Event) objEvent;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetOnline.HANDICAP_ASIATICO);
		xmlBetType.setXmlBetEvent(getBetTypeEvent(event, BetTypeBetOnline.HANDICAP_ASIATICO));
		xmlMarket.setXmlBetType(xmlBetType);

		Spread spread = event.getPeriod().getSpread();

		// Home
		XmlMarketBet xmlMarketBetHome = new XmlMarketBet();
		XmlAsianHandicapAttribute xmlAttributeHome = new XmlAsianHandicapAttribute();
		xmlAttributeHome.setAsianResult(AsianResult.ONE);
		xmlAttributeHome.setFirstValue(Double.parseDouble(spread.getSpreadHome()));
		xmlMarketBetHome.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(spread.getSpreadAdjustHome())));
		xmlMarketBetHome.setXmlAttribute(xmlAttributeHome);
		xmlMarketBetHome.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, true));
		xmlMarket.addXmlBet(xmlMarketBetHome);

		// Away
		XmlMarketBet xmlMarketBetAway = new XmlMarketBet();
		XmlAsianHandicapAttribute xmlAttributeAway = new XmlAsianHandicapAttribute();
		xmlAttributeAway.setAsianResult(AsianResult.TWO);
		xmlAttributeAway.setFirstValue(Double.parseDouble(spread.getSpreadHome()));
		xmlMarketBetAway
				.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(spread.getSpreadAdjustVisiting())));
		xmlMarketBetAway.setXmlAttribute(xmlAttributeAway);
		xmlMarketBetAway.setXmlMatchParticipant(getParticipant(xmlMatchParticipants, false));
		xmlMarket.addXmlBet(xmlMarketBetAway);

		return xmlMarket;
	}

	/**
	 * Gets the market mas menos.
	 * 
	 * @param event
	 *            the event
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @param xmlBetEvent
	 *            the xml bet event
	 * @return the market mas menos
	 */
	public XmlMarket getMarketMasMenos(final Object objEvent) throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "Se procesa market MasMenos");
		Event event = (Event) objEvent;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetOnline.MAS_MENOS);
		xmlBetType.setXmlBetEvent(getBetTypeEvent(event, BetTypeBetOnline.MAS_MENOS));
		xmlMarket.setXmlBetType(xmlBetType);

		Total total = event.getPeriod().getTotal();

		// Mas
		XmlMarketBet xmlMarketBetMas = new XmlMarketBet();
		xmlMarketBetMas.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(total.getOverAdjust())));
		XmlMoreLessAttribute xmlAttribute = new XmlMoreLessAttribute();
		xmlAttribute.setMasMenos(MasMenos.MAS);
		xmlAttribute.setTotalGoal(Double.valueOf(total.getTotalPoints().toString()));
		xmlMarketBetMas.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetMas);

		// Menos
		XmlMarketBet xmlMarketBetMenos = new XmlMarketBet();
		xmlMarketBetMenos.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(total.getUnderAdjust())));
		xmlAttribute = new XmlMoreLessAttribute();
		xmlAttribute.setMasMenos(MasMenos.MENOS);
		xmlAttribute.setTotalGoal(Double.valueOf(total.getTotalPoints().toString()));
		xmlMarketBetMenos.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketBetMenos);

		return xmlMarket;
	}

	/**
	 * Gets the market uno x dos.
	 * 
	 * @param event
	 *            the event
	 * @param xmlParticipants
	 *            the xml participants
	 * @param drawOdd
	 *            the draw odd
	 * @param xmlBetEvent
	 *            the xml bet event
	 * @return the market uno x dos
	 */
	public XmlMarket getMarketUnoXDos(Object objEvent, Collection<XmlMatchParticipant> xmlParticipants) throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "Se procesa market 1x2");
		Event event = (Event) objEvent;
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetOnline.UNO_X_DOS);
		xmlBetType.setXmlBetEvent(getBetTypeEvent(event, BetTypeBetOnline.UNO_X_DOS));
		xmlMarket.setXmlBetType(xmlBetType);

		for (Participant participant : event.getParticipant()) {
			XmlMarketBet xmlMarketBet = new XmlMarketBet();
			xmlMarketBet.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(participant.getOdds()
					.getMoneyline())));
			Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
			// Home
			if (participant.getVisitingHomeDraw().equalsIgnoreCase(HOME)) {
				xmlAttribute.setResult(Result.ONE);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlParticipants, true));
			}
			// Away
			else if (participant.getVisitingHomeDraw().equalsIgnoreCase(VISITING)) {
				xmlAttribute.setResult(Result.TWO);
				xmlMarketBet.setXmlMatchParticipant(getParticipant(xmlParticipants, false));
			}
			xmlMarketBet.setXmlAttribute(xmlAttribute);
			xmlMarket.addXmlBet(xmlMarketBet);
		}
		// Draw
		XmlMarketBet xmlMarketDraw = new XmlMarketBet();
		xmlMarketDraw.setXmlMarketBetOdd(new XmlMarketBetOdd(CuotaConverterUtil.americanToDecimalOdds(event.getDrawmoneyline())));
		Xml1X2Attribute xmlAttribute = new Xml1X2Attribute();
		xmlAttribute.setResult(Result.DRAW);
		xmlMarketDraw.setXmlAttribute(xmlAttribute);
		xmlMarket.addXmlBet(xmlMarketDraw);
		return xmlMarket;
	}

	/**
	 * Gets the participants.
	 * 
	 * @param event
	 *            the event
	 * @param xmlTournament
	 * @return the participants
	 */
	private Collection<XmlMatchParticipant> getParticipants(Event event, XmlTournament xmlTournament) {
		Collection<XmlMatchParticipant> xmlParticipants = new HashSet<XmlMatchParticipant>();
		List<Participant> participants = event.getParticipant();
		for (Participant participant : participants) {
			XmlMatchParticipant xmlParticipant = new XmlMatchParticipant(participant.getParticipantName(), xmlTournament);
			LOG.debug(Thread.currentThread(), "Se procesa participante: " + participant.getParticipantName());
			if (participant.getVisitingHomeDraw().equalsIgnoreCase(HOME)) {
				xmlParticipant.setAwayParticipant(false);
				xmlParticipant.setHomeParticipant(true);
			} else if (participant.getVisitingHomeDraw().equalsIgnoreCase(VISITING)) {
				xmlParticipant.setAwayParticipant(true);
				xmlParticipant.setHomeParticipant(false);
			}
			xmlParticipants.add(xmlParticipant);
		}
		return xmlParticipants;
	}

	/**
	 * Gets the sport.
	 * 
	 * @param event
	 *            the event
	 * @return the sport
	 */
	private XmlSport getSport(Event event) {
		XmlSport xmlSport = new XmlSport();
		String sportName = event.getSporttype();
		BetOnlineSportName sportNameLookUp = BetOnlineSportName.getSportNameByValue(sportName);
		if (sportNameLookUp != null) {
			sportName = sportNameLookUp.getSportName();
		}
		xmlSport.setName(sportName);
		LOG.debug(Thread.currentThread(), "Se procesa el deporte: " + sportName);
		return xmlSport;
	}

	/**
	 * Gets the tournament.
	 * 
	 * @param event
	 *            the event
	 * @param sportName
	 *            the sport name
	 * @return the tournament
	 */
	private XmlTournament getTournament(Event event, String sportName) {
		XmlTournament xmlTournament = new XmlTournament();
		// Muchas veces el nombre de la competicion viene con el nombre del
		// deporte (pej: <league>WTA Tennis</league> o <league>NCAA
		// Football</league>. Quitamos el deporte.
		String tournamentName = event.getLeague();
		tournamentName = tournamentName.replace(sportName, "").trim();
		// A veces el nodo <scheduletext> viene con información adicional de la
		// competicion (pej: <scheduletext>French Open - QF</scheduletext>).
		// Lo concatenamos.
		String additionalTournamentName = event.getScheduletext();
		if (!additionalTournamentName.equalsIgnoreCase(NO_ADDITIONAL_TOURNAMENT_NAME)) {
			tournamentName = new StringBuffer().append(tournamentName).append(" - ").append(additionalTournamentName).toString();
		}
		xmlTournament.setName(tournamentName);
		LOG.debug(Thread.currentThread(), "Se procesa competicion: " + tournamentName);
		return xmlTournament;
	}

	/**
	 * Read xml.
	 * 
	 * @param pFile
	 *            the file
	 * @param cfgBookmakerConfiguration
	 *            the cfg bookmaker configuration
	 * @param pBeanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bookmaker events
	 * @throws XmlReaderException
	 *             the xml reader exception {@inheritDoc}
	 */
	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile, CfgBookmakerConfiguration cfgBookmakerConfiguration,
			final BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		LOG.debug(Thread.currentThread(), "Inicio reader BetOnline");
		timeZone = cfgBookmakerConfiguration.getTimeZone();
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		BestlinesportsLineFeed bestlinesportsLineFeed = null;
		try {
			bestlinesportsLineFeed = (BestlinesportsLineFeed) JaxbUtils.readXML(pFile, BestlinesportsLineFeed.class);

			List<Event> events = bestlinesportsLineFeed.getEvent();
			for (Event event : events) {
				XmlMatch xmlMatch = new XmlMatch();

				// Fecha
				xmlMatch.setStartDate(getStartDate(event.getEventDatetimeGMT(), DATE_FORMAT, timeZone));

				// Deporte
				XmlSport xmlSport = getSport(event);

				// Competicion
				XmlTournament xmlTournament = getTournament(event, event.getSporttype());
				xmlTournament.setXmlSport(xmlSport);
				xmlMatch.setXmlTournament(xmlTournament);

				xmlMatch.setName(xmlTournament.getName());

				// Participantes
				Collection<XmlMatchParticipant> xmlParticipants = getParticipants(event, xmlTournament);
				xmlMatch.setXmlMatchParticipants(xmlParticipants);

				boolean filtroApuestaGanadorEliminatoria = false;
				for (XmlMatchParticipant xmlMatchParticipant : xmlParticipants) {
					if (xmlMatchParticipant.getName().contains("advance")) {
						filtroApuestaGanadorEliminatoria = true;
					}
				}

				if (!filtroApuestaGanadorEliminatoria) {
					// Market con tipo de apuesta 1X2
					if (eventHasBetTypeUnoXDos(event)) {
						XmlMarket xmlMarketUnoXDos = getMarketUnoXDos(event, xmlMatch.getXmlMatchParticipants());
						xmlMatch.addXmlMarket(xmlMarketUnoXDos);
					} else if (eventHasBetTypeGanadorPartido(event)) {
						// Market con tipo de apuesta Ganador Partido
						XmlMarket xmlMarketGanadorPartido = getMarketGanadorPartido(event, xmlMatch.getXmlMatchParticipants());
						xmlMatch.addXmlMarket(xmlMarketGanadorPartido);
					}

					// Market con tipo de apuesta Handicap Asiatico
					if (eventHasBetTypeHandicapAsiatico(event)) {
						XmlMarket xmlMarketHandicapAsiatico = getMarketHandicapAsiatico(event, xmlMatch.getXmlMatchParticipants());
						xmlMatch.addXmlMarket(xmlMarketHandicapAsiatico);
					}

					// Market con tipo de apuesta Mas/Menos
					if (eventHasBetTypeMasMenos(event)) {
						XmlMarket xmlMarketMasMenos = getMarketMasMenos(event);
						xmlMatch.addXmlMarket(xmlMarketMasMenos);
					}
					xmlBookmakerEvents.addXmlMatch(xmlMatch);
				}
			}
		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(Thread.currentThread(), errorMessage, e);
		} catch (ParseException e) {
			String errorMessage = new StringBuffer().append("Error al parsear una fecha en el xml: \n")
					.append(JaxbUtils.writeXML(bestlinesportsLineFeed, BestlinesportsLineFeed.class)).toString();
			LOG.error(Thread.currentThread(), errorMessage, e);
		}
		LOG.debug(
				Thread.currentThread(),
				new StringBuffer().append("Se finaliza reader BetOnline. Numero de xmlMatchs: ")
						.append(xmlBookmakerEvents.getXmlMatchs().size()).toString());
		if (xmlBookmakerEvents.getXmlMatchs() != null) {
			LOG.debug(Thread.currentThread(), "Numero de xmlMatchs procesados: " + xmlBookmakerEvents.getXmlMatchs().size());
		}
		return xmlBookmakerEvents;
	}

	public XmlMarket getMarketGanador(Object pMarket, Collection<XmlMatchParticipant> pXmlMatchParticipants) throws XmlReaderException {
		// De momento no se ha visto ninguna apuesta de tipo Ganador en el
		// xml de pinnacle
		return null;
	}

	public XmlMarket getMarketUnoXDosHandicap(Object pMarket, Collection<XmlMatchParticipant> pXmlMatchParticipants)
			throws XmlReaderException {
		// De momento no se ha visto ninguna apuesta de tipo 1X2 Handicap en el
		// xml de pinnacle
		return null;
	}

	public XmlMarket getMarketMaximoGoleador(Object pMarket, Collection<XmlMatchParticipant> pXmlMatchParticipants)
			throws XmlReaderException {
		// De momento no se ha visto ninguna apuesta de tipo Maximo Goleador en
		// el
		// xml de pinnacle
		return null;
	}

}
