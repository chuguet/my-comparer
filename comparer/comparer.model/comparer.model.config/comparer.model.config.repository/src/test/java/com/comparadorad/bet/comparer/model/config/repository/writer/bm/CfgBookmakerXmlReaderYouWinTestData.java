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
 * The Class CfgBookmakerXmlReaderYouWinTestData.
 */
public class CfgBookmakerXmlReaderYouWinTestData implements
		ICfgBookmakerXmlReaderTestData {

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader {@inheritDoc}
	 */

	@Override
	public CfgBookmakerXmlReader getCfgBookmakerXmlReader() {

		// General remarks about the configuaration of YouWin:
		// The attributes "date_format" and "timezone" in node "/odds"
		// are considered redundant
		// The attributes "priceup" and "pricedown" in node
		// "/odds/sport/region/group/event/bet/selection" are considered
		// redundant

		CfgBookmakerXmlReader cfgBookmakerXmlReader = new CfgBookmakerXmlReader();
		cfgBookmakerXmlReader
				.setXmlReaderConfigDateFormat("yyyy/MM/dd HH:mm:ss");
		cfgBookmakerXmlReader
				.setCfgBookmakerXmlReaderTimeZoneFormat(TimeZoneConstants.GMT_0);

		return cfgBookmakerXmlReader;
	}

}
