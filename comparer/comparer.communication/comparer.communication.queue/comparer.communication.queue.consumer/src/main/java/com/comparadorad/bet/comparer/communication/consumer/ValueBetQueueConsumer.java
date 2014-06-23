/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;

/**
 * The Class ConsumerQueue.
 */
@Service
public class ValueBetQueueConsumer<T extends ValueBetQueue> extends AbstractConsumerQueue<T> {

	@Resource(name="valuebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getTemplate() {
		return template;
	}

	
}
