/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.comparadorad.bet.comparer.model.core.service.config.ServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractServiceTest.
 * 
 * @param <T>
 *            the generic type
 */

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(classes = ServiceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractServiceTest<T> {
	/**
	 * Gets the dao.
	 * 
	 * @return the dao
	 */
	protected abstract IGenericCrudService<T> getIGenericService();

}
