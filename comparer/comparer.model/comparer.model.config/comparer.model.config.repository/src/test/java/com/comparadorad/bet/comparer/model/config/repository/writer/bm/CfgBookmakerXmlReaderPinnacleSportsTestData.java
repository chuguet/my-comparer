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
 * The Class CfgBookmakerXmlReaderPinnacleSportsTestData.
 */
public class CfgBookmakerXmlReaderPinnacleSportsTestData implements
		ICfgBookmakerXmlReaderTestData {

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader {@inheritDoc}
	 */
	@Override
	public CfgBookmakerXmlReader getCfgBookmakerXmlReader() {

		// General remarks about the configuaration of PinnacleSports:
		// The node "pinnacle_line_feed/PinnacleFeedTime" is considered
		// redundant
		// The node "pinnacle_line_feed/lastContest" is considered redundant
		// The node "pinnacle_line_feed/lastGame" is considered redundant
		// The node
		// "/pinnacle_line_feed/events/event/participants/participant/rotnum" is
		// considered redundant

		CfgBookmakerXmlReader cfgBookmakerXmlReader = new CfgBookmakerXmlReader();
		cfgBookmakerXmlReader.setXmlReaderConfigDateFormat("yyyy-MM-dd HH:mm");
		cfgBookmakerXmlReader
				.setCfgBookmakerXmlReaderTimeZoneFormat(TimeZoneConstants.GMT_0);

		cfgBookmakerXmlReader.setXmlMarketBetEnabled(true);

		return cfgBookmakerXmlReader;
	}

}
