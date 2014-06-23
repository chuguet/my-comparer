/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.consumer;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.email.exception.EmailException;

/**
 * The Class SureBetEmailConsumerQueueTest.
 */
public class FirstSureBetEmailConsumerQueueTest extends AbstractConsumerTest {
	
	@Inject
	private FirstSureBetEmailConsumerQueue firstSureBetEmailConsumerQueue;

	@Override
	protected IEmailConsumerQueue getConsumer() {
		return firstSureBetEmailConsumerQueue;
	}
	
	@Test
	public final void receiveTest() throws EmailException {
		assertNotNull(getConsumer());
		getConsumer().receive();
	}
	



}
