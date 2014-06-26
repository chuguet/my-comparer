/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.valuebet.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;

/**
 * The Interface IValueBetService.
 */
public interface IValueBetService extends IGenericCrudService<ValueBetData> {

	/**
	 * Exist.
	 * 
	 * @param matchId
	 *            the match id
	 * @param marketHashKey
	 *            the market hash key
	 * @param betHashKey
	 *            the bet hash key
	 * @return the list
	 */
	List<ValueBetData> exist(String matchId, String marketHashKey,
			String betHashKey);

	/**
	 * Exist.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @return the boolean
	 */
	List<ValueBetData> exist(ValueBetData valueBetData);

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<ValueBetData> findAllLimit(Integer limit, Integer skip);

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	Long getCount();

	/**
	 * Gets the differing match value bets.
	 * 
	 * @param matchId
	 *            the match id
	 * @param hashKeysMarket
	 *            the hash keys market
	 * @param hashKeysBet
	 *            the hash keys bet
	 * @return the differing match value bets
	 */
	List<ValueBetData> getDifferingMatchValueBets(String matchId,
			List<String> hashKeysMarket, List<String> hashKeysBet);

	/**
	 * Gets the value bet from num days.
	 * 
	 * @param numDays
	 *            the num days
	 * @return the value bet from num days
	 */
	List<ValueBetData> getValueBetFromNumDays(Integer numDays);

	/**
	 * Gets the value bet page.
	 * 
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the value bet page
	 */
	List<ValueBetData> getValueBetPage(int PageSize, long PageNumber);

	/**
	 * Update.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 */
	void update(ValueBetData valueBetDataDB, ValueBetData valueBetData);

}