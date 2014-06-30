/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.aop;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.IUtilCache;
import com.comparadorad.bet.comparer.util.cache.config.CacheConfig;
import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;
import com.comparadorad.bet.comparer.util.cache.exception.ElemementNotFoundException;

/**
 * The Class AsynchronousCacheableInterceptor.
 */
@Aspect
@Service
final class AsynchronousCacheableInterceptor {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AsynchronousCacheableInterceptor.class);

	/** The cache update async. */
	@Inject
	private ICacheUpdateAsync cacheUpdateAsync;

	/** The cache config. */
	@Inject
	private CacheConfig cacheConfig;

	/** The util cache. */
	@Inject
	private IUtilCache utilCache;

	/**
	 * Around.
	 * 
	 * @param pjpt
	 *            the pjpt
	 * @param asynchronousCacheable
	 *            the asynchronous cacheable
	 * @return the object
	 * @throws AsynchronousCacheException
	 *             the asynchronous cache exception
	 */
	@Around("@annotation(com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable) && @annotation(asynchronousCacheable)")
	public Object around(final ProceedingJoinPoint pjpt,
			final AsynchronousCacheable asynchronousCacheable)
			throws AsynchronousCacheException {
		Object result = null;
		CacheRegion[] cacheRegions;
		Object[] args;

		LOG.info("Se inicia la cache asincrona");

		cacheRegions = asynchronousCacheable.value();
		args = pjpt.getArgs();

		try {
			result = utilCache.find(Arrays.asList(args), cacheRegions).getObjectValue();			
			
			LOG.info("Procesos encolados para actualizacion: " + cacheUpdateAsync.executionSize());
			if (cacheUpdateAsync.executionSize() < cacheConfig
					.getAsyncExecutorBean().getQueueCapacity()) {
				cacheUpdateAsync.updateCache(pjpt, cacheRegions, result);
			} else {
				LOG.info("Cola de elementos llena, se realiza directamente la llamada al metodo");
				result = proceedAndCache(pjpt, cacheRegions);
			}

		} catch (ElemementNotFoundException e) {
			LOG.info("Elemento no encontrado en cache");
			result = proceedAndCache(pjpt, cacheRegions);
		}

		LOG.info("Se finaliza la cache asincrona");

		return result;
	}

	/**
	 * Proceed and cache.
	 * 
	 * @param pjpt
	 *            the pjpt
	 * @param cacheRegions
	 *            the cache regions
	 * @return the object
	 * @throws AsynchronousCacheException
	 *             the asynchronous cache exception
	 */
	private Object proceedAndCache(ProceedingJoinPoint pjpt,
			CacheRegion[] cacheRegions) throws AsynchronousCacheException {
		Object result = null;
		try {
			result = pjpt.proceed(pjpt.getArgs());
			utilCache.add(Arrays.asList(pjpt.getArgs()), result, cacheRegions);
		} catch (Throwable e1) {
			LOG.error("Caching Error: "+e1.getMessage());
			throw new AsynchronousCacheException(e1);
		}

		return result;
	}
}
