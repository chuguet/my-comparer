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

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;

/**
 * The Class RtMatchCacheStandard.
 */
@Component
public class RtMatchCacheStandard implements IRtMatchCacheStandard {
	private static final Log LOG = LogFactory
			.getLog(RtMatchCacheStandard.class);
	/** The match service. */
	@Inject
	private IRtMatchService matchService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #findOneCustomCache(java.lang.String)
	 */
	@Override
	@Cacheable(value = "findOneCustomCache")
	public RtMatch findOneCustomCache(String id) {
		return matchService.findOneCustom(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #
	 * getBetTypesCompetitionMatchs(com.comparadorad.bet.comparer.model.config.
	 * bean .CfgCompetition)
	 */
	@Override
	@Cacheable(value = "betTypesCompetitionMatchs")
	public List<RtMatch> getBetTypesCompetitionMatchsCache(
			CfgCompetition pCompetition) {
		return matchService.getBetTypesCompetitionMatchs(pCompetition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #getCompetitionMatchHead(com.comparadorad.bet.comparer.model.config.bean.
	 * CfgCompetition)
	 */
	@Override
	@Cacheable("competitionMatchHead")
	public RtMatch getCompetitionMatchHeadCache(CfgCompetition pCompetition) {
		return matchService.getCompetitionMatchHead(pCompetition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #
	 * getCompetitionMatchHeadLongTerm(com.comparadorad.bet.comparer.model.config
	 * .bean.CfgCompetition)
	 */
	@Override
	@Cacheable("competitionMatchHeadLongTerm")
	public RtMatch getCompetitionMatchHeadLongTermCache(
			CfgCompetition pCompetition) {
		return matchService.getCompetitionMatchHeadLongTerm(pCompetition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #getLongTermCompetition(java.math.BigInteger)
	 */
	@Override
	@Cacheable(value = "longTermCompetition")
	public List<RtMatch> getLongTermCompetitionCache(BigInteger competitionId) {
		return matchService.getLongTermCompetition(competitionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #getLongTermMarketCache(java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	@Cacheable(value = "longTermMarketCache")
	public List<RtMarket> getLongTermMarketCache(BigInteger competitionId,
			BigInteger betTypeId) {
		return matchService.getLongTermMarket(competitionId, betTypeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #getMatchsByCompetitionFilteredByBetType(java.lang.String)
	 */
	@Override
	@Cacheable(value = "matchsByCompetitionFilteredByBetType")
	public List<RtMatch> getMatchsByCompetitionFilteredByBetTypeCache(
			String competitionId) {
		return matchService
				.getMatchsByCompetitionFilteredByBetType(competitionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheStandard
	 * #mapReduceGetMatchsByCompetitionCache(java.math.BigInteger,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	@Cacheable(value = "matchsByCompetitionCache")
	public List<RtMatch> mapReduceGetMatchsByCompetitionCache(
			BigInteger competitionId, String betTypeId, String betTypeEventId) {
		LOG.info("Se entra en la capa de cache standard. Metodo: mapReduceGetMatchsByCompetition");
		return matchService.mapReduceGetMatchsByCompetition(competitionId,
				betTypeId, betTypeEventId);
	}

}
