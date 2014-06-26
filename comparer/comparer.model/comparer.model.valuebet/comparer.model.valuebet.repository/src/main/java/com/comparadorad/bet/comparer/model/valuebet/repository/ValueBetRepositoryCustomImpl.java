/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;

/**
 * The Class ValueBetRepositoryCustomImpl.
 * 
 * @param <T>
 *            the generic type
 */
class ValueBetRepositoryCustomImpl<T extends ValueBetData> extends
		AbstractCfgRepository<T> implements ValueBetRepositoryCustom<T> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ValueBetRepositoryCustomImpl.class);

	/** {@inheritDoc} */
	@Override
	public List<ValueBetData> exist(String matchId, String marketHashKey,
			String betHashKey) {

		InfoMatch match = new InfoMatch();
		match.setObjectId(matchId);

		Query query = new Query(where("infoMatch._id")
				.is(getConvertedId(match)).and("bet.hashKey").is(betHashKey)
				.and("infoMatch.market.hashKey").is(marketHashKey));

		return getMongoTemplate().find(query, ValueBetData.class);
	}

	/**
	 * Exist. Si es el mismo partido, la misma apuesta (bet) y el mismo mercado.
	 * 
	 * @param valueBeanData
	 *            the value bean data
	 * @return the boolean {@inheritDoc}
	 */
	@Override
	public List<ValueBetData> exist(ValueBetData valueBeanData) {

		return exist(valueBeanData.getInfoMatch().getObjectId().toString(),
				valueBeanData.getInfoMatch().getMarket().getHashKey(),
				valueBeanData.getBet().getHashKey());

	}

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<ValueBetData> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<ValueBetData> listResult = getMongoTemplate().find(query,
				ValueBetData.class);
		return listResult;
	}

	/**
	 * Devuele todos los valuebets del market que NO corresponden a ninguna de
	 * las parejas hashKeyMarket - hashKeyBet que se pasa al metodo.
	 * 
	 * @param matchId
	 *            the match id
	 * @param hashKeysMarket
	 *            the hash keys market
	 * @param hashKeysBet
	 *            the hash keys bet
	 * @return the differing match value bets {@inheritDoc}
	 */
	@Override
	public List<ValueBetData> getDifferingMatchValueBets(String matchId,
			List<String> hashKeysMarket, List<String> hashKeysBet) {

		List<ValueBetData> result = new ArrayList<ValueBetData>();

		InfoMatch match = new InfoMatch();
		match.setObjectId(matchId);
		Criteria[] criterias = new Criteria[hashKeysMarket.size()];
		Criteria marketBetPairCriteria;

		for (int i = 0; i < hashKeysMarket.size(); i++) {

			marketBetPairCriteria = new Criteria();
			marketBetPairCriteria.andOperator(
					Criteria.where("infoMatch.market.hashKey").is(
							hashKeysMarket.get(i)),
					Criteria.where("bet.hashKey").is(hashKeysBet.get(i)));

			criterias[i] = marketBetPairCriteria;
		}

		Query query = new Query(where("infoMatch._id")
				.is(getConvertedId(match)).norOperator(criterias));

		result = getMongoTemplate().find(query, ValueBetData.class);

		return result;
	}

	/**
	 * Gets the value bet from num days.
	 * 
	 * @param numDays
	 *            the num days
	 * @return the value bet from num days {@inheritDoc}
	 */
	@Override
	public List<ValueBetData> getValueBetFromNumDays(Integer numDays) {
		List<ValueBetData> result = new ArrayList<ValueBetData>();
		Date now = new Date();
		Date future = new DateTime().plusDays(numDays).toDate();

		Criteria criteria = new Criteria().andOperator(
				Criteria.where("infoMatch.date").exists(true).gt(now), Criteria
						.where("infoMatch.date").exists(true).lt(future));

		Query query = new Query(criteria);

		result = getMongoTemplate().find(query, ValueBetData.class);

		return result;
	}

	/**
	 * Gets the value bet page.
	 * 
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the value bet page {@inheritDoc}
	 */
	public List<ValueBetData> getValueBetPage(int PageSize, long PageNumber) {
		List<ValueBetData> result;

		Query query = new Query();

		Order order1 = new Order(Direction.DESC, "expectation.value");
		Order order2 = new Order(Direction.DESC, "probability.value");
		Order[] orders = new Order[2];
		orders[0] = order1;
		orders[1] = order2;
		Sort sort = new Sort(orders);
		query.with(sort);

		query.skip((int) (PageSize * PageNumber));
		query.limit(PageSize);
		
		query.fields().include("_id");
		query.fields().include("bet");
		query.fields().include("probability");
		query.fields().include("expectation");
		query.fields().include("betTypeEvent.nameId");
		query.fields().include("infoMatch");

		result = getMongoTemplate().find(query, ValueBetData.class);

		return result;
	}

	/**
	 * Update.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data {@inheritDoc}
	 */
	@Override
	public void update(ValueBetData valueBetDataDB, ValueBetData valueBetData) {

		valueBetDataDB.setBet(valueBetData.getBet());
		valueBetDataDB.setExpectation(valueBetData.getExpectation());
		valueBetDataDB.setInfoMatch(valueBetData.getInfoMatch());
		valueBetDataDB.setProbability(valueBetData.getProbability());
		valueBetData.setLastVerificationDate(new CoreDate(Calendar
				.getInstance().getTime()));

		getMongoTemplate().save(valueBetDataDB);
	}

}
