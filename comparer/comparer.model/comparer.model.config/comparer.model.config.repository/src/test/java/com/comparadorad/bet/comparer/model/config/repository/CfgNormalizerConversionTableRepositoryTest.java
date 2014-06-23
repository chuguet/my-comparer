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

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgNormalizerConversionTable;
import com.comparadorad.bet.comparer.model.repository.CfgNormalizerConversionTableRepository;

/**
 * The Class CfgParticipantSynonymsRepositoryTest.
 */
public class CfgNormalizerConversionTableRepositoryTest extends
		AbstractConfigRepositoryTest<CfgNormalizerConversionTableRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CfgNormalizerConversionTableRepositoryTest.class);

	/** The synonyms word repository. */
	@Inject
	private CfgNormalizerConversionTableRepository normalizerRepository;
	
	@Override
	public CfgNormalizerConversionTableRepository getCrudRepository() {
		return normalizerRepository;
	}

	@Override
	protected Object getNewElement() {
		CfgNormalizerConversionTable cfgNormalizerConversionTable = new CfgNormalizerConversionTable();
		cfgNormalizerConversionTable.setKey("Esto es una prueba");
		
		return cfgNormalizerConversionTable;
	}
	
	/**
	 * Test query.
	 */	
	@Test
	public void customFindByKey(){
		LOG.debug("Initialize test customFindByname");
		
		CfgNormalizerConversionTable result = normalizerRepository
				.customFindByKey("Real Club Deportivo");
		
		assertNotNull(result);
		assertEquals(result.getKey(), "Real Club Deportivo");
		
		LOG.debug("The test customFindByname has been executed successfully");
	}
}