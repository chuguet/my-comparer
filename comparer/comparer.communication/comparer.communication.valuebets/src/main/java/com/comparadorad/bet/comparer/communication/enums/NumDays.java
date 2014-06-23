/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.enums;

import java.util.Calendar;

/**
 * The Enum NumDays.
 */
public enum NumDays {
	
	/** The DAILY. */
	DAILY(1, Boolean.FALSE),

	/** The WEEKLY. */
	WEEKLY(7, Boolean.FALSE),

	/** The MONTHLY. */
	MONTHLY(null, Boolean.TRUE);

	/** The num days. */
	private Integer numDays;

	/** The calculate. */
	private Boolean calculate;

	/**
	 * Instantiates a new num days.
	 *
	 * @param numDays the num days
	 * @param calculate the calculate
	 */
	NumDays(Integer numDays, Boolean calculate) {
		this.setNumDays(numDays);
		this.calculate = calculate;
	}

	/**
	 * Gets the num days.
	 *
	 * @return the num days
	 */
	public Integer getNumDays() {
		if (calculate.equals(Boolean.TRUE)) {
			numDays = Calendar.getInstance().getActualMaximum(
					Calendar.DAY_OF_MONTH);
		}
		return numDays;
	}

	/**
	 * Sets the num days.
	 *
	 * @param numDays the new num days
	 */
	public void setNumDays(Integer numDays) {
		this.numDays = numDays;
	}

}
