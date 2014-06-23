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
 * The Class MoveContactRequestBeanGetResponse.
 */
public class MoveContactRequestBeanGetResponse extends AbstractRequestBeanGetResponse implements IRequestBeanGetResponse{
	
	/** The email. */
	@Email
	@NotEmpty
	private String email;
	
	/** The campaign id. */
	@NotEmpty
	private String originCampaignId;
	
	
	/** The campaign id. */
	@NotEmpty
	private String destinyCampaignId;


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


	/**
	 * Gets the origin campaign id.
	 *
	 * @return the origin campaign id
	 */
	public String getOriginCampaignId() {
		return originCampaignId;
	}


	/**
	 * Sets the origin campaign id.
	 *
	 * @param originCampaignId the new origin campaign id
	 */
	public void setOriginCampaignId(String originCampaignId) {
		this.originCampaignId = originCampaignId;
	}


	/**
	 * Gets the destiny campaign id.
	 *
	 * @return the destiny campaign id
	 */
	public String getDestinyCampaignId() {
		return destinyCampaignId;
	}


	/**
	 * Sets the destiny campaign id.
	 *
	 * @param destinyCampaignId the new destiny campaign id
	 */
	public void setDestinyCampaignId(String destinyCampaignId) {
		this.destinyCampaignId = destinyCampaignId;
	}


	
	

}
