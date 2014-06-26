/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.AbstractCfgBookmakerXmlReaderData;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;

/**
 * The Class XmlBetFileReaderDataResolver.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class XmlBetFileReaderDataResolver {

	/** The tmp market. */
	private XmlMarket tmpMarket;

	/** The tmp xml match. */
	private XmlMatch tmpXmlMatch;

	/** The tmp xml match participant. */
	private List<XmlMatchParticipant> tmpXmlMatchParticipants = new ArrayList<XmlMatchParticipant>();

	/** The tmp xml region type. */
	private XmlRegion tmpXmlRegion;

	/** The tmp xml sport type. */
	private XmlSport tmpXmlSportType;

	/** The tmp xml tournament. */
	private XmlTournament tmpXmlTournament;

	/** The tmp xml tournament. */
	private XmlTournamentEvent tmpXmlTournamentEvent;

	/** The xml bookmaker events. */
	private XmlBookmakerEvents xmlBookmakerEvents;

	/**
	 * Gets the xml bookmaker events.
	 * 
	 * @return the xml bookmaker events
	 */
	public XmlBookmakerEvents getXmlBookmakerEvents() {
		return xmlBookmakerEvents;
	}

	/**
	 * Reset fields.
	 * 
	 * @param abstractCfgBookmakerXmlReaderData
	 *            the abstract cfg bookmaker xml reader data
	 */
	private void resetFields(
			final AbstractCfgBookmakerXmlReaderData abstractCfgBookmakerXmlReaderData,
			final XmlBetFileReaderVariables pReaderVariables) {
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetMarket()) {
			tmpMarket = null;
		}
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetMatch()) {
			tmpXmlMatch = null;
			pReaderVariables.clearMatchVariables();
		}
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetParticipant()) {
			tmpXmlMatchParticipants.clear();
		}
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetRegion()) {
			tmpXmlRegion = null;
		}
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetSport()) {
			tmpXmlSportType = null;
		}
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetTournament()) {
			tmpXmlTournament = null;
		}
		if (abstractCfgBookmakerXmlReaderData.getResetDataInResolver()
				.isResetTournament()) {
			tmpXmlTournamentEvent = null;
		}

	}

	/**
	 * Resolve data.
	 * 
	 * @param abstractXmlData
	 *            the abstract xml data
	 * @param abstractCfgBookmakerXmlReaderData
	 *            the abstract cfg bookmaker xml reader data
	 */
	public void resolveData(
			final AbstractXmlData abstractXmlData,
			final AbstractCfgBookmakerXmlReaderData abstractCfgBookmakerXmlReaderData,
			final XmlBetFileReaderVariables pReaderVariables) {
		resetFields(abstractCfgBookmakerXmlReaderData, pReaderVariables);

		if (abstractXmlData instanceof XmlBookmakerEvents) {
			xmlBookmakerEvents = (XmlBookmakerEvents) abstractXmlData;
		} else if (abstractXmlData instanceof XmlSport) {
			tmpXmlSportType = (XmlSport) abstractXmlData;
			if (tmpXmlTournament != null) {
				tmpXmlTournament.setXmlSport(tmpXmlSportType);
			}
		} else if (abstractXmlData instanceof XmlRegion) {
			tmpXmlRegion = (XmlRegion) abstractXmlData;
		} else if (abstractXmlData instanceof XmlTournament) {
			tmpXmlTournament = (XmlTournament) abstractXmlData;
			tmpXmlTournament.setXmlSport(tmpXmlSportType);
			if (tmpXmlRegion != null) {
				tmpXmlTournament.setRegion(tmpXmlRegion);
			}
			if (tmpXmlMatch != null) {
				tmpXmlMatch.setXmlTournament(tmpXmlTournament);
			}
		} else if (abstractXmlData instanceof XmlTournamentEvent) {
			tmpXmlTournamentEvent = (XmlTournamentEvent) abstractXmlData;
			if (tmpXmlTournament != null) {
				tmpXmlTournament.addTournamentEvent(tmpXmlTournamentEvent);
			}
		} else if (abstractXmlData instanceof XmlMatch) {
			tmpXmlMatch = (XmlMatch) abstractXmlData;
			tmpXmlMatch.setXmlTournament(tmpXmlTournament);
			xmlBookmakerEvents.addXmlMatch(tmpXmlMatch);
			if ((tmpXmlMatch.getXmlMatchParticipants() == null || tmpXmlMatch
					.getXmlMatchParticipants().isEmpty())
					&& !tmpXmlMatchParticipants.isEmpty()) {
				tmpXmlMatch.addXmlMatchParticipants(tmpXmlMatchParticipants);
			}
		} else if (abstractXmlData instanceof XmlMarket) {
			tmpMarket = (XmlMarket) abstractXmlData;
			if (tmpMarket.getXmlBetType() != null
					&& tmpMarket.getXmlBetType().getName() == null) {
				tmpMarket.getXmlBetType().setName(tmpMarket.getName());
			}
			if (tmpXmlMatch != null) {
				tmpXmlMatch.addXmlMarket(tmpMarket);
			}
		} else if (abstractXmlData instanceof XmlMatchParticipant) {
			tmpXmlMatchParticipants.add((XmlMatchParticipant) abstractXmlData);
			if (tmpXmlMatch != null) {
				tmpXmlMatch
						.addXmlMatchParticipant((XmlMatchParticipant) abstractXmlData);
			}
		} else if (abstractXmlData instanceof XmlMarketBet) {
			XmlMarketBet xmlMarketBet = (XmlMarketBet) abstractXmlData;
			if (xmlMarketBet != null && tmpXmlMatch != null) {
				// Participants in MarketBet name -->
				// decide the match participants
				if (xmlMarketBet.getXmlMatchParticipant() != null) {
					tmpXmlMatch.addXmlMatchParticipant(xmlMarketBet
							.getXmlMatchParticipant());
				} else {
					// There are already match participants -->
					// add them to the MarketBet if the name correpondes to
					// a role or name
					if (xmlMarketBet.getName() != null) {
						XmlMatchParticipant xmlMatchParticipant = tmpXmlMatch
								.getXmlMatchParticipant(xmlMarketBet.getName());
						xmlMarketBet
								.setXmlMatchParticipant(xmlMatchParticipant);
					}
				}
				if (tmpMarket != null) {
					tmpMarket.addXmlBet(xmlMarketBet);
				}
			}
		}
	}
}
