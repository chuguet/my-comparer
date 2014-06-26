/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.core.bean;

/**
 * The Class UriParameter.
 */
public class UriParameterBean {
	
	/** The name. */
	private final String name;
	
	/** The value. */
	private final String value;
	
	
	/**
	 * Instantiates a new uri parameter bean.
	 *
	 * @param name the name
	 * @param value the value
	 */
	public UriParameterBean(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}	

}
