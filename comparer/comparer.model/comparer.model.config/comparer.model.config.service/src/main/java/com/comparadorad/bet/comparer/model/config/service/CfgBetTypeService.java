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

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;

/**
 * The Class CfgBetTypeService.
 */
@Service
class CfgBetTypeService extends AbstractGenericCrudService<CfgBetType>
		implements ICfgBetTypeService {

	/** The sport repository. */
	@Inject
	private CfgBetTypeRepository cfgBetTypeRepository;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgBetType> getCrudRepository() {
		return cfgBetTypeRepository;
	}

}
