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

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.AbstractTest;

/**
 * The Class WeeklyTaskValueBetTest.
 */
public class WeeklyTaskValueBetTest extends AbstractTest {
	
	/** The weekly task value bet. */
	@Inject
	private WeeklyTaskValueBet weeklyTaskValueBet;
	
	/**
	 * Test.
	 */
	@Test
	public final void test(){
		/*
		 * TODO intento de conectar con RabbitMQ real. bugzilla 2939 
		 */
		assertNotNull(weeklyTaskValueBet);
		assertEquals( (Integer) weeklyTaskValueBet.getNumDays(), new Integer("7"));
		weeklyTaskValueBet.process();
		assertNotNull(weeklyTaskValueBet.getValueBetQueue());
	}

}
