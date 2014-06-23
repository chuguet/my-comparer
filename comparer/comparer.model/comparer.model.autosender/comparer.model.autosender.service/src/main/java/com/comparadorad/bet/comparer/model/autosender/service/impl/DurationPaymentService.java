package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.repository.IDurationPaymentDao;
import com.comparadorad.bet.comparer.model.autosender.service.IDurationPaymentService;

@Service
class DurationPaymentService implements IDurationPaymentService {

	@Inject
	private IDurationPaymentDao durationPaymentDao;

	@Override
	public Integer save(DurationPayment t) {
		return durationPaymentDao.save(t);
	}

	@Override
	public void update(DurationPayment t) {
		durationPaymentDao.update(t);
	}

	@Override
	public void delete(DurationPayment t) {
		durationPaymentDao.delete(t);
	}

	@Override
	public DurationPayment findOne(Integer pId) {
		return durationPaymentDao.findOne(pId);
	}

	@Override
	public List<DurationPayment> findAll() {
		return durationPaymentDao.findAll();
	}

}
