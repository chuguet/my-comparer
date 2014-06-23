/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.consumer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.email.AbstractTest;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;

/**
 * The Class AbstractConsumerTest.
 */
public abstract class AbstractConsumerTest extends AbstractTest {

	/**
	 * Gets the consumer.
	 *
	 * @return the consumer
	 */
	protected abstract IEmailConsumerQueue getConsumer();

	/**
	 * Receive test.
	 *
	 * @throws EmailException the email exception
	 */
	@Test
	public void receiveTest() throws EmailException {
		assertNotNull(getConsumer());
		getConsumer().receive();
	}

}
