/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;

/**
 * The Interface IQueueConfig.
 */
public interface IQueueConfig {
	
	/**
	 * Rabbit template.
	 *
	 * @param connectionFactory the connection factory
	 * @return the rabbit template
	 */
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory );
	
	/**
	 * Queue.
	 *
	 * @return the queue
	 */
	Queue queue();

}
