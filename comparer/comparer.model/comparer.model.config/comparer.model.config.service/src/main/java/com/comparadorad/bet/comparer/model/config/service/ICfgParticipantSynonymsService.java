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

import org.springframework.cache.annotation.Cacheable;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICfgParticipantSynonymsService.
 */
public interface ICfgParticipantSynonymsService extends
		IGenericCrudService<CfgParticipantSynonyms>,
		ISynonymsService<CfgParticipantSynonyms> {

	/**
	 * Clean duplicate synonyms words only one participant.
	 */
	void cleanDuplicateSynonymsWordsOnlyOneParticipant();

	/**
	 * Clean duplicate synonyms words some participants.
	 */
	void cleanDuplicateSynonymsWordsSomeParticipants();

	/**
	 * Clean participants synonyms without participants.
	 */
	void cleanParticipantsSynonymsWithoutParticipants();

	/**
	 * Clean synonym words from bookmaker.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 */
	void cleanSynonymWordsFromBookmaker(String idBookmaker);

	/**
	 * Custom find by key words and competition id.
	 * 
	 * @param keywords
	 *            the keywords
	 * @param competitionOjectId
	 *            the competition oject id
	 * @return the list
	 */
	@Cacheable(value = { "customFindByKeyWordsAndCompetitionId" })
	List<CfgParticipantSynonyms> customFindByKeyWordsAndCompetitionId(
			final String[] keywords, final BigInteger competitionOjectId);

	/**
	 * Custom find by participant id.
	 * 
	 * @param participantId
	 *            the participant id
	 * @return the list
	 */
	List<CfgParticipantSynonyms> customFindByParticipant(
			final BigInteger participantId);

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
	@Cacheable(value = { "customFindByParticipantNameSportAndCompetitionId" })
	List<CfgParticipantSynonyms> customFindByParticipantNameSportAndCompetitionId(
			final String teamName, final BigInteger sportId,
			final BigInteger competitionId);

	/**
	 * Custom find by team name competition name.
	 * 
	 * @param teamName
	 *            the team name
	 * @param competitionId
	 *            the competition id
	 * @return the list
	 */
	@Cacheable(value = { "customFindByTeamNameCompetitionName" })
	List<CfgParticipantSynonyms> customFindByTeamNameCompetitionName(
			final String teamName, final BigInteger competitionId);

	/**
	 * Custom find by team name sport name.
	 * 
	 * @param teamName
	 *            the team name
	 * @param sportId
	 *            the sport id
	 * @return the list
	 */
	@Cacheable(value = { "customFindByTeamNameSportName" })
	List<CfgParticipantSynonyms> customFindByTeamNameSportName(
			final String teamName, final BigInteger sportId);

	/**
	 * Delete participant referer.
	 * 
	 * @param participantId
	 *            the participant id
	 */
	void deleteParticipantReferer(BigInteger participantId);

}
