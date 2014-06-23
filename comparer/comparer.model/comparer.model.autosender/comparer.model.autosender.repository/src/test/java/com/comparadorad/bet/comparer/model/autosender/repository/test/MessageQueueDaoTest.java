package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.MessageQueue;
import com.comparadorad.bet.comparer.model.autosender.repository.IMessageQueueDao;

public class MessageQueueDaoTest extends
		AbstractDaoTest<MessageQueue, IMessageQueueDao> {

	@Inject
	private IMessageQueueDao messageQueueDao;

	@Override
	public MessageQueue getObject() {
		return new MessageQueue();
	}

	@Override
	public IMessageQueueDao getDao() {
		return messageQueueDao;
	}

}
