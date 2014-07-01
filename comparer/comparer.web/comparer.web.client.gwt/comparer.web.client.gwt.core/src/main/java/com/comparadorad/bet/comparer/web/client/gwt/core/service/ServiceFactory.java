/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.service;

import org.fusesource.restygwt.client.RestServiceProxy;
import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;
import org.fusesource.restygwt.client.dispatcher.FilterawareDispatcher;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.dispatch.ForbiddenDispatcherFilter;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;

/**
 * The Class ServiceFactory.
 */
public class ServiceFactory {

	/** The instance. */
	private static ServiceFactory instance;

	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static ServiceFactory getInstance() {
		if (instance == null) {
			synchronized (ServiceFactory.class) {
				instance = new ServiceFactory();
			}
		}
		return instance;
	}

	/**
	 * Gets the service.
	 * 
	 * @param apiService
	 *            the api service
	 * @param dummyService
	 *            the dummy service
	 * @return the service
	 */
	public Object getService(final Object apiService, final Object dummyService) {
		Object resultService;
		if (isNoServerMode()) {
			resultService = dummyService;
		} else {
			final RestServiceProxy restServiceProxy = (RestServiceProxy) apiService;

			final FilterawareDispatcher dispatcher = new DefaultFilterawareDispatcher();

			restServiceProxy.setDispatcher(dispatcher);
			dispatcher.addFilter(new ForbiddenDispatcherFilter());
			// Object dummyService = GWT.create(dummyServiceClass);
			// dispatcher
			// .addFilter(new DummyServiceDispatcherFilter(dummyService));
			// Poner una condici�n para que no devuelva los dummys
			resultService = restServiceProxy;
		}
		Log.debug("Service obtained: " + resultService);
		return resultService;
	}

	/**
	 * Checks if is no server mode.
	 * 
	 * @return true, if checks if is no server mode
	 */
	public boolean isNoServerMode() {
		return AppProperties.getInstance().isGwtNoServer();
	}
}
