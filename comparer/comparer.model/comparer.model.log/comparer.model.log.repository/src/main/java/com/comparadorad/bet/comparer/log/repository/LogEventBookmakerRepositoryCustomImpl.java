/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.log.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;

/**
 * The Class CfgBetTypeRepositoryCustomImpl.
 */
class LogEventBookmakerRepositoryCustomImpl extends
		AbstractRepository<LogEventBookmaker> implements
		IGenericCustomRepository<LogEventBookmaker>,
		LogEventBookmakerRepositoryCustom<LogEventBookmaker> {

	/** {@inheritDoc} */
	@Override
	public List<LogEventBookmaker> customFindByBookmakerAndState(
			CfgBookmaker bookmaker, LogState pLogState) {
		Query q1 = new Query(where("bookmaker.$id")
				.is(getConvertedId(bookmaker)).and("logState")
				.is(pLogState.getState())).limit(1000);
		return getMongoTemplate().find(q1, LogEventBookmaker.class);
	}
}
