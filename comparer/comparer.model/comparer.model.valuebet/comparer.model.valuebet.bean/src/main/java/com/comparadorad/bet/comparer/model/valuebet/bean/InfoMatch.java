/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.bean;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.valuebet.validator.CompetitionExistInBD;

/**
 * The Class InfoMatch.
 */
@SuppressWarnings("serial")
public class InfoMatch extends AbstractId {

	/** The competition. */
	@Field
	@CompetitionExistInBD
	private CfgCompetition competition;

	/** The date. */
	@Field
	private Date date;

	/** The markets. */
	@Field
	private RtMarket market;

	/** The i18n. */
	@Field
	private I18n name;

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public CfgCompetition getCompetition() {
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
	 * Gets the markets.
	 * 
	 * @return the markets
	 */
	public RtMarket getMarket() {
		return market;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public I18n getName() {
		return name;
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
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets the markets.
	 * 
	 * @param market
	 *            the new market
	 */
	public void setMarket(RtMarket market) {
		this.market = market;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(I18n name) {
		this.name = name;
	}

}
