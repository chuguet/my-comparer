/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.bean;

import java.util.Date;

import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Class SureBetQueue.
 */
public class SureBetQueue extends AbstractQueue {

	/** The secure bean data. */
	private final SecureBeanData secureBeanData;
	
	/** The creation date. */
	private final Date creationDate;

	/**
	 * Instantiates a new sure bet queue.
	 *
	 * @param secureBeanData the secure bean data
	 * @param creationDate the creation date
	 */
	public SureBetQueue(SecureBeanData secureBeanData, Date creationDate) {
		super();
		this.secureBeanData = secureBeanData;
		this.creationDate = creationDate;
	}

	/**
	 * Gets the secure bean data.
	 *
	 * @return the secure bean data
	 */
	public final SecureBeanData getSecureBeanData() {
		return secureBeanData;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public final Date getCreationDate() {
		return creationDate;
	}
	
	

}
