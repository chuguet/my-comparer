/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean;

import java.util.Arrays;
import java.util.List;

/**
 * The Class CriteriaBetTypeEvent.
 */
public class CriteriaBetTypeEvent {

	/** The bookmakers specials. */
	private List<String> bookmakersSpecials = Arrays.asList("77", "69", "85",
			"103", "105");

	/** The id bet type. */
	private String idBetType;

	/** The id bookmaker. */
	private String idBookmaker;

	/** The id competition. */
	private String idCompetition;

	/** The id sport. */
	private String idSport;

	/** The sports specials. */
	private List<String> sportsSpecials = Arrays.asList("24");

	/**
	 * Instantiates a new criteria bet type event.
	 */
	public CriteriaBetTypeEvent() {

	}

	/**
	 * Instantiates a new criteria bet type event.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param idSport
	 *            the id sport
	 * @param idBetType
	 *            the id bet type
	 */
	public CriteriaBetTypeEvent(String idBookmaker, String idSport,
			String idBetType) {
		super();
		this.idBookmaker = idBookmaker;
		this.idSport = idSport;
		this.idBetType = idBetType;
	}

	/**
	 * Instantiates a new criteria bet type event.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param idSport
	 *            the id sport
	 * @param idBetType
	 *            the id bet type
	 * @param idCompetition
	 *            the id competition
	 */
	public CriteriaBetTypeEvent(String idBookmaker, String idSport,
			String idBetType, String idCompetition) {
		super();
		this.idBookmaker = idBookmaker;
		this.idSport = idSport;
		this.idBetType = idBetType;
		this.idCompetition = idCompetition;
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
		CriteriaBetTypeEvent other = (CriteriaBetTypeEvent) obj;
		if (idBetType == null) {
			if (other.idBetType != null)
				return false;
		} else if (!idBetType.equals(other.idBetType))
			return false;
		if (idBookmaker == null) {
			if (other.idBookmaker != null)
				return false;
		} else if (!idBookmaker.equals(other.idBookmaker))
			return false;
		if (idCompetition == null) {
			if (other.idCompetition != null)
				return false;
		} else if (!idCompetition.equals(other.idCompetition))
			return false;
		if (idSport == null) {
			if (other.idSport != null)
				return false;
		} else if (!idSport.equals(other.idSport))
			return false;
		return true;
	}

	/**
	 * Gets the id bet type.
	 * 
	 * @return the id bet type
	 */
	public String getIdBetType() {
		return idBetType;
	}

	/**
	 * Gets the id bookmaker.
	 * 
	 * @return the id bookmaker
	 */
	public String getIdBookmaker() {
		return idBookmaker;
	}

	/**
	 * Gets the id competition.
	 * 
	 * @return the id competition
	 */
	public String getIdCompetition() {
		return idCompetition;
	}

	/**
	 * Gets the id sport.
	 * 
	 * @return the id sport
	 */
	public String getIdSport() {
		return idSport;
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
				+ ((idBetType == null) ? 0 : idBetType.hashCode());
		result = prime * result
				+ ((idBookmaker == null) ? 0 : idBookmaker.hashCode());
		result = prime * result
				+ ((idCompetition == null) ? 0 : idCompetition.hashCode());
		result = prime * result + ((idSport == null) ? 0 : idSport.hashCode());
		return result;
	}

	/**
	 * Sets the id bet type.
	 * 
	 * @param idBetType
	 *            the new id bet type
	 */
	public void setIdBetType(String idBetType) {
		this.idBetType = idBetType;
	}

	/**
	 * Sets the id bookmaker.
	 * 
	 * @param idBookmaker
	 *            the new id bookmaker
	 */
	public void setIdBookmaker(String idBookmaker) {
		this.idBookmaker = idBookmaker;
	}

	/**
	 * Sets the id competition.
	 * 
	 * @param idCompetition
	 *            the new id competition
	 */
	public void setIdCompetition(String idCompetition) {
		if (sportsSpecials.contains(idSport)
				&& (bookmakersSpecials.contains(idBookmaker))) {
			this.idCompetition = idCompetition;
		}
	}

	/**
	 * Sets the id sport.
	 * 
	 * @param idSport
	 *            the new id sport
	 */
	public void setIdSport(String idSport) {
		this.idSport = idSport;
	}

}
