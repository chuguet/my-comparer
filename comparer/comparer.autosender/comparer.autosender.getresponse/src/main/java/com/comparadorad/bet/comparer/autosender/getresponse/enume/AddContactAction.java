/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.enume;

import com.comparadorad.bet.comparer.autosender.core.enume.ContactActions;

/**
 * The Enum AddContactAction.
 */
public enum AddContactAction {
	/*If standard mode is chosen then a new contact will be added 
	 * if not already present in a given campaign otherwise existing 
	 * contact will be updated including name change and customs list 
	 * merge. If insert mode is chosen then a contact will be added if 
	 * it doesn’t exist in a given campaign but no updates will be performed 
	 * otherwise. If update is chosen then a contact will be updated if it 
	 * exists in a given campaign but no inserts will be performed otherwise.
	 *  Default is standard.
	 */
	/** The INSERT. */
	INSERT("insert",ContactActions.INSERT),

	/** The UPDATE. */
	UPDATE("update",ContactActions.UPDATE),

	/** The STANDARD. */
	STANDARD("standard",ContactActions.STANDARD);


	/** The name id. */
	private final String nameId;

	/** The action. */
	private final ContactActions action;
	
	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public ContactActions getAction() {
		return action;
	}

	/**
	 * Gets the name id.
	 *
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}

	/**
	 * Instantiates a new adds the contact action.
	 *
	 * @param nameId the name id
	 * @param action the action
	 */
	AddContactAction(String nameId,ContactActions action){
		this.nameId=nameId;
		this.action=action;
	}


}
