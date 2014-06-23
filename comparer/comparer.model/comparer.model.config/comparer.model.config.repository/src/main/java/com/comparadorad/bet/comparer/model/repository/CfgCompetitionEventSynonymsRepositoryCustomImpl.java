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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;

/**
 * The Class CfgCompetitionEventSynonymsRepositoryCustomImpl.
 */
class CfgCompetitionEventSynonymsRepositoryCustomImpl extends
		AbstractCfgSynonymsRepositoryCustomImpl<CfgCompetitionEventSynonyms> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgCompetitionSynonymsRepositoryCustomImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.ISynonymsRepository#
	 * findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgCompetitionEventSynonyms> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgCompetitionEventSynonyms> listResult = getMongoTemplate().find(
				query, CfgCompetitionEventSynonyms.class);
		return listResult;
	}

	/**
	 * Gets the model class.
	 * 
	 * @return the model class {@inheritDoc}
	 */
	@Override
	protected Class<CfgCompetitionEventSynonyms> getModelClass() {
		return CfgCompetitionEventSynonyms.class;
	}
}
