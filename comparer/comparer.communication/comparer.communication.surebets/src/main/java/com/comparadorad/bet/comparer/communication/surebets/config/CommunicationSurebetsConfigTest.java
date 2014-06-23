package com.comparadorad.bet.comparer.communication.surebets.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.communication.producer.config.ProducerConfigTest;
import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import({ProducerConfigTest.class, SecureBetServiceConfig.class})
@Profile({ProfileConstant.TEST})
public class CommunicationSurebetsConfigTest extends AbstractCommunicationSurebetsConfig {

}
