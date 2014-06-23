/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.enume;

/**
 * The Enum MessageType.
 */
public enum MessageType {
/*
 * Allowed keys are plain and html, at least one is mandatory. 
 * All merge-words should be written as GetResponse Dynamic Content syntax. 
 * Maximum length is 524288 characters each.
 */
	/** The HTML. */
	HTML("html"),
	
	/** The PLAIN. */
	PLAIN("plain");
	
	/** The name id. */
	private final String nameId;
	
	/**
	 * Instantiates a new message type.
	 *
	 * @param nameId the name id
	 */
	private MessageType(String nameId) {
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
