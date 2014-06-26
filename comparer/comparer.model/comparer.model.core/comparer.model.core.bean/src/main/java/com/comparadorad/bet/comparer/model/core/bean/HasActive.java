/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.util.Date;

/**
 * The Interface HasActive.
 * 
 * Indicates if an element is active.
 */
public interface HasActive {

	/**
	 * Checks if is active.
	 * 
	 * @param pDate
	 *            the date
	 * @return true, if is active
	 */
	boolean isActive(final Date pDate);

}
