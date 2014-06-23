/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.mapreduce;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.I18n;

/**
 * The Class AbstractValue.
 */
public abstract class AbstractValue {

	/** The i18n. */
	@Field
	private I18n i18n;

	/**
	 * Gets the i18n.
	 * 
	 * @return the i18n
	 */
	public I18n getI18n() {
		return i18n;
	}

	/**
	 * Sets the i18n.
	 * 
	 * @param i18n
	 *            the new i18n
	 */
	public void setI18n(I18n i18n) {
		this.i18n = i18n;
	}
}
