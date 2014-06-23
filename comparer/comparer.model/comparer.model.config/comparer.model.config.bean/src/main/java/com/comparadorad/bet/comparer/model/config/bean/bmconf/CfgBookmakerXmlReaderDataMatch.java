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
 * The Class CfgBookmakerXmlReaderDataMatch.
 */
public class CfgBookmakerXmlReaderDataMatch extends
		AbstractCfgBookmakerXmlReaderData {

	/** The Constant PERCENTIL. */
	public static final String PERCENTIL = "PERCENTIL";

	/** The Constant XML_LIVE_ID_PARAM. */
	public static final String XML_LIVE_ID_PARAM = "liveId";

	/** The Constant XML_LIVE_PARAM. */
	public static final String XML_LIVE_PARAM = "live";

	/** The Constant XML_PARTICIPIANS_IN_NAME_PARAM. */
	public static final String XML_PARTICIPANTS_IN_NAME_PARAM = "participantsInName";

	/** The Constant XML_PARTICIPIANS_NAME_TYPE. */
	public static final String XML_PARTICIPANTS_NAME_TYPE = "participantsNameType";

	/** The Constant XML_PARTICIPIANS_SEPARATOR. */
	public static final String XML_PARTICIPANTS_SEPARATOR = "participantsSeparator";

	/** The Constant XML_START_DATE_PARAM. */
	public static final String XML_START_DATE_PARAM = "startDate";

	/** The Constant XML_STREAMING_PARAM. */
	public static final String XML_STREAMING_PARAM = "streaming";

	/**
	 * Instantiates a new cfg bookmaker xml reader data match.
	 */
	public CfgBookmakerXmlReaderDataMatch() {
		super("XmlMatch");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data match.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataMatch(String pNodeName) {
		super(pNodeName, "XmlMatch");
	}

	/**
	 * Gets the live id param.
	 * 
	 * @return the live id param
	 */
	public CfgBookmakerXmlReaderParam getLiveIdParam() {
		return getXmlReaderConfigDataParameter(XML_LIVE_ID_PARAM);
	}

	/**
	 * Gets the live param.
	 * 
	 * @return the live param
	 */
	public CfgBookmakerXmlReaderParam getLiveParam() {
		return getXmlReaderConfigDataParameter(XML_LIVE_PARAM);
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
	 * Gets the participants name type param.
	 * 
	 * @return the participants name type param
	 */
	public CfgBookmakerXmlReaderParam getParticipantsNameTypeParam() {
		return getXmlReaderConfigDataParameter(XML_PARTICIPANTS_NAME_TYPE);
	}

	/**
	 * Gets the participants separator param.
	 * 
	 * @return the participants separator param
	 */
	public CfgBookmakerXmlReaderParam getParticipiansSeparatorParam() {
		return getXmlReaderConfigDataParameter(XML_PARTICIPANTS_SEPARATOR);
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
	 * Gets the streaming param.
	 * 
	 * @return the streaming param
	 */
	public CfgBookmakerXmlReaderParam getStreamingParam() {
		return getXmlReaderConfigDataParameter(XML_STREAMING_PARAM);
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
	 * Sets the live id param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new live id xml attribute name
	 * @param xmlNodeName
	 *            the new live id xml node name
	 */
	public void setLiveIdParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_LIVE_ID_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}

	/**
	 * Sets the live param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new live xml attribute name
	 * @param xmlNodeName
	 *            the new live xml node name
	 */
	public void setLiveParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_LIVE_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
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
	 * Sets the participants name type param.
	 * 
	 * @param xmlExtraInfoParam
	 *            the new participants name type param
	 */
	public void setParticipantsNameTypeParam(final String xmlExtraInfoParam) {
		addXmlReaderConfigDataParameter(XML_PARTICIPANTS_NAME_TYPE,
				xmlExtraInfoParam);
	}

	/**
	 * Sets the participants name type param percentil.
	 */
	public void setParticipantsNameTypeParamPercentil() {
		addXmlReaderConfigDataParameter(XML_PARTICIPANTS_NAME_TYPE, PERCENTIL);
	}

	/**
	 * Sets the participants separator param.
	 * 
	 * @param xmlExtraInfoParam
	 *            the new participants separator param
	 */
	public void setParticipantsSeparatorParam(final String xmlExtraInfoParam) {
		addXmlReaderConfigDataParameter(XML_PARTICIPANTS_SEPARATOR,
				xmlExtraInfoParam);
	}

	/**
	 * Sets the participants in name param.
	 * 
	 * @param xmlExtraInfoParam
	 *            the new participants in name param
	 */
	private void setParticipiantsInNameParam(final String xmlExtraInfoParam) {
		addXmlReaderConfigDataParameter(XML_PARTICIPANTS_IN_NAME_PARAM,
				xmlExtraInfoParam);
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

	/**
	 * Sets the streaming param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new streaming xml attribute name
	 * @param xmlNodeName
	 *            the new streaming xml node name
	 */
	public void setStreamingParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_STREAMING_PARAM, xmlAttributeName,
				xmlNodeName, dataLocation);
	}
}