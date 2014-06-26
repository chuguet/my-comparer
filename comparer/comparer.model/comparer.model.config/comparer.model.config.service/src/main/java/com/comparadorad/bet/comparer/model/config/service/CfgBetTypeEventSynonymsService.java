/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventSynonymsRepository;

/**
 * The Class CfgBetTypeEventSynonymsService.
 */
@Service
class CfgBetTypeEventSynonymsService extends
		AbstractSynonymsCrudService<CfgBetTypeEventSynonyms> implements
		ICfgBetTypeEventSynonymsService {

	/** The synonyms word repository. */
	@Inject
	private CfgBetTypeEventSynonymsRepository cfgBetTypeEventSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgBetTypeEventSynonyms> getCrudRepository() {
		return cfgBetTypeEventSynonymsRepository;
	}

	
	@Override
	public List<CfgBetTypeEventSynonyms> customFindAllTournament(String string,
			BigInteger bigInteger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CfgBetTypeEventSynonyms> customFindAllParticipant(
			BigInteger competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
