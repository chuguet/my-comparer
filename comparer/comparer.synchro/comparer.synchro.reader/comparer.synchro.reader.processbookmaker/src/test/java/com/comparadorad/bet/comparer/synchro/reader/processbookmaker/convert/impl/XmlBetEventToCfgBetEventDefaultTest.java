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

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventExpekt;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeExpekt;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlBetEventToCfgBetEventDefaultTest.
 */
public class XmlBetEventToCfgBetEventDefaultTest extends AbstractTest {

	/** The xml bet event to cfg bet event default. */
	@Inject
	private XmlBetEventToCfgBetEventDefault xmlBetEventToCfgBetEventDefault;

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
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.UNO_X_DOS);
		xmlBetType
				.setXmlBetEvent(new XmlBetEvent(BetEventBetClick.PRIMERA_PARTE));

		RtBetTypeEvent result = new RtBetTypeEvent();
		result = (RtBetTypeEvent) xmlBetEventToCfgBetEventDefault.convert(null,
				xmlBetType, null, null, new CfgBookmaker("19"), null, null);
		assertNotNull(result);
		assertTrue(result.getBetTypeEvent().getNameId()
				.equals(CfgBetTypeEventId.PRIMERA_PARTE.nameId()));

	}

	/**
	 * Test partido completo.
	 */
	@Test
	public void testPartidoCompleto() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeBetClick.UNO_X_DOS);
		xmlBetType.setXmlBetEvent(new XmlBetEvent(
				BetEventBetClick.PARTIDO_COMPLETO));

		RtBetTypeEvent result = new RtBetTypeEvent();
		result = (RtBetTypeEvent) xmlBetEventToCfgBetEventDefault.convert(null,
				xmlBetType, null, null, new CfgBookmaker("19"), null, null);
		assertNotNull(result);
		assertTrue(result.getBetTypeEvent().getNameId()
				.equals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId()));

	}

	/**
	 * Sin evento de apuesta
	 */
	@Test
	public void testSinEventoApuesta() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeExpekt.UNO_X_DOS);
		
		RtBetTypeEvent result = new RtBetTypeEvent();
		result = (RtBetTypeEvent) xmlBetEventToCfgBetEventDefault.convert(null,
				xmlBetType, null, null, new CfgBookmaker("19"), null, null);
		assertNotNull(result);
		assertTrue(result.getBetTypeEvent().getNameId()
				.equals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId()));

	}

	/**
	 * Test segunda parte.
	 */
	@Test
	public void testSegundaParte() {
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setBetType(BetTypeExpekt.UNO_X_DOS);
		xmlBetType
				.setXmlBetEvent(new XmlBetEvent(BetEventExpekt.SEGUNDA_PARTE));

		RtBetTypeEvent result = new RtBetTypeEvent();
		result = (RtBetTypeEvent) xmlBetEventToCfgBetEventDefault.convert(null,
				xmlBetType, null, null, new CfgBookmaker("19"), null, null);
		assertNotNull(result);
		assertTrue(result.getBetTypeEvent().getNameId()
				.equals(CfgBetTypeEventId.SEGUNDA_PARTE.nameId()));

	}

	

}
