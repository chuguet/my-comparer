/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;

/**
 * The Interface ValueBetHistoricRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface ValueBetHistoricRepositoryCustom<T extends ValueBetHistoricData>
		extends IGenericCustomRepository<T> {

	/**
	 * Exist.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param marketHashKey
	 *            the market hash key
	 * @param betHashKey
	 *            the bet hash key
	 * @return the list
	 */
	List<ValueBetHistoricData> exist(String idMatch, String marketHashKey,
			String betHashKey);

	/**
	 * Exist.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @return the list
	 */
	List<ValueBetHistoricData> exist(ValueBetData valueBetData);

	/**
	 * Exist.
	 * 
	 * @param valueBetHistoricData
	 *            the value bet historic data
	 * @return the list
	 */
	List<ValueBetHistoricData> exist(ValueBetHistoricData valueBetHistoricData);
}
