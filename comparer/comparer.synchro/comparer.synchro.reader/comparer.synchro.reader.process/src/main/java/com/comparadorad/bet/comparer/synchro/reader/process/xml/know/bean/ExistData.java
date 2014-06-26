/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class ExistData.
 */
public class ExistData {

	/** The bean market id. */
	private String beanMarketId = "";

	/** The bookmaker. */
	private CfgBookmaker bookmaker;

	/** The rt match. */
	private RtMatch rtMatch;

	/** The xml bet internal id. */
	private String xmlBetInternalId = "";

	/** The xml market internal id. */
	private String xmlMarketInternalId = "";

	/** The xml match internal id. */
	private String xmlMatchInternalId = "";

	/** The xml to rt resolver data. */
	private XmlToRtResolverData xmlToRtResolverData;

	/**
	 * Gets the bean market id.
	 * 
	 * @return the bean market id
	 */
	public String getBeanMarketId() {
		return beanMarketId;
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
	 * Gets the rt match.
	 * 
	 * @return the rt match
	 */
	public RtMatch getRtMatch() {
		return rtMatch;
	}

	/**
	 * Gets the xml bet internal id.
	 * 
	 * @return the xml bet internal id
	 */
	public String getXmlBetInternalId() {
		return xmlBetInternalId;
	}

	/**
	 * Gets the xml market internal id.
	 * 
	 * @return the xml market internal id
	 */
	public String getXmlMarketInternalId() {
		return xmlMarketInternalId;
	}

	/**
	 * Gets the xml match internal id.
	 * 
	 * @return the xml match internal id
	 */
	public String getXmlMatchInternalId() {
		return xmlMatchInternalId;
	}

	/**
	 * Gets the xml to rt resolver data.
	 * 
	 * @return the xml to rt resolver data
	 */
	public XmlToRtResolverData getXmlToRtResolverData() {
		return xmlToRtResolverData;
	}

	/**
	 * Sets the bean market id.
	 * 
	 * @param pBeanMarketId
	 *            the new bean market id
	 */
	public void setBeanMarketId(String pBeanMarketId) {
		beanMarketId = pBeanMarketId;
	}

	/**
	 * Sets the bookmaker.
	 * 
	 * @param pBookmaker
	 *            the new bookmaker
	 */
	public void setBookmaker(CfgBookmaker pBookmaker) {
		bookmaker = pBookmaker;
	}

	/**
	 * Sets the rt match.
	 * 
	 * @param pRtMatch
	 *            the new rt match
	 */
	public void setRtMatch(RtMatch pRtMatch) {
		rtMatch = pRtMatch;
	}

	/**
	 * Sets the xml bet internal id.
	 * 
	 * @param pXmlBetInternalId
	 *            the new xml bet internal id
	 */
	public void setXmlBetInternalId(String pXmlBetInternalId) {
		xmlBetInternalId = pXmlBetInternalId;
	}

	/**
	 * Sets the xml market internal id.
	 * 
	 * @param pXmlMarketInternalId
	 *            the new xml market internal id
	 */
	public void setXmlMarketInternalId(String pXmlMarketInternalId) {
		xmlMarketInternalId = pXmlMarketInternalId;
	}

	/**
	 * Sets the xml match internal id.
	 * 
	 * @param pXmlMatchInternalId
	 *            the new xml match internal id
	 */
	public void setXmlMatchInternalId(String pXmlMatchInternalId) {
		xmlMatchInternalId = pXmlMatchInternalId;
	}

	/**
	 * Sets the xml to rt resolver data.
	 * 
	 * @param pXmlToRtResolverData
	 *            the new xml to rt resolver data
	 */
	public void setXmlToRtResolverData(XmlToRtResolverData pXmlToRtResolverData) {
		xmlToRtResolverData = pXmlToRtResolverData;
	}

}
