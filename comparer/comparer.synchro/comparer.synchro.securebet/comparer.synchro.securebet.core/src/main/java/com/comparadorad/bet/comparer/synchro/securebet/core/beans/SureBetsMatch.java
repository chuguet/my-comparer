/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.core.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class SecureBeanResult.
 */
public class SureBetsMatch implements ISureBet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6666209630830878470L;

	/** The secure bet beans. */
	private List<SureBetsMarket> sureBetsMarket;

	/**
	 * Gets the secure bet beans.
	 * 
	 * @return the secure bet beans
	 */
	public List<SureBetsMarket> getSureBetsMarket() {
		if (sureBetsMarket == null) {
			sureBetsMarket = new ArrayList<SureBetsMarket>();
		}
		return sureBetsMarket;
	}

	/**
	 * Sets the secure bet beans.
	 * 
	 * @param sureBetsMarket
	 *            the new sure bets market
	 */
	public void setSureBetsMarket(List<SureBetsMarket> sureBetsMarket) {
		this.sureBetsMarket = sureBetsMarket;
	}

	/**
	 * Adds the.
	 * 
	 * @param sureBetsMarket
	 *            the sure bets market
	 */
	public void add(SureBetsMarket sureBetsMarket) {
		getSureBetsMarket().add(sureBetsMarket);
	}

}
