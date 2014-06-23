package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePaymentName;
import com.comparadorad.bet.comparer.model.autosender.bean.UserCreacion;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserPaymentDao;
import com.comparadorad.bet.comparer.model.autosender.service.IUserPaymentService;

@Service
class UserPaymentService implements IUserPaymentService {

	@Inject
	private IUserPaymentDao userPaymentDao;

	@Override
	public Integer save(UserPayment t) {
		return userPaymentDao.save(t);
	}

	@Override
	public void update(UserPayment t) {
		userPaymentDao.update(t);
	}

	@Override
	public void delete(UserPayment t) {
		userPaymentDao.delete(t);
	}

	@Override
	public UserPayment findOne(Integer pId) {
		return userPaymentDao.findOne(pId);
	}

	@Override
	public List<UserPayment> findAll() {
		return userPaymentDao.findAll();
	}

	
	public void makePayment(Integer userId, TypePaymentName typePaymentName,
			UserCreacion creacion) {
		// TODO Auto-generated method stub
		
	}

	
	public void makePaymentByLiferayUser(Integer userId,
			TypePaymentName typePaymentName, UserCreacion creacion) {
		// TODO Auto-generated method stub
		
	}

}
