/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanParameterPinnacle.
 */
public class BeanParameterPinnacle extends AbstractBeanParameters {

	/** The id time pinnacle. */
	private String idTimePinnacle;

	/**
	 * Instantiates a new bean parameter pinnacle.
	 */
	public BeanParameterPinnacle() {
		super();
	}

	/**
	 * Instantiates a new bean parameter pinnacle.
	 *
	 * @param idTimePinnacle the id time pinnacle
	 */
	public BeanParameterPinnacle(String idTimePinnacle) {
		super();
		this.idTimePinnacle = idTimePinnacle;
	}


	/** {@inheritDoc} */ 
	@Override
	public Class<?> getClassZ() {
		return this.getClass();
	}

	/**
	 * Gets the id time pinnacle.
	 *
	 * @return the id time pinnacle
	 */
	public String getIdTimePinnacle() {
		return idTimePinnacle;
	}

	/**
	 * Sets the id time pinnacle.
	 *
	 * @param idTimePinnacle the new id time pinnacle
	 */
	public void setIdTimePinnacle(String idTimePinnacle) {
		this.idTimePinnacle = idTimePinnacle;
	}

}
