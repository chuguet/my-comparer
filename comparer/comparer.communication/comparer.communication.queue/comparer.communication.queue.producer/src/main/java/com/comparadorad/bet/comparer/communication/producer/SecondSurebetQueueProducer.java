/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;

/**
 * The Class SecondSurebetQueueProducer.
 *
 * @param <T> the generic type
 */
@Service
public class SecondSurebetQueueProducer<T extends SureBetQueue> extends
		AbstractQueueProduce<T> implements ISureBetQueueProducer<T> {
	
	/** The template. */
	@Resource(name="secondSurebetTemplate")
	private AmqpTemplate template;

	/** {@inheritDoc} */ 
	@Override
	protected AmqpTemplate getTemplate() {
		return template;
	}

}
