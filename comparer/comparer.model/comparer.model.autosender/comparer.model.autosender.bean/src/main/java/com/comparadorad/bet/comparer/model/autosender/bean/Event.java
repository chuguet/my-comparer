/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Event.
 */
@Entity
@Table(name = "EVENT")
public class Event extends AbstractRelacional implements IAutoSender {

	
	/** The event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private Integer eventId;
	
	/** The attributes. */
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<EventAttribute> attributes;
	
	/** The type event. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TypeEvent typeEvent;



	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public Integer getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the attributes.
	 *
	 * @return the attributes
	 */
	public Collection<EventAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * Sets the attributes.
	 *
	 * @param attributes the new attributes
	 */
	public void setAttributes(Collection<EventAttribute> attributes) {
		this.attributes = attributes;
	}

	/**
	 * Gets the type event.
	 *
	 * @return the type event
	 */
	public TypeEvent getTypeEvent() {
		return typeEvent;
	}

	/**
	 * Sets the type event.
	 *
	 * @param typeEvent the new type event
	 */
	public void setTypeEvent(TypeEvent typeEvent) {
		this.typeEvent = typeEvent;
	}

	
	
}
