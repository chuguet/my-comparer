/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

/**
 * The Class CfgBookmakerXmlReaderDataTournament.
 */
public class CfgBookmakerXmlReaderDataTournament extends
		AbstractCfgBookmakerXmlReaderData {

	/**
	 * Instantiates a new cfg bookmaker xml reader data tournament.
	 */
	public CfgBookmakerXmlReaderDataTournament() {
		super("XmlTournament");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data tournament.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataTournament(String pNodeName) {
		super(pNodeName, "XmlTournament");
	}
}