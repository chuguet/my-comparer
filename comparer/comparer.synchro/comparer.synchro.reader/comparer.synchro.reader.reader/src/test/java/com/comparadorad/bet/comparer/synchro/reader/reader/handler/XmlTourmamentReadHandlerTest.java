/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlSportReadHandlerTest.
 */
public class XmlTourmamentReadHandlerTest extends AbstractReadHandlerTest {

	/**
	 * Test process.
	 * 
	 * @throws XmlReaderException
	 *             the xml reader exception
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testProcess() throws XmlReaderException,
			XmlDataFileReaderException {

//		String idbookmaker = "BetAtClick";
//
//		AbstractXmlData abstractXmlData = getXmlReadHandler(idbookmaker,
//				"/sports/sport/event").process(readXsom(idbookmaker), null);
//		assertTrue(abstractXmlData instanceof XmlTournament);
	}
}
