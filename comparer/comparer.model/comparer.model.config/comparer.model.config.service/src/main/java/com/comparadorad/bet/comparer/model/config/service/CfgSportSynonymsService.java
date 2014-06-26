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

import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportSynonymsRepository;

/**
 * The Class CfgSportSynonymsService.
 */
@Service
class CfgSportSynonymsService extends
		AbstractSynonymsCrudService<CfgSportSynonyms> implements
		ICfgSportSynonymsService {

	/** The synonyms word repository. */
	@Inject
	private CfgSportSynonymsRepository cfgSportSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgSportSynonyms> getCrudRepository() {
		return cfgSportSynonymsRepository;
	}

	@Override
	public List<CfgSportSynonyms> customFindAllTournament(String string,
			BigInteger bigInteger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CfgSportSynonyms> customFindAllParticipant(
			BigInteger competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
