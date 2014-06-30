package com.comparadorad.bet.comparer.test.bean.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


@Configuration
@Profile(value = { ProfileConstant.TEST })
public class TestBeanConfig extends AbstractBeanTestConfig {

}
