package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.MessageQueue;
import com.comparadorad.bet.comparer.model.autosender.service.IMessageQueueService;

public class MessageQueueServiceTest extends
		AbstractServiceTest<MessageQueue, IMessageQueueService> {

	@Inject
	private IMessageQueueService messageQueueService;

	@Override
	public IMessageQueueService getService() {
		return messageQueueService;
	}

	@Override
	public MessageQueue getObject() {
		return new MessageQueue();
	}

}