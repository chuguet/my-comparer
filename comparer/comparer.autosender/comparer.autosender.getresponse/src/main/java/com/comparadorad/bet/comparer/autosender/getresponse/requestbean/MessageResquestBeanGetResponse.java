/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.requestbean;

import org.hibernate.validator.constraints.NotEmpty;

import com.comparadorad.bet.comparer.autosender.core.enume.MessageType;



/**
 * The Class MessageResquestBeanGetResponse.
 */
public class MessageResquestBeanGetResponse extends AbstractRequestBeanGetResponse implements IRequestBeanGetResponse{

	/** The campaign id. */
	@NotEmpty
	private String campaignId;
	
	/** The subject. */
	@NotEmpty
	private String subject;
	
	/** The message type. */
	
	private MessageType messageType;
	
	/** The content. */
	@NotEmpty
	private String content;

	/**
	 * Gets the campaign id.
	 *
	 * @return the campaign id
	 */
	public String getCampaignId() {
		return campaignId;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Gets the message type.
	 *
	 * @return the message type
	 */
	public MessageType getMessageType() {
		return messageType;
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
	 * Sets the campaign id.
	 *
	 * @param campaignId the new campaign id
	 */
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	
	
}
