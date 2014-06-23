/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;

/**
 * The Class CfgSportRepositoryTest.
 */

public class CfgSportRepositoryTest extends
		AbstractConfigRepositoryTest<CfgSportRepository> {
	/** The sport type repository. */
	@Inject
	private CfgSportRepository sportTypeRepository;

	/** {@inheritDoc} */
	@Override
	public CfgSportRepository getCrudRepository() {
		return sportTypeRepository;
	}

	/** {@inheritDoc} */
	@Override
	protected Object getNewElement() {
		CfgSport sportType = new CfgSport();
		sportType.setI18n(getI18N());
		sportType.setName("sport1");
		return sportType;
	}
}
