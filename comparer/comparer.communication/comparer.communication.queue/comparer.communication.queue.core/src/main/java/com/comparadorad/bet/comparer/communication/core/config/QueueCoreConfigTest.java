/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.config;

import static org.mockito.Mockito.mock;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class QueueCoreConfigTest.
 */
@Configuration
@PropertySource({ "classpath:/configurationAMQPTest.properties" })
@Profile(value = { ProfileConstant.TEST })
public class QueueCoreConfigTest {

	/**
	 * Gets the first surebet template.
	 * 
	 * @return the first surebet template
	 */
	@Bean(name = "firstSurebetTemplate")
	public AmqpTemplate getFirstSurebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		return result;
	}

	/**
	 * Gets the fourth surebet template.
	 * 
	 * @return the fourth surebet template
	 */
	@Bean(name = "fourthSurebetTemplate")
	public AmqpTemplate getFourthSurebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		return result;
	}

	/**
	 * Gets the second surebet template.
	 * 
	 * @return the second surebet template
	 */
	@Bean(name = "secondSurebetTemplate")
	public AmqpTemplate getSecondSurebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		return result;
	}

	/**
	 * Gets the third surebet template.
	 * 
	 * @return the third surebet template
	 */
	@Bean(name = "thirdSurebetTemplate")
	public AmqpTemplate getThirdSurebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		return result;
	}

	/**
	 * Gets the updater bets template.
	 * 
	 * @return the updater bets template
	 */
	@Bean(name = "updaterBetsTemplate")
	public AmqpTemplate getUpdaterBetsTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		return result;
	}

	/**
	 * Rabbit template.
	 * 
	 * @return the amqp template
	 */
	@Bean(name = "valuebetTemplate")
	public AmqpTemplate getValuebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		return result;
	}

	/**
	 * Simple message listener container.
	 * 
	 * @return the simple message listener container
	 */
	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer() {
		ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
		MessageListenerAdapter messageListenerAdapter = mock(MessageListenerAdapter.class);
		SimpleMessageListenerContainer result = new SimpleMessageListenerContainer(
				connectionFactory);
		result.setMessageListener(messageListenerAdapter);
		result.setAutoStartup(false);
		result.afterPropertiesSet();
		result.setQueueNames("updaterBetsQueue");
		return result;
	}

}
