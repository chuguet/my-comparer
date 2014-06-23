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
 * The Class UnderOverAttribute.
 */
@SuppressWarnings("serial")
public class RtMasMenosAttribute extends AbstractRtAttribute {

	/** The mas menos. */
	@Field
	private MasMenos masMenos;

	/** The value. */
	@Field
	@NotNull
	private Double totalGoalValue;

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
		RtMasMenosAttribute other = (RtMasMenosAttribute) obj;
		if (masMenos != other.masMenos)
			return false;
		if (super.getFinalValue() == null) {
			if (other.getFinalValue() != null)
				return false;
		} else if (!super.getFinalValue().equals(other.getFinalValue()))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String getAttributeHashCode() {
		return new StringBuffer().append(super.getFinalValue())
				.append(this.masMenos).toString();
	}

	/**
	 * Gets the mas menos.
	 * 
	 * @return the mas menos
	 */
	public MasMenos getMasMenos() {
		return masMenos;
	}

	/**
	 * Gets the total goal value.
	 * 
	 * @return the total goal value
	 */
	public Double getTotalGoalValue() {
		return totalGoalValue;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode())
				.append(this.masMenos.getNameId())
				.append(super.getFinalValue()).toHashCode();
	}

	/**
	 * Sets the mas menos.
	 * 
	 * @param pMasMenos
	 *            the new mas menos
	 */
	public void setMasMenos(MasMenos pMasMenos) {
		masMenos = pMasMenos;
	}

	/**
	 * Sets the total goal value.
	 * 
	 * @param totalGoalValue
	 *            the new total goal value
	 */
	public void setTotalGoalValue(Double totalGoalValue) {
		this.totalGoalValue = totalGoalValue;
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
		return "RtMasMenosAttribute [masMenos=" + masMenos
				+ ", totalGoalValue=" + totalGoalValue + "]";
	}	
	
}
