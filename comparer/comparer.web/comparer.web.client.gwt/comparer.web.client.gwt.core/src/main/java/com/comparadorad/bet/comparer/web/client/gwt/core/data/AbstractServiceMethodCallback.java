/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.data;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 * The Class ServiceMethodCallback.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractServiceMethodCallback<T> implements
		MethodCallback<T> {

	/** The counter request. */
	private Integer counterRequest = 0;

	/** The data. */
	private T data;

	/** The max request. */
	private final Integer maxRequest = 10;

	/**
	 * Gets the counter request.
	 * 
	 * @return the counter request
	 */
	public Integer getCounterRequest() {
		return counterRequest;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public final T getData() {
		return this.data;
	}

	/**
	 * Gets the max request.
	 * 
	 * @return the max request
	 */
	public Integer getMaxRequest() {
		return maxRequest;
	}

	/**
	 * Inc counter request.
	 */
	public void incCounterRequest() {
		this.counterRequest++;
	}

	/**
	 * On failure.
	 * 
	 * @param pMethod
	 *            the p method
	 * @param pException
	 *            the p exception {@inheritDoc}
	 */
	public final void onFailure(Method pMethod, Throwable pException) {
		onFailureActions(pMethod, pException);
	}

	/**
	 * On failure actions.
	 * 
	 * @param pMethod
	 *            the p method
	 * @param pException
	 *            the p exception
	 */
	protected void onFailureActions(Method pMethod, Throwable pException) {
		// TO Override in heritage
	}

	/**
	 * On success.
	 * 
	 * @param pMethod
	 *            the p method
	 * @param pResponse
	 *            the p response {@inheritDoc}
	 */
	public final void onSuccess(Method pMethod, T pResponse) {
		this.setData(pResponse);
		onSuccessActions(pMethod, pResponse);
	}

	/**
	 * On success actions.
	 * 
	 * @param pMethod
	 *            the p method
	 * @param pResponse
	 *            the p response
	 */
	public abstract void onSuccessActions(Method pMethod, T pResponse);

	/**
	 * Reset counter request.
	 */
	public void resetCounterRequest() {
		this.counterRequest = 0;
	}

	/**
	 * Sets the counter request.
	 * 
	 * @param counterRequest
	 *            the new counter request
	 */
	public void setCounterRequest(Integer counterRequest) {
		this.counterRequest = counterRequest;
	}

	/**
	 * Sets the data.
	 * 
	 * @param pData
	 *            the new data
	 */
	public final void setData(T pData) {
		this.data = pData;
	}

}
