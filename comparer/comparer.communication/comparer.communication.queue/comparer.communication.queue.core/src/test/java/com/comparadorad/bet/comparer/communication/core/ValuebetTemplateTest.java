package com.comparadorad.bet.comparer.communication.core;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;

public class ValuebetTemplateTest extends AbstractQueueTest {
	
	@Resource(name="valuebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getAmqpTemplate() {
		return template;
	}

}
