/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer.bm;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.util.commons.date.TimeZoneConstants;

/**
 * The Class CfgBookmakerXmlReaderNoxWinTestData.
 */
public class CfgBookmakerXmlReaderNoxWinTestData implements
		ICfgBookmakerXmlReaderTestData {

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader {@inheritDoc}
	 */

	@Override
	public CfgBookmakerXmlReader getCfgBookmakerXmlReader() {

		// General remarks about the configuaration of NoxWin:
		// The attribute "feedtime" in node "/Odds" is considered redundant

		CfgBookmakerXmlReader cfgBookmakerXmlReader = new CfgBookmakerXmlReader();
		cfgBookmakerXmlReader.setXmlReaderConfigDateFormat("yyyy-MM-dd");
		cfgBookmakerXmlReader
				.setCfgBookmakerXmlReaderTimeZoneFormat(TimeZoneConstants.GMT_0);

		cfgBookmakerXmlReader.setXmlMarketBetEnabled(true);

		return cfgBookmakerXmlReader;
	}

}
