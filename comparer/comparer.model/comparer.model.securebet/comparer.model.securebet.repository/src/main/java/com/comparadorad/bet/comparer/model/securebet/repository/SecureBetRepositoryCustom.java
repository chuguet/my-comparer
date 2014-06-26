/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Interface SecureBetRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface SecureBetRepositoryCustom<T extends SecureBeanData> extends
		IGenericCustomRepository<T> {

	/**
	 * Exist.
	 * 
	 * @param t
	 *            the t
	 * @return the boolean
	 */
	public List<SecureBeanData> exist(T t) ;

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<SecureBeanData> findAllLimit(Integer limit, Integer skip);

	/**
	 * Find one custom.
	 * 
	 * @param sureBetId
	 *            the sure bet id
	 * @return the secure bean data
	 */
	SecureBeanData findOneCustom(String sureBetId);

	/**
	 * Gets the count.
	 * 
	 * @param coreDate
	 *            the core date
	 * @return the count
	 */
	long getCount(CoreDate coreDate);

	/**
	 * Gets the sure bet page.
	 * 
	 * @param coreDate
	 *            the core date
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the sure bet page
	 */
	List<SecureBeanData> getSureBetPage(CoreDate coreDate, int PageSize,
			long PageNumber);

	/**
	 * Last date ssurebet.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the core date
	 */
	SecureBeanData lastDateSurebet(T secureBeanData);

	void update(SecureBeanData surebetDB, Set<RtBet> bets,
			SecureBeanBenefit benefit);
	
	public List<SecureBeanData> getSureBetPaginateForHistoric(int PageSize,
			long PageNumber);
}
