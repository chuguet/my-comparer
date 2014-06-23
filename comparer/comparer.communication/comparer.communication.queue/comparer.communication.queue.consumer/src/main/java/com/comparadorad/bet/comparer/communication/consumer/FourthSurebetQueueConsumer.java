package com.comparadorad.bet.comparer.communication.consumer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;

@Service
public class FourthSurebetQueueConsumer<T extends SureBetQueue> extends AbstractConsumerQueue<T> {
	
	@Resource(name="fourthSurebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getTemplate() {
		return template;
	}

}
