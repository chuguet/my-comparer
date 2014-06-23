/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;

/**
 * The Class CfgCompetitionSynonymsRepositoryCustomImpl.
 */
class CfgRegionSynonymsRepositoryCustomImpl extends
		AbstractCfgSynonymsRepositoryCustomImpl<CfgRegionSynonyms> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgRegionSynonymsRepositoryCustomImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.ISynonymsRepository#
	 * findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgRegionSynonyms> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgRegionSynonyms> listResult = getMongoTemplate().find(query,
				CfgRegionSynonyms.class);
		return listResult;
	}

	/**
	 * Gets the model class.
	 * 
	 * @return the model class {@inheritDoc}
	 */
	@Override
	protected Class<CfgRegionSynonyms> getModelClass() {
		return CfgRegionSynonyms.class;
	}

}
