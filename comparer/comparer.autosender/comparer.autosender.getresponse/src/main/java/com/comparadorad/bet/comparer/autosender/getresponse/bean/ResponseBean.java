/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.bean;

import net.sf.json.JSONObject;

import com.comparadorad.bet.comparer.autosender.core.enume.ResponseStatus;

/**
 * The Class ResponseBean.
 */
public class ResponseBean {

	/** The status. */
	private ResponseStatus status;
	
	/** The json content. */
	private JSONObject jsonContent;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	/**
	 * Gets the json content.
	 *
	 * @return the json content
	 */
	public JSONObject getJsonContent() {
		return jsonContent;
	}

	/**
	 * Sets the json content.
	 *
	 * @param jsonContent the new json content
	 */
	public void setJsonContent(JSONObject jsonContent) {
		this.jsonContent = jsonContent;
	}
	
}
