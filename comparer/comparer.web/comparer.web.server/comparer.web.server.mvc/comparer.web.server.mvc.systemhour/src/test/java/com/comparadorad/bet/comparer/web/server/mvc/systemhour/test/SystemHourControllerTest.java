/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.systemhour.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.server.mvc.systemhour.beans.HourRequestTo;
import com.comparadorad.bet.comparer.web.server.mvc.systemhour.beans.HourResponseTo;
import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;

/**
 * The Class EventOddsControllerTest.
 */
public class SystemHourControllerTest extends AbstractTest {

	@Before
	public void init() throws PortalException, SystemException {
		BeanLocator mockBeanLocator = mock(BeanLocator.class);
		PortalBeanLocatorUtil.setBeanLocator(mockBeanLocator);
		UserLocalService mockUserLocalService = mock(UserLocalService.class);
		User user = mock(User.class);
		when(user.getUserId()).thenReturn(new Long(1));
		when(mockUserLocalService.getUser(1)).thenReturn(user);
		when(
				mockBeanLocator
						.locate("com.liferay.portal.service.UserLocalService"))
				.thenReturn(mockUserLocalService);
	}

	@Test
	public void getSystemHourUserTest() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		HourRequestTo hourRequestTo = new HourRequestTo();
		hourRequestTo.setGmt(TimeZone.getDefault().getID());
		hourRequestTo.setUserId("1");
		DefaultRequestBuilder requestBuilder = postJson(
				"/systemHour/calculateHourUser", hourRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		HourResponseTo hourResponseTo = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), HourResponseTo.class);

		assertTrue(hourResponseTo.getSystemHour().equals(
				dateFormat.format(new Date())));

	}
	
	@Test
	public void getSystemHourNotUserTest() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		HourRequestTo hourRequestTo = new HourRequestTo();
		hourRequestTo.setGmt(TimeZone.getDefault().getID());
		hourRequestTo.setUserId("1");
		DefaultRequestBuilder requestBuilder = postJson(
				"/systemHour/calculateHourNotUser", hourRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		HourResponseTo hourResponseTo = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), HourResponseTo.class);

		assertTrue(hourResponseTo.getSystemHour().equals(
				dateFormat.format(new Date())));

	}

}
