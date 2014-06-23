/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;

/**
 * The Class CfgBetTypeRepositoryTest.
 */

public class CfgBetTypeEventRepositoryTest extends
		AbstractConfigRepositoryTest<CfgBetTypeEventRepository> {

	/** The sport type repository. */
	@Inject
	private CfgBetTypeEventRepository cfgBetTypeEventRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgBetTypeEventRepository getCrudRepository() {
		return cfgBetTypeEventRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgBetTypeEvent betTypeEvent = new CfgBetTypeEvent();
		betTypeEvent.setObjectId("100");
		betTypeEvent.setName("Cien Minutos");
		betTypeEvent.setNameId("CIEN_MINUTOS");
		betTypeEvent.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		betTypeEvent.setOrder(new Order(new Integer(1000)));
		return betTypeEvent;
	}
	
	@Test
	public void getBetTypeEventTest() {
		CfgBetTypeEvent result = cfgBetTypeEventRepository.findOne(new BigInteger("5"));
		assertNotNull(result);
		assertNotNull(result.getCoreActiveElement());
		assertNotNull(result.getCoreActiveElement().getActive());
		assertTrue(result.getCoreActiveElement().getActive());
		assertNotNull(result.getNameId());
		assertEquals("TREINTA_MINUTOS", result.getNameId());
		assertNotNull(result.getObjectId());
		assertEquals(new BigInteger("5"), result.getObjectId());
		assertNotNull(result.getOrder());
		assertNotNull(result.getOrder().getPriority());
		assertEquals(new Integer(120), result.getOrder().getPriority());
		assertEquals("Treinta Minutos", result.getI18n().getI18nField(null).getString());
	}

}
