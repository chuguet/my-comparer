/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.constant;

/**
 * The Enum ConstantConverterName.
 */
public enum ConstantConverterName {
	
	/** The ODD s_ t o_ rows. */
	SECUREBEAN_TO_ROWTABLE("secureBeanToRowTable");
	
	/** The name. */
	private String name;

	/**
	 * Instantiates a new constant converter name.
	 * 
	 * @param pName
	 *            the name
	 */
	ConstantConverterName(String pName) {
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
