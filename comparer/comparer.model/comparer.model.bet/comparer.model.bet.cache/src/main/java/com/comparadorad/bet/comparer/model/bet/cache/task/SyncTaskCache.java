/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.task;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.cache.bean.CacheRefreshType;
import com.comparadorad.bet.comparer.model.bet.cache.bean.ParametersBean;
import com.comparadorad.bet.comparer.model.bet.cache.util.IsEmpty;
import com.comparadorad.bet.comparer.model.bet.cache.util.Queue;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;

/**
 * The Class AsyncTaskCache.
 */
// @Component
public class SyncTaskCache implements ISyncTaskCache {

	@Inject
	private Queue<ParametersBean> queueParameters;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SyncTaskCache.class);

	/** The cache manager. */
	@Resource
	private CacheManager cacheManager;

	/** The match service. */
	@Inject
	private IRtMatchService matchService;

	/**
	 * Creates the markets collection elements.
	 * 
	 * @param markets
	 *            the markets
	 * @return the collection
	 */
	private Collection<Element> createMarketsCollectionElements(
			List<RtMarket> markets) {
		Collection<Element> result = new ArrayList<Element>();
		Element element;
		for (RtMarket market : markets) {
			element = new Element(market.getObjectId().toString(), market);
			result.add(element);
		}
		return result;
	}

	/**
	 * Creates the matchs collection elements.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the collection
	 */
	private Collection<Element> createMatchsCollectionElements(
			List<RtMatch> matchs) {
		Collection<Element> result = new ArrayList<Element>();
		Element element;
		for (RtMatch match : matchs) {
			element = new Element(match.getObjectId().toString(), match);
			result.add(element);
		}
		return result;
	}

	/**
	 * Gets the cache.
	 * 
	 * @param regionName
	 *            the region name
	 * @return the cache
	 */
	private net.sf.ehcache.Cache getCache(String regionName) {
		final Cache cache = cacheManager.getCache(regionName);
		return (net.sf.ehcache.Cache) cache.getNativeCache();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.cache.task.IAsyncTaskCache#
	 * refreshCache
	 * (com.comparadorad.bet.comparer.model.bet.cache.bean.ParametersBean)
	 */
	// @Scheduled(fixedDelay = 1000)
	@Override
	public void refreshCache() {
		LOG.info("Se comienza la tarea sincrona");
		ParametersBean parametersBean;
		try {
			parametersBean = queueParameters.pop();
			LOG.info("--------------------------------------------");
			LOG.info(new StringBuffer(
					"Se comienza la tarea sincrona para la region de cache ")
					.append(parametersBean.getCacheRefreshType()
							.getRegionCache()).toString());
			LOG.info(new StringBuffer("Con los parametros: ")
					.append(parametersBean.toString()));
			if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.COMPETITION_MATCH_HEAD)) {
				this.refreshCacheGetCompetitionMatchHeadCacheCustom(
						parametersBean.getCacheRefreshType().getRegionCache(),
						parametersBean);
			} else if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.COMPETITION_MATCH_HEAD_LONG_TERM)) {
				this.refreshCacheGetCompetitionMatchHeadLongTermCacheCustom(
						parametersBean.getCacheRefreshType().getRegionCache(),
						parametersBean);
			} else if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.FIND_ONE_CUSTOM_CACHE_CUSTOM)) {
				this.refreshCacheFindOneCustomCacheCustom(parametersBean
						.getCacheRefreshType().getRegionCache(), parametersBean);
			} else if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.GET_BET_TYPES_COMPETITION_MATCHS)) {
				this.refreshCacheGetBetTypesCompetitionMatchsCacheCustom(
						parametersBean.getCacheRefreshType().getRegionCache(),
						parametersBean);
			} else if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.LONG_TERM_COMPETITION)) {
				this.refreshCacheGetLongTermCompetitionCacheCustom(
						parametersBean.getCacheRefreshType().getRegionCache(),
						parametersBean);
			} else if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.LONG_TERM_MARKET)) {
				this.refreshCacheGetLongTermMarketCacheCustom(parametersBean
						.getCacheRefreshType().getRegionCache(), parametersBean);
			} else if (parametersBean.getCacheRefreshType().equals(
					CacheRefreshType.MAP_REDUCE_GET_MATCHS_BY_COMPETITION)) {
				this.refreshCacheMapReduceGetMatchsByCompetitionCacheCustom(
						parametersBean.getCacheRefreshType().getRegionCache(),
						parametersBean);
			} else if (parametersBean
					.getCacheRefreshType()
					.equals(CacheRefreshType.MATCHS_BY_COMPETITION_FILTERED_BY_BET_TYPE)) {
				this.refreshCacheMatchsByCompetitionFilteredByBetType(
						parametersBean.getCacheRefreshType().getRegionCache(),
						parametersBean);
			} else {
				LOG.info("No se ha actualizado ninguna region de cache.");
			}
		} catch (IsEmpty e) {
			LOG.info(e.getMessage());
		}
		LOG.info("Se finaliza correctamente la tarea sincrona");
		LOG.info("--------------------------------------------");
	}

	/**
	 * Refresh cache find one custom cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheFindOneCustomCacheCustom(String regionCache,
			ParametersBean parametersBean) {
		getCache(regionCache).remove(parametersBean.getIdMatch());
		getCache(regionCache).put(
				new Element(parametersBean.getIdMatch(), matchService
						.findOneCustom(parametersBean.getIdMatch())));
	}

	/**
	 * Refresh cache get bet types competition matchs cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheGetBetTypesCompetitionMatchsCacheCustom(
			String regionCache, ParametersBean parametersBean) {
		List<RtMatch> matchs = matchService
				.getBetTypesCompetitionMatchs(parametersBean.getCompetition());
		getCache(regionCache).removeAll(matchs);
		Collection<Element> result = createMatchsCollectionElements(matchs);
		getCache(regionCache).putAll(result);
	}

	/**
	 * Refresh cache get competition match head cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheGetCompetitionMatchHeadCacheCustom(
			String regionCache, ParametersBean parametersBean) {
		RtMatch match = matchService.getCompetitionMatchHead(parametersBean
				.getCompetition());
		if (match != null) {
			getCache(regionCache).remove(match.getObjectId().toString());
			getCache(regionCache).put(
					new Element(match.getObjectId().toString(), match));
		}
	}

	/**
	 * Refresh cache get competition match head long term cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheGetCompetitionMatchHeadLongTermCacheCustom(
			String regionCache, ParametersBean parametersBean) {
		RtMatch match = matchService
				.getCompetitionMatchHeadLongTerm(parametersBean
						.getCompetition());
		if (match != null) {
			getCache(regionCache).remove(match.getObjectId().toString());
			getCache(regionCache).put(
					new Element(match.getObjectId().toString(), match));
		}
	}

	/**
	 * Refresh cache get long term competition cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheGetLongTermCompetitionCacheCustom(
			String regionCache, ParametersBean parametersBean) {
		List<RtMatch> matchs = matchService
				.getLongTermCompetition(new BigInteger(parametersBean
						.getCompetitionId()));
		getCache(regionCache).removeAll(matchs);
		Collection<Element> result = createMatchsCollectionElements(matchs);
		getCache(regionCache).putAll(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.cache.task.IAsyncTaskCache#
	 * refreshCacheLongTermMarketCacheCustom(java.lang.String,
	 * com.comparadorad.bet.comparer.model.bet.cache.bean.ParametersBean)
	 */
	/**
	 * Refresh cache long term market cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheGetLongTermMarketCacheCustom(String regionCache,
			ParametersBean parametersBean) {
		List<RtMarket> markets = matchService.getLongTermMarket(new BigInteger(
				parametersBean.getCompetitionId()), new BigInteger(
				parametersBean.getBetTypeId()));
		getCache(regionCache).removeAll(markets);
		Collection<Element> result = createMarketsCollectionElements(markets);
		getCache(regionCache).putAll(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.cache.task.IAsyncTaskCache#
	 * refreshCacheMapReduceGetMatchsByCompetitionCacheCustom(java.lang.String,
	 * com.comparadorad.bet.comparer.model.bet.cache.bean.ParametersBean)
	 */
	/**
	 * Refresh cache map reduce get matchs by competition cache custom.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheMapReduceGetMatchsByCompetitionCacheCustom(
			String regionCache, ParametersBean parametersBean) {
		List<RtMatch> matchs = matchService.mapReduceGetMatchsByCompetition(
				new BigInteger(parametersBean.getCompetitionId()),
				parametersBean.getBetTypeId(),
				parametersBean.getBetTypeEventId());
		getCache(regionCache).removeAll(matchs);
		Collection<Element> result = createMatchsCollectionElements(matchs);
		getCache(regionCache).putAll(result);
	}

	/**
	 * Refresh cache matchs by competition filtered by bet type.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	private void refreshCacheMatchsByCompetitionFilteredByBetType(
			String regionCache, ParametersBean parametersBean) {
		List<RtMatch> matchs = matchService
				.getMatchsByCompetitionFilteredByBetType(parametersBean
						.getCompetitionId());
		getCache(regionCache).removeAll(matchs);
		Collection<Element> result = createMatchsCollectionElements(matchs);
		getCache(regionCache).putAll(result);
	}
}
