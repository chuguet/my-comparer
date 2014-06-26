/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetOddNotFoundException;

/**
 * The Class XmlMarketBetOddToXmlMarketBetOddTest.
 */
public class XmlMarketBetOddToXmlMarketBetOddTest extends AbstractTest {

	/** The xml market bet odd to xml market bet odd. */
	@Inject
	private XmlMarketBetOddToXmlMarketBetOdd xmlMarketBetOddToXmlMarketBetOdd;

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void test() {
		XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd("1.2");
		RtBetOdd result = new RtBetOdd();
		result = (RtBetOdd) xmlMarketBetOddToXmlMarketBetOdd.convert(null,
				xmlMarketBetOdd, null, null);
		assertNotNull(result);
		assertTrue(result.getOdds().equals("1.2"));
	}

	/**
	 * Test mal informado.
	 */
	@Test
	public void testMalInformado() {
		RtBetOdd result = new RtBetOdd();
		try {
			result = (RtBetOdd) xmlMarketBetOddToXmlMarketBetOdd.convert(null,
					"objeto", null, null);
			fail("No se han informado de los valores de la apuesta");
		} catch (BetOddNotFoundException e) {
			e.getMessage();
		}
	}

}
