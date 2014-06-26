/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.HashCodeBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlTournament.
 */
public class XmlTournament extends AbstractXmlData {

	/** The region. */
	private XmlRegion region;

	/** The tournament events. */
	private Collection<XmlTournamentEvent> tournamentEvents;

	/** The xml sport type. */
	private XmlSport xmlSport;

	/** The participant names. */
	private Set<String> participantNames;

	/**
	 * Gets the participant names.
	 * 
	 * @return the participant names
	 */
	public Set<String> getParticipantNames() {
		if(participantNames == null){
			participantNames = new HashSet<String>();
		}
		return participantNames;
	}
	
	public boolean addParticipant(String participant){
		return getParticipantNames().add(participant);
	}

	/**
	 * Sets the participant names.
	 * 
	 * @param participantNames
	 *            the new participant names
	 */
	public void setParticipantNames(Set<String> participantNames) {
		this.participantNames = participantNames;
	}

	/**
	 * Instantiates a new xml tournament.
	 */
	public XmlTournament() {
		super();
	}

	/**
	 * Instantiates a new xml tournament.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlTournament(final String pName) {
		super(pName);
	}

	/**
	 * Adds the tournament event.
	 * 
	 * @param pTournamentEvent
	 *            the tournament event
	 */
	public void addTournamentEvent(XmlTournamentEvent pTournamentEvent) {
		if (this.tournamentEvents == null) {
			this.tournamentEvents = new HashSet<XmlTournamentEvent>();
		}
		tournamentEvents.add(pTournamentEvent);
	}

	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public XmlRegion getRegion() {
		return region;
	}

	/**
	 * Gets the tournament events.
	 * 
	 * @return the tournament events
	 */
	public Collection<XmlTournamentEvent> getTournamentEvents() {
		return tournamentEvents;
	}

	/**
	 * Gets the xml sport type.
	 * 
	 * @return the xml sport type
	 */
	public XmlSport getXmlSport() {
		return xmlSport;
	}

	/**
	 * Sets the region.
	 * 
	 * @param region
	 *            the new region
	 */
	public void setRegion(XmlRegion region) {
		this.region = region;
	}

	/**
	 * Sets the tournament events.
	 * 
	 * @param pTournamentEvents
	 *            the new tournament events
	 */
	public void setTournamentEvents(
			Collection<XmlTournamentEvent> pTournamentEvents) {
		tournamentEvents = pTournamentEvents;
	}

	/**
	 * Sets the xml sport type.
	 * 
	 * @param pXmlSport
	 *            the new xml sport type
	 */
	public void setXmlSport(XmlSport pXmlSport) {
		xmlSport = pXmlSport;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode()).append(this.participantNames)
				.append(this.region).append(this.tournamentEvents)
				.append(this.xmlSport).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmlTournament other = (XmlTournament) obj;
		if (participantNames == null) {
			if (other.participantNames != null)
				return false;
		} else if (!participantNames.equals(other.participantNames))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (tournamentEvents == null) {
			if (other.tournamentEvents != null)
				return false;
		} else if (!tournamentEvents.equals(other.tournamentEvents))
			return false;
		if (xmlSport == null) {
			if (other.xmlSport != null)
				return false;
		} else if (!xmlSport.equals(other.xmlSport))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "XmlTournament [region=" + region + ", tournamentEvents="
				+ tournamentEvents + ", xmlSport=" + xmlSport
				+ ", participantNames=" + participantNames + "]";
	}
	
	

}
