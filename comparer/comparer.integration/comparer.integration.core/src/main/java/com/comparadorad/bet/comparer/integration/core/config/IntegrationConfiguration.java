/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.core.config;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.comparadorad.bet.comparer.integration.core.beans.DataIntegrationConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class IntegrationConfiguration.
 */
@Configuration
@PropertySource("classpath:/DataIntegrationConfiguration.properties")
@ComponentScan("com.comparadorad.bet.comparer.integration.core")
@Import(SpringSynchroLogConfig.class)
@ImportResource(value = { "classpath*:/application-context.xml" })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class IntegrationConfiguration {

	/** The data configuration. */
	@Inject
	private DataIntegrationConfiguration dataIntegrationConfiguration;

	/**
	 * Connection factory.
	 * 
	 * @return the connection factory
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
				dataIntegrationConfiguration.getHostRabbit());
		connectionFactory.setUsername(dataIntegrationConfiguration
				.getUserRabbit());
		connectionFactory.setPassword(dataIntegrationConfiguration
				.getPassRabbit());
		return connectionFactory;
	}

	/**
	 * Amqp admin.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the amqp admin
	 */
	@Inject
	@Bean
	public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	/**
	 * Updater bets amqp template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the amqp template
	 */
	@Inject
	@Bean(name = "updaterBetsAmqpTemplate")
	public AmqpTemplate updaterBetsAmqpTemplate(
			ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(dataIntegrationConfiguration
				.getUpdaterBetsQueueRabbit());
		template.setQueue(dataIntegrationConfiguration
				.getUpdaterBetsQueueRabbit());
		return template;
	}

	/**
	 * Updater bets queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue updaterBetsQueue() {
		return new Queue(
				dataIntegrationConfiguration.getUpdaterBetsQueueRabbit());
	}

	/**
	 * Task executor.
	 * 
	 * @return the executor
	 */
	@Bean(name = "springIntegrationTaskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(dataIntegrationConfiguration.getCorePoolSize());
		executor.setMaxPoolSize(dataIntegrationConfiguration.getMaxPoolSize());
		executor.setQueueCapacity(dataIntegrationConfiguration
				.getQueueCapacity());
		executor.setThreadNamePrefix(dataIntegrationConfiguration
				.getThreadNamePrefix());
		executor.initialize();
		return executor;
	}

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
