/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.io.Serializable;

/**
 * The Class XmlUrl.
 */
public class XmlUrl implements Serializable {

	/** The url. */
	private String url;

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Instantiates a new xml url.
	 */
	public XmlUrl() {
		super();
	}

	/**
	 * Sets the url.
	 * 
	 * @param pUrl
	 *            the new url
	 */
	public void setUrl(String pUrl) {
		url = pUrl;
	}
}
