/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventSynonymsRepository;

/**
 * The Class CfgCompetitionEventSynonymsRepositoryTest.
 */
public class CfgCompetitionEventSynonymsRepositoryTest extends
		AbstractConfigRepositoryTest<CfgCompetitionEventSynonymsRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CfgCompetitionEventRepositoryTest.class);

	/** The competition event synonyms repository. */
	@Inject
	private CfgCompetitionEventSynonymsRepository competitionEventSynonymsRepository;

	/** {@inheritDoc} */
	@Override
	public CfgCompetitionEventSynonymsRepository getCrudRepository() {
		return competitionEventSynonymsRepository;
	}

	/** {@inheritDoc} */
	@Override
	protected Object getNewElement() {
		return new CfgCompetitionEventSynonyms();
	}

	/**
	 * Test query.
	 */
	@Test
	public void testQuery() {
		String nameSynonymEvent1 = "Real Madrid - Barcelona : Cuartos de final";
		String nameSynonymEvent2 = "Valencia - Osasuna : Semifinal";
		String nameSynonymEvent3 = "At. Madrid - Sevilla : Final";

		LOG.info("Synonym found: "
				+ competitionEventSynonymsRepository
						.customFindByname(nameSynonymEvent1).get(0)
						.getObjectId().toString());
		LOG.info("Synonym found: "
				+ competitionEventSynonymsRepository
						.customFindByname(nameSynonymEvent2).get(0)
						.getObjectId().toString());
		LOG.info("Synonym found: "
				+ competitionEventSynonymsRepository
						.customFindByname(nameSynonymEvent3).get(0)
						.getObjectId().toString());

		assertEquals(
				competitionEventSynonymsRepository
						.customFindByname(nameSynonymEvent1).get(0)
						.getSynonimWords().get(0).getWord(), nameSynonymEvent1);
		assertEquals(
				competitionEventSynonymsRepository
						.customFindByname(nameSynonymEvent2).get(0)
						.getSynonimWords().get(0).getWord(), nameSynonymEvent2);
		assertEquals(
				competitionEventSynonymsRepository
						.customFindByname(nameSynonymEvent3).get(0)
						.getSynonimWords().get(0).getWord(), nameSynonymEvent3);
	}
}
