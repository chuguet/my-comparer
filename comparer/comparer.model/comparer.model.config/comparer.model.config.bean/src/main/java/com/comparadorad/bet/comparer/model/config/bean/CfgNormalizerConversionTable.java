/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractHistoricChangeActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class CfgNormalizerConversionTable.
 */
@Document
public class CfgNormalizerConversionTable extends
		AbstractHistoricChangeActivable implements IDocument {

	public CfgNormalizerConversionTable(String key, List<String> value) {
		super();
		this.key = key;
		this.value = value;
	}

	/** The key. */
	@Field
	private String key;

	/** The value. */
	@Field
	private List<String> value;

	/**
	 * The Constructor.
	 */
	public CfgNormalizerConversionTable() {
		super();
	}

	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public List<String> getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the value
	 */
	public void setValue(List<String> value) {
		this.value = value;
	}

}
