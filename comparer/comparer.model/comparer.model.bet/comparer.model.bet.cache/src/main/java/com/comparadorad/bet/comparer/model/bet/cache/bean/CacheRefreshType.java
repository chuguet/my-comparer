/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.bean;

/**
 * The Enum CacheRefreshType.
 */
public enum CacheRefreshType {

	/** The COMPETITIO n_ matc h_ head. */
	COMPETITION_MATCH_HEAD("competitionMatchHead"),

	/** The COMPETITIO n_ matc h_ hea d_ lon g_ term. */
	COMPETITION_MATCH_HEAD_LONG_TERM("competitionMatchHeadLongTerm"),

	/** The FIN d_ on e_ custo m_ cach e_ custom. */
	FIND_ONE_CUSTOM_CACHE_CUSTOM("findOneCustomCache"),

	/** The GE t_ be t_ type s_ competitio n_ matchs. */
	GET_BET_TYPES_COMPETITION_MATCHS("betTypesCompetitionMatchs"),

	/** The LON g_ ter m_ competition. */
	LONG_TERM_COMPETITION("longTermCompetition"),

	/** The LON g_ ter m_ market. */
	LONG_TERM_MARKET("longTermMarketCache"),

	/** The MA p_ reduc e_ ge t_ match s_ b y_ competition. */
	MAP_REDUCE_GET_MATCHS_BY_COMPETITION("matchsByCompetitionCache"),

	/** The MATCH s_ b y_ competitio n_ filtere d_ b y_ be t_ type. */
	MATCHS_BY_COMPETITION_FILTERED_BY_BET_TYPE(
			"matchsByCompetitionFilteredByBetType");

	/** The region cache. */
	private String regionCache;

	/**
	 * Instantiates a new cache refresh type.
	 * 
	 * @param pRegionCache
	 *            the region cache
	 */
	private CacheRefreshType(String pRegionCache) {
		this.regionCache = pRegionCache;
	}

	/**
	 * Gets the region cache.
	 * 
	 * @return the region cache
	 */
	public String getRegionCache() {
		return this.regionCache;
	}
}
