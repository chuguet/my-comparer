/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class XmlToRtResolverData.
 * 
 * This class is used to pass between the diferent XmlToRtResolver.
 */
public class XmlToRtResolverData implements Cloneable {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlToRtResolverData.class);

	/** The bookmaker. */
	private final CfgBookmaker bookmaker;

	/** The last market. */
	private RtMarket lastMarket;

	/** The last cfg bet type. */
	private CfgBetType lastCfgBetType;

	/** The bets number. */
	private int betsNumber;

	/**
	 * Gets the bets number.
	 * 
	 * @return the bets number
	 */
	public int getBetsNumber() {
		return betsNumber;
	}

	/**
	 * Sets the bets number.
	 * 
	 * @param pBetsNumber
	 *            the new bets number
	 */
	public void setBetsNumber(int pBetsNumber) {
		betsNumber = pBetsNumber;
	}

	/**
	 * Gets the last cfg bet type.
	 * 
	 * @return the last cfg bet type
	 */
	public CfgBetType getLastCfgBetType() {
		return lastCfgBetType;
	}

	/**
	 * Sets the last cfg bet type.
	 * 
	 * @param pLastCfgBetType
	 *            the new last cfg bet type
	 */
	public void setLastCfgBetType(CfgBetType pLastCfgBetType) {
		lastCfgBetType = pLastCfgBetType;
	}

	/** The match. */
	private RtMatch match;

	/**
	 * Instantiates a new xml to rt resolver data.
	 * 
	 * @param pBookmaker
	 *            the bookmaker
	 */
	public XmlToRtResolverData(CfgBookmaker pBookmaker) {
		super();
		bookmaker = pBookmaker;
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
	 * Gets the last market.
	 * 
	 * @return the last market
	 */
	public RtMarket getLastMarket() {
		return lastMarket;
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
	 * Sets the last market.
	 * 
	 * @param pLastMarket
	 *            the new last market
	 */
	public void setLastMarket(RtMarket pLastMarket) {
		lastMarket = pLastMarket;
	}

	/**
	 * Sets the match.
	 * 
	 * @param pMatch
	 *            the new match
	 */
	public void setMatch(RtMatch pMatch) {
		match = pMatch;
	}

	/**
	 * Clone.
	 * 
	 * @return the object {@inheritDoc}
	 */

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

}
