/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;

/**
 * The Interface ICacheUpdateAsync.
 */
public interface ICacheUpdateAsync {
	
	/**
	 * Update cache.
	 *
	 * @param pjpt the pjpt
	 * @param cacheRegions the cache regions
	 * @throws AsynchronousCacheException the asynchronous cache exception
	 */
	public void updateCache(final ProceedingJoinPoint pjpt,
			final CacheRegion[] cacheRegions, Object previusResult)
			throws AsynchronousCacheException;
	
	/**
	 * Execution size.
	 *
	 * @return the int
	 */
	public int executionSize();

}
