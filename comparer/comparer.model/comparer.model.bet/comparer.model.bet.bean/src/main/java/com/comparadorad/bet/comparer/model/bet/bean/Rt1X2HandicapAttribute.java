/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class HandicapAttribute.
 */
@SuppressWarnings("serial")
public class Rt1X2HandicapAttribute extends AbstractRtAttribute implements
		IHandicapAttribute {

	/** The value. */
	@Field
	@NotNull
	private Double firstValue;

	/** The result. */
	@Field
	private Result result;

	/** The value. */
	@Field
	private Double secondValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute#equals
	 * (java.lang.Object)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute#equals
	 * (java.lang.Object)
	 */
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rt1X2HandicapAttribute other = (Rt1X2HandicapAttribute) obj;
		if (super.getFinalValue() == null) {
			if (other.getFinalValue() != null)
				return false;
		} else if (!super.getFinalValue().equals(other.getFinalValue()))
			return false;
		if (result != other.result)
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String getAttributeHashCode() {
		StringBuffer attributeSpecificHashKey = new StringBuffer();
		attributeSpecificHashKey.append(super.getFinalValue());
		attributeSpecificHashKey.append(result);
		return attributeSpecificHashKey.toString();
	}

	/**
	 * Gets the first value.
	 * 
	 * @return the first value
	 */
	public Double getFirstValue() {
		return firstValue;
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Gets the second value.
	 * 
	 * @return the second value
	 */
	public Double getSecondValue() {
		return secondValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute#hashCode
	 * ()
	 */
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((super.getFinalValue() == null) ? 0 : super.getFinalValue()
						.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	/**
	 * Sets the first value.
	 * 
	 * @param firstValue
	 *            the new first value
	 */
	public void setFirstValue(Double firstValue) {
		this.firstValue = firstValue;
	}

	/**
	 * Sets the result.
	 * 
	 * @param pResult
	 *            the new result
	 */
	public void setResult(Result pResult) {
		result = pResult;
	}

	/**
	 * Sets the second value.
	 * 
	 * @param secondValue
	 *            the new second value
	 */
	public void setSecondValue(Double secondValue) {
		this.secondValue = secondValue;
	}

	@Override
	public Boolean isValidForSurebet() {
		return Boolean.TRUE;
	}

	@Override
	public String toString() {
		return "Rt1X2HandicapAttribute [firstValue=" + firstValue + ", result="
				+ result + ", secondValue=" + secondValue + "]";
	}	

}
