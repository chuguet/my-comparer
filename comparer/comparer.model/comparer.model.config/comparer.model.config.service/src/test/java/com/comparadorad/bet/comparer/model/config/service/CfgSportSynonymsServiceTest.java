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
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgSportSynonymsServiceTest.
 */
public class CfgSportSynonymsServiceTest extends
		AbstractServiceTest<CfgSportSynonyms> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgSportSynonymsServiceTest.class);

	/** The sport type service. */
	@Inject
	private ICfgSportSynonymsService cfgSportSynonymsWordService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgSportSynonyms> getIGenericService() {
		return cfgSportSynonymsWordService;
	}

	/**
	 * Test find syns by sport name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgSportSynonyms> sportSynonims = cfgSportSynonymsWordService
				.customFindByname("Futbol");

		LOG.info("CfgSportSynonyms found: " + sportSynonims.get(0).toString());

		assertNotNull(sportSynonims.get(0));
		assertEquals(new BigInteger("1"), sportSynonims.get(0).getObjectId());
		assertTrue(sportSynonims.get(0).containsSynonimWord("Futbol"));
		assertTrue(sportSynonims.get(0).containsSynonimWord("Football"));
		assertTrue(sportSynonims.get(0).containsSynonimWord("Soccer"));
	}

	/**
	 * Test custom find all.
	 */
	@Test
	public void testCustomFindAll() {
		List<CfgSportSynonyms> sportSynonims = cfgSportSynonymsWordService
				.customFindAll();

		assertNotNull(sportSynonims);
		assertTrue(sportSynonims.size() > 1);

	}

}
