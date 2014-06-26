/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import java.util.Date;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.util.commons.date.DateFormatUtil;

/**
 * The Class XmlReaderHandlerConfiguration.
 */
public class XmlReaderHandlerConfiguration {

	/**
	 * The Class XmlDateFormatUtil.
	 */
	public static class XmlDateFormatUtil extends DateFormatUtil {

		/**
		 * Instantiates a new xml date format util.
		 * 
		 * @param pFormat
		 *            the format
		 */
		public XmlDateFormatUtil(String pFormat) {
			super(pFormat);
		}

		/**
		 * Instantiates a new xml date format util.
		 * 
		 * @param pFormat
		 *            the format
		 * @param pRemoveChars
		 *            the remove chars
		 * @param pTimeZone
		 *            the time zone
		 */
		public XmlDateFormatUtil(String pFormat, String[] pRemoveChars,
				String pTimeZone) {
			super(pFormat, pRemoveChars, pTimeZone);
		}

		/**
		 * Gets the xml date.
		 * 
		 * @param date
		 *            the date
		 * @return the xml date
		 */
		public XmlDate getXmlDate(final String date) {
			if (date != null) {
				Date result = super.getDate(date);
				// Date gmtDate = super.getZeroGmtDate(date);
				return new XmlDate(result, super.getTimeZoneStr());
				// return new XmlDate(result,timeZone, gmtDate,
				// TimeZone.getTimeZone("GMT+0"));
			} else {
				return null;
			}
		}

	}

	/** The date util. */
	private XmlDateFormatUtil dateFormatUtil;

	/** The xml bet file reader data. */
	private final XmlBetFileReaderData xmlBetFileReaderData;

	/**
	 * Instantiates a new xml reader handler configuration.
	 * 
	 * @param pXmlBetFileReaderData
	 *            the xml bet file reader data
	 */
	public XmlReaderHandlerConfiguration(
			XmlBetFileReaderData pXmlBetFileReaderData) {
		super();
		xmlBetFileReaderData = pXmlBetFileReaderData;
	}

	/**
	 * Gets the date util.
	 * 
	 * @return the date util
	 */
	public XmlDateFormatUtil getDateUtil() {
		return dateFormatUtil;
	}

	/**
	 * Gets the xml bet file reader data.
	 * 
	 * @return the xml bet file reader data
	 */
	public XmlBetFileReaderData getXmlBetFileReaderData() {
		return xmlBetFileReaderData;
	}

	/**
	 * Sets the date util.
	 * 
	 * @param pDateFormatUtil
	 *            the new date util
	 */
	public void setDateUtil(XmlDateFormatUtil pDateFormatUtil) {
		dateFormatUtil = pDateFormatUtil;
	}
}
