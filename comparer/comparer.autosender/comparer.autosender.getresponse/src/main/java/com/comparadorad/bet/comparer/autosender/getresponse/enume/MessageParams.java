/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.enume;

/**
 * The Enum MessageParams.
 */
public enum MessageParams {

	/** The CAMPAIGN. */
	CAMPAIGN("campaign"),

	/** The SUBJECT. */
	SUBJECT("subject"),
	
	/** The CONTACTS. */
	CONTACTS("contacts"),
	
	/** The CONTENTS. */
	CONTENTS("contents"),
	
	name("name");

	/** The name id. */
	private final String nameId;

	/**
	 * Gets the name id.
	 *
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}

	/**
	 * Instantiates a new contact params.
	 *
	 * @param nameId the name id
	 */
	private MessageParams(String nameId) {
		this.nameId=nameId;
	}
}
