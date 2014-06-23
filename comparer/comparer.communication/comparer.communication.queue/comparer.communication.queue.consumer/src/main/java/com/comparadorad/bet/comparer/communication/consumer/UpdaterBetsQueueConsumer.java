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

import com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO;

/**
 * The Class UpdaterBetsQueueConsumer.
 * 
 * @param <T>
 *            the generic type
 */
@Service
public class UpdaterBetsQueueConsumer<T extends UpdaterBetsTO> extends
		AbstractConsumerQueue<T> {

	/** The template. */
	@Resource(name = "updaterBetsTemplate")
	private AmqpTemplate template;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.communication.consumer.AbstractConsumerQueue
	 * #getTemplate()
	 */
	@Override
	public AmqpTemplate getTemplate() {
		return template;
	}
}
