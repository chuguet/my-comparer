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

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;

/**
 * The Class CfgBookmakerService.
 */
@Service
class CfgBookmakerService extends AbstractGenericCrudService<CfgBookmaker>
		implements ICfgBookmakerService {

	/** The bookmaker configuration repository. */
	@Inject
	private CfgBookmakerRepository cfgBookmakerRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService
	 * #getCrudRepository()
	 */
	@Override
	protected IGenericRepository<CfgBookmaker> getCrudRepository() {
		return cfgBookmakerRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgBookmakerService
	 * #getActiveBookmakers()
	 */
	@Override
	public Long getActiveBookmakers() {
		Long result = cfgBookmakerRepository.getActiveBookmakers();
		return result;
	}
}
