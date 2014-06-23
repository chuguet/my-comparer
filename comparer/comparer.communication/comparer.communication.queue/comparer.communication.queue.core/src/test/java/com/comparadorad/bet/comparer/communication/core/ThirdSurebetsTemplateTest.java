package com.comparadorad.bet.comparer.communication.core;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;

public class ThirdSurebetsTemplateTest  extends AbstractQueueTest {
	
	@Resource(name="thirdSurebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getAmqpTemplate() {
		return template;
	}

}
