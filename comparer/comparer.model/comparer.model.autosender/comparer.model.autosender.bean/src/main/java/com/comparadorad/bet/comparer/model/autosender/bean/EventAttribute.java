/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class EventAttribute.
 */
@Entity
@Table(name = "EVENT_ATTRIBUTE")
public class EventAttribute  extends AbstractRelacional implements IAutoSender {
	
	/**
	 * The Enum AttributeName.
	 */
	public enum AttributeName{
		
	}
	
	/** The event attribute id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ATTRIBUTE_ID")
	private Integer eventAttributeId;
	
	/** The name. */
	@Basic
	@Column(name="NAME")
	private AttributeName name;
	
	/** The value. */
	@Basic
	@Column(nullable = true, length = 255, name = "VALUE")
	private String value;	
	

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public AttributeName getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(AttributeName name) {
		this.name = name;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the event attribute id.
	 *
	 * @return the event attribute id
	 */
	public Integer getEventAttributeId() {
		return eventAttributeId;
	}

	/**
	 * Sets the event attribute id.
	 *
	 * @param eventAttributeId the new event attribute id
	 */
	public void setEventAttributeId(Integer eventAttributeId) {
		this.eventAttributeId = eventAttributeId;
	}
	
	

}
