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
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface CfgParticipantSynonymsRepositoryCustom.
 * 
 */
public interface CfgParticipantSynonymsRepositoryCustom extends
		IGenericCustomRepository<CfgParticipantSynonyms>,
		ISynonymsRepository<CfgParticipantSynonyms> {
	
	/**
	 * Custom find all participants.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindAllParticipants(
			final BigInteger competitionId);
	/**
	 * Custom find by id.
	 *
	 * @param synonymId the synonym id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindById(BigInteger synonymId);

	/**
	 * Custom find by name and competition.
	 * 
	 * @param teamName
	 *            the team name
	 * @param competition
	 *            the competition
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindByNameAndCompetition(
			String teamName, CfgCompetition competition);

	/**
	 * Custom find by participant.
	 * 
	 * @param participantId
	 *            the participant id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindByParticipant(
			BigInteger participantId);

	/**
	 * Custom find by participant name sport and competition id.
	 * 
	 * @param teamName
	 *            the team name
	 * @param sportId
	 *            the sport id
	 * @param competitionId
	 *            the competition id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindByParticipantNameSportAndCompetitionId(
			final String teamName, final BigInteger sportId,
			final BigInteger competitionId);

	/**
	 * Custom find by team name and competition name.
	 * 
	 * @param teamName
	 *            the team name
	 * @param competitionId
	 *            the competition id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindByTeamNameAndCompetitionName(
			String teamName, BigInteger competitionId);

	/**
	 * Custom find by team name and sport name.
	 * 
	 * @param teamName
	 *            the team name
	 * @param sportId
	 *            the sport id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindByTeamNameAndSportName(
			String teamName, BigInteger sportId);
	
	/**
	 * Delete participant referer.
	 *
	 * @param participantId the participant id
	 */
	void deleteParticipantReferer(BigInteger participantId);

}
