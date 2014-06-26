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
 * The Class AbstractHistoricChangeActivable.
 */
@SuppressWarnings("serial")
public class AbstractHistoricChangeActivable extends AbstractHistoricChange
		implements HasActive, IActivable {

	/** The core active element. */
	@Field
	private CoreActiveElement coreActiveElement;

	/**
	 * Instantiates a new abstract historic change activable.
	 */
	public AbstractHistoricChangeActivable() {
		super();

	}

	/**
	 * Instantiates a new abstract historic change activable.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractHistoricChangeActivable(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new abstract historic change activable.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractHistoricChangeActivable(IObjectIdEnum pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new abstract historic change activable.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractHistoricChangeActivable(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Gets the core active element.
	 * 
	 * @return the core active element
	 */
	public CoreActiveElement getCoreActiveElement() {
		return coreActiveElement;
	}

	/**
	 * Checks if is active.
	 * 
	 * @param pDate
	 *            the date
	 * @return true, if is active {@inheritDoc}
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
