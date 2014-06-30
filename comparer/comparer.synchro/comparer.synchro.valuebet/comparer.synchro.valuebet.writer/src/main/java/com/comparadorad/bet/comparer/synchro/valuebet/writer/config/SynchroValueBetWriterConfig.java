package com.comparadorad.bet.comparer.synchro.valuebet.writer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.valuebet.config.ValueBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.valuebet.writer" })
@Import(value = { BetServiceConfig.class, ValueBetServiceConfig.class })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class SynchroValueBetWriterConfig {

}
