package com.comparadorad.bet.comparer.model.bet.cache.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import(BetServiceConfig.class)
@ComponentScan("com.comparadorad.bet.comparer.model.bet.cache")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class BetCacheConfig {

}
