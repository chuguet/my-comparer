/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface RtToolbarElementRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface RtToolbarElementRepositoryCustom<T extends RtToolbarElement> extends
		IGenericCustomRepository<T> {

	/**
	 * Gets the first level.
	 * 
	 * @return the first level
	 */
	List<RtToolbarElement> getFirstLevel();

	/**
	 * Gets the second level.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the second level
	 */
	List<RtToolbarElement> getSecondLevel(String sportId);

	/**
	 * Gets the third level.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param regionId
	 *            the region id
	 * @return the third level
	 */
	List<RtToolbarElement> getThirdLevel(String sportId, String regionId);

}
