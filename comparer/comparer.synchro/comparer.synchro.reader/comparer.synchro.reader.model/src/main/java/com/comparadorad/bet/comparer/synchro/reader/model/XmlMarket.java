/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Class XmlMarket.
 */
@SuppressWarnings("serial")
public class XmlMarket extends AbstractXmlData<XmlMatch> {

	/** The xml bet type. */
	private XmlBetType xmlBetType;

	/** The xml bets. */
	private Collection<XmlMarketBet> xmlMarketBets;

	/** The xml match. */
	private XmlMatch xmlMatch;

	/**
	 * Instantiates a new xml market.
	 */
	public XmlMarket() {
		super();
	}

	/**
	 * Instantiates a new xml market.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarket(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml market.
	 * 
	 * @param pXmlBetType
	 *            the xml bet type
	 */
	public XmlMarket(final XmlBetType pXmlBetType) {
		super();
		xmlBetType = pXmlBetType;
	}

	/**
	 * Instantiates a new xml market.
	 * 
	 * @param pXmlBetType
	 *            the xml bet type
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarket(final XmlBetType pXmlBetType,
			final BmInternalId pBmInternalId) {
		super(pBmInternalId);
		xmlBetType = pXmlBetType;
	}

	/**
	 * Instantiates a new xml market.
	 * 
	 * @param pXmlMatch
	 *            the xml match
	 * @param pXmlBetType
	 *            the xml bet type
	 */
	public XmlMarket(XmlMatch pXmlMatch, XmlBetType pXmlBetType) {
		super();
		xmlMatch = pXmlMatch;
		xmlBetType = pXmlBetType;
	}

	/**
	 * Instantiates a new xml market.
	 * 
	 * @param pXmlMatch
	 *            the xml match
	 * @param pXmlBetType
	 *            the xml bet type
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarket(XmlMatch pXmlMatch, XmlBetType pXmlBetType,
			final BmInternalId pBmInternalId) {
		super(pBmInternalId);
		xmlMatch = pXmlMatch;
		xmlBetType = pXmlBetType;
	}

	/**
	 * Adds the xml bet.
	 * 
	 * @param pXmlMarketBet
	 *            the xml bet
	 */
	public void addXmlBet(XmlMarketBet pXmlMarketBet) {
		if (this.xmlMarketBets == null) {
			this.xmlMarketBets = new ArrayList<XmlMarketBet>();
		}
		if (pXmlMarketBet != null) {
			pXmlMarketBet.setParent(this);
			this.xmlMarketBets.add(pXmlMarketBet);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmlMarket other = (XmlMarket) obj;
		if (xmlBetType == null) {
			if (other.xmlBetType != null)
				return false;
		} else if (!xmlBetType.equals(other.xmlBetType))
			return false;
		return true;
	}

	/**
	 * Gets the xml bet type.
	 * 
	 * @return the xml bet type
	 */
	public XmlBetType getXmlBetType() {
		return xmlBetType;
	}

	/**
	 * Gets the xml bets.
	 * 
	 * @return the xml bets
	 */
	public Collection<XmlMarketBet> getXmlMarketBets() {
		if (xmlMarketBets == null) {
			xmlMarketBets = new ArrayList<XmlMarketBet>();
		}
		return xmlMarketBets;
	}

	/**
	 * Gets the xml match.
	 * 
	 * @return the xml match
	 */
	public XmlMatch getXmlMatch() {
		return xmlMatch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((xmlBetType == null) ? 0 : xmlBetType.hashCode());
		return result;
	}

	/**
	 * Sets the xml bet type.
	 * 
	 * @param pXmlBetType
	 *            the new xml bet type
	 */
	public void setXmlBetType(XmlBetType pXmlBetType) {
		xmlBetType = pXmlBetType;
	}

	/**
	 * Sets the xml market bets.
	 * 
	 * @param xmlMarketBets
	 *            the new xml market bets
	 */
	public void setXmlMarketBets(Collection<XmlMarketBet> xmlMarketBets) {
		this.xmlMarketBets = xmlMarketBets;
	}

	/**
	 * Sets the xml match.
	 * 
	 * @param pXmlMatch
	 *            the new xml match
	 */
	public void setXmlMatch(XmlMatch pXmlMatch) {
		xmlMatch = pXmlMatch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "XmlMarket [xmlBetType=" + xmlBetType + ", xmlMarketBets="
				+ xmlMarketBets + ", xmlMatch=" + xmlMatch + "]";
	}

}
