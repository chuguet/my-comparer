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

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepository;

/**
 * The Class CfgParticipantSynonymsRepositoryTest.
 */
public class CfgParticipantSynonymsRepositoryTest extends
		AbstractConfigRepositoryTest<CfgParticipantSynonymsRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CfgParticipantSynonymsRepositoryTest.class);

	/** The synonyms word repository. */
	@Inject
	private CfgParticipantSynonymsRepository teamSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgParticipantSynonymsRepository getCrudRepository() {
		return teamSynonymsRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgParticipantSynonyms synonyms = new CfgParticipantSynonyms();

		CfgParticipant team = new CfgParticipant();
		team.setObjectId("1");
		team.setName("Real Madrid C.F. Test");
		team.setCompetition(getCompetition1());
		synonyms.setRelatedDocument(team);
		synonyms.addSynonimWord("Real Madrid  Test", getBookmaker());
		synonyms.addSynonimWord("Real Madrid CF Test", getBookmaker());
		return synonyms;
	}

	/**
	 * Gets the competition1.
	 * 
	 * @return the competition1
	 */
	private CfgCompetition getCompetition1() {
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgSport cfgSport = new CfgSport();
		cfgSport.setObjectId("1");
		cfgSport.setName("Futbol");
		cfgCompetition.setObjectId("1");
		cfgCompetition.setName("Liga Española");
		cfgCompetition.setSport(cfgSport);
		cfgCompetition.setHistoricCreationData("testUser");
		return cfgCompetition;
	}

	/**
	 * Test custom: find syns by team name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgParticipantSynonyms> teamSyn = teamSynonymsRepository
				.customFindByname("Barcelona");
		LOG.info("CfgParticipantSynonyms found: " + teamSyn.get(0).toString());

		assertNotNull(teamSyn.get(0));
		assertEquals("F.C. Barcelona", teamSyn.get(0).getSynonimWords().get(0)
				.getWord());
		assertEquals("FC Barcelona", teamSyn.get(0).getSynonimWords().get(1)
				.getWord());
		assertEquals("Barcelona", teamSyn.get(0).getSynonimWords().get(3)
				.getWord());

	}

	/**
	 * Test custom: find syns by team name.
	 */
	@Test
	public void testcustomFindAll() {

		List<CfgParticipantSynonyms> teamSyn = teamSynonymsRepository
				.customFindAll();
		LOG.info("CfgParticipantSynonyms found: " + teamSyn.get(0).toString());

		assertNotNull(teamSyn.get(0));

	}
	
	/**
	 * Test custom: find syns by team name and competition.
	 */
	@Test
	public void testcustomFindByNameAndCompetition() {

		CfgCompetition competition = new CfgCompetition();
		competition.setObjectId(new BigInteger("656935033"));
		List<CfgParticipantSynonyms> teamSyn = teamSynonymsRepository
				.customFindByNameAndCompetition("Barcelona", competition);
		LOG.info("CfgParticipantSynonyms found: " + teamSyn.get(0).toString());

		assertNotNull(teamSyn.get(0));
		assertEquals(BigInteger.ONE, teamSyn.get(0).getObjectId());
		assertEquals("F.C. Barcelona", teamSyn.get(0).getSynonimWords().get(0)
				.getWord());
		assertEquals("FC Barcelona", teamSyn.get(0).getSynonimWords().get(1)
				.getWord());
		assertEquals("Barcelona", teamSyn.get(0).getSynonimWords().get(3)
				.getWord());

	}

	
	
	/**
	 * Test custom find by name and competition name.
	 */
	@Test
	public void testcustomFindByNameAndCompetitionName() {
		BigInteger competitionId = new BigInteger("656935033");
		String teamName = "Barcelona";

		List<CfgParticipantSynonyms> teamSyn = teamSynonymsRepository
				.customFindByTeamNameAndCompetitionName(teamName, competitionId);

		LOG.info("CfgParticipantSynonyms found: " + teamSyn.get(0).toString());
		assertNotNull(teamSyn.get(0));
		assertEquals(teamSyn.get(0).getObjectId(), new BigInteger("1"));
		assertEquals(teamSyn.get(0).getSynonimWords().get(3).getWord(), "Barcelona");
	}

	/**
	 * Test custom find by name and sport name.
	 */
	@Test
	public void testcustomFindByNameAndSportName() {
		BigInteger sportId = BigInteger.ONE;
		String teamName = "Barcelona";

		List<CfgParticipantSynonyms> teamSyn = teamSynonymsRepository
				.customFindByTeamNameAndSportName(teamName, sportId);

		LOG.info("CfgParticipantSynonyms found: " + teamSyn.get(0).toString());
		assertNotNull(teamSyn.get(0));
		assertEquals(teamSyn.get(0).getSynonimWords().get(3).getWord(), "Barcelona");
		assertEquals(teamSyn.get(0).getParticipant().getObjectId(), new BigInteger("12"));
	}

}