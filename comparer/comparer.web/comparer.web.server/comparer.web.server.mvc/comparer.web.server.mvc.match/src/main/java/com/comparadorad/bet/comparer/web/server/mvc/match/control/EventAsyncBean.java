package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.IUtilCache;

@Component
@Scope("singleton")
public class EventAsyncBean {

	/** The util cache */
	@Inject
	private IUtilCache utilCache;

	/** The executions. */
	private volatile Set<Object> executions;

	/**
	 * Update the cache
	 * 
	 * @param keys
	 *            The keys
	 * @param value
	 *            The value
	 * @param cacheRegions
	 *            The cacheRegion
	 */
	@Async(value = "cacheTaskExecutor")
	public void asyncUpdateRtMatchCache(final List<Object> keys,
			final CacheRegion[] cacheRegions, final String rtMatchId,
			AbstractHeadAndCellsCreator abstractHeadAndCellsCreator,
			Object previousResult) {

		Object value = previousResult;

		if (!containsExecution(keys)) {
			addExecution(keys);
			value = abstractHeadAndCellsCreator.getMatchService()
					.findOneCustom(rtMatchId);
			removeExecution(keys);
		}
		utilCache.add(keys, value, cacheRegions);
	}

	/**
	 * Contains execution.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public synchronized boolean containsExecution(Object e) {
		return getExecution().contains(e);
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
	private synchronized Set<Object> getExecution() {
		if (executions == null) {
			executions = new HashSet<Object>();
		}
		return executions;
	}

	/**
	 * Removes the execution.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public synchronized boolean removeExecution(Object e) {
		return getExecution().remove(e);
	}

}
