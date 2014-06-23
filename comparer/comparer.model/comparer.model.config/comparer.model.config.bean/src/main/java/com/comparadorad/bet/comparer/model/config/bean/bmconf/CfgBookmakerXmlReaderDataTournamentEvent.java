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
 * The Class CfgBookmakerXmlReaderDataTournamentEvent.
 */
@SuppressWarnings("serial")
public class CfgBookmakerXmlReaderDataTournamentEvent extends
		AbstractCfgBookmakerXmlReaderData {

	/** The Constant XML_START_DATE_PARAM. */
	public static final String XML_END_DATE_PARAM = "endDate";

	/** The Constant XML_START_DATE_PARAM. */
	public static final String XML_START_DATE_PARAM = "startDate";

	/**
	 * Instantiates a new cfg bookmaker xml reader data tournament event.
	 */
	public CfgBookmakerXmlReaderDataTournamentEvent() {
		super("XmlTournamentEvent");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data tournament.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataTournamentEvent(String pNodeName) {
		super(pNodeName, "XmlTournamentEvent");
	}

	/**
	 * Gets the end date param.
	 * 
	 * @return the end date param
	 */
	public CfgBookmakerXmlReaderParam getEndDateParam() {
		return getXmlReaderConfigDataParameter(XML_END_DATE_PARAM);
	}

	/**
	 * Gets the start date param.
	 * 
	 * @return the start date param
	 */
	public CfgBookmakerXmlReaderParam getStartDateParam() {
		return getXmlReaderConfigDataParameter(XML_START_DATE_PARAM);
	}

	/**
	 * Sets the end date param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new end date xml attribute name
	 * @param xmlNodeName
	 *            the new end date xml node name
	 */
	public void setEndDateParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_END_DATE_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}

	/**
	 * Sets the start date param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new start date xml attribute name
	 * @param xmlNodeName
	 *            the new start date xml node name
	 */
	public void setStartDateParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_START_DATE_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}

}