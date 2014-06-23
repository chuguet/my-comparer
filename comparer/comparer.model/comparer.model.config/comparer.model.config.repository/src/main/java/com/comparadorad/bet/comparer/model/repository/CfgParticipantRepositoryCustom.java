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

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SynonymPerParticipant;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgParticipantRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
public interface CfgParticipantRepositoryCustom<T extends CfgParticipant>
		extends IGenericCustomRepository<T> {

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<CfgParticipant> findAllLimit(Integer limit, Integer skip);

	/**
	 * Gets the participants by competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the participants by competition
	 */
	List<CfgParticipant> getParticipantsByCompetition(BigInteger competitionId);


	/**
	 * Clean duplicated participant synonyms.
	 */
	void cleanDuplicatedParticipantSynonyms();
	
	/**
	 * Clean participants with no synonyms.
	 */
	void cleanParticipantsWithNoSynonyms();

}
