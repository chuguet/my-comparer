package com.comparadorad.bet.comparer.communication.core;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;

public class SecondSurebetTemplateTest extends AbstractQueueTest {
	
	@Resource(name="secondSurebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getAmqpTemplate() {
		return template;
	}

}
