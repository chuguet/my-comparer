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

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgParticipantSynonymsServiceTest.
 */
public class CfgParticipantSynonymsServiceTest extends
		AbstractServiceTest<CfgParticipantSynonyms> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgParticipantSynonymsServiceTest.class);

	/** The team type service. */
	@Inject
	private ICfgParticipantSynonymsService cfgParticipantSynonymsWordService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgParticipantSynonyms> getIGenericService() {
		return cfgParticipantSynonymsWordService;
	}

	/**
	 * Test custom: find syns by team name.
	 */
	@Test
	public void testCustomFindByNameTest() {

		List<CfgParticipantSynonyms> teamSyn = cfgParticipantSynonymsWordService
				.customFindByname("Barça");

		if (teamSyn != null && teamSyn.size() > 0) {
			LOG.info("CfgParticipantSynonyms found: "
					+ teamSyn.get(0).toString());
			assertNotNull(teamSyn);
			assertEquals(new BigInteger("1"), teamSyn.get(0).getObjectId());
			assertEquals("F.C. Barcelona", teamSyn.get(0).getSynonimWords()
					.get(0).getWord());
			assertEquals("FC Barcelona", teamSyn.get(0).getSynonimWords()
					.get(1).getWord());
			assertEquals("Barça", teamSyn.get(0).getSynonimWords().get(2)
					.getWord());
			assertEquals("Barcelona", teamSyn.get(0).getSynonimWords().get(3)
					.getWord());
		}

	}

	/**
	 * Test custom find by name error test.
	 */
	@Test
	public void testCustomFindByNameErrorTest() {
		List<CfgParticipantSynonyms> teamSyn = cfgParticipantSynonymsWordService
				.customFindByname("XXXX");

		assertTrue(teamSyn.size() == 0);

	}

	/**
	 * Test custom find by team name competition name test.
	 */
	@Test
	public void testCustomFindByTeamNameCompetitionNameTest() {
		List<CfgParticipantSynonyms> teamSyn = cfgParticipantSynonymsWordService
				.customFindByTeamNameCompetitionName("Barça", new BigInteger(
						"1"));

		if (teamSyn != null && teamSyn.size() > 0) {
			LOG.debug("CfgParticipantSynonyms found: "
					+ teamSyn.get(0).toString());
			assertNotNull(teamSyn);
			assertEquals(new BigInteger("1"), teamSyn.get(0).getObjectId());
			assertEquals("F.C. Barcelona", teamSyn.get(0).getSynonimWords()
					.get(0).getWord());
			assertEquals("FC Barcelona", teamSyn.get(0).getSynonimWords()
					.get(1).getWord());
			assertEquals("Barça", teamSyn.get(0).getSynonimWords().get(2)
					.getWord());
			assertEquals("Barcelona", teamSyn.get(0).getSynonimWords().get(3)
					.getWord());
		}
	}

	/**
	 * Test custom find by team name competition name error test.
	 */
	@Test
	public void testCustomFindByTeamNameCompetitionNameErrorTest() {
		List<CfgParticipantSynonyms> teamSyn = cfgParticipantSynonymsWordService
				.customFindByTeamNameCompetitionName("XXXX",
						new BigInteger("1"));
		assertTrue(teamSyn.size() == 0);

	}

	/**
	 * Test custom find by team name sport name test.
	 */
	@Test
	public void testCustomFindByTeamNameSportNameTest() {
		List<CfgParticipantSynonyms> teamSyn = cfgParticipantSynonymsWordService
				.customFindByTeamNameSportName("Barça", new BigInteger("1"));

		if (teamSyn != null && teamSyn.size() > 0) {
			LOG.debug("CfgParticipantSynonyms found: "
					+ teamSyn.get(0).toString());
			assertNotNull(teamSyn);
			assertEquals(new BigInteger("1"), teamSyn.get(0).getObjectId());
			assertEquals("F.C. Barcelona", teamSyn.get(0).getSynonimWords()
					.get(0).getWord());
			assertEquals("FC Barcelona", teamSyn.get(0).getSynonimWords()
					.get(1).getWord());
			assertEquals("Barça", teamSyn.get(0).getSynonimWords().get(2)
					.getWord());
			assertEquals("Barcelona", teamSyn.get(0).getSynonimWords().get(3)
					.getWord());
		}
	}

	/**
	 * Test custom find by team name sport name error test.
	 */
	@Test
	public void testCustomFindByTeamNameSportNameErrorTest() {
		List<CfgParticipantSynonyms> teamSyn = cfgParticipantSynonymsWordService
				.customFindByTeamNameSportName("XXXX", new BigInteger("1"));

		assertTrue(teamSyn.size() == 0);

	}

}
