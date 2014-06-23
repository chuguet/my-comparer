/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.bean;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;

/**
 * The Class ParametersBean.
 */
public class ParametersBean {

	/** The bet type event id. */
	private String betTypeEventId;

	/** The bet type id. */
	private String betTypeId;

	/** The cache refresh type. */
	private CacheRefreshType cacheRefreshType;

	/** The competition. */
	private CfgCompetition competition;

	/** The competition id. */
	private String competitionId;

	/** The id match. */
	private String idMatch;

	/**
	 * Instantiates a new parameters bean.
	 */
	public ParametersBean() {
	}

	/**
	 * Instantiates a new parameters bean.
	 * 
	 * @param cacheRefreshType
	 *            the cache refresh type
	 * @param idMatch
	 *            the id match
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventId
	 *            the bet type event id
	 * @param competition
	 *            the competition
	 */
	public ParametersBean(CacheRefreshType cacheRefreshType, String idMatch,
			String competitionId, String betTypeId, String betTypeEventId,
			CfgCompetition competition) {
		this.cacheRefreshType = cacheRefreshType;
		this.idMatch = idMatch;
		this.betTypeEventId = betTypeEventId;
		this.betTypeId = betTypeId;
		this.competitionId = competitionId;
		this.competition = competition;
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
		ParametersBean other = (ParametersBean) obj;
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
		if (cacheRefreshType != other.cacheRefreshType)
			return false;
		if (competition == null) {
			if (other.competition != null)
				return false;
		} else if (!competition.equals(other.competition))
			return false;
		if (competitionId == null) {
			if (other.competitionId != null)
				return false;
		} else if (!competitionId.equals(other.competitionId))
			return false;
		if (idMatch == null) {
			if (other.idMatch != null)
				return false;
		} else if (!idMatch.equals(other.idMatch))
			return false;
		return true;
	}

	/**
	 * Gets the bet type event id.
	 * 
	 * @return the bet type event id
	 */
	public String getBetTypeEventId() {
		return betTypeEventId;
	}

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	public String getBetTypeId() {
		return betTypeId;
	}

	/**
	 * Gets the cache refresh type.
	 * 
	 * @return the cache refresh type
	 */
	public CacheRefreshType getCacheRefreshType() {
		return cacheRefreshType;
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public CfgCompetition getCompetition() {
		return competition;
	}

	/**
	 * Gets the competition id.
	 * 
	 * @return the competition id
	 */
	public String getCompetitionId() {
		return competitionId;
	}

	/**
	 * Gets the id match.
	 * 
	 * @return the id match
	 */
	public String getIdMatch() {
		return idMatch;
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
				+ ((betTypeEventId == null) ? 0 : betTypeEventId.hashCode());
		result = prime * result
				+ ((betTypeId == null) ? 0 : betTypeId.hashCode());
		result = prime
				* result
				+ ((cacheRefreshType == null) ? 0 : cacheRefreshType.hashCode());
		result = prime * result
				+ ((competition == null) ? 0 : competition.hashCode());
		result = prime * result
				+ ((competitionId == null) ? 0 : competitionId.hashCode());
		result = prime * result + ((idMatch == null) ? 0 : idMatch.hashCode());
		return result;
	}

	/**
	 * Sets the bet type event id.
	 * 
	 * @param betTypeEventId
	 *            the new bet type event id
	 */
	public void setBetTypeEventId(String betTypeEventId) {
		this.betTypeEventId = betTypeEventId;
	}

	/**
	 * Sets the bet type id.
	 * 
	 * @param betTypeId
	 *            the new bet type id
	 */
	public void setBetTypeId(String betTypeId) {
		this.betTypeId = betTypeId;
	}

	/**
	 * Sets the cache refresh type.
	 * 
	 * @param cacheRefreshType
	 *            the new cache refresh type
	 */
	public void setCacheRefreshType(CacheRefreshType cacheRefreshType) {
		this.cacheRefreshType = cacheRefreshType;
	}

	/**
	 * Sets the competition.
	 * 
	 * @param competition
	 *            the new competition
	 */
	public void setCompetition(CfgCompetition competition) {
		this.competition = competition;
	}

	/**
	 * Sets the competition id.
	 * 
	 * @param competitionId
	 *            the new competition id
	 */
	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}

	/**
	 * Sets the id match.
	 * 
	 * @param idMatch
	 *            the new id match
	 */
	public void setIdMatch(String idMatch) {
		this.idMatch = idMatch;
	}

	@Override
	public String toString() {
		return "ParametersBean [betTypeEventId=" + betTypeEventId
				+ ", betTypeId=" + betTypeId + ", competition=" + competition
				+ ", competitionId=" + competitionId + ", idMatch=" + idMatch
				+ "]";
	}
}
