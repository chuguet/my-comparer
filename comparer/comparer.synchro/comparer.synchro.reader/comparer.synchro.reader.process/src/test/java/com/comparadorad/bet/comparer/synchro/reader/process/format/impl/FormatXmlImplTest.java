/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.format.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.process.format.xml.IFormatXML;

/**
 * The Class FormatXmlImplTest.
 */
public class FormatXmlImplTest extends AbstractTest {

	/** The format xml. */
	@Inject
	private IFormatXML formatXML;

	/** {@inheritDoc} */
	@Override
	@Test
	public void test() {
		XmlMatch xmlMatch = new XmlMatch();
		List<XmlMarket> markets = new ArrayList<XmlMarket>();
		XmlMarket xmlMarket = new XmlMarket();
		xmlMatch.setName(" a ");
		xmlMarket.setName(" b");
		markets.add(xmlMarket);
		xmlMatch.setXmlMarkets(markets);
		xmlMatch = formatXML.format(xmlMatch);
		assertEquals(xmlMatch.getName(), "A");
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			assertEquals(market.getName(), "B");
		}

	}

}
