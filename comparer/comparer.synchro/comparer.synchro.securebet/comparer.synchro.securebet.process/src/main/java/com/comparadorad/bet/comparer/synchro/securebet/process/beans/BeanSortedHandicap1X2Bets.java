/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.beans;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class BeanSortedHandicap1X2Bets.
 */
public class BeanSortedHandicap1X2Bets {

	/** The attribute. */
	private Rt1X2HandicapAttribute attribute;

	/** The bets. */
	private List<RtBet> bets;

	/**
	 * Gets the attribute.
	 * 
	 * @return the attribute
	 */
	public Rt1X2HandicapAttribute getAttribute() {
		return attribute;
	}

	/**
	 * Sets the attribute.
	 * 
	 * @param attribute
	 *            the new attribute
	 */
	public void setAttribute(Rt1X2HandicapAttribute attribute) {
		this.attribute = attribute;
	}

	/**
	 * Gets the bets.
	 * 
	 * @return the bets
	 */
	public List<RtBet> getBets() {
		return bets;
	}

	/**
	 * Sets the bets.
	 * 
	 * @param bets
	 *            the new bets
	 */
	public void setBets(List<RtBet> bets) {
		this.bets = bets;
	}

}
