/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.mapreduce.beans.NextEventMapReduce;
import com.comparadorad.bet.comparer.model.bet.repository.exception.IsolatedSaveException;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface RtMatchRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface RtMatchRepositoryCustom<T extends RtMatch> extends
		IGenericCustomRepository<T> {

	void saveWithoutValidation(RtMatch match);
	
	/**
	 * Find all lazy.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the list
	 */
	Map<String, byte[]> convertMatchsToJSON(List<RtMatch> matchs);

	/**
	 * Exists custom.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the boolean
	 */
	Boolean existsCustom(String idMatch);
	
	Boolean exists(String hashKey);

	/**
	 * Busca un partido activo.
	 * 
	 * @param betType
	 *            the bet type
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the rt match
	 */
	RtMatch findActiveMatch(String betType, String betTypeEvent);

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<RtMatch> findAllLimit(Integer limit, Integer skip);

	/**
	 * Find all limit bet clean.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<RtMatch> findAllLimitBetClean(Integer limit, Integer skip);

	/**
	 * Find by name.
	 * 
	 * @param name
	 *            the name
	 * @return the rt match
	 */
	RtMatch findByName(String name);

	/**
	 * Gets the betTypes for an specific rtMatch.
	 * 
	 * @param idRtMatch
	 *            the id rt match
	 * @return the rt match
	 */
	RtMatch findMarketAndBetType(String idRtMatch);

	/**
	 * Gets a reduced Match with conditions.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @return the rt match
	 */
	RtMatch findMarketByBetType(String idMatch, String idBetType);

	/**
	 * Find market by bet type and bet type event.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt match
	 */
	RtMatch findMarketByBetTypeAndBetTypeEvent(String idMatch,
			String idBetType, String idBetTypeEvent);

	/**
	 * Gets a reduced Match for.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt match
	 */
	RtMatch findMarketByBetTypeBetTypeEvent(String idMatch, String idBetType,
			String idBetTypeEvent);

	/**
	 * Find match.
	 * 
	 * @param objectId
	 *            the object id
	 * @return the rt match
	 */
	RtMatch findMatch(ObjectId objectId);

	/**
	 * Gets the name of a rtMatch and the competition data.
	 * 
	 * @param idRtMatch
	 *            the id rt match
	 * @return the rt match
	 */
	RtMatch findNameAndCompetition(String idRtMatch);

	/**
	 * Find one custom.
	 * 
	 * @param id
	 *            the id
	 * @return the rt match
	 */
	RtMatch findOneCustom(String id);

	/**
	 * Find one custom from RtMatch, but only wants the marktes.
	 * 
	 * @param id
	 *            the id
	 * @return the set
	 */
	Set<RtMarket> findOneCustomMarkets(String id);

	/**
	 * Gets the all next events.
	 * 
	 * @param currentDate
	 *            the current date
	 * @param limitDate
	 *            the limit date
	 * @param minimalNumberOfBookamkers
	 *            the minimal number of bookamkers
	 * @return the all next events
	 */
	List<NextEventMapReduce> getAllNextEvents(Date currentDate, Date limitDate,
			final int minimalNumberOfBookamkers);

	/**
	 * Gets the bet types competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the bet types competition matchs
	 */
	List<RtMatch> getBetTypesCompetitionMatchs(CfgCompetition pCompetition);

	/**
	 * Gets the competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the competition matchs
	 */
	List<RtMatch> getCompetitionMatchs(CfgCompetition pCompetition);

	/**
	 * Gets the events for value bet limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @param minNumBets
	 *            the min num bets
	 * @return the events for value bet limit
	 */
	List<RtMatch> getEventsForValueBetLimit(Integer limit, Integer skip,
			Integer minNumBets);

	/**
	 * Gets the matchs by bet type and competition.
	 * 
	 * @param idCompetition
	 *            the id competition
	 * @param idBetType
	 *            the id bet type
	 * @return the matchs by bet type and competition
	 */
	List<RtMatch> getMatchsByBetTypeAndCompetition(BigInteger idCompetition,
			BigInteger idBetType);

	/**
	 * Gets the matchs by competition filtered by bet type.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the matchs by competition filtered by bet type
	 */
	List<RtMatch> getMatchsByCompetitionFilteredByBetType(String competitionId);

	/**
	 * Gets the matchs by hash key.
	 * 
	 * @param matchHashKey
	 *            the match hash key
	 * @return the matchs by hash key
	 */
	List<RtMatch> getMatchsByHashKey(String matchHashKey);

	RtMatch isolatedFindByHashKey(String matchHashKey);
	
	void isolateSave(RtMatch match) throws IsolatedSaveException;
	
	/**
	 * Gets the matchs by hash key bet clean.
	 * 
	 * @param matchHashKey
	 *            the match hash key
	 * @return the matchs by hash key bet clean
	 */
	List<RtMatch> getMatchsByHashKeyBetClean(String matchHashKey);

	/**
	 * Gets the matchs by hash keys.
	 * 
	 * @param matchHashKey
	 *            the match hash key
	 * @return the matchs by hash keys
	 */
	List<RtMatch> getMatchsByHashKeys(String matchHashKey);

	/**
	 * Gets the num matchs by competition.
	 * 
	 * @param competition
	 *            the competition
	 * @param betType
	 *            the bet type
	 * @return the num matchs by competition
	 */
	Long getNumMatchsByCompetition(CfgCompetition competition, String betType);

	/**
	 * Gets the rt match by competition and competition event.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param competitionEventId
	 *            the competition event id
	 * @return the rt match by competition and competition event
	 */
	List<RtMatch> getRtMatchByCompetitionAndCompetitionEvent(
			BigInteger competitionId, BigInteger competitionEventId);

	/**
	 * Gets the upcoming events.
	 * 
	 * @param currentDate
	 *            the current date
	 * @param limitDate
	 *            the limit date
	 * @param minimalNumberOfBookmakers
	 *            the minimal number of bookmakers
	 * @return the upcoming events
	 */
	List<RtMatch> getUpcomingEvents(Date currentDate, Date limitDate,
			int minimalNumberOfBookmakers);

	/**
	 * Gets the upcoming events for sure bet.
	 * 
	 * @param zeroGmtMatchDate
	 *            the zero gmt match date
	 * @param limitDate
	 *            the limit date
	 * @param page
	 *            the page
	 * @return the upcoming events for sure bet
	 */
	List<RtMatch> getUpcomingEventsForSureBet(Date zeroGmtMatchDate,
			Date limitDate, int page);

	/**
	 * Map reduce get matchs by competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventId
	 *            the bet type event id
	 * @param betTypeEventIdPCP
	 *            the bet type event id pcp
	 * @return the list
	 */
	List<RtMatch> mapReduceGetMatchsByCompetition(BigInteger competitionId,
			String betTypeId, String betTypeEventId, String betTypeEventIdPCP);

	/**
	 * Update bets by update date.
	 * 
	 * @param match
	 *            the match
	 * @param date
	 *            the date
	 * @return the rt match
	 */
	RtMatch removeBetsByUpdateDate(RtMatch match, Date date);
}
