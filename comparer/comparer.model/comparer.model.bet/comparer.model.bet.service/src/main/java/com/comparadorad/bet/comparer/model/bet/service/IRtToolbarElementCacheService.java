/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface IRtToolbarElementService.
 */
public interface IRtToolbarElementCacheService extends
		IGenericCrudService<RtToolbarElementCache> {

	/**
	 * Generate toolbar.
	 * 
	 * @return the list
	 */
	List<RtToolbarElementCache> cacheableToolbar();
}
