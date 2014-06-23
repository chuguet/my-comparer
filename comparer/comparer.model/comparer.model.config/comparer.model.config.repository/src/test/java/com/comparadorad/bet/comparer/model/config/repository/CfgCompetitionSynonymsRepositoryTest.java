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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepositoryCustom;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;

/**
 * The Class CfgCompetitionSynonymsRepositoryTest.
 */
public class CfgCompetitionSynonymsRepositoryTest extends
		AbstractConfigRepositoryTest<CfgCompetitionSynonymsRepository> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgCompetitionSynonymsRepositoryTest.class);

	/** The synonyms word repository. */
	@Inject
	private CfgCompetitionSynonymsRepository competitionSynonymsRepository;

	/** The competition synonyms repository custom. */
	@Inject
	private CfgCompetitionSynonymsRepositoryCustom competitionSynonymsRepositoryCustom;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgCompetitionSynonymsRepository getCrudRepository() {
		return competitionSynonymsRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgCompetitionSynonyms competitionSynonyms = new CfgCompetitionSynonyms();

		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgSport cfgSport = new CfgSport();
		cfgSport.setObjectId("1");
		cfgSport.setName("Futbol");
		cfgCompetition.setObjectId("1");
		cfgCompetition.setName("Liga Española Test");
		cfgCompetition.setSport(cfgSport);
		cfgCompetition.setHistoricCreationData("testUser");
		competitionSynonyms.setRelatedDocument(cfgCompetition);

		competitionSynonyms.addSynonimWord("Spain League Test", getBookmaker());
		competitionSynonyms.addSynonimWord("Liga Espannola Test", getBookmaker());
		return competitionSynonyms;
	}

	/**
	 * Test custom: find syns by Competition name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgCompetitionSynonyms> comSyn = competitionSynonymsRepository
				.customFindByname("Spain League");

		LOG.info("CfgCompetitionSynonyms found: " + comSyn.get(0).toString());

		assertNotNull(comSyn.get(0));
		assertEquals(new BigInteger("1"), comSyn.get(0).getObjectId());
		// assertEquals("Liga Española",
		// ComSyn.get(0).getSynonimWords().get(0).getWord());
		assertEquals("Spain League", comSyn.get(0).getSynonimWords().get(1)
				.getWord());
		assertEquals("La Liga 2012/13", comSyn.get(0).getSynonimWords().get(2)
				.getWord());

		comSyn = competitionSynonymsRepository.customFindByname("Euro 2012");
		assertTrue(comSyn.size() > 0);
	}

	/**
	 * Test custom find all.
	 */
	@Test
	public void testCustomFindAll() {
		List<CfgCompetitionSynonyms> comSyn = competitionSynonymsRepository
				.customFindAll();

		assertTrue(comSyn.size() > 0);
	}

	/**
	 * Test find competition by name and sport.
	 */
	@Test
	public void testFindCompetitionByNameAndSport() {
		BigInteger sportId = new BigInteger("1");
		String competitionName = "Premier League";
		CfgCompetition comSyn;
		
		try {
			comSyn = competitionSynonymsRepositoryCustom
					.findByCompetitionNameAndSport(competitionName, sportId);
			assertNotNull(comSyn);
		} catch (CompetitionNotVerifiedException e) {
			LOG.error(e.getMessage());
		}

		
	}

	/**
	 * Test find competition by name and sport not found.
	 */
	@Test
	public void testFindCompetitionByNameAndSportNotFound() {
		BigInteger sportId = new BigInteger("666");
		String competitionName = "Premier League";
		CfgCompetition comSyn;
		try {
			comSyn = competitionSynonymsRepositoryCustom
					.findByCompetitionNameAndSport(competitionName, sportId);
			assertNull(comSyn);
		} catch (CompetitionNotVerifiedException e) {
			LOG.error(e.getMessage());
		}

		
	}

	/**
	 * Test find competition by name not found and sport.
	 */
	@Test
	public void testFindCompetitionByNameNotFoundAndSport() {
		BigInteger sportId = new BigInteger("1");
		String competitionName = "Competicion Inventada";
		CfgCompetition comSyn;
		try {
			comSyn = competitionSynonymsRepositoryCustom
					.findByCompetitionNameAndSport(competitionName, sportId);
			assertNull(comSyn);
		} catch (CompetitionNotVerifiedException e) {
			LOG.error(e.getMessage());
		}

		
	}

	@Test
	public void testCustomFindAllTournament() {
		BigInteger sportId = new BigInteger("1");
		String competitionName = "PremierLeague";

		List<CfgCompetitionSynonyms> competitionSynonyms = competitionSynonymsRepositoryCustom
				.customFindAllTournament(competitionName, sportId);
		
		assertNotNull(competitionSynonyms);
		
		sportId = new BigInteger("666");
		competitionSynonyms = competitionSynonymsRepositoryCustom
				.customFindAllTournament(competitionName, sportId);
		
		assertTrue(competitionSynonyms.size() == 0);
		
	}

}
