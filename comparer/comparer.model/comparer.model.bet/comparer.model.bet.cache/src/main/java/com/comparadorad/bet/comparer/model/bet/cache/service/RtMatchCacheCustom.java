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
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.cache.bean.CacheRefreshType;
import com.comparadorad.bet.comparer.model.bet.cache.bean.ParametersBean;
import com.comparadorad.bet.comparer.model.bet.cache.util.AlreadyContains;
import com.comparadorad.bet.comparer.model.bet.cache.util.Queue;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;

/**
 * The Class RtMatchCacheCustom.
 */
@Component
public class RtMatchCacheCustom implements IRtMatchCacheCustom {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtMatchCacheCustom.class);

	/** The queue. */
	@Inject
	private Queue<ParametersBean> queue;

	/** The match cache standard. */
	@Inject
	private IRtMatchCacheStandard matchCacheStandard;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #findOneCustomCacheCustom(java.lang.String)
	 */
	/**
	 * Find one custom cache custom.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the rt match
	 */
	@Override
	public RtMatch findOneCustomCacheCustom(String idMatch) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.FIND_ONE_CUSTOM_CACHE_CUSTOM, idMatch, null,
				null, null, null);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}

		return matchCacheStandard.findOneCustomCache(idMatch);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #
	 * getBetTypesCompetitionMatchsCacheCustom(com.comparadorad.bet.comparer.model
	 * .config.bean.CfgCompetition)
	 */
	@Override
	public List<RtMatch> getBetTypesCompetitionMatchsCacheCustom(
			CfgCompetition pCompetition) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.GET_BET_TYPES_COMPETITION_MATCHS, null, null,
				null, null, pCompetition);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard
				.getBetTypesCompetitionMatchsCache(pCompetition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #
	 * getCompetitionMatchHeadCacheCustom(com.comparadorad.bet.comparer.model.config
	 * .bean.CfgCompetition)
	 */
	@Override
	public RtMatch getCompetitionMatchHeadCacheCustom(
			CfgCompetition pCompetition) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.COMPETITION_MATCH_HEAD, null, null, null,
				null, pCompetition);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard.getCompetitionMatchHeadCache(pCompetition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #
	 * getCompetitionMatchHeadLongTermCacheCustom(com.comparadorad.bet.comparer.
	 * model.config.bean.CfgCompetition)
	 */
	@Override
	public RtMatch getCompetitionMatchHeadLongTermCacheCustom(
			CfgCompetition pCompetition) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.COMPETITION_MATCH_HEAD_LONG_TERM, null, null,
				null, null, pCompetition);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard
				.getCompetitionMatchHeadLongTermCache(pCompetition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #getLongTermCompetitionCacheCustom(java.math.BigInteger)
	 */
	@Override
	public List<RtMatch> getLongTermCompetitionCacheCustom(
			BigInteger competitionId) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.LONG_TERM_COMPETITION, null,
				competitionId.toString(), null, null, null);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard.getLongTermCompetitionCache(competitionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #getLongTermMarketCacheCustom(java.math.BigInteger, java.math.BigInteger)
	 */
	/**
	 * Gets the long term market cache custom.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @return the long term market cache custom
	 */
	@Override
	public List<RtMarket> getLongTermMarketCacheCustom(
			BigInteger competitionId, BigInteger betTypeId) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.LONG_TERM_MARKET, null,
				competitionId.toString(), betTypeId.toString(), null, null);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard.getLongTermMarketCache(competitionId,
				betTypeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #getMatchsByCompetitionFilteredByBetTypeCacheCustom(java.lang.String)
	 */
	@Override
	public List<RtMatch> getMatchsByCompetitionFilteredByBetTypeCacheCustom(
			String competitionId) {
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.MATCHS_BY_COMPETITION_FILTERED_BY_BET_TYPE,
				null, competitionId.toString(), null, null, null);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard
				.getMatchsByCompetitionFilteredByBetTypeCache(competitionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom
	 * #mapReduceGetMatchsByCompetitionCacheCustom(java.math.BigInteger,
	 * java.lang.String, java.lang.String)
	 */
	/**
	 * Map reduce get matchs by competition cache custom.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventId
	 *            the bet type event id
	 * @return the list
	 */
	@Override
	public List<RtMatch> mapReduceGetMatchsByCompetitionCacheCustom(
			BigInteger competitionId, String betTypeId, String betTypeEventId) {
		LOG.info("Se entra en la capa de cache custom. Metodo: mapReduceGetMatchsByCompetition");
		ParametersBean parametersBean = new ParametersBean(
				CacheRefreshType.MAP_REDUCE_GET_MATCHS_BY_COMPETITION, null,
				competitionId.toString(), betTypeId, betTypeEventId, null);
		try {
			queue.push(parametersBean);
		} catch (AlreadyContains e) {
			LOG.debug(e.getMessage());
		}
		return matchCacheStandard.mapReduceGetMatchsByCompetitionCache(
				competitionId, betTypeId, betTypeEventId);
	}
}
