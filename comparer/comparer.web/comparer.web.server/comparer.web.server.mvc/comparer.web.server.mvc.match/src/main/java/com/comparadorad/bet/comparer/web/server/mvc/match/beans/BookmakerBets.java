/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.beans;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class BookmakerBets.
 */
public class BookmakerBets {

	/** The bookmaker. */
	private CfgBookmaker bookmaker;

	/** The bets. */
	private List<RtBet> bets;

	/**
	 * Gets the bookmaker.
	 * 
	 * @return the bookmaker
	 */
	public CfgBookmaker getBookmaker() {
		return bookmaker;
	}

	/**
	 * Sets the bookmaker.
	 * 
	 * @param bookmaker
	 *            the new bookmaker
	 */
	public void setBookmaker(CfgBookmaker bookmaker) {
		this.bookmaker = bookmaker;
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
