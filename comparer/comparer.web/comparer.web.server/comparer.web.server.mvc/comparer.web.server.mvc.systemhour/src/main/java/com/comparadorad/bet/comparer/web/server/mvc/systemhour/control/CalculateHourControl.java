/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.systemhour.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.web.server.mvc.systemhour.beans.HourRequestTo;
import com.comparadorad.bet.comparer.web.server.mvc.systemhour.beans.HourResponseTo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The Class CalculateHourControl.
 */
@Controller
@RequestMapping("/systemHour")
public class CalculateHourControl {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CalculateHourControl.class);

	/** The Constant DATE_FORMAT. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/**
	 * Calculate hour user.
	 * 
	 * @param hourRequestTo
	 *            the hour request to
	 * @return the hour response to
	 */
	@RequestMapping(value = "/calculateHourUser", method = RequestMethod.POST)
	public @ResponseBody
	HourResponseTo calculateHourUser(@RequestBody HourRequestTo hourRequestTo) {
		Long userId = Long.valueOf(hourRequestTo.getUserId());
		HourResponseTo result = new HourResponseTo();
		TimeZone timeZone = TimeZone.getTimeZone(hourRequestTo.getGmt());
		Date fecha = new Date();

		DATE_FORMAT.setTimeZone(timeZone);
		result.setSystemHour(DATE_FORMAT.format(fecha));

		try {
			User user = UserLocalServiceUtil.getUser(userId);
			user.setTimeZoneId(hourRequestTo.getGmt());
			user = UserLocalServiceUtil.updateUser(user);
		} catch (SystemException e) {
			LOG.error(e.getMessage());
		} catch (PortalException e) {
			LOG.error(e.getMessage());
		}

		LOG.debug("Request GMT: " + hourRequestTo.getGmt());
		LOG.debug("Request User Id: " + hourRequestTo.getUserId());
		LOG.debug("Response: " + result.getSystemHour());
		return result;
	}

	/**
	 * Calculate hour not user.
	 * 
	 * @param hourRequestTo
	 *            the hour request to
	 * @return the hour response to
	 */
	@RequestMapping(value = "/calculateHourNotUser", method = RequestMethod.POST)
	public @ResponseBody
	HourResponseTo calculateHourNotUser(@RequestBody HourRequestTo hourRequestTo) {
		HourResponseTo result = new HourResponseTo();
		TimeZone timeZone = TimeZone.getTimeZone(hourRequestTo.getGmt());
		Date fecha = new Date();

		DATE_FORMAT.setTimeZone(timeZone);
		result.setSystemHour(DATE_FORMAT.format(fecha));

		LOG.debug("Request GMT: " + hourRequestTo.getGmt());
		LOG.debug("Request User Id: " + hourRequestTo.getUserId());
		LOG.debug("Response: " + result.getSystemHour());
		return result;
	}
}
