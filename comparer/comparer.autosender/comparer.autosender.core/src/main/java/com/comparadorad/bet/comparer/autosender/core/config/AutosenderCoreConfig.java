package com.comparadorad.bet.comparer.autosender.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.autosender.core" })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class AutosenderCoreConfig {

}
