/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;

/**
 * The Class ProducerQueueTest.
 */
public class ValuebetQueueProducerTest extends AbstractTest {
	
	/** The producer queue. */
	@Inject
	private ValuebetQueueProducer<ValueBetQueue> producerQueue;
	
	/**
	 * Send test.
	 */
	@Test
	public final void sendTest(){
		/*
		 * TODO intento de conectar con RabbitMQ real. bugzilla 2939 
		 */
		List<ValueBetData> beandata = new ArrayList<ValueBetData>();
		ValueBetData betData = new ValueBetData();
		ValueBetProbability probability = new ValueBetProbability();
		probability.setValue(1.5d);
		betData.setProbability(probability);
		beandata.add(betData);
		producerQueue.send(new ValueBetQueue(beandata));
	}

}
