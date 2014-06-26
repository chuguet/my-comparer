/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventAgrupation;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgBetTypeEventAgrupationServiceTest.
 */
public class CfgBetTypeEventAgrupationServiceTest extends
AbstractServiceTest<CfgBetTypeEventAgrupation> {

	
	/** The cfg bet type event agrupation service. */
	@Inject
	private ICfgBetTypeEventAgrupationService cfgBetTypeEventAgrupationService;
	
	/** {@inheritDoc} */ 
	@Override
	protected IGenericCrudService<CfgBetTypeEventAgrupation> getIGenericService() {
		return cfgBetTypeEventAgrupationService;
	}

}
