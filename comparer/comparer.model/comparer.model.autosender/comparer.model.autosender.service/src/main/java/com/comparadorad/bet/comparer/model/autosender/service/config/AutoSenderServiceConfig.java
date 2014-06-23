package com.comparadorad.bet.comparer.model.autosender.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.autosender.repository.config.AutoSenderRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import(AutoSenderRepositoryConfig.class)
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
public class AutoSenderServiceConfig extends AbstractAutoSenderServiceConfig {
	
}
