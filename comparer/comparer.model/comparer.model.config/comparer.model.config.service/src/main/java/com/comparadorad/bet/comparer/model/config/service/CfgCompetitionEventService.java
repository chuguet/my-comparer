/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;

/**
 * The Class CfgCompetitionEventService.
 */
@Service
class CfgCompetitionEventService extends
		AbstractGenericCrudService<CfgCompetitionEvent> implements
		ICfgCompetitionEventService {

	/** The competition event repository. */
	@Inject
	private CfgCompetitionEventRepository competitionEventRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgCompetitionEvent> getCrudRepository() {
		return competitionEventRepository;
	}

	/**
	 * Custom find byname.
	 * 
	 * @param pName
	 *            the name
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<CfgCompetitionEvent> customFindByname(String pName) {
		return competitionEventRepository.customFindByname(pName);
	}

}
