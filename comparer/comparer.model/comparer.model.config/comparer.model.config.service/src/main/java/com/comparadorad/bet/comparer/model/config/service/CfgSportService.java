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

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;

/**
 * The Class CfgSportService.
 */
@Service
class CfgSportService extends AbstractGenericCrudService<CfgSport> implements
		ICfgSportService {

	/** The sport repository. */
	@Inject
	private CfgSportRepository cfgSportRepository;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgSport> getCrudRepository() {
		return cfgSportRepository;
	}

}
