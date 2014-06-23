/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.autosender.core.config.AutosenderCoreConfig;
import com.comparadorad.bet.comparer.autosender.getresponse.config.AutosenderGetResponseConfig;
import com.comparadorad.bet.comparer.autosender.getresponse.config.AutosenderGetResponseConfigTest;
import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.consumer.config.ConsumerConfig;
import com.comparadorad.bet.comparer.communication.consumer.config.ConsumerConfigTest;
import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;
import com.comparadorad.bet.comparer.model.autosender.service.config.AutoSenderServiceConfig;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetMathematicalExpectation;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class EmailConfigTest.
 */
@Configuration
@Import({ AutosenderGetResponseConfig.class, AutoSenderServiceConfig.class,
	AutosenderCoreConfig.class, AutosenderGetResponseConfigTest.class, SecureBetServiceConfig.class,ConsumerConfigTest.class })
@Profile(value = { ProfileConstant.TEST })
public class EmailConfigTest extends AbstractEmailConfig {
	
	
	/**
	 * Consumer queue.
	 *
	 * @return the i consumer queue
	 */
	@Bean
	public IConsumerQueue iConsumerQueue(){
		IConsumerQueue mock =  (IConsumerQueue) mock(IConsumerQueue.class);
		List<ValueBetData> betDatas = new ArrayList<ValueBetData>();
		ValueBetData betData = new ValueBetData();
		ValueBetProbability betProbability = new ValueBetProbability();
		ValueBetMathematicalExpectation betMathematicalExpectation = new ValueBetMathematicalExpectation();
		RtBet bet = new RtBet();
		RtBetOdd rtBetOdd = new RtBetOdd();
		CfgBookmaker bookmaker = new CfgBookmaker();
		CfgBetType betType = new CfgBetType();
		InfoMatch infoMatch = new InfoMatch();
		I18n i18n = new I18n();
		RtGanadorAttribute ganadorAttribute = new RtGanadorAttribute();
		
		rtBetOdd.setOdds("3");
		bookmaker.setNameId("Bookmaker");
		betType.setNameId("BetType");
		bet.setBookmaker(bookmaker);
		bet.setBetOdd(rtBetOdd);
		bet.setBetType(betType);
		bet.setAttribute(ganadorAttribute);
		
//		betProbability.setValue(1f);
//		betMathematicalExpectation.setValue(2f);
		
		i18n.setNameId("Test event");
		infoMatch.setName(i18n);
		
		
		betData.setExpectation(betMathematicalExpectation);
		betData.setProbability(betProbability);
		betData.setBet(bet);
		betData.setInfoMatch(infoMatch);
		
		betDatas.add(betData);
		
		ValueBetQueue valueBetTo = new ValueBetQueue(betDatas);
		when(mock.receive()).thenReturn(valueBetTo);
		return mock;
	}

}
