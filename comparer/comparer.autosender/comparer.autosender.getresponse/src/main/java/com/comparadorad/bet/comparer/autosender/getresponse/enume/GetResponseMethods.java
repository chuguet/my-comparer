/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.enume;

/**
 * The Enum GetResponseMethods.
 */
public enum GetResponseMethods {
	//Connection testing
	/** The PING. */
	PING("ping"),

	//Messages
	/** The SEN d_ newsletter. */
	SEND_NEWSLETTER("send_newsletter"),

	//Contacts
	/** The AD d_ contact. */
	ADD_CONTACT("add_contact"),

	/** The MOV e_ contact. */
	MOVE_CONTACT("move_contact"),

	/** The DELET e_ contact. */
	DELETE_CONTACT("delete_contact"),
	
	/** The GE t_ contacts. */
	GET_CONTACTS("get_contacts"),
	
	GET_CAMPAIGNS("get_campaigns"),
	
	SET_CONTACT_CYCLE("set_contact_cycle");
	
	
	
	
	//Campaigns
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
	 * Instantiates a new gets the response methods.
	 *
	 * @param nameId the name id
	 */
	GetResponseMethods(String nameId){
		this.nameId=nameId;
	}
}
