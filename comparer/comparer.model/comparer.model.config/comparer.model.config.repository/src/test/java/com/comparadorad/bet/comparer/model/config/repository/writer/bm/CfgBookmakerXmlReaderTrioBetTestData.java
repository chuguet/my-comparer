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
 * The Class CfgBookmakerXmlReaderTrioBetClickTestData.
 */
public class CfgBookmakerXmlReaderTrioBetTestData implements
		ICfgBookmakerXmlReaderTestData {

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader {@inheritDoc}
	 */
	@Override
	public CfgBookmakerXmlReader getCfgBookmakerXmlReader() {

		// General remarks about the configuaration of TrioBet:
		// The node "Odds/Game/BreadCrumbs" is considered redundant
		// The node "/Odds/Game/OutcomeSet/ExternalComment" is considered
		// redundant
		// The attribute "info" in node "/Odds/Game/Participant" is considered
		// redundant

		CfgBookmakerXmlReader cfgBookmakerXmlReader = new CfgBookmakerXmlReader();
		cfgBookmakerXmlReader.setXmlReaderConfigDateFormat("yyyy-MM-dd HH:mm",
				new String[] { "EEST" });
		cfgBookmakerXmlReader
				.setCfgBookmakerXmlReaderTimeZoneFormat(TimeZoneConstants.GMT_0);

		return cfgBookmakerXmlReader;
	}

}
