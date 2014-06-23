/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.math.BigInteger;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;

/**
 * The Interface CfgParticipantSynonymsRepositoryCustom.
 * 
 */
public interface CfgCompetitionSynonymsRepositoryCustom extends
		IGenericCustomRepository<CfgCompetitionSynonyms>,
		ISynonymsRepository<CfgCompetitionSynonyms> {

	/**
	 * Find by competition name and sport.
	 * 
	 * @param name
	 *            the name
	 * @param sportId
	 *            the sport id
	 * @return the list
	 * @throws CompetitionNotVerifiedException 
	 */
	CfgCompetition findByCompetitionNameAndSport(String name,
			BigInteger sportId) throws CompetitionNotVerifiedException;

	List<CfgCompetitionSynonyms> customFindAllTournament(String tournamentName,
			BigInteger sportId);

}
