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
import com.comparadorad.bet.comparer.autosender.getresponse.enume.AddContactAction;



/**
 * The Class ContactRequestBeanGetResponse.
 */
public class AddContactRequestBeanGetResponse extends AbstractRequestBeanGetResponse implements IRequestBeanGetResponse{

	/** The campaign. */
	@NotEmpty
	private String campaignId;
	
	/** The action. */
	private AddContactAction action;
	
	/** The name. */
	private String name;
	
	/** The email. */
	@NotEmpty
	@Email
	private String email;
	
	/** The cycle_day. */
	private Integer cycle_day;
	
	/** The ip. */
	private String ip;
	
	/** The customs. 
	 * String1: NAME
	 * String2: CONTENT
	 * */
	private Object[] customs;

	/**
	 * Gets the campaign.
	 *
	 * @return the campaign
	 */
	public String getCampaign() {
		return campaignId;
	}

	/**
	 * Sets the campaign.
	 *
	 * @param campaignId the new campaign
	 */
	public void setCampaign(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public AddContactAction getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(AddContactAction action) {
		this.action = action;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * Gets the ip.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Sets the ip.
	 *
	 * @param ip the new ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Gets the customs.
	 *
	 * @return the customs
	 */
	public Object[] getCustoms() {
		return customs;
	}

	/**
	 * Sets the customs.
	 *
	 * @param customs the customs
	 */
	public void setCustoms(Object[] customs) {
		this.customs = customs;
	}
	

}
