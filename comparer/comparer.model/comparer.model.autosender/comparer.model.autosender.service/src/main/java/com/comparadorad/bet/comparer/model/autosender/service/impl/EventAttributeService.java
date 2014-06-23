package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.EventAttribute;
import com.comparadorad.bet.comparer.model.autosender.repository.IEventAttributeDao;
import com.comparadorad.bet.comparer.model.autosender.service.IEventAttributeService;

@Service
class EventAttributeService implements IEventAttributeService {

	@Inject
	private IEventAttributeDao attributeDao;

	@Override
	public Integer save(EventAttribute t) {
		return attributeDao.save(t);
	}

	@Override
	public void update(EventAttribute t) {
		attributeDao.update(t);
	}

	@Override
	public void delete(EventAttribute t) {
		attributeDao.delete(t);
	}

	@Override
	public EventAttribute findOne(Integer pId) {
		return attributeDao.findOne(pId);
	}

	@Override
	public List<EventAttribute> findAll() {
		return attributeDao.findAll();
	}

}
