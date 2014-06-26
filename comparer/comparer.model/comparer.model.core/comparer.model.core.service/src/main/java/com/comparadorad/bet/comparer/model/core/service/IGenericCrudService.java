/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.service;

/*
 * Copyright 2008-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.math.BigInteger;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 * 
 * @param <T>
 *            the generic type
 * @author Oliver Gierke
 * @author Eberhard Wolff
 */
public interface IGenericCrudService<T> {

	/**
	 * Saves a given entity. Use the returned instance for further operations as
	 * the save operation might have changed the entity instance completely.
	 * 
	 * @param entity
	 *            the entity
	 * @return the saved entity
	 */
	T save(T entity);

	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 *            the entities
	 * @return the saved entities
	 */
	Iterable<T> save(Iterable<T> entities);

	/**
	 * Retrives an entity by its id.
	 * 
	 * @param objectId
	 *            must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 */
	T findOne(BigInteger objectId);

	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param objectId
	 *            must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 */
	boolean exists(BigInteger objectId);

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	Iterable<T> findAll();

	/**
	 * Returns the number of entities available.
	 * 
	 * @return the number of entities
	 */
	long count();

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param objectId
	 *            must not be {@literal null}.
	 */
	void delete(BigInteger objectId);

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 *            the entity
	 */
	void delete(T entity);

	/**
	 * Deletes the given entities.
	 * 
	 * @param entities
	 *            the entities
	 */
	void delete(Iterable<? extends T> entities);

	/**
	 * Deletes all entities managed by the repository.
	 */
	void deleteAll();
}
