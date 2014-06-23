/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.mapreduce;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class SynonymPerParticipantValue.
 */
public class SynonymPerParticipantValue {

	/** The counter synonyms. */
	@Field
	private Double counterSynonyms;

	/** The synonyms id list. */
	@Field
	private List<Integer> synonymsIdList;

	/**
	 * Gets the counter synonyms.
	 * 
	 * @return the counter synonyms
	 */
	public Double getCounterSynonyms() {
		return counterSynonyms;
	}

	/**
	 * Sets the counter synonyms.
	 * 
	 * @param counterSynonyms
	 *            the new counter synonyms
	 */
	public void setCounterSynonyms(Double counterSynonyms) {
		this.counterSynonyms = counterSynonyms;
	}

	/**
	 * Gets the synonyms id list.
	 * 
	 * @return the synonyms id list
	 */
	public List<Integer> getSynonymsIdList() {
		return synonymsIdList;
	}

	/**
	 * Sets the synonyms id list.
	 * 
	 * @param synonymsIdList
	 *            the new synonyms id list
	 */
	public void setSynonymsIdList(List<Integer> synonymsIdList) {
		this.synonymsIdList = synonymsIdList;
	}

}
