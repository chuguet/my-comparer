package com.comparadorad.bet.comparer.communication.consumer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;

@Service
public class SecondSurebetQueueConsumer<T extends SureBetQueue> extends AbstractConsumerQueue<T> {
	
	@Resource(name="secondSurebetTemplate")
	private AmqpTemplate template;

	@Override
	public AmqpTemplate getTemplate() {
		return template;
	}

}
