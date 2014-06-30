/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.date;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class CoreDate.
 */
@SuppressWarnings("serial")
public class CommonsDate implements Serializable {

	/** The Constant GMT_0. */
	public static final String GMT_0 = "GMT+0";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CommonsDate.class);

	/** The date. */
	@Field
	private Date providerDate;

	/** The date. */
	@Transient
	private transient TimeZone providerTimeZone;

	/** The provider time zone str. */
	@Field
	private String providerTimeZoneStr;

	/** The GMT 0 MATCH date. */
	@Field
	private Date zeroGmtMatchDate;

	/** The date. */
	@Transient
	private transient TimeZone zeroGmtMatchTimeZone;

	/** The zero gmt match time zone str. */
	@Field
	private String zeroGmtMatchTimeZoneStr;

	/**
	 * Instantiates a new xml date.
	 */
	public CommonsDate() {
		super();
		setZeroGmtMatchTimeZoneStr();
	}

	/**
	 * Instantiates a new xml date.
	 * 
	 * @param pDate
	 *            the date
	 */
	public CommonsDate(Date pDate) {
		super();
		providerDate = pDate;
		setZeroGmtMatchTimeZoneStr();
	}

	/**
	 * Instantiates a new xml date.
	 * 
	 * @param pProviderDate
	 *            the provider date
	 * @param pProviderTimeZone
	 *            the provider time zone
	 */
	public CommonsDate(Date pProviderDate, String pProviderTimeZone) {
		super();
		providerDate = pProviderDate;
		this.setProviderTimeZoneStr(pProviderTimeZone);
		setZeroGmtMatchTimeZoneStr();
		zeroGmtMatchDate = pProviderDate;
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
	 */
	public CommonsDate(Date pProviderDate, String pProviderTimeZone,
			Date pZeroGmtMatchDate) {
		super();
		providerDate = pProviderDate;
		zeroGmtMatchDate = pZeroGmtMatchDate;
		this.setProviderTimeZoneStr(pProviderTimeZone);
		this.setZeroGmtMatchTimeZoneStr();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommonsDate other = (CommonsDate) obj;
		if (zeroGmtMatchDate == null) {
			if (other.zeroGmtMatchDate != null)
				return false;
		} else if (!zeroGmtMatchDate.equals(other.zeroGmtMatchDate))
			return false;
		return true;
	}

	/**
	 * Gets the date for time zone.
	 * 
	 * @param pTimeZone
	 *            the time zone
	 * @return the date for time zone
	 */
	public Date getDateForTimeZone(TimeZone pTimeZone) {
		Date result = new Date();
		DateFormat dateFormat = new SimpleDateFormat();

		String fecha = dateFormat.format(result);
		dateFormat.setTimeZone(pTimeZone);
		try {
			result = dateFormat.parse(fecha);
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
		}
		return result;

	}

	/**
	 * Gets the date time str for time zone.
	 * 
	 * @param pTimeZone
	 *            the time zone
	 * @return the date time str for time zone
	 */
	public String getDateTimeStrForTimeZone(TimeZone pTimeZone) {
		Date fecha = new Date();
		String result = "";

		DateFormat dateFormat = new SimpleDateFormat();
		dateFormat.setTimeZone(pTimeZone);
		result = dateFormat.format(fecha);
		return result;

	}

	/**
	 * Gets the match date expressed in gmt0. Si la fecha 'zeroGmtMatchDate'
	 * haya sido recuperado de la BD, mongo automaticamente nos ha devuelto la
	 * fecha expresada en la zona horaria del sistema. Este metodo devuelve la
	 * fecha expresada en GMT0.
	 * 
	 * @return the match date expressed in gmt0
	 */
	public Date getMatchDateExpressedInGMT0() {

		Long msDate = zeroGmtMatchDate.getTime();
		int offset = TimeZone.getDefault().getOffset(
				Calendar.getInstance().getTimeInMillis());
		msDate = msDate - offset;

		return new Date(msDate);
	}

	/**
	 * Gets the provider date. OJO! Si la fecha haya sido recuperado de la BD,
	 * mongo automaticamente nos ha devuelto la fecha expresada en la zona
	 * horaria del sistema.
	 * 
	 * @return the provider date
	 */
	public Date getProviderDate() {
		return providerDate;
	}

	/**
	 * Gets the provider date expressed in gmt0. Si la fecha 'providerDate' haya
	 * sido recuperado de la BD, mongo automaticamente nos ha devuelto la fecha
	 * expresada en la zona horaria del sistema. Este metodo devuelve la fecha
	 * expresada en GMT0.
	 * 
	 * @return the provider date expressed in gmt0
	 */
	public Date getProviderDateExpressedInGMT0() {

		Long msDate = providerDate.getTime();
		int offset = TimeZone.getDefault().getOffset(
				Calendar.getInstance().getTimeInMillis());
		msDate = msDate - offset;

		return new Date(msDate);

	}

	/**
	 * Gets the provider time zone.
	 * 
	 * @return the provider time zone
	 */
	public TimeZone getProviderTimeZone() {
		return providerTimeZone;
	}

	/**
	 * Gets the provider time zone str.
	 * 
	 * @return the provider time zone str
	 */
	public String getProviderTimeZoneStr() {
		return providerTimeZoneStr;
	}

	/**
	 * Gets the local match date. OJO! Si la fecha haya sido recuperado de la
	 * BD, mongo automaticamente nos ha devuelto la fecha expresada en la zona
	 * horaria del sistema.
	 * 
	 * @return the local match date
	 */
	public Date getZeroGmtMatchDate() {

		return zeroGmtMatchDate;
	}

	/**
	 * Gets the local match time zone.
	 * 
	 * @return the local match time zone
	 */
	public TimeZone getZeroGmtMatchTimeZone() {
		return zeroGmtMatchTimeZone;
	}

	/**
	 * Gets the zero gmt match time zone str.
	 * 
	 * @return the zero gmt match time zone str
	 */
	public String getZeroGmtMatchTimeZoneStr() {
		return zeroGmtMatchTimeZoneStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((zeroGmtMatchDate == null) ? 0 : zeroGmtMatchDate.hashCode());
		return result;
	}

	/**
	 * Sets the provider date. Si se desea hacer consultas contra/guardar en BD,
	 * esta fecha debe estar expresada en la zona de horaria del sistema, es
	 * decir, no hay que transformarlo a GMT0 ya que mongo lo hará
	 * automaticamente.
	 * 
	 * @param pProviderDate
	 *            the new provider date
	 */
	public void setProviderDate(Date pProviderDate) {
		providerDate = pProviderDate;
	}

	/**
	 * Sets the provider time zone.
	 * 
	 * @param pProviderTimeZone
	 *            the new provider time zone
	 */
	protected void setProviderTimeZone(TimeZone pProviderTimeZone) {
		providerTimeZone = pProviderTimeZone;
	}

	/**
	 * Sets the provider time zone str.
	 * 
	 * @param pProviderTimeZoneStr
	 *            the new provider time zone str
	 */
	public void setProviderTimeZoneStr(final String pProviderTimeZoneStr) {
		providerTimeZoneStr = pProviderTimeZoneStr;
		setProviderTimeZone(TimeZone.getTimeZone(providerTimeZoneStr));
	}

	/**
	 * Sets the local match date. Si se desea hacer consultas contra/guardar en
	 * BD, esta fecha debe estar expresada en la zona de horaria del sistema, es
	 * decir, no hay que transformarlo a GMT0 ya que mongo lo hará
	 * automaticamente.
	 * 
	 * @param pZeroGmtMatchDate
	 *            the new zero gmt match date
	 */
	public void setZeroGmtMatchDate(Date pZeroGmtMatchDate) {
		zeroGmtMatchDate = pZeroGmtMatchDate;
	}

	/**
	 * Sets the zero gmt match time zone.
	 * 
	 * @param pZeroGmtMatchTimeZone
	 *            the new zero gmt match time zone
	 */
	private void setZeroGmtMatchTimeZone(TimeZone pZeroGmtMatchTimeZone) {
		zeroGmtMatchTimeZone = pZeroGmtMatchTimeZone;
	}

	/**
	 * Sets the zero gmt match time zone str.
	 */
	public void setZeroGmtMatchTimeZoneStr() {
		zeroGmtMatchTimeZoneStr = GMT_0;
		setZeroGmtMatchTimeZone(TimeZone.getTimeZone(zeroGmtMatchTimeZoneStr));
	}

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "CommonsDate [providerDate=" + providerDate
				+ ", providerTimeZoneStr=" + providerTimeZoneStr
				+ ", zeroGmtMatchDate=" + zeroGmtMatchDate
				+ ", zeroGmtMatchTimeZoneStr=" + zeroGmtMatchTimeZoneStr + "]";
	}

}
