/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;

/**
 * The Class ValueBetHistoricRepositoryCustomImpl.
 * 
 * @param <T>
 *            the generic type
 */
class ValueBetHistoricRepositoryCustomImpl<T extends ValueBetHistoricData>
		extends AbstractCfgRepository<T> implements
		ValueBetHistoricRepositoryCustom<T> {

	/** {@inheritDoc} */
	@Override
	public List<ValueBetHistoricData> exist(String idMatch,
			String marketHashKey, String betHashKey) {

		InfoMatch match = new InfoMatch();
		match.setObjectId(idMatch);

		Query query = new Query(where("infoMatch._id")
				.is(getConvertedId(match)).and("bet.hashKey").is(betHashKey)
				.and("infoMatch.market.hashKey").is(marketHashKey));

		return getMongoTemplate().find(query, ValueBetHistoricData.class);
	}

	/** {@inheritDoc} */
	@Override
	public List<ValueBetHistoricData> exist(ValueBetData valueBetData) {

		return exist(valueBetData.getInfoMatch().getObjectId().toString(),
				valueBetData.getInfoMatch().getMarket().getHashKey(),
				valueBetData.getBet().getHashKey());
	}

	/** {@inheritDoc} */
	@Override
	public List<ValueBetHistoricData> exist(
			ValueBetHistoricData valueBetHistoricData) {

		return exist(valueBetHistoricData.getInfoMatch().getObjectId()
				.toString(), valueBetHistoricData.getInfoMatch().getMarket()
				.getHashKey(), valueBetHistoricData.getBet().getHashKey());

	}

}
