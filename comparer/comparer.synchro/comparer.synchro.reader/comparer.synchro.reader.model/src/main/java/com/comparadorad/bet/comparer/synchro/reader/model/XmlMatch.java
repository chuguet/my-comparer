/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.util.ArrayList;
import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlMatch.
 * 
 */
@SuppressWarnings("serial")
public class XmlMatch extends AbstractXmlData<XmlBookmakerEvents> {

	/** The abstract bean parameters. */
	private AbstractBeanParameters abstractBeanParameters;

	/** The live. */
	private boolean live = false;

	/** The live id. */
	private String liveId;

	/** The startDate. */
	private XmlDate startDate;

	/** The streaming. */
	private String streaming;

	/** The xml markets. */
	private Collection<XmlMarket> xmlMarkets;

	/** The xml match participants. */
	private Collection<XmlMatchParticipant> xmlMatchParticipants;

	/** The xml tournament. */
	private XmlTournament xmlTournament;

	/** The xml tournament event. */
	private XmlTournamentEvent xmlTournamentEvent;

	/**
	 * Instantiates a new xml match.
	 */
	public XmlMatch() {
		super();
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMatch(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlMatch(String pName) {
		super(pName);
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMatch(final String pName, final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pName
	 *            the name
	 * @param pLive
	 *            the live
	 */
	public XmlMatch(String pName, final boolean pLive) {
		super(pName);
		this.live = pLive;
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pName
	 *            the name
	 * @param pLive
	 *            the live
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMatch(final String pName, boolean pLive,
			final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
		this.live = pLive;
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pName
	 *            the name
	 * @param pDate
	 *            the startDate
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMatch(final String pName, final XmlDate pDate,
			final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
		this.startDate = pDate;
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pName
	 *            the name
	 * @param pDate
	 *            the startDate
	 * @param pLive
	 *            the live
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMatch(final String pName, final XmlDate pDate,
			final boolean pLive, final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
		this.live = pLive;
		this.startDate = pDate;
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param name
	 *            the name
	 * @param xmlTournament
	 *            the xml tournament
	 * @param date
	 *            the date
	 */
	public XmlMatch(String name, XmlTournament xmlTournament, XmlDate date) {
		super(name);
		this.xmlTournament = xmlTournament;
		this.startDate = date;
	}

	/**
	 * Instantiates a new xml match.
	 * 
	 * @param pDate
	 *            the startDate
	 * @param pLive
	 *            the live
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMatch(final XmlDate pDate, final boolean pLive,
			final BmInternalId pBmInternalId) {
		super(pBmInternalId);
		this.live = pLive;
		this.startDate = pDate;
	}

	/**
	 * Adds the xml market.
	 * 
	 * @param pXmlMarket
	 *            the xml market
	 */
	public void addXmlMarket(XmlMarket pXmlMarket) {
		if (this.xmlMarkets == null) {
			this.xmlMarkets = new ArrayList<XmlMarket>();
		}
		if (pXmlMarket != null) {
			pXmlMarket.setParent(this);
			this.xmlMarkets.add(pXmlMarket);
		}
	}

	/**
	 * Adds the xml match participant.
	 * 
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 */
	public void addXmlMatchParticipant(
			final XmlMatchParticipant pXmlMatchParticipant) {
		if (this.xmlMatchParticipants == null) {
			this.xmlMatchParticipants = new ArrayList<XmlMatchParticipant>();
		}
		if (pXmlMatchParticipant != null) {
			this.xmlMatchParticipants.add(pXmlMatchParticipant);
		}
	}

	/**
	 * Adds the xml match participant away.
	 * 
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 */
	public void addXmlMatchParticipantAway(
			final XmlMatchParticipant pXmlMatchParticipant) {
		pXmlMatchParticipant.setAwayParticipant(true);
		this.addXmlMatchParticipant(pXmlMatchParticipant);
	}

	/**
	 * Adds the xml match participant home.
	 * 
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 */
	public void addXmlMatchParticipantHome(
			final XmlMatchParticipant pXmlMatchParticipant) {
		pXmlMatchParticipant.setHomeParticipant(true);
		this.addXmlMatchParticipant(pXmlMatchParticipant);
	}

	/**
	 * Adds the xml match participants.
	 * 
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 */
	public void addXmlMatchParticipants(
			final Collection<XmlMatchParticipant> pXmlMatchParticipant) {
		for (XmlMatchParticipant xmlMatchParticipant : pXmlMatchParticipant) {
			addXmlMatchParticipant(xmlMatchParticipant);
		}
	}

	/**
	 * Gets the abstract bean parameters.
	 * 
	 * @return the abstract bean parameters
	 */
	public AbstractBeanParameters getAbstractBeanParameters() {
		return abstractBeanParameters;
	}

	/**
	 * Gets the live id.
	 * 
	 * @return the live id
	 */
	public String getLiveId() {
		return liveId;
	}

	/**
	 * Gets the startDate.
	 * 
	 * @return the startDate
	 */
	public XmlDate getStartDate() {
		return startDate;
	}

	/**
	 * Gets the streaming.
	 * 
	 * @return the streaming
	 */
	public String getStreaming() {
		return streaming;
	}

	/**
	 * Gets the xml markets.
	 * 
	 * @return the xml markets
	 */
	public Collection<XmlMarket> getXmlMarkets() {
		if (xmlMarkets == null) {
			xmlMarkets = new ArrayList<XmlMarket>();
		}
		return xmlMarkets;
	}

	/**
	 * Gets the xml match participant.
	 * 
	 * @param internalId
	 *            the internal id
	 * @return the xml match participant
	 */
	public XmlMatchParticipant getXmlMatchParticipant(final String internalId) {
		if (xmlMatchParticipants != null) {
			for (XmlMatchParticipant xmlMatchParticipant : xmlMatchParticipants) {
				if ((xmlMatchParticipant.getRole() != null && internalId.trim()
						.toLowerCase()
						.indexOf(xmlMatchParticipant.getRole().toLowerCase()) != -1)
						|| (xmlMatchParticipant.getName().trim().toLowerCase() != null && internalId
								.trim().indexOf(
										xmlMatchParticipant.getName().trim()
												.toLowerCase()) != -1)) {
					return xmlMatchParticipant;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the xml match participants.
	 * 
	 * @return the xml match participants
	 */
	public Collection<XmlMatchParticipant> getXmlMatchParticipants() {
		if (xmlMatchParticipants == null) {
			xmlMatchParticipants = new ArrayList<XmlMatchParticipant>();
		}
		return xmlMatchParticipants;
	}

	/**
	 * Gets the xml tournament.
	 * 
	 * @return the xml tournament
	 */
	public XmlTournament getXmlTournament() {
		return xmlTournament;
	}

	/**
	 * Gets the xml tournament event.
	 * 
	 * @return the xml tournament event
	 */
	public XmlTournamentEvent getXmlTournamentEvent() {
		return xmlTournamentEvent;
	}

	/**
	 * Checks if is live.
	 * 
	 * @return true, if is live
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * Sets the abstract bean parameters.
	 * 
	 * @param abstractBeanParameters
	 *            the new abstract bean parameters
	 */
	public void setAbstractBeanParameters(
			AbstractBeanParameters abstractBeanParameters) {
		this.abstractBeanParameters = abstractBeanParameters;
	}

	/**
	 * Sets the home participant.
	 */
	public void setHomeParticipant() {

	}

	/**
	 * Sets the live.
	 * 
	 * @param pLive
	 *            the new live
	 */
	public void setLive(boolean pLive) {
		live = pLive;
	}

	/**
	 * Sets the live id.
	 * 
	 * @param pLiveId
	 *            the new live id
	 */
	public void setLiveId(String pLiveId) {
		liveId = pLiveId;
	}

	/**
	 * Sets the startDate.
	 * 
	 * @param pXmlDate
	 *            the new startDate
	 */
	public void setStartDate(XmlDate pXmlDate) {
		startDate = pXmlDate;
	}

	/**
	 * Sets the streaming.
	 * 
	 * @param pStreaming
	 *            the new streaming
	 */
	public void setStreaming(String pStreaming) {
		streaming = pStreaming;
	}

	/**
	 * Sets the xml markets.
	 * 
	 * @param pXmlMarkets
	 *            the new xml markets
	 */
	public void setXmlMarkets(Collection<XmlMarket> pXmlMarkets) {
		xmlMarkets = pXmlMarkets;
	}

	/**
	 * Sets the xml match participants.
	 * 
	 * @param pXmlMatchParticipants
	 *            the new xml match participants
	 */
	public void setXmlMatchParticipants(
			Collection<XmlMatchParticipant> pXmlMatchParticipants) {
		xmlMatchParticipants = pXmlMatchParticipants;
	}

	/**
	 * Sets the xml tournament.
	 * 
	 * @param pXmlTournament
	 *            the new xml tournament
	 */
	public void setXmlTournament(XmlTournament pXmlTournament) {
		xmlTournament = pXmlTournament;
	}

	/**
	 * Sets the xml tournament event.
	 * 
	 * @param pXmlTournamentEvent
	 *            the new xml tournament event
	 */
	public void setXmlTournamentEvent(XmlTournamentEvent pXmlTournamentEvent) {
		xmlTournamentEvent = pXmlTournamentEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "XmlMatch [abstractBeanParameters=" + abstractBeanParameters
				+ ", live=" + live + ", liveId=" + liveId + ", startDate="
				+ startDate + ", streaming=" + streaming + ", xmlMarkets="
				+ xmlMarkets + ", xmlMatchParticipants=" + xmlMatchParticipants
				+ ", xmlTournament=" + xmlTournament + ", xmlTournamentEvent="
				+ xmlTournamentEvent + "]";
	}

}