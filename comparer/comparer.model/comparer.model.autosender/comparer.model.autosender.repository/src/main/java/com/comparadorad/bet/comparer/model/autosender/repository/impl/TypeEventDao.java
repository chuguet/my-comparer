package com.comparadorad.bet.comparer.model.autosender.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.comparadorad.bet.comparer.model.autosender.bean.TypeEvent;
import com.comparadorad.bet.comparer.model.autosender.repository.ITypeEventDao;

@Repository
class TypeEventDao implements ITypeEventDao {

	@Inject
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer save(TypeEvent t) {
		return (Integer)hibernateTemplate.save(t);
	}

	@Override
	public void update(TypeEvent t) {
		hibernateTemplate.update(t);
	}

	@Override
	public void delete(TypeEvent t) {
		hibernateTemplate.delete(t);
	}

	@Override
	public TypeEvent findOne(Integer pId) {
		return hibernateTemplate.get(TypeEvent.class, pId);
	}

	@Override
	public List<TypeEvent> findAll() {
		return hibernateTemplate.loadAll(TypeEvent.class);
	}

}
