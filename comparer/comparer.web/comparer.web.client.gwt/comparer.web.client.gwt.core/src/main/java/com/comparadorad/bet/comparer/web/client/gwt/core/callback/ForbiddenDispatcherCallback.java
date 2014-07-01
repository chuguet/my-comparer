/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.callback;

import org.fusesource.restygwt.client.Method;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

/**
 * The Class ForbiddenDispatcherCallback.
 */
public class ForbiddenDispatcherCallback implements RequestCallback {
	
	/** The request callback. */
	protected RequestCallback requestCallback;

	/**
	 * The Constructor.
	 *
	 * @param method the method
	 */
	public ForbiddenDispatcherCallback(Method method) {

		this.requestCallback = method.builder.getCallback();
	}

	/**
	 * On error.
	 *
	 * @param request the request
	 * @param exception the exception
	 * {@inheritDoc}
	 */
	public void onError(Request request, Throwable exception) {
		requestCallback.onError(request, exception);

	}

	/**
	 * On response received.
	 *
	 * @param request the request
	 * @param response the response
	 * {@inheritDoc}
	 */
	public void onResponseReceived(Request request, Response response) {
		requestCallback.onResponseReceived(request, response);
		/*
		 * if (response.getStatusCode() == Response.SC_FORBIDDEN) { // make a
		 * hard redirect to login page Window.Location.assign("/login"); } else
		 * { requestCallback.onResponseReceived(request, response);
		 * 
		 * }
		 */
	}

}