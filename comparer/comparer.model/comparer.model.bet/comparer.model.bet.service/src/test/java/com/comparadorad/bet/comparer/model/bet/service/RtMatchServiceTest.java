/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class RtMatchServiceTest.
 */
public class RtMatchServiceTest extends AbstractServiceTest<RtMatch> {

	/** The rt match service. */
	@Inject
	private IRtMatchService rtMatchService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<RtMatch> getIGenericService() {
		return rtMatchService;
	}

	/**
	 * Test get upcoming events.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	// @Test
	// public final void testGetUpcomingEvents() throws ParseException {
	// CoreDate userCoreDate = new CoreDate();
	// String userDate = "3/8/2010 9:35:40";
	// SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	// Date uDate = dt.parse(userDate);
	// userCoreDate.setZeroGmtMatchDate(uDate);
	// String limitDate = "3/8/2014 9:35:41";
	// Date dlimit = dt.parse(limitDate);
	//
	// List<RtMatch> matchs = rtMatchService.getUpcomingEvents(uDate, 20000000,
	// 1);
	//
	// LOG.info("-------------------------");
	// for (RtMatch rtMatch : matchs) {
	// LOG.info(rtMatch.getMatchId().getStartDate().getZeroGmtMatchDate());
	// }
	// LOG.info("-------------------------");
	//
	// LOG.info("userDate--> " + dt.format(uDate));
	// LOG.info("limitDate--> " + dt.format(dlimit));
	// LOG.info("MATCHS FOUND: " + matchs.size());
	// assertNotNull(matchs.get(0));
	// }
	
	/**
	 * Gets the future events.
	 * 
	 * @return the future events
	 */
	@Test
	public final void getFutureEvents() {
		GregorianCalendar dateEvent = new GregorianCalendar(2012, 11, 31);
		Calendar today = new GregorianCalendar();
		int result = dateEvent.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR);
		List<RtMatch> matchs = rtMatchService.getFutureEvents(result);
		assertNotNull(matchs);
		// assertEquals(matchs.size(), 1);
	}

	/**
	 * Gets the matchs by hash keys test.
	 * 
	 * @return the matchs by hash keys test
	 */
	public final void getMatchsByHashKeysTest() {
		List<RtMatch> rtMatchs = rtMatchService.getMatchsByHashKeys("1haskey");
		assertNotNull(rtMatchs);
		assertEquals(rtMatchs.get(0).contains("1haskey"), true);
	}
	
	/**
	 * Test que prueba el servicio que accede a BD y recupera el primer partido
	 * activo.
	 * 
	 * @return the active matches
	 */
	@Test
	public void getActiveMatches() {
		RtMatch result = rtMatchService.findActiveMatch("1", "1");
		assertTrue(result != null);
		assertTrue(result.isActive(new Date()));
	}

}
