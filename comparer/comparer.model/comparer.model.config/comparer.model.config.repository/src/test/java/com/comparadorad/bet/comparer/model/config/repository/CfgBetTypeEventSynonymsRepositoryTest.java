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

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventSynonymsRepository;

/**
 * The Class CfgBetTypeSynonymsRepositoryTest.
 */
public class CfgBetTypeEventSynonymsRepositoryTest extends
		AbstractConfigRepositoryTest<CfgBetTypeEventSynonymsRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CfgBetTypeEventSynonymsRepositoryTest.class);

	/** The synonyms word repository. */
	@Inject
	private CfgBetTypeEventSynonymsRepository cfgBetTypeEventSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgBetTypeEventSynonymsRepository getCrudRepository() {
		return cfgBetTypeEventSynonymsRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		// CfgBetTypeEventSynonyms synonyms = new CfgBetTypeEventSynonyms();
		// CfgBetTypeEvent betType = new CfgBetTypeEvent();
		// betType.setObjectId("1");
		// betType.setName("Final primera parte");
		// synonyms.setBetType(betType);
		// synonyms.addSynonimWord("Handicap Test");
		// synonyms.addSynonimWord("Handicap ResultTest");
		// return synonyms;
		CfgBetTypeEventSynonyms betTypeEventSynonymsRepository = new CfgBetTypeEventSynonyms();
		betTypeEventSynonymsRepository.setObjectId(BigInteger.ONE);
		return betTypeEventSynonymsRepository;
	}

	/**
	 * Test find syns by betType name.
	 */
	@Test
	public void testcustomFindByname() {

		List<CfgBetTypeEventSynonyms> listBetTypeEvent = cfgBetTypeEventSynonymsRepository
				.customFindByname("Handicap");

		LOG.info("CfgBetTypeEventSynonyms found: "
				+ listBetTypeEvent.get(0).getObjectId().toString());

		assertNotNull(listBetTypeEvent.get(0));
		assertEquals(BigInteger.ONE, listBetTypeEvent.get(0).getObjectId());

	}

}
