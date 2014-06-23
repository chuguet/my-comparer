/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class Rt1X2Attribute.
 */
@SuppressWarnings("serial")
public class Rt1X2Attribute extends AbstractRtAttribute implements Serializable {

	/** The result. */
	@Field
	@NotNull
	@Valid
	private Result result;

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rt1X2Attribute other = (Rt1X2Attribute) obj;
		if (result != other.result)
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String getAttributeHashCode() {
		return new StringBuffer().append(this.result).toString();
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		return result;
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

	@Override
	public Boolean isValidForSurebet() {
		return Boolean.TRUE;
	}

	@Override
	public String toString() {
		return "Rt1X2Attribute [result=" + result + "]";
	}
	
	

}
