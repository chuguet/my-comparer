/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.bean;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueBetProbability.
 */
public class ValueBetProbability {

	/** The value. */
	@NotNull
	private Double value;

	/**
	 * Instantiates a new value bet probability.
	 */
	public ValueBetProbability() {
	}

	/**
	 * Instantiates a new value bet probability.
	 * 
	 * @param pValue
	 *            the value
	 */
	public ValueBetProbability(Double pValue) {
		this.value = pValue;
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

}
