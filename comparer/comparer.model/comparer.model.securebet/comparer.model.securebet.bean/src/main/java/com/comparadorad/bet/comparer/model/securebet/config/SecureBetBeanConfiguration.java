package com.comparadorad.bet.comparer.model.securebet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;

@Configuration
@Import({ BetServiceConfig.class, ConfigRepositoryConfig.class })
public class SecureBetBeanConfiguration {

}
