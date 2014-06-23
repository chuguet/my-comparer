package com.comparadorad.bet.comparer.autosender.getresponse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@ComponentScan("com.comparadorad.bet.comparer.autosender.getresponse")
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PRODUCTION,
		ProfileConstant.PREPRODUCTION })
public class AutosenderGetResponseConfig extends
		AbstractAutosenderGetResponseConfig {

}
