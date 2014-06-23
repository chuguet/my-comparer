/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.repository.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.model.autosender.bean.IAutoSender;
import com.comparadorad.bet.comparer.model.autosender.repository.IRepositoryDAO;
import com.comparadorad.bet.comparer.model.autosender.repository.config.AutoSenderRepositoryConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractDaoTest.
 * 
 * @param <I>
 *            the generic type
 * @param <T>
 *            the generic type
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoSenderRepositoryConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
@Transactional
public abstract class AbstractDaoTest<I extends IAutoSender, T extends IRepositoryDAO<I, Integer>> {

	/**
	 * Gets the object.
	 * 
	 * @return the object
	 */
	public abstract I getObject();

	/**
	 * Gets the dao.
	 * 
	 * @return the dao
	 */
	public abstract T getDao();

	/**
	 * Creates the test.
	 */
	@Test
	public final void createTest() {
		getDao().save(getObject());
	}

	/**
	 * Delete test.
	 */
	@Test
	public final void deleteTest() {
		getDao().save(getObject());
		getDao().delete(getObject());
	}

	/**
	 * Find one test.
	 */
	@Test
	public final void findOneTest() {
		Integer id = getDao().save(getObject());
		assertNotNull(getDao().findOne(id));
	}

	/**
	 * Find all test.
	 */
	@Test
	public final void findAllTest() {
		getDao().save(getObject());
		assertNotNull(getDao().findAll());
	}
}
