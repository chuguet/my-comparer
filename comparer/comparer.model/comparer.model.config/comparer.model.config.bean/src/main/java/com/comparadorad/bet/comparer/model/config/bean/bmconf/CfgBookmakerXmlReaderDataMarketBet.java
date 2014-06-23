/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader.DataLocation;

/**
 * The Class CfgBookmakerXmlReaderDataMarketBet.
 */
public class CfgBookmakerXmlReaderDataMarketBet extends
		AbstractCfgBookmakerXmlReaderData {

	/** The Constant XML_MARKET_BET_AMERICAN_ODD_PARAM. */
	public static final String XML_MARKET_BET_AMERICAN_ODD_PARAM = "americanOdd";

	/** The Constant XML_MARKET_BET_FRA_ODD_PARAM. */
	public static final String XML_MARKET_BET_FRA_ODD_PARAM = "fraOdd";

	/** The Constant XML_MARKET_BET_ODD_PARAM. */
	public static final String XML_MARKET_BET_ODD_PARAM = "odd";

	/** The Constant XML_MARKET_BET_VALUE_PARAM. */
	public static final String XML_MARKET_BET_VALUE_PARAM = "value";

	/** The Constant XML_PARTICIPIANS_IN_NAME_PARAM. */
	public static final String XML_PARTICIPANTS_IN_NAME_PARAM = "participantsInName";

	/**
	 * Instantiates a new cfg bookmaker xml reader data market bet.
	 */
	public CfgBookmakerXmlReaderDataMarketBet() {
		super("XmlMarketBet");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data market bet.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataMarketBet(String pNodeName) {
		super(pNodeName, "XmlMarketBet");
	}

	/**
	 * Gets the american odd param.
	 * 
	 * @return the american odd param
	 */
	public CfgBookmakerXmlReaderParam getAmericanOddParam() {
		return getXmlReaderConfigDataParameter(XML_MARKET_BET_AMERICAN_ODD_PARAM);
	}

	/**
	 * Gets the fra odd param.
	 * 
	 * @return the fra odd param
	 */
	public CfgBookmakerXmlReaderParam getFraOddParam() {
		return getXmlReaderConfigDataParameter(XML_MARKET_BET_FRA_ODD_PARAM);
	}

	/**
	 * Gets the odd param.
	 * 
	 * @return the odd param
	 */
	public CfgBookmakerXmlReaderParam getOddParam() {
		return getXmlReaderConfigDataParameter(XML_MARKET_BET_ODD_PARAM);
	}

	/**
	 * Gets the participants in name param.
	 * 
	 * @return the participants in name param
	 */
	private CfgBookmakerXmlReaderParam getParticipantsInNameParam() {
		return getXmlReaderConfigDataParameter(XML_PARTICIPANTS_IN_NAME_PARAM);
	}

	/**
	 * Gets the value param.
	 * 
	 * @return the value param
	 */
	public CfgBookmakerXmlReaderParam getValueParam() {
		return getXmlReaderConfigDataParameter(XML_MARKET_BET_VALUE_PARAM);
	}

	/**
	 * Checks if is participants in name.
	 * 
	 * @return true, if is participants in name
	 */
	public boolean isParticipantsInName() {
		boolean result = false;
		if (getParticipantsInNameParam() != null) {
			result = new Boolean(getParticipantsInNameParam()
					.getXmlExtraInfoParam());
		}
		return result;
	}

	/**
	 * Sets the american odd param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new american odd xml attribute name
	 * @param xmlNodeName
	 *            the new american odd xml node name
	 */
	public void setAmericanOddParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_MARKET_BET_AMERICAN_ODD_PARAM,
				xmlAttributeName, xmlNodeName, dataLocation);
	}

	/**
	 * Sets the fra odd param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new fra odd xml attribute name
	 * @param xmlNodeName
	 *            the new fra odd xml node name
	 */
	public void setFraOddParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_MARKET_BET_FRA_ODD_PARAM,
				xmlAttributeName, xmlNodeName, dataLocation);
	}

	/**
	 * Sets the odd param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new odd xml attribute name
	 * @param xmlNodeName
	 *            the new odd xml node name
	 */
	public void setOddParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_MARKET_BET_ODD_PARAM,
				xmlAttributeName, xmlNodeName, dataLocation);
	}

	/**
	 * Sets the participants in name.
	 * 
	 * @param participantsInName
	 *            the new participants in name
	 */
	public void setParticipantsInName(final boolean participantsInName) {
		setParticipiantsInNameParam(new Boolean(participantsInName).toString());
	}

	/**
	 * Sets the participant in name param.
	 * 
	 * @param pXmlExtraInfoParam
	 *            the new participant in name param
	 */
	private void setParticipiantsInNameParam(final String pXmlExtraInfoParam) {
		addXmlReaderConfigDataParameter(XML_PARTICIPANTS_IN_NAME_PARAM,
				pXmlExtraInfoParam);
	}

	/**
	 * Sets the value param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new value xml attribute name
	 * @param xmlNodeName
	 *            the new value xml node name
	 */
	public void setValueParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_MARKET_BET_VALUE_PARAM,
				xmlAttributeName, xmlNodeName, dataLocation);
	}
}