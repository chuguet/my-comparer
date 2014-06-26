/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.io.Serializable;

/**
 * The Class XmlBetOdd.
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class XmlMarketBetOdd extends AbstractXmlData implements Serializable {

	/** The american odds. */
	private String americanOdds;

	/** The fra odds. */
	private String fraOdds;

	/** The odds. */
	private String odds;

	/** The xml url. */
	private XmlUrl xmlUrl;

	/**
	 * Instantiates a new xml bet odd.
	 * 
	 * @param pOdds
	 *            the odds
	 */
	public XmlMarketBetOdd(String pOdds) {
		super();
		odds = pOdds;
	}

	/**
	 * Instantiates a new xml bet odd.
	 * 
	 * @param pOdds
	 *            the odds
	 * @param pAmericanOdds
	 *            the american odds
	 * @param pFraOdds
	 *            the fra odds
	 */
	public XmlMarketBetOdd(String pOdds, String pAmericanOdds, String pFraOdds) {
		super();
		odds = pOdds;
		americanOdds = pAmericanOdds;
		fraOdds = pFraOdds;
	}

	/**
	 * Gets the american odds.
	 * 
	 * @return the american odds
	 */
	public String getAmericanOdds() {
		return americanOdds;
	}

	/**
	 * Gets the fra odds.
	 * 
	 * @return the fra odds
	 */
	public String getFraOdds() {
		return fraOdds;
	}

	/**
	 * Gets the odds.
	 * 
	 * @return the odds
	 */
	public String getOdds() {
		return odds;
	}

	/**
	 * Gets the xml url.
	 * 
	 * @return the xml url
	 */
	public XmlUrl getXmlUrl() {
		return xmlUrl;
	}

	/**
	 * Sets the american odds.
	 * 
	 * @param pAmericanOdds
	 *            the new american odds
	 */
	public void setAmericanOdds(String pAmericanOdds) {
		americanOdds = pAmericanOdds;
	}

	/**
	 * Sets the fra odds.
	 * 
	 * @param pFraOdds
	 *            the new fra odds
	 */
	public void setFraOdds(String pFraOdds) {
		fraOdds = pFraOdds;
	}

	/**
	 * Sets the odds.
	 * 
	 * @param pOdds
	 *            the new odds
	 */
	public void setOdds(String pOdds) {
		odds = pOdds;
	}

	/**
	 * Sets the xml url.
	 * 
	 * @param pXmlUrl
	 *            the new xml url
	 */
	public void setXmlUrl(XmlUrl pXmlUrl) {
		xmlUrl = pXmlUrl;
	}

	@Override
	public String toString() {
		return "XmlMarketBetOdd [americanOdds=" + americanOdds + ", fraOdds="
				+ fraOdds + ", odds=" + odds + ", xmlUrl=" + xmlUrl + "]";
	}
	
	

}