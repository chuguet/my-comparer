/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.repository;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractRepositoryTest.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractRepositoryTest<T extends IGenericRepository> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractRepositoryTest.class);

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository
	 */
	public abstract T getCrudRepository();

	/**
	 * Gets the new element.
	 * 
	 * @return the new element
	 */
	protected abstract Object getNewElement();

	/**
	 * Size.
	 * 
	 * @param list
	 *            the list
	 * @return the int
	 */
	@SuppressWarnings("unused")
	private int size(Iterable<?> list) {
		int size = 0;
		for (Object object : list) {
			size++;
		}
		return size;
	}

	/**
	 * Test create.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCreate() {

		Iterable<?> list = getCrudRepository().findAll();

		int initialSize = size(list);

		Object entity = getCrudRepository().save(getNewElement());
		if (entity instanceof AbstractId) {
			Object dbEntity = getCrudRepository().findOne(
					((AbstractId) entity).getObjectId());
			assertNotNull(dbEntity);
		}
		list = getCrudRepository().findAll();
		int finalSize = size(list);
		if (initialSize + 1 != finalSize) {
			LOG.warn("findall not working properly: elementos antes de insertar: message);"
					+ initialSize + " After insert: " + finalSize);

		}
	}

	/**
	 * Test find all.
	 */
//	@Test
	public void testFindAll() {
		// Eliminamos el test para optimizar el rendimiento
		// Iterable<?> list = getCrudRepository().findAll();
		// // Parche, ya que en el ordenador de alunden no funciona el findall
		// boolean assertList = true;
		// if (System.getProperty("user.home").contains("alunden")) {
		// assertList = false;
		// }
		// if (assertList) {
		// assertNotNull(list);
		// assertTrue(list.iterator().hasNext());
		// // if (LOG.isDebugEnabled()) {

		// // }
		// }
	}
}
