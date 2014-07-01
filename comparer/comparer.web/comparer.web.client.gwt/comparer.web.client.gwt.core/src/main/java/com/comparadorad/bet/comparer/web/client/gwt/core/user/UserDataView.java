/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.core.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.i18n.client.TimeZoneInfo;
import com.google.gwt.i18n.client.constants.TimeZoneConstants;

/**
 * The Class AppProperties.
 */
public class UserDataView {

	/** The instance. */
	private static UserDataView instance;

	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static final UserDataView getInstance() {
		if (instance == null) {
			instance = new UserDataView();
		}
		return instance;
	}

	/** The user time zone. */
	private TimeZone userTimeZone;

	/**
	 * Gets the user time zone.
	 * 
	 * @return the user time zone
	 */
	public TimeZone getUserTimeZone() {
		if (userTimeZone == null) {
			final TimeZoneConstants timeZoneConstants = GWT
					.create(TimeZoneConstants.class);
			userTimeZone = TimeZone.createTimeZone(TimeZoneInfo
					.buildTimeZoneData(timeZoneConstants.europeMadrid()));
		}
		return userTimeZone;

	}
}
