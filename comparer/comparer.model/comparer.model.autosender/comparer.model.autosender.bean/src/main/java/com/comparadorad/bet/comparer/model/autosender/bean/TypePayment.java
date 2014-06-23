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
 * The Class TypePayment.
 */
@Entity
@Table(name = "TYPE_PAYMENT")
public class TypePayment extends AbstractSystemExternal implements IAutoSender {

	/**
	 * The Enum TypePaymentName.
	 */
	public enum TypePaymentName {
		NIVEL_1(), NIVEL_2(), NIVEL_3(), PROMOTION();
	}

	/** The type payment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_PAYMENT_ID")
	private Integer typePaymentId;

	/** The type payment name. */
	@Basic
	@Column(nullable = true, length = 30, name = "NAME")
	private TypePaymentName typePaymentName;

	/** The duration. */
	@Basic
	@Column(name = "DURATION")
	private Integer duration;

	/**
	 * Gets the duration.
	 * 
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 * 
	 * @param duration
	 *            the new duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Gets the type payment name.
	 * 
	 * @return the type payment name
	 */
	public TypePaymentName getTypePaymentName() {
		return typePaymentName;
	}

	/**
	 * Sets the type payment name.
	 * 
	 * @param typePaymentName
	 *            the new type payment name
	 */
	public void setTypePaymentName(TypePaymentName typePaymentName) {
		this.typePaymentName = typePaymentName;
	}

	/**
	 * Gets the type payment id.
	 * 
	 * @return the type payment id
	 */
	public Integer getTypePaymentId() {
		return typePaymentId;
	}

	/**
	 * Sets the type payment id.
	 * 
	 * @param typePaymentId
	 *            the new type payment id
	 */
	public void setTypePaymentId(Integer typePaymentId) {
		this.typePaymentId = typePaymentId;
	}

}
