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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventAgrupation;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventAgrupationRepository;

/**
 * The Class CfgCompetitionEventAgrupationService.
 */
@Service
class CfgCompetitionEventAgrupationService extends
		AbstractGenericCrudService<CfgCompetitionEventAgrupation> implements
		ICfgCompetitionEventAgrupationService {

	/** The repository. */
	@Inject
	private CfgCompetitionEventAgrupationRepository repository;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgCompetitionEventAgrupation> getCrudRepository() {
		return repository;
	}

}
