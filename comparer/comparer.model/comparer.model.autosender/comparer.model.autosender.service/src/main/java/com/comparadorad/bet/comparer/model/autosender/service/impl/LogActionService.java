package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.repository.ILogActionDao;
import com.comparadorad.bet.comparer.model.autosender.service.ILogActionService;

@Service
class LogActionService implements ILogActionService {

	@Inject
	private ILogActionDao logActionDao;

	@Override
	public Integer save(LogAction t) {
		return logActionDao.save(t);
	}

	@Override
	public void update(LogAction t) {
		logActionDao.update(t);
	}

	@Override
	public void delete(LogAction t) {
		logActionDao.delete(t);
	}

	@Override
	public LogAction findOne(Integer pId) {
		return logActionDao.findOne(pId);
	}

	@Override
	public List<LogAction> findAll() {
		return logActionDao.findAll();
	}

}
