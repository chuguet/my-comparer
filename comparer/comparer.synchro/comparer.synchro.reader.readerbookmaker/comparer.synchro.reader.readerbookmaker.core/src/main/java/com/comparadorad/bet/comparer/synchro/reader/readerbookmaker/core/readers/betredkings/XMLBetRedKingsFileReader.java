/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betredkings;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetRedKings;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetRedKings;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.BettingOffer;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Country;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Match;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Odds;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Participant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Participants;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Sport;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.StartDate;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.Tournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings.TournamentOdds;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.neovisionaries.i18n.CountryCode;

/**
 * The Class XMLBetRedKingsFileReader.
 */
@Component
public class XMLBetRedKingsFileReader extends AbstractXmlFilereader implements MarketType{

	/** The Constant AWAY. */
	private static final String AWAY = "away";

	/** The Constant CADENA_VACIA. */
	private static final String CADENA_VACIA = "";

	/** The Constant COMA. */
	private static final String COMA = ",";

	/** The Constant EMPATE. */
	private static final String EMPATE = "X";
	
	/** The Constant FORMATTER_DATE. */
	private volatile static SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/** The Constant HOME. */
	private static final String HOME = "home";
	
	/** The Constant LOCAL. */
	private static final String LOCAL = "1";
	
	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;
	
	/** The Constant MAS. */
	private static final String MAS = "over";
	
	/** The Constant MENOS. */
	private static final String MENOS = "under";
	
	/** The Constant VISITANTE. */
	private static final String VISITANTE = "2";
	
	/**
	 * Builds the matchs.
	 * 
	 * @param content
	 *            the content
	 * @return the list
	 */
	private List<Match> buildMatchs(List<Object> content) {
		List<Match> result = new ArrayList<Match>();
		for (Object obj : content) {
			if (obj instanceof Match) {
				Match match = (Match) obj;
				result.add(match);
			}
		}
		return result;
	}
	
	/**
	 * Builds the participants.
	 * 
	 * @param content
	 *            the content
	 * @return the participants
	 */
	private Participants buildParticipants(List<Object> content) {
		Participants result = null;
		for (Object obj : content) {
			if (obj instanceof Participants) {
				result = (Participants) obj;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Builds the start date.
	 * 
	 * @param content
	 *            the content
	 * @return the start date
	 */
	private StartDate buildStartDate(List<Object> content) {
		StartDate result = null;
		for (Object obj : content) {
			if (obj instanceof StartDate) {
				result = (StartDate) obj;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Builds the tournament odds.
	 * 
	 * @param content
	 *            the content
	 * @return the tournament odds
	 */
	private TournamentOdds buildTournamentOdds(List<Object> content) {
		TournamentOdds result = null;
		for (Object obj : content) {
			if (obj instanceof TournamentOdds) {
				result = (TournamentOdds) obj;
				break;
			}
		}
		return result;
	}

	/**
	 * Clean principal tag.
	 * 
	 * @param xml
	 *            the xml
	 * @return the string
	 */
	private String cleanPrincipalTag(String xml) {
		int indexHeader = xml.indexOf("?>") + 2;
		int indexBeginSport = xml.indexOf("<Sport");
		int indexEndSport = xml.indexOf("</Sport>") + "</Sport>".length();
		String sport = xml.substring(indexBeginSport, indexEndSport);
		String result = new StringBuffer(xml.substring(0, indexHeader)).append(sport).toString();

		return result;
	}

	/**
	 * Formatter file.
	 *
	 * @param pFile the file
	 * @return the input stream
	 * @throws BetRedKingsReadXmlException the bet red kings read xml exception
	 */
	private InputStream formatterFile(InputStream pFile) throws BetRedKingsReadXmlException {
		try {
			String xml = IOUtils.toString(pFile, "UTF-8");
			String xmlToParse = cleanPrincipalTag(xml);
			return new ByteArrayInputStream(xmlToParse.getBytes("UTF-8"));
		} catch (IOException e) {
			String message = "No se ha podido eliminar los tags innecesarios del xml.";
			LOG.error(Thread.currentThread(), message);
			throw new BetRedKingsReadXmlException(message, e);
		}
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
		return CfgBookmaker.CfgBookmakerId.BETREDKINGS_ID.objectId().toString();
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketGanador(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketGanador(Object market,
			Collection<XmlMatchParticipant> participants){
		XmlMatchParticipant xmlParticipant;
		XmlWinnerAttribute xmlAttribute;
		XmlMarketBetOdd xmlMarketBetOdd;
		XmlMarket xmlMarket = new XmlMarket();
		TournamentOdds tournamentOdds = (TournamentOdds)market;
		XmlMarketBet xmlBet;
		for (Odds odd : tournamentOdds.getBettingOffer().getOdds()) {
			xmlParticipant = resolveParticipantById(participants, odd.getParticipantId());
			xmlMarketBetOdd = new XmlMarketBetOdd(odd.getValue().replace(COMA , CADENA_VACIA));
			xmlBet = new XmlMarketBet(xmlMarketBetOdd);
			xmlAttribute = new XmlWinnerAttribute();
			xmlAttribute.setWinner(xmlParticipant);
			xmlBet.setXmlAttribute(xmlAttribute);
			xmlBet.setXmlMatchParticipant(xmlParticipant);
			xmlMarket.addXmlBet(xmlBet);
		}
		return xmlMarket;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketGanadorPartido(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketGanadorPartido(Object market,
			Collection<XmlMatchParticipant> participants)
			throws XmlReaderException {
		XmlMatchParticipant xmlParticipant;
		XmlMarket xmlMarket = new XmlMarket();
		XmlMatchWinnerAttribute attribute;
		BettingOffer bettingOffer = (BettingOffer) market;
		XmlMarketBet xmlBet;
		for (Odds odd : bettingOffer.getOdds()) {
			xmlBet = new XmlMarketBet();
			attribute = new XmlMatchWinnerAttribute();
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(odd.getValue().replace(COMA , CADENA_VACIA)));
			if(odd.getOutcome().equals(LOCAL)){
				xmlParticipant = getParticipant(participants, true);
				attribute.setWinnerName(xmlParticipant);
				xmlBet.setXmlMatchParticipant(xmlParticipant);
				attribute.setResult(Result.ONE);
			}else if (odd.getOutcome().equals(VISITANTE)){
				xmlParticipant = getParticipant(participants, false);
				attribute.setWinnerName(xmlParticipant);
				xmlBet.setXmlMatchParticipant(xmlParticipant);
				attribute.setResult(Result.TWO);
			}
			xmlBet.setXmlAttribute(attribute);
			xmlMarket.addXmlBet(xmlBet);	
		}
		return xmlMarket;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketHandicapAsiatico(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketHandicapAsiatico(Object market,
			Collection<XmlMatchParticipant> participants)
			throws XmlReaderException {
		XmlMarket xmlMarket = new XmlMarket();
		XmlAsianHandicapAttribute attribute;
		BettingOffer bettingOffer = (BettingOffer) market;
		XmlMarketBet xmlBet;
		for (Odds odd : bettingOffer.getOdds()) {
			xmlBet = new XmlMarketBet();
			attribute = new XmlAsianHandicapAttribute();
			attribute.setFirstValue(resolveHandicap(odd));
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(odd.getValue().replace(COMA , CADENA_VACIA)));
			if(odd.getOutcome().equals(LOCAL)){
				xmlBet.setXmlMatchParticipant(getParticipant(participants, true));
				attribute.setAsianResult(AsianResult.ONE);
			}else if (odd.getOutcome().equals(VISITANTE)){
				xmlBet.setXmlMatchParticipant(getParticipant(participants, false));
				attribute.setAsianResult(AsianResult.TWO);
			}
			xmlBet.setXmlAttribute(attribute);
			xmlMarket.addXmlBet(xmlBet);
		}
		return xmlMarket;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketMasMenos(java.lang.Object)
	 */
	@Override
	public XmlMarket getMarketMasMenos(Object market) throws XmlReaderException {
		XmlMarket xmlMarket = new XmlMarket();
		XmlMoreLessAttribute attribute;
		BettingOffer bettingOffer = (BettingOffer) market;
		XmlMarketBet xmlBet;
		for (Odds odd : bettingOffer.getOdds()) {
			xmlBet = new XmlMarketBet();
			attribute = new XmlMoreLessAttribute();
			attribute.setTotalGoal(Double.valueOf(odd.getScore().toString()));
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(odd.getValue().replace(COMA , CADENA_VACIA)));
			if(odd.getOutcome().equals(MAS)){
				attribute.setMasMenos(MasMenos.MAS);
			}else if (odd.getOutcome().equals(MENOS)){
				attribute.setMasMenos(MasMenos.MENOS);
			}
			xmlBet.setXmlAttribute(attribute);
			xmlMarket.addXmlBet(xmlBet);
		}
		return xmlMarket;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketMaximoGoleador(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketMaximoGoleador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketUnoXDos(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketUnoXDos(Object market,
			Collection<XmlMatchParticipant> participants)
			throws XmlReaderException {
		XmlMarket xmlMarket = new XmlMarket();
		Xml1X2Attribute attribute;
		BettingOffer bettingOffer = (BettingOffer) market;
		XmlMarketBet xmlBet;
		for (Odds odd : bettingOffer.getOdds()) {
			xmlBet = new XmlMarketBet();
			attribute = new Xml1X2Attribute();
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(odd.getValue().replace(COMA , CADENA_VACIA)));
			if(odd.getOutcome().equals(LOCAL)){
				xmlBet.setXmlMatchParticipant(getParticipant(participants, true));
				attribute.setResult(Result.ONE);
			}else if (odd.getOutcome().equals(VISITANTE)){
				xmlBet.setXmlMatchParticipant(getParticipant(participants, false));
				attribute.setResult(Result.TWO);
			}else if (odd.getOutcome().equals(EMPATE)){
				xmlBet.setXmlMatchParticipant(getDrawParticipant());
				attribute.setResult(Result.DRAW);
			}
			xmlBet.setXmlAttribute(attribute);
			xmlMarket.addXmlBet(xmlBet);
		}
		return xmlMarket;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.MarketType#getMarketUnoXDosHandicap(java.lang.Object, java.util.Collection)
	 */
	@Override
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> participants)
			throws XmlReaderException {
		XmlMarket xmlMarket = new XmlMarket();
		Xml1X2HandicapAttribute attribute;
		BettingOffer bettingOffer = (BettingOffer) market;
		XmlMarketBet xmlBet;
		for (Odds odd : bettingOffer.getOdds()) {
			xmlBet = new XmlMarketBet();
			attribute = new Xml1X2HandicapAttribute();
			attribute.setFirstValue(resolveHandicap(odd));
			xmlBet.setXmlMarketBetOdd(new XmlMarketBetOdd(odd.getValue().replace(COMA , CADENA_VACIA)));
			if(odd.getOutcome().equals(LOCAL)){
				xmlBet.setXmlMatchParticipant(getParticipant(participants, true));
				attribute.setResult(Result.ONE);
			}else if (odd.getOutcome().equals(VISITANTE)){
				xmlBet.setXmlMatchParticipant(getParticipant(participants, false));
				attribute.setResult(Result.TWO);
			}else if (odd.getOutcome().equals(EMPATE)){
				xmlBet.setXmlMatchParticipant(getDrawParticipant());
				attribute.setResult(Result.DRAW);
			}
			xmlBet.setXmlAttribute(attribute);
			xmlMarket.addXmlBet(xmlBet);
		}
		return xmlMarket;
	}

	/**
	 * Gets the name match.
	 *
	 * @param match the match
	 * @param xmlTournament the xml tournament
	 * @return the name match
	 */
	private String getNameMatch(Match match, XmlTournament xmlTournament) {
		String result;
		if (match.getParticipants().getParticipant().size() == 2) {
			if (match.getParticipants().getParticipant().get(0).getType().equals("home")) {
				result = new StringBuffer().append(match.getParticipants().getParticipant().get(0).getName())
						.append("-").append(match.getParticipants().getParticipant().get(1).getName()).toString();
				LOG.debug(Thread.currentThread(), new StringBuffer("Evento:").append(match.getParticipants().getParticipant().get(0).getName())
						.append("-").append(match.getParticipants().getParticipant().get(1).getName()).toString());						
			} else {
				result = new StringBuffer().append(match.getParticipants().getParticipant().get(1).getName())
						.append("-").append(match.getParticipants().getParticipant().get(0).getName()).toString();
				LOG.debug(Thread.currentThread(), new StringBuffer("Evento:").append(match.getParticipants().getParticipant().get(1).getName())
						.append("-").append(match.getParticipants().getParticipant().get(0).getName()).toString());						
			}
			
		} else {
			result = xmlTournament.getName();
			LOG.debug(Thread.currentThread(), new StringBuffer("Evento:").append(xmlTournament.getName()).toString());						
		}
		return result;
	}

	/**
	 * Gets the object to parse.
	 *
	 * @param pFile the file
	 * @return the object to parse
	 * @throws JAXBException the jAXB exception
	 * @throws BetRedKingsReadXmlException the bet red kings read xml exception
	 */
	private Sport getObjectToParse(InputStream pFile) throws JAXBException, BetRedKingsReadXmlException {
		InputStream formattedFile = formatterFile(pFile);
		LOG.info(Thread.currentThread(), "Se va a leer el xml con Jaxb");			
		Sport sport = (Sport) JaxbUtils.readXML(formattedFile, Sport.class);
		LOG.info(Thread.currentThread(), "Se ha leido el xml con Jaxb");
		return sport;
	}

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
	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile, CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) throws XmlReaderException {
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		Sport sport = null;
		LOG.info(Thread.currentThread(), "Se comienza el reader");
		try {
			Collection<XmlMatch> xmlMatchs = new ArrayList<XmlMatch>();
			Collection<XmlMatch> result = new ArrayList<XmlMatch>();
			XmlMatch xmlMatch;
			
			//Recuperamos el objeto a tratar para generar los matchs
			sport = getObjectToParse(pFile);

			//Resolvemos el deporte
			XmlSport xmlSport = resolveSport(sport);
			for (Country country : sport.getCountry()) {
				//Resolvemos el pais
				XmlRegion xmlRegion = resolveRegion(country);
				for (Tournament tournament : country.getTournament()) {
					//Resolvemos el tournament
					XmlTournament xmlTournament = resolveTournament(xmlSport, xmlRegion, tournament);
					
					//BetRedKings no resuelve el tipado del objeto, hay que castear
					List<Match> matchs = buildMatchs(tournament.getContent());
					Participants participants = buildParticipants(tournament.getContent());
					StartDate startDate = buildStartDate(tournament.getContent());
					TournamentOdds tournamentOdds = buildTournamentOdds(tournament.getContent());

					//Resolvemos el/los match/s
					if (!matchs.isEmpty()) {
						xmlMatchs = resolveShortTermMatchs(matchs, xmlTournament, cfgBookmakerConfiguration.getTimeZone());
					}
					if (tournamentOdds != null) {
						xmlMatch = resolveLongTermMatch(participants, startDate,  tournamentOdds, xmlTournament, cfgBookmakerConfiguration.getTimeZone());
						xmlMatchs.add(xmlMatch);
					}
					result.addAll(xmlMatchs);
				}
			}
			xmlBookmakerEvents.setXmlMatchs(result);

		} catch (JAXBException e) {
			String errorMessage = "XML mal construido o no reconocido.";
			LOG.error(Thread.currentThread(), errorMessage, e);
		} catch (Exception e) {
			String errorMessage = "Error parseando el xml: " + JaxbUtils.writeXML(sport, Sport.class);
			LOG.error(Thread.currentThread(), errorMessage, e);
		}

		return xmlBookmakerEvents;
	}

	/**
	 * Resolve bet type.
	 * 
	 * @param type
	 *            the type
	 * @return the xml bet type
	 */
	private XmlBetType resolveBetType(String type) {
		XmlBetType result = new XmlBetType(BetTypeBetRedKings.getTypeByValue(type));
		return result;
	}

	/**
	 * Resolve bet type event.
	 * 
	 * @param scope
	 *            the scope
	 * @return the xml bet event
	 */
	private XmlBetEvent resolveBetTypeEvent(String scope) {
		XmlBetEvent result = new XmlBetEvent(BetEventBetRedKings.getEventByValue(scope));
		return result;
	}

	/**
	 * Resolve date.
	 *
	 * @param startDate the start date
	 * @param timeZone the time zone
	 * @return the xml date
	 * @throws ParseException the parse exception
	 */
	private synchronized XmlDate resolveDate (StartDate startDate, String timeZone) throws ParseException {
		return new XmlDate(FORMATTER_DATE.parse(startDate.getValue()), timeZone);
	}

	/**
	 * Resolve handicap.
	 *
	 * @param odd the odd
	 * @return the double
	 */
	private Double resolveHandicap(Odds odd) {
		Double result =null;
		if(!odd.getOutcome().equals("2")){
			result = Double.valueOf(odd.getHandicap().toString());
		}else {
			result = -1*Double.valueOf(odd.getHandicap().toString());
		}
		return result;
	}

	/**
	 * Resolve long term match.
	 *
	 * @param participants the participants
	 * @param startDate the start date
	 * @param tournamentOdds the tournament odds
	 * @param xmlTournament the xml tournament
	 * @param timeZone the time zone
	 * @return the xml match
	 * @throws ParseException the parse exception
	 * @throws XmlReaderException the xml reader exception
	 */
	private XmlMatch resolveLongTermMatch(Participants participants, StartDate startDate, TournamentOdds tournamentOdds, XmlTournament xmlTournament, String timeZone) throws ParseException, XmlReaderException{
		XmlDate xmlDate = resolveDate(startDate, timeZone);
		XmlMatch xmlMatch = new XmlMatch(xmlTournament.getName(), xmlTournament, xmlDate);
		xmlMatch.setXmlMatchParticipants(resolveParticipants(participants, xmlTournament));
		XmlMarket xmlMarket = null;
		
		XmlBetType xmlBetType = resolveBetType(tournamentOdds.getBettingOffer().getType());
		XmlBetEvent xmlBetEvent = resolveBetTypeEvent(tournamentOdds.getBettingOffer().getScope());
		xmlBetType.setXmlBetEvent(xmlBetEvent);
		if(xmlBetType.getBetType().equals(BetTypeBetRedKings.GANADOR)){
			xmlMarket = getMarketGanador(tournamentOdds, xmlMatch.getXmlMatchParticipants());
			xmlMarket.setXmlBetType(xmlBetType);
		}
		if(xmlMarket!=null){
			xmlMatch.addXmlMarket(xmlMarket);
		}
		return xmlMatch;
	}

	/**
	 * Resolve participant by id.
	 *
	 * @param participants the participants
	 * @param participantId the participant id
	 * @return the xml match participant
	 */
	private XmlMatchParticipant resolveParticipantById(Collection<XmlMatchParticipant> participants, Integer participantId) {
		XmlMatchParticipant result = null;
		for (XmlMatchParticipant participant : participants) {
			if (participant.getBmInternalId().getValue().equals(participantId.toString())) {
				result = participant;
			}
		}
		return result;
	}

	/**
	 * Resolve participants.
	 * 
	 * @param participants
	 *            the participants
	 * @param xmlTournament
	 *            the xml tournament
	 * @return the collection
	 */
	private Collection<XmlMatchParticipant> resolveParticipants(Participants participants, XmlTournament xmlTournament) {
		Collection<XmlMatchParticipant> result = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant xmlParticipant;
		for (Participant participant : participants.getParticipant()) {
			xmlParticipant = new XmlMatchParticipant(participant.getName(), xmlTournament);
			xmlParticipant.setBmInternalId(new BmInternalId(String.valueOf(participant.getId())));
			if (participant.getType() != null && participant.getType().equals(HOME)) {
				xmlParticipant.setAwayParticipant(false);
				xmlParticipant.setHomeParticipant(true);
			} else if (participant.getType() != null && participant.getType().equals(AWAY)) {
				xmlParticipant.setAwayParticipant(true);
				xmlParticipant.setHomeParticipant(false);
			}
			result.add(xmlParticipant);
		}
		return result;
	}

	/**
	 * Resolve region.
	 *
	 * @param country the country
	 * @return the xml region
	 */
	private XmlRegion resolveRegion(Country country) {
		CountryCode cc = CountryCode.getByCode(country.getName());
		XmlRegion xmlRegion = null;
		if (cc != null) {
			xmlRegion = new XmlRegion(cc.getName());
			LOG.debug(Thread.currentThread(), new StringBuffer("Region:").append(xmlRegion.getName()).toString());
		}
		return xmlRegion;
	}

	/**
	 * Resolve short term matchs.
	 *
	 * @param matchs the matchs
	 * @param xmlTournament the xml tournament
	 * @param timeZone the time zone
	 * @return the collection
	 * @throws ParseException the parse exception
	 * @throws XmlReaderException the xml reader exception
	 */
	private Collection<XmlMatch> resolveShortTermMatchs(List<Match> matchs, XmlTournament xmlTournament, String timeZone) throws ParseException, XmlReaderException {
		Collection<XmlMatch> xmlMatchs = new ArrayList<XmlMatch>();
		Collection<XmlMatchParticipant> participants;
		XmlDate xmlDate;
		XmlMatch xmlMatch;
		XmlMarket xmlMarket;
		XmlBetType xmlBetType;
		XmlBetEvent xmlBetTypeEvent;
		// MATCHS DE CUALQUIER OTRO TIPO
		for (Match match : matchs) {
			xmlDate = resolveDate(match.getStartDate(), timeZone);
			participants = resolveParticipants(match.getParticipants(), xmlTournament);
			xmlMatch = new XmlMatch(getNameMatch(match, xmlTournament), xmlTournament, xmlDate);
			xmlMatch.setXmlMatchParticipants(participants);
			
			for (BettingOffer bettingOffer : match.getMatchOdds().getBettingOffer()) {
				xmlMarket = null;
				xmlBetType = resolveBetType(bettingOffer.getType());
				xmlBetTypeEvent = resolveBetTypeEvent(bettingOffer.getScope());
				xmlBetType.setXmlBetEvent(xmlBetTypeEvent);
				if(xmlBetType !=null && xmlBetType.getBetType() != null){
					if(xmlBetType.getBetType().equals(BetTypeBetRedKings.UNO_X_DOS)){
						xmlMarket = getMarketUnoXDos(bettingOffer, participants);
					} else if(xmlBetType.getBetType().equals(BetTypeBetRedKings.GANADOR_PARTIDO)){
						xmlMarket = getMarketGanadorPartido(bettingOffer, participants);
					} else if(xmlBetType.getBetType().equals(BetTypeBetRedKings.UNO_X_DOS_HANDICAP)){
						xmlMarket = getMarketUnoXDosHandicap(bettingOffer, participants);
					} else if(xmlBetType.getBetType().equals(BetTypeBetRedKings.MAS_MENOS)){
						xmlMarket = getMarketMasMenos(bettingOffer);
					} else if(xmlBetType.getBetType().equals(BetTypeBetRedKings.HANDICAP_ASIATICO)){
						xmlMarket = getMarketHandicapAsiatico(bettingOffer, participants);
					}
					xmlMarket.setXmlBetType(xmlBetType);
				}
				if (xmlMarket != null && xmlMarket.getXmlBetType() != null && xmlMarket.getXmlBetType().getBetType() != null) {
					xmlMatch.addXmlMarket(xmlMarket);
				}
			}
			if (!xmlMatch.getXmlMarkets().isEmpty()) {
				xmlMatchs.add(xmlMatch);
			}
		}
		return xmlMatchs;
	}

	/**
	 * Resolve sport.
	 *
	 * @param sport the sport
	 * @return the xml sport
	 */
	private XmlSport resolveSport(Sport sport) {
		XmlSport xmlSport = new XmlSport(sport.getName());
		LOG.debug(Thread.currentThread(), new StringBuffer("Deporte:").append(xmlSport.getName()).toString());
		return xmlSport;
	}

	/**
	 * Resolve tournament.
	 *
	 * @param xmlSport the xml sport
	 * @param xmlRegion the xml region
	 * @param tournament the tournament
	 * @return the xml tournament
	 */
	private XmlTournament resolveTournament(XmlSport xmlSport,
			XmlRegion xmlRegion, Tournament tournament) {
		XmlTournament xmlTournament;
		if (xmlRegion != null) {
			xmlTournament = new XmlTournament(new StringBuffer().append(xmlRegion.getName()).append(" ")
					.append(tournament.getName()).toString());
			} else {
			xmlTournament = new XmlTournament(tournament.getName());
		}
		LOG.debug(Thread.currentThread(), new StringBuffer("Torneo:").append(xmlTournament.getName()).toString());
		
		xmlTournament.setXmlSport(xmlSport);
		xmlTournament.setRegion(xmlRegion);
		return xmlTournament;
	}

}
