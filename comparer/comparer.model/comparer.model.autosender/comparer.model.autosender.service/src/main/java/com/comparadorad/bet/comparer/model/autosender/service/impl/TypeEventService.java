package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.TypeEvent;
import com.comparadorad.bet.comparer.model.autosender.repository.ITypeEventDao;
import com.comparadorad.bet.comparer.model.autosender.service.ITypeEventService;

@Service
class TypeEventService implements ITypeEventService {

	@Inject
	private ITypeEventDao typeEventDao;
	
	@Override
	public Integer save(TypeEvent t) {
		return typeEventDao.save(t);
	}

	@Override
	public void update(TypeEvent t) {
		typeEventDao.update(t);
	}

	@Override
	public void delete(TypeEvent t) {
		typeEventDao.delete(t);
	}

	@Override
	public TypeEvent findOne(Integer pId) {
		return typeEventDao.findOne(pId);
	}

	@Override
	public List<TypeEvent> findAll() {
		return typeEventDao.findAll();
	}


}
