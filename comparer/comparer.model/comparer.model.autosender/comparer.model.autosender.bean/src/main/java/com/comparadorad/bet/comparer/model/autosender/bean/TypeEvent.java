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
 * The Class TypeEvent.
 */
@Entity
@Table(name = "TYPE_EVENT")
public class TypeEvent extends AbstractRelacional implements IAutoSender {

	/**
	 * The Enum TypeEventName.
	 */
	public enum TypeEventName {

		/** The FOUN d_ securebet. */
		FOUND_SECUREBET(),

		/** The FOUN d_ valuebet. */
		FOUND_VALUEBET();
	}

	/** The type event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_EVENT_ID")
	private Integer typeEventId;

	/** The type event name. */
	@Basic
	@Column(name = "TYPE_EVENT_NAME")
	private TypeEventName typeEventName;

	/**
	 * Gets the type event id.
	 * 
	 * @return the type event id
	 */
	public Integer getTypeEventId() {
		return typeEventId;
	}

	/**
	 * Gets the type event name.
	 * 
	 * @return the type event name
	 */
	public TypeEventName getTypeEventName() {
		return typeEventName;
	}

	/**
	 * Sets the type event id.
	 * 
	 * @param typeEventId
	 *            the new type event id
	 */
	public void setTypeEventId(Integer typeEventId) {
		this.typeEventId = typeEventId;
	}

	/**
	 * Sets the type event name.
	 * 
	 * @param typeEventName
	 *            the new type event name
	 */
	public void setTypeEventName(TypeEventName typeEventName) {
		this.typeEventName = typeEventName;
	}

}
