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
 * The Class EventRequestTo.
 */
public class EventRequestTo extends AbstractClientToRequest {

	/** The bet type event id. */
	private ObjectToId betTypeEventId;

	/** The bet type id. */
	private ObjectToId betTypeId;

	/** The competition id. */
	private ObjectToId competitionId;

	/** The event id. */
	private ObjectToId eventId;

	/**
	 * Instantiates a new event request to.
	 */
	public EventRequestTo() {
		super();
	}

	/**
	 * Instantiates a new event request to.
	 * 
	 * @param eventId
	 *            the event id
	 */
	public EventRequestTo(ObjectToId eventId) {
		super();
		this.eventId = eventId;
	}

	/**
	 * Instantiates a new event request to.
	 * 
	 * @param betTypeId
	 *            the bet type id
	 * @param eventId
	 *            the event id
	 */
	public EventRequestTo(ObjectToId betTypeId, ObjectToId eventId) {
		super();
		this.betTypeId = betTypeId;
		this.eventId = eventId;
	}

	/**
	 * Instantiates a new event request to.
	 * 
	 * @param betTypeEventId
	 *            the bet type event id
	 * @param betTypeId
	 *            the bet type id
	 * @param eventId
	 *            the event id
	 */
	public EventRequestTo(ObjectToId betTypeEventId, ObjectToId betTypeId,
			ObjectToId eventId) {
		super();
		this.betTypeEventId = betTypeEventId;
		this.betTypeId = betTypeId;
		this.eventId = eventId;
	}

	/**
	 * Gets the bet type event id.
	 * 
	 * @return the bet type event id
	 */
	public ObjectToId getBetTypeEventId() {
		return betTypeEventId;
	}

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	public ObjectToId getBetTypeId() {
		return betTypeId;
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
	 * Sets the bet type event id.
	 * 
	 * @param betTypeEventId
	 *            the new bet type event id
	 */
	public void setBetTypeEventId(ObjectToId betTypeEventId) {
		this.betTypeEventId = betTypeEventId;
	}

	/**
	 * Sets the bet type id.
	 * 
	 * @param betTypeId
	 *            the new bet type id
	 */
	public void setBetTypeId(ObjectToId betTypeId) {
		this.betTypeId = betTypeId;
	}

	/**
	 * Sets the competition id.
	 * 
	 * @param pCompetitionId
	 *            the new competition id
	 */
	public void setCompetitionId(ObjectToId pCompetitionId) {
		competitionId = pCompetitionId;
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
		result = prime * result
				+ ((betTypeEventId == null) ? 0 : betTypeEventId.hashCode());
		result = prime * result
				+ ((betTypeId == null) ? 0 : betTypeId.hashCode());
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
		EventRequestTo other = (EventRequestTo) obj;
		if (betTypeEventId == null) {
			if (other.betTypeEventId != null)
				return false;
		} else if (!betTypeEventId.equals(other.betTypeEventId))
			return false;
		if (betTypeId == null) {
			if (other.betTypeId != null)
				return false;
		} else if (!betTypeId.equals(other.betTypeId))
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

}
