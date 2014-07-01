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
 * The Class CountryRequestTo.
 */
public class CountryRequestTo extends AbstractClientToRequest {

	/** The bet type id. */
	private ObjectToId betTypeId;

	/** The competition id. */
	private ObjectToId competitionId;

	/** The country id. */
	private ObjectToId countryId;

	/** The sport id. */
	private ObjectToId sportId;

	/**
	 * Instantiates a new country request to.
	 */
	public CountryRequestTo() {
		super();
	}

	/**
	 * Instantiates a new country request to.
	 * 
	 * @param countryId
	 *            the country id
	 */
	public CountryRequestTo(ObjectToId countryId) {
		super();
		this.countryId = countryId;
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
	 * Sets the country id.
	 * 
	 * @param pCountryId
	 *            the new country id
	 */
	public void setCountryId(ObjectToId pCountryId) {
		countryId = pCountryId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((betTypeId == null) ? 0 : betTypeId.hashCode());
		result = prime * result
				+ ((competitionId == null) ? 0 : competitionId.hashCode());
		result = prime * result
				+ ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((sportId == null) ? 0 : sportId.hashCode());
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
		CountryRequestTo other = (CountryRequestTo) obj;
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

}
