/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Class SecondSurebetQueueProducerTest.
 */
public class SecondSurebetQueueProducerTest extends AbstractTest {
	
	/** The queue surebet. */
	@Inject
	private SecondSurebetQueueProducer<SureBetQueue> queueSurebet;
	
	/**
	 * Send test.
	 */
	@Test
	public final void sendTest(){
		queueSurebet.send(new SureBetQueue(new SecureBeanData(), new Date()));
	}

}
