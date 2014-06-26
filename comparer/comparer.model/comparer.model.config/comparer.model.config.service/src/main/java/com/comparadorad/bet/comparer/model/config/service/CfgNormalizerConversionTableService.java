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

import com.comparadorad.bet.comparer.model.config.bean.CfgNormalizerConversionTable;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgNormalizerConversionTableRepository;

/**
 * The Class CfgMasterService.
 */
@Service
class CfgNormalizerConversionTableService extends AbstractGenericCrudService<CfgNormalizerConversionTable> implements
		ICfgNormalizerConversionTablleService {

	/** The master repository. */
	@Inject
	private CfgNormalizerConversionTableRepository cfgNormalizerConversionTableRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgNormalizerConversionTable> getCrudRepository() {
		return cfgNormalizerConversionTableRepository;
	}

}
