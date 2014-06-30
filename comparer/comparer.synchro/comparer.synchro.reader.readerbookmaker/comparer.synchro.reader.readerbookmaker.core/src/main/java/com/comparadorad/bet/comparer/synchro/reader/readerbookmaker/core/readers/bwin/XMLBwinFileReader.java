/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventBwin;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBwin;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Games;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.League;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Leaguelist;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils.JaxbUtils;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.AbstractXmlFilereader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class XMLPinnacleSportsFileReader.
 */
@Component
public class XMLBwinFileReader extends AbstractXmlFilereader {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XMLBwinFileReader.class);

	private static final String DATE_FORMAT = "dd.MM.yyyy / HH:mm";


	@Override
	public String getBookmakerId() {
		return CfgBookmaker.CfgBookmakerId.BWIN_COM_ID.objectId().toString();
	}

	@Override
	protected XmlBookmakerEvents readXml(InputStream pFile,
			CfgBookmakerConfiguration cfgBookmakerConfiguration,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
					throws XmlReaderException {


		XmlBookmakerEvents result = new XmlBookmakerEvents();
		List<XmlMatch> matchs = new ArrayList<XmlMatch>();


		try {

			matchs = getMatchs(pFile,cfgBookmakerConfiguration);

		} catch (JAXBException e) {
			LOG.error("No se puede provesar el XML, no se reconoce el elemento descargado");
//			throw new XmlReaderException(e.getCause());
		}catch (ParseException e) {
			LOG.error("No se puede provesar el XML, Error al parsear el xml.");
//			throw new XmlReaderException(e.getCause());
		}

		result.setXmlMatchs(matchs);
		return result;
	}

	private List<XmlMatch> getMatchs(InputStream pFile,CfgBookmakerConfiguration cfgBookmakerConfiguration) throws JAXBException, ParseException {

		List<XmlMatch> matchs = new ArrayList<XmlMatch>();
		Leaguelist leaguelist = (Leaguelist) JaxbUtils.readXML(pFile, Leaguelist.class);
		List<XmlMatch> match = null;

		for (League league : leaguelist.getLeague()) {
			for (Event event : league.getEvent()) {
				match = processEvent(event,league,cfgBookmakerConfiguration);
				for (XmlMatch xmlMatch : match) {
					matchs.add(xmlMatch);
				}
			}
		}

		return matchs;
	}

	private List<XmlMatch> processEvent(Event event, League league,CfgBookmakerConfiguration cfgBookmakerConfiguration) throws ParseException {
		List<XmlMatch> result = new ArrayList<XmlMatch>();
		XmlMatch match = new XmlMatch();
		XmlTournament tournament = null;
		XmlMarket market = null;
		LongTerm lt = null;
		XmlTournamentEvent tournamentEvent = null;
		match.setName(event.getName());

		String parseDate = parseDate(event.getEventdate());
		
		//DATE
		match.setStartDate(getStartDate(parseDate, DATE_FORMAT,
				cfgBookmakerConfiguration.getTimeZone()));
		
		
		
		
		// COMPETITION
		tournament = new XmlTournament();
		tournament.setName(league.getName());
		tournament.setXmlSport(new XmlSport(SportsIdBwin.getSportByValue(getSport(event.getEventlink()))));
		match.setXmlTournament(tournament);

		//MARKETS

		for (Games game : event.getGames()) {

			try {
				market = getMarket(game,tournament,event.getName());
				match.addXmlMarket(market);

			} catch (MarketNotFoundException e) {
				LOG.info(e);
			} catch (InvalidNumberParticipantsException e) {
				LOG.error(e);
			} catch (LongTermException e) {
				XmlMatch matchLT = cloneMatch(match);
				matchLT.addXmlMarket(e.getMarket());
				tournamentEvent = new XmlTournamentEvent();
				lt = new LongTerm();
				lt.setLongTerm(true);
				tournamentEvent.setLongTerm(lt);
				matchLT.setXmlTournamentEvent(tournamentEvent);
				addParticipants(matchLT);
				result.add(matchLT);
			}   

		}
		if(match.getXmlMarkets().size()>0){
			tournamentEvent = new XmlTournamentEvent();
			lt = new LongTerm();
			lt.setLongTerm(false);
			tournamentEvent.setLongTerm(lt);
			match.setXmlTournamentEvent(tournamentEvent);
			addParticipants(match);
			result.add(match);
		}


		return result;
	}

	private String parseDate(String eventdate) {
		
		String[] comp = eventdate.split("/");
		String[] time = comp[1].split(":");
		String t = time[0].replace("24", "00");
		
		return new StringBuffer().append(comp[0]).append("/").append(t).append(":").append(time[1]).toString();
	}

	private void addParticipants(XmlMatch matchLT) {
		List<XmlMatchParticipant> participants = new ArrayList<XmlMatchParticipant>();
		XmlMatchParticipant p = null;
		for (XmlMarketBet bet : matchLT.getXmlMarkets().iterator().next()
				.getXmlMarketBets()) {
			if (bet.getXmlMatchParticipant() != null) {
				p = new XmlMatchParticipant(bet.getXmlMatchParticipant()
						.getName(), bet.getXmlMatchParticipant()
						.isHomeParticipant(), bet.getXmlMatchParticipant()
						.isAwayParticipant(), bet.getXmlMatchParticipant()
						.getXmlTournament());
				participants.add(p);
			}
		}
		matchLT.setXmlMatchParticipants(participants);
	}

	private XmlMatch cloneMatch(XmlMatch match) {
		XmlMatch result = new XmlMatch();

		result.setName(match.getName());
		result.setStartDate(match.getStartDate());
		result.setXmlTournament(match.getXmlTournament());

		return result;
	}

	private XmlMarket getMarket(Games game,XmlTournament tournament, String eventName) throws MarketNotFoundException, InvalidNumberParticipantsException, LongTermException {
		XmlMarket result = new XmlMarket();


		MarketType mType = getBetType(game.getName());
		XmlBetType betType = new XmlBetType(mType.getBetType());
		betType.setXmlBetEvent(new XmlBetEvent(mType.getBetTypeEvent()));
		result.setXmlBetType(betType);

		IBetTypeResolver resolver = ResolverFactory.getInstance(mType.getBetType());
		List<XmlMarketBet> bets;
		try {
			bets = resolver.resolveBets(game,tournament,eventName);
			result.setXmlMarketBets(bets);
		} catch (LongTermException e) {
			result.setXmlMarketBets(e.getBets());
			throw new LongTermException(result);
		}
		return result;
	}


	private MarketType getBetType(String name) throws MarketNotFoundException {

		BetTypeBwin betType = (BetTypeBwin) BetTypeBwin.getTypeByValue(name);
		BetEventBwin betTypeEvent = (BetEventBwin) BetEventBwin.getEventByValue(name);

		if(betType!=null && betTypeEvent!=null){
			return new MarketType(betType,betTypeEvent);
		}else{
			throw new MarketNotFoundException(name);
		}
	}

	private String getSport(String eventlink) {
		return eventlink.substring(eventlink.indexOf("zoneId=")+7);
	}

}
