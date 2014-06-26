/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetFred;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetTypeException;

/**
 * The Class XmlBetTypeToCfgBetTypeTest.
 */
public class XmlBetTypeToCfgBetTypeTest extends AbstractTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlBetTypeToCfgBetTypeTest.class);

	/** The xml bet type to cfg bet type. */
	@Inject
	private XmlBetTypeToCfgBetType xmlBetTypeToCfgBetType;

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void test() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.UNO_X_DOS);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

	/**
	 * Test ganador.
	 */
	@Test
	public void testGanador() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.GANADOR);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

	/**
	 * Test ganador partido.
	 */
	@Test
	public void testGanadorPartido() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.GANADOR_PARTIDO);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

	/**
	 * Test handicap1x2.
	 */
	@Test
	public void testHandicap1x2() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.UNO_X_DOS_HANDICAP);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

	/**
	 * Test handicap asiatico.
	 */
	@Test
	public void testHandicapAsiatico() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.HANDICAP_ASIATICO);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

	/**
	 * Test mas menos.
	 */
	@Test
	public void testMasMenos() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.MAS_MENOS);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

	/**
	 * Test maximo goleador.
	 */
	@Test
	public void testMaximoGoleador() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetFred.MAXIMO_GOLEADOR);
		assertNotNull(xmlBetTypeToCfgBetType.convert(null, xmlBetType, null,
				null));
	}

//	/**
//	 * Test sin apuesta.
//	 */
//	@Test
//	public void testSinApuesta() {
//		XmlBetType xmlBetType = new XmlBetType();
//		try {
//			xmlBetTypeToCfgBetType.convert(null, xmlBetType, null, null);
//			fail("The convert must be fail");
//		} catch (BetTypeException e) {
//			LOG.info(e.getMessage());
//		}
//	}

}
