/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.core.bean.AbstractQueue;

/**
 * The Class ConsumerQueueTest.
 */
@SuppressWarnings("rawtypes")
public abstract class ConsumerQueueTest<T extends AbstractConsumerQueue, I extends AbstractQueue>
		extends AbstractTest {

	public abstract T getAbstractConsumerQueue();

	/**
	 * Test.
	 */
	@Test
	public final void test() {
		@SuppressWarnings("unchecked")
		I i = (I) getAbstractConsumerQueue().receive();
		assertNotNull(i);
	}

}
