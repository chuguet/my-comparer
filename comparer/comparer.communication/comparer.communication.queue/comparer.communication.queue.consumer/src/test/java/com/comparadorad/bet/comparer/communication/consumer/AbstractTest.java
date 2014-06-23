/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.communication.consumer.config.ConsumerConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConsumerConfig.class })
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

}
