/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.beans;

import java.util.Date;

/**
 * The Class SureBetTo.
 */
public class SureBetTo extends AbstractBet {

	/** The benefit. */
	private Double benefit;

	/** The bet url. */
	private String betUrl;

	/** The competition. */
	private String competition;

	/** The date. */
	private Date date;

	/** The name. */
	private String name;
	
	/** The region. */
	private String region; 
	
	
	/** The sport. */
	private String sport;
	
	
	
	/**
	 * Instantiates a new sure bet to.
	 *
	 * @param benefit the benefit
	 * @param betUrl the bet url
	 * @param competition the competition
	 * @param date the date
	 * @param name the name
	 * @param region the region
	 * @param sport the sport
	 */
	public SureBetTo(Double benefit, String betUrl, String competition,
			Date date, String name, String region, String sport) {
		super();
		this.benefit = benefit;
		this.betUrl = betUrl;
		this.competition = competition;
		this.date = date;
		this.name = name;
		this.region = region;
		this.sport = sport;
	}

	/**
	 * Instantiates a new sure bet to.
	 */
	public SureBetTo(){
		super();
	}

	/**
	 * Instantiates a new sure bet to.
	 *
	 * @param sport the sport
	 * @param region the region
	 * @param competition the competition
	 * @param name the name
	 * @param date the date
	 */
	public SureBetTo(String sport, String region, String competition,
			String name, Date date) {
		super();
		this.sport = sport;
		this.region = region;
		this.competition = competition;
		this.name = name;
		this.date = date;
	}

	/**
	 * Gets the benefit.
	 *
	 * @return the benefit
	 */
	public Double getBenefit() {
		return benefit;
	}

	/**
	 * Gets the bet url.
	 *
	 * @return the bet url
	 */
	public String getBetUrl() {
		return betUrl;
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public String getCompetition() {
		return competition;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Gets the sport.
	 * 
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * Sets the benefit.
	 *
	 * @param benefit the new benefit
	 */
	public void setBenefit(Double benefit) {
		this.benefit = benefit;
	}

	/**
	 * Sets the bet url.
	 *
	 * @param betUrl the new bet url
	 */
	public void setBetUrl(String betUrl) {
		this.betUrl = betUrl;
	}

	/**
	 * Sets the competition.
	 * 
	 * @param competition
	 *            the new competition
	 */
	public void setCompetition(String competition) {
		this.competition = competition;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the region.
	 * 
	 * @param region
	 *            the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Sets the sport.
	 * 
	 * @param sport
	 *            the new sport
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}

	/** {@inheritDoc} */ 
	@Override
	public String toString() {
		return "SureBetTo [benefit=" + benefit + ", betUrl=" + betUrl
				+ ", competition=" + competition + ", date=" + date + ", name="
				+ name + ", region=" + region + ", sport=" + sport + "]";
	}
	
	
	

}
