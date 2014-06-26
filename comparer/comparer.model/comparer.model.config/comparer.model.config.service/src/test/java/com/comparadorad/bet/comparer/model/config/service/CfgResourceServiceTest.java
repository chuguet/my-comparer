package com.comparadorad.bet.comparer.model.config.service;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

public class CfgResourceServiceTest extends AbstractServiceTest<CfgResource> {
	
	@Inject
	private ICfgResourceService resourceService;

	@Override
	protected IGenericCrudService<CfgResource> getIGenericService() {
		return resourceService;
	}

}
