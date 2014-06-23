package com.comparadorad.bet.comparer.model.config.bean.mapreduce;

import org.springframework.data.mongodb.core.mapping.Field;

public class CountryToolbar extends AbstractBeanMapReduce {

	/** The value. */
	@Field
	private CountryToolbarValue value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public CountryToolbarValue getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(CountryToolbarValue value) {
		this.value = value;
	}
}
