/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class MessageQueue.
 */
@Entity
@Table(name = "MESSAGE_QUEUE")
public class MessageQueue extends AbstractRelacional implements IAutoSender {

	/**
	 * The Enum MessageQueueState.
	 */
	public enum MessageQueueState{
		
		/** The CORRECT. */
		CORRECT(),
		
		/** The FAIL. */
		FAIL();
	} 
	
	/** The event. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Event event;
	
	/** The message queue id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MESSAGE_QUEUE_ID")
	private Integer messageQueueId;

	/** The message queue state. */
	@Basic
	@Column(name="messageQueueState")
	private MessageQueueState messageQueueState;
	
	/** The type payment. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TypePayment typePayment;
	
	/**
	 * Gets the event.
	 * 
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Gets the message queue id.
	 * 
	 * @return the message queue id
	 */
	public Integer getMessageQueueId() {
		return messageQueueId;
	}

	/**
	 * Gets the message queue state.
	 *
	 * @return the message queue state
	 */
	public MessageQueueState getMessageQueueState() {
		return messageQueueState;
	}

	/**
	 * Gets the type payment.
	 *
	 * @return the type payment
	 */
	public TypePayment getTypePayment() {
		return typePayment;
	}

	/**
	 * Sets the event.
	 * 
	 * @param event
	 *            the new event
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Sets the message queue id.
	 * 
	 * @param messageQueueId
	 *            the new message queue id
	 */
	public void setMessageQueueId(Integer messageQueueId) {
		this.messageQueueId = messageQueueId;
	}

	/**
	 * Sets the message queue state.
	 *
	 * @param messageQueueState the new message queue state
	 */
	public void setMessageQueueState(MessageQueueState messageQueueState) {
		this.messageQueueState = messageQueueState;
	}

	/**
	 * Sets the type payment.
	 *
	 * @param typePayment the new type payment
	 */
	public void setTypePayment(TypePayment typePayment) {
		this.typePayment = typePayment;
	}

}
