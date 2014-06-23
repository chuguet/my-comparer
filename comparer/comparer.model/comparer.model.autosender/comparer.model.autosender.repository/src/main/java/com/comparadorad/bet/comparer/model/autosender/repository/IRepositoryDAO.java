/**
 *
 * Copyright (C) Factoría ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.repository;

import java.io.Serializable;
import java.util.List;

import com.comparadorad.bet.comparer.model.autosender.bean.IAutoSender;

/**
 * The Interface IRepositoryDAO.
 * 
 * @param <T>
 *            the generic type
 */
public interface IRepositoryDAO<T extends IAutoSender, I extends Serializable> {

	/**
	 * Save.
	 * 
	 * @param t
	 *            the t
	 */
	I save(T t);

	/**
	 * Update.
	 * 
	 * @param t
	 *            the t
	 */
	void update(T t);

	/**
	 * Delete.
	 * 
	 * @param t
	 *            the t
	 */
	void delete(T t);

	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the t
	 */
	T findOne(I pId);

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	List<T> findAll();

}