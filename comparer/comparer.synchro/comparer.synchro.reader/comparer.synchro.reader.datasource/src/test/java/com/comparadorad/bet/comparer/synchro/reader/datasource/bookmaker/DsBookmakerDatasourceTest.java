/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.bookmaker;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.synchro.reader.datasource.AbstractSynchroReaderDatasourceTest;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class DsBookmakerDatasourceTest.
 */
public final class DsBookmakerDatasourceTest extends
		AbstractSynchroReaderDatasourceTest {

	/** The ds bookmaker datasource. */
	@Inject
	private DsBookmakerDatasource dsBookmakerDatasource;

	/**
	 * Test get xml data files.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */
	@Test
	public void testGetXmlDataFiles() throws IOException, XmlNotFoundException {
		// TODO TEST
		CfgBookmaker bookmaker = new CfgBookmaker();
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration
				.addBookmakerDataUrl(new CfgBookmakerDataUrl(
						"http://xml.betclick.com/odds_en.xml"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		dsBookmakerDatasource.getXmlDataFiles(bookmaker);
	}
}
