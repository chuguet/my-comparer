/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.service;

import java.math.BigInteger;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;

/**
 * The Class GenericServiceImpl.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractGenericCrudService<T extends IDocument>
		implements IGenericCrudService<T> {

	/**
	 * Gets the dao.
	 * 
	 * @return the dao
	 */
	protected abstract IGenericRepository<T> getCrudRepository();

	/**
	 * Save.
	 * 
	 * @param pEntity
	 *            the entity
	 * @return the t {@inheritDoc}
	 */
	@Override
	public T save(final T pEntity) {
		return getCrudRepository().save((T) pEntity);
	}

	/**
	 * Save.
	 * 
	 * @param pEntities
	 *            the entities
	 * @return the iterable {@inheritDoc}
	 */
	@Override
	public Iterable<T> save(final Iterable<T> pEntities) {
		Iterable<? extends T> t =  (Iterable<? extends T>) getCrudRepository().save((Iterable<? extends T>) pEntities);
		return (Iterable<T>) t;
	}

	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the t {@inheritDoc}
	 */
	@Override
	public T findOne(final BigInteger pId) {
		return getCrudRepository().findOne(pId);
	}

	/**
	 * Exists.
	 * 
	 * @param pId
	 *            the id
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean exists(final BigInteger pId) {
		return getCrudRepository().exists(pId);
	}

	/**
	 * Find all.
	 * 
	 * @return the iterable {@inheritDoc}
	 */
	@Override
	public Iterable<T> findAll() {
		return getCrudRepository().findAll();
	}

	/**
	 * Count.
	 * 
	 * @return the long {@inheritDoc}
	 */
	@Override
	public long count() {
		return getCrudRepository().count();
	}

	/**
	 * Delete.
	 * 
	 * @param pId
	 *            the id {@inheritDoc}
	 */
	@Override
	public void delete(final BigInteger pId) {
		getCrudRepository().delete(pId);
	}

	/**
	 * Delete.
	 * 
	 * @param pEntity
	 *            the entity {@inheritDoc}
	 */
	@Override
	public void delete(final T pEntity) {
		getCrudRepository().delete(pEntity);
	}

	/**
	 * Delete.
	 * 
	 * @param pEntities
	 *            the entities {@inheritDoc}
	 */
	@Override
	public void delete(final Iterable<? extends T> pEntities) {
		getCrudRepository().delete(pEntities);
	}

	/**
	 * Delete all.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() {
		getCrudRepository().deleteAll();
	}

}
