/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface IRtToolbarElementService.
 */
public interface IRtToolbarElementService extends
		IGenericCrudService<RtToolbarElement> {

	/**
	 * Free cache.
	 */
	void freeCache();

	/**
	 * Generate toolbar.
	 * 
	 */
	void generateToolbar();

	/**
	 * Gets the child nodes.
	 * 
	 * @return the child nodes
	 */
	List<RtToolbarElement> getFirstLevel();

	/**
	 * Gets the orphan nodes.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the orphan nodes
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
