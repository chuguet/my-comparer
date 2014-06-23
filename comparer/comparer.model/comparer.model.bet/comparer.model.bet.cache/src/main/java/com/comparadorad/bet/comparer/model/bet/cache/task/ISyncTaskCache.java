/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.task;

/**
 * The Interface IAsyncTaskCache.
 */
public interface ISyncTaskCache {

	/**
	 * Refresh cache.
	 * 
	 * @param regionCache
	 *            the region cache
	 * @param parametersBean
	 *            the parameters bean
	 */
	void refreshCache();

}
