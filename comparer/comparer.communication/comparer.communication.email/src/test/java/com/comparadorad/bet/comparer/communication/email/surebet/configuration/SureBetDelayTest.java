package com.comparadorad.bet.comparer.communication.email.surebet.configuration;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.email.AbstractTest;

public final class SureBetDelayTest extends AbstractTest {
	
	@Inject
	private SureBetDelay betDelay;
	
	@Test
	public void test(){
		assertNotNull(betDelay);
		betDelay.getDelayTypeOne();
		betDelay.getDelayTypeTwo();
	}

}
