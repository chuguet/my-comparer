/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.bean;

import java.util.UUID;

import org.springframework.data.annotation.Transient;

/**
 * The Class Benefit.
 */
public class SecureBeanBenefit implements ISecureBeanData {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2062440273744578870L;

	/** The value. */
	private Double value;

	/** The uuid. */
	@Transient
	private UUID uuid;

	/**
	 * Instantiates a new benefit secure bet.
	 */
	public SecureBeanBenefit() {
		super();
		this.uuid = UUID.randomUUID();
	}

	/**
	 * Instantiates a new benefit secure bet.
	 * 
	 * @param pValue
	 *            the value
	 */
	public SecureBeanBenefit(Double pValue) {
		super();
		this.value = pValue;
		this.uuid = UUID.randomUUID();
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return uuid.hashCode();
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecureBeanBenefit other = (SecureBeanBenefit) obj;
		if (other.uuid.equals(this.uuid)) {
			return true;
		}
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "SecureBeanBenefit [value=" + value + "]";
	}

}
