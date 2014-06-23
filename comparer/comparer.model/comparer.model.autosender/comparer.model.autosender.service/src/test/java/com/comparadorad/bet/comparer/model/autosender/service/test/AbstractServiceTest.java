/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.model.autosender.bean.IAutoSender;
import com.comparadorad.bet.comparer.model.autosender.service.IModelService;
import com.comparadorad.bet.comparer.model.autosender.service.config.AutoSenderServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractServiceTest.
 * 
 * @param <I>
 *            the generic type
 * @param <T>
 *            the generic type
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoSenderServiceConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
@Transactional
public abstract class AbstractServiceTest<I extends IAutoSender, T extends IModelService<I, Integer>> {

	/**
	 * Gets the service.
	 * 
	 * @return the service
	 */
	public abstract T getService();

	/**
	 * Gets the object.
	 * 
	 * @return the object
	 */
	public abstract I getObject();

	/**
	 * Creates the test.
	 */
	@Test
	public final void createTest() {
		getService().save(getObject());
	}

	/**
	 * Delete test.
	 */
	@Test
	public final void deleteTest() {
		getService().save(getObject());
		getService().delete(getObject());
	}

	/**
	 * Find one test.
	 */
	@Test
	public final void findOneTest() {
		Integer id = getService().save(getObject());
		assertNotNull(getService().findOne(id));
	}

	/**
	 * Find all test.
	 */
	@Test
	public final void findAllTest() {
		getService().save(getObject());
		assertNotNull(getService().findAll());
	}
}
