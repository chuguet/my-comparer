/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AbstractId.
 */
@SuppressWarnings("serial")
public abstract class AbstractIdActivable extends AbstractId implements
		HasActive {

	/** The core active element. */
	@Field
	private CoreActiveElement coreActiveElement;

	/**
	 * Instantiates a new abstract id activable.
	 */
	public AbstractIdActivable() {
		super();

	}

	/**
	 * Instantiates a new abstract id activable.
	 *
	 * @param pObjectId the object id
	 */
	public AbstractIdActivable(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new abstract id activable.
	 *
	 * @param pObjectId the object id
	 */
	public AbstractIdActivable(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Checks if is active.
	 *
	 * @param pDate the date
	 * @return true, if is active
	 * {@inheritDoc}
	 */
	@Override
	public boolean isActive(Date pDate) {
		boolean result = true;
		if (coreActiveElement != null) {
			result = coreActiveElement.isActive(pDate);
		}
		return result;
	}

	/**
	 * Sets the core active element.
	 * 
	 * @param pCoreActiveElement
	 *            the new core active element
	 */
	public void setCoreActiveElement(CoreActiveElement pCoreActiveElement) {
		coreActiveElement = pCoreActiveElement;
	}
}
