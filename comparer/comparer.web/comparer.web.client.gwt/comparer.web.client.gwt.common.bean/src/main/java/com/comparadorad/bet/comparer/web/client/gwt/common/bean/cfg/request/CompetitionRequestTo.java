/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToRequest;

/**
 * The Class CompetitionToResult.
 */
public class CompetitionRequestTo extends AbstractClientToRequest {

	/** The bet type id first level. */
	private ObjectToId betTypeIdFirstLevel;

	/** The competition id. */
	private ObjectToId competitionId;
	
	/** The event id. */
	private ObjectToId eventId;

	/**
	 * Instantiates a new competition request to.
	 */
	public CompetitionRequestTo() {
		super();
	}

	/**
	 * Instantiates a new competition request to.
	 * 
	 * @param competitionId
	 *            the competition id
	 */
	public CompetitionRequestTo(ObjectToId competitionId) {
		super();
		this.competitionId = competitionId;
	}

	/**
	 * Instantiates a new competition request to.
	 * 
	 * @param betTypeIdFirstLevel
	 *            the bet type id first level
	 * @param competitionId
	 *            the competition id
	 */
	public CompetitionRequestTo(ObjectToId betTypeIdFirstLevel,
			ObjectToId competitionId) {
		super();
		this.betTypeIdFirstLevel = betTypeIdFirstLevel;
		this.competitionId = competitionId;
	}

	/**
	 * Gets the bet type id first level.
	 * 
	 * @return the bet type id first level
	 */
	public ObjectToId getBetTypeIdFirstLevel() {
		return betTypeIdFirstLevel;
	}

	/**
	 * Gets the competition id.
	 * 
	 * @return the competition id
	 */
	public ObjectToId getCompetitionId() {
		return competitionId;
	}

	/**
	 * Gets the event id.
	 * 
	 * @return the event id
	 */
	public ObjectToId getEventId() {
		return eventId;
	}

	/**
	 * Sets the bet type id first level.
	 * 
	 * @param betTypeIdFirstLevel
	 *            the new bet type id first level
	 */
	public void setBetTypeIdFirstLevel(ObjectToId betTypeIdFirstLevel) {
		this.betTypeIdFirstLevel = betTypeIdFirstLevel;
	}

	/**
	 * Sets the competition id.
	 * 
	 * @param competitionId
	 *            the new competition id
	 */
	public void setCompetitionId(ObjectToId competitionId) {
		this.competitionId = competitionId;
	}

	/**
	 * Sets the event id.
	 * 
	 * @param eventId
	 *            the new event id
	 */
	public void setEventId(ObjectToId eventId) {
		this.eventId = eventId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((betTypeIdFirstLevel == null) ? 0 : betTypeIdFirstLevel
						.hashCode());
		result = prime * result
				+ ((competitionId == null) ? 0 : competitionId.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetitionRequestTo other = (CompetitionRequestTo) obj;
		if (betTypeIdFirstLevel == null) {
			if (other.betTypeIdFirstLevel != null)
				return false;
		} else if (!betTypeIdFirstLevel.equals(other.betTypeIdFirstLevel))
			return false;
		if (competitionId == null) {
			if (other.competitionId != null)
				return false;
		} else if (!competitionId.equals(other.competitionId))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompetitionRequestTo [betTypeIdFirstLevel="
				+ betTypeIdFirstLevel + ", competitionId=" + competitionId
				+ ", eventId=" + eventId + "]";
	}
	
	

}
