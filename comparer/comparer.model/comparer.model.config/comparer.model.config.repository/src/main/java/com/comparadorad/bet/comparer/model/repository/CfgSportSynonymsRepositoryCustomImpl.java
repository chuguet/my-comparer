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

import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;

/**
 * The Class CfgSportSynonymsRepositoryCustomImpl.
 */
class CfgSportSynonymsRepositoryCustomImpl extends
		AbstractCfgSynonymsRepositoryCustomImpl<CfgSportSynonyms> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgSportSynonymsRepositoryCustomImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.ISynonymsRepository#
	 * findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgSportSynonyms> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgSportSynonyms> listResult = getMongoTemplate().find(query,
				CfgSportSynonyms.class);
		return listResult;
	}

	/**
	 * Gets the model class.
	 * 
	 * @return the model class {@inheritDoc}
	 */
	@Override
	protected Class<CfgSportSynonyms> getModelClass() {
		return CfgSportSynonyms.class;
	}

}
