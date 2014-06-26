package com.comparadorad.bet.comparer.synchro.reader.urlparameter.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
@ContextConfiguration(classes = { UrlParameterConfig.class })
public abstract class AbstractUrlParameterTest {

}
