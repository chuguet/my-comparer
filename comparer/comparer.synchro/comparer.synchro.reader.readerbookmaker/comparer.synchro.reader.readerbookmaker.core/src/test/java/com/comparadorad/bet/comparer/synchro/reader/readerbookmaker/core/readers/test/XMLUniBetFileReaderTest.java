/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.unibet.XMLUniBetFileReader;

/**
 * The Class XMLUniBetFileReaderTest.
 */
public class XMLUniBetFileReaderTest extends AbstractTest {

	/** The bet click reader. */
	@Inject
	private XMLUniBetFileReader unibetReader;

	@Test
	public void test() {
		
	}
	
	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
//	@Test
//	public void getBookmakerIdTest() {
//		assertNotNull(unibetReader.getBookmakerId());
//		assertEquals(unibetReader.getBookmakerId(),
//				CfgBookmakerId.UNIBET_COM_ID.objectId().toString());
//	}

	/**
	 * Unibet read big test. Está comentado porque en ocasiones no pasa por
	 * memoria.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	// @Test
	// public void unibetReadBigTest() throws Exception {
	// CfgBookmakerConfiguration bookmakerConfiguration = new
	// CfgBookmakerConfiguration();
	// bookmakerConfiguration.setTimeZone(UNIBET_TIMEZONE);
	// XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(UNIBET_READER,
	// UNIBET_XML_LOCATION_BIG, bookmakerConfiguration);
	// Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents()
	// .getXmlMatchs().size() > 0);
	// }

	/**
	 * Unibet read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
//	@Test
//	public void unibetReadTest() throws Exception {
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		bookmakerConfiguration.setTimeZone(UNIBET_TIMEZONE);
//		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(UNIBET_READER,
//				UNIBET_XML_LOCATION, bookmakerConfiguration, null);
//		Collection<XmlMatch> result = xmlrBetFileReaderResult
//				.getXmlBookmakerEvents().getXmlMatchs();
//		Assert.isTrue(result.size() > 0);
//		for (XmlMatch sport : result) {
//			if (sport.getName().equals("UEFA Champions League 2012/2013")) {
//				assertEquals(sport.getXmlTournament().getName(),
//						"Champions League");
//				for (XmlMarket market : sport.getXmlMarkets()) {
//					if (market.getXmlBetType().getBetType().toString()
//							.equals("MAS_MENOS")) {
//						assertEquals(market.getXmlMarketBets().size(), 2);
//					}
//				}
//			}
//		}
//	}
}
