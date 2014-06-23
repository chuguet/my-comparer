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

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;

/**
 * The Class CfgParticipantRepositoryCustomImpl.
 */
class CfgSportRepositoryCustomImpl extends AbstractCfgRepository<CfgSport>
		implements CfgSportRepositoryCustom<CfgSport> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgSportRepositoryCustom
	 * #findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgSport> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgSport> listResult = getMongoTemplate().find(query,
				CfgSport.class);
		return listResult;
	}

}
