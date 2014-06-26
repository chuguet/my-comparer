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

import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgSportSynonymsServiceTest.
 */
public class CfgRegionSynonymsServiceTest extends
		AbstractServiceTest<CfgRegionSynonyms> {

	public static final Log LOG = LogFactory
			.getLog(CfgRegionSynonymsServiceTest.class);

	/** The sport type service. */
	@Inject
	private ICfgRegionSynonymsService cfgRegionSynonymsWordService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgRegionSynonyms> getIGenericService() {
		return cfgRegionSynonymsWordService;
	}

	/**
	 * Test find syns by sport name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgRegionSynonyms> RegionSyn = cfgRegionSynonymsWordService
				.customFindByname("Europa");

		LOG.info("CfgRegionSynonyms found: " + RegionSyn.get(0).toString());

		assertNotNull(RegionSyn.get(0));
		assertEquals(new BigInteger("3"), RegionSyn.get(0).getObjectId());
		// assertEquals("Fútbol",
		// SportSyn.get(0).getSynonimWords().get(0).getWord());
		assertTrue(RegionSyn.get(0).containsSynonimWord("Europa"));
		
	}

}
