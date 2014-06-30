/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.core.beans;

import java.util.List;
import java.util.Map;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;

/**
 * The Class SecureBetBean.
 */
public class SureBetsMarket implements ISureBet {

	private static final long serialVersionUID = -7405567422505435255L;

	/** The bet type. */
	private CfgBetType betType;

	/** The bet type event. */
	private RtBetTypeEvent betTypeEvent;

	/** The match. */
	private RtMatch match;

	/** The modification date. */
	private CoreDate modificationDate;

	/** The create date. */
	private CoreDate createDate;

	/** The secure bet agrupation. */
	private Map<SecureBeanBenefit, List<RtBet>> secureBetAgrupation;

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetType getBetType() {
		return betType;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param betType
	 *            the new bet type
	 */
	public void setBetType(CfgBetType betType) {
		this.betType = betType;
	}

	/**
	 * Gets the bet type event.
	 * 
	 * @return the bet type event
	 */
	public RtBetTypeEvent getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Sets the bet type event.
	 * 
	 * @param betTypeEvent
	 *            the new bet type event
	 */
	public void setBetTypeEvent(RtBetTypeEvent betTypeEvent) {
		this.betTypeEvent = betTypeEvent;
	}

	/**
	 * Gets the match.
	 * 
	 * @return the match
	 */
	public RtMatch getMatch() {
		return match;
	}

	/**
	 * Sets the match.
	 * 
	 * @param match
	 *            the new match
	 */
	public void setMatch(RtMatch match) {
		this.match = match;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modification date
	 */
	public CoreDate getModificationDate() {
		return modificationDate;
	}

	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate
	 *            the new modification date
	 */
	public void setModificationDate(CoreDate modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Gets the creates the date.
	 * 
	 * @return the creates the date
	 */
	public CoreDate getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 * 
	 * @param createDate
	 *            the new creates the date
	 */
	public void setCreateDate(CoreDate createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the secure bet agrupation.
	 * 
	 * @return the secure bet agrupation
	 */
	public Map<SecureBeanBenefit, List<RtBet>> getSecureBetAgrupation() {
		return secureBetAgrupation;
	}

	/**
	 * Sets the secure bet agrupation.
	 * 
	 * @param secureBetAgrupation
	 *            the secure bet agrupation
	 */
	public void setSecureBetAgrupation(
			Map<SecureBeanBenefit, List<RtBet>> secureBetAgrupation) {
		this.secureBetAgrupation = secureBetAgrupation;
	}

}
