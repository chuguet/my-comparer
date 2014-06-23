/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.repository.exception.IsolatedSaveException;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface IRtMatchService.
 */
public interface IRtMatchService extends IGenericCrudService<RtMatch> {

	/**
	 * Exists custom.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the boolean
	 */
	Boolean existsCustom(String idMatch);
	
	Boolean exists(String hashKey);
	
	void isolateSave(RtMatch match) throws IsolatedSaveException;

	/**
	 * Busca un partido activo
	 * 
	 * @param betType
	 *            the bet type
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the rt match
	 */
	RtMatch findActiveMatch(String betType, String betTypeEvent);
	
	/**
	 * Find match.
	 * 
	 * @param objectId
	 *            the object id
	 * @return the rt match
	 */
	RtMatch findMatch(ObjectId objectId);

	/**
	 * Find one custom.
	 * 
	 * @param id
	 *            the id
	 * @return the rt match
	 */
	RtMatch findOneCustom(String id);

	/**
	 * Gets the all sport country competition matchs.
	 * 
	 * @param pCompetitionId
	 *            the competition id
	 * @return the all sport country competition matchs
	 */
	List<RtMatch> getAllSportCountryCompetitionMatchs(BigInteger pCompetitionId);

	/**
	 * Gets the all sport country matchs.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @param pCountryId
	 *            the country id
	 * @return the all sport country matchs
	 */
	List<RtMatch> getAllSportCountryMatchs(BigInteger pSportId,
			BigInteger pCountryId);

	/**
	 * Gets the all sport matchs.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @return the all sport matchs
	 */
	List<RtMatch> getAllSportMatchs(BigInteger pSportId);

	/**
	 * Gets the bet types competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the bet types competition matchs
	 */
	List<RtMatch> getBetTypesCompetitionMatchs(CfgCompetition pCompetition);

	/**
	 * Gets the competition market.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the competition market
	 */
	List<RtMarket> getCompetitionMarket(BigInteger competitionId,
			BigInteger betTypeId);

	/**
	 * Gets the competition market.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param cfgBetTypeId
	 *            the cfg bet type id
	 * @return the competition market
	 */
	List<RtMarket> getCompetitionMarket(BigInteger competitionId,
			CfgBetTypeId cfgBetTypeId);

	/**
	 * Gets the competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the competition matchs
	 */
	List<RtMatch> getCompetitionMatchs(CfgCompetition pCompetition);

	/**
	 * Gets the all future event.
	 * 
	 * @param moreDays
	 *            the more days
	 * @return the all future event
	 */
	List<RtMatch> getFutureEvents(int moreDays);

	/**
	 * Gets the future events sure bet.
	 * 
	 * @param page
	 *            the page
	 * @param limitDays
	 *            the limit days
	 * @return the future events sure bet
	 */
	List<RtMatch> getFutureEventsSureBet(int page, Integer limitDays);
	
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
	 * Gets the long term competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the long term competition
	 */
	List<RtMatch> getLongTermCompetition(BigInteger competitionId);

	/**
	 * Gets the long term market.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the long term market
	 */
	List<RtMarket> getLongTermMarket(BigInteger competitionId,
			BigInteger betTypeId);

	/**
	 * Gets the matchs by bet type and competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the matchs by bet type and competition
	 */
	List<RtMatch> getMatchsByBetTypeAndCompetition(BigInteger competitionId,
			BigInteger betTypeId);

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

	/**
	 * Gets the matchs by hash keys.
	 * 
	 * @param matchHashKey
	 *            the match hash key
	 * @return the matchs by hash keys
	 */
	List<RtMatch> getMatchsByHashKeys(String matchHashKey);
	
	
	RtMatch isolatedFindByHashKey(String matchHashKey);

	/**
	 * Gets the matchs by sport and country long term.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the matchs by sport and country long term
	 */
	List<RtMatch> getMatchsBySportAndCountryLongTerm(BigInteger sportId,
			BigInteger countryId);

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
	 * Gets the upcoming events.
	 * 
	 * @param zeroGmtMatchDate
	 *            the zero gmt match date
	 * @param dayRange
	 *            the day range
	 * @param minimalNumberOfBookmakers
	 *            the minimal number of bookmakers
	 * @return the upcoming events
	 */
	List<RtMatch> getUpcomingEvents(Date zeroGmtMatchDate, int dayRange,
			int minimalNumberOfBookmakers);

	/**
	 * Map reduce get matchs by competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventId
	 *            the bet type event id
	 * @param idBetTypeEventPCP 
	 * @return the list
	 */
	List<RtMatch> mapReduceGetMatchsByCompetition(BigInteger competitionId,
			String betTypeId, String betTypeEventId, String idBetTypeEventPCP);
	
	/**
	 * Returns a market in RtMatch select by match id, bet type id and bet type
	 * Event id.
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
	 * Returns a market in RtMatch select by match id, bet type id and not bet
	 * type Event id.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @return the rt match
	 */
	RtMatch findMarketByBetType(String idMatch, String idBetType);
	
	/**
	 * Returns a tMatch select by rtMatch id, with rtMatch name and competition
	 * data.
	 * 
	 * @param idRtMatch
	 *            the id rt match
	 * @return the rt match
	 */
	RtMatch findNameAndCompetition(String idRtMatch);
	
	/**
	 * Returns a market in RtMatch select by match id with the betType
	 * information.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the rt match
	 */
	RtMatch findMarketAndBetType(String idMatch);

	/**
	 * Find market by bet type and bet type event.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt market
	 */
	RtMarket findMarketByBetTypeAndBetTypeEvent(String idMatch,
			String idBetType, String idBetTypeEvent);

}
