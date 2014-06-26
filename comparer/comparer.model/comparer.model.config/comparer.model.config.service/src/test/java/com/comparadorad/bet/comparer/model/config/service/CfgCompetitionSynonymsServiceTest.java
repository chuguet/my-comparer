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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgCompetitionSynonymsServiceTest.
 */
public class CfgCompetitionSynonymsServiceTest extends
		AbstractServiceTest<CfgCompetitionSynonyms> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgCompetitionSynonymsServiceTest.class);

	/** The competition type service. */
	@Inject
	private ICfgCompetitionSynonymsService cfgCompetitionSynonymsWordService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgCompetitionSynonyms> getIGenericService() {
		return cfgCompetitionSynonymsWordService;
	}

	/**
	 * Test custom: find syns by Competition name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgCompetitionSynonyms> comSyn = cfgCompetitionSynonymsWordService
				.customFindByname("Spain League");

		LOG.info("CfgCompetitionSynonyms found: " + comSyn.get(0).toString());

		assertNotNull(comSyn.get(0));
		assertEquals(new BigInteger("1"), comSyn.get(0).getObjectId());
		assertEquals("Spain League", comSyn.get(0).getSynonimWords().get(1)
				.getWord());
		assertEquals("La Liga 2012/13", comSyn.get(0).getSynonimWords().get(2)
				.getWord());
	}

	/**
	 * Test custom find all.
	 */
	@Test
	public void testCustomFindAll() {
		List<CfgCompetitionSynonyms> comSyn = cfgCompetitionSynonymsWordService
				.customFindAll();
		assertNotNull(comSyn);
		assertTrue(comSyn.size() > 0);

	}
	
	@Test
	public void testCustomFindAllTournament() {
		String competitionName = "Premier League";
		BigInteger sportId = new BigInteger("1");
		List<CfgCompetitionSynonyms> comSyn = cfgCompetitionSynonymsWordService
				.customFindAllTournament(competitionName, sportId);
		
		assertNotNull(comSyn);
		assertTrue(comSyn.size() > 0);
		
		sportId = new BigInteger("666");
		comSyn = cfgCompetitionSynonymsWordService
				.customFindAllTournament(competitionName, sportId);
		
		assertTrue(comSyn.size() == 0);
	}
}
