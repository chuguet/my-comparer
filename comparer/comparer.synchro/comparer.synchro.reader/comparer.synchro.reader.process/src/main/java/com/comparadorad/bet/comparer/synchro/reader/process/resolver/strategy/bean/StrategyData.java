/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;

/**
 * The Class StrategyData.
 */
public class StrategyData {

	/** The bookmaker. */
	private final CfgBookmaker bookmaker;

	/** The bet type. */
	private final CfgBetType betType;

	/** The pattern. */
	private String pattern = "";

	/**
	 * Sets the pattern.
	 * 
	 * @param pPattern
	 *            the new pattern
	 */
	public void setPattern(String pPattern) {
		pattern = pPattern;
	}

	/**
	 * Gets the pattern.
	 * 
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetType getBetType() {
		return betType;
	}

	/** The team. */
	private XmlMarketBet marketBet;

	/** The value. */
	private final String xmlBetTypeName;

	/**
	 * Instantiates a new strategy data.
	 * 
	 * @param pPValue
	 *            the p value
	 * @param pBookmaker
	 *            the bookmaker
	 * @param pValue
	 *            the value
	 */
	public StrategyData(CfgBetType pPValue, CfgBookmaker pBookmaker,
			String pValue) {
		super();
		betType = pPValue;
		bookmaker = pBookmaker;
		xmlBetTypeName = pValue;
	}

	/**
	 * Gets the bookmaker.
	 * 
	 * @return the bookmaker
	 */
	public CfgBookmaker getBookmaker() {
		return bookmaker;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getXmlBetTypeName() {
		return xmlBetTypeName;
	}

	/**
	 * Gets the market bet.
	 * 
	 * @return the market bet
	 */
	public XmlMarketBet getMarketBet() {
		return marketBet;
	}

	/**
	 * Sets the market bet.
	 * 
	 * @param pMarketBet
	 *            the new market bet
	 */
	public void setMarketBet(XmlMarketBet pMarketBet) {
		marketBet = pMarketBet;
	}

}
