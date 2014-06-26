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

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface ICfgParticipantService.
 */
public interface ICfgParticipantService extends
		IGenericCrudService<CfgParticipant> {

	/**
	 * Clean duplicated participant synonyms.
	 */
	void cleanDuplicatedParticipantSynonyms();

	/**
	 * Clean participants with no synonyms.
	 */
	void cleanParticipantsWithNoSynonyms();

	/**
	 * Clean participants without competition.
	 */
	void cleanParticipantsWithoutCompetition();

	/**
	 * Find by synonyms.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	List<CfgParticipant> findBySynonyms(String name);

	/**
	 * Gets the participants by competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the participants by competition
	 */
	List<CfgParticipant> getParticipantsByCompetition(BigInteger competitionId);

}
