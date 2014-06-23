package com.comparadorad.bet.comparer.communication.core;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;

public class FourthSurebetsTemplateTest extends AbstractQueueTest {
	
	@Resource(name="fourthSurebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getAmqpTemplate() {
		return template;
	}

}
