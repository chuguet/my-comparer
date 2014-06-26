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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventSynonymsRepository;

/**
 * The Class CfgCompetitionEventSynonymsService.
 */
@Service
class CfgCompetitionEventSynonymsService extends
		AbstractSynonymsCrudService<CfgCompetitionEventSynonyms> implements
		ICfgCompetitionEventSynonymsService {

	/** The competition event synonyms repository. */
	@Inject
	private CfgCompetitionEventSynonymsRepository competitionEventSynonymsRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository
	 */
	@Override
	protected IGenericRepository<CfgCompetitionEventSynonyms> getCrudRepository() {
		return competitionEventSynonymsRepository;
	}



	@Override
	public List<CfgCompetitionEventSynonyms> customFindAllTournament(
			String string, BigInteger bigInteger) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CfgCompetitionEventSynonyms> customFindAllParticipant(
			BigInteger competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
