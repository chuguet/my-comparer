/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class SynchroErrorEventTest.
 */
public class SynchroErrorEventTest extends AbstractTest {

	/** The synchro error event. */
	@Inject
	private SynchroErrorEvent synchroErrorEvent;

	/** The sport. */
	private XmlSport sport;

	/** The bookmaker. */
	private CfgBookmaker bookmaker;

	/**
	 * Inits the.
	 */
	private void init() {
		sport = new XmlSport("Futbol");
		bookmaker = setBookmaker();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	@Test
	public void test() {
		init();
		synchroErrorEvent.errorLog("Mensaje de error", sport, bookmaker,
				new Date());

	}

	/**
	 * Test1.
	 */
	@Test
	public void test1() {
		init();
		synchroErrorEvent.errorLog("mensaje de erorr", sport, bookmaker,
				new Date());

	}

	/**
	 * Test2.
	 */
	@Test
	public void test2() {
		init();
		synchroErrorEvent.errorLog("mensaje de erorr", new Throwable("error"),
				sport, bookmaker, new Date());
	}

	/**
	 * Test3.
	 */
	@Test
	public void test3() {
		init();
		synchroErrorEvent.errorMasterWordsLog("Error generador nombres",
				new Throwable("Error"), sport, bookmaker, new Date());
	}

}
