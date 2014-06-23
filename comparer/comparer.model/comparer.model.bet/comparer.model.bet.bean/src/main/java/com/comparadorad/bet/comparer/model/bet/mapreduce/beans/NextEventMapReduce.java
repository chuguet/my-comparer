/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.mapreduce.beans;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AllNextEvent.
 */
public class NextEventMapReduce extends AbstractMapReduce implements
		Comparable<NextEventMapReduce> {

	/** The value. */
	@Field
	private NextEvent value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public NextEvent getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(NextEvent value) {
		this.value = value;
	}

	@Override
	public int compareTo(NextEventMapReduce object) {
		int result = 0;
		if (object.getValue().getMarkets().isEmpty()) {
			result = -1;
		} else {
			result = this.getValue().getDate()
					.compareTo(object.getValue().getDate());
		}
		return result;
	}

}
