/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo;

/**
 * The Class AbstractBetRepositoryTest.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BetRepositoryConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractBetRepositoryTest<T extends IGenericRepository>
		extends AbstractTestMongo {

}
