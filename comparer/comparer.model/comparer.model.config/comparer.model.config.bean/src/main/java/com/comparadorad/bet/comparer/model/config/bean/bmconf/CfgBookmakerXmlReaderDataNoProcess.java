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
@SuppressWarnings("serial")
public class CfgBookmakerXmlReaderDataNoProcess extends
		AbstractCfgBookmakerXmlReaderData {

	/**
	 * Instantiates a new cfg bookmaker xml reader data tournament.
	 */
	public CfgBookmakerXmlReaderDataNoProcess() {
		super(null);
		setEmptyReader(true);
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data tournament.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataNoProcess(String pNodeName) {
		super(pNodeName, null);
		setEmptyReader(true);
	}
}