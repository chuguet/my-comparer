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
 * The Class AbstractI18nTable.
 */
@SuppressWarnings("serial")
public abstract class AbstractI18nTableActivable extends AbstractI18nTable
		implements HasActive, IActivable {

	/** The core active element. */
	@Field
	private CoreActiveElement coreActiveElement;

	/**
	 * Instantiates a new abstract i18n table activable.
	 */
	public AbstractI18nTableActivable() {
		super();

	}

	/**
	 * Instantiates a new abstract i18n table activable.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractI18nTableActivable(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new abstract i18n table activable.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractI18nTableActivable(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new abstract i18n table activable.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractI18nTableActivable(String pObjectId) {
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
