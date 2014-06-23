/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;

/**
 * The Class CfgBetTypeEventSynonymsRepositoryCustomImpl.
 */
class CfgBetTypeEventSynonymsRepositoryCustomImpl extends
		AbstractCfgSynonymsRepositoryCustomImpl<CfgBetTypeEventSynonyms> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.ISynonymsRepository#
	 * findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgBetTypeEventSynonyms> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgBetTypeEventSynonyms> listResult = getMongoTemplate().find(
				query, CfgBetTypeEventSynonyms.class);
		return listResult;
	}

	/**
	 * Gets the model class.
	 * 
	 * @return the model class {@inheritDoc}
	 */
	@Override
	protected Class<CfgBetTypeEventSynonyms> getModelClass() {
		return CfgBetTypeEventSynonyms.class;
	}
}
