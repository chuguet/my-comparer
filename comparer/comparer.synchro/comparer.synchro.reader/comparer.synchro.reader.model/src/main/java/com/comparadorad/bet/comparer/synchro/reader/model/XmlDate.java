/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import com.comparadorad.bet.comparer.util.commons.date.CommonsDate;

/**
 * The Class XmlDate.
 */
@SuppressWarnings("rawtypes")
public class XmlDate extends AbstractXmlData implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3858186344529655706L;

	/** The commons date. */
	private CommonsDate commonsDate;

	/**
	 * Gets the date for time zone.
	 * 
	 * @param pTimeZone
	 *            the time zone
	 * @return the date for time zone
	 */
	public Date getDateForTimeZone(TimeZone pTimeZone) {
		return commonsDate.getDateForTimeZone(pTimeZone);
	}

	/**
	 * Gets the date time str for time zone.
	 * 
	 * @param pTimeZone
	 *            the time zone
	 * @return the date time str for time zone
	 */
	public String getDateTimeStrForTimeZone(TimeZone pTimeZone) {
		return commonsDate.getDateTimeStrForTimeZone(pTimeZone);
	}

	/**
	 * Gets the zero gmt match date.
	 * 
	 * @return the zero gmt match date
	 */
	public Date getZeroGmtMatchDate() {
		return commonsDate.getZeroGmtMatchDate();
	}

	/**
	 * Gets the zero gmt match time zone.
	 * 
	 * @return the zero gmt match time zone
	 */
	public TimeZone getZeroGmtMatchTimeZone() {
		return commonsDate.getZeroGmtMatchTimeZone();
	}

	public String getZeroGmtMatchTimeZoneStr() {
		return commonsDate.getZeroGmtMatchTimeZoneStr();
	}

	/**
	 * Gets the provider date.
	 * 
	 * @return the provider date
	 */
	public Date getProviderDate() {
		return commonsDate.getProviderDate();
	}

	/**
	 * Gets the provider time zone.
	 * 
	 * @return the provider time zone
	 */
	public TimeZone getProviderTimeZone() {
		return commonsDate.getProviderTimeZone();
	}

	public String getProviderTimeZoneStr() {
		return commonsDate.getProviderTimeZoneStr();
	}

	/**
	 * Sets the zero gmt match date.
	 * 
	 * @param pZeroGmtMatchDate
	 *            the new zero gmt match date
	 */
	public void setZeroGmtMatchDate(Date pZeroGmtMatchDate) {
		commonsDate.setZeroGmtMatchDate(pZeroGmtMatchDate);
	}

	/**
	 * Sets the provider date.
	 * 
	 * @param pProviderDate
	 *            the new provider date
	 */
	public void setProviderDate(Date pProviderDate) {
		commonsDate.setProviderDate(pProviderDate);
	}

	/**
	 * Sets the provider time zone.
	 * 
	 * @param pProviderTimeZone
	 *            the new provider time zone
	 */
	public void setProviderTimeZone(String pProviderTimeZone) {
		commonsDate.setProviderTimeZoneStr(pProviderTimeZone);
	}

	/**
	 * Instantiates a new xml date.
	 */
	public XmlDate() {
		super();
	}

	/**
	 * Instantiates a new xml date.
	 * 
	 * @param pDate
	 *            the date
	 */
	public XmlDate(Date pDate) {
		super();
		commonsDate = new CommonsDate(pDate);
	}

	/**
	 * Instantiates a new xml date.
	 * 
	 * @param pProviderDate
	 *            the provider date
	 * @param pProviderTimeZone
	 *            the provider time zone
	 */
	public XmlDate(Date pProviderDate, String pProviderTimeZone) {
		super();
		commonsDate = new CommonsDate(pProviderDate, pProviderTimeZone);
	}

	/**
	 * Instantiates a new xml date.
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
	public XmlDate(Date pProviderDate, String pProviderTimeZone,
			Date pZeroGmtMatchDate) {
		super();
		commonsDate = new CommonsDate(pProviderDate, pProviderTimeZone,
				pZeroGmtMatchDate);
	}

	@Override
	public String toString() {
		return "XmlDate [commonsDate=" + commonsDate + "]";
	}
	
	

}
