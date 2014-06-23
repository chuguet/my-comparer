/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.enume;

/**
 * The Enum ResponseStatus.
 */
public enum ResponseStatus {

	/** The COMPLETED. */
	COMPLETED("completed"),
	
	/** The FAILED. */
	FAILED("failed");
	
	/** The name id. */
	private final String nameId;
	
	/**
	 * Instantiates a new response status.
	 *
	 * @param nameId the name id
	 */
	private ResponseStatus(String nameId) {
		this.nameId = nameId;
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
