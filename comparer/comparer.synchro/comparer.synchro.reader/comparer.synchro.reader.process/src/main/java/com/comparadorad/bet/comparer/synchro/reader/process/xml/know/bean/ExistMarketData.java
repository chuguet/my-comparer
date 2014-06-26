/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;

/**
 * The Class ExistMarketData.
 */
public class ExistMarketData extends AbstractExistData<RtMarket> {

	/** The previous market. */
	private RtMarket previousMarket;

	/**
	 * Gets the previous market.
	 * 
	 * @return the previous market
	 */
	public RtMarket getPreviousMarket() {
		return previousMarket;
	}

	/**
	 * Sets the previous market.
	 * 
	 * @param pPreviousMarket
	 *            the new previous market
	 */
	public void setPreviousMarket(RtMarket pPreviousMarket) {
		previousMarket = pPreviousMarket;
	}

	/**
	 * Instantiates a new exist market data.
	 * 
	 * @param pIsNew
	 *            the is new
	 */
	public ExistMarketData(Boolean pIsNew) {
		super(pIsNew);
	}

}
