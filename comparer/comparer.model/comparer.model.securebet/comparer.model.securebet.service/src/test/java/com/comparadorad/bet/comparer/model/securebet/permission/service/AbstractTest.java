package com.comparadorad.bet.comparer.model.securebet.permission.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SecureBetServiceConfig.class, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

}
