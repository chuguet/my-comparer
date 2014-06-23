/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgSportRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
public interface CfgSportRepositoryCustom<T extends CfgSport> extends
		IGenericCustomRepository<T> {

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<CfgSport> findAllLimit(Integer limit, Integer skip);
}
