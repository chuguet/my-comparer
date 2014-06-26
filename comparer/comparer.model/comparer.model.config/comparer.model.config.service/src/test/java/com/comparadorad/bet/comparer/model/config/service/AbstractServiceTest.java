/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractServiceTest.
 * 
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigServiceConfig.class, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractServiceTest<T> {
	private static final Log LOG = LogFactory.getLog(AbstractServiceTest.class);

	/**
	 * Gets the dao.
	 * 
	 * @return the dao
	 */
	protected abstract IGenericCrudService<T> getIGenericService();

	/**
	 * Test find all.
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testFindAll() {
		System.out.println("findAll");
		Iterable<T> iterable = getIGenericService().findAll();
		if (iterable instanceof Collection) {
			LOG.debug("Number of elements:" + ((Collection) iterable).size());
		}
	}
}
