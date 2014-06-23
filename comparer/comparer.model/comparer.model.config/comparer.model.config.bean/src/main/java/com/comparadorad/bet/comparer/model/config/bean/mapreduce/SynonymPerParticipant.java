/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.mapreduce;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class SynonymPerParticipant.
 */
public class SynonymPerParticipant extends AbstractBeanMapReduce {

	/** The value. */
	@Field
	private SynonymPerParticipantValue value;

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public SynonymPerParticipantValue getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(SynonymPerParticipantValue value) {
		this.value = value;
	}

}
