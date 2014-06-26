/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlSportToCfgSportTest.
 */
public class XmlSportToCfgSportTest extends AbstractTest {

	/** The xml sport to cfg sport. */
	@Inject
	private XmlSportToCfgSport xmlSportToCfgSport;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	@Test
	public void test() {
		XmlSport xmlSport = new XmlSport("Futbol");
		CfgSport result = new CfgSport();
		result = (CfgSport) xmlSportToCfgSport.convert(null, xmlSport, null,
				null);

	}

	/**
	 * Test no encontrado.
	 */
	@Test
	public void testNoEncontrado() {
		XmlSport xmlSport = new XmlSport("deporte inventado");
		CfgSport result = new CfgSport();
		try {
			result = (CfgSport) xmlSportToCfgSport.convert(null, xmlSport,
					null, null);
		} catch (Exception e) {
			assertTrue(result.getName(null) == null);
		}

	}

	/**
	 * Test mal informado.
	 */
	@Test
	public void testMalInformado() {
		CfgSport result = new CfgSport();
		try {
			result = (CfgSport) xmlSportToCfgSport.convert(null, "objeto",
					null, null);
		} catch (Exception e) {
			assertTrue(result.getName(null) == null);
		}
	}
	
	@Test
	public void testNoConfigurado() {
		XmlSport xmlSport = new XmlSport("Ski");
		CfgSport result = new CfgSport();
		try {
			result = (CfgSport) xmlSportToCfgSport.convert(null, xmlSport,
					null, null);
		} catch (Exception e) {
			assertTrue(result.getName(null) == null);
		}
	}

}
