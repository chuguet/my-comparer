/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.valuebet.enums;

/**
 * The Enum SureBetEmailField.
 */
public enum SureBetEmailField {

	/** The BENEFIT. */
	BENEFIT("benefit"), /** The SUBTITLE. */
	SUBTITLE("subtitle"), /** The TITLE. */
	TITLE("title"), /** The CONTACT. */
	CONTACT("contact"),
	BASEURL("baseUrl");

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new sure bet email field.
	 *
	 * @param nameId the name id
	 */
	private SureBetEmailField(String nameId) {
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
