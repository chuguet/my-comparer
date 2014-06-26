/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

import com.comparadorad.bet.comparer.model.core.bean.HasActive;

/**
 * The Class AbstractActiveFilterAspect.
 */
public abstract class AbstractActiveFilterAspect {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractActiveFilterAspect.class);

	/**
	 * Filter active after returning.
	 * 
	 * @param joinPoint
	 *            the join point
	 * @param result
	 *            the result
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void filterActiveAfterReturning(JoinPoint joinPoint, Object result) {
		if (result instanceof Collection) {
			Collection resColl = (Collection) result;
			if (!resColl.isEmpty()
					&& resColl.iterator().next() instanceof HasActive) {
				Date todayDate = new Date();
				List toRemoveList = null;
				for (Object object : resColl) {
					if (object instanceof HasActive) {
						if (!((HasActive) object).isActive(todayDate)) {
							if (toRemoveList == null) {
								toRemoveList = new ArrayList();
							}
							toRemoveList.add(object);
						}
					}
				}
				if (toRemoveList != null) {
					for (Object objectToDelete : toRemoveList) {
						((Collection) result).remove(objectToDelete);
					}
					LOG.debug("Filter of:" + joinPoint.getSignature()
							+ " succeed. Removed " + toRemoveList.size()
							+ " elements.");
				}
			}
		}
	}
}
