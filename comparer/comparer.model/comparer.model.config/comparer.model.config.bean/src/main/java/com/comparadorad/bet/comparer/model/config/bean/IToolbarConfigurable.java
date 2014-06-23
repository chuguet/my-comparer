/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Locale;

/**
 * The Interface IToolbarConfigurable.
 */
public interface IToolbarConfigurable extends Serializable {

	/**
	 * Gets the order.
	 * 
	 * @return the order
	 */
	Integer getOrder();

	/**
	 * Gets the name.
	 * 
	 * @param locale
	 *            the locale
	 * @return the name
	 */
	String getName(final Locale locale);

	/**
	 * Gets the object id.
	 * 
	 * @return the object id
	 */
	BigInteger getObjectId();

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	CfgResource getResource();

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name
	 * @param locale
	 *            the locale
	 */
	void setName(final String name, final Locale locale);
}
