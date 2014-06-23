/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;

/**
 * The Class CfgCompetitionEventRepositoryCustomImpl.
 */
class CfgCompetitionEventRepositoryCustomImpl extends
		AbstractCfgRepository<CfgCompetitionEvent> implements
		CfgCompetitionEventRepositoryCustom<CfgCompetitionEvent> {

	/**
	 * Custom find byname.
	 *
	 * @param pName the name
	 * @return the list
	 * {@inheritDoc}
	 */
	@Override
	public List<CfgCompetitionEvent> customFindByname(String pName) {
		Query q1 = new Query(where("i18n.i18nFields.string").is(pName));
		return getMongoTemplate().find(q1, CfgCompetitionEvent.class);
	}

	 /**
 	 * Custom find by long term.
 	 *
 	 * @param isLongTerm the is long term
 	 * @return the list
 	 * {@inheritDoc}
 	 */ 
	@Override
	public List<CfgCompetitionEvent> customFindByLongTerm(boolean isLongTerm) {
		Query q1 = new Query(where("longTerm.longTerm").is(isLongTerm));
		return getMongoTemplate().find(q1, CfgCompetitionEvent.class);
	}

}
