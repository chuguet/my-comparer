/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service;

import java.io.Serializable;
import java.util.List;

import com.comparadorad.bet.comparer.model.autosender.bean.IAutoSender;

/**
 * The Interface IModelService.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public interface IModelService<T extends IAutoSender, I extends Serializable> {

	/**
	 * Save.
	 * 
	 * @param t
	 *            the t
	 * @return the i
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
