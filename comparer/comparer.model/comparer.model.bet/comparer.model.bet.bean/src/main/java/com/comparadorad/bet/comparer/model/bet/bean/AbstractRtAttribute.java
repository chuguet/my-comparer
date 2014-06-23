/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AbstractRtResult.
 */
@SuppressWarnings("serial")
public abstract class AbstractRtAttribute implements Serializable {

	/** The bet name. */
	@Field
	@NotEmpty
	private String betName;

	/** The final value. */
	@Field
	private Double finalValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractRtAttribute other = (AbstractRtAttribute) obj;
		if (betName == null) {
			if (other.betName != null)
				return false;
		} else if (!betName.equals(other.betName))
			return false;
		if (finalValue == null) {
			if (other.finalValue != null)
				return false;
		} else if (!finalValue.equals(other.finalValue))
			return false;
		return true;
	}

	/**
	 * Gets the attribute hash code.
	 * 
	 * @return the attribute hash code
	 */
	public abstract String getAttributeHashCode();

	/**
	 * Gets the bet name.
	 * 
	 * @return the bet name
	 */
	public String getBetName() {
		return betName;
	}

	/**
	 * Gets the final value.
	 * 
	 * @return the final value
	 */
	public Double getFinalValue() {
		return finalValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((betName == null) ? 0 : betName.hashCode());
		result = prime * result
				+ ((finalValue == null) ? 0 : finalValue.hashCode());
		return result;
	}

	/**
	 * Sets the bet name.
	 * 
	 * @param pBetName
	 *            the new bet name
	 */
	public void setBetName(String pBetName) {
		betName = pBetName;
	}

	/**
	 * Sets the final value.
	 * 
	 * @param finalValue
	 *            the new final value
	 */
	public void setFinalValue(Double finalValue) {
		this.finalValue = finalValue;
	}

	public abstract Boolean isValidForSurebet();
}
