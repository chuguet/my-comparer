/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.enume;

/**
 * The Enum ContactActions.
 */
public enum ContactActions{

	/** The INSERT. */
	INSERT("insert"),

	/** The UPDATE. */
	UPDATE("update"),

	/** The STANDARD. */
	STANDARD("standard");


	/** The name id. */
	private final String nameId;

	/**
	 * Instantiates a new adds the contact action.
	 *
	 * @param nameId the name id
	 */
	ContactActions(String nameId){
		this.nameId=nameId;
	}

	/**
	 * Gets the name id.
	 *
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}
	
	
}
