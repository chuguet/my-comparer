/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.constant;

/**
 * The Enum ConstantMapperName.
 */
public enum ConstantMapperName {

	/** The SECUREBE t_ t o_ tableresponseto. */
	SECUREBET_TO_TABLERESPONSETO("secureBetToTableResponseTo");

	/** The name. */
	private String name;

	/**
	 * Instantiates a new constant mapper name.
	 * 
	 * @param pName
	 *            the name
	 */
	ConstantMapperName(String pName) {
		this.name = pName;
	}

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */
	public String toString() {
		return this.name;
	}
}
