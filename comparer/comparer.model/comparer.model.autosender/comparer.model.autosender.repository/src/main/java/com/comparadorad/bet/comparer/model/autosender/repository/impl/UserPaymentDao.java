package com.comparadorad.bet.comparer.model.autosender.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserPaymentDao;

@Repository
class UserPaymentDao implements IUserPaymentDao {
	
	@Inject
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer save(UserPayment t) {
		return (Integer)hibernateTemplate.save(t);
	}

	@Override
	public void update(UserPayment t) {
		hibernateTemplate.update(t);
	}

	@Override
	public void delete(UserPayment t) {
		hibernateTemplate.delete(t);
	}

	@Override
	public UserPayment findOne(Integer pId) {
		return hibernateTemplate.get(UserPayment.class, pId);
	}

	@Override
	public List<UserPayment> findAll() {
		return hibernateTemplate.loadAll(UserPayment.class);
	}

}
