package com.comparadorad.bet.comparer.communication.producer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;

@Service
public class FourthSurebetQueueProducer<T extends SureBetQueue> extends
AbstractQueueProduce<T> implements ISureBetQueueProducer<T> {
	
	@Resource(name="fourthSurebetTemplate")
	private AmqpTemplate template;

	@Override
	protected AmqpTemplate getTemplate() {
		return template;
	}

}
