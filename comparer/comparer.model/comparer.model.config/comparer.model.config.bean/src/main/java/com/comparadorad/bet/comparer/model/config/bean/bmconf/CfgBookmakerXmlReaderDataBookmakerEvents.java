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
 * The Class CfgBookmakerXmlReaderDataBookmakerEvents.
 */
public class CfgBookmakerXmlReaderDataBookmakerEvents extends
		AbstractCfgBookmakerXmlReaderData {

	/** The Constant XML_FILE_DATE_PARAM. */
	public static final String XML_FILE_DATE_PARAM = "fileDate";

	/**
	 * Instantiates a new cfg bookmaker xml reader data bookmaker events.
	 */
	public CfgBookmakerXmlReaderDataBookmakerEvents() {
		super("XmlBookmakerEvents");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data bookmaker events.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataBookmakerEvents(String pNodeName) {
		super(pNodeName, "XmlBookmakerEvents");
	}

	/**
	 * Gets the file date param.
	 * 
	 * @return the file date param
	 */
	public CfgBookmakerXmlReaderParam getFileDateParam() {
		return getXmlReaderConfigDataParameter(XML_FILE_DATE_PARAM);
	}

	/**
	 * Sets the file date param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new file date xml attribute name
	 * @param xmlNodeName
	 *            the new file date xml node name
	 */
	public void setFileDateParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_FILE_DATE_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}
}