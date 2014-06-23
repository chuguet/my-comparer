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

import com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO;

/**
 * The Class UpdaterBetsQueueProducer.
 * 
 * @param <T>
 *            the generic type
 */
@Service
class UpdaterBetsQueueProducer<T extends UpdaterBetsTO> extends
		AbstractQueueProduce<T> implements IUpdaterBetsQueueProducer<T> {

	/** The template. */
	@Resource(name = "updaterBetsTemplate")
	private AmqpTemplate template;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.communication.producer.AbstractQueueProduce
	 * #getTemplate()
	 */
	@Override
	protected AmqpTemplate getTemplate() {
		return template;
	}

}
