/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.bean;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;

/**
 * The Class HandicapOddsSortedByAttribute.
 */
public class HandicapOddsSortedByAttribute extends OddsSortedBy {

	/** The attribute. */
	private AbstractRtAttribute attribute;

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
		HandicapOddsSortedByAttribute other = (HandicapOddsSortedByAttribute) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		return true;
	}

	/**
	 * Gets the attribute.
	 * 
	 * @return the attribute
	 */
	public AbstractRtAttribute getAttribute() {
		return attribute;
	}

	/** {@inheritDoc} */
	@Override
	public Double getFinalValue() {
		if (attribute != null) {
			return attribute.getFinalValue();
		} else {
			return null;
		}
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return attribute.hashCode();
	}

	/**
	 * Sets the attribute.
	 * 
	 * @param attribute
	 *            the new attribute
	 */
	public void setAttribute(AbstractRtAttribute attribute) {
		this.attribute = attribute;
	}

}
