package com.comparadorad.bet.comparer.synchro.betclean.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.integration.consumer.config.IntegrationConsumerConfiguration;
import com.comparadorad.bet.comparer.model.activator.config.ActivatorServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import({ IntegrationConsumerConfiguration.class,
		ActivatorServiceConfigTest.class })
@Profile(value = { ProfileConstant.TEST })
public class BetCleanTaskConfigurationTest extends
		AbstractBetCleanTaskConfiguration {

}
