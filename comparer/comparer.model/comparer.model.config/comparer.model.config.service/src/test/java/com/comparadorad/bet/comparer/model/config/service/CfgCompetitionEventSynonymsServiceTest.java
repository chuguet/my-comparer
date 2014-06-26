package com.comparadorad.bet.comparer.model.config.service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

public class CfgCompetitionEventSynonymsServiceTest extends
AbstractServiceTest<CfgCompetitionEventSynonyms>{

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgCompetitionEventSynonymsServiceTest.class);
	
	/** The competition type service. */
	@Inject
	private ICfgCompetitionEventSynonymsService cfgCompetitionEventSynonymsService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgCompetitionEventSynonyms> getIGenericService() {
		return cfgCompetitionEventSynonymsService;
	}

	
	/**
	 * Test custom: find syns by Competition name.
	 */
	@Test
	public void testcustomFindByname(){
		String nameSynonymEvent1 = "Real Madrid - Barcelona : Cuartos de final";
		String nameSynonymEvent2 = "Valencia - Osasuna : Semifinal";
		String nameSynonymEvent3 = "At. Madrid - Sevilla : Final";

		LOG.info("CfgCompetitionSynonyms found: " + cfgCompetitionEventSynonymsService.customFindByname(nameSynonymEvent1).get(0).getSynonimWords().get(0).getWord());
		LOG.info("CfgCompetitionSynonyms found: " + cfgCompetitionEventSynonymsService.customFindByname(nameSynonymEvent2).get(0).getSynonimWords().get(0).getWord());
		LOG.info("CfgCompetitionSynonyms found: " + cfgCompetitionEventSynonymsService.customFindByname(nameSynonymEvent3).get(0).getSynonimWords().get(0).getWord());

		assertEquals(cfgCompetitionEventSynonymsService.customFindByname(nameSynonymEvent1).get(0).getSynonimWords().get(0).getWord(), nameSynonymEvent1);
		assertEquals(cfgCompetitionEventSynonymsService.customFindByname(nameSynonymEvent2).get(0).getSynonimWords().get(0).getWord(), nameSynonymEvent2);
		assertEquals(cfgCompetitionEventSynonymsService.customFindByname(nameSynonymEvent3).get(0).getSynonimWords().get(0).getWord(), nameSynonymEvent3);
	}
}
