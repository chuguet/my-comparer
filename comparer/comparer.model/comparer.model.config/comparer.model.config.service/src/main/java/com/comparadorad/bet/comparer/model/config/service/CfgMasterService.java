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

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgMasterRepository;

/**
 * The Class CfgMasterService.
 */
@Service
class CfgMasterService extends AbstractGenericCrudService<CfgMaster> implements
		ICfgMasterService {

	/** The master repository. */
	@Inject
	private CfgMasterRepository cfgMasterRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgMaster> getCrudRepository() {
		return cfgMasterRepository;
	}

}
