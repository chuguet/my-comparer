/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * Spring MongoDB configuration file.
 */
@Configuration
@PropertySource("classpath:/database.prod.properties")
@Profile(value = { ProfileConstant.PRODUCTION })
public class SpringMongoProdConfig extends AbstractSpringMongoConfig {
	
	@Override
	public String getNamePropertyFile() {
		return "database.prod.properties";
	}

	@Override
	public String getPathPropertyFile() {
		return "file:D:/";
	}
}