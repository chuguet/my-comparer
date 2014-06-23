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
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.repository.CfgRegionRepository;

/**
 * The Class CfgCompetitionRepositoryTest.
 */
public class CfgRegionRepositoryTest extends
		AbstractConfigRepositoryTest<CfgRegionRepository> {

	/** The competition repository. */
	@Inject
	private CfgRegionRepository cfgRegionRepository;

	/** {@inheritDoc} */
	@Override
	public CfgRegionRepository getCrudRepository() {
		return cfgRegionRepository;
	}

	/** {@inheritDoc} */
	@Override
	protected Object getNewElement() {
		CfgRegion cfgRegion = new CfgRegion();
		cfgRegion.setName("Europa");
		cfgRegion.setI18n(getI18N());
		
		return cfgRegion;
	}

	/**
	 * Test query.
	 */
	@Test
	public void testgetRegionName() {
		ArrayList<CfgRegion> result = cfgRegionRepository.
				getRegionByName("Europa");
		
		assertNotNull(result);
		assertEquals(result.get(0).getI18n().getI18nField(null).getString(), "Europa");
	}
	
	@Test
	public void getRegionById() {
		CfgRegion result = cfgRegionRepository.
				getRegionById(new BigInteger("3"));
		
		assertNotNull(result);
		assertEquals(result.getAlfanumeric2Code(), "europeanunion");
		assertEquals(result.getObjectId(), new BigInteger("3"));
	}

}
