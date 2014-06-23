/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.activator.config.ActivatorServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ActivatorMatchTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ActivatorServiceConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class ActivatorMatchTest {

}
