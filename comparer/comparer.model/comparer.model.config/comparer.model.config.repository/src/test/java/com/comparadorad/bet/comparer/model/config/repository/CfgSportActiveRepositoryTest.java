/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgSportActive;
import com.comparadorad.bet.comparer.model.repository.CfgSportActiveRepository;

/**
 * The Class CfgSportActiveRepositoryTest.
 */
public class CfgSportActiveRepositoryTest extends
		AbstractConfigRepositoryTest<CfgSportActiveRepository> {

	/** The sport type repository. */
	@Inject
	private CfgSportActiveRepository sportActiveRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractRepositoryTest
	 * #getCrudRepository()
	 */
	@Override
	public CfgSportActiveRepository getCrudRepository() {
		return sportActiveRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractRepositoryTest
	 * #getNewElement()
	 */
	@Override
	protected Object getNewElement() {
		CfgSportActive sportActive = new CfgSportActive();
		sportActive.setSportName("prueba");
		return sportActive;
	}

	/**
	 * Find all test.
	 */
	@Test
	public void findAllTest() {
		List<CfgSportActive> result = sportActiveRepository.findAll();

		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

}
