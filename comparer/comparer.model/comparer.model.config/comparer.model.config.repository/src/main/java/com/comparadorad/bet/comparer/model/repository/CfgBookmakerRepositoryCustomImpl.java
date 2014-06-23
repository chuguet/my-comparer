/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class CfgBookmakerRepositoryCustomImpl.
 */
class CfgBookmakerRepositoryCustomImpl extends
		AbstractCfgRepository<CfgBookmaker> implements
		CfgBookmakerRepositoryCustom<CfgBookmaker> {

	private static final Long MINUTES_30 = 1800000l;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepositoryCustom
	 * #getActiveBookmakers()
	 */
	@Override
	public Long getActiveBookmakers() {
		Long result;

		Query query = new Query(where("coreActiveElement.active").is(true));

		result = getMongoTemplate().count(query, CfgBookmaker.class);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepositoryCustom
	 * #findAllTimesForDeleteBets()
	 */
	@Override
	public Map<BigInteger, Long> findAllTimesForDeleteBets() {
		Map<BigInteger, Long> result = new HashMap<BigInteger, Long>();
		List<CfgBookmaker> bookmakers;
		Query query;
		
		query = new Query(where("coreActiveElement.active").is(true));
		query.fields().include("_id");
		query.fields().include("bookmakerConfiguration.minutesForDeleteBets");
		
		bookmakers = getMongoTemplate().find(query,
				CfgBookmaker.class);

		for (CfgBookmaker bookmaker : bookmakers) {
			if (bookmaker.getBookmakerConfiguration().getMinutesForDeleteBets() == null) {
				result.put(bookmaker.getObjectId(), MINUTES_30);
			} else {
				result.put(bookmaker.getObjectId(), bookmaker
						.getBookmakerConfiguration().getMinutesForDeleteBets());
			}
		}

		return result;
	}

}
