/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.config;

import javax.inject.Inject;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class QueueCoreConfig.
 */
@Configuration
@PropertySource({ "classpath:/configurationAMQP.properties" })
@Profile(value = { ProfileConstant.PRODUCTION, ProfileConstant.PREPRODUCTION,
		ProfileConstant.DEV })
public class QueueCoreConfig extends AbstractQueueCoreConfig {

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
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
	 * Connection factory.
	 * 
	 * @return the connection factory
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
				getHost());
		connectionFactory.setUsername(getUser());
		connectionFactory.setPassword(getPassword());
		return connectionFactory;
	}

	/**
	 * Gets the valuebet template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the valuebet template
	 */
	@Inject
	@Bean(name = "valuebetTemplate")
	public AmqpTemplate getValuebetTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(getValuebetQueue());
		template.setQueue(getValuebetQueue());
		return template;
	}

	/**
	 * Valuebet queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue valuebetQueue() {
		return new Queue(getValuebetQueue());
	}

	/**
	 * Gets the updater bets template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the updater bets template
	 */
	@Inject
	@Bean(name = "updaterBetsTemplate")
	public AmqpTemplate getUpdaterBetsTemplate(
			ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(getUpdaterBetsQueue());
		template.setQueue(getUpdaterBetsQueue());
		return template;
	}

	/**
	 * Updater bets queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue updaterBetsQueue() {
		return new Queue(getUpdaterBetsQueue());
	}

	/**
	 * Message listener container.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the simple message listener container
	 */
//	@Inject
//	@Bean
//	public SimpleMessageListenerContainer messageListenerContainer(
//			ConnectionFactory connectionFactory) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(
//				connectionFactory);
//		return container;
//	}

	/**
	 * Gets the first surebet template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the first surebet template
	 */
	@Inject
	@Bean(name = "firstSurebetTemplate")
	public AmqpTemplate getFirstSurebetTemplate(
			ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(getFirstSurebestQueue());
		template.setQueue(getFirstSurebestQueue());
		return template;
	}

	/**
	 * First surebet queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue firstSurebetQueue() {
		return new Queue(getFirstSurebestQueue());
	}

	/**
	 * Gets the second surebet template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the second surebet template
	 */
	@Inject
	@Bean(name = "secondSurebetTemplate")
	public AmqpTemplate getSecondSurebetTemplate(
			ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(getSecondSurebetsQueue());
		template.setQueue(getSecondSurebetsQueue());
		return template;
	}

	/**
	 * Second surebet queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue secondSurebetQueue() {
		return new Queue(getSecondSurebetsQueue());
	}

	/**
	 * Gets the third surebets template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the third surebets template
	 */
	@Inject
	@Bean(name = "thirdSurebetTemplate")
	public AmqpTemplate getThirdSurebetsTemplate(
			ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(getThirdSurebetsQueue());
		template.setQueue(getThirdSurebetsQueue());
		return template;
	}

	/**
	 * Third surebett queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue thirdSurebettQueue() {
		return new Queue(getThirdSurebetsQueue());
	}

	/**
	 * Gets the fourth surebet template.
	 * 
	 * @param connectionFactory
	 *            the connection factory
	 * @return the fourth surebet template
	 */
	@Inject
	@Bean(name = "fourthSurebetTemplate")
	public AmqpTemplate getFourthSurebetTemplate(
			ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(getFourthSurebetsQueue());
		template.setQueue(getFourthSurebetsQueue());
		return template;
	}

	/**
	 * Fourth surebett queue.
	 * 
	 * @return the queue
	 */
	@Bean
	public Queue fourthSurebettQueue() {
		return new Queue(getFourthSurebetsQueue());
	}

}
