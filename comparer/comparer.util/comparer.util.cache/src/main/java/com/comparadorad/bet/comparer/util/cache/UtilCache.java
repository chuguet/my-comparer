/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache;

import java.util.List;

import javax.inject.Inject;

import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;
import com.comparadorad.bet.comparer.util.cache.exception.ElemementNotFoundException;

/**
 * The Class UtilCache.
 */
@Service
final class UtilCache implements IUtilCache {

	/** The cache manager. */
	@Inject
	private CacheManager cacheManager;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UtilCache.class);


	/**
	 * Gets the cache.
	 *
	 * @param cacheRegion the cache region
	 * @return the cache
	 */
	private net.sf.ehcache.Cache getCache(CacheRegion cacheRegion) {
		final Cache cache = cacheManager.getCache(cacheRegion.getName());
		return (net.sf.ehcache.Cache) cache.getNativeCache();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.util.cache.IUtilCache#add(java.lang.Object
	 * [], java.lang.Object,
	 * com.comparadorad.bet.comparer.util.cache.CacheRegion[])
	 */
	@Override
	public void add(List<Object> keys, Object value, CacheRegion[] cacheRegions) {
		Element element;
		CacheRegion cacheRegion;
		for (int i = 0; i < cacheRegions.length; i++) {
			cacheRegion = cacheRegions[i];
			element = new Element(keys, value);
			getCache(cacheRegion).put(element);
			LOG.info(new StringBuffer("Se añade a la region: ")
					.append(cacheRegion).append(" El elemento: ")
					.append(element));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.util.cache.IUtilCache#find(java.lang.Object
	 * [], com.comparadorad.bet.comparer.util.cache.CacheRegion[])
	 */
	@Override
	public Element find(List<Object> keys, CacheRegion[] cacheRegions)
			throws AsynchronousCacheException {
		Element result = null;
		CacheRegion cacheRegion;
		for (int i = 0; i < cacheRegions.length; i++) {
			cacheRegion = cacheRegions[i];
			result = getCache(cacheRegion).get(keys);

			LOG.info(new StringBuffer("Se busca en la region: ")
					.append(cacheRegion).append(" con la key: ").append(keys)
					.append("El elemento: ").append(result));
			if (result != null) {
				LOG.info(new StringBuffer("Se encuentra en la region: ")
						.append(cacheRegion).append(" El elemento: ")
						.append(result));
				break;
			} else {
				LOG.info(new StringBuffer("No se encuentra en la region: ")
						.append(cacheRegion).append(" El elemento: ")
						.append(result));
//				LOG.info(new StringBuffer("El tamaño de la cache es: ").append(result.));
			}
		}
		if (result == null) {
			throw new ElemementNotFoundException(
					"No se ha encontrado el elemento en la cache");
		}
		return result;
	}

}
