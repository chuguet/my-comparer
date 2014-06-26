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

import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgResourceRepository;

/**
 * The Class CfgResourceService.
 */
@Service
class CfgResourceService extends AbstractGenericCrudService<CfgResource>
		implements ICfgResourceService {

	/** The resource repository. */
	@Inject
	private CfgResourceRepository resourceRepository;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgResource> getCrudRepository() {
		return resourceRepository;
	}
}
