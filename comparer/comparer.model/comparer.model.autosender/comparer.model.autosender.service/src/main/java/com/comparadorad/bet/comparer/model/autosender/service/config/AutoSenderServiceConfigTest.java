package com.comparadorad.bet.comparer.model.autosender.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.autosender.repository.config.AutoSenderRepositoryConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import(AutoSenderRepositoryConfigTest.class)
@Profile(value = { ProfileConstant.TEST })
public class AutoSenderServiceConfigTest extends AbstractAutoSenderServiceConfig {

}
