/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.payment.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;

import com.comparadorad.bet.comparer.model.autosender.service.config.AutoSenderServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class WebServerMvcMatchConfig.
 */
@Configuration
@EnableAsync
@ComponentScan({ "com.comparadorad.bet.comparer.web.server.mvc.payment" })
@Import(value = {AutoSenderServiceConfig.class})
@Profile(value = { ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class WebServerMvcPaymentConfig extends AbstractPaymentConfig{

	@Bean
	public PayPalAPIInterfaceServiceService payPalAPIInterfaceServiceService(){
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", getMode());
		sdkConfig.put("acct1.UserName", getUsername());
		sdkConfig.put("acct1.Password", getPassword());
		sdkConfig.put("acct1.Signature",getSignature());

		return new PayPalAPIInterfaceServiceService(sdkConfig);
	}






}