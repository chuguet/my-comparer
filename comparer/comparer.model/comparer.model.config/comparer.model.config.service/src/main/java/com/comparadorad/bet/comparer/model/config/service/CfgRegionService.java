/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgRegionRepository;

/**
 * The Class CfgSportService.
 */
@Service
class CfgRegionService extends AbstractGenericCrudService<CfgRegion> implements
		ICfgRegionService {

	/** The region repository. */
	@Inject
	private CfgRegionRepository cfgRegionRepository;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgRegion> getCrudRepository() {
		return cfgRegionRepository;
	}

}
