/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.requestbean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class DeleteContactRequestBeanGetResponse.
 */
public class DeleteContactRequestBeanGetResponse extends AbstractRequestBeanGetResponse implements IRequestBeanGetResponse{

	/** The campaign. */
	@NotEmpty
	private String campaign;
	
	/** The email. */
	@NotEmpty
	@Email
	private String email;

	/**
	 * Gets the campaign.
	 *
	 * @return the campaign
	 */
	public String getCampaign() {
		return campaign;
	}

	/**
	 * Sets the campaign.
	 *
	 * @param campaign the new campaign
	 */
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
