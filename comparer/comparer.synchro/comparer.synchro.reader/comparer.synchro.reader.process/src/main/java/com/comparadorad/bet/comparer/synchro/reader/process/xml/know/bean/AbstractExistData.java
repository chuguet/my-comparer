/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;

/**
 * The Class AbstractExistRtData.
 *
 * @param <T> the generic type
 */
public class AbstractExistData<T extends IRtData> {

	/** The is new. */
	private final Boolean isNew;
	
	/** The rt data. */
	private T rtData;

	/**
	 * Instantiates a new abstract exist rt data.
	 *
	 * @param pIsNew the is new
	 */
	public AbstractExistData(Boolean pIsNew) {
		super();
		isNew = pIsNew;
	}

	/**
	 * Gets the rt data.
	 *
	 * @return the rt data
	 */
	public IRtData getRtData() {
		return rtData;
	}

	/**
	 * Sets the rt data.
	 *
	 * @param pRtData the new rt data
	 */
	public void setRtData(T pRtData) {
		rtData = pRtData;
	}

	/**
	 * Gets the checks if is new.
	 *
	 * @return the checks if is new
	 */
	public Boolean getIsNew() {
		return isNew;
	}	
	
}
