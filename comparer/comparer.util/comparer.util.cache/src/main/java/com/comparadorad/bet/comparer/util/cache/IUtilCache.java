/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache;

import java.util.List;

import net.sf.ehcache.Element;

import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;

/**
 * The Interface IUtilCache.
 */
public interface IUtilCache {
	

	/**
	 * Adds the.
	 *
	 * @param keys the keys
	 * @param value the value
	 * @param cacheRegions the cache regions
	 */
	void add(List<Object> keys, Object value, CacheRegion[] cacheRegions);
	

	/**
	 * Find.
	 *
	 * @param args the args
	 * @param cacheRegions the cache regions
	 * @return the element
	 * @throws AsynchronousCacheException the asynchronous cache exception
	 */
	Element find(List<Object> args, CacheRegion[] cacheRegions)
			throws AsynchronousCacheException;


}
