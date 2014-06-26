/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement.ActivationPeriod;

/**
 * The Class CoreActiveElementTest.
 */
public class CoreActiveElementTest {

	/**
	 * Test add activation period.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testAddActivationPeriod() throws ParseException {
		Date matchDate = getDate("2012-05-29 20:45:00");
		// //////////////////////////////////////////////////////////
		CoreActiveElement coreActiveElement = new CoreActiveElement();
		assertTrue(coreActiveElement.isActive(matchDate));
		// //////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement(false);
		assertFalse(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.setActive(true);
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:44:00"),
				getDate("2012-05-29 20:46:00"));
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:45:00"),
				getDate("2012-05-29 20:46:00"));
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:45:01"),
				getDate("2012-05-29 20:46:00"));
		assertFalse(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:44:01"),
				getDate("2012-05-29 20:44:59"));
		assertFalse(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:44:01"),
				getDate("2012-05-29 20:44:59"));
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:44:01"),
				null);
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(getDate("2012-05-29 20:45:01"),
				getDate("2012-05-29 20:48:59"));
		coreActiveElement.addActivationPeriod(null,
				getDate("2012-05-29 20:46:01"));
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(null, null);
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		coreActiveElement.addActivationPeriod(new ActivationPeriod());
		assertTrue(coreActiveElement.isActive(matchDate));
		// ///////////////////////////////////////////////////////////
		coreActiveElement = new CoreActiveElement();
		ActivationPeriod activationPeriod = new ActivationPeriod();
		coreActiveElement.addActivationPeriod(activationPeriod);
		assertTrue(coreActiveElement.isActive(matchDate));
		activationPeriod.setInitDate(getDate("2012-05-29 20:44:01"));
		assertTrue(coreActiveElement.isActive(matchDate));
		activationPeriod.setEndDate(getDate("2012-05-29 20:44:05"));
		assertFalse(coreActiveElement.isActive(matchDate));
	}

	/**
	 * Gets the date.
	 * 
	 * @param dateStr
	 *            the date str
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	private Date getDate(String dateStr) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date date = dateFormat.parse(dateStr);
		return dateFormat.parse(dateStr);
	}

}
