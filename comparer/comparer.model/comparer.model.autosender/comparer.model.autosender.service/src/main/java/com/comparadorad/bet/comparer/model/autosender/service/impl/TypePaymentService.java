package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.repository.ITypePaymentDao;
import com.comparadorad.bet.comparer.model.autosender.service.ITypePaymentService;

@Service
class TypePaymentService implements ITypePaymentService {

	@Inject
	private ITypePaymentDao typePaymentDao;

	@Override
	public Integer save(TypePayment t) {
		return typePaymentDao.save(t);
	}

	@Override
	public void update(TypePayment t) {
		typePaymentDao.update(t);
	}

	@Override
	public void delete(TypePayment t) {
		typePaymentDao.delete(t);
	}

	@Override
	public TypePayment findOne(Integer pId) {
		return typePaymentDao.findOne(pId);
	}

	@Override
	public List<TypePayment> findAll() {
		return typePaymentDao.findAll();
	}

}
