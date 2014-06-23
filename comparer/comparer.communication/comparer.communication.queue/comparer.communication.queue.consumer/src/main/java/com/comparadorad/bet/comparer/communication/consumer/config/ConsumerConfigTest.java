/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;
import com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.thoughtworks.xstream.XStream;

/**
 * The Class ConsumerConfigTest.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST })
public class ConsumerConfigTest extends AbstractConsumerConfig {

	/** The x stream. */
	private XStream xStream;

	/**
	 * Instantiates a new consumer config test.
	 */
	public ConsumerConfigTest() {
		xStream = new XStream();
	}

	/**
	 * Rabbit template.
	 * 
	 * @return the amqp template
	 */
	@Bean(name = "valuebetTemplate")
	public AmqpTemplate getValuebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		List<ValueBetData> betDatas = new ArrayList<ValueBetData>();
		ValueBetData betData = new ValueBetData();
		betDatas.add(betData);
		ValueBetQueue betQueue = new ValueBetQueue(betDatas);
		when(result.receiveAndConvert()).thenReturn(xStream.toXML(betQueue));
		return result;
	}

	/**
	 * Gets the first surebet template.
	 * 
	 * @return the first surebet template
	 */
	@Bean(name = "firstSurebetTemplate")
	public AmqpTemplate getFirstSurebetTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		SecureBeanData secureBeanData = new SecureBeanData();
		SureBetQueue sureBetQueue = new SureBetQueue(secureBeanData, new Date());
		when(result.receiveAndConvert())
				.thenReturn(xStream.toXML(sureBetQueue));
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
		SecureBeanData secureBeanData = new SecureBeanData();
		SureBetQueue sureBetQueue = new SureBetQueue(secureBeanData, new Date());
		when(result.receiveAndConvert())
				.thenReturn(xStream.toXML(sureBetQueue));
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
		SecureBeanData secureBeanData = new SecureBeanData();
		SureBetQueue sureBetQueue = new SureBetQueue(secureBeanData, new Date());
		when(result.receiveAndConvert())
				.thenReturn(xStream.toXML(sureBetQueue));
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
		SecureBeanData secureBeanData = new SecureBeanData();
		SureBetQueue sureBetQueue = new SureBetQueue(secureBeanData, new Date());
		when(result.receiveAndConvert())
				.thenReturn(xStream.toXML(sureBetQueue));
		return result;
	}

	/**
	 * Gets the updater bets template.
	 * 
	 * @return the updater bets template
	 */
	@Bean(name = "updaterBetsTemplate")
	public AmqpTemplate getupdaterBetsTemplate() {
		AmqpTemplate result = mock(AmqpTemplate.class);
		UpdaterBetsTO updaterBetsTO = new UpdaterBetsTO("asas",
				BigInteger.ZERO, Arrays.asList("asdasd", "dadasd"));
		when(result.receiveAndConvert()).thenReturn(
				xStream.toXML(updaterBetsTO));
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
