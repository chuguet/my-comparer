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
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.repository.CfgSportSynonymsRepository;

/**
 * The Class CfgSportSynonymsRepositoryTest.
 */

public class CfgSportSynonymsRepositoryTest extends
		AbstractConfigRepositoryTest<CfgSportSynonymsRepository> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgSportSynonymsRepositoryTest.class);

	/** The synonyms word repository. */
	@Inject
	private CfgSportSynonymsRepository cfgSportSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgSportSynonymsRepository getCrudRepository() {
		return cfgSportSynonymsRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgSportSynonyms cfgSportSynonyms = new CfgSportSynonyms();
		return cfgSportSynonyms;
	}

	/**
	 * Test find syns by sport name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgSportSynonyms> synonyms = cfgSportSynonymsRepository
				.customFindByname("Futbol");
		LOG.info("CfgSportSynonyms found: " + synonyms.get(0).toString());
		assertNotNull(synonyms.get(0));
		assertEquals(BigInteger.ONE, synonyms.get(0).getObjectId());
		// assertEquals("Fútbol", synonyms.get(0).getSynonimWords().get(0)
		// .getWord());
		assertTrue(synonyms.get(0).containsSynonimWord("Futbol"));

	}

	/**
	 * Test custom find all.
	 */
	@Test
	public void testCustomFindAll() {
		List<CfgSportSynonyms> synonyms = cfgSportSynonymsRepository
				.customFindAll();

		assertTrue(synonyms.size() > 1);
	}

}
