/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.rest.beans;

import com.comparadorad.bet.comparer.web.rest.beans.enume.ResponseType;


/**
 * The Class UserInfoResponse.
 */
public class UserInfoResponse implements IResponse {

	/** The response. */
	private ResponseType response;

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public ResponseType getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(ResponseType response) {
		this.response = response;
	}

	
}
