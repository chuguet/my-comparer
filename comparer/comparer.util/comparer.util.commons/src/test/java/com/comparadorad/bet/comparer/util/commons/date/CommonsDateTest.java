/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

/**
 * The Class CommonsDateTest.
 */
public class CommonsDateTest {

	/**
	 * Gets the date for time zone test.
	 * 
	 * @return the date for time zone test
	 */
	@Test
	public void getDateForTimeZoneTest() {
		CommonsDate commons = new CommonsDate();
		TimeZone timeZone1 = TimeZone.getTimeZone("GMT-9");
		TimeZone timeZone2 = TimeZone.getTimeZone("GMT+8");

		Date dateTimeZone1 = commons.getDateForTimeZone(timeZone1);

		Date dateTimeZone2 = new Date();
		DateFormat dateFormat = new SimpleDateFormat();
		String dateTimeZone2Str = dateFormat.format(dateTimeZone2);
		dateFormat.setTimeZone(timeZone2);
		try {
			dateTimeZone2 = dateFormat.parse(dateTimeZone2Str);
		} catch (ParseException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		assertNotNull(dateTimeZone1);
		assertNotNull(dateTimeZone2);

		// Ahora debería haber una diferencia de minimo 17 horas (incl) y maximo
		// 18 horas (excl) entre las dos fechas (poniendolo entre 17 y 18 horas
		// evita problemas con diferencias de milisegundos al crear las dos
		// fechas, pej se podría dar el caso de que fecha1 se crea a 14.59.59 y
		// fecha2 a
		// 15.00.00).
		Long time1 = dateTimeZone1.getTime();
		Long time2 = dateTimeZone2.getTime();
		assertTrue(time1 - time2 >= 17 * 1000 * 60 * 60);
		assertTrue(time1 - time2 < 18 * 1000 * 60 * 60);

	}

	/**
	 * Gets the date time str for time zone.
	 * 
	 * @return the date time str for time zone
	 */
	@Test
	public void getDateTimeStrForTimeZone() {
		TimeZone timeZone = TimeZone.getTimeZone("GMT+3");

		CommonsDate commons = new CommonsDate();
		String date = commons.getDateTimeStrForTimeZone(timeZone);

		assertNotNull(date);
	}

	/**
	 * Gets the match date expressed in gm t0 test.
	 * 
	 * @return the match date expressed in gm t0 test
	 */
	@Test
	public void getMatchDateExpressedInGMT0Test() {

		Date date = new Date();
		CommonsDate commons = new CommonsDate(date, "GMT+5", date);
		Date dateGMT0 = commons.getMatchDateExpressedInGMT0();
		int offset = TimeZone.getDefault().getOffset(
				Calendar.getInstance().getTimeInMillis());

		assertEquals(date.getTime(), dateGMT0.getTime() + offset);
		
		Calendar dateAtBookmakerTimeZone = Calendar.getInstance(TimeZone.getTimeZone(
				"GMT+5"));
		DateFormat dateFormat = new SimpleDateFormat();
		String fecha1 = dateFormat.format(dateAtBookmakerTimeZone.getTimeInMillis());
//		dateAtBookmakerTimeZone.setTimeZone(TimeZone.getTimeZone(
//				"GMT+5"));
//		String fecha2 = dateFormat.format(dateAtBookmakerTimeZone.getTimeInMillis());
		dateAtBookmakerTimeZone.getTime();

	}

	/**
	 * Gets the provider date expressed in gm t0 test.
	 * 
	 * @return the provider date expressed in gm t0 test
	 */
	@Test
	public void getProviderDateExpressedInGMT0Test() {

		Date date = new Date();
		CommonsDate commons = new CommonsDate(date, "GMT+5", date);
		Date dateGMT0 = commons.getProviderDateExpressedInGMT0();
		int offset = TimeZone.getDefault().getOffset(
				Calendar.getInstance().getTimeInMillis());

		assertEquals(date.getTime(), dateGMT0.getTime() + offset);

	}

	/**
	 * Gets the zero gmt match time zone str.
	 * 
	 * @return the zero gmt match time zone str
	 */
	@Test
	public void getZeroGmtMatchTimeZoneStr() {
		CommonsDate commons = new CommonsDate();
		String result = commons.getZeroGmtMatchTimeZoneStr();

		assertNotNull(result);
		assertEquals(result, "GMT+0");
	}
}
