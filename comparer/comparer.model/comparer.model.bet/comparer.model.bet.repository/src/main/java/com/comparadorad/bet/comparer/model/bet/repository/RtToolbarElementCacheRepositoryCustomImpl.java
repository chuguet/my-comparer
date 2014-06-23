/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CompetitionToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportToolbar;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;

/**
 * The Class RtToolbarElementRepositoryCustomImpl.
 * 
 * @param <T>
 *            the generic type
 */
class RtToolbarElementCacheRepositoryCustomImpl<T extends RtToolbarElementCache>
		extends AbstractRepository<T> implements
		RtToolbarElementCacheRepositoryCustom<T> {

	/** The Constant LIMIT. */
	private static final Integer LIMIT = 100;

	/** The cfg competition repository. */
	@Inject
	private CfgCompetitionRepository cfgCompetitionRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementCacheRepositoryCustom#findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<RtToolbarElementCache> findAllLimit(Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(LIMIT);

		List<RtToolbarElementCache> listResult = getMongoTemplate().find(query,
				RtToolbarElementCache.class);

		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementCacheRepositoryCustom#getFirstLevelToolbar()
	 */
	@Override
	public List<RtToolbarElementCache> generateFirstLevelToolbar() {
		List<RtToolbarElementCache> result = new ArrayList<RtToolbarElementCache>();
		RtToolbarElementCache toolbarElementCache;

		List<SportToolbar> sportsToolbar = cfgCompetitionRepository
				.mapReduceToolbarSport();
		for (SportToolbar sportToolbar : sportsToolbar) {
			toolbarElementCache = new RtToolbarElementCache(null, new CfgSport(
					sportToolbar.getId()), new CoreActiveElement(Boolean.TRUE));
			result.add(toolbarElementCache);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementCacheRepositoryCustom
	 * #getSecondLevelToolbar(com.comparadorad
	 * .bet.comparer.model.bet.bean.RtToolbarElement, java.lang.String)
	 */
	@Override
	public List<RtToolbarElementCache> generateSecondLevelToolbar(
			RtToolbarElementCache parent, String sportId) {
		List<RtToolbarElementCache> result = new ArrayList<RtToolbarElementCache>();
		RtToolbarElementCache toolbarElementCache;

		List<CountryToolbar> countriesToolbar = cfgCompetitionRepository
				.mapReduceToolbarCountry(sportId);
		for (CountryToolbar countryToolbar : countriesToolbar) {
			toolbarElementCache = new RtToolbarElementCache(parent,
					new CfgRegion(countryToolbar.getId()),
					new CoreActiveElement(Boolean.TRUE));
			result.add(toolbarElementCache);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementCacheRepositoryCustom
	 * #getThirdLevelToolbar(com.comparadorad
	 * .bet.comparer.model.bet.bean.RtToolbarElement, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<RtToolbarElementCache> generateThirdLevelToolbar(
			RtToolbarElementCache parent, String sportId, String countryId) {
		List<RtToolbarElementCache> result = new ArrayList<RtToolbarElementCache>();
		RtToolbarElementCache toolbarElementCache;

		List<CompetitionToolbar> competitionsToolbar = cfgCompetitionRepository
				.mapReduceToolbarCompetition(sportId, countryId);
		for (CompetitionToolbar competitionToolbar : competitionsToolbar) {
			toolbarElementCache = new RtToolbarElementCache(parent,
					new CfgCompetition(competitionToolbar.getId()),
					new CoreActiveElement(Boolean.TRUE));
			result.add(toolbarElementCache);
		}

		return result;
	}

}
