/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class DateUtilJava.
 */
public class DateUtilJava {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DateUtilJava.class);

	/** The Constant DATE_TIME. */
	private static final SimpleDateFormat DATE_TIME = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/** The Constant DATE. */
	private static final SimpleDateFormat DATE = new SimpleDateFormat(
			"dd/MM/yyyy");

	/** The Constant TIME. */
	private static final SimpleDateFormat TIME = new SimpleDateFormat("HH:mm");

	/**
	 * Date time to string.
	 * 
	 * @param date
	 *            the date
	 * @param timeZone
	 *            the time zone
	 * @return the string
	 */
	public static String dateTimeToString(final Date date) {
		String result = "";
		result = DATE_TIME.format(date);
		return result;
	}

	/**
	 * Date to string.
	 * 
	 * @param date
	 *            the date
	 * @param timeZone
	 *            the time zone
	 * @return the string
	 */
	public static String dateToString(final Date date) {
		String result = "";
		result = DATE.format(date);
		return result;
	}

	/**
	 * Time to string.
	 * 
	 * @param date
	 *            the date
	 * @param timeZone
	 *            the time zone
	 * @return the string
	 */
	public static String timeToString(final Date date) {
		String result = "";
		result = TIME.format(date);
		return result;
	}

	/**
	 * Date with words month to string.
	 * 
	 * @param date
	 *            the date
	 * @param timeZone
	 *            the time zone
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	public static String dateWithWordsMonthToString(final Date date,
			final Locale locale) {
		Locale defaultLocale = Locale.getDefault();
		SimpleDateFormat sdf;
		if (locale != null) {
			sdf = new SimpleDateFormat("dd MMMMM yyyy", locale);
		} else {
			sdf = new SimpleDateFormat("dd MMMMM yyyy", defaultLocale);
		}
		String result = "";
		result = sdf.format(date);
		return result;
	}

	/**
	 * String to date with words month.
	 * 
	 * @param date
	 *            the date
	 * @param locale
	 *            the locale
	 * @return the date
	 */
	public static Date stringToDateWithWordsMonth(final String date,
			Locale locale) {
		Date result = null;
		Locale defaultLocale = Locale.getDefault();
		SimpleDateFormat sdf;
		if (locale != null) {
			sdf = new SimpleDateFormat("dd MMMMM yyyy", locale);
		} else {
			sdf = new SimpleDateFormat("dd MMMMM yyyy", defaultLocale);
		}
		try {
			result = sdf.parse(date);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Checks if is date time.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is date time
	 */
	public static boolean isDateTime(final String date) {
		boolean result;
		try {
			DATE_TIME.parse(date);
			result = true;
		} catch (ParseException e) {
			result = false;
		}
		return result;
	}

	/**
	 * Checks if is date.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is date
	 */
	public static boolean isDate(final String date) {
		boolean result;
		try {
			DATE.parse(date);
			result = true;
		} catch (ParseException e) {
			result = false;
		}
		return result;
	}

	/**
	 * Checks if is time.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is time
	 */
	public static boolean isTime(final String date) {
		boolean result;
		try {
			TIME.parse(date);
			result = true;
		} catch (ParseException e) {
			result = false;
		}
		return result;
	}

	/**
	 * Convert sistem dependent date to desired time zone. Mongo siempre guarda
	 * las fechas en GMT0/UTC0. Al recuperar una fecha, mongo automaticamente la
	 * devuelve expresada en la zona horaria del sistema desde donde se pidio la
	 * fecha. Este metodo transforma una fecha a una zona horaria deseada,
	 * teniendo en cuenta el local desde donde se ejecuta el codigo.
	 * 
	 * @param sistemDependentDate
	 *            the sistem dependent date
	 * @param desiredTimeZone
	 *            the desired time zone
	 * @return the date
	 */
	public static Date convertSistemDependentDateToDesiredTimeZone(
			final Date sistemDependentDate, TimeZone desiredTimeZone) {

		Long msDate = sistemDependentDate.getTime();
		int systemTimeZoneOffset = TimeZone.getDefault()
				.getOffset(Calendar.getInstance().getTimeInMillis());
		if (desiredTimeZone == null) {
			desiredTimeZone = TimeZone.getDefault();
		}
		int desiredTimeZoneOffset = desiredTimeZone
				.getOffset(Calendar.getInstance().getTimeInMillis());
		int totalMsOffset = - systemTimeZoneOffset
				+ desiredTimeZoneOffset;
		msDate = msDate + totalMsOffset;
		return new Date(msDate);
	}

}
