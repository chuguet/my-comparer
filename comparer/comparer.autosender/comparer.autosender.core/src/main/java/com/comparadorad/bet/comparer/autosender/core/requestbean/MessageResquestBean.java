/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.core.requestbean;

import org.hibernate.validator.constraints.NotEmpty;

import com.comparadorad.bet.comparer.autosender.core.enume.MessageType;



/**
 * The Class MessageResquestBean.
 */
public class MessageResquestBean extends AbstractRequestBean implements IRequestBean{
	/** The campaign id. */
	@NotEmpty
	private String campaignId;

	/** The subject. */
	@NotEmpty
	private String subject;
	
	/** The message type. */
	
	private MessageType messageType;

	/** The contents. */
	@NotEmpty
	private String content;
	/**
	 * Gets the message type.
	 *
	 * @return the message type
	 */
	public MessageType getMessageType() {
		return messageType;
	}

	/**
	 * Sets the message type.
	 *
	 * @param messageType the new message type
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	/**
	 * Gets the contents.
	 *
	 * @return the contents
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the contents.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}





	/**
	 * Gets the campaign id.
	 *
	 * @return the campaign id
	 */
	public String getCampaignId() {
		return campaignId;
	}

	/**
	 * Sets the campaign id.
	 *
	 * @param campaignId the new campaign id
	 */
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}



}
