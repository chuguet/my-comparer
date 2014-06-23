package com.comparadorad.bet.comparer.communication.task;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.AbstractTest;

public class DailyTaskValueBetTest extends AbstractTest {
	
	@Inject
	private DailyTaskValueBet taskValueBet;
	
	@Test
	public final void test(){
		/*
		 * TODO intento de conectar con RabbitMQ real. bugzilla 2939 
		 */
		assertNotNull(taskValueBet);
		assertEquals( (Integer) taskValueBet.getNumDays(), new Integer("1"));
		taskValueBet.process();
		assertNotNull(taskValueBet.getValueBetQueue());
	}

}
