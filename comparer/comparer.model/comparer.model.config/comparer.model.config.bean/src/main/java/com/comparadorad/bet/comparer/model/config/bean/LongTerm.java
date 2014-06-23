/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The Class LongTerm.
 */
@SuppressWarnings("serial")
public class LongTerm implements IBetTypeFeature, Serializable {

	/** The long term. */
	@NotNull
	private Boolean longTerm = Boolean.FALSE;

	/**
	 * Gets the long term.
	 * 
	 * @return the long term
	 */
	public Boolean getLongTerm() {
		return longTerm;
	}

	/**
	 * Sets the long term.
	 * 
	 * @param longTerm
	 *            the new long term
	 */
	public void setLongTerm(Boolean longTerm) {
		this.longTerm = longTerm;
	}

}
