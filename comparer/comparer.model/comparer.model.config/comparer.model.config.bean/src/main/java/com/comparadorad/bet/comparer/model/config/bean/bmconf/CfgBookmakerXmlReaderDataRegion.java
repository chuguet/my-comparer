/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

/**
 * The Class CfgBookmakerXmlReaderDataRegion.
 */
public class CfgBookmakerXmlReaderDataRegion extends
		AbstractCfgBookmakerXmlReaderData {

	/**
	 * Instantiates a new cfg bookmaker xml reader data region.
	 */
	public CfgBookmakerXmlReaderDataRegion() {
		super("XmlRegion");
	}

	/**
	 * Instantiates a new cfg bookmaker xml reader data region.
	 * 
	 * @param pNodeName
	 *            the node name
	 */
	public CfgBookmakerXmlReaderDataRegion(String pNodeName) {
		super(pNodeName, "XmlRegion");
	}

}