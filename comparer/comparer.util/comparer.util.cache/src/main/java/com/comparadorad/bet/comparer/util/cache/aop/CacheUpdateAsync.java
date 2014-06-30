/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.aop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.IUtilCache;
import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;

/**
 * The Class CacheUpdateAsync.
 */
@Component
@Scope("singleton")
final class CacheUpdateAsync implements ICacheUpdateAsync {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CacheUpdateAsync.class);

	/** The util cache. */
	@Inject
	private IUtilCache utilCache;

	/** The executions. */
	private volatile Set<Object> executions;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.util.cache.aop.ICacheUpdateAsync#updateCache
	 * (org.aspectj.lang.ProceedingJoinPoint,
	 * com.comparadorad.bet.comparer.util.cache.CacheRegion[])
	 */
	/** {@inheritDoc} */
	@Async(value = "cacheTaskExecutor")
	public void updateCache(final ProceedingJoinPoint pjpt,
			final CacheRegion[] cacheRegions, Object previusResult)
			throws AsynchronousCacheException {
		Object result = previusResult;
		CacheRegion cacheRegion;
		Element element;
		StringBuffer stringBuffer;
		Object[] args;

		try {
			args = pjpt.getArgs();
			if (!containsExecution(args)) {
				LOG.info("PRE - llamada metodo -- " + args);
				addExecution(args);
				result = pjpt.proceed(args);
				LOG.info("POST - llamada metodo -- " + args);
				removeExecution(args);
			}

			for (int i = 0; i < cacheRegions.length; i++) {
				cacheRegion = cacheRegions[i];
				element = new Element(pjpt.getArgs(), result);
				stringBuffer = new StringBuffer("Se añade a las region: ");

				stringBuffer.append(cacheRegion).append(" ");
				stringBuffer.append("el elemento: ");
				stringBuffer.append(element);

				utilCache.add(Arrays.asList(args), result, cacheRegions);

				LOG.debug(stringBuffer);
			}

		} catch (Throwable t) {
			LOG.error(t.getMessage());
			throw new AsynchronousCacheException(t);
		}

	}

	/**
	 * Contains execution.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public boolean containsExecution(Object e) {
		synchronized (CacheUpdateAsync.class) {
			return getExecution().contains(e);
		}
		
	}

	/**
	 * Adds the execution.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public synchronized boolean addExecution(Object e) {
		return getExecution().add(e);
	}

	/**
	 * Gets the execution.
	 * 
	 * @return the execution
	 */
	private Set<Object> getExecution() {

		if (executions == null) {
			executions = new HashSet<Object>();
		}
		synchronized (CacheUpdateAsync.class) {
			return executions;
		}
	}

	/**
	 * Removes the execution.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public boolean removeExecution(Object e) {
		synchronized (CacheUpdateAsync.class) {
			return getExecution().remove(e);
		}
	}

	/** {@inheritDoc} */
	public int executionSize() {
		synchronized (CacheUpdateAsync.class) {
			return getExecution().size();
		}

	}

}
