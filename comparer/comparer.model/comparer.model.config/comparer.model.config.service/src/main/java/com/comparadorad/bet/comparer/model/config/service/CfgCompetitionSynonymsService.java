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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepositoryCustom;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;

/**
 * The Class CfgCompetitionSynonymsService.
 */
@Service
class CfgCompetitionSynonymsService extends
		AbstractSynonymsCrudService<CfgCompetitionSynonyms> implements
		ICfgCompetitionSynonymsService {

	/** The synonyms word repository. */
	@Inject
	private CfgCompetitionSynonymsRepository cfgCompetitionSynonymsRepository;

	@Inject
	private CfgCompetitionSynonymsRepositoryCustom cfgCompetitionSynonymsRepositoryCustom;

	/** {@inheritDoc} */
	@Override
	protected IGenericRepository<CfgCompetitionSynonyms> getCrudRepository() {
		return cfgCompetitionSynonymsRepository;
	}

	@Override
	public CfgCompetition findByCompetitionNameAndSport(final String name,
			final BigInteger sportId) throws CompetitionNotVerifiedException {
		CfgCompetition result = null;
		result = cfgCompetitionSynonymsRepositoryCustom
				.findByCompetitionNameAndSport(name, sportId);
		return result;
	}

	@Override
	public List<CfgCompetitionSynonyms> customFindAllTournament(
			String tournamentName, BigInteger sportId) {
		List<CfgCompetitionSynonyms> listaSinonimos = null;
		listaSinonimos = cfgCompetitionSynonymsRepositoryCustom
				.customFindAllTournament(tournamentName, sportId);
		return listaSinonimos;
	}

	@Override
	public List<CfgCompetitionSynonyms> customFindAllParticipant(
			BigInteger competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}