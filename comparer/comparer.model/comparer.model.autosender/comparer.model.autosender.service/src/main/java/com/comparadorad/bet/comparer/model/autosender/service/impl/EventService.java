package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.Event;
import com.comparadorad.bet.comparer.model.autosender.repository.IEventDao;
import com.comparadorad.bet.comparer.model.autosender.service.IEventService;

@Service
class EventService implements IEventService {

	@Inject
	private IEventDao eventDao;

	@Override
	public Integer save(Event t) {
		return eventDao.save(t);
	}

	@Override
	public void update(Event t) {
		eventDao.update(t);
	}

	@Override
	public void delete(Event t) {
		eventDao.delete(t);
	}

	@Override
	public Event findOne(Integer pId) {
		return eventDao.findOne(pId);
	}

	@Override
	public List<Event> findAll() {
		return eventDao.findAll();
	}

}
