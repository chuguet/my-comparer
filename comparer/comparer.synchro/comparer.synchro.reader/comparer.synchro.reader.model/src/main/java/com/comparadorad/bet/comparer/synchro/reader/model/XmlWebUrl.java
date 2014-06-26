/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class BookmakerWebUrl.
 * Alamacenará la url directa hacia la apuesta en caso de que en el xml de entrada venga informada.
 */
@SuppressWarnings("serial")
public class XmlWebUrl implements Serializable {

	/** The Constant PATTERN_URL. */
	private final static String PATTERN_URL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	/** The private url. */
	@Field
	private String url;

	/**
	 * Instantiates a new xml web url.
	 */
	public XmlWebUrl() {
		super();
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		Pattern patt = Pattern.compile(PATTERN_URL);
		Matcher matcher = patt.matcher(url);
		if (matcher.find()) {
			this.url = url;
		}
	}
}
