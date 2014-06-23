/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;

/**
 * The Class ProducerQueue.
 *
 * @param <T> the generic type
 */
@Service
public class ValuebetQueueProducer<T extends  ValueBetQueue> extends AbstractQueueProduce<T> {
	
	/** The template. */
	@Inject
	@Resource(name="valuebetTemplate")
	private AmqpTemplate template;

	/** {@inheritDoc} */ 
	@Override
	protected AmqpTemplate getTemplate() {
		return template;
	}


}
