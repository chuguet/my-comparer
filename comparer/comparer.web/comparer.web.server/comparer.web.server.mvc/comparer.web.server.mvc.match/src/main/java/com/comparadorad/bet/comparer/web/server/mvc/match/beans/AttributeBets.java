/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.beans;

import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class AttributeBets.
 */
public class AttributeBets {

	/** The attribute. */
	private AbstractRtAttribute attribute;

	/** The bets. */
	private Set<RtBet> bets;

	/** The handicap. */
	private String handicap;

	/**
	 * Gets the attribute.
	 * 
	 * @return the attribute
	 */
	public AbstractRtAttribute getAttribute() {
		return attribute;
	}

	/**
	 * Gets the bets.
	 * 
	 * @return the bets
	 */
	public Set<RtBet> getBets() {
		return bets;
	}

	/**
	 * Gets the handicap.
	 * 
	 * @return the handicap
	 */
	public String getHandicap() {
		return handicap;
	}

	/**
	 * Sets the attribute.
	 * 
	 * @param attribute
	 *            the new attribute
	 */
	public void setAttribute(AbstractRtAttribute attribute) {
		this.attribute = attribute;
	}

	/**
	 * Sets the bets.
	 * 
	 * @param bets
	 *            the new bets
	 */
	public void setBets(Set<RtBet> bets) {
		this.bets = bets;
	}

	/**
	 * Sets the handicap.
	 * 
	 * @param pHandicap
	 *            the new handicap
	 */
	public void setHandicap(String pHandicap) {
		handicap = pHandicap;
	}
}
