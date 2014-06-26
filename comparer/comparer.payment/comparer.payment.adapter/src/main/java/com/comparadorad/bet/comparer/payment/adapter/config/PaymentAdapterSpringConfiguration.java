package com.comparadorad.bet.comparer.payment.adapter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.autosender.service.config.AbstractAutoSenderServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@ComponentScan("com.comparadorad.bet.comparer.payment.adapter")
@Import(AbstractAutoSenderServiceConfig.class)
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class PaymentAdapterSpringConfiguration {

}
