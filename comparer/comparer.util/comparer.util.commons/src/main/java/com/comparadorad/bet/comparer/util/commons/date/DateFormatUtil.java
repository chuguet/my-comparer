/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.util.commons.exception.DateFormatException;

/**
 * The Class DateFormatUtil.
 */
public class DateFormatUtil {

	/** The Constant DEFAULT_FORMAT. */
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** The Constant DEFAULT_FORMAT. */
	public static final String FILENAME_FORMAT = "yyyyMMddHHmmss";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DateFormatUtil.class);

	/**
	 * Gets the single instance of DateFormatUtil.
	 * 
	 * @return single instance of DateFormatUtil
	 */
	public static DateFormatUtil getInstance() {
		return new DateFormatUtil(DEFAULT_FORMAT);
	}

	/**
	 * Gets the single instance of DateFormatUtil.
	 * 
	 * @param pFormat
	 *            the format
	 * @return single instance of DateFormatUtil
	 */
	public static DateFormatUtil getInstance(String pFormat) {
		return new DateFormatUtil(pFormat);
	}

	/**
	 * Gets the single instance of DateFormatUtil.
	 * 
	 * @param pFormat
	 *            the format
	 * @param pRemoveChars
	 *            the remove chars
	 * @return single instance of DateFormatUtil
	 */
	public static DateFormatUtil getInstance(String pFormat,
			String[] pRemoveChars) {
		return new DateFormatUtil(pFormat, pRemoveChars);
	}

	/** The format. */
	private final String format;

	/** The remove chars. */
	private String[] removeChars;

	/** The time zone. */
	private TimeZone timeZone;

	/** The time zone str. */
	private String timeZoneStr;

	/**
	 * Instantiates a new date util.
	 * 
	 * @param pFormat
	 *            the format
	 */
	public DateFormatUtil(String pFormat) {
		super();
		format = pFormat;
	}

	/**
	 * Instantiates a new date util.
	 * 
	 * @param pFormat
	 *            the format
	 * @param pRemoveChars
	 *            the remove chars
	 */
	public DateFormatUtil(String pFormat, String[] pRemoveChars) {
		super();
		format = pFormat;
		removeChars = pRemoveChars;
	}

	/**
	 * Instantiates a new date util.
	 * 
	 * @param pFormat
	 *            the format
	 * @param pRemoveChars
	 *            the remove chars
	 * @param pTimeZone
	 *            the time zone
	 */
	public DateFormatUtil(String pFormat, String[] pRemoveChars,
			String pTimeZone) {
		super();
		format = pFormat;
		removeChars = pRemoveChars;
		timeZone = TimeZone.getTimeZone(pTimeZone);
		timeZoneStr = pTimeZone;
	}

	/**
	 * Format.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 */
	public String format(final Date date) {

		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * Gets the date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public Date getDate(final String date) {
		String tmpDate = date;
		if (removeChars != null) {
			for (String removeChar : removeChars) {
				tmpDate = tmpDate.replace(removeChar, " ");
			}
		}
		DateFormat dateFormat = new SimpleDateFormat(format);
		if (timeZone != null) {
			dateFormat.setTimeZone(timeZone);
		} else {
			LOG.warn("The timeZone is not informed");
		}
		Date matchDate;
		try {
			matchDate = dateFormat.parse(tmpDate);
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
			throw new DateFormatException(e.getMessage(), e);
		}
		return matchDate;
	}

	/**
	 * Gets the time zone.
	 * 
	 * @return the time zone
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * Gets the time zone str.
	 * 
	 * @return the time zone str
	 */
	public String getTimeZoneStr() {
		return timeZoneStr;
	}

	/**
	 * Gets the zero gmt date.
	 * 
	 * @param date
	 *            the date
	 * @return the zero gmt date
	 */
	public Date getZeroGmtDate(final String date) {
		String tmpDate = date;
		if (removeChars != null) {
			for (String removeChar : removeChars) {
				tmpDate = tmpDate.replace(removeChar, " ");
			}
		}
		DateFormat dateFormat = new SimpleDateFormat(format);

		Date matchDate;
		try {
			matchDate = dateFormat.parse(tmpDate);
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
			throw new DateFormatException(e.getMessage(), e);
		}
		return matchDate;
	}
}