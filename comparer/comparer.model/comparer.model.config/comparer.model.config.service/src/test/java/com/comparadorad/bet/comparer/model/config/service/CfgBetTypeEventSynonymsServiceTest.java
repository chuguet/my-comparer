/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgBetTypeSynonymsServiceTest.
 */
public class CfgBetTypeEventSynonymsServiceTest extends
		AbstractServiceTest<CfgBetTypeEventSynonyms> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CfgBetTypeEventSynonymsServiceTest.class);

	/** The sport type service. */
	@Inject
	private ICfgBetTypeEventSynonymsService cfgBetTypeEventSynonymsWordService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgBetTypeEventSynonyms> getIGenericService() {
		return cfgBetTypeEventSynonymsWordService;
	}

	/**
	 * Test find syns by betType name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgBetTypeEventSynonyms> listBetTypeEvent = cfgBetTypeEventSynonymsWordService
				.customFindByname("Handicap Result");

		LOG.info("CfgBetTypeSynonyms found: "
				+ listBetTypeEvent.get(0).getObjectId().toString());

		assertNotNull(listBetTypeEvent.get(0));
		assertEquals(BigInteger.ONE, listBetTypeEvent.get(0).getObjectId());

	}
}