/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service;

import java.util.Collection;

import com.comparadorad.bet.comparer.model.autosender.bean.User;

/**
 * The Interface IUserService.
 */
public interface IUserService extends IModelService<User, Integer> {

	/**
	 * Find by liferay id.
	 * 
	 * @param pId
	 *            the id
	 * @return the user
	 */
	User findByLiferayId(Integer pId);

	/**
	 * Find active users.
	 * 
	 * @return the collection
	 */
	Collection<User> findActiveUsers();

	/**
	 * Delete by liferay id.
	 * 
	 * @param liferayId
	 *            the liferay id
	 */
	void deleteByLiferayId(Integer liferayId);
}
