/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.model.config.repository.writer.bm.CfgBookmakerXmlReaderTrioBetTestData;
import com.comparadorad.bet.comparer.model.config.repository.writer.bm.ICfgBookmakerXmlReaderTestData;

/**
 * The Class AbstractXmlBetFileReaderServiceTest.
 */

public class XmlBetFileReaderServiceTrioBetTest extends
		AbstractXmlBetFileReaderServiceTest {

	/**
	 * Do xml equal assertion.
	 * 
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	protected boolean doXmlEqualAssertion() {
		return false;
	}

	/**
	 * Gets the bookmaker name.
	 * 
	 * @return the bookmaker name {@inheritDoc}
	 */
	@Override
	protected String getBookmakerName() {
		return "TrioBet";
	}

	/**
	 * Gets the cfg bookmaker xml reader.
	 * 
	 * @return the cfg bookmaker xml reader {@inheritDoc}
	 */
	@Override
	protected CfgBookmakerXmlReader getCfgBookmakerXmlReader() {

		ICfgBookmakerXmlReaderTestData result = new CfgBookmakerXmlReaderTrioBetTestData();
		return result.getCfgBookmakerXmlReader();
	}
}
