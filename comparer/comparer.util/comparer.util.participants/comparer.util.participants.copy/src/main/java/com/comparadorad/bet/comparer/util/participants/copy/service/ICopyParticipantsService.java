/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.service;

import java.util.List;
import java.util.Map;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.util.participants.copy.exception.DataNotFoundException;
import com.comparadorad.bet.comparer.util.participants.copy.exception.ParticipantCopyException;

/**
 * Interface for CopyParticipantsService.
 *
 * @see com.comparer.utils.copy.participants.service.CopyParticipantsService
 * @author farce
 */
public interface ICopyParticipantsService {

	/**
	 * Copy particiant to competition.
	 *
	 * @param participantId the participant id
	 * @param competitionId the competition id
	 */
	public void copyParticiantToCompetition(List<String> participantIds,
			String competitionId) throws ParticipantCopyException;

	/**
	 * Create participants with a new id, and the same data, create all the same
	 * synonyms to that participants, all associated to the new competition, and
	 * do the transaction's commit.
	 *
	 * @param competitionSource the competition source
	 * @param competitionTarget , competition target
	 * @param participantsSynonyms the participants synonyms
	 * @param participantsTargetSynonyms the participants target synonyms
	 * @param outputFilePath the output file path
	 * @return true, if successful
	 */
	public boolean doCopyParticipants(
			CfgCompetition competitionSource,
			CfgCompetition competitionTarget,
			Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsSynonyms,
			Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsTargetSynonyms,
			String outputFilePath);

	/**
	 * Finds all Competitions in database.
	 *
	 * @return List
	 */
	public List<CfgCompetition> findAllCompetitions();

	/**
	 * Gets a competition by their "_id", as String.
	 *
	 * @param cmpName the cmp name
	 * @return the CfgCompetition Object
	 */
	public CfgCompetition findCompetitionByName(String cmpName);

	/**
	 * Finds all competition's participants.
	 *
	 * @param competitionId , the "_id"'s competition as String
	 * @param bRejectNotActive the b reject not active
	 * @return the list
	 */
	public List<CfgParticipant> findParticipantsByCompetitionId(
			String competitionId, boolean bRejectNotActive);

	/**
	 * Find sysnomims of participants and sets in a Map.
	 *
	 * @param participants the participants
	 * @param bRejectNotActive the b reject not active
	 * @return the map
	 */
	public Map<CfgParticipant, List<CfgParticipantSynonyms>> findParticipantSynonyms(
			List<CfgParticipant> participants, boolean bRejectNotActive);

	/**
	 * Gets a competition by their "_id", as String.
	 *
	 * @param id , the "_id"'s competition in String format
	 * @return the CfgCompetition Object
	 */
	public CfgCompetition getCompetitionById(String id);
}
