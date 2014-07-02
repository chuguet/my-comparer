/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class WebServerUtilCoreConfigTest.
 */
@Configuration
@PropertySource({ "classpath:/core.properties" })
@ComponentScan({ "com.comparadorad.bet.comparer.web.server.util" })
@Profile(value = { ProfileConstant.TEST })
public class WebServerUtilCoreConfigTest {

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