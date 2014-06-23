/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer.bm;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;

/**
 * The Class CfgBookmakerXmlReaderBetClickTestData.
 */
public class CfgBookmakerXmlReaderExpekTestData implements
		ICfgBookmakerXmlReaderTestData {

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader {@inheritDoc}
	 */
	@Override
	public CfgBookmakerXmlReader getCfgBookmakerXmlReader() {

		CfgBookmakerXmlReader cfgBookmakerXmlReader = new CfgBookmakerXmlReader();

		return cfgBookmakerXmlReader;
	}

}