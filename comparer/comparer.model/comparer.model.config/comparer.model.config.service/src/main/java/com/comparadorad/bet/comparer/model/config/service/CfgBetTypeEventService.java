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

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;

/**
 * The Class CfgBetTypeService.
 */
@Service
class CfgBetTypeEventService extends
		AbstractGenericCrudService<CfgBetTypeEvent> implements
		ICfgBetTypeEventService {

	/** The sport repository. */
	@Inject
	private CfgBetTypeEventRepository cfgBetTypeRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgBetTypeEvent> getCrudRepository() {
		return cfgBetTypeRepository;
	}

}
