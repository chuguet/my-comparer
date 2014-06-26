/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

/**
 * The Class XmlBet.
 */
@SuppressWarnings("serial")
public class XmlMarketBet extends AbstractXmlData<XmlMarket> {

	/**
	 * The xml market bet value. Here goes the value corresponding to a bet
	 * where there is a value. For example the handicap/spread value or the
	 * under/over bet total points value.
	 * */
	private String marketBetValue;

	/** The xml attribute. */
	private IXmlAttribute xmlAttribute;

	/** The result. */
	private XmlMarketBetOdd xmlMarketBetOdd;

	/** The xml match participant. */
	private XmlMatchParticipant xmlMatchParticipant;

	/** The xml url. */
	private XmlUrl xmlUrl;

	/**
	 * Instantiates a new xml bet.
	 */
	public XmlMarketBet() {
		super();
	}

	/**
	 * Instantiates a new xml bet.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarketBet(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml bet.
	 * 
	 * @param pName
	 *            the name
	 * @param pXmlMarketBetOdd
	 *            the xml bet odd
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarketBet(final String pName,
			final XmlMarketBetOdd pXmlMarketBetOdd,
			final XmlMatchParticipant pXmlMatchParticipant,
			final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
		this.xmlMarketBetOdd = pXmlMarketBetOdd;
		xmlMatchParticipant = pXmlMatchParticipant;
	}

	/**
	 * Instantiates a new xml bet.
	 * 
	 * @param pResult
	 *            the result
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 */
	public XmlMarketBet(String pResult, XmlMatchParticipant pXmlMatchParticipant) {
		super();
		this.xmlMarketBetOdd = new XmlMarketBetOdd(pResult);
		xmlMatchParticipant = pXmlMatchParticipant;
	}

	/**
	 * Instantiates a new xml bet.
	 * 
	 * @param pResult
	 *            the result
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarketBet(final String pResult,
			final XmlMatchParticipant pXmlMatchParticipant,
			final BmInternalId pBmInternalId) {
		super(pBmInternalId);
		this.xmlMarketBetOdd = new XmlMarketBetOdd(pResult);
		xmlMatchParticipant = pXmlMatchParticipant;
	}

	/**
	 * Instantiates a new xml market bet.
	 * 
	 * @param pXmlMarketBetOdd
	 *            the xml market bet odd
	 */
	public XmlMarketBet(final XmlMarketBetOdd pXmlMarketBetOdd) {
		super();
		this.xmlMarketBetOdd = pXmlMarketBetOdd;
	}

	/**
	 * Instantiates a new xml market bet.
	 * 
	 * @param pXmlMarketBetOdd
	 *            the xml market bet odd
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarketBet(final XmlMarketBetOdd pXmlMarketBetOdd,
			final BmInternalId pBmInternalId) {
		super(pBmInternalId);
		this.xmlMarketBetOdd = pXmlMarketBetOdd;
	}

	/**
	 * Instantiates a new xml bet.
	 * 
	 * @param pXmlMarketBetOdd
	 *            the xml bet odd
	 * @param pXmlMatchParticipant
	 *            the xml match participant
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlMarketBet(final XmlMarketBetOdd pXmlMarketBetOdd,
			final XmlMatchParticipant pXmlMatchParticipant,
			final BmInternalId pBmInternalId) {
		super(pBmInternalId);
		this.xmlMarketBetOdd = pXmlMarketBetOdd;
		xmlMatchParticipant = pXmlMatchParticipant;
	}

	/**
	 * Gets the market bet value.
	 * 
	 * @return the market bet value
	 */
	public String getMarketBetValue() {
		return marketBetValue;
	}

	/**
	 * Gets the xml attribute.
	 * 
	 * @return the xml attribute
	 */
	public IXmlAttribute getXmlAttribute() {
		return xmlAttribute;
	}

	/**
	 * Gets the xml bet odd.
	 * 
	 * @return the xml bet odd
	 */
	public XmlMarketBetOdd getXmlBetOdd() {
		return xmlMarketBetOdd;
	}

	/**
	 * Gets the xml market bet odd.
	 * 
	 * @return the xml market bet odd
	 */
	public XmlMarketBetOdd getXmlMarketBetOdd() {
		return xmlMarketBetOdd;
	}

	/**
	 * Gets the xml match participant.
	 * 
	 * @return the xml match participant
	 */
	public XmlMatchParticipant getXmlMatchParticipant() {
		return xmlMatchParticipant;
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
	 * Sets the market bet value.
	 * 
	 * @param pMarketBetValue
	 *            the new market bet value
	 */
	public void setMarketBetValue(String pMarketBetValue) {
		this.marketBetValue = pMarketBetValue;
	}

	/**
	 * Sets the xml attribute.
	 * 
	 * @param pXmlAttribute
	 *            the new xml attribute
	 */
	public void setXmlAttribute(IXmlAttribute pXmlAttribute) {
		xmlAttribute = pXmlAttribute;
	}

	/**
	 * Sets the xml market bet odd.
	 * 
	 * @param pXmlMarketBetOdd
	 *            the new xml market bet odd
	 */
	public void setXmlMarketBetOdd(XmlMarketBetOdd pXmlMarketBetOdd) {
		xmlMarketBetOdd = pXmlMarketBetOdd;
	}

	/**
	 * Sets the xml match participant.
	 * 
	 * @param pXmlMatchParticipant
	 *            the new xml match participant
	 */
	public void setXmlMatchParticipant(XmlMatchParticipant pXmlMatchParticipant) {
		xmlMatchParticipant = pXmlMatchParticipant;
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
		return "XmlMarketBet [marketBetValue=" + marketBetValue
				+ ", xmlAttribute=" + xmlAttribute + ", xmlMarketBetOdd="
				+ xmlMarketBetOdd + ", xmlMatchParticipant="
				+ xmlMatchParticipant + ", xmlUrl=" + xmlUrl + "]";
	}
	
	

}
