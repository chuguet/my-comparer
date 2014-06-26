/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class ExistBetData.
 */
public class ExistBetData extends AbstractExistData<RtBet> {

	/** The rt bet. */
	private RtBet previousRtBet;

	/**
	 * Instantiates a new exist bet data.
	 * 
	 * @param pIsNew
	 *            the is new
	 */
	public ExistBetData(Boolean pIsNew) {
		super(pIsNew);
	}

	/**
	 * Gets the rt bet.
	 * 
	 * @return the rt bet
	 */
	public RtBet getPreviousRtBet() {
		return previousRtBet;
	}

	/**
	 * Sets the rt bet.
	 * 
	 * @param pRtBet
	 *            the new rt bet
	 */
	public void setPreviousRtBet(RtBet pRtBet) {
		previousRtBet = pRtBet;
	}

}
