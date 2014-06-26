/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.repository.CfgSureBetRepository;

/**
 * The Class SureBetConfigService.
 */
@Service
public class CfgSureBetService extends AbstractGenericCrudService<CfgSureBet>
		implements ICfgSureBetService {

	/** The sure bet config repository. */
	@Inject
	private CfgSureBetRepository sureBetConfigRepository;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgSureBet> getCrudRepository() {
		return sureBetConfigRepository;
	}

}
