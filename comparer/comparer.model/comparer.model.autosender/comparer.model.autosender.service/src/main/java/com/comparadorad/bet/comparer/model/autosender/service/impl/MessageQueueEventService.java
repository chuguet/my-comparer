package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.MessageQueue;
import com.comparadorad.bet.comparer.model.autosender.repository.IMessageQueueDao;
import com.comparadorad.bet.comparer.model.autosender.service.IMessageQueueService;

@Service
class MessageQueueEventService implements IMessageQueueService {

	@Inject
	private IMessageQueueDao messageQueueDao;

	@Override
	public Integer save(MessageQueue t) {
		return messageQueueDao.save(t);
	}

	@Override
	public void update(MessageQueue t) {
		messageQueueDao.update(t);
	}

	@Override
	public void delete(MessageQueue t) {
		messageQueueDao.delete(t);
	}

	@Override
	public MessageQueue findOne(Integer pId) {
		return messageQueueDao.findOne(pId);
	}

	@Override
	public List<MessageQueue> findAll() {
		return messageQueueDao.findAll();
	}

}
