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

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;

/**
 * The Class FirstSurebetQueueProducer.
 *
 * @param <T> the generic type
 */
@Service
public class FirstSurebetQueueProducer<T extends SureBetQueue> extends
		AbstractQueueProduce<T> implements ISureBetQueueProducer<T> {

	/** The template. */
	@Inject
	@Resource(name = "firstSurebetTemplate")
	private AmqpTemplate template;

	/** {@inheritDoc} */ 
	@Override
	protected AmqpTemplate getTemplate() {
		return template;
	}

}
