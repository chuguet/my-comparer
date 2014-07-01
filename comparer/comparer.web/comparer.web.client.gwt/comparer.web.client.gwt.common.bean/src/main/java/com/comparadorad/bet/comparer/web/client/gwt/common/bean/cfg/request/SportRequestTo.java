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
 * The Class SportRequestTo.
 */
public class SportRequestTo extends AbstractClientToRequest {

	/** The competition id. */
	private ObjectToId competitionId;

	/** The country id. */
	private ObjectToId countryId;

	/** The sport id. */
	private ObjectToId sportId;

	/**
	 * Instantiates a new sport request to.
	 */
	public SportRequestTo() {
		super();
	}

	/**
	 * Instantiates a new sport request to.
	 * 
	 * @param sportId
	 *            the sport id
	 */
	public SportRequestTo(ObjectToId sportId) {
		super();
		this.sportId = sportId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportRequestTo other = (SportRequestTo) obj;
		if (competitionId == null) {
			if (other.competitionId != null)
				return false;
		} else if (!competitionId.equals(other.competitionId))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (sportId == null) {
			if (other.sportId != null)
				return false;
		} else if (!sportId.equals(other.sportId))
			return false;
		return true;
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
	 * Gets the country id.
	 * 
	 * @return the country id
	 */
	public ObjectToId getCountryId() {
		return countryId;
	}

	/**
	 * Gets the sport id.
	 * 
	 * @return the sport id
	 */
	public ObjectToId getSportId() {
		return sportId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competitionId == null) ? 0 : competitionId.hashCode());
		result = prime * result
				+ ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((sportId == null) ? 0 : sportId.hashCode());
		return result;
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
	 * Sets the country id.
	 * 
	 * @param countryId
	 *            the new country id
	 */
	public void setCountryId(ObjectToId countryId) {
		this.countryId = countryId;
	}

	/**
	 * Sets the sport id.
	 * 
	 * @param sportId
	 *            the new sport id
	 */
	public void setSportId(ObjectToId sportId) {
		this.sportId = sportId;
	}

}
