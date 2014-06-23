package com.comparadorad.bet.comparer.model.autosender.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.autosender.config.AutoSenderBeanConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import(AutoSenderBeanConfigTest.class)
@Profile(value = { ProfileConstant.TEST })
public class AutoSenderRepositoryConfigTest extends
		AbstractAutoSenderRepositoryConfig {
}
