/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class RtAsianHandicapAttribute.
 */
@SuppressWarnings("serial")
public class RtAsianHandicapAttribute extends AbstractRtAttribute implements
		IHandicapAttribute {

	/** The asian result. */
	@Field
	private AsianResult asianResult;

	/** The firstValue. */
	@Field
	@NotNull
	private Double firstValue;

	/** The second value. */
	@Field
	private Double secondValue;

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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtAsianHandicapAttribute other = (RtAsianHandicapAttribute) obj;
		if (asianResult != other.asianResult)
			return false;
		if (super.getFinalValue() == null) {
			if (other.getFinalValue() != null)
				return false;
		} else if (!super.getFinalValue().equals(other.getFinalValue()))
			return false;
		return true;
	}

	/**
	 * Gets the asian result.
	 * 
	 * @return the asian result
	 */
	public AsianResult getAsianResult() {
		return asianResult;
	}

	/** {@inheritDoc} */
	@Override
	public String getAttributeHashCode() {
		StringBuffer attributeSpecificHashKey = new StringBuffer();
		attributeSpecificHashKey.append(super.getFinalValue());
		attributeSpecificHashKey.append(asianResult);
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
	 * Gets the second value.
	 * 
	 * @return the second value
	 */
	public Double getSecondValue() {
		return secondValue;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.append(this.asianResult.getNameId())
				.append(super.getFinalValue()).toHashCode();
	}

	/**
	 * Sets the asian result.
	 * 
	 * @param pAsianResult
	 *            the new asian result
	 */
	public void setAsianResult(AsianResult pAsianResult) {
		asianResult = pAsianResult;
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
		Boolean result = Boolean.TRUE;
		
		if(this.getFinalValue()!=null && this.getFinalValue()%1==0){
			result = Boolean.FALSE;
		}
		return result;
	}

	@Override
	public String toString() {
		return "RtAsianHandicapAttribute [asianResult=" + asianResult
				+ ", firstValue=" + firstValue + ", secondValue=" + secondValue
				+ "]";
	}	

}
