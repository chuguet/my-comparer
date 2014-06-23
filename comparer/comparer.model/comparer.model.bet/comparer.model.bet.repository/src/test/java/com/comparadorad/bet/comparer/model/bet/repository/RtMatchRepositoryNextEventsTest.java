/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import java.text.ParseException;
import java.util.HashMap;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.data.repository.CrudRepository;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class RtMatchRepositoryTest.
 */
public class RtMatchRepositoryNextEventsTest extends
		AbstractBetRepositoryTest<RtMatchRepository> {

	/** The rt match repository. */
	@Inject
	private RtMatchRepository rtMatchRepository;

	/**
	 * Test get upcoming events hour. Nos devuelve un proximo evento modificando
	 * solo la hora del mismo.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testGetUpcomingEventsHour() throws ParseException {
		// CoreDate userCoreDate = new CoreDate();
		// String userDate = "15/12/2013 7:35:40";
		// SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		// dt.setTimeZone(TimeZone.getTimeZone("GMT_0"));
		// Date uDate = dt.parse(userDate);
		// userCoreDate.setZeroGmtMatchDate(uDate);
		// String limitDate = "15/12/2050 7:35:41";
		// Date dlimit = dt.parse(limitDate);
		//
		// List<RtMatch> matchs = rtMatchRepository.getUpcomingEvents(
		// userCoreDate.getZeroGmtMatchDate(), dlimit,3);
		//
		// assertTrue(matchs.size() == 1);

	}

	/**
	 * Test get upcoming events zero. No devuelve ningun proximo evento
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testGetUpcomingEventsZero() throws ParseException {
		// CoreDate userCoreDate = new CoreDate();
		// String userDate = "3/11/2012 9:35:40";
		// SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		// dt.setTimeZone(TimeZone.getTimeZone("GMT_0"));
		// Date uDate = dt.parse(userDate);
		// userCoreDate.setZeroGmtMatchDate(uDate);
		// String limitDate = "4/11/2012 9:35:41";
		// Date dlimit = dt.parse(limitDate);
		//
		// List<RtMatch> matchs = rtMatchRepository.getUpcomingEvents(
		// userCoreDate.getZeroGmtMatchDate(), dlimit, 1);
		//
		// assertTrue(matchs.size() == 0);

	}

	/**
	 * Test get upcoming events only10. Para mas de 10 resultados en el fichero
	 * de carga de datos de prueba solo nos devuelve 10 como debe ser.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testGetUpcomingEventsOnly6() throws ParseException {
		// CoreDate userCoreDate = new CoreDate();
		// String userDate = "3/11/2012 9:35:40";
		// SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		// dt.setTimeZone(TimeZone.getTimeZone("GMT_0"));
		// Date uDate = dt.parse(userDate);
		// userCoreDate.setZeroGmtMatchDate(uDate);
		// String limitDate = "4/11/2016 9:35:41";
		// Date dlimit = dt.parse(limitDate);
		//
		// List<RtMatch> matchs = rtMatchRepository.getUpcomingEvents(
		// userCoreDate.getZeroGmtMatchDate(), dlimit);
		//
		// assertTrue(matchs.size() == 6);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#getRepository
	 * ()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		result.put(RtMatch.class, rtMatchRepository);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#
	 * getLoaderClass()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getLoaderClass() {
		return BetRepositoryConfig.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#
	 * getAditionalNameForLoad()
	 */
	@Override
	public String getAditionalNameForLoad() {
		return "_nextEvents";
	}
}
