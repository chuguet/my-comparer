/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.requestbean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class MoveContactRequestBeanGetResponse.
 */
public class ContactCycleRequestBeanGetResponse extends AbstractRequestBeanGetResponse implements IRequestBeanGetResponse{

	/** The email. */
	@Email
	@NotEmpty
	private String email;

	/** The campaign id. */
	@NotEmpty
	private String originCampaignId;

	/** The cycle_day. */
	@NotNull
	private Integer cycle_day;

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
	 * Gets the cycle_day.
	 *
	 * @return the cycle_day
	 */
	public Integer getCycle_day() {
		return cycle_day;
	}


	/**
	 * Sets the cycle_day.
	 *
	 * @param cycle_day the new cycle_day
	 */
	public void setCycle_day(Integer cycle_day) {
		this.cycle_day = cycle_day;
	}




}
