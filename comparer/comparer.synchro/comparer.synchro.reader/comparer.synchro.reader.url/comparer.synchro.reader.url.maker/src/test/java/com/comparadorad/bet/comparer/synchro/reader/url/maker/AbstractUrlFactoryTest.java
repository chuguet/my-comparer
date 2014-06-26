/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.synchro.reader.url.maker.config.UrlFactoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractUrlFactoryTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.PRODUCTION)
@ContextConfiguration(classes = { UrlFactoryConfig.class })
public abstract class AbstractUrlFactoryTest {

}
