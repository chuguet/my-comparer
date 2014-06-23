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
 * The Class CfgBookmakerXmlReaderDataMatchParticipant.
 */
public class CfgBookmakerXmlReaderDataMatchParticipant extends
		AbstractCfgBookmakerXmlReaderData {

	/** role can be 1 (home team) or 2 (away team). */
	public static final String XML_MATCH_PARTICIPANT_ROLE_PARAM = "role";

	/**
	 * Instantiates a new cfg bookmaker xml reader match participant.
	 */
	public CfgBookmakerXmlReaderDataMatchParticipant() {
		super("XmlMatchParticipant");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data match participant.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataMatchParticipant(String pNodeName) {
		super(pNodeName, "XmlMatchParticipant");
	}

	/**
	 * Gets the role param.
	 * 
	 * @return the role param
	 */
	public CfgBookmakerXmlReaderParam getRoleParam() {
		return getXmlReaderConfigDataParameter(XML_MATCH_PARTICIPANT_ROLE_PARAM);
	}

	/**
	 * Sets the role param.
	 * 
	 * @param dataLocation
	 *            the new dataLocation param
	 * @param xmlAttributeName
	 *            the new role xml attribute name
	 * @param xmlNodeName
	 *            the new role xml node name
	 */
	public void setRoleParam(final DataLocation dataLocation,
			final String xmlAttributeName, final String xmlNodeName) {
		addXmlReaderConfigDataParameter(XML_MATCH_PARTICIPANT_ROLE_PARAM,
				xmlAttributeName, xmlNodeName, dataLocation);
	}

}