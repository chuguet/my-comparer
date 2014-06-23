/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;

/**
 * The Interface IRtMatchCache.
 */
public interface IRtMatchCacheStandard {

	/**
	 * Find one custom cache.
	 * 
	 * @param id
	 *            the id
	 * @return the rt match
	 */
	RtMatch findOneCustomCache(String id);

	/**
	 * Gets the bet types competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the bet types competition matchs
	 */
	List<RtMatch> getBetTypesCompetitionMatchsCache(CfgCompetition pCompetition);

	/**
	 * Gets the competition match head.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the competition match head
	 */
	RtMatch getCompetitionMatchHeadCache(CfgCompetition pCompetition);

	/**
	 * Gets the competition match head long term.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the competition match head long term
	 */
	RtMatch getCompetitionMatchHeadLongTermCache(CfgCompetition pCompetition);

	/**
	 * Gets the long term competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the long term competition
	 */
	List<RtMatch> getLongTermCompetitionCache(BigInteger competitionId);

	/**
	 * Gets the long term market cache.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the long term market cache
	 */
	List<RtMarket> getLongTermMarketCache(BigInteger competitionId,
			BigInteger betTypeId);

	/**
	 * Gets the matchs by competition filtered by bet type.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the matchs by competition filtered by bet type
	 */
	List<RtMatch> getMatchsByCompetitionFilteredByBetTypeCache(
			String competitionId);

	/**
	 * Map reduce get matchs by competition cache.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventId
	 *            the bet type event id
	 * @return the list
	 */
	List<RtMatch> mapReduceGetMatchsByCompetitionCache(
			BigInteger competitionId, String betTypeId, String betTypeEventId);
}
