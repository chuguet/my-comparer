/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.AbstractTest;

/**
 * The Class MonthlyTaskValueBetTest.
 */
public class MonthlyTaskValueBetTest extends AbstractTest {

	/** The monthly task value bet. */
	@Inject
	private MonthlyTaskValueBet monthlyTaskValueBet;

	/**
	 * Test.
	 */
	@Test
	public final void test() {
		/*
		 * TODO intento de conectar con RabbitMQ real. bugzilla 2939 
		 */
		assertNotNull(monthlyTaskValueBet);
		assertEquals((Integer) monthlyTaskValueBet.getNumDays(), new Integer(
				Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)));
		monthlyTaskValueBet.process();
		assertNotNull(monthlyTaskValueBet.getValueBetQueue());
	}

}
