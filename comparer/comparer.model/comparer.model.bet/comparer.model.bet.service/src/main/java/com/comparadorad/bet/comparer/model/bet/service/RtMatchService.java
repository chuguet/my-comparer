/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchMapReduce;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.bet.repository.exception.IsolatedSaveException;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;

/**
 * The Class RtMatchService.
 */
@Service
public class RtMatchService extends AbstractGenericCrudService<RtMatch>
		implements IRtMatchService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtMatchService.class);

	/** The Constant sdf. */
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/** The competition event. */
	@Inject
	private CfgCompetitionEventRepository competitionEventRepository;
	/** The competition repository. */
	@Inject
	private CfgCompetitionRepository competitionRepository;

	/** The rt match repository. */
	@Inject
	private RtMatchRepository rtMatchRepository;

	/**
	 * Exists custom.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the boolean {@inheritDoc}
	 */
	@Override
	public Boolean existsCustom(String idMatch) {
		return rtMatchRepository.existsCustom(idMatch);
	}

	/**
	 * Find match.
	 * 
	 * @param objectId
	 *            the object id
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findMatch(ObjectId objectId) {

		return rtMatchRepository.findMatch(objectId);
	}

	/**
	 * Busca un partido activo.
	 * 
	 * @param betType
	 *            the bet type
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findActiveMatch(String betType, String betTypeEvent) {
		return rtMatchRepository.findActiveMatch(betType, betTypeEvent);
	}

	/**
	 * Find one custom.
	 * 
	 * @param id
	 *            the id
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findOneCustom(String id) {
		return rtMatchRepository.findOneCustom(id);
	}

	/**
	 * Gets the all sport country competition matchs.
	 * 
	 * @param pCompetitionId
	 *            the competition id
	 * @return the all sport country competition matchs {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getAllSportCountryCompetitionMatchs(
			BigInteger pCompetitionId) {
		CfgCompetition cfgCompetition = competitionRepository
				.getCompetitionById(pCompetitionId);
		List<RtMatch> result = rtMatchRepository
				.getCompetitionMatchs(cfgCompetition);
		return result;
	}

	/**
	 * Gets the all sport country matchs.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @param pCountryId
	 *            the country id
	 * @return the all sport country matchs {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getAllSportCountryMatchs(BigInteger pSportId,
			BigInteger pCountryId) {
		List<RtMatch> result = new ArrayList<RtMatch>();
		List<CfgCompetition> competitions = competitionRepository
				.getCompetitionsBySportAndCountry(pSportId, pCountryId);

		for (CfgCompetition cfgCompetition : competitions) {
			result.addAll(rtMatchRepository
					.getCompetitionMatchs(cfgCompetition));
		}
		return result;
	}

	/**
	 * Gets the all sport matchs.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @return the all sport matchs {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getAllSportMatchs(BigInteger pSportId) {
		List<RtMatch> result = new ArrayList<RtMatch>();

		List<CfgCompetition> competitions = competitionRepository
				.getCompetitionsBySport(pSportId);

		for (CfgCompetition competition : competitions) {
			result.addAll(rtMatchRepository.getCompetitionMatchs(competition));
		}

		return result;
	}

	/**
	 * Gets the bet types competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the bet types competition matchs {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getBetTypesCompetitionMatchs(
			CfgCompetition pCompetition) {
		return rtMatchRepository.getBetTypesCompetitionMatchs(pCompetition);
	}

	/**
	 * Gets the competition market.
	 * 
	 * @param pCompetitionId
	 *            the competition id
	 * @param pBetTypeId
	 *            the bet type id
	 * @return the competition market {@inheritDoc}
	 */
	@Override
	public List<RtMarket> getCompetitionMarket(BigInteger pCompetitionId,
			BigInteger pBetTypeId) {

		CfgCompetition cfgCompetition = competitionRepository
				.getCompetitionById(pCompetitionId);
		List<RtMarket> result = new ArrayList<RtMarket>();
		List<RtMatch> matchs = rtMatchRepository
				.getCompetitionMatchs(cfgCompetition);

		for (RtMatch rtMatch : matchs) {
			for (RtMarket rtMarket : rtMatch.getRtMarkets()) {
				if (rtMarket.getBetType().getObjectId().equals(pBetTypeId)) {
					result.add(rtMarket);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the competition market.
	 * 
	 * @param pCompetitionId
	 *            the competition id
	 * @param pCfgBetTypeId
	 *            the cfg bet type id
	 * @return the competition market {@inheritDoc}
	 */
	@Override
	public List<RtMarket> getCompetitionMarket(BigInteger pCompetitionId,
			CfgBetTypeId pCfgBetTypeId) {
		CfgCompetition cfgCompetition = competitionRepository
				.getCompetitionById(pCompetitionId);
		List<RtMarket> result = new ArrayList<RtMarket>();
		List<RtMatch> matchs = rtMatchRepository
				.getCompetitionMatchs(cfgCompetition);

		for (RtMatch rtMatch : matchs) {
			for (RtMarket rtMarket : rtMatch.getRtMarkets()) {
				if (rtMarket.getBetType().getNameId()
						.equals(pCfgBetTypeId.nameId())) {
					result.add(rtMarket);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the competition matchs {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getCompetitionMatchs(CfgCompetition pCompetition) {
		return rtMatchRepository.getCompetitionMatchs(pCompetition);
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<RtMatch> getCrudRepository() {
		return rtMatchRepository;
	}

	/**
	 * Gets the future events.
	 * 
	 * @param moreDays
	 *            the more days
	 * @return the future events {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getFutureEvents(int moreDays) {
		Calendar endCalendar = Calendar.getInstance();
		Calendar startCalendar = Calendar.getInstance();
		endCalendar.add(Calendar.DAY_OF_YEAR, moreDays);
		startCalendar.add(Calendar.DAY_OF_YEAR, moreDays - 1);
		List<RtMatch> result = rtMatchRepository.getUpcomingEvents(
				startCalendar.getTime(), endCalendar.getTime(), 1);
		return result;
	}

	/**
	 * Gets the future events sure bet.
	 * 
	 * @param page
	 *            the page
	 * @param limitDays
	 *            the limit days
	 * @return the future events sure bet {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getFutureEventsSureBet(int page, Integer limitDays) {
		Calendar endCalendar = Calendar.getInstance();
		Calendar startCalendar = Calendar.getInstance();
		endCalendar.add(Calendar.DAY_OF_YEAR, limitDays);
		// startCalendar.add(Calendar.DAY_OF_YEAR, moreDays - 1);
		// LOG.info(new StringBuffer("Matchs obtenidos desde el ")
		// .append(sdf.format(startCalendar.getTime()))
		// .append(" hasta el ").append(sdf.format(endCalendar.getTime()))
		// .toString());
		List<RtMatch> result = rtMatchRepository.getUpcomingEventsForSureBet(
				startCalendar.getTime(), endCalendar.getTime(), page);
		return result;
	}

	/**
	 * Gets the events for value bet limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @param minNumBets
	 *            the min num bets
	 * @return the events for value bet limit {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getEventsForValueBetLimit(Integer limit, Integer skip,
			Integer minNumBets) {
		return rtMatchRepository.getEventsForValueBetLimit(limit, skip,
				minNumBets);
	}

	/**
	 * Gets the long term competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the long term competition {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getLongTermCompetition(BigInteger competitionId) {
		List<RtMatch> result = new ArrayList<RtMatch>();

		CfgCompetition competition = competitionRepository
				.getCompetitionById(competitionId);

		List<CfgCompetitionEvent> comEvent = competitionEventRepository
				.customFindByLongTerm(true);

		for (CfgCompetitionEvent cfgCompetitionEvent : comEvent) {
			result.addAll(rtMatchRepository
					.getRtMatchByCompetitionAndCompetitionEvent(new BigInteger(
							competition.getObjectId().toString()),
							new BigInteger(cfgCompetitionEvent.getObjectId()
									.toString())));
		}

		return result;
	}

	/**
	 * Gets the long term market.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the long term market {@inheritDoc}
	 */
	@Override
	public List<RtMarket> getLongTermMarket(BigInteger competitionId,
			BigInteger betTypeId) {
		List<RtMatch> matchs = new ArrayList<RtMatch>();
		List<RtMarket> result = new ArrayList<RtMarket>();

		CfgCompetition competition = competitionRepository
				.getCompetitionById(competitionId);

		List<CfgCompetitionEvent> comEvent = competitionEventRepository
				.customFindByLongTerm(true);

		for (CfgCompetitionEvent cfgCompetitionEvent : comEvent) {
			matchs.addAll(rtMatchRepository
					.getRtMatchByCompetitionAndCompetitionEvent(
							competition.getObjectId(),
							cfgCompetitionEvent.getObjectId()));
		}

		for (RtMatch rtMatch : matchs) {
			for (RtMarket rtMarket : rtMatch.getRtMarkets()) {
				if (rtMarket.getBetType().getObjectId().equals(betTypeId)
						&& rtMarket
								.getBetTypeEvent()
								.getBetTypeEvent()
								.getNameId()
								.equals(CfgBetTypeEventId.PARTIDO_COMPLETO
										.nameId())) {
					result.add(rtMarket);
				}
			}
		}

		return result;
	}

	/**
	 * Gets the matchs by bet type and competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the matchs by bet type and competition {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getMatchsByBetTypeAndCompetition(
			BigInteger competitionId, BigInteger betTypeId) {
		return rtMatchRepository.getMatchsByBetTypeAndCompetition(
				competitionId, betTypeId);
	}

	/**
	 * Gets the matchs by competition filtered by bet type.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the matchs by competition filtered by bet type {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getMatchsByCompetitionFilteredByBetType(
			String competitionId) {
		return rtMatchRepository
				.getMatchsByCompetitionFilteredByBetType(competitionId);
	}

	/**
	 * Gets the matchs by hash key.
	 * 
	 * @param pMatchHashKey
	 *            the p match hash key
	 * @return the matchs by hash key
	 */

	@Override
	public List<RtMatch> getMatchsByHashKey(String pMatchHashKey) {
		return rtMatchRepository.getMatchsByHashKey(pMatchHashKey);
	}

	/**
	 * Gets the matchs by hash keys.
	 * 
	 * @param matchHashKey
	 *            the match hash key
	 * @return the matchs by hash keys {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getMatchsByHashKeys(String matchHashKey) {
		return rtMatchRepository.getMatchsByHashKeys(matchHashKey);
	}

	/**
	 * Gets the matchs by sport and country long term.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the matchs by sport and country long term {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getMatchsBySportAndCountryLongTerm(BigInteger sportId,
			BigInteger countryId) {
		List<RtMatch> result = new ArrayList<RtMatch>();
		List<CfgCompetition> competitions = competitionRepository
				.getCompetitionsBySportAndCountry(sportId, countryId);
		for (CfgCompetition competition : competitions) {
			result.addAll(rtMatchRepository.getCompetitionMatchs(competition));
		}
		return result;
	}

	/**
	 * Gets the num matchs by competition.
	 * 
	 * @param competition
	 *            the competition
	 * @param betType
	 *            the bet type
	 * @return the num matchs by competition {@inheritDoc}
	 */
	@Override
	public Long getNumMatchsByCompetition(CfgCompetition competition,
			String betType) {
		return rtMatchRepository
				.getNumMatchsByCompetition(competition, betType);
	}

	/**
	 * Gets the upcoming events.
	 * 
	 * @param currentDate
	 *            the current date
	 * @param dayRange
	 *            the day range
	 * @param minimalNumberOfBookmakers
	 *            the minimal number of bookmakers
	 * @return the upcoming events {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getUpcomingEvents(Date currentDate, int dayRange,
			final int minimalNumberOfBookmakers) {
		Date limitDate = new Date(new Date(currentDate.getTime()).getTime()
				+ daysToMili(dayRange));
		List<RtMatch> result = rtMatchRepository.getUpcomingEvents(currentDate,
				limitDate, minimalNumberOfBookmakers);

		return result;
	}

	/**
	 * Days to mili.
	 * 
	 * @param dayRange
	 *            the day range
	 * @return the long
	 */
	private long daysToMili(int dayRange) {
		return dayRange * 86400000l;
	}

	/**
	 * Map reduce get matchs by competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventIdPC
	 *            the bet type event id
	 * @param betTypeEventIdPCP
	 *            the bet type event id
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<RtMatch> mapReduceGetMatchsByCompetition(
			BigInteger competitionId, String betTypeId,
			String betTypeEventIdPC, String betTypeEventIdPCP) {
		LOG.info("Se entra en la capa de servicio. Metodo: mapReduceGetMatchsByCompetition");
		List<RtMatch> resultQuery = 
				rtMatchRepository.mapReduceGetMatchsByCompetition(competitionId,
						betTypeId, betTypeEventIdPC, betTypeEventIdPCP);

		return resultQuery;
	}

	/**
	 * Find market by bet type bet type event.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findMarketByBetTypeBetTypeEvent(String idMatch,
			String idBetType, String idBetTypeEvent) {

		LOG.info("Se entra en la capa de servicio. Metodo: findMarketByBetTypeBetTypeEvent");
		return rtMatchRepository.findMarketByBetTypeBetTypeEvent(idMatch,
				idBetType, idBetTypeEvent);
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public RtMatch findMarketAndBetType(String idMatch) {

		LOG.info("Se entra en la capa de servicio. Metodo: findMarketByBetTypeBetTypeEvent");
		return rtMatchRepository.findMarketAndBetType(idMatch);
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public RtMatch findMarketByBetType(String idMatch, String idBetType) {

		LOG.info("Se entra en la capa de servicio. Metodo: findMarketByBetTypeBetTypeEvent");
		return rtMatchRepository.findMarketByBetType(idMatch, idBetType);
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public RtMatch findNameAndCompetition(String idRtMatch) {
		LOG.info("Se entra en la capa de servicio. Metodo: findNameAndCompetition");
		return rtMatchRepository.findNameAndCompetition(idRtMatch);
	}

	/**
	 * Find market by bet type and bet type event.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt market {@inheritDoc}
	 */
	public RtMarket findMarketByBetTypeAndBetTypeEvent(String idMatch,
			String idBetType, String idBetTypeEvent) {
		RtMarket result = null;
		RtMatch aux = rtMatchRepository.findMarketByBetTypeAndBetTypeEvent(
				idMatch, idBetType, idBetTypeEvent);
		if (aux != null && aux.getRtMarkets().size() > 0) {
			result = aux.getRtMarkets().iterator().next();
		}
		return result;
	}

	
	/**
	 * Counts events types on markets of type Complete or Override from Matches, and 
	 * return the List<Match> with more events of one or other type.
	 * 
	 * In draw case, default Complete.
	 * 
	 * @param resultQuery, query's result's matchs.
	 * 
	 * @return
	 */
	private List<RtMatch> reduceMatchSelectingOnlyMatchCompleteOrMatchOverrideTypeEvent(
			List<RtMatch> resultQuery) {
		
		List<RtMatch> resultNormal		= new ArrayList<RtMatch>();
		List<RtMatch> resultProrroga	= new ArrayList<RtMatch>();
		
		for (RtMatch aMatch : resultQuery) {
			// Inicializar la cuenta para los mercados del Match.
			int countComplete = 0;
			int countCompleteOverride = 0;

			List<RtMarket> pcMarkets	= new ArrayList<RtMarket>();
			List<RtMarket> pcpMarkets 	= new ArrayList<RtMarket>();
			
			// getValue devuelve el RtMatch.
			for(RtMarket market : aMatch.getRtMarkets()){
				if(market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(
						CfgBetTypeEventId.PARTIDO_COMPLETO.objectId())) {
					pcMarkets.add(market);
					++countComplete;
				}
				else if(market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(
						CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId())){
					pcpMarkets.add(market);
					++countCompleteOverride;
				}
			}			
				
			// Si existen datos.
			if(countComplete>0||countCompleteOverride>0) {
				// Elimnar del Match los mercados porque, se van a insertar los reducidos para ese Match:
				aMatch.getRtMarkets().clear();
				
				// Si hay más datos (o igual) de Partido Completo.
				if(countComplete>=countCompleteOverride) {
					for(RtMarket aMarket : pcMarkets) {
						aMatch.getRtMarkets().add(aMarket);
					}					
					resultNormal.add(aMatch);
				} else {
					for(RtMarket aMarket : pcpMarkets) {
						aMatch.getRtMarkets().add(aMarket);
					}					
					resultProrroga.add(aMatch);
				}
			}
		}
	
		if(resultNormal.size() >= resultProrroga.size()){
			return resultNormal;
		}
		
		return resultProrroga;
	}

	@Override
	public Boolean exists(String hashKey) {
		
		return rtMatchRepository.exists(hashKey);
	}

	@Override
	public RtMatch isolatedFindByHashKey(String matchHashKey) {
		return rtMatchRepository.isolatedFindByHashKey(matchHashKey);
	}

	@Override
	public void isolateSave(RtMatch match) throws IsolatedSaveException{
		rtMatchRepository.isolateSave(match);
	}	
}
