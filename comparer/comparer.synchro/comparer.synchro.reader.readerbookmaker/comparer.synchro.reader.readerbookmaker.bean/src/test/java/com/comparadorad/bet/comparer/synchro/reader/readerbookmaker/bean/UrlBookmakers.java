/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The Class UrlBookmakers.
 */
public class UrlBookmakers {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "urlbookmakers"; //$NON-NLS-1$

	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	/**
	 * Instantiates a new url bookmakers.
	 */
	private UrlBookmakers() {
	}

	/**
	 * Gets the url.
	 * 
	 * @param key
	 *            the key
	 * @return the url
	 */
	public static String getUrl(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
