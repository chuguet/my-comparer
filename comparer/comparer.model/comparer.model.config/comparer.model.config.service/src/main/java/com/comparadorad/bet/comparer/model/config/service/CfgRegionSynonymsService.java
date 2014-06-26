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

import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionSynonymsRepository;

/**
 * The Class CfgRegionSynonymsService.
 */
@Service
class CfgRegionSynonymsService extends
		AbstractSynonymsCrudService<CfgRegionSynonyms> implements
		ICfgRegionSynonymsService {

	/** The synonyms word repository. */
	@Inject
	private CfgRegionSynonymsRepository cfgRegionSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgRegionSynonyms> getCrudRepository() {
		return cfgRegionSynonymsRepository;
	}

	/**
	 * Custom find byname.
	 *
	 * @param name the name
	 * @return the list
	 * {@inheritDoc}
	 */ 
	@Override
	public List<CfgRegionSynonyms> customFindByname(String name) {
		
		return cfgRegionSynonymsRepository.customFindByname(name);
	}

	@Override
	public List<CfgRegionSynonyms> customFindAllTournament(String string,
			BigInteger bigInteger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CfgRegionSynonyms> customFindAllParticipant(
			BigInteger competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
