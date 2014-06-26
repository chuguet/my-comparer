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

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventAgrupation;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventAgrupationRepository;

/**
 * The Class CfgBetTypeEventAgrupationService.
 */
@Service
class CfgBetTypeEventAgrupationService extends
		AbstractGenericCrudService<CfgBetTypeEventAgrupation> implements
		ICfgBetTypeEventAgrupationService {
	
	
	/** The cfg bet type event agrupation repository. */
	@Inject
	private CfgBetTypeEventAgrupationRepository cfgBetTypeEventAgrupationRepository;

	/**
	 * Gets the crud repository.
	 *
	 * @return the crud repository
	 * {@inheritDoc}
	 */ 
	@Override
	protected IGenericRepository<CfgBetTypeEventAgrupation> getCrudRepository() {
		return cfgBetTypeEventAgrupationRepository;
	}
}
