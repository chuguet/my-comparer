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
 * The Class ValueBetHope.
 */
public class ValueBetMathematicalExpectation {

	/** The value. */
	@NotNull
	private Double value;

	/**
	 * Instantiates a new value bet mathematical expectation.
	 */
	public ValueBetMathematicalExpectation() {
	}

	/**
	 * Instantiates a new value bet mathematical expectation.
	 * 
	 * @param pValue
	 *            the value
	 */
	public ValueBetMathematicalExpectation(Double pValue) {
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
