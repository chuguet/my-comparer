/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.repository.ValueBetRepository;

/**
 * The Class ValueBetService.
 */
@Service
class ValueBetService extends AbstractGenericCrudService<ValueBetData>
		implements IValueBetService {

	/** The sport repository. */
	@Inject
	private ValueBetRepository valueBetRepository;

	/** {@inheritDoc} */
	@Override
	public List<ValueBetData> exist(String matchId, String marketHashKey,
			String betHashKey) {
		return valueBetRepository.exist(matchId, marketHashKey, betHashKey);
	}

	/**
	 * Exist.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @return the boolean {@inheritDoc}
	 */
	@Override
	public List<ValueBetData> exist(ValueBetData valueBetData) {
		return valueBetRepository.exist(valueBetData);
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
		return valueBetRepository.findAllLimit(limit, skip);
	}

	/**
	 * Gets the count.
	 * 
	 * @return the count {@inheritDoc}
	 */
	public Long getCount() {
		return valueBetRepository.count();
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<ValueBetData> getCrudRepository() {
		return valueBetRepository;
	}

	/**
	 * Gets the differing match value bets.
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
		return valueBetRepository.getDifferingMatchValueBets(matchId,
				hashKeysMarket, hashKeysBet);
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
		return valueBetRepository.getValueBetFromNumDays(numDays);
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
	@Override
	public List<ValueBetData> getValueBetPage(int PageSize, long PageNumber) {
		return valueBetRepository.getValueBetPage(PageSize, PageNumber);
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
		valueBetRepository.update(valueBetDataDB, valueBetData);
	}

}
