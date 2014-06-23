/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;

/**
 * The Class RtToolbarElementRepositoryCustomImpl.
 * 
 * @param <T>
 *            the generic type
 */
class RtToolbarElementRepositoryCustomImpl<T extends RtToolbarElement> extends
		AbstractRepository<T> implements RtToolbarElementRepositoryCustom<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementRepositoryCustom#getFirstLevel()
	 */
	@Override
	public List<RtToolbarElement> getFirstLevel() {
		List<RtToolbarElement> result;

		Query query = new Query(where("coreActiveElement.Active").is(true)
				.and("toolbarConfigurable.$ref").is("cfgSport"));
		result = getMongoTemplate().find(query, RtToolbarElement.class);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementRepositoryCustom#getSecondLevel(java.lang.String)
	 */
	@Override
	public List<RtToolbarElement> getSecondLevel(String sportId) {
		List<RtToolbarElement> result;
		RtToolbarElement parent;
		Query query;

		query = new Query(where("coreActiveElement.Active").is(true)
				.and("toolbarConfigurable.$ref").is("cfgSport")
				.and("toolbarConfigurable.$id").is(sportId));
		query.fields().include("_id");
		parent = getMongoTemplate().findOne(query, RtToolbarElement.class);

		query = new Query(where("coreActiveElement.Active").is(true)
				.and("toolbarConfigurable.$ref").is("cfgRegion")
				.and("parentElement.$id").is(getConvertedId(parent)));
		result = getMongoTemplate().find(query, RtToolbarElement.class);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.repository.
	 * RtToolbarElementRepositoryCustom#getThirdLevel(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<RtToolbarElement> getThirdLevel(String sportId, String regionId) {
		List<RtToolbarElement> result;
		RtToolbarElement parent;
		Query query;

		query = new Query(where("coreActiveElement.Active").is(true)
				.and("toolbarConfigurable.$ref").is("cfgSport")
				.and("toolbarConfigurable.$id").is(sportId));
		query.fields().include("_id");
		parent = getMongoTemplate().findOne(query, RtToolbarElement.class);

		query = new Query(where("coreActiveElement.Active").is(true)
				.and("toolbarConfigurable.$ref").is("cfgRegion")
				.and("toolbarConfigurable.$id").is(regionId)
				.and("parentElement.$id").is(getConvertedId(parent)));
		query.fields().include("_id");
		parent = getMongoTemplate().findOne(query, RtToolbarElement.class);

		query = new Query(where("coreActiveElement.Active").is(true)
				.and("toolbarConfigurable.$ref").is("cfgCompetition")
				.and("parentElement.$id").is(getConvertedId(parent)));
		result = getMongoTemplate().find(query, RtToolbarElement.class);

		return result;
	}

}
