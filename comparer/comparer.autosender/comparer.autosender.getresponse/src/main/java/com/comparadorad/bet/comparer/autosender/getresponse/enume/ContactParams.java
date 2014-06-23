/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.enume;

/**
 * The Enum ContactParams.
 */
public enum ContactParams {

	/** The CAMPAIGN. */
	CAMPAIGN("campaign"),
	
	/** The ACTION. */
	ACTION("action"),
	
	/** The NAME. */
	NAME("name"),
	
	/** The EMAIL. */
	EMAIL("email"),
	
	/** The CYCL e_ day. */
	CYCLE_DAY("cycle_day"),
	
	/** The IP. */
	IP("ip"),
	
	/** The CUSTOMS. */
	CUSTOMS("customs"),
	
	/** The CUSTO m_ name. */
	CUSTOM_NAME("name"),
	
	/** The CUSTO m_ content. */
	CUSTOM_CONTENT("content"),
	
	/** The CONTACT. */
	CONTACT("contact"),
	
	/** The CONTACTS. */
	CONTACTS("contacts"),
	
	/** The CAMPAIGNS. */
	CAMPAIGNS("campaigns"),
	
	/** The OPERATO r_ equals. */
	OPERATOR_EQUALS("EQUALS"),
	
	CONTAINS("CONTAINS"),
	
	ALL("%");
	
	
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
	private ContactParams(String nameId) {
		this.nameId=nameId;
	}
}
