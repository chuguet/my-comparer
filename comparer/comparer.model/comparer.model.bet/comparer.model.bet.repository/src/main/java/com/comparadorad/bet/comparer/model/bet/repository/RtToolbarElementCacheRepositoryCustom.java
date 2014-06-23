/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface RtToolbarElementRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface RtToolbarElementCacheRepositoryCustom<T extends RtToolbarElementCache>
		extends IGenericCustomRepository<T> {

	/**
	 * Find all limit.
	 * 
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<RtToolbarElementCache> findAllLimit(Integer skip);

	/**
	 * Gets the first level toolbar.
	 * 
	 * @return the first level toolbar
	 */
	List<RtToolbarElementCache> generateFirstLevelToolbar();

	/**
	 * Gets the second level toolbar.
	 * 
	 * @param parent
	 *            the parent
	 * @param sportId
	 *            the sport id
	 * @return the second level toolbar
	 */
	List<RtToolbarElementCache> generateSecondLevelToolbar(
			RtToolbarElementCache parent, String sportId);

	/**
	 * Gets the third level toolbar.
	 * 
	 * @param parent
	 *            the parent
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the third level toolbar
	 */
	List<RtToolbarElementCache> generateThirdLevelToolbar(
			RtToolbarElementCache parent, String sportId, String countryId);
}
