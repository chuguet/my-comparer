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
 * The Class CfgBookmakerXmlReaderDataMarket.
 */
public class CfgBookmakerXmlReaderDataMarket extends
		AbstractCfgBookmakerXmlReaderData {

	/** The Constant XML_CODE_PARAM. */
	public static final String XML_CODE_PARAM = "code";

	/** The Constant XML_WEB_URL_PARAM. */
	public static final String XML_WEB_URL_PARAM = "url";

	/**
	 * Instantiates a new cfg bookmaker xml reader data market.
	 */
	public CfgBookmakerXmlReaderDataMarket() {
		super("XmlMarket");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data market.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataMarket(String pNodeName) {
		super(pNodeName, "XmlMarket");
	}

	/**
	 * Gets the code param.
	 * 
	 * @return the code param
	 */
	public CfgBookmakerXmlReaderParam getCodeParam() {
		return getXmlReaderConfigDataParameter(XML_CODE_PARAM);
	}

	/**
	 * Gets the web url param.
	 * 
	 * @return the web url param
	 */
	public CfgBookmakerXmlReaderParam getWebUrlParam() {
		return getXmlReaderConfigDataParameter(XML_WEB_URL_PARAM);
	}

	/**
	 * Sets the code param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new code xml attribute name
	 * @param xmlNodeName
	 *            the new code xml node name
	 */
	public void setCodeParam(final DataLocation dataLocation,
			final String xmlAttributeName, String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_CODE_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}

	/**
	 * Sets the web url param.
	 * 
	 * @param dataLocation
	 *            the data location
	 * @param xmlAttributeName
	 *            the xml attribute name
	 * @param xmlNodeName
	 *            the xml node name
	 */
	public void setWebUrlParam(final DataLocation dataLocation,
			final String xmlAttributeName, String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_WEB_URL_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}
}