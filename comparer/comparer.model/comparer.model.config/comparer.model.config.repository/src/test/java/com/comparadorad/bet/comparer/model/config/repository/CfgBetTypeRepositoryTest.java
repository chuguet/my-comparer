/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import java.math.BigInteger;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;

/**
 * The Class CfgBetTypeRepositoryTest.
 */

public class CfgBetTypeRepositoryTest extends
		AbstractConfigRepositoryTest<CfgBetTypeRepository> {

	/** The sport type repository. */
	@Inject
	private CfgBetTypeRepository sportTypeRepository;

	/** {@inheritDoc} */
	@Override
	public CfgBetTypeRepository getCrudRepository() {
		return sportTypeRepository;
	}

	/** {@inheritDoc} */
	@Override
	protected Object getNewElement() {
		CfgBetType sportType = new CfgBetType();
		sportType.setObjectId(new BigInteger("6435236"));
		sportType.setName("Handicap test");
		return sportType;
	}
}
