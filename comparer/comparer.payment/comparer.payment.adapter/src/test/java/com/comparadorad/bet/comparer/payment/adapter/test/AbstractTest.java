package com.comparadorad.bet.comparer.payment.adapter.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.payment.adapter.config.PaymentAdapterSpringConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PaymentAdapterSpringConfiguration.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

}
