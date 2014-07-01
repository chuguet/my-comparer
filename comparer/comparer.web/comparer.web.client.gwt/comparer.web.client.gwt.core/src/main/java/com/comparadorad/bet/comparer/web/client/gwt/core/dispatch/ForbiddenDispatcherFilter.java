/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.dispatch;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

import com.comparadorad.bet.comparer.web.client.gwt.core.callback.ForbiddenDispatcherCallback;
import com.google.gwt.http.client.RequestBuilder;

/**
 * The Class ForbiddenDispatcherFilter.
 */
public class ForbiddenDispatcherFilter implements DispatcherFilter {

	/**
	 * Filter.
	 *
	 * @param pMethod the p method
	 * @param pBuilder the p builder
	 * @return true, if filter
	 * {@inheritDoc}
	 */
	public boolean filter(Method pMethod, RequestBuilder pBuilder) {
		pBuilder.setCallback(new ForbiddenDispatcherCallback(pMethod));

		return true;
	}

}
