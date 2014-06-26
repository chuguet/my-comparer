/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;
import java.util.Date;

import com.comparadorad.bet.comparer.util.commons.date.CommonsDate;

/**
 * The Class CoreDate.
 */
@SuppressWarnings("serial")
public class CoreDate extends CommonsDate implements Serializable {

	/**
	 * Instantiates a new core date.
	 */
	public CoreDate() {
		super();

	}

	/**
	 * Instantiates a new core date.
	 * 
	 * @param pProviderDate
	 *            the provider date
	 * @param pProviderTimeZone
	 *            the provider time zone
	 * @param pZeroGmtMatchDate
	 *            the zero gmt match date
	 * @param pZeroGmtMatchTimeZone
	 *            the zero gmt match time zone
	 */
	public CoreDate(Date pProviderDate, String pProviderTimeZone,
			Date pZeroGmtMatchDate) {
		super(pProviderDate, pProviderTimeZone, pZeroGmtMatchDate);

	}

	/**
	 * Instantiates a new core date.
	 * 
	 * @param pProviderDate
	 *            the provider date
	 * @param pProviderTimeZone
	 *            the provider time zone
	 */
	public CoreDate(Date pProviderDate, String pProviderTimeZone) {
		super(pProviderDate, pProviderTimeZone);

	}

	/**
	 * Instantiates a new core date.
	 * 
	 * @param pDate
	 *            the date
	 */
	public CoreDate(Date pDate) {
		super(pDate);

	}

}
