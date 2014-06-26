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

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlDateToCoreDateTest.
 */
public class XmlDateToCoreDateTest extends AbstractTest {

	/** The xml date to core date. */
	@Inject
	private XmlDateToCoreDate xmlDateToCoreDate;

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void test() {
		XmlDate xmlDate = new XmlDate(new Date(), "GMT", new Date());
		CoreDate result = new CoreDate();
		result = (CoreDate) xmlDateToCoreDate
				.convert(null, xmlDate, null, null);
		assertNotNull(result);
		assertTrue(result.getProviderDate() != null);
		assertTrue(result.getProviderTimeZone() != null);
		assertTrue(result.getZeroGmtMatchDate() != null);
		assertTrue(result.getZeroGmtMatchTimeZone() != null);
	}

	/**
	 * Test mal informado.
	 */
	@Test
	public void testMalInformado() {
		CoreDate result = new CoreDate();
		try {
			result = (CoreDate) xmlDateToCoreDate.convert(null, "objeto", null,
					null);
		} catch (Exception e) {
			assertTrue(result.getProviderDate() == null);
		}
	}

}
