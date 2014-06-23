package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.repository.IActionTypeDao;
import com.comparadorad.bet.comparer.model.autosender.service.IActionTypeService;

@Service
class ActionTypeService implements IActionTypeService {

	@Inject
	private IActionTypeDao actionTypeDao;

	@Override
	public Integer save(ActionType t) {
		return actionTypeDao.save(t);
	}

	@Override
	public void update(ActionType t) {
		actionTypeDao.update(t);
	}

	@Override
	public void delete(ActionType t) {
		actionTypeDao.delete(t);
	}

	@Override
	public ActionType findOne(Integer pId) {
		return actionTypeDao.findOne(pId);
	}

	@Override
	public List<ActionType> findAll() {
		return actionTypeDao.findAll();
	}

}
