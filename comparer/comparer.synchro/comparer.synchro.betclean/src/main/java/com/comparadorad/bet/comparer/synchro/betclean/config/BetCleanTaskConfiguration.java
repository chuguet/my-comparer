/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.config;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.comparadorad.bet.comparer.integration.consumer.config.IntegrationConsumerConfiguration;
import com.comparadorad.bet.comparer.model.activator.config.ActivatorServiceConfig;
import com.comparadorad.bet.comparer.synchro.betclean.data.DataConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetCleanTaskConfiguration.
 */
@Configuration
@EnableScheduling
@EnableAsync
@Import({ IntegrationConsumerConfiguration.class, ActivatorServiceConfig.class })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
public class BetCleanTaskConfiguration extends
		AbstractBetCleanTaskConfiguration {

	/** The data configuration. */
	@Inject
	private DataConfiguration dataConfiguration;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncExecutor
	 * ()
	 */
	/**
	 * Draft task executor.
	 * 
	 * @return the executor
	 */
	@Bean(name = "draftTaskExecutor")
	public Executor draftTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(dataConfiguration.getDraftCorePoolSize());
		executor.setMaxPoolSize(dataConfiguration.getDraftMaxPoolSize());
		executor.setQueueCapacity(dataConfiguration.getDraftQueueCapacity());
		executor.setThreadNamePrefix(dataConfiguration
				.getDraftThreadNamePrefix());
		executor.initialize();
		return executor;
	}

	/**
	 * Update task executor.
	 * 
	 * @return the executor
	 */
	@Bean(name = "updateTaskExecutor")
	public Executor updateTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(dataConfiguration.getUpdateCorePoolSize());
		executor.setMaxPoolSize(dataConfiguration.getUpdateMaxPoolSize());
		executor.setQueueCapacity(dataConfiguration.getUpdateQueueCapacity());
		executor.setThreadNamePrefix(dataConfiguration
				.getUpdateThreadNamePrefix());
		executor.initialize();
		return executor;
	}

}
